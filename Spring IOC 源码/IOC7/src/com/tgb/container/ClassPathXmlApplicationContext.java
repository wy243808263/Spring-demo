package com.tgb.container;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/**
 * 容器
 * 
 * @author liang
 * 
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

	// 用于存放Bean
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	// 用于存放Bean的实例
	private Map<String, Object> sigletons =new HashMap<String, Object>();
	
	
	public ClassPathXmlApplicationContext(String fileName) {

		this.readXML(fileName);
		
		this.instanceBeans();
		
		this.injectObject();
	}
	/**
	 * 为bean对象的属性注入值
	 */
	private void injectObject() {
		for (BeanDefinition beanDefinition :beanDefines) {
			Object bean = sigletons.get(beanDefinition.getId());
			if(bean != null){
				try {
					// 通过Introspector取得bean的定义信息，之后再取得属性的描述信息，返回一个数组
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					
					for(PropertyDefinition propertyDefinition:beanDefinition.getPropertys()){
						for(PropertyDescriptor properdesc: ps){
							if(propertyDefinition.getName().equals(properdesc.getName())){
								// 获取属性的setter方法,private
								Method setter = properdesc.getWriteMethod(); 
								if(setter != null){
									Object value = sigletons.get(propertyDefinition.getRef());
									// 允许访问私有方法
									setter.setAccessible(true); 
									// 把引用对象注入到属性
									setter.invoke(bean, value); 
								}
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 完成bean的实例化
	 */
	private void instanceBeans() {
		for(BeanDefinition beanDefinition : beanDefines){
			try {
				if(beanDefinition.getClassName() != null && !"".equals(beanDefinition.getClassName().trim())){
					sigletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance() );
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取xml配置文件
	 */
	private void readXML(String fileName) {
		// 创建SAXBuilder对象
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			// 读取资源，获得document对象
			Document doc = saxBuilder.build(this.getClass().getClassLoader()
					.getResourceAsStream(fileName));
			// 获取根元素
			Element rootEle = doc.getRootElement();
			// 从根元素获得所有的子元素，建立元素集合
			List listBean = XPath.selectNodes(rootEle, "/beans/bean");

			// 遍历根元素的子元素集合，扫描配置文件中的bean
			for (int i = 0; i < listBean.size(); i++) {
				 // 将根元素beans下的bean子元素作为一个新的子根元素
				Element elementBean = (Element) listBean.get(i);
				//获取id属性值
				String id = elementBean.getAttributeValue("id");
				//获取class属性值
				String clazz = elementBean.getAttributeValue("class");
				
				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
				// 获取子根元素bean下的所有property子元素
				List listProperty = elementBean.getChildren("property");
				// 遍历子根元素的子元素集合(即遍历property元素)
				for (int j = 0; j < listProperty.size(); j++) {
					// 获取property元素
					Element elmentProperty = (Element)listProperty.get(j);
					// 获取name属性值
					String propertyName = elmentProperty.getAttributeValue("name");
					// 获取ref属性值
					String propertyref = elmentProperty.getAttributeValue("ref");
					
					PropertyDefinition propertyDefinition = new PropertyDefinition(propertyName,propertyref);
					
					beanDefine.getPropertys().add(propertyDefinition);
				}
				
				// 将javabean添加到集合中
				beanDefines.add(beanDefine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取bean实例
	 */
	@Override
	public Object getBean(String beanName) {
		return this.sigletons.get(beanName);
	}
}
