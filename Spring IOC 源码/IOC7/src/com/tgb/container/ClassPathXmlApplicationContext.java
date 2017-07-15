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
 * ����
 * 
 * @author liang
 * 
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

	// ���ڴ��Bean
	private List<BeanDefinition> beanDefines = new ArrayList<BeanDefinition>();
	// ���ڴ��Bean��ʵ��
	private Map<String, Object> sigletons =new HashMap<String, Object>();
	
	
	public ClassPathXmlApplicationContext(String fileName) {

		this.readXML(fileName);
		
		this.instanceBeans();
		
		this.injectObject();
	}
	/**
	 * Ϊbean���������ע��ֵ
	 */
	private void injectObject() {
		for (BeanDefinition beanDefinition :beanDefines) {
			Object bean = sigletons.get(beanDefinition.getId());
			if(bean != null){
				try {
					// ͨ��Introspectorȡ��bean�Ķ�����Ϣ��֮����ȡ�����Ե�������Ϣ������һ������
					PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
					
					for(PropertyDefinition propertyDefinition:beanDefinition.getPropertys()){
						for(PropertyDescriptor properdesc: ps){
							if(propertyDefinition.getName().equals(properdesc.getName())){
								// ��ȡ���Ե�setter����,private
								Method setter = properdesc.getWriteMethod(); 
								if(setter != null){
									Object value = sigletons.get(propertyDefinition.getRef());
									// �������˽�з���
									setter.setAccessible(true); 
									// �����ö���ע�뵽����
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
	 * ���bean��ʵ����
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
	 * ��ȡxml�����ļ�
	 */
	private void readXML(String fileName) {
		// ����SAXBuilder����
		SAXBuilder saxBuilder = new SAXBuilder();

		try {
			// ��ȡ��Դ�����document����
			Document doc = saxBuilder.build(this.getClass().getClassLoader()
					.getResourceAsStream(fileName));
			// ��ȡ��Ԫ��
			Element rootEle = doc.getRootElement();
			// �Ӹ�Ԫ�ػ�����е���Ԫ�أ�����Ԫ�ؼ���
			List listBean = XPath.selectNodes(rootEle, "/beans/bean");

			// ������Ԫ�ص���Ԫ�ؼ��ϣ�ɨ�������ļ��е�bean
			for (int i = 0; i < listBean.size(); i++) {
				 // ����Ԫ��beans�µ�bean��Ԫ����Ϊһ���µ��Ӹ�Ԫ��
				Element elementBean = (Element) listBean.get(i);
				//��ȡid����ֵ
				String id = elementBean.getAttributeValue("id");
				//��ȡclass����ֵ
				String clazz = elementBean.getAttributeValue("class");
				
				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
				// ��ȡ�Ӹ�Ԫ��bean�µ�����property��Ԫ��
				List listProperty = elementBean.getChildren("property");
				// �����Ӹ�Ԫ�ص���Ԫ�ؼ���(������propertyԪ��)
				for (int j = 0; j < listProperty.size(); j++) {
					// ��ȡpropertyԪ��
					Element elmentProperty = (Element)listProperty.get(j);
					// ��ȡname����ֵ
					String propertyName = elmentProperty.getAttributeValue("name");
					// ��ȡref����ֵ
					String propertyref = elmentProperty.getAttributeValue("ref");
					
					PropertyDefinition propertyDefinition = new PropertyDefinition(propertyName,propertyref);
					
					beanDefine.getPropertys().add(propertyDefinition);
				}
				
				// ��javabean��ӵ�������
				beanDefines.add(beanDefine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * ��ȡbeanʵ��
	 */
	@Override
	public Object getBean(String beanName) {
		return this.sigletons.get(beanName);
	}
}
