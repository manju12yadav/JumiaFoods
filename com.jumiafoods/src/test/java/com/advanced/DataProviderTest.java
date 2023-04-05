package com.advanced;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest 
{

	@DataProvider()
	public Object[][] getDetails()
	{
		Object[][] obArr=new Object[2][3];
		obArr[0][0]=361;
		obArr[0][1]="Kiran";
		obArr[0][2]="Sr test Engineer";
		
		obArr[1][0]=363;
		obArr[1][1]="Kalaa";
		obArr[1][2]="Test Engineer";
		return obArr;
	}
	
	@Test(dataProvider = "getDetails")
	public void empDetails(int id,String name,String desig)
	{
		Reporter.log("Emp Id-->"+id+" Emp Name-->"+name+" Emp Desig -->"+desig,true);
		
	}
}
