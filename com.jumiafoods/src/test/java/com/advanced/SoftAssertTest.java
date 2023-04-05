package com.advanced;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest 
{
	
	@Test
	public void script1()
	{
		SoftAssert sa = new SoftAssert();
		Reporter.log("----Script-1---",true);
		Reporter.log("----Script-2---",true);
		Reporter.log("----Script-3---",true);
		sa.assertEquals("Manju", "Manj", "Data is Mismatched");
		Reporter.log("----Script-4---",true);
		sa.assertAll();
	}
	
	@Test
	public void script2()
	{
		SoftAssert sa = new SoftAssert();
		Reporter.log("----Script-5---",true);
		Reporter.log("----Script-6---",true);
		Reporter.log("----Script-7---",true);
		sa.assertNotSame("Manju", "Maju", "Data is Mismatched");
		Reporter.log("----Script-8---",true);
		sa.assertAll();
	}
}
