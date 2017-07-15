package org.springboot.sample.mapper;

import java.util.List;

import org.springboot.sample.entity.Student;

/**
 * StudentMapper，映射SQL语句的接口，无逻辑实现
 *
 * @author 单红宇(365384722)
 * @myblog http://blog.csdn.net/catoop/
 * @create 2016年1月20日
 */
public interface StudentMapper {

	List<Student> likeName(String name);
	
	Student getById(int id);
	
	int add(Student stu);
	
	String getNameById(int id);

}
