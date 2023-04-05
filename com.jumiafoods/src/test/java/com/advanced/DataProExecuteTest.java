package com.advanced;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class DataProExecuteTest 
{
	@Test(dataProviderClass = ReadFromDataProvider.class, dataProvider = "data", enabled = false)
	public void executeTest(int price,String dish)
	{
		Reporter.log(dish+"-->"+price+"Rs",true);
	}
	
	@Test(dataProviderClass = ReadFromExcelUsingDP.class, dataProvider = "data", enabled = true)
	public void executeTest(String id,String name,String desig)
	{
		Reporter.log(id+" "+name+" "+desig,true);
	}
	
}
