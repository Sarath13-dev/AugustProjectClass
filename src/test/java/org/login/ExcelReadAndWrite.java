package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadAndWrite {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenTestng\\src\\test\\resources\\testData\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet("Sheet1");
		Sheet createSheet = w.createSheet("Sheet2");
		for(int i=0; i<sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Row createRow = sheet.createRow(i);
			for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				Cell createCell = row.createCell(j);
				int cellType = cell.getCellType();
				if(cellType==1) {
					String stringCellValue = cell.getStringCellValue();
					createCell.setCellValue(stringCellValue);
				}
				else if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					String format = s.format(dateCellValue);
					createCell.setCellValue(format);
					
				}
				
				else {
					double numericCellValue = cell.getNumericCellValue();
					String valueOf = String.valueOf(numericCellValue);
					createCell.setCellValue(valueOf);
				}
			}
		}
		
		FileOutputStream os = new FileOutputStream(f);
		w.write(os);
		
	}

}
