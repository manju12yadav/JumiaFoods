package com.advanced;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class TC_01 extends BaseClass
{
	@Test
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
