package cn.itcast.exception.service;

import java.lang.reflect.Method;

import cn.itcast.exception.ServiceMapping;

public class PersonServiceImpl implements Service{

	@Override
	public Object service(ServiceMapping serviceMapping) throws Exception{
		// TODO Auto-generated method stub
		/**
		 * serviceMapping
		 *   serviceClass cn.itcast.exception.service.StudentServiceImpl
		 *   methodName   savePerson
		 */
		String methodName = serviceMapping.getMethod();
		Object obj = Class.forName(serviceMapping.getServiceClass()).newInstance();
		Method method = Class.forName(serviceMapping.getServiceClass()).getMethod(methodName);
		return method.invoke(obj);
	}
}
