package cn.itcast.spring0909.mvc.spring.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{
	@Resource(name="personDao")
	private PersonDao personDao;

	@Override
	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
	}
}
