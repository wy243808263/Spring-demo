package com.tgb.container.service.impl;

import com.tgb.container.ServiceLocator;
import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	// �ӷ�������λ����������Ľӿ�
	private Dao dao = (Dao) ServiceLocator.getDao();;  
	
	@Override
	public void serviceMethod() {
		dao.daoMethod();
	}

}
