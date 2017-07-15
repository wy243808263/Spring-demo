package com.tgb.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

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
	 * 依赖注入，为bean对象的属性注入值
	 * 这里还不灵活，但是原理是一样的，下篇博文重构封装，依赖注入
	 */
	private void injectObject() {
		Service service = (Service) this.sigletons.get("service");
		Dao dao = (Dao) this.sigletons.get("dao");
		//依赖注入，Service实现依赖dao的实现
		service.setDao(dao);
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
				Element bean = (Element) listBean.get(i);
				// 获取id属性值
				String id = bean.getAttributeValue("id");
				// 获取class属性值
				String clazz = bean.getAttributeValue("class");
				
				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
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
