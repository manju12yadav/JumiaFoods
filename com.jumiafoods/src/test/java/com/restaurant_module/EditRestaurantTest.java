package com.restaurant_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllRestaurantPage;
import com.ObjectRepo.UpdateRestaurantPage;

public class EditRestaurantTest extends BaseClass
{

	@Test
	public void editRestaurant() throws Throwable
	{
		
		AdminPanelPage app=new AdminPanelPage(driver);

		app.getRestaurantDrpdwn().click();
		app.getAllRestaurantLink().click();
		AllRestaurantPage.editRestaurant(driver, eLib);
		UpdateRestaurantPage urp=new UpdateRestaurantPage(driver);
		urp.editRestoDetails(driver, eLib, wLib);		
	}

}
