package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcelTest 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Food");
		int count = sh.getLastRowNum();
		for (int i = 1; i <=count ; i++) 
		{
			String Resto = sh.getRow(i).getCell(0).getStringCellValue();
			String food = sh.getRow(i).getCell(1).getStringCellValue();
			String price = sh.getRow(i).getCell(2).getStringCellValue();
			
			System.out.println(Resto +"---------->"+ food +"---------->"+ price);
		}
		
		
	}

}
