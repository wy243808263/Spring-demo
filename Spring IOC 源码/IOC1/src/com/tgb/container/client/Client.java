package com.tgb.container.client;

import com.tgb.container.service.Service;
import com.tgb.container.service.impl.ServiceImpl;

public class Client {
	public static void main(String[] args) {
		//实例化Service实现
		Service service = new ServiceImpl();
		//调用Service实现的方法
		service.serviceMethod();
	}
}
