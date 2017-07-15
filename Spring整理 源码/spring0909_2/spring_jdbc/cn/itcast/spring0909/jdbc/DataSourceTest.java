package cn.itcast.spring0909.jdbc;

import javax.sql.DataSource;

import org.junit.Test;

import cn.itcast.spring0909.utils.SpringHelper;

public class DataSourceTest extends SpringHelper{
	static{
		path = "cn/itcast/spring0909/jdbc/applicationContext.xml";
	}
	
	@Test
	public void testDataSource(){
		/**
		 * 完全的面向接口编程
		 */
		DataSource dataSource = (DataSource)context.getBean("dataSource");
		System.out.println(dataSource);
	}
}
