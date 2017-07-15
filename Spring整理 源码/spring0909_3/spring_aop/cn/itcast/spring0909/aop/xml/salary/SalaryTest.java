package cn.itcast.spring0909.aop.xml.salary;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class SalaryTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/aop/xml/salary/applicationContext.xml";
	}
	@Test
	public void test(){
		SalaryManager salaryManager = (SalaryManager)context.getBean("salaryManager");
		salaryManager.showSalary();
	}
}
