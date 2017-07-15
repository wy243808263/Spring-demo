package com.tgb.container.service;

import com.tgb.container.dao.Dao;


public interface Service {
	//增加注入接口的方法
	public void setDao(Dao dao);
	public void serviceMethod();
}
