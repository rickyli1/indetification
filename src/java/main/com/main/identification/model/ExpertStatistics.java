package com.main.identification.model;

import java.util.List;

public class ExpertStatistics extends Expert  {

	private static final long serialVersionUID = -794749798417226682L;
	private List<ExpertReport> reportList;
    
	
	public List<ExpertReport> getReportList() {
		return reportList;
	}
	public void setReportList(List<ExpertReport> reportList) {
		this.reportList = reportList;
	}
    
}
