package cn.itcast.spring0909.createobject.when;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class WhenTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/createobject/when/applicationContext.xml";
	}
	
	@Test
	public void test(){
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		Person person = (Person)context.getBean("person");
		helloWorld.hello();
		person.say();
	}
}
