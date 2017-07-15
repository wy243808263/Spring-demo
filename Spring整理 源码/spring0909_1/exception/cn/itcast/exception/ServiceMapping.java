package cn.itcast.exception;

public class ServiceMapping {
	private String serviceClass;//封装service的全名
	
	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	private String method;//某一个service的方法
}	
