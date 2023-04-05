package com.restaurant_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllRestaurantPage;

public class DeleteRestaurantTest extends BaseClass
{
	
	@Test
	public void deleteRestaurant() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);
		
		app.getRestaurantDrpdwn().click();
		app.getAllRestaurantLink().click();
		AllRestaurantPage.deleteRestaurant(driver, eLib);
	}

}
