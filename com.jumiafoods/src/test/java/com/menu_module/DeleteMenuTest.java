package com.menu_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllMenuesPage;

public class DeleteMenuTest extends BaseClass
{
	
	@Test
	public void deleteMenu() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);		
		app.getMenuDrpdwn().click();
		app.getAllMenuLink().click();
		
		AllMenuesPage.deleteMenu(driver, eLib);
	}


}
