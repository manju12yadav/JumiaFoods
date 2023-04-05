   package com.order_module;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrder
{

	public static void main(String[] args) throws IOException 
	{
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		

		String URL = fLib.readFromPropertyFile("Curl");
		String USERNAME = fLib.readFromPropertyFile("Cusername");
		String PASSWORD = fLib.readFromPropertyFile("Cpassword");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[.='Restaurants ']")).click();
		String restoName = eLib.readFromExcel("AddResto (2)", 0, 1);
		System.out.println(restoName);
		driver.findElement(By.xpath("//a[.='"+restoName+"']/../../../following-sibling::div//a")).click();
		String dishName = eLib.readFromExcel("AddMenu (3)", 0, 1);
		System.out.println(dishName);
		driver.findElement(By.xpath("//a[contains(text(),'"+dishName+"')]/../../../../following-sibling::div/input[@name='quantity']")).sendKeys("4");
		driver.findElement(By.xpath("//a[contains(text(),'"+dishName+"')]/../../../../following-sibling::div/input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Checkout']")).click();
		driver.findElement(By.name("submit")).click();
		wLib.acceptAlert(driver);
		String eResult = "Thank you. Your Order has been placed!";
		String aResult = wLib.getTextAlert(driver);
		wLib.acceptAlert(driver);
		if(aResult.equals(eResult))
		{
			System.out.println("Order is Placed Successfully");
		}
		else
		{
			System.err.println("Order is not Placed");
		}
		
		String eStatus = "Dispatch";
		String orderDetails= driver.findElement(By.xpath("(//tr[last()])[2]")).getText();
		System.out.println(orderDetails);
		String aStatus = driver.findElement(By.xpath("(//tr[last()]//following-sibling::td)[4]")).getText();
		System.out.println("Order is in "+aStatus+" Status");
		if(aStatus.equals(eStatus))
		{
			System.out.println("Status is Dispatch");
		}
		else
		{
			System.err.println("Status is not Updated");
		}
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		driver.close();
	}

}
