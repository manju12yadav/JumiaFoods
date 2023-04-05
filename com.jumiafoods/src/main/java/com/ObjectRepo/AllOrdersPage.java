package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class AllOrdersPage 
{
	@FindBy(xpath = "(//tr[last()])[2]/td[.='manj']/following-sibling::td[7]/a[2]")
	private WebElement lastOrderEditBtn;
	
	@FindBy(xpath = "(//tr[last()])[2]/td[.='manj']/following-sibling::td[7]/a[1]")
	private WebElement lastOrderDeleteBtn;
	
	public AllOrdersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastOrderEditBtn() {
		return lastOrderEditBtn;
	}

	public WebElement getLastOrderDeleteBtn() {
		return lastOrderDeleteBtn;
	}
	
	public void orderStatusVerification(WebDriver driver)
	{
		SoftAssert sa = new SoftAssert();
		String eStatus = "On The Way!";
		String aStatus = driver.findElement(By.xpath("(//tr[last()])[2]/td[.='manj']/following-sibling::td[5]")).getText();
//		System.out.println(aStatus);
		sa.assertEquals(aStatus, eStatus,"Status is Not updated ");
		Reporter.log("Delivery status updated to "+aStatus+"for Order",true);
//		if(aStatus.contains(eStatus))
//		{
//			System.out.println("Delivery status updated to "+aStatus+"for Order");
//		}
//		else
//		{
//			System.err.println("Not updated ");
//		}
	}
	
}
