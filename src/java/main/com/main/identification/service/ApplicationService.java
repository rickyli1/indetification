package com.main.identification.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.service.ExpertService;

import com.main.identification.model.Application;
import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationDetailComp;
import com.main.identification.model.ApplicationDetailModel;
import com.main.identification.model.ApplicationResult;
import com.main.identification.model.Expert;
import com.main.identification.model.Report;
import com.main.identification.repository.ApplicationRepository;
import com.main.identification.repository.ConstantRepository;
import com.main.identification.repository.ExpertRepository;
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
	public ExpertRepository expertRepository;
	
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
	 * @return
	 */
	public int deleteUpdateApply(Application application){
		return applicationRepository.delUpdateApplication(application);
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
		}
		application.setOriginFlag("1");
		applicationRepository.insertApplication(application);
		int result = reportRepository.insertReportBatch(reports);
		return result;
	}
	
	/**
	 * 根据申请编号，取得申请详细信息
	 * @param condition
	 * @return
	 */
	public ApplicationDetailModel selectAppDetail(String applicationNo){
		
		ApplicationDetailModel result = new ApplicationDetailModel();
		
		// 获取单位信息
		ApplicationDetailComp compDetail = applicationRepository.selectCompDetailByApplication(applicationNo);

		result.setCompany(compDetail);
		
		// 获取专家信息
		// 给组员专家参数赋值
		if(compDetail.getExpertsNo() != null && !compDetail.getExpertsNo().isEmpty()){
			StringBuffer expertsNoStrBuf = new StringBuffer();
			expertsNoStrBuf.append("'");
			String[] expertsNo = compDetail.getExpertsNo().split(";");
			for(int i=0;i<expertsNo.length;i++){
				if(!expertsNo[i].isEmpty()){
					expertsNoStrBuf = expertsNoStrBuf.append(expertsNo[i]).append("','");
				}
			}
			String expertsNoCon = expertsNoStrBuf.substring(0, expertsNoStrBuf.length()-2);
			compDetail.setExpertsCon(expertsNoCon);
		}
		// 获取专家信息数据
		result.setExperts(expertRepository.searchAppExpertDetail(compDetail));
		
		// 获取设备信息 
		result.setEquipments(applicationRepository.selectEquipsDetailByApplication(applicationNo));
		
		return result ;
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
		Expert expert = new Expert();
		// 获取组长姓名
		if(applicationResult.getLeaderNo() != null && !applicationResult.getLeaderNo().isEmpty()){
			expert = expertService.selectByExpertNo(applicationResult.getLeaderNo());
			if(expert != null){
				expertsName = expert.getExpertName();
			}
		}
		
		if(!expertsName.isEmpty()){
			expertsName = expertsName.concat("(组长)");
		}
		
		if(applicationResult.getExpertsNo() != null && !applicationResult.getExpertsNo().isEmpty()){
			// 获取组员姓名
			String[] namesNo = applicationResult.getExpertsNo().split(";");
			for(int i=0;i<namesNo.length;i++){
				if(!namesNo[i].isEmpty()){
					expert = expertService.selectByExpertNo(namesNo[i]);
					if(expert !=null){
						expertsName = expertsName.concat(",").concat(expert.getExpertName());
					}
				}
			}
		}
		
		return expertsName;
	}

	public ApplicationAddModel selectApplicationInfoByNo(String id) {
		ApplicationAddModel app = applicationRepository.selectApplicationInfoByNo(id);
		ApplicationResult applicationResult = new ApplicationResult();
		if(app != null && app.getApplication()!=null) {
			if(StringUtils.isNotBlank(app.getApplication().getLeaderNo())) {
				applicationResult.setLeaderNo(app.getApplication().getLeaderNo());
			}
			
			if(StringUtils.isNotBlank(app.getApplication().getExpertsNo())) {
				applicationResult.setExpertsNo(app.getApplication().getExpertsNo());
			}
			
			app.getApplication().setExpertsName(getExpertsName(applicationResult));
			
			if(StringUtils.isNotBlank(app.getApplication().getApplicationDate())) {
				app.getApplication().setApplicationDate(IndentificationUtils.formatDate(app.getApplication().getApplicationDate()));
			}
		}
		return app;
	}

	public int updateApplicationInfo(ApplicationAddModel applicationAddModel) {
		Application application = applicationAddModel.getApplication();
		List<Report> reports = applicationAddModel.getReports();
		
		IndentificationUtils.setUserInfo(application);
		application.setApplicationDate(application.getApplicationDate().replaceAll("-", ""));
		
		//set delete report info
		Report deleteReport = new Report();
		deleteReport.setApplicationNo(application.getApplicationNo());
		
		//set insert report info 
		for(Report report : reports) {
			IndentificationUtils.setUserInfo(report);
			report.setApplicationNo(application.getApplicationNo());
			report.setCompanyNo(application.getCompanyNo());
			report.setReportNo(Constant.REPORT_FLAG +  String.valueOf(commonService.createSequenceId(Constant.REPORT_SEQ)));	
			report.setApplicationDate(application.getApplicationDate());
		}

		
		//application.setOriginFlag("1");
		
		//update application
		applicationRepository.updateApplication(application);
		
		//delete report flg = 1
		reportRepository.removeReport(deleteReport);
		
		//insert report
		int result = reportRepository.insertReportBatch(reports);
		return result;
	}
}
