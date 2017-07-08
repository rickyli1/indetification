package com.main.identification.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.main.identification.controller.BaseInfoUploadController;
import com.main.identification.model.Application;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.Report;
import com.main.identification.repository.ApplicationRepository;
import com.main.identification.repository.CompanyRepository;
import com.main.identification.repository.ConstantRepository;
import com.main.identification.repository.EquipmentRepository;
import com.main.identification.repository.ReportRepository;
import com.main.identification.utils.Constant;
import com.main.identification.utils.TimeUtils;

@Service
//@Transactional(rollbackFor=Exception.class)  
public class PoiUploadService {

	private static Logger logger = Logger
			.getLogger(BaseInfoUploadController.class);

	@Autowired
	public ConstantRepository constantRepository;

	@Autowired
	private CommonService commonService;

	@Autowired
	public EquipmentRepository equipmentRepository;

	@Autowired
	public CompanyRepository companyRepository;

	@Autowired
	public ApplicationRepository applicationRepository;

	@Autowired
	public ReportRepository reportRepository;

	/**
	 * 设备基础信息导入测试接口
	 * 
	 * @param args
	 */
	// public static void main(String[] args) {
	// new PoiUploadService().getExcelDate("E:\\BaiduYunDownload\\234.xls");
	// }

	/**
	 * 
	 * @param filename
	 */
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List getExcelDate(String filename) {
		HashMap<String, String> levelMap = findConstantLevel();
		List ls = new ArrayList();
		HashMap<String, ConstantModel> parentMap = new HashMap<String, ConstantModel>();
		HashMap<String, ConstantModel> childrenMap = new HashMap<String, ConstantModel>();
		HashMap<String, EquipmentModel> equipmentMap = new HashMap<String, EquipmentModel>();
		HashMap<String, Company> companyMap = new HashMap<String, Company>();
		HashMap<String, Application> applicationMap = new HashMap<String, Application>();
		HashMap<String, Report> reportMap = new HashMap<String, Report>();
//		Application application = new Application();
		String date = TimeUtils.getStringFromTime(new Date(),
				TimeUtils.FORMAT_DATE_NO);
		String remark = date + " " + Constant.IMPORT_REMARK;
		
//		application.setApplicationNo(applicationNo);
//		application.setRemark(remark);
//		application.setApplicationDate(date);
//		application.setOriginFlag(Constant.ORIGIN_FLAG_IMPORT);// 導入標識
//		applicationMap.put(date, application);
		try {
			// create a poi workbook from the excel spreadsheet file
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					filename));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				logger.info("THE sheet number :" + k);
				HSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();
				ConstantModel cm = new ConstantModel();
				String parentValue = "";
				String parentNo = "";
				String childrenNo = "";
				String companyNo = "";
				String equipmentNo = "";
				String equipmentName = "";
				String levelNo = "";
				for (int r = Constant.EXCEL_START_ROW; r < rows; r++) {
					HSSFRow row = sheet.getRow(r);
					if (row != null && r >= Constant.EXCEL_START_ROW) {
						int cells = row.getPhysicalNumberOfCells();
						logger.info("THE row:" + row.getRowNum() + "");

						for (short c = 0; c < cells; c++) {
							HSSFCell cell = row.getCell(c);
							if (cell != null
									&& c >= Constant.EXCEL_START_COLUMN) {
								String value = null;

								switch (cell.getCellType()) {

								case HSSFCell.CELL_TYPE_FORMULA:
									value = "FORMULA ";
									break;

								case HSSFCell.CELL_TYPE_NUMERIC:
									value = "" + cell.getNumericCellValue();
									break;

								case HSSFCell.CELL_TYPE_STRING:
									value = cell.getStringCellValue();
									break;

								default:
								}
								if(!StringUtils.isEmpty(value)){
									value = value.trim();
								}
								if (c == 1 && !StringUtils.isEmpty(value)) {
									if (!StringUtils.isEmpty(value)) {
										parentValue = value;
									}
									if (!parentMap.containsKey(parentValue)) {
										cm = new ConstantModel();
										cm.setConstantType(Constant.PARENT_TYPE);
										parentNo = Constant.PARENT_FLAG
												+ String.valueOf(commonService
														.createSequenceId(Constant.PARENT_SEQ));
										// parentNo = Constant.PARENT_FLAG;
										cm.setConstantNo(parentNo);
										cm.setConstantName(value);
										parentMap.put(parentValue, cm);
									}

								}
								if (c == 2 && !StringUtils.isEmpty(value)) {
									ConstantModel parentModel = parentMap
											.get(parentValue);
									String groupNo = parentModel
											.getConstantNo();
									String groupName = parentModel
											.getConstantName();
									if (!childrenMap.containsKey(value
											+ groupName)) {
										ConstantModel scm = new ConstantModel();
										scm.setConstantType(Constant.CHILDREN_TYPE);
										childrenNo = Constant.CHILDREN_FLAG
												+ String.valueOf(commonService
														.createSequenceId(Constant.CHILDREN_SEQ));
										// childrenNo = Constant.CHILDREN_FLAG;

										scm.setConstantNo(childrenNo);
										scm.setConstantName(value);
										scm.setParentNo(groupNo);
										childrenMap.put(value + groupName, scm);
									}
								}
								if (c == 3 && !StringUtils.isEmpty(value)) {
									ConstantModel parentModel = parentMap
											.get(parentValue);
									String groupNo = parentModel
											.getConstantNo();
									EquipmentModel epuipModel = new EquipmentModel();
									// 创建equipment 序列
									equipmentNo = Constant.EQUIPMENT_FLAG
											+ String.valueOf(commonService
													.createSequenceId(Constant.EQUIPMENT_SEQ));
									epuipModel.setEquipmentNo(equipmentNo);
									epuipModel.setEquipmentName(value);
									epuipModel.setGroupNo(groupNo);
									epuipModel.setSubGroupNo(childrenNo);
									epuipModel.setRemark(remark);
									equipmentMap.put(value, epuipModel);
									equipmentName = value;
								}
								if (c == 4 && !StringUtils.isEmpty(value)) {
									levelNo = levelMap.get(value);
								}
								// COMPANY 字段值
								if (c == 5 && !StringUtils.isEmpty(value)) {
									if (!StringUtils.isEmpty(value)) {
										List<String> companyNames = Arrays
												.asList(value
														.split(Constant.splitConstant));
										for (String name : companyNames) {
											if (!companyMap.containsKey(name)) {
												Company commapny = new Company();
												companyNo = Constant.COMPANY_FLAG
														+ String.valueOf(commonService
																.createSequenceId(Constant.COMPANY_SEQ));
												commapny.setCompanyNo(companyNo);
												commapny.setCompanyName(name);
												companyMap.put(name, commapny);
											}
											String key = name + equipmentName
													+ levelNo;
											if (!reportMap.containsKey(key)) {
												Company commapny = companyMap
														.get(name);
												String applicationNo = date
														+ "_"
														+ String.valueOf(commonService
																.createSequenceId(Constant.APPLICATION_SEQ));
												Application application = new Application();
												application.setApplicationNo(applicationNo);
												application.setCompanyNo(commapny.getCompanyNo());
												application.setRemark(remark);
												application.setApplicationDate(date);
												application.setOriginFlag(Constant.ORIGIN_FLAG_IMPORT);// 導入標識
												applicationMap.put(key, application);
												
												Report report = new Report();
												String reportNo = Constant.REPORT_FLAG
														+ String.valueOf(commonService
																.createSequenceId(Constant.REPORT_SEQ));
												report.setApplicationDate(date);
												report.setRemark(remark);
												report.setReportNo(reportNo);
												report.setCompanyNo(commapny
														.getCompanyNo());
												report.setEquipmentNo(equipmentNo);
												report.setRepairLevel(levelNo);
												report.setResult(Constant.RESULT_FLAG_TRUE);// 0
																							// 不合格
																							// //1
																							// 合格
												report.setApplicationNo(applicationNo);
												report.setRemark(remark);
												report.setRow(row.getRowNum());
												reportMap.put(key, report);
											}
										}
									}

								}
								// 期限 字段值
								if (c == 6 && !StringUtils.isEmpty(value)) {
									String valueLimitStr = value
											.substring(0, 4);
									reportMap = setReportLimit(valueLimitStr,
											reportMap, row.getRowNum());
								}

								logger.info("CELL col:" + cell.getColumnIndex()
										+ " CELL VALUE:" + value);

							}
						}
					}
				}
				logger.info("worksheet  END :" + k);
			}
			ls.add(0, parentMap); // 常量父类
			ls.add(1, childrenMap); // 常量子类
			ls.add(2, equipmentMap); // 设备
			ls.add(3, companyMap); // 公司
			ls.add(4, applicationMap); // 申请
			ls.add(5, reportMap); // 报告
		} catch (Exception e) {
			logger.error("PoiUploadService failed:" + e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * 更新报告期限
	 * 
	 * @param timeLimit
	 *            期限
	 * @param reportMap
	 *            报告列表
	 * @return 报告列表
	 */
	private HashMap<String, Report> setReportLimit(String timeLimit,
			HashMap<String, Report> reportMap, int row) {
		for (Map.Entry<String, Report> entry : reportMap.entrySet()) {
			Report report = entry.getValue();
			if (report.getRow() == row) {
				report.setTimeLimit(timeLimit);
			}
		}

		return reportMap;
	}

	/**
	 * 获取维修级别键值对
	 * 
	 * @return hm
	 */
	private HashMap<String, String> findConstantLevel() {
		HashMap<String, String> hm = new HashMap<String, String>();
		ConstantModel constantModelPara = new ConstantModel();
		constantModelPara.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> list = constantRepository
				.findConstantMap(constantModelPara);
		for (ConstantModel constantModel : list) {
			hm.put(constantModel.getConstantName(),
					constantModel.getConstantNo());
		}
		return hm;
	}

//	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void batchExportExcelDate(List ls) throws RuntimeException{
		// 删除之前导入的数据
		if(true){
			Report report = new Report();
			Application application = new Application();
			ConstantModel constant = new ConstantModel();
			constant.setAttribute1(Constant.REPAIR_LEVEL);
			constantRepository.deleteConstant(constant);
			EquipmentModel equip = new EquipmentModel();
			Company company = new Company();
			equipmentRepository.deleteEquipment(equip);
			companyRepository.deleteCompany(company);
			applicationRepository.deleteApplication(application);
			reportRepository.deleteReport(report);
	    }
//		deleteAllBaseInfoData();
		try {
			List<ConstantModel> constantList = new ArrayList<ConstantModel>();
			List<Company> companyList = new ArrayList<Company>();
			List<EquipmentModel> equipmentList = new ArrayList<EquipmentModel>();
			List<Report> reportList = new ArrayList<Report>();
			if (ls != null) {
				HashMap<String, ConstantModel> parentMap = (HashMap<String, ConstantModel>) ls.get(0);
				for (Map.Entry<String, ConstantModel> entry : parentMap
						.entrySet()) {
					ConstantModel cm = entry.getValue();
					cm.setCreateBy("-1");
					cm.setLastModifyBy("-1");
					// constantsService.addConstantModel(cm);
					constantList.add(cm);
				}

				HashMap<String, ConstantModel> childrenMap = (HashMap<String, ConstantModel>) ls.get(1);
				for (Map.Entry<String, ConstantModel> entry : childrenMap
						.entrySet()) {
					ConstantModel cm = entry.getValue();
					cm.setCreateBy("-1");
					cm.setLastModifyBy("-1");
					// constantsService.addConstantModel(cm);
					constantList.add(cm);
				}

				constantRepository.batchAddConstantModel(constantList);

				HashMap<String, EquipmentModel> equipmentMap = (HashMap<String, EquipmentModel>) ls.get(2);
				for (Map.Entry<String, EquipmentModel> entry : equipmentMap
						.entrySet()) {
					EquipmentModel em = entry.getValue();
					em.setCreateBy("-1");
					em.setLastModifyBy("-1");
					equipmentList.add(em);
					// equipmentService.addEquipmentModel(em);
				}
				equipmentRepository.batchAddEquipmentModel(equipmentList);
				// 获得companymap，调用接口插入相关数据
				// HashMap<String, String> companyMap = (HashMap<String,
				// String>) ls.get(3);
				// companyUploadService.addCompanyModel(companyMap);

				HashMap<String, Company> companyMap = (HashMap<String, Company>) ls.get(3);
				for (Map.Entry<String, Company> entry : companyMap.entrySet()) {
					Company company = entry.getValue();
					company.setCreateBy("-1");
					company.setLastModifyBy("-1");
					company.setCompanyType("0");
					company.setCompanyCode(company.getCompanyName()); // TODO 
					companyList.add(company);
					// companyUploadService.insertCompany(em);
				}
				companyRepository.insertCompanyBatch(companyList);

				HashMap<String, Application> applicationMap = (HashMap<String, Application>) ls.get(4);
				for (Map.Entry<String, Application> entry : applicationMap
						.entrySet()) {
					Application application = entry.getValue();
					application.setCreateBy("-1");
					application.setLastModifyBy("-1");
					applicationRepository.insertApplication(application);
				}

				HashMap<String, Report> reportMap = (HashMap<String, Report>) ls.get(5);
				for (Map.Entry<String, Report> entry : reportMap.entrySet()) {
					Report report = entry.getValue();
					report.setCreateBy("-1");
					report.setLastModifyBy("-1");
					reportList.add(report);
				}
				reportRepository.insertReportBatch(reportList);
			}
		} catch (Exception e) {
			throw new RuntimeException(); 
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			e.printStackTrace();
		}
	}

	/**
     * 
     */
	private void deleteAllBaseInfoData() {
		Report report = new Report();
		Application application = new Application();
		ConstantModel constant = new ConstantModel();
		constant.setAttribute1(Constant.REPAIR_LEVEL);
		constantRepository.deleteConstant(constant);
		EquipmentModel equip = new EquipmentModel();
		Company company = new Company();
		equipmentRepository.deleteEquipment(equip);
		companyRepository.deleteCompany(company);
		applicationRepository.deleteApplication(application);
		reportRepository.deleteReport(report);
	}
}
