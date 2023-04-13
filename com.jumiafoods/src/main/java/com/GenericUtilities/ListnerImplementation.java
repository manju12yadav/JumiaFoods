package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		//		execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"--------> TestScript Execution Started",true);
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---> Passed");
		Reporter.log(MethodName+"----> TestScript Execution Sucessfull",true);
	}

	public void onTestFailure(ITestResult result) 
	{
//		JavaUtility jLib = new JavaUtility();
//		int r = jLib.random();
		String fScript = result.getMethod().getMethodName();
						String fs = fScript+ new JavaUtility().getSystemDate();
//		String fs = fScript+r;
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+fScript+".png");
		//				String path = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}

//				try {
//					String screenShotName = WebDriverUtility.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
//					test.addScreenCaptureFromPath(screenShotName);
//				} 
//				catch (IOException e) 
//				{
//					e.printStackTrace();
//				}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("TestScripts Execution Failed",true);

	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---->Skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log("TestScript execution Skipped",true);
	}

	public void onStart(ITestContext context) 
	{
		//		create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Test Yantra");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Jumia Food");

		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base_URL", "http://rmgtestingserver/domain/Online_Food_Ordering_System/login.php");
		report.setSystemInfo("Reporter Name", "Manjunath");
	}

	public void onFinish(ITestContext context) 
	{
		//		consolodate the report
		report.flush();
	}

}
