package br.com.webapp.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.webapp.domain_new.AlgorithmMethodTest;
import br.com.webapp.domain_new.AlgorithmTest;

public class AlgorithmTestUtil {

	public static AlgorithmTest load() {
		
		AlgorithmTest algorithm = new AlgorithmTest();
		algorithm.setName("Calculadora");
		algorithm.setDescribe("Criação de uma calculadora com operações de + - * /");
		
			List<AlgorithmMethodTest> methodsToTest = new ArrayList<AlgorithmMethodTest>();
			AlgorithmMethodTest test1 = new AlgorithmMethodTest();
			test1.setMethodName("sum");
			test1.setMethodDescribe("Algoritimo de Soma");
			
				List<Object> methodParameters = new ArrayList<Object>();			
				methodParameters.add(2);
				methodParameters.add(4);
			
			test1.setMethodParameters(methodParameters);
			test1.setMethodResponseExpected(6);
			methodsToTest.add(test1);
		
		algorithm.setMethodsToTest(methodsToTest);
		
		return algorithm;
	}
}