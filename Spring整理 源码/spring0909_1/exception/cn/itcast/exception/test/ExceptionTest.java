package cn.itcast.exception.test;

import org.junit.Test;

import cn.itcast.exception.ServiceInvocation;
import cn.itcast.exception.ServiceMapping;

public class ExceptionTest {
	@Test
	public void test(){
		ServiceMapping serviceMapping = new ServiceMapping();
		serviceMapping.setServiceClass("cn.itcast.exception.service.StudentServiceImpl");
		serviceMapping.setMethod("savePerson");
		ServiceInvocation.execution(serviceMapping);
	}
}
