package com.main.identification.model;

import java.util.List;

public class ExpertStatistics extends Expert  {

	private static final long serialVersionUID = -794749798417226682L;
	private List<Report> reportList;
    
	
	public List<Report> getReportList() {
		return reportList;
	}
	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}
    
}
