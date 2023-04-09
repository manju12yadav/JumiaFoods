package com.restaurant_module;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AddRestaurantPage;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllRestaurantPage;
import com.ObjectRepo.UpdateRestaurantPage;

@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class RestaurantModuleTest extends BaseClass
{

	@Test(groups = {"smoke","regression"})
	public void addRestaurant() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);
		AddRestaurantPage arp=new AddRestaurantPage(driver);
		
		app.getRestaurantDrpdwn().click();
		app.getAddRestaurantLink().click();
		arp.addRestoDetails(driver, eLib, wLib);		
	}

	
	
	@Test(priority = 1, groups = "regression")
	public void editRestaurant() throws Throwable
	{
		
		AdminPanelPage app=new AdminPanelPage(driver);

		app.getRestaurantDrpdwn().click();
		app.getAllRestaurantLink().click();
		AllRestaurantPage.editRestaurant(driver, eLib);
		UpdateRestaurantPage urp=new UpdateRestaurantPage(driver);
		urp.editRestoDetails(driver, eLib, wLib);		
	}
	
	@Test(priority = 2, groups = "regression")
	public void deleteRestaurant() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);
		
		app.getRestaurantDrpdwn().click();
		app.getAllRestaurantLink().click();
		AllRestaurantPage.deleteRestaurant(driver, eLib);
	}

	
	
}
