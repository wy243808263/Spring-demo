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
	 * ����ע�룬Ϊbean���������ע��ֵ
	 * ���ﻹ��������ԭ����һ���ģ���ƪ�����ع���װ������ע��
	 */
	private void injectObject() {
		Service service = (Service) this.sigletons.get("service");
		Dao dao = (Dao) this.sigletons.get("dao");
		//����ע�룬Serviceʵ������dao��ʵ��
		service.setDao(dao);
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
				Element bean = (Element) listBean.get(i);
				// ��ȡid����ֵ
				String id = bean.getAttributeValue("id");
				// ��ȡclass����ֵ
				String clazz = bean.getAttributeValue("class");
				
				BeanDefinition beanDefine = new BeanDefinition(id,clazz);
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
