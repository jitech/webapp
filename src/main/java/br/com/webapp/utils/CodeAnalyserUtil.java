package br.com.webapp.utils;

import java.io.File;
import java.io.IOException;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.IClassCoverage;
import org.jacoco.core.analysis.ICoverageVisitor;
import org.jacoco.core.data.ExecutionDataStore;

public class CodeAnalyserUtil implements ICoverageVisitor{

	private Analyzer analyzer;
	private int complexity;
	
	public CodeAnalyserUtil() {
		analyzer = new Analyzer(new ExecutionDataStore(), this);
	}
	
	@Override
	public void visitCoverage(IClassCoverage coverage) {
		complexity = coverage.getComplexityCounter().getTotalCount();
	}
	
	public int loadComplexity(final String location) throws IOException {
		LoggerUtil.info(getClass(), "Analisando código...");
		analyzer.analyzeAll(new File(location));
		LoggerUtil.info(getClass(), ">>> Complexidade do código: "+complexity);
		return complexity;
	}
}
