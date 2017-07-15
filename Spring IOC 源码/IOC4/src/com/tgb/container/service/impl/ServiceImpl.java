package com.tgb.container.service.impl;

import com.tgb.container.dao.Dao;
import com.tgb.container.service.Service;

public class ServiceImpl implements Service {
	private Dao dao;  
	//“¿¿µ◊¢»Î
	public void setDao(Dao dao) {
		this.dao= dao;
	}
	
	@Override
	public void serviceMethod() {
		dao.daoMethod();
	}
}
