package com.tgb.container.client;

import com.tgb.container.service.Service;
import com.tgb.container.service.impl.ServiceImpl;

public class Client {
	public static void main(String[] args) {
		//ʵ����Serviceʵ��
		Service service = new ServiceImpl();
		//����Serviceʵ�ֵķ���
		service.serviceMethod();
	}
}
