package com.practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.GenericUtilities.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class AutomateMakeMyTrip 
{

	public static void main(String[] args) throws Throwable 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='notification-frame-173061603']"));
		driver.switchTo().frame(frame);
		
		WebElement popup = driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		wait.until(ExpectedConditions.visibilityOf(popup));
		js.executeScript("arguments[0].click()", popup);
		
//		WebElement popup = driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Goa");
		driver.findElement(By.xpath("//p[.='Goa - Dabolim Airport, India']")).click();
		
//		System Date
		Date cdt=new Date();
		String[] d = cdt.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		String travelDate = day+" "+month+" "+date+" "+year;

		
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
		

		//		Fri Aug 12 2023

		String rday = "Sat";
		String rmonth = "Sep";
		String rdate = "09";
		String ryear = "2023";
		String returnDate = rday+" "+rmonth+" "+rdate+" "+ryear;

		//		giving infinity loop to select the future date

		for (; ;)
		{
			try 
			{
				driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']")).click();
				break;
			}
			catch (Exception e) 
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//				driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
			}

		}
		
		driver.findElement(By.xpath("//span[@class='appendRight10']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-4']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
		System.out.println("Flight details are in below screenshot");
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.getScreenShot(driver, "FlightDetails");
		
//		driver.close();
		

	}

}


