package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class TeamWithRating
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
	public void teamRating() 
	{
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < teams.size(); i++) 
		{
			al.add(teams.get(i).getText());
		}
		for (String myTeams : al) 
		{
			String rat = "//span[.='"+myTeams+"']/../following-sibling::td[3]";
			String Rating = driver.findElement(By.xpath(rat)).getText();
			System.out.println("Team--->"+myTeams+"Ratings--->"+Rating);
		}

		//		String team="India";
		//		String rating = driver.findElement(By.xpath("//span[.='"+team+"']/../following-sibling::td[3]")).getText();
		//		System.out.println(rating);
	}

}
