package com.restaurant_module;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AddRestaurantPage;
import com.ObjectRepo.AdminPanelPage;

public class AddRestaurantTest extends BaseClass
{
	@Test
	public void addRestaurant() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);
		AddRestaurantPage arp=new AddRestaurantPage(driver);
		Assert.fail();
		app.getRestaurantDrpdwn().click();
		app.getAddRestaurantLink().click();
		arp.addRestoDetails(driver, eLib, wLib);		
	}

}
