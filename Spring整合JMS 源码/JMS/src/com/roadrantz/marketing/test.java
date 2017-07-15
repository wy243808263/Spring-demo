package com.roadrantz.marketing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class test {
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 Sender sender = (Sender) context.getBean("sender");
	        sender.sendInfo();	
	}
}
