package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBeforeLogin
{
	@FindBy(linkText = "Login")
	private WebElement loginlink;
	
	@FindBy(linkText = "Register")
	private WebElement registerLink;
	
	public HomePageBeforeLogin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoginlink() {
		return loginlink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}
	
	
}

