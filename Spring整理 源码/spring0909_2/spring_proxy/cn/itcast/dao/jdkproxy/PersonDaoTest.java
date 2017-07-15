package cn.itcast.dao.jdkproxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class PersonDaoTest {
	@Test
	public void test(){
		Transaction transaction = new Transaction();
		PersonDao target = new PersonDaoImpl();
		PersonDaoInteceptor inteceptor = new PersonDaoInteceptor(transaction, target);
		PersonDao proxy = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), inteceptor);
		proxy.getPerson();
	}
}
