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
	
	public CodeAnalyserUtil() {
		analyzer = new Analyzer(new ExecutionDataStore(), this);
	}
	
	@Override
	public void visitCoverage(IClassCoverage coverage) {		
		codeReport.add(new CodeReport(coverage, null, false));	
	}
	
	public List<CodeReport> getReport(){
		return codeReport;
	}
	
	public void generatedReport(final String location) throws IOException {
		LoggerUtil.info(getClass(), "Analisando código...");
		analyzer.analyzeAll(new File(location));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void executeMethodAnalyser(final String file, final String methodName, List<Object> listParams, Object expected) throws Exception {
		
		try {
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
							
							return;
						}
					}
				}
							
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}		
}