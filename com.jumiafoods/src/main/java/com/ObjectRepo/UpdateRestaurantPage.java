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

public class UpdateRestaurantPage
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
	
	public UpdateRestaurantPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void editRestoDetails(WebDriver driver,ExcelUtility eLib,WebDriverUtility wLib) throws Throwable, Throwable
	{
		SoftAssert sa = new SoftAssert();
		HashMap<String, String> map = eLib.readMulFromExcel("AddResto (4)");

		for(Entry<String, String> set:map.entrySet())
		{
				
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				data.sendKeys(set.getValue());
				
		}
		wLib.select("10am", openHrDrpDwn);
		wLib.select("8pm", closeHrDrpDwn);
		wLib.select("24hr-x7", openDaysDrpDwn);
		String category = eLib.readFromExcel("CategoryList",1, 0);
		wLib.select(category, categoryNameDrpDwn);
//		String path = eLib.readFromExcel("AddResto (4)", 5, 1);
//		File f=new File(path);
//		String abPath = f.getAbsolutePath();
//		fileUploadBtn.sendKeys(abPath);
		saveBtn.click();
		boolean updated = driver.findElement(By.xpath("//strong[.='Record Updated!']")).isDisplayed();
		sa.assertTrue(updated,"Record is not Updated");
		System.out.println("Record Updated Successfully");
		sa.assertAll();
//		if(updated==true)
//		{
//			System.out.println("Record Updated Successfully");
//		}
//		else
//		{
//			System.err.println("Record is not Updated");
//		}
	
		

	}
	
}
