package com.order_module;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditStatus
{

	public static void main(String[] args) throws IOException 
	{
		
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();

		String AURL = fLib.readFromPropertyFile("Aurl");
		String AUN = fLib.readFromPropertyFile("Ausername");
		String APW = fLib.readFromPropertyFile("Apassword");
		
		String CUN = fLib.readFromPropertyFile("Cusername");
		String CPW = fLib.readFromPropertyFile("Cpassword");
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(AURL);
		driver.findElement(By.name("username")).sendKeys(AUN);
		driver.findElement(By.name("password")).sendKeys(APW);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		driver.findElement(By.xpath("(//tr[last()])[2]/td[.='manj']/following-sibling::td[7]/a[2]")).click();
		driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		
		wLib.switchToWindow(driver,"login");
		
		driver.findElement(By.name("username")).sendKeys(CUN);
		driver.findElement(By.name("password")).sendKeys(CPW);
		driver.findElement(By.name("submit")).click();
		driver.close();

		wLib.switchToWindow(driver, "view_order");
		
		driver.findElement(By.xpath("//button[.='Update Order Status']")).click();
		
		wLib.switchToWindow(driver, "order_update");
		
		
		WebElement statusList = driver.findElement(By.name("status"));
		wLib.select("On the way", statusList);
		String comment = eLib.readFromExcel("EditStatus", 0, 1);
		driver.findElement(By.name("remark")).sendKeys(comment);
		driver.findElement(By.name("update")).click();
		String msg = wLib.getTextAlert(driver);
		System.out.println(msg);
		wLib.acceptAlert(driver);
		driver.close();
		wLib.switchToWindow(driver, "view_order");
		
		wLib.refreshPage(driver);
		
		String updatedStatus = driver.findElement(By.xpath("//strong[.='Status:']/../following-sibling::td//button")).getText();
		System.out.println(updatedStatus);
		driver.findElement(By.xpath("//span[.='Orders']")).click();
		String eStatus = "On The Way!";
		String aStatus = driver.findElement(By.xpath("(//tr[last()])[2]/td[.='manj']/following-sibling::td[5]")).getText();
		System.out.println(aStatus);
		if(aStatus.contains(eStatus))
		{
			System.out.println("Delivery status updated to "+aStatus+"for Order");
		}
		else
		{
			System.err.println("Not updated ");
		}
		driver.close();
	}

}
