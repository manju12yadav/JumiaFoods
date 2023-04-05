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

public class UpdateMenuPage 
{
	
	@FindBy(name = "file")
	private WebElement fileUploadBtn;
	
	@FindAll({@FindBy(name = "res_name"),@FindBy(xpath = "//option[.='--Select Restaurant--']")})
	private WebElement restoListDrpDwn;
	
	@FindBy(name = "submit")
	private WebElement saveBtn;
	

	public UpdateMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void editMenuDetails(WebDriver driver,ExcelUtility eLib,WebDriverUtility wLib) throws Throwable, Throwable
	{
		SoftAssert sa = new SoftAssert();
				
		HashMap<String, String> map = eLib.readMulFromExcel("AddMenu (2)");

		for(Entry<String, String> set:map.entrySet())
		{
				WebElement data = driver.findElement(By.name(set.getKey()));
				data.clear();
				data.sendKeys(set.getValue());				
		}
//		String path = eLib.readFromExcel("AddMenu (2)", 3, 1);
//		File f=new File(path);
//		String abPath = f.getAbsolutePath();
//		fileUploadBtn.sendKeys(abPath);
		String restoName = eLib.readFromExcel("AddResto (3)", 0, 1);
		wLib.select(restoName, restoListDrpDwn);
		saveBtn.click();
		String eResult = "Record Updated!";
		String aResult = driver.findElement(By.xpath("//strong[.='Record Updated!']")).getText();
		sa.assertEquals(aResult, eResult, "Menu is not Modified");
		System.out.println("Menu modified succesfully");
		sa.assertAll();
//		if(eResult.equals(aResult))
//		{
//			System.out.println("Menu modified succesfully");
//		}
//		else
//		{
//			System.err.println("Menu not modified");
//		}

		
	}
	
}
