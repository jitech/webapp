package br.com.webapp.domain;

public class UserTestCode extends Domain{

	private User user;
	private TestCode testCode;
	private String testFilePath;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public TestCode getTestCode() {
		return testCode;
	}
	
	public void setTestCode(TestCode testCode) {
		this.testCode = testCode;
	}
	
	public String getTestFilePath() {
		return testFilePath;
	}
	
	public void setTestFilePath(String testFilePath) {
		this.testFilePath = testFilePath;
	}
}