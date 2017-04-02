package com.main.identification.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.Application;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.Report;
import com.main.identification.repository.CommonRepository;
import com.main.identification.repository.ConstantRepository;
import com.main.identification.utils.Constant;
import com.main.identification.utils.TimeUtils;

@Service
public class PoiUploadService {
	
	@Autowired
	public ConstantRepository constantRepository;
	
	@Autowired
	private CommonService commonService;

	/**
	 * 设备基础信息导入测试接口
	 * @param args
	 */
//	public static void main(String[] args) {
//		new PoiUploadService().getExcelDate("E:\\BaiduYunDownload\\234.xls");
//	}

	/**
	 * 
	 * @param filename
	 */
	public List getExcelDate(String filename) {
		HashMap<String, String> levelMap = findConstantLevel();
		List ls = new ArrayList();
		HashMap<String, ConstantModel> parentMap = new HashMap<String, ConstantModel>();
		HashMap<String, ConstantModel> childrenMap = new HashMap<String, ConstantModel>();
		HashMap<String, EquipmentModel> equipmentMap = new HashMap<String, EquipmentModel>();
		HashMap<String, Company> companyMap = new HashMap<String, Company>();
		HashMap<String, Application> applicationMap = new HashMap<String, Application>();
		HashMap<String, Report> reportMap = new HashMap<String, Report>();
		Application application = new Application();
		String date = TimeUtils.getStringFromTime(new Date(), TimeUtils.FORMAT_DATE_NO);
		String remark = date +" " +Constant.IMPORT_REMARK;
		String applicationNo = date+"_" +  String.valueOf(commonService.createSequenceId(Constant.APPLICATION_SEQ));
		application.setApplicationNo(applicationNo);
		application.setRemark(remark);
		application.setApplicationDate(date);
		applicationMap.put(date, application);
		try {
			// create a poi workbook from the excel spreadsheet file
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					filename));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				System.out.println("THE sheet number :" + k);
				HSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();
				ConstantModel cm = new ConstantModel(); 
				String parentValue ="";
				String parentNo ="";
				String childrenNo ="";
				String companyNo ="";
				String equipmentNo ="";
				String equipmentName ="";
				String levelNo ="";
				for (int r = Constant.EXCEL_START_ROW; r < rows; r++) {
					HSSFRow row = sheet.getRow(r);
					if (row != null && r>=Constant.EXCEL_START_ROW) {
						int cells = row.getPhysicalNumberOfCells();
						System.out.println("THE row:" + row.getRowNum() + "");
					
						for (short c = 0; c < cells; c++) {
							HSSFCell cell = row.getCell(c);
							if (cell != null && c>=Constant.EXCEL_START_COLUMN ) {
								String value = null;

								switch (cell.getCellType()) {

								case HSSFCell.CELL_TYPE_FORMULA:
									value = "FORMULA ";
									break;

								case HSSFCell.CELL_TYPE_NUMERIC:
									value = ""+ cell.getNumericCellValue();
									break;

								case HSSFCell.CELL_TYPE_STRING:
									value =  cell.getStringCellValue();
									break;

								default:
								}
//								if(StringUtils.isEmpty(value)){
//									break;
//								}
								if(c==1 && !StringUtils.isEmpty(value)){
									if(!StringUtils.isEmpty(value)){
										parentValue = value;
									}
									if(!parentMap.containsKey(parentValue)){
										cm = new ConstantModel();
										cm.setConstantType(Constant.PARENT_TYPE);
										parentNo = Constant.PARENT_FLAG + String.valueOf(commonService.createSequenceId(Constant.PARENT_SEQ));
	//										parentNo = Constant.PARENT_FLAG;
										cm.setConstantNo(parentNo);
										cm.setConstantName(value);
										parentMap.put(parentValue, cm);
									}
									
								}
								if(c==2 && !StringUtils.isEmpty(value)) {
									ConstantModel parentModel =  parentMap.get(parentValue);
									String groupNo = parentModel.getConstantNo();
									String groupName = parentModel.getConstantName();
									if(!parentMap.containsKey(value+groupName)){
										ConstantModel scm = new ConstantModel();
										scm.setConstantType(Constant.CHILDREN_TYPE);
										childrenNo = Constant.CHILDREN_FLAG +  String.valueOf(commonService.createSequenceId(Constant.CHILDREN_SEQ));
//										childrenNo = Constant.CHILDREN_FLAG;
										
										scm.setConstantNo(childrenNo);
										scm.setConstantName(value);
										scm.setParentNo(groupNo);
										childrenMap.put(value+groupName, scm);
									}
								}
								if(c==3 && !StringUtils.isEmpty(value)){
									ConstantModel parentModel =  parentMap.get(parentValue);
									String groupNo = parentModel.getConstantNo();
									EquipmentModel epuipModel =  new EquipmentModel(); 
									//创建equipment 序列
									equipmentNo = Constant.COMPANY_FLAG + String.valueOf(commonService.createSequenceId(Constant.COMPANY_SEQ));
									epuipModel.setEquipmentNo(equipmentNo);
									epuipModel.setEquipmentName(value);
									epuipModel.setGroupNo(groupNo);
									epuipModel.setSubGroupNo(childrenNo);
									equipmentMap.put(value, epuipModel);
									equipmentName = value;
								}
								if(c==4&& !StringUtils.isEmpty(value)){
									levelNo = levelMap.get(value);
								}
								//COMPANY 字段值
								if(c==5 && !StringUtils.isEmpty(value)){
									if(!StringUtils.isEmpty(value)){
										List<String> companyNames = Arrays.asList(value.split(Constant.splitConstant));
										for(String name:companyNames){
											if(!companyMap.containsKey(name)){
												Company commapny =  new Company(); 
												companyNo = Constant.EQUIPMENT_FLAG
														+ String.valueOf(commonService.createSequenceId(Constant.EQUIPMENT_SEQ));
												commapny.setCompanyNo(companyNo);
												commapny.setCompanyName(name);
												companyMap.put(name, commapny);
											}
											String key = name+equipmentName+levelNo;
											if(!reportMap.containsKey(key)){
												Company commapny = companyMap.get(name);
												Report report =  new Report(); 
												String reportNo = Constant.REPORT_FLAG
														+ String.valueOf(commonService.createSequenceId(Constant.EQUIPMENT_SEQ));
																	report.setApplicationDate(date);
												report.setRemark(remark);
												report.setReportNo(reportNo);
												report.setCompanyNo(commapny.getCompanyNo());
												report.setEquipmentNo(equipmentNo);
												report.setRepairLevel(levelNo);
												report.setResult(Constant.RESULT);
												report.setApplicationNo(applicationNo);
												report.setRemark(remark);
												report.setRow(row.getRowNum());
												reportMap.put(key, report);
											}
										}
									}
									
								}
								//期限 字段值
								if(c==6 && !StringUtils.isEmpty(value)){
									reportMap = setReportLimit(value,reportMap,row.getRowNum());
								}
								
								System.out.println("CELL col:"+ cell.getColumnIndex()+ " CELL VALUE:" + value);

							}
						}
					}
				}
				System.out.println("worksheet  END :"+ k);
			}
			ls.add(0, parentMap);    	//常量父类
			ls.add(1, childrenMap);     //常量子类
			ls.add(2, equipmentMap);    //设备
			ls.add(3, companyMap);      //公司
			ls.add(4, applicationMap);  //申请
			ls.add(5, reportMap);       //报告
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * 更新报告期限
	 * @param timeLimit 期限
	 * @param reportMap 报告列表
	 * @return 报告列表
	 */
	private HashMap<String, Report> setReportLimit(String timeLimit,
			HashMap<String, Report> reportMap, int row) {
		for (Map.Entry<String, Report> entry : reportMap.entrySet()) {
			Report report = entry.getValue();
			if(report.getRow() == row){
				report.setTimeLimit(timeLimit);
			}
        }
   	
		return reportMap;
	}

	
	/**
	 * 获取维修级别键值对
	 * @return  hm
	 */
	private HashMap<String, String> findConstantLevel() {
		HashMap<String, String> hm = new HashMap<String, String>();
		ConstantModel constantModelPara = new ConstantModel(); 
		constantModelPara.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> list = constantRepository.findConstantMap(constantModelPara);
		for(ConstantModel constantModel : list){
			hm.put(constantModel.getConstantName(), constantModel.getConstantNo());
		}
		return hm;
	}
}
