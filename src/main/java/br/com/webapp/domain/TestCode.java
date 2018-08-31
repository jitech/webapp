package br.com.webapp.domain;

import java.util.List;

import br.com.webapp.enums.LanguageEnum;

public class TestCode {

	private String code;
	private String describe;
	private LanguageEnum language;
	private List<TestCodeCase> testCodeCases;
	
	public TestCode() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescribe() {
		return describe;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public LanguageEnum getLanguage() {
		return language;
	}
	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}

	public List<TestCodeCase> getTestCodeCases() {
		return testCodeCases;
	}

	public void setTestCodeCases(List<TestCodeCase> testCodeCases) {
		this.testCodeCases = testCodeCases;
	}
}