package cn.itcast.spring0909.jdbc.transaction;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/jdbc/transaction/applicationContext.xml";
	}

	@Test
	public void test(){
		PersonService personService = (PersonService)context.getBean("personService");
		System.out.println(personService);
		personService.savePerson();
	}
}

