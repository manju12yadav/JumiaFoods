package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRanking 
{

	public static void main(String[] args) 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> pos = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//tbody/tr/td[4]"));
		List<WebElement> Rating = driver.findElements(By.xpath("//tbody/tr/td[5]"));
//		int count = pos.size();
		for (int i = 0; i <5 ; i++)
		{	
			System.out.println(pos.get(i).getText()+" "+teams.get(i).getText()+"--->"+matches.get(i).getText()+"--->"+points.get(i).getText()+"--->"+Rating.get(i).getText());
		}
		
		
	}

}
