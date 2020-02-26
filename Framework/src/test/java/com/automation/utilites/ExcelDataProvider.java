package com.automation.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook Wb;
	
	public ExcelDataProvider()
	{
		File src= new File("./TestData/Data.xlsx");
		
		
		try {
			FileInputStream fis = new FileInputStream(src);
			 Wb= new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			
			System.out.println("Unable to read Excel file"+ e.getMessage());
			
		}
		
	}
	//Method Overloading- where method name is same but parameters Datatypes are same 
	public String getStringData(int sheetIndex, int row , int column)
	{
		return Wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetname, int row , int column)
	{
		return Wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	
	public double getNumericData(String sheetname, int row , int column)
	{
		return Wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();	
	}

}
