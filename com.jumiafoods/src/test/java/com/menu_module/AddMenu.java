package com.menu_module;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMenu
{

	public static void main(String[] args) throws Throwable 
	{
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();

		
		String URL = fLib.readFromPropertyFile("Aurl");
		String UN = fLib.readFromPropertyFile("Ausername");
		String PW = fLib.readFromPropertyFile("Apassword");
		
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PW);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='Add Menu']")).click();
		
		HashMap<String, String> map = eLib.readMulFromExcel("AddMenu (4)");
		
				for(Entry<String, String> set:map.entrySet())
				{
				
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				
				}
		
		File f=new File("E:\\Test Yantra\\Project\\images\\thatte idly.jpg");
		String abPath = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(abPath);
		WebElement restoList = driver.findElement(By.name("res_name"));
		wLib.select("Sri ram Hotel", restoList);
		driver.findElement(By.name("submit")).click();
		boolean added = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();
		if(added==true)
		{
			System.out.println("Dish is added SuccessFully");
		}
		else
		{
			System.err.println("Max Image Size is 1024kb! Try different Image.");
		}
		driver.close();
	}

}
