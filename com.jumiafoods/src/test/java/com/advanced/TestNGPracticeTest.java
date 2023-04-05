package com.advanced;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPracticeTest 
{
	@Test(priority = 0,invocationCount = 5)
	public void createOrder()
	{
		System.out.println("Create Order");
	}
	
	@Test(priority = 1, invocationCount = 2,dependsOnGroups = "editStatus")
	public void editOrder()
	{
		System.out.println("Edit Order");
	}
	
	@Test(priority = -1, invocationCount = 3,dependsOnMethods = "editOrder")
	public void deleteOrder()
	{
//		int [] ar= {1,5,9};
//		System.out.println(ar[4]);

		System.out.println("Delete Order");
	}
	
	@Test(priority = -1,dependsOnMethods = "createOrder")
	public void editStatus()
	{
		Reporter.log("Status updated",true);
	}
}
