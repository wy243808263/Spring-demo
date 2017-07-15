package cn.itcast.spring0909.alias;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring0909.utils.SpringHelper;

public class AliasTest extends SpringHelper{
	/**
	 * 无论这两个类之间有什么继承关系，静态代码块比方法先执行
	 */
	static{
		path = "cn/itcast/spring0909/alias/applicationContext.xml";
	}
	@Test
	public void test(){
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		HelloWorld helloWorld2 = (HelloWorld)context.getBean("王二麻子");
//		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
//		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		helloWorld2.hello();
	}
}
