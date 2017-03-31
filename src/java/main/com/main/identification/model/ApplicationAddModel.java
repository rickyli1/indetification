package com.main.identification.model;

import java.util.List;

public class ApplicationAddModel extends BaseModel {
	private Application application;
	private List<Report> reports;
	
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public List<Report> getReports() {
		return reports;
	}
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	
	
}
