package com.advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowRoot 
{
	@Test
	public void searchDownloads()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote.allow.origins");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("chrome://downloads/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement search = (WebElement)js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('input')");
		search.sendKeys("Jenkins");
		
	}
}
