package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.WebDriverUtility;

public class AddRestaurantPage 
{
	@FindBy(name = "o_hr")
	private WebElement openHrDrpDwn;
	
	@FindBy(name = "c_hr")
	private WebElement closeHrDrpDwn;
	
	@FindBy(name = "o_days")
	private WebElement openDaysDrpDwn;
	
	@FindBy(name = "file")
	private WebElement fileUploadBtn;
	
	@FindBy(name = "c_name")
	private WebElement categoryNameDrpDwn;
	
	@FindBy(name = "submit")
	private WebElement saveBtn;
	
	public AddRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addRestoDetails(WebDriver driver,ExcelUtility eLib,WebDriverUtility wLib) throws Throwable, Throwable
	{
		SoftAssert sa = new SoftAssert();
		HashMap<String, String> map = eLib.readMulFromExcel("AddResto (3)");

		for(Entry<String, String> set:map.entrySet())
		{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		wLib.select("10am", openHrDrpDwn);
		wLib.select("8pm", closeHrDrpDwn);
		wLib.select("Mon-Sat", openDaysDrpDwn);
		String category = eLib.readFromExcel("CategoryList",9, 0);
		wLib.select(category, categoryNameDrpDwn);
//		String path = eLib.readFromExcel("AddResto (3)", 5, 1);
//		File f=new File(path);
//		String abPath = f.getAbsolutePath();
//		fileUploadBtn.sendKeys(abPath);
		saveBtn.click();
		Boolean RestoAdded = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();
		System.out.println(RestoAdded);
		sa.assertTrue(RestoAdded, "Restaurant Not Added");
		System.out.println("New Restaurant Added Successfully");
		sa.assertAll();
		
//		if(RestoAdded==true)
//		{
//			System.out.println("New Restaurant Added Successfully");
//		}
//		else
//		{
//			System.err.println("Restaurant Not Added");
//		}
	}
}
