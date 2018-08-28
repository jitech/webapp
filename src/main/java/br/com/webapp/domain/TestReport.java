package br.com.webapp.domain;

import java.util.List;

public class TestReport extends Domain{

	private Integer complexity;		
	private List<ClassReport> classReports;

	public Integer getComplexity() {
		
		try {
				Integer sum = 0;
		
				for(ClassReport classReport : getClassReports()) {
					sum = sum + classReport.getComplexity();
				}
		
				setComplexity(sum/getClassReports().size());
		
				return complexity;
		
		}catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public void setComplexity(Integer complexity) {
		this.complexity = complexity;
	}

	public List<ClassReport> getClassReports() {
		return classReports;
	}

	public void setClassReports(List<ClassReport> classReports) {
		this.classReports = classReports;
	}
}