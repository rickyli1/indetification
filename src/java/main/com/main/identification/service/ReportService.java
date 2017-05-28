package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.repository.ReportRepository;
import com.main.identification.model.Report;

/**
 * 申请管理Service
 * 
 * @author YangQi
 *
 */
@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	
	public int insertReport(Report report){
		return reportRepository.insertReport(report);
	}
	
	public int deleteReport(Report report){
		return reportRepository.deleteReport(report);
	}
	
	public int deleteUpdateReport(Report report){
		return reportRepository.delUpdateReport(report);
	}
	
	public int insertReportBatch(List<Report> list){
		return reportRepository.insertReportBatch(list);
	}
	
}
