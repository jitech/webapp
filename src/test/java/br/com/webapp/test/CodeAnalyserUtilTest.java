package br.com.webapp.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.webapp.utils.MethodUtil;

public class CodeAnalyserUtilTest {

	@Test
	public void listarMetodosParaTeste() throws Exception {			
		Assert.assertEquals(1, MethodUtil.listMethodsByAnnotationTableTest().size());
	}
	
	@Test
	public void testarMetodo() throws Exception {	
		
		Assert.assertEquals(true, MethodUtil.testMethod(MethodUtil.listMethodsByAnnotationTableTest().get(0), 5, 5));
	}
}