package br.com.webapp.domain;

import java.util.List;

public class UserTestCodeReport {

	private UserTestCode userTestCode;
	private List<UserTestCodeCase> userTestCodeCases;
	
	public UserTestCode getUserTestCode() {
		return userTestCode;
	}
	public void setUserTestCode(UserTestCode userTestCode) {
		this.userTestCode = userTestCode;
	}
	public List<UserTestCodeCase> getUserTestCodeCases() {
		return userTestCodeCases;
	}
	public void setUserTestCodeCases(List<UserTestCodeCase> userTestCodeCases) {
		this.userTestCodeCases = userTestCodeCases;
	}
}