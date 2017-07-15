package cn.itcast.spring0909.document.spring;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class DocumentTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/document/spring/applicationContext.xml";
	}
	@Test
	public void test(){
		DocumentManager documentManager = (DocumentManager)context.getBean("documentManager");
		documentManager.read();
	}
}
