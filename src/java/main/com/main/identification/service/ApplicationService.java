package com.main.identification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.service.ExpertService;

import com.main.identification.model.Application;
import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationResult;
import com.main.identification.model.Report;
import com.main.identification.repository.ApplicationRepository;
import com.main.identification.repository.ConstantRepository;
import com.main.identification.repository.ReportRepository;
import com.main.identification.utils.Constant;
import com.main.identification.utils.IndentificationUtils;

/**
 * 申请管理Service
 * 
 * @author YangQi
 *
 */
@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	public ExpertService expertService;
	
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired
	public ConstantRepository constantRepository;	
	
	@Autowired
	CommonService commonService;
	
	/**
	 * 申请查询
	 * 
	 * @param condition 检索条件
	 * @return 结果集
	 */
	public List<ApplicationResult> searchList(ApplicationResult condition){
		return this.setContent(applicationRepository.selectApplicationResultList(condition));
	}
	
	/**
	 * 申请查询
	 * 
	 * @param condition 检索条件
	 * @return 结果集
	 */
	public int selectApplicationResultCount(ApplicationResult condition){
		return applicationRepository.selectApplicationResultCount(condition);
	}
	
	/**
	 * @return
	 */
	public int insertApplication(Application application){
		return applicationRepository.insertApplication(application);
	}
	
	/**
	 * @return
	 */
	public int deleteApplication(Application application){
		return applicationRepository.deleteApplication(application);
	}
	
	/**
	 * 申请和申请详细插入插入
	 * 	
	 * */
	public int addApplicationInfo(ApplicationAddModel applicationAddModel){
		
		Application application = applicationAddModel.getApplication();
		List<Report> reports = applicationAddModel.getReports();
		application.setApplicationNo(Constant.APPLICATION_FLAG +  String.valueOf(constantRepository.findApplicationSeq()));		
		
		IndentificationUtils.setUserInfo(application);
		application.setApplicationDate(application.getApplicationDate().replaceAll("-", ""));
		for(Report report : reports) {
			IndentificationUtils.setUserInfo(report);
			report.setApplicationNo(application.getApplicationNo());
			report.setCompanyNo(application.getCompanyNo());
			report.setReportNo(Constant.REPORT_FLAG +  String.valueOf(commonService.createSequenceId(Constant.REPORT_SEQ)));	
			report.setApplicationDate(application.getApplicationDate());
			
			// 暂时追加为专家组长
			if(report.getExpertsNo() != null && !report.getExpertsNo().isEmpty()){
				report.setLeaderNo(report.getExpertsNo());
				report.setExpertsNo("");
			}
		}
		
		applicationRepository.insertApplication(application);
		int result = reportRepository.insertReportBatch(reports);
		return result;
	}
	
	/**
	 * 设定画面显示内容
	 * @param resultList 检索返回结果集
	 * @return 设定后的结果集
	 */
	private List<ApplicationResult> setContent(List<ApplicationResult> resultList){
		// 设定检修级别
		for(ApplicationResult applicationResult: resultList){
			if("1".equals(applicationResult.getRepairLevel())){
				applicationResult.setRepairLevel("检修");
			} else if ("2".equals(applicationResult.getRepairLevel())){
				applicationResult.setRepairLevel("小修");
			} else if ("3".equals(applicationResult.getRepairLevel())){
				applicationResult.setRepairLevel("中修");
			} else if ("4".equals(applicationResult.getRepairLevel())){
				applicationResult.setRepairLevel("大修");
			} 
			
			// 设定专家组姓名
			applicationResult.setExpertsName(this.getExpertsName(applicationResult));
		}
		
		return resultList;
	}
	
	/**
	 * 获取专家组姓名
	 * @param applicationResult
	 * @return 专家组姓名
	 */
	private String getExpertsName(ApplicationResult applicationResult){
		String expertsName = "";
		
		// 获取组长姓名
		if(applicationResult.getLeaderNo() != null && !applicationResult.getLeaderNo().isEmpty()){
			expertsName = expertsName.concat(expertService.selectByExpertNo(applicationResult.getLeaderNo()).getExpertName());
		}
		
		if(!expertsName.isEmpty()){
			expertsName = expertsName.concat("(*)");
		}
		
		if(applicationResult.getExpertsNo() != null && !applicationResult.getExpertsNo().isEmpty()){
			// 获取组员姓名
			String[] namesNo = applicationResult.getExpertsNo().split(";");
			for(int i=0;i<namesNo.length;i++){
				if(!namesNo[i].isEmpty()){
					expertsName = expertsName.concat(",").concat(expertService.selectByExpertNo(namesNo[i]).getExpertName());
				}
			}
		}
		
		return expertsName;
	}

}
