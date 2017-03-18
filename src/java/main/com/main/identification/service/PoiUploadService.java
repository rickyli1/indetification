package com.main.identification.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.repository.ConstantRepository;
import com.main.identification.utils.Constant;

@Service
public class PoiUploadService {
	
	@Autowired
	public ConstantRepository constantRepository;

	/**
	 * 设备基础信息导入测试接口
	 * @param args
	 */
	public static void main(String[] args) {
		new PoiUploadService().getExcelDate("E:\\BaiduYunDownload\\234.xls");
	}

	/**
	 * 
	 * @param filename
	 */
	public List getExcelDate(String filename) {
		List ls = new ArrayList();
		HashMap<String, ConstantModel> parentMap = new HashMap<String, ConstantModel>();
		HashMap<String, ConstantModel> childrenMap = new HashMap<String, ConstantModel>();
		HashMap<String, EquipmentModel> equipmentMap = new HashMap<String, EquipmentModel>();
		try {
			// create a poi workbook from the excel spreadsheet file
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					filename));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				System.out.println("THE sheet number :" + k);
				HSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();

				for (int r = Constant.EXCEL_START_ROW; r < rows; r++) {
					HSSFRow row = sheet.getRow(r);
					if (row != null && r>=Constant.EXCEL_START_ROW) {
						int cells = row.getPhysicalNumberOfCells();
						System.out.println("THE row:" + row.getRowNum() + "");
						ConstantModel cm = new ConstantModel(); 
						String parentValue ="";
						String parentNo ="";
						String childrenNo ="";
						for (short c = 0; c < cells; c++) {
							HSSFCell cell = row.getCell(c);
							if (cell != null && c>=Constant.EXCEL_START_COLUMN ) {
								String value = null;

								switch (cell.getCellType()) {

								case HSSFCell.CELL_TYPE_FORMULA:
									value = "FORMULA ";
									break;

								case HSSFCell.CELL_TYPE_NUMERIC:
									value = "NUMERIC value="
											+ cell.getNumericCellValue();
									break;

								case HSSFCell.CELL_TYPE_STRING:
									value = "STRING value="
											+ cell.getStringCellValue();
									break;

								default:
								}
								if(StringUtils.isEmpty(value)){
									break;
								}
								if(c==1 ){
									parentValue = value;
									if(!parentMap.containsKey(value)){
										cm.setConstantType(Constant.PARENT_TYPE);
										parentNo = Constant.PARENT_FLAG + String.valueOf(constantRepository.findParentSeq());
//										parentNo = Constant.PARENT_FLAG;
										cm.setConstantNo(parentNo);
										cm.setConstantName(value);
										parentMap.put(parentValue, cm);
									}
								}
								if(c==2){
									ConstantModel parentModel =  parentMap.get(parentValue);
									String groupNo = parentModel.getConstantNo();
									String groupName = parentModel.getConstantName();
									if(!parentMap.containsKey(value+groupName)){
										ConstantModel scm = new ConstantModel();
										scm.setConstantType(Constant.CHILDREN_TYPE);
										childrenNo = Constant.CHILDREN_FLAG + String.valueOf(constantRepository.findChildrenSeq());
//										childrenNo = Constant.CHILDREN_FLAG;
										
										scm.setConstantNo(childrenNo);
										scm.setConstantName(value);
										scm.setParentNo(groupNo);
										childrenMap.put(value+groupName, scm);
									}
								}
								if(c==3){
									EquipmentModel epuipModel =  new EquipmentModel(); 
									epuipModel.setEquipmentName(value);
									epuipModel.setGroupNo(parentNo);
									epuipModel.setSubGroupNo(childrenNo);
									equipmentMap.put(value, epuipModel);
								}
								
								System.out.println("CELL col:"+ cell.getColumnIndex()+ " CELL VALUE:" + value);

							}
						}
					}
				}
				System.out.println("worksheet  END :"+ k);
			}
			ls.add(0, parentMap);
			ls.add(1, childrenMap);
			ls.add(2, equipmentMap);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}
}
