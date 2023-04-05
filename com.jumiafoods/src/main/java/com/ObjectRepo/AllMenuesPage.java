package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.GenericUtilities.ExcelUtility;

public class AllMenuesPage 
{

	public static void editMenu(WebDriver driver,ExcelUtility eLib) throws Throwable, Throwable
	{
		String menu = eLib.readFromExcel("AddMenu (4)", 0, 1);
		driver.findElement(By.xpath("//td[.='"+menu+"']/following-sibling::td[4]/a[2]")).click();
		System.out.println("Your Successfully selected "+menu+" Menu");
	}
	
	public static void deleteMenu(WebDriver driver,ExcelUtility eLib) throws Throwable, Throwable
	{
		String menu = eLib.readFromExcel("AddMenu (2)", 0, 1);
		driver.findElement(By.xpath("//td[.='"+menu+"']/following-sibling::td[4]/a[1]")).click();
		System.out.println("Your Successfully deleted "+menu+" Menu");
	}
}
