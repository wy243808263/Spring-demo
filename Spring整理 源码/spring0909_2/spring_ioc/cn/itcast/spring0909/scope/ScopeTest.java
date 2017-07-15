package cn.itcast.spring0909.scope;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class ScopeTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/scope/applicationContext.xml";
	}
	
	@Test
	public void test(){
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		helloWorld.getLists().add("aa");
		System.out.println(helloWorld);
		
		HelloWorld helloWorld2 = (HelloWorld)context.getBean("helloWorld");
		helloWorld2.getLists().add("bb");
		System.out.println(helloWorld2);
		System.out.println(helloWorld.getLists().size());
		System.out.println(helloWorld2.getLists().size());
	}
}
