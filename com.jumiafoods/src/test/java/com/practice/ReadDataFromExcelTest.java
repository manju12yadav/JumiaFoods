package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest 
{

	public static void main(String[] args) throws Throwable 
	{
//		create object for physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");

//		get Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
//		get Sheet
		Sheet sh = wb.getSheet("Details");
		
//		get Row
		Row rw = sh.getRow(1);
		
//		get Cell
		Cell cel = rw.getCell(0);
		
//		get Cell value
		String Value = cel.getStringCellValue();
		
		System.out.println(Value);
	}

}
