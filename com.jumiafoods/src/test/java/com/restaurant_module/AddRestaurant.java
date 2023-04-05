package com.restaurant_module;

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

public class AddRestaurant
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
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.xpath("//a[.='Add Restaurant']")).click();

		HashMap<String, String> map = eLib.readMulFromExcel("AddResto (2)");

		for(Entry<String, String> set:map.entrySet())
		{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

		WebElement openHr = driver.findElement(By.name("o_hr"));
		wLib.select("11am",openHr);
		WebElement closeHr = driver.findElement(By.name("c_hr"));
		wLib.select("9pm", closeHr);
		WebElement openDays = driver.findElement(By.name("o_days"));
		wLib.select("Mon-Sat", openDays);
		String path = eLib.readFromExcel("AddResto (2)", 5, 1);
		File f=new File(path);
		String abPath = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(abPath);
		WebElement cateName = driver.findElement(By.name("c_name"));
		wLib.select("Non-vegg", cateName);
		driver.findElement(By.name("submit")).click();
		 Boolean RestoAdded = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();
		System.out.println(RestoAdded);
		if(RestoAdded==true)
		{
			System.out.println("New Restaurant Added Successfully");
		}
		else
		{
			System.err.println("Restaurant Not Added");
		}
		driver.close();
	}

}
