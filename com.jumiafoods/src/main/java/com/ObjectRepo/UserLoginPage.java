package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage 
{
	@FindBy(name = "username")
	private WebElement userNameTxt;
	
	@FindBy(name = "password")
	private WebElement passWordTxt;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTxt() {
		return userNameTxt;
	}

	public WebElement getPassWordTxt() {
		return passWordTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void userLogin(String USERNAME,String PASSWORD)
	{
		userNameTxt.sendKeys(USERNAME);
		passWordTxt.sendKeys(PASSWORD);
		submitBtn.click();
	}
	
}
