package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateSpiceJet 
{

	public static void main(String[] args) throws Throwable 
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[.='round trip' and @class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa']/../preceding-sibling::*")).click();
		driver.findElement(By.xpath("(//div[.='From'])[2]")).click();
		driver.findElement(By.xpath("(//*[@id='main-container']//input)[1]")).sendKeys("Hy");
		driver.findElement(By.xpath("(//div[.='To'])[2]")).click();
		driver.findElement(By.xpath("(//*[@id='main-container']//input)[2]")).sendKeys("Bengaluru");
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div[1]/div/div[3]/div[4]//div[3]/div/div")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div/div[2]/div/div[3]/div[3]/div[2]/div/div")).click();
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[3]")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//descendant::div/div[1]/div[3]/div[2]/div[5]/div[1]/div/div[2]/div[2]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//*[@id='main-container']//div[1]/div[3]/div[2]/div[7]//div[2]/div")).click();
		driver.close();
	}

}
