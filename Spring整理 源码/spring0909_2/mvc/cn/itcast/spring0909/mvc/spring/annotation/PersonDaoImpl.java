package cn.itcast.spring0909.mvc.spring.annotation;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao{
	@Override
	public void savePerson() {
		// TODO Auto-generated method stub
		System.out.println("save person");
	}
	
}
