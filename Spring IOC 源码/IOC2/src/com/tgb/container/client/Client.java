package com.tgb.container.client;
import com.tgb.container.Container;
import com.tgb.container.service.Service;

public class Client {
	public static void main(String[] args) {
		//容器初始化，这个可以用filter完成，只需在整个项目中初始化一次
		Container.init();
		
		//从容器中查找接口
		Service service =(Service)Container.getComponent("service");
		//调用Service实现的方法
		service.serviceMethod();
	}
}
