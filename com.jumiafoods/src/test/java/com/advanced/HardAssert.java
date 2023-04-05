package com.advanced;

import static org.testng.Assert.*;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssert 
{
	@Test
	public void script1()
	{
		Reporter.log("----Script-1---",true);
		Reporter.log("----Script-2---",true);
		Reporter.log("----Script-3---",true);
		assertEquals("Manju", "Manju", "Data is Mismatched");
		Reporter.log("----Script-4---",true);
		fail();
	}
	
	@Test
	public void script2()
	{
		Reporter.log("----Script-5---",true);
		Reporter.log("----Script-6---",true);
		Reporter.log("----Script-7---",true);
		assertNotEquals("Manju", "Manj", "Data is Mismatched");
		Reporter.log("----Script-8---",true);
	}
	
}
