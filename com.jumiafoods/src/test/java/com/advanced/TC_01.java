package com.advanced;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class TC_01 extends BaseClass
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
	public void crossBrowser1()
	{
		Reporter.log("Good Morning",true);
		Assert.fail();
		Reporter.log("Hello",true);
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver=new FirefoxDriver();
//		driver.get("https://www.facebook.com/");
	}
	
}
