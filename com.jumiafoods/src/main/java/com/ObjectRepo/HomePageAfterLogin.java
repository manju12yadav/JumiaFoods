package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAfterLogin
{
		@FindBy(xpath = "//a[.='Restaurants ']")
		private WebElement restaurantLink;
		
		@FindBy(linkText = "My Orders")
		private WebElement myOrdersLink;
		
		@FindBy(linkText = "Logout")
		private WebElement logoutLink;
		
		
		public HomePageAfterLogin(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getRestaurantLink() {
			return restaurantLink;
		}

		public WebElement getMyOrdersLink() {
			return myOrdersLink;
		}

		public WebElement getLogoutLink() {
			return logoutLink;
		}
		
		
		
		
}
