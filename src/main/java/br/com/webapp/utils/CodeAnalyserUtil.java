package br.com.webapp.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.data.ExecutionDataStore;

public class CodeAnalyserUtil implements ICoverageVisitor{

	private Analyzer analyzer;
	private int complexity;
	private IClassCoverage iClassCoverage;
	
	public CodeAnalyserUtil() {
		analyzer = new Analyzer(new ExecutionDataStore(), this);
	}
	
	@Override
	public void visitCoverage(IClassCoverage coverage) {
		complexity = coverage.getComplexityCounter().getTotalCount();
		iClassCoverage = coverage;
	}
	
	public int loadComplexity(final String location) throws IOException {
		LoggerUtil.info(getClass(), "Analisando código...");
		analyzer.analyzeAll(new File(location));
		LoggerUtil.info(getClass(), ">>> Complexidade do código: "+complexity);
		return complexity;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public boolean isCorrectMethod(final String file, final String methodName, List<Object> listParams, Object expected) throws Exception {
		
		Class params[] = new Class[listParams.size()];
		
		for(int count = 0 ; count < params.length ; count++) {
			params[count] = listParams.get(count).getClass();
		}
		
		URL url = new URL("file:"+file);
		URL[] urls = {url};
		
		URLClassLoader child = new URLClassLoader(urls);
		
		Class cls = Class.forName(iClassCoverage.getName().replaceAll("/", "."),true, child);

		Object obj = cls.newInstance();
			
		Method[] methods = cls.getMethods();
		
		for(int count = 0 ; count < methods.length ; count++) {
			
			if(methods[count].getName().equals(methodName)) {
				
				Method method = methods[count];
				
				if(method.getParameterCount() > 1) {
					
					method = cls.getDeclaredMethod(methodName, params);					
					LoggerUtil.info(getClass(), ">>> Analisando o método: "+method.getName());
					
					if(method.invoke(obj, listParams) == expected) {
						LoggerUtil.info(getClass(), ">>> Método: "+method.getName()+" retornou os valores esperados.");
						return true;
					}else {						
						LoggerUtil.info(getClass(), ">>> Método: "+method.getName()+" não retornou os valores esperados.");
						return false;
					}
					
				}else {
					
					method = cls.getDeclaredMethod(methodName, params[count]);				
					LoggerUtil.info(getClass(), ">>> Analisando o método: "+method.getName());
					
					if(method.invoke(obj, listParams.get(count)) == expected) {	
						LoggerUtil.info(getClass(), ">>> Método: "+method.getName()+" retornou os valores esperados.");
						return true;
					}else {					
						LoggerUtil.info(getClass(), ">>> Método: "+method.getName()+" não retornou os valores esperados.");
						return false;
					}
				}
			}
		}
		
		return false;
	}		
}