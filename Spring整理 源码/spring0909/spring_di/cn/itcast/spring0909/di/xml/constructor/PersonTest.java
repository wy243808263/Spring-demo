package cn.itcast.spring0909.di.xml.constructor;

import java.util.List;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/di/xml/constructor/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Person person = (Person)context.getBean("person");
		person.getStudent().say();
	}
}
