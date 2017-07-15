package com.tgb.container;

import java.util.HashMap;
import java.util.Map;

import com.tgb.container.dao.Dao;
import com.tgb.container.dao.impl.Dao4MySqlImpl;
import com.tgb.container.dao.impl.Dao4OracleImpl;
import com.tgb.container.service.Service;
import com.tgb.container.service.impl.ServiceImpl;

public class Container {
	private static Map<String, Object> components;

	private Container() {
	}

	/**
	 * 初始化容器
	 */
	public static synchronized void init() {
		if (components == null) {
			components = new HashMap<String, Object>();
			//写一个读配置文件的类，根据读取的配置文件，反射对应的类
			//反射好类后进行 依赖管理，往对应的属性上注入相应的类
			//客户端创建新类的时候把容器创建好的类付给新类
			
			Dao dao4Mysql = new Dao4MySqlImpl();
			components.put("dao4Mysql", dao4Mysql);
			
			Dao dao4Oracle = new Dao4OracleImpl();
			components.put("dao4Oracle", dao4Oracle);
			
			Service service = new ServiceImpl();  
			components.put("service", service);
			
		}
	}

	/**
	 * 查找组件
	 * 
	 * @param id
	 * @return
	 */
	public static Object getComponent(String id) {
		return components.get(id);
	}

}
