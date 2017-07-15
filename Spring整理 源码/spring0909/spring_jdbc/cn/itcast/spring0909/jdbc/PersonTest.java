package cn.itcast.spring0909.jdbc;

import java.util.List;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/jdbc/applicationContext.xml";
	}
	
	@Test
	public void testSave(){
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.savePerson();
	}
	
	@Test
	public void testQuery(){
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		List<Person> personList = personDao.getPersons();
		System.out.println(personList.size());
	}
}
