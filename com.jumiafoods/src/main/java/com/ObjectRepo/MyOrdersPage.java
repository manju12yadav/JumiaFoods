package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class MyOrdersPage 
{
	@FindBy(xpath = "(//tr[last()])[2]")
	private WebElement orderedDetails;

	@FindBy(xpath = "(//tr[last()]//following-sibling::td)[4]")
	private WebElement orderStatus;

	public MyOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public String getOrderedDetails()
	{
		String details = orderedDetails.getText();
		return details;
	}

	public void getOrderStatus()
	{
		SoftAssert sa = new SoftAssert();
		String eStatus="Dispatch";
		String aStatus = orderStatus.getText();
		sa.assertEquals(aStatus, eStatus,"Status is not Updated");
		System.out.println("Order is in "+aStatus+" Status");
//		if(eStatus.contains(aStatus))
//		{
//			System.out.println("Status is Dispatch");
//		}
//		else
//		{
//			System.err.println("Status is not Updated");
//		}
	}

}
