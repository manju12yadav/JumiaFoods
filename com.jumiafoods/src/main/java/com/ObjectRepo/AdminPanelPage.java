package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPanelPage 
{
	
//	Declaration
	@FindBy(xpath = "//span[.='Users']")
	private WebElement usersLink;
	
	@FindBy(xpath = "//span[.='Restaurant']")
	private WebElement restaurantDrpdwn;
	
	@FindBy(xpath = "//a[.='Add Restaurant']")
	private WebElement addRestaurantLink;
	
	@FindBy(xpath = "//a[.='All Restaurant']")
	private WebElement allRestaurantLink;
	
	@FindBy(xpath = "")
	private WebElement addCategoryLink;
	
	@FindBy(xpath = "//span[.='Menu']")
	private WebElement menuDrpdwn;
	
	@FindBy(xpath = "//a[.='Add Menu']")
	private WebElement addMenuLink;
	
	@FindBy(xpath = "//a[.='All Menues']")
	private WebElement allMenuLink;
	
	@FindBy(xpath = "//span[.='Orders']")
	private WebElement ordersLink;
	
	@FindBy(xpath = "//img[@src='images/bookingSystem/user-icn.png']")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logoutLink;
	
//	Initialization
	public AdminPanelPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	Utilization
	public WebElement getUsersLink() {
		return usersLink;
	}

	public WebElement getRestaurantDrpdwn() {
		return restaurantDrpdwn;
	}

	public WebElement getAddRestaurantLink() {
		return addRestaurantLink;
	}

	public WebElement getAllRestaurantLink() {
		return allRestaurantLink;
	}

	public WebElement getAddCategoryLink() {
		return addCategoryLink;
	}

	public WebElement getMenuDrpdwn() {
		return menuDrpdwn;
	}

	public WebElement getAddMenuLink() {
		return addMenuLink;
	}

	public WebElement getAllMenuLink() {
		return allMenuLink;
	}

	public WebElement getOrdersLink() {
		return ordersLink;
	}
	
	public void logoutAdmin()
	{
		adminIcon.click();
		logoutLink.click();
	}
	
	
	
}
