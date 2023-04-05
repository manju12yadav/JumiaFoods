package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.WebDriverUtility;

public class RestaurantsPage 
{
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=253\"])[3]")
	private WebElement sriRamMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=203\"])[3]")
	private WebElement checkPostMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=205\"])[3]")
	private WebElement maniDumMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=220\"])[3]")
	private WebElement hanumanthuMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=286\"])[3]")
	private WebElement mohammadDesiMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=226\"])[3]")
	private WebElement sammruddiMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=231\"])[3]")
	private WebElement athithiSathkarMenu;
	
	@FindBy(xpath = "(//a[@href=\"dishes.php?res_id=240\"])[3]")
	private WebElement shivaSagarMenu;
	
	public RestaurantsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSriramMenu(WebDriver driver,WebDriverUtility wLib) {
		wLib.scrollAction(driver, sriRamMenu);
		return sriRamMenu;
	}

	public WebElement getCheckPostMenu() {
		return checkPostMenu;
	}

	public WebElement getManiDumMenu() {
		return maniDumMenu;
	}

	public WebElement getHanumanthuMenu() {
		return hanumanthuMenu;
	}

	public WebElement getSriramMenu() {
		return sriRamMenu;
	}

	public WebElement getMohammadDesiMenu() {
		return mohammadDesiMenu;
	}

	public WebElement getSammruddiMenu() {
		return sammruddiMenu;
	}

	public WebElement getAthithiSathkarMenu() {
		return athithiSathkarMenu;
	}

	public WebElement getShivaSagarMenu() {
		return shivaSagarMenu;
	}
	
	
	
	
	
}
