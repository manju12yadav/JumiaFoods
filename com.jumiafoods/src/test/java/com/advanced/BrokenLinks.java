package com.advanced;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks 
{
	@Test
	public void test() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://github.com/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count = allLinks.size();
		System.out.println(count);
		List<String> listOfLink = new ArrayList<String>();
		List<String> brokenLink = new ArrayList<String>();
		for (WebElement wb : allLinks) 
		{
			String link = wb.getAttribute("href");
			if(link!=null)
			{
				if(link.contains("http"))
				{
					listOfLink.add(link);
				}
				else
				{
					brokenLink.add(link+" ===> Not Having HTTP Protocol");
				}
			}else
			{
				brokenLink.add(link +" ==> Null" );
			}
			System.out.println(link);

		}
		for (String link : listOfLink) 
		{
			try {
				URL url=new URL(link);
				URLConnection urlCon = url.openConnection();
				HttpURLConnection httpUrlCon = (HttpURLConnection)urlCon;
				int statusCode = httpUrlCon.getResponseCode();
				String respoMsg = httpUrlCon.getResponseMessage();
				if(statusCode>=400)
				{
					brokenLink.add(link+" ==> Status code : "+statusCode+" ==>Response Msg :"+respoMsg);
				}
			}
			catch (Exception e) {
				brokenLink.add(link+" ===> Not Connected to Server ");
			}
		}
		System.err.println(brokenLink);
		System.err.println(brokenLink.size());

	}
}
