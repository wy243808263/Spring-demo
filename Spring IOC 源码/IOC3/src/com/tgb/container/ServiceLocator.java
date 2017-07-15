package com.tgb.container;

public class ServiceLocator {
	
	static{
		//该类加载的时候执行一次
		Container.init();
	}
	public static Object getDao(){
		return Container.getComponent("dao4Mysql");
//		return Container.getComponent("dao4Oracle");
	}
}
