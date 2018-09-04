package br.com.webapp.domain_new;

import br.com.webapp.annotations.TableTest;
import br.com.webapp.domain.Domain;

public class AlgorithmTableTest extends Domain{

	private String name;
	private String describe;
	
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
	
	@TableTest
	public int sum(int x, int y) {
		
		return x + y;
	}
}