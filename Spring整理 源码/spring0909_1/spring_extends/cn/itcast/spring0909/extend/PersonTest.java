package cn.itcast.spring0909.extend;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/extend/applicationContext.xml";
	}
	
	@Test
	public void test(){
		Student student = (Student)context.getBean("student");
		student.say();
	}
}
