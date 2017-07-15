package com.tgb.container;

import java.util.HashMap;
import java.util.Map;

import com.tgb.container.dao.Dao;
import com.tgb.container.dao.impl.Dao4MySqlImpl;
import com.tgb.container.service.Service;
import com.tgb.container.service.impl.ServiceImpl;

public class Container {
	private static Map<String, Object> components;

	private Container() {
	}

	/**
	 * ��ʼ������
	 */
	public static synchronized void init() {
		if (components == null) {
			components = new HashMap<String, Object>();
			
			//дһ���������ļ����࣬���ݶ�ȡ�������ļ��������Ӧ����
			//����������� ������������Ӧ��������ע����Ӧ����
			
			Dao dao4Mysql = new Dao4MySqlImpl();
			components.put("dao4Mysql", dao4Mysql);
			
			Service service = new ServiceImpl();  
			components.put("service", service);
			
			//����ά��������ϵ
			service.setDao(dao4Mysql);
		}
	}

	/**
	 * �������
	 * 
	 * @param id
	 * @return
	 */
	public static Object getComponent(String id) {
		return components.get(id);
	}
}
