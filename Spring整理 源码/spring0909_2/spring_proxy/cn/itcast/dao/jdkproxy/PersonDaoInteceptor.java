package cn.itcast.dao.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInteceptor implements InvocationHandler{
	
	private Transaction transaction;
	private Object target;
	
	public PersonDaoInteceptor(Transaction transaction,Object target){
		this.transaction = transaction;
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		Object obj;
		String methodName = method.getName();
		if("savePerson".equals(methodName)||
				"updatePerson".equals(methodName)||
				"deletePerson".equals(methodName)){
			this.transaction.beginTransaction();
			obj = method.invoke(this.target, args);//调用目标类的目标方法
			this.transaction.commit();
		}else{
			obj = method.invoke(this.target, args);//调用目标类的目标方法
		}
		return obj;
	}

}
