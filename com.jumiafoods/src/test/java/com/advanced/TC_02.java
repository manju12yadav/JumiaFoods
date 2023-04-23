package com.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02 
{
//	@Test()
//	public void crossBrowser1()
//	{
//		Reporter.log("Good Morning",true);
//		Assert.fail();
//		Reporter.log("Hello",true);
//	}
	
	
	@Test(dependsOnMethods = "crossBrowser1")
	public void crossBrowser2()
	{
		Reporter.log("Bye",true);
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
}
