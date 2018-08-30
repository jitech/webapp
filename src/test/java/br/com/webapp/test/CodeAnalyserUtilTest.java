package br.com.webapp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.webapp.domain.CodeReport;
import br.com.webapp.utils.CodeAnalyserUtil;

public class CodeAnalyserUtilTest {

	@Test
	public void fatorar() throws Exception {
		CodeAnalyserUtil codeAnalyserUtil = new CodeAnalyserUtil("/export/c74fe7c6ba2963d7f2f4304226a6fb4a.jar");
		
		List<Object> listParams = new ArrayList<Object>();
		listParams.add(5);
		
		CodeReport report = codeAnalyserUtil.getReport("/export/c74fe7c6ba2963d7f2f4304226a6fb4a.jar", "fatorar", listParams, 120);
		
		Assert.assertEquals(true, report.isMethodSucess());
	}
	
	@Test
	public void somar() throws Exception {
		CodeAnalyserUtil codeAnalyserUtil = new CodeAnalyserUtil("/export/c74fe7c6ba2963d7f2f4304226a6fb4a.jar");
		
		List<Object> listParams = new ArrayList<Object>();
		listParams.add(5);
		listParams.add(15);
		
		CodeReport report = codeAnalyserUtil.getReport("/export/c74fe7c6ba2963d7f2f4304226a6fb4a.jar", "sum", listParams, 10);
		
		Assert.assertEquals(true, report.isMethodSucess());
	}
}