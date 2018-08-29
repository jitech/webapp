package br.com.webapp.domain;

import java.util.List;

public class TestClass extends Domain{
	
	private String name;
	private List<TestMethod> methods;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TestMethod> getMethods() {
		return methods;
	}
	public void setMethods(List<TestMethod> methods) {
		this.methods = methods;
	}
}