package com.advanced;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_02 extends BaseClass
{
	@Test()
	public void crossBrowser1()
	{
		Reporter.log("Good Morning",true);
		Assert.fail();
		Reporter.log("Hello",true);
	}
	
	
	@Test(dependsOnMethods = "crossBrowser1")
	public void crossBrowser2()
	{
		Reporter.log("Bye",true);
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver=new EdgeDriver();
//		driver.get("https://www.facebook.com/");
	}
}
