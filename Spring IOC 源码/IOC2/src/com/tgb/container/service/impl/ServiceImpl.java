package com.tgb.container.service.impl;

import com.tgb.container.Container;
import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	//������������Ӧ�Ķ���
	private Dao dao = (Dao) Container.getComponent("dao4Mysql");  

	@Override
	public void serviceMethod() {
		dao.daoMethod();
	}
}
