package com.menu_module;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AddMenuPage;
import com.ObjectRepo.AdminPanelPage;

@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class AddMenuTest extends BaseClass
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryImplementation.class)
	public void addMenu() throws Throwable 
	{		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.getMenuDrpdwn().click();
		app.getAddMenuLink().click();
		
		AddMenuPage amp=new AddMenuPage(driver);
		amp.addMenuDetails(driver, eLib, wLib);
		
	}

}
