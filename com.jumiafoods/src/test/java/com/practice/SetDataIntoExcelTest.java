package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataIntoExcelTest {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet("Details").createRow(1).createCell(0).setCellValue("TestYantra");
	wb.getSheet("Details").createRow(1).createCell(1).setCellValue("Kathriguppe");
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb.write(fos);
	wb.close();
	}

}
