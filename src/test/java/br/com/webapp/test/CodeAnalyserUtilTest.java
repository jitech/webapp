package br.com.webapp.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.webapp.utils.MethodUtil;

public class CodeAnalyserUtilTest {

	private List<Method> methods = new ArrayList<Method>();
	
	@Before
	public void before() {
		this.methods = MethodUtil.listMethodsByAnnotationTableTest();
	}
	
	@Test
	public void listarMetodosParaTeste() throws Exception {			
		Assert.assertEquals(1, methods.size());
	}
	
	@Test
	public void testarMetodo() throws Exception {	
		
		Assert.assertEquals(true, MethodUtil.testMethod(methods.get(0), 5, 5));
	}
}