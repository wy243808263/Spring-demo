package cn.itcast.spring0909.initdestroy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring0909.utils.SpringHelper;

public class InitDestroyTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/initdestroy/applicationContext.xml";
	}
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext)context;
		HelloWorld helloWorld = (HelloWorld)applicationContext.getBean("helloWorld");
		helloWorld.hello();
		applicationContext.close();
	}
}
