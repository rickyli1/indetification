package com.main.identification.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.main.identification.model.EquipmentResult;
import com.main.identification.model.SubExportResult;
@Service
public class PoiExportService extends AbstractExcelView {
	@Override
	protected void buildExcelDocument(Map<String, Object> obj,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// map的key，在对应的controller中设置
		List<EquipmentResult> list = (List<EquipmentResult>) obj.get("list");
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("学生表一");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow((int) 0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("学号");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("姓名");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("年龄");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("生日");
		cell.setCellStyle(style);

		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow((int) i + 1);
			EquipmentResult eEquipmentResult = (EquipmentResult) list.get(i);
			// 第四步，创建单元格，并设置值
			row.createCell((short) 0).setCellValue(
					eEquipmentResult.getGroupName());
			row.createCell((short) 1).setCellValue(
					eEquipmentResult.getSubGroupName());
			row.createCell((short) 2).setCellValue(
					eEquipmentResult.getEquipmentName());
			row.createCell((short) 3).setCellValue(
					eEquipmentResult.getRepairName());
			cell = row.createCell((short) 4);
			cell.setCellValue(eEquipmentResult.getCompanyNames());
		}
		// 设置下载时客户端Excel的名称
		String filename = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				+ ".xls";
		// 处理中文文件名
		 response.setContentType("application/vnd.ms-excel");
		 response.setHeader("Content-disposition", "attachment;filename="
		 + filename);
		 OutputStream ouputStream = response.getOutputStream();
		 workbook.write(ouputStream);
		 ouputStream.flush();
		 ouputStream.close();
	}

	/**
	 * 描述：根据文件路径获取项目中的文件
	 * 
	 * @param fileDir
	 *            文件路径
	 * @return
	 * @throws Exception
	 */
	public File getExcelDemoFile(String fileDir) throws Exception {
		String classDir = null;
		String fileBaseDir = null;
		File file = null;
		classDir = Thread.currentThread().getContextClassLoader()
				.getResource("/").getPath();
		fileBaseDir = classDir.substring(0, classDir.lastIndexOf("classes"));

		file = new File(fileBaseDir + fileDir);
		if (!file.exists()) {
			throw new Exception("模板文件不存在！");
		}
		return file;
	}

	public Workbook writeNewExcel(File file, String sheetName,
			List<EquipmentResult> list) throws Exception {
		Row row = null;
		Cell cell = null;

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
	              file));
	       // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
		Sheet sheet = wb.getSheet(sheetName);

		// 循环插入数据
		CellStyle cs = setSimpleCellStyle(wb); // Excel单元格样式
		int index =0;
		for (int i = 0; i < list.size(); i++) {
			
			// 按项目实际需求，在该处将对象数据插入到Excel中
			EquipmentResult vo = list.get(i);
			if (null == vo) {
				break;
			}
			
			List<SubExportResult> exportList = vo.getExportList();
			if(exportList != null ){
				if(i != 0){
					index += list.get(i-1).getExportList().size();
				}
				for (int j = 0; j < exportList.size(); j++) {
					
					row = sheet.createRow(j+3+ index);  
					SubExportResult subExportResult = exportList.get(j);
					
					if(j == 0){
						// Cell赋值开始
						cell = row.createCell(0);
						cell.setCellValue(i);
						cell.setCellStyle(cs);
			
						cell = row.createCell(1);
						cell.setCellValue(vo.getGroupName());
						cell.setCellStyle(cs);
			
						cell = row.createCell(2);
						cell.setCellValue(vo.getSubGroupName());
						cell.setCellStyle(cs);
			
						cell = row.createCell(3);
						cell.setCellValue(vo.getEquipmentName());
						cell.setCellStyle(cs);
					}else{
						// Cell赋值开始
						cell = row.createCell(0);
						cell.setCellValue("");
						cell.setCellStyle(cs);
			
						cell = row.createCell(1);
						cell.setCellValue("");
						cell.setCellStyle(cs);
			
						cell = row.createCell(2);
						cell.setCellValue("");
						cell.setCellStyle(cs);
			
						cell = row.createCell(3);
						cell.setCellValue("");
						cell.setCellStyle(cs);
					}
					
					// Cell赋值开始
					cell = row.createCell(4);
					cell.setCellValue(subExportResult.getRepairName());
					cell.setCellStyle(cs);
		
					cell = row.createCell(5);
					cell.setCellValue(subExportResult.getCompanyNames());
					cell.setCellStyle(cs);
		
					cell = row.createCell(6);
					cell.setCellValue(subExportResult.getTimeLimit());
					cell.setCellStyle(cs);
		
					cell = row.createCell(7);
					cell.setCellValue(subExportResult.getRemark());
					cell.setCellStyle(cs);
				}
			}
			if(exportList.size() != 1){
				 /* 
		         * 设定合并单元格区域范围 
		         *  firstRow  0-based 
		         *  lastRow   0-based 
		         *  firstCol  0-based 
		         *  lastCol   0-based 
		         */  
			    CellRangeAddress cra=new CellRangeAddress(3+index, 3+index+exportList.size()-1 , 0, 0);        
		        //在sheet里增加合并单元格  
		        sheet.addMergedRegion(cra);  
		        CellRangeAddress cra1=new CellRangeAddress(3+index, 3+index+exportList.size()-1  , 1, 1);        
		        //在sheet里增加合并单元格  
		        sheet.addMergedRegion(cra1);  
		        CellRangeAddress cra2=new CellRangeAddress(3+index, 3+index+exportList.size()-1  , 2, 2);        
		        //在sheet里增加合并单元格  
		        sheet.addMergedRegion(cra2);  
		        CellRangeAddress cra3=new CellRangeAddress(3+index, 3+index+exportList.size()-1  , 3, 3);        
		        //在sheet里增加合并单元格  
		        sheet.addMergedRegion(cra3);  
			}
		}
		return wb;
	}

	/**
	 * 描述：设置简单的Cell样式
	 * 
	 * @return
	 */
	public CellStyle setSimpleCellStyle(Workbook wb) {
		CellStyle cs = wb.createCellStyle();

		cs.setBorderBottom(CellStyle.BORDER_THIN); // 下边框
		cs.setBorderLeft(CellStyle.BORDER_THIN);// 左边框
		cs.setBorderTop(CellStyle.BORDER_THIN);// 上边框
		cs.setBorderRight(CellStyle.BORDER_THIN);// 右边框

//		cs.setAlignment(CellStyle.ALIGN_CENTER); // 居中
		cs.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中  
		cs.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//垂直  
		return cs;
	}

}
