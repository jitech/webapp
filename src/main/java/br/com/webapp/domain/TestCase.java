package br.com.webapp.domain;

import java.util.List;

public class TestCase extends Domain{
	
	private List<Object> parameters;
	private Object expected;
	
	public List<Object> getParameters() {
		return parameters;
	}
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
	public Object getExpected() {
		return expected;
	}
	public void setExpected(Object expected) {
		this.expected = expected;
	}
}