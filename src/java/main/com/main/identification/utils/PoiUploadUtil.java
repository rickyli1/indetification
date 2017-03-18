package com.main.identification.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class PoiUploadUtil {

	public static void main(String[] args){
		PoiUploadUtil.getExcelDate("E:\\BaiduYunDownload\\234.xls");
	}
	
	/**
	 * 
	 * @param filename
	 */
	public static void getExcelDate(String filename) {
		try {

			// create a poi workbook from the excel spreadsheet file
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					filename));
//			XSSFWorkbook wb = new XSSFWorkbook();
            HSSFWorkbook wb = new HSSFWorkbook(fs);  
			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				System.out.println("THE sheet number :" + k);

				HSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();

				for (int r = 0; r < rows; r++) {
					HSSFRow row = sheet.getRow(r);
					if (row != null) {
						int cells = row.getPhysicalNumberOfCells();
						System.out.println("THE row:" + row.getRowNum()+"");
						for (short c = 0; c < cells; c++) {
							HSSFCell cell = row.getCell(c);
							if (cell != null) {
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
								System.out.println("CELL col:"
										+ cell.getColumnIndex() + " CELL VALUE:"
										+ value);

							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
