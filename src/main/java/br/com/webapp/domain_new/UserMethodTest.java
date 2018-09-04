package br.com.webapp.domain_new;

import br.com.webapp.domain.Domain;

public class UserMethodTest extends Domain{

	private String methodName;
	private boolean isCorrect;
	
	public UserMethodTest() {
		super();
	}
	
	public UserMethodTest(String methodName, boolean isCorrect) {
		super();
		this.methodName = methodName;
		this.isCorrect = isCorrect;
	}
	
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}