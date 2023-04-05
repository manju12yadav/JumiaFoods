package com.menu_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AddMenuPage;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllMenuesPage;
import com.ObjectRepo.UpdateMenuPage;

public class MenuModule extends BaseClass
{	
	
	@Test(groups = {"smoke","regression"})
	public void addMenu() throws Throwable 
	{		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.getMenuDrpdwn().click();
		app.getAddMenuLink().click();
		
		AddMenuPage amp=new AddMenuPage(driver);
		amp.addMenuDetails(driver, eLib, wLib);
	}

	@Test(priority = 1, groups = "regression")
	public void editMenu() throws Throwable 
	{
		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.getMenuDrpdwn().click();
		app.getAllMenuLink().click();
		
		AllMenuesPage.editMenu(driver, eLib);
		
		UpdateMenuPage ump=new UpdateMenuPage(driver);
		ump.editMenuDetails(driver, eLib, wLib);
		
		

	}
	
	@Test(priority = 2, groups ="regression")
	public void deleteMenu() throws Throwable 
	{
		AdminPanelPage app=new AdminPanelPage(driver);		
		app.getMenuDrpdwn().click();
		app.getAllMenuLink().click();
		
		AllMenuesPage.deleteMenu(driver, eLib);
	}
	
}
