package cn.itcast.spring0909.di.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	@Resource(name="student")
	//@Autowired//按照类型进行匹配
	//@Qualifier("student")
	private Student studen;
	
	@Resource
	private Long pid;
	
	public void say(){
		this.studen.say();
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}
}
