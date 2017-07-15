package cn.itcast.spring0909.aop.exception.test;

import org.junit.Test;

import cn.itcast.spring0909.aop.exception.action.PersonAction;
import cn.itcast.spring0909.utils.SpringHelper;

public class ExceptionTest extends SpringHelper{
	static{
		path = "applicationContext-exception.xml";
	}
	@Test
	public void test() throws Exception{
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
