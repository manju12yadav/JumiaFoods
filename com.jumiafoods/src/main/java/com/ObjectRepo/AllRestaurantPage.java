package com.ObjectRepo;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.GenericUtilities.ExcelUtility;

public class AllRestaurantPage 
{
	
	public static void editRestaurant(WebDriver driver,ExcelUtility eLib) throws EncryptedDocumentException, IOException
	{
		String restoName = eLib.readFromExcel("AddResto (3)", 0, 1);
		driver.findElement(By.xpath("//td[.='"+restoName+"']/following-sibling::td[10]/a[2]")).click();
		System.out.println("Your Successfully selected "+restoName+" Restaurant");
	}
	public static void deleteRestaurant(WebDriver driver,ExcelUtility eLib) throws EncryptedDocumentException, IOException
	{
		String restoName = eLib.readFromExcel("AddResto (4)", 0, 1);
		driver.findElement(By.xpath("//td[.='"+restoName+"']/following-sibling::td[10]/a[1]")).click();
		System.out.println("Your Successfully Deleted "+restoName+" Restaurant");
	}
}
