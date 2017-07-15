package com.tgb.container;

import java.util.ArrayList;
import java.util.List;

public class BeanDefinition {

	private String id;
	private String className;

	private List<PropertyDefinition> propertys = new ArrayList<PropertyDefinition>();
	
	public BeanDefinition(String id, String className) {
		this.id = id;
		this.className = className;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<PropertyDefinition> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<PropertyDefinition> propertys) {
		this.propertys = propertys;
	}

	
}
