package br.com.webapp.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.webapp.domain.TestCode;
import br.com.webapp.domain.TestCodeCase;
import br.com.webapp.domain.UserTestCode;
import br.com.webapp.enums.LanguageEnum;

public class TestCodeUtil {

	public static UserTestCode loadUserTestCode() {
		
		UserTestCode userTestCode = new UserTestCode();
		userTestCode.setTestCode(loadTestCode());
		userTestCode.setTestFilePath("/export/calc.jar");
		
		return userTestCode;
	}
	
	public static TestCode loadTestCode() {
		
		TestCode testCode = new TestCode();
		testCode.setCode("CCCCCC");
		testCode.setDescribe("Crie uma calculadora com as funções sum, sub, div e fatorar.");
		testCode.setLanguage(LanguageEnum.JAVA);
		
			TestCodeCase case1 = new TestCodeCase();
			case1.setMethodName("sum");
			case1.setMethodOutputExpected(20);		
				List<Object> paramsCase1 = new ArrayList<Object>();
				paramsCase1.add(10);
				paramsCase1.add(10);		
			case1.setMethodInputParameters(paramsCase1);
			
			TestCodeCase case2 = new TestCodeCase();
			case2.setMethodName("fatorar");
			case2.setMethodOutputExpected(120);		
				List<Object> paramsCase2 = new ArrayList<Object>();
				paramsCase2.add(5);		
			case2.setMethodInputParameters(paramsCase2);
			
			TestCodeCase case3 = new TestCodeCase();
			case3.setMethodName("sub");
			case3.setMethodOutputExpected(0);		
				List<Object> paramsCase3 = new ArrayList<Object>();
				paramsCase3.add(10);
				paramsCase3.add(10);		
			case3.setMethodInputParameters(paramsCase3);
			
			List<TestCodeCase> cases = new ArrayList<TestCodeCase>();
			cases.add(case1);
			cases.add(case2);
			cases.add(case3);
			
		testCode.setTestCodeCases(cases);
			
		return testCode;
	}
}
