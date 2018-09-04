package br.com.webapp.domain_new;

import java.util.List;

import br.com.webapp.domain.Domain;

public class UserAlgorithmTest extends Domain{
	
	private List<UserMethodTest> userMethodTests;
	private String path;
	private AlgorithmTest algorithmTest;
	
	public UserAlgorithmTest() {
		super();
	}
	
	public UserAlgorithmTest(List<UserMethodTest> userMethodTests, String path, AlgorithmTest algorithmTest) {
		super();
		this.userMethodTests = userMethodTests;
		this.path = path;
		this.algorithmTest = algorithmTest;
	}

	public List<UserMethodTest> getUserMethodTests() {
		return userMethodTests;
	}
	public void setUserMethodTests(List<UserMethodTest> userMethodTests) {
		this.userMethodTests = userMethodTests;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public AlgorithmTest getAlgorithmTest() {
		return algorithmTest;
	}
	public void setAlgorithmTest(AlgorithmTest algorithmTest) {
		this.algorithmTest = algorithmTest;
	}
}