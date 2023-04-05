package com.advanced;

import org.testng.annotations.DataProvider;

import com.GenericUtilities.ExcelUtility;

public class ReadFromExcelUsingDP
{
	@DataProvider
	public Object[][] setOfData() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readSetOfData("DP");
		return value;
		
	}
	
	
}
