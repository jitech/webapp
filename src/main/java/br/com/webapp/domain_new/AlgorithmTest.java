package br.com.webapp.domain_new;

import java.util.List;

import br.com.webapp.domain.Domain;

public class AlgorithmTest extends Domain{

	private String name;
	private String describe;
	private List<AlgorithmMethodTest> methodsToTest;
	private String path;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<AlgorithmMethodTest> getMethodsToTest() {
		return methodsToTest;
	}
	public void setMethodsToTest(List<AlgorithmMethodTest> methodsToTest) {
		this.methodsToTest = methodsToTest;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}