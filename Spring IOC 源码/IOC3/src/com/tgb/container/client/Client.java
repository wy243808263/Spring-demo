package com.tgb.container.client;
import com.tgb.container.Container;
import com.tgb.container.service.Service;

public class Client {
	public static void main(String[] args) {
		//������ʼ�������������filter��ɣ�ֻ����������Ŀ�г�ʼ��һ��
		Container.init();
		
		//��������ȡ�ӿ�
		Service service =(Service)Container.getComponent("service");
		service.serviceMethod();
	}
}
