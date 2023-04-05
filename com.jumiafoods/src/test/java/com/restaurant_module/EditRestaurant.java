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

public class EditRestaurant
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
		driver.findElement(By.xpath("//a[.='All Restaurant']")).click();
		String restoName = eLib.readFromExcel("AddResto", 0, 1);
		driver.findElement(By.xpath("//td[.='"+restoName+"']/following-sibling::td[10]/a[2]")).click();
		
		HashMap<String, String> map = eLib.readMulFromExcel("EditResto");

		for(Entry<String, String> set:map.entrySet())
		{
				
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				data.sendKeys(set.getValue());
				
		}

		
		WebElement openHr = driver.findElement(By.name("o_hr"));
		wLib.select("7am", openHr);
		WebElement closeHr = driver.findElement(By.name("c_hr"));
		wLib.select("7pm", closeHr);
		WebElement openDays = driver.findElement(By.name("o_days"));
		wLib.select("24hr-x7", openDays);
		File f=new File("E:\\Test Yantra\\Project\\images\\download (7).jpg");
		String abPath = f.getAbsolutePath();
		driver.findElement(By.name("file")).sendKeys(abPath);
		WebElement ChCategory = driver.findElement(By.name("c_name"));
		wLib.select("Indian", ChCategory);
		driver.findElement(By.name("submit")).click();
		boolean updated = driver.findElement(By.xpath("//strong[.='Record Updated!']")).isDisplayed();
		if(updated==true)
		{
			System.out.println("Record Updated Successfully");
		}
		else
		{
			System.err.println("Record is not Updated");
		}
		driver.close();
		
	}

}
