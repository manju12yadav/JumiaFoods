package com.menu_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllMenuesPage;
import com.ObjectRepo.UpdateMenuPage;

public class EditMenuTest extends BaseClass
{
	@Test
	public void editMenu() throws Throwable 
	{
		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.getMenuDrpdwn().click();
		app.getAllMenuLink().click();
		
		AllMenuesPage.editMenu(driver, eLib);
		
		UpdateMenuPage ump=new UpdateMenuPage(driver);
		ump.editMenuDetails(driver, eLib, wLib);
		
		

	}

}
