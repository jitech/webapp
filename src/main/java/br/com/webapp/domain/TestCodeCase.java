package br.com.webapp.domain;

import java.util.List;

public class TestCodeCase extends Domain{
	
	private String methodName;
	private List<Object> methodInputParameters;
	private Object methodOutputExpected;
	
	public TestCodeCase() {
		super();
	}

	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public List<Object> getMethodInputParameters() {
		return methodInputParameters;
	}
	
	public void setMethodInputParameters(List<Object> methodInputParameters) {
		this.methodInputParameters = methodInputParameters;
	}
	
	public Object getMethodOutputExpected() {
		return methodOutputExpected;
	}
	
	public void setMethodOutputExpected(Object methodOutputExpected) {
		this.methodOutputExpected = methodOutputExpected;
	}
}