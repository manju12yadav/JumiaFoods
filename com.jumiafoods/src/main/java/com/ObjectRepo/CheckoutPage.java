package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.WebDriverUtility;

public class CheckoutPage 
{
	@FindBy(name = "submit")
	private WebElement orderNowBtn;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void orderAndPay(WebDriver driver,WebDriverUtility wLib)
	{
		SoftAssert sa = new SoftAssert();
		orderNowBtn.click();
		wLib.acceptAlert(driver);
		String eResult = "Thank you. Your Order has been placed!";
		String aResult = wLib.getTextAlert(driver);
		wLib.acceptAlert(driver);
		sa.assertEquals(aResult, eResult,"Order is not Placed");
		System.out.println("Order is Placed Successfully");
		sa.assertAll();
//		if(aResult.equals(eResult))
//		{
//			System.out.println("Order is Placed Successfully");
//		}
//		else
//		{
//			System.err.println("Order is not Placed");
//		}
	}

}

