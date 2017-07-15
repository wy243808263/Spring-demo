package cn.itcast.spring0909.jdbc;

import java.util.List;

public interface PersonDao {
	public void savePerson();
	
	public List<Person> getPersons();
}
