package org.springboot.sample.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 注册动态数据源
 *
 * @author   单红宇(365384722)
 * @myblog  http://blog.csdn.net/catoop/
 * @create    2016年1月23日
 */
//@Configuration
@Deprecated// 改用DynamicDataSourceRegister类
public class ConfigurationDynamicDataSourceRegister
		implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent>, EnvironmentAware {

	// 如配置文件中未指定数据源类型，使用该默认值
	private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";
	// private static final Object DATASOURCE_TYPE_DEFAULT = "com.zaxxer.hikari.HikariDataSource";

	private ApplicationContext applicationContext;
	
	// 存放DataSource配置的集合，模型<dataSourceName,dataSourceMap>
	private Map<String, Map<String, Object>> dataSourceInfoMap = new HashMap<>();

	@Resource(name="dataSource")
	private javax.sql.DataSource dataSource;
	
	/**
	 * 获得ApplicationContext
	 * 
	 * @param event
	 * @author SHANHY
	 * @create 2016年1月23日
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 监听容器刷新事件 OR Start Event
	 *
	 * @param event
	 * @author SHANHY
	 * @create 2016年1月23日
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		registerDynamicDataSource();
	}

	/**
	 * 注册动态数据源
	 *
	 * @author SHANHY
	 * @create 2016年1月23日
	 */
	private void registerDynamicDataSource() {
		// 把数据源bean注册到容器中
		addBeanToApplication(dataSourceInfoMap);  
	}

	/**
	 * 功能说明：根据DataSource创建bean并注册到容器中
	 * 
	 * @param acf
	 * @param customDataSourceMap
	 */
	private void addBeanToApplication(Map<String, Map<String, Object>> customDataSourceMap) {
		DefaultListableBeanFactory acf = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder bdb;

		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();

		// 将默认数据源放入 targetDataSources map中
		targetDataSources.put("dataSource", dataSource);
		DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");

		// 根据数据源得到数据，动态创建数据源bean 并将bean注册到applicationContext中去
		Map<String, Object> dsMap = null;
		for (Entry<String, Map<String, Object>> entry : customDataSourceMap.entrySet()) {
			// bean ID
			String key = entry.getKey();
			dsMap = entry.getValue();
			Object type = dsMap.get("type");
			if (type == null)
				type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource
			
			// 创建bean
			bdb = BeanDefinitionBuilder.rootBeanDefinition(type.toString());
			bdb.getBeanDefinition().setAttribute("id", key);
			bdb.addPropertyValue("driverClassName", dsMap.get("driver-class-name"));
			bdb.addPropertyValue("url", dsMap.get("url"));
			bdb.addPropertyValue("username", dsMap.get("username"));
			bdb.addPropertyValue("password", dsMap.get("password"));
			// 注册bean
			acf.registerBeanDefinition(key, bdb.getBeanDefinition());
			// 放入map中，注意一定是刚才创建bean对象
			targetDataSources.put(key, applicationContext.getBean(key));
			DynamicDataSourceContextHolder.dataSourceIds.add(key);
		}
		
		bdb = BeanDefinitionBuilder.rootBeanDefinition(DynamicDataSource.class);
		bdb.getBeanDefinition().setAttribute("id", "dynamicDataSource");

		bdb.addPropertyValue("defaultTargetDataSource", dataSource);
		bdb.addPropertyValue("targetDataSources", targetDataSources);

		// 注册Bean
		acf.registerBeanDefinition("dynamicDataSource", bdb.getBeanDefinition());
//		// 必须重新初始化 AbstractRoutingDataSource 中的 resolvedDataSources，动态切换才会生效
		DynamicDataSource dynamicDataSource = (DynamicDataSource)applicationContext.getBean("dynamicDataSource");
        dynamicDataSource.afterPropertiesSet();
        
        autowiredDynamicDataSource(dynamicDataSource);
	}
	
	/**
	 * 注入动态数据源到jdbcTemplate、sqlSessoinTemplate
	 *
	 * @author SHANHY
	 * @create  2016年1月24日
	 */
	private void autowiredDynamicDataSource(DynamicDataSource dynamicDataSource){
        //>>>>>>>>>>>>>>>>> JdbcTemplate <<<<<<<<<<<<<<<<<//	
		// 读取jdbcTemplate，设置dynamicDataSource为它的dataSource
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		jdbcTemplate.setDataSource(dynamicDataSource);
		jdbcTemplate.afterPropertiesSet();
		//>>>>>>>>>>>>>>>>> SqlSessionTemplate <<<<<<<<<<<<<<<<<//
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)applicationContext.getBean(SqlSessionFactory.class);
		org.apache.ibatis.mapping.Environment myBatisEnvironment = sqlSessionFactory.getConfiguration().getEnvironment();
		sqlSessionFactory.getConfiguration().setEnvironment(new org.apache.ibatis.mapping.Environment(myBatisEnvironment.getId(), myBatisEnvironment.getTransactionFactory(), dynamicDataSource));
	}

	/**
	 * 加载多数据源配置
	 */
	@Override
	public void setEnvironment(Environment env) {
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "custom.datasource.");
		String dsPrefixs = propertyResolver.getProperty("names");
		for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源
			Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");
			dataSourceInfoMap.put(dsPrefix, dsMap);
		}
	}

}
