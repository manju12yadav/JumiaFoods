package com.GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepo.HomePageAfterLogin;
import com.ObjectRepo.UserLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 
{

	public ExcelUtility eLib=new ExcelUtility();
	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws Throwable
	{
		dLib.connectToDB();
		Reporter.log("--Connect to DB--",true);
	}
	
//	@Parameters("BROWSER") String BROWSER
	@BeforeClass(alwaysRun = true)
	public void configBC() throws IOException
	{
		String URL = fLib.readFromPropertyFile("Curl");
		
		String BROWSER = fLib.readFromPropertyFile("cbrowser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			Reporter.log("--Invalid Browser--",true);
		}
		
		sdriver=driver;
		wLib.maximizeWindow(driver);
		driver.get(URL);
		wLib.implicitWaitForLoad(driver);
		Reporter.log("--Open the Browser--",true);

	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException
	{
		String UN = fLib.readFromPropertyFile("Cusername");
		String PW = fLib.readFromPropertyFile("Cpassword");

		UserLoginPage ulp=new UserLoginPage(driver);
		ulp.userLogin(UN, PW);

		Reporter.log("--Login to Application As a User--",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		HomePageAfterLogin hpal=new HomePageAfterLogin(driver);
		hpal.getLogoutLink();
		Reporter.log("--LogOut from Application as a User --",true);
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		driver.quit();
		Reporter.log("--Close The Browser--",true);
	}
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("--Close The Data Base Connection--",true);
	}
}
