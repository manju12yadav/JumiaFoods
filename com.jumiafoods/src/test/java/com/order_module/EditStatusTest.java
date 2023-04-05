package com.order_module;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepo.AdminPanelPage;
import com.ObjectRepo.AllOrdersPage;
import com.ObjectRepo.UserLoginPage;
import com.ObjectRepo.ViewOrderPage;

public class EditStatusTest extends BaseClass
{
	@Test(groups = {"smoke","regression"})
	public void editOrderStatus() throws Throwable
	{

		String CUN = fLib.readFromPropertyFile("Cusername");
		String CPW = fLib.readFromPropertyFile("Cpassword");
		
		
		AdminPanelPage app=new AdminPanelPage(driver);
		AllOrdersPage aop=new AllOrdersPage(driver);
		ViewOrderPage vop=new ViewOrderPage(driver);
		UserLoginPage ulp=new UserLoginPage(driver);
			
		app.getOrdersLink().click();
		aop.getLastOrderEditBtn().click();
		vop.updateOrderStatus(driver, wLib, ulp, eLib, CUN, CPW);
		app.getOrdersLink().click();
		aop.orderStatusVerification(driver);
	}
}
