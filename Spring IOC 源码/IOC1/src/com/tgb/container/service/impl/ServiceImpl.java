package com.tgb.container.service.impl;

import com.tgb.container.dao.Dao;
import com.tgb.container.dao.impl.Dao4MySqlImpl;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	//实例化Dao实现
	private Dao dao = new Dao4MySqlImpl();  

	@Override
	public void serviceMethod() {
		//调用Dao实现的方法
		dao.daoMethod();
	}
}
