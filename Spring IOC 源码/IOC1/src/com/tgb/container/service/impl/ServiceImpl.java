package com.tgb.container.service.impl;

import com.tgb.container.dao.Dao;
import com.tgb.container.dao.impl.Dao4MySqlImpl;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	//ʵ����Daoʵ��
	private Dao dao = new Dao4MySqlImpl();  

	@Override
	public void serviceMethod() {
		//����Daoʵ�ֵķ���
		dao.daoMethod();
	}
}
