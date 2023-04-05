package com.advanced;

import org.testng.annotations.DataProvider;

public class ReadFromDataProvider {

	@DataProvider
	public Object[][] data()
	{
		Object[][] obArr=new Object[4][2];
		obArr[0][0]=200;
		obArr[0][1]="Dhum Biriyani";
		
		obArr[1][0]=199;
		obArr[1][1]="Chicken Kabab";
		
		obArr[2][0]=150;
		obArr[2][1]="Mutton Sambar";
		
		obArr[3][0]=95;
		obArr[3][1]="Fish Fry";
		
		return obArr;
	}
}
