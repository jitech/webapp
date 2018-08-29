package br.com.webapp.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
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
	
	public boolean isCorrectMethod(final String file, final String methodName, List<Object> listParams, Object expected) throws Exception {
		
		@SuppressWarnings("rawtypes")
		Class params[] = new Class[listParams.size()];
		
		for(int count = 0 ; count < params.length ; count++) {
			params[count] = listParams.get(count).getClass();
		}
		
		URL url = new URL("file:"+file);
		URL[] urls = {url};
		
		URLClassLoader child = new URLClassLoader(urls);
		
		@SuppressWarnings("rawtypes")
		Class cls = Class.forName(iClassCoverage.getName().replaceAll("/", "."),true, child);

		Object obj = cls.newInstance();
	
		@SuppressWarnings("unchecked")
		
		Method[] methods = cls.getMethods();
		
		for(int count = 0 ; count < methods.length ; count++) {
			
			if(methods[count].getName().equals(methodName)) {
				
				Method method = methods[count];
				
				if(method.getParameterCount() > 1) {
					
					method = cls.getDeclaredMethod(methodName, params);
					
					if(method.invoke(obj, params) == expected) {				
						return true;
					}
					
				}else {
					
					method = cls.getDeclaredMethod(methodName, params[count]);
									
					if(method.invoke(obj, params[count]) == expected) {				
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
