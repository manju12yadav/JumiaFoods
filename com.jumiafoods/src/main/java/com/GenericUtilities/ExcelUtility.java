package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility 
{
	/**
	 * This method is used to Read the data From Excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	
	public String readFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String value= c.getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to Get the last Row Num from Excel
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		return count;
		
	}
	
	/**
	 * This method is used to Write Data to Excel File
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	public void writeToExcel(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IPathConstants.EXCELPATH);
		wb.write(fos);
		
	}
	
	/**
	 * This method is used to Read/Get the Multiple data from the excel in Key and Value Pair
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	
	public HashMap<String,String> readMulFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <=count; i++) 
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	/**
	 * This method is used to Read/Get the Multiple data from the excel using Object Array(Data Provider)
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 * @author Manjunath Yadav
	 */
	
	public Object[][] readSetOfData(String sheetName) throws Throwable, Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.EXCELPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow][lastCell];
		for (int i = 0; i <= lastRow; i++) 
		{
			for (int j = 0; j <lastCell; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
	}
	
	
}
