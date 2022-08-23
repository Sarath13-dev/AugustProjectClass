package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static void main(String[] args) throws IOException {
		
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenTestng\\src\\test\\resources\\testData\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook  w = new XSSFWorkbook(stream);
		//get Sheet
		Sheet sheet = w.getSheet("Sheet1");
		//get no of rows filled with data
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=0; i<rows; i++) {
			Row row = sheet.getRow(i);
			int cells = row.getPhysicalNumberOfCells();
			for(int j=0; j<cells; j++) {
				Cell cell = row.getCell(j);
				//to determine the type of Data
				int cellType = cell.getCellType();
				//switch(cellType){
				//case STRING:
				//case NUMERIC:
					//}
				if(cellType==1) {
					String stringCellValue = cell.getStringCellValue();
					System.out.println(stringCellValue);
				}
				else if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					System.out.println(dateCellValue);
					//To Change the Date Format
					SimpleDateFormat s = new SimpleDateFormat("dd/MMM/yy");
					String format = s.format(dateCellValue);
					System.out.println(format);
					
				}
				else {
					double numericCellValue = cell.getNumericCellValue();
					System.out.println(numericCellValue);
					//Type Casting
					//Down Conversion Double - long
					long l =(long)numericCellValue;
					System.out.println(l);
				}
			}
		}
		
	}

}
