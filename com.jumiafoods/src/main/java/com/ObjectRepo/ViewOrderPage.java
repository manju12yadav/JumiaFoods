package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.WebDriverUtility;

public class ViewOrderPage 
{
	@FindBy(xpath = "//button[.='Update Order Status']")
	private WebElement updateOrdStatusBtn;
	
	@FindBy(xpath = "//button[.='View User Detials']")
	private WebElement viewUserDetailsBtn;
	
	@FindBy(name = "status")
	private WebElement statusDrpDwn;
	
	@FindBy(name = "remark")
	private WebElement statusRemark;
	
	@FindBy(name = "update")
	private WebElement submitStatus;
	
	@FindBy(xpath = "//strong[.='Status:']/../following-sibling::td//button")
	private WebElement updatedStatusTxt;
	
	public ViewOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void updateOrderStatus(WebDriver driver,WebDriverUtility wLib,UserLoginPage ulp,ExcelUtility eLib,String un,String pw) throws Throwable, Throwable
	{
		updateOrdStatusBtn.click();
		wLib.switchToWindow(driver,"login");
		ulp.userLogin(un, pw);
		driver.close();
		wLib.switchToWindow(driver, "view_order");
		updateOrdStatusBtn.click();
		wLib.switchToWindow(driver, "order_update");
		wLib.select("On the way", statusDrpDwn);
		String remarks = eLib.readFromExcel("EditStatus", 0, 1);
		statusRemark.sendKeys(remarks);
		submitStatus.click();
		String msg = wLib.getTextAlert(driver);
		System.out.println(msg);
		wLib.acceptAlert(driver);
		driver.close();
		wLib.switchToWindow(driver, "view_order");
		wLib.refreshPage(driver);
		String updatedStatus = updatedStatusTxt.getText();
		System.out.println(updatedStatus);
		
		

	}
	
	
	
	
}
