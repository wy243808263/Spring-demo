package com.tgb.container;

public class ServiceLocator {
	
	static{
		//������ص�ʱ��ִ��һ��
		Container.init();
	}
	public static Object getDao(){
		return Container.getComponent("dao4Mysql");
//		return Container.getComponent("dao4Oracle");
	}
}
