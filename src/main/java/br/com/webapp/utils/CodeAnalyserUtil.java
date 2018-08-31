package br.com.webapp.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.data.ExecutionDataStore;

import br.com.webapp.domain.TestCodeCase;
import br.com.webapp.domain.UserTestCode;

public class CodeAnalyserUtil implements ICoverageVisitor{

	private Analyzer analyzer;	
	private UserTestCode userTestCode;
	
	public CodeAnalyserUtil(UserTestCode userTestCode) throws IOException {
		this.userTestCode = userTestCode;
		
		LoggerUtil.info(getClass(), "--------------------------------------------------------");
		LoggerUtil.info(getClass(), "Test: "+userTestCode.getTestCode().getDescribe());
		LoggerUtil.info(getClass(), "Language: "+userTestCode.getTestCode().getLanguage());
		
		analyzer = new Analyzer(new ExecutionDataStore(), this);		
		analyzer.analyzeAll(new File(userTestCode.getTestFilePath()));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void visitCoverage(IClassCoverage coverage) {
		
		try {
				LoggerUtil.info(getClass(), "--------------------------------------------------------");
				LoggerUtil.info(getClass(), "Classe analisada: "+coverage.getSourceFileName());
				LoggerUtil.info(getClass(), "Complexidade Ciclomática: "+coverage.getComplexityCounter().getTotalCount());
		
				for(TestCodeCase testCodeCase : userTestCode.getTestCode().getTestCodeCases()) {
						
					Class params[] = new Class[testCodeCase.getMethodInputParameters().size()];
					
					for(int count = 0 ; count < params.length ; count++) {
						params[count] = testCodeCase.getMethodInputParameters().get(count).getClass();
					}
			
					URL[] urls = {new URL("file:"+userTestCode.getTestFilePath())};
					
					Class clazz = Class.forName(coverage.getName().replaceAll("/", "."),true, new URLClassLoader(urls));
					Object obj = clazz.newInstance();						
					Method[] methods = clazz.getMethods();
					
					for(int count = 0 ; count < methods.length ; count++) {					
						if(methods[count].getName().equals(testCodeCase.getMethodName())) {
									
							LoggerUtil.info(getClass(), ">>> Testando o método: "+testCodeCase.getMethodName());
							
							Method method = methods[count];	
							method = clazz.getDeclaredMethod(testCodeCase.getMethodName(), params);	
														
							if(method.invoke(obj, testCodeCase.getMethodInputParameters().toArray()) == testCodeCase.getMethodOutputExpected()) {
								LoggerUtil.info(getClass(), ">>>> Método retornou o esperado");
							}else {
								LoggerUtil.info(getClass(), ">>>> Método não retornou o esperado");
							}
							
							break;
						}
					}
				}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}