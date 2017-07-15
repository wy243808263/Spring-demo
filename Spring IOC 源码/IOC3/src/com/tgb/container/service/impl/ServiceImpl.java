package com.tgb.container.service.impl;

import com.tgb.container.ServiceLocator;
import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	// 从服务器定位器查找所需的接口
	private Dao dao = (Dao) ServiceLocator.getDao();;  
	
	@Override
	public void serviceMethod() {
		dao.daoMethod();
	}

}
