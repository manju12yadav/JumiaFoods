package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class VerifyTeamPresent 
{
	@Test
	public void teamPresent() 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String teamName = "India";
		
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		boolean flag=false;
		for (WebElement name : teams) 
		{
			String text = name.getText();
			if(text.equals(teamName))
			{
				System.out.println("is Present");
				flag=true;
				break;
			}
			if(!flag)
			{
				System.out.println("not Present");
			}
		}
	}

}
