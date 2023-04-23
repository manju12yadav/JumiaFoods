package com.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class TC_01 
{
	@Test
	public void crossBrowser1()
	{
		Reporter.log("Good Morning",true);
		Reporter.log("Hello",true);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	}
	
}
