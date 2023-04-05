package com.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String Un = p.getProperty("username");
		String Pwd = p.getProperty("password");
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(Un);
		System.out.println(Pwd);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(Url);
		driver.findElement(By.name("username")).sendKeys(Un);
		driver.findElement(By.name("password")).sendKeys(Pwd);
		driver.findElement(By.name("submit")).click();
		
		
		
	}

}
