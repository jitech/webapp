package br.com.webapp.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.data.ExecutionDataStore;

import br.com.webapp.domain.CodeReport;

public class CodeAnalyserUtil implements ICoverageVisitor{

	private Analyzer analyzer;	
	private List<CodeReport> codeReport = new ArrayList<CodeReport>();
	
	public CodeAnalyserUtil(String location) throws IOException {
		analyzer = new Analyzer(new ExecutionDataStore(), this);		
		analyzer.analyzeAll(new File(location));
	}
	
	@Override
	public void visitCoverage(IClassCoverage coverage) {		
		codeReport.add(new CodeReport(coverage, null, false));	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CodeReport getReport(final String file, final String methodName, List<Object> listParams, Object expected) throws Exception {
		
		try {
				LoggerUtil.info(getClass(), "Gerando relatório...");
			
				Class params[] = new Class[listParams.size()];
				for(int count = 0 ; count < params.length ; count++) {
					params[count] = listParams.get(count).getClass();
				}
				
				URL[] urls = {new URL("file:"+file)};
										
				for(CodeReport codeReport : codeReport) {					
					Class clazz = Class.forName(codeReport.getCoverage().getName().replaceAll("/", "."),true, new URLClassLoader(urls));
					Object obj = clazz.newInstance();						
					Method[] methods = clazz.getMethods();
					
					for(int count = 0 ; count < methods.length ; count++) {					
						if(methods[count].getName().equals(methodName)) {
							
							codeReport.setAnalizedMethod(methodName);
							
							Method method = methods[count];	
							method = clazz.getDeclaredMethod(methodName, params);	
														
							if(method.invoke(obj, listParams.toArray()) == expected) {
								codeReport.setMethodSucess(true);
							}
							
							LoggerUtil.info(getClass(), "--------------------------------------------------------");
							LoggerUtil.info(getClass(), ">> Classe: "+codeReport.getCoverage().getName());
							LoggerUtil.info(getClass(), ">> Método testado: "+codeReport.getAnalizedMethod());
							LoggerUtil.info(getClass(), ">> Método testado is OK? : "+codeReport.isMethodSucess());
							LoggerUtil.info(getClass(), ">> Complexidade do método: "+codeReport.getCoverage().getComplexityCounter().getTotalCount());
							LoggerUtil.info(getClass(), "--------------------------------------------------------");
						
							
							return codeReport;
						}
					}
				}
				
				return null;
							
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}		
}