package cn.itcast.spring0909.document;

import org.junit.Test;

public class DocumentTest {
	@Test
	public void test(){
		/**
		 * 没有做到完成的面向接口编程
		 */
		Document document = new WordDocument();
		DocumentManager documentManager = new DocumentManager(document);
		documentManager.read();
		documentManager.write();
	}
}
