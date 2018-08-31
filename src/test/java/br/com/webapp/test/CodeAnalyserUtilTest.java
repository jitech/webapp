package br.com.webapp.test;

import org.junit.Test;

import br.com.webapp.utils.CodeAnalyserUtil;
import br.com.webapp.utils.TestCodeUtil;

public class CodeAnalyserUtilTest {

	@Test
	public void fatorar() throws Exception {
		
		new CodeAnalyserUtil(TestCodeUtil.loadUserTestCode());
	}
}