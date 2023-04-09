package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintDeselected 
{
	@Test
	public void deSelectedOpt()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///E:/QSPIDER/SELENIUM/Selenium%20Files/Hotels.html");
		WebElement hotel = driver.findElement(By.id("sh"));
		Select s=new Select(hotel);
		List<WebElement> list = s.getOptions();
		for (WebElement wb : list) {
			if(wb.isSelected()==false)
			{
				System.out.println(wb.getText());
			}
			
		}
	}

}
