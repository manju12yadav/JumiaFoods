package com.menu_module;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditMenu 
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
		wLib.maximizeWindow(driver);
		wLib.implicitWaitForLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PW);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Menu']")).click();
		driver.findElement(By.xpath("//a[.='All Menues']")).click();
		String menu = eLib.readFromExcel("AddMenu (3)", 0, 1);
		driver.findElement(By.xpath("//td[.='"+menu+"']/following-sibling::td[4]/a[2]")).click();
		
		HashMap<String, String> map = eLib.readMulFromExcel("AddMenu (2)");

		for(Entry<String, String> set:map.entrySet())
		{
				
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				data.sendKeys(set.getValue());
				
		}

		File f=new File("E:\\Test Yantra\\Project\\images\\download.jpg");
		String abPath = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(abPath);
		WebElement restoList = driver.findElement(By.name("res_name"));
		wLib.select("Check Post", restoList);
		driver.findElement(By.name("submit")).click();
		String eResult = "Record Updated!";
		String aResult = driver.findElement(By.xpath("//strong[.='Record Updated!']")).getText();
		if(eResult.equals(aResult))
		{
			System.out.println("Menu modified succesfully");
		}
		else
		{
			System.err.println("Menu not modified");
		}
		driver.close();
		
	}

}
