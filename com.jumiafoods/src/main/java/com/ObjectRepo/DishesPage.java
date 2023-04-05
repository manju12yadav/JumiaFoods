package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericUtilities.ExcelUtility;

public class DishesPage 
{
	@FindBy(xpath = "(//input[@name='quantity'])")
	private WebElement quantityTxt;
	
	@FindBy(xpath = "(//input[@value='Add To Cart'])")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[.='Checkout']")
	private WebElement checkoutBtn;
	
	public DishesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectDishes(WebDriver driver,ExcelUtility eLib) throws Throwable
	{
		String dishName = eLib.readFromExcel("AddMenu (2)", 0, 1);
		System.out.println(dishName);
		WebElement qty = driver.findElement(By.xpath("//a[contains(text(),'"+dishName+"')]/../../../../following-sibling::div/input[@name='quantity']"));
		qty.clear();
		qty.sendKeys("4");
		driver.findElement(By.xpath("//a[contains(text(),'"+dishName+"')]/../../../../following-sibling::div/input[@type='submit']")).click();
		
		String dishName1 = eLib.readFromExcel("AddMenu (4)", 0, 1);
		System.out.println(dishName1);
		WebElement qty1 = driver.findElement(By.xpath("//a[contains(text(),'"+dishName1+"')]/../../../../following-sibling::div/input[@name='quantity']"));
		qty1.clear();
		qty1.sendKeys("2");
		driver.findElement(By.xpath("//a[contains(text(),'"+dishName1+"')]/../../../../following-sibling::div/input[@type='submit']")).click();
		
		checkoutBtn.click();
	}
	
	
}
