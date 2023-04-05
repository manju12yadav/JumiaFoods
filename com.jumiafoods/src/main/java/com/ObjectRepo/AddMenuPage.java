package com.ObjectRepo;


import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.WebDriverUtility;

public class AddMenuPage
{
	@FindBy(name = "file")
	private WebElement fileUploadBtn;
	
	@FindAll({@FindBy(name = "res_name"),@FindBy(xpath = "//option[.='--Select Restaurant--']")})
	private WebElement restoListDrpDwn;
	
	@FindBy(name = "submit")
	private WebElement saveBtn;
	

	public AddMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void addMenuDetails(WebDriver driver,ExcelUtility eLib,WebDriverUtility wLib) throws Throwable, Throwable
	{
		SoftAssert sa = new SoftAssert();
		HashMap<String, String> map = eLib.readMulFromExcel("AddMenu (4)");

		for(Entry<String, String> set:map.entrySet())
		{			
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
//		String path = eLib.readFromExcel("AddMenu (4)", 3, 1);
//		File f=new File(path);
//		String abPath = f.getAbsolutePath();
//		fileUploadBtn.sendKeys(abPath);
		String restoName = eLib.readFromExcel("AddResto (2)", 0, 1);
		System.out.println(restoName);
		wLib.select(restoName, restoListDrpDwn);
		saveBtn.click();
		boolean added = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).isDisplayed();
		sa.assertTrue(added,"Data is not added");
		System.out.println("Dish is added SuccessFully");
		sa.assertAll();
		//		if(added==true)
//		{
//			System.out.println("Dish is added SuccessFully");
//		}
//		else
//		{
//			System.err.println("Dish is not Added.");
//		}
	}

}
