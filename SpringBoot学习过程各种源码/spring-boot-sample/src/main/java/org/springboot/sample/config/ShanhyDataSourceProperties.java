package org.springboot.sample.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ShanhyDataSourceProperties.PREFIX)
public class ShanhyDataSourceProperties {

	public static final String PREFIX = "shanhy.datasource";

	private ClassLoader classLoader;

	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Class<? extends DataSource> type;

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Class<? extends DataSource> getType() {
		return type;
	}

	public void setType(Class<? extends DataSource> type) {
		this.type = type;
	}

}
