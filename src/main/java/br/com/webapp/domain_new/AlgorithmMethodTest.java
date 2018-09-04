package br.com.webapp.domain_new;

import java.util.List;

import br.com.webapp.domain.Domain;

public class AlgorithmMethodTest extends Domain{

	private String methodName;
	private String methodDescribe;
	private List<Object> methodParameters;
	private Object methodResponseExpected;
	
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
	public List<Object> getMethodParameters() {
		return methodParameters;
	}
	public void setMethodParameters(List<Object> methodParameters) {
		this.methodParameters = methodParameters;
	}
	public Object getMethodResponseExpected() {
		return methodResponseExpected;
	}
	public void setMethodResponseExpected(Object methodResponseExpected) {
		this.methodResponseExpected = methodResponseExpected;
	}
}