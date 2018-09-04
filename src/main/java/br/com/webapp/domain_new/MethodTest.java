package br.com.webapp.domain_new;

import br.com.webapp.domain.Domain;

public class MethodTest extends Domain{

	private String methodName;
	private String methodDescribe;
	private Object[] methodParameters;
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getMethodDescribe() {
		return methodDescribe;
	}
	public void setMethodDescribe(String methodDescribe) {
		this.methodDescribe = methodDescribe;
	}
	public Object[] getMethodParameters() {
		return methodParameters;
	}
	public void setMethodParameters(Object[] methodParameters) {
		this.methodParameters = methodParameters;
	}
}