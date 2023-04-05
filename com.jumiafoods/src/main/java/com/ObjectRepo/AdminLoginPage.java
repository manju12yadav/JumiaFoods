package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage 
{
	@FindBy(name = "username")
	private WebElement adminUsernameTxt;
	
	@FindBy(name = "password")
	private WebElement adminPasswordTxt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminUsernameTxt() {
		return adminUsernameTxt;
	}

	public WebElement getAdminPasswordTxt() {
		return adminPasswordTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void adminLogin(String un,String pw)
	{
		adminUsernameTxt.sendKeys(un);
		adminPasswordTxt.sendKeys(pw);
		submitBtn.click();
	}
	
	
}
