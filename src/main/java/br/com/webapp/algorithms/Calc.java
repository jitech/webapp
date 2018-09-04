package br.com.webapp.algorithms;

import br.com.webapp.annotations.TableTest;

public class Calc {

	@TableTest
	public int sum(int x, int y) {
		
		return x + y;
	}
	
	@TableTest
	public int sub(int x, int y) {
		
		return x - y;
	}
	
	@TableTest
	public int multi(int x, int y) {
		
		return x * y;
	}
	
	@TableTest
	public int div(int x, int y) {
		
		return x / y;
	}
}
