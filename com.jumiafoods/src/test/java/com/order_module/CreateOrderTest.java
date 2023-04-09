package com.order_module;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass2;
import com.ObjectRepo.CheckoutPage;
import com.ObjectRepo.DishesPage;
import com.ObjectRepo.HomePageAfterLogin;
import com.ObjectRepo.MyOrdersPage;
import com.ObjectRepo.RestaurantsPage;

@Listeners(com.GenericUtilities.ListnerImplementation.class)
public class CreateOrderTest extends BaseClass2
{
	@Test
	public void createOrder() throws Throwable
	{
		
		HomePageAfterLogin hpal=new HomePageAfterLogin(driver);
		hpal.getRestaurantLink().click();
		RestaurantsPage rp=new RestaurantsPage(driver);
//		Assert.fail();
		//		rp.getSriramMenu(driver, wLib).click();
//		rp.getManiDumMenu().click();
//		rp.getHanumanthuMenu().click();
		rp.getShivaSagarMenu().click();

		DishesPage dp=new DishesPage(driver);
		dp.selectDishes(driver, eLib);
		
		CheckoutPage cp=new CheckoutPage(driver);
		cp.orderAndPay(driver, wLib);
		
		MyOrdersPage mop=new MyOrdersPage(driver);
		mop.getOrderStatus();	
	}

}
