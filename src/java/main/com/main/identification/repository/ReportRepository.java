package com.main.identification.repository;
import java.util.List;

import com.main.identification.model.Report;

public interface ReportRepository {
	
	/**
	 * @return
	 */
	public int insertReport(Report report);
	
	public int insertReportBatch(List<Report> list);

}
