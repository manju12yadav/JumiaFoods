package com.advanced;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetMulDataToExcelTest 
{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		  Workbook wb = WorkbookFactory.create(fis); 
//		  	Sheet sh = wb.createSheet("My List");
		  	Sheet sh = wb.getSheet("My List");
		
		Object mydata[][]= { 	{"Id","Name","Desig"},
								{"341","Siri","Developer "},
								{"363","Manju","Tester"},
								{"360","Kiran","DevOps"},
								{"364","Kalaa","Docter"},
								{"369","Balaji","Business"}
		};
		int rows = mydata.length;
		int cols = mydata[0].length;
		
		System.out.println(rows);
		System.out.println(cols);
		
		for (int i = 0; i < rows ; i++) 
		{
		Row row = sh.createRow(i);
			for (int j = 0; j < cols; j++) 
			{
				 Cell cel = row.createCell(j);
				Object data = mydata[i][j];
				
				if(data instanceof String)
					cel.setCellValue((String)data);
				if(data instanceof Integer)
					cel.setCellValue((Integer)data);
				
			}
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
		
		System.out.println("Excel Created");
		
		
	}

}

//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//Workbook wb = WorkbookFactory.create(fis);
//Sheet sh = wb.getSheet("Emp");
//for (int i = 0; i <=10; i++) 
//{
//	sh.createRow(i).createCell(0).setCellValue(Math.random());
//	for (int j =i; j<=i; j++) 
//	{
//		sh.createRow(j).createCell(1).setCellValue(Math.random());	
//	}
//}
//FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
//wb.write(fos);
//wb.close();





//FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
//XSSFWorkbook wb = new XSSFWorkbook();
//XSSFSheet sheet = wb.createSheet("Emp List");
//
//Object empdata[][]= { 	{"EmpId","EName","Designation"},
//						{341,"Priya","Develop Engineer"},
//						{363,"Manju","Test Enginner"},
//						{360,"Deevu","DevOps Engineer"}
//};
//int rows = empdata.length;
//int cols = empdata[0].length;
//
//System.out.println(rows);
//System.out.println(cols);
//
//for (int i = 0; i < rows ; i++) 
//{
//	XSSFRow row = sheet.createRow(i);
//	for (int j = 0; j < cols; j++) 
//	{
//		XSSFCell cel = row.createCell(j);
//		Object value = empdata[i][j];
//		
//		if(value instanceof String)
//			cel.setCellValue((String)value);
//		if(value instanceof Integer)
//			cel.setCellValue((Integer)value);
//		
//	}
//}
//FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
//wb.write(fos);
//fos.close();
//
//System.out.println("Excel Created");
