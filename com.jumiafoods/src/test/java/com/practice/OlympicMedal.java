package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicMedal 
{

	public static void main(String[] args) 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		List<WebElement> countryName = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		List<WebElement> goldMedal = driver.findElements(By.xpath("//div[@title='Gold']"));
		List<WebElement> silverMedal = driver.findElements(By.xpath("//div[@title='Silver']"));
		List<WebElement> bronzeMedal = driver.findElements(By.xpath("//div[@title='Bronze']"));
		List<WebElement> totalMedals = driver.findElements(By.xpath("//span[@data-cy='country-name']/../following-sibling::div[4]"));
		
		int count = countryName.size();
		System.out.println(count);
		
		for (int i = 0; i < count; i++) 
		{
			System.out.println((i+1)+") "+countryName.get(i).getText()+"------>"+goldMedal.get(i).getText()+"  "+silverMedal.get(i).getText()+"  "+bronzeMedal.get(i).getText()+"  "+totalMedals.get(i).getText());
		}
		driver.close();
	}

}
