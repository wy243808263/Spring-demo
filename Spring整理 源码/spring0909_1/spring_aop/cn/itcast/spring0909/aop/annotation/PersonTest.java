package cn.itcast.spring0909.aop.annotation;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

/**
 * 
 * @author Administrator
 *
 */
public class PersonTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/aop/annotation/applicationContext.xml";
	}
	
	@Test
	public void test(){
		PersonDaoImpl personDao = (PersonDaoImpl)context.getBean("personDao");
		personDao.getPerson();
	}
}
