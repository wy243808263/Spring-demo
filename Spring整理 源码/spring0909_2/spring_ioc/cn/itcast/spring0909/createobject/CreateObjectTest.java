package cn.itcast.spring0909.createobject;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class CreateObjectTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/createobject/applicationContext.xml";
	}
	/**
	 * spring容器调用默认的构造函数来创建对象的
	 */
	@Test
	public void test(){
		HelloWorld world = (HelloWorld)context.getBean("helloWorld2");
		world.hello();
	}
}
