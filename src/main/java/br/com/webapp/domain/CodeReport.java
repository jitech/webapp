package br.com.webapp.domain;

import org.jacoco.core.analysis.IClassCoverage;

public class CodeReport {

	private IClassCoverage coverage;
	private String analizedMethod;
	private boolean isMethodSucess;
	
	public CodeReport() {
		super();
	}
	
	public CodeReport(IClassCoverage coverage, String analizedMethod, boolean isMethodSucess) {
		super();
		this.coverage = coverage;
		this.analizedMethod = analizedMethod;
		this.isMethodSucess = isMethodSucess;
	}

	public IClassCoverage getCoverage() {
		return coverage;
	}

	public void setCoverage(IClassCoverage coverage) {
		this.coverage = coverage;
	}
	
	public String getAnalizedMethod() {
		return analizedMethod;
	}

	public void setAnalizedMethod(String analizedMethod) {
		this.analizedMethod = analizedMethod;
	}

	public boolean isMethodSucess() {
		return isMethodSucess;
	}

	public void setMethodSucess(boolean isMethodSucess) {
		this.isMethodSucess = isMethodSucess;
	}
}