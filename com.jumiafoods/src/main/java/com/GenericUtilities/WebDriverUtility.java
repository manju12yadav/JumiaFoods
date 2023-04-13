package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	

	/**
	 * This method is used to Maximize the window
	 * @param driver
	 * @author Manjunath Yadav
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to Refresh the Page/Window
	 * @param driver
	 */
	public void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}

	/**
	 * This method is used to Implicit Wait for page to load
	 * @param driver
	 * @author Manjunath Yadav
	 */
	public void implicitWaitForLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	/**
	 * This method is used to Wait for page to load
	 * @param driver
	 * @author Manjunath Yadav
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to Explicit wait conditions to wait until the element gets loaded
	 * @param driver
	 * @param element
	 * @author Manjunath Yadav
	 */
	public void elementTobeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to Select the data from dropdown by value
	 * @param element
	 * @param value
	 * @author Manjunath Yadav
	 */
	public void select(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to Select the data from dropdown by index
	 * @param element
	 * @param index
	 * @author Manjunath Yadav
	 */
	public void select(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to Select the data from dropdown by visible Text
	 * @param text
	 * @param element
	 * @author Manjunath Yadav
	 */
	public void select(String text ,WebElement element )
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method will perform MouseHover action
	 * @param driver
	 * @param element
	 * @author Manjunath Yadav
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dest
	 * @author Manjunath Yadav
	 */
	public void dragAndDrop(WebDriver driver,WebElement src, WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	/**
	 * This method will perform Double Click action
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}

	/**
	 * This method will perform Right Click action
	 * @param driver
	 * @author Manjunath Yadav
	 */

	public void rightClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * This method will perform Right Click action on element
	 * @param driver
	 * @param element
	 * @author Manjunath Yadav
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * This method will Press Enter Key
	 * @param driver
	 */

	public void enterKey(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method will Press Enter Key
	 * @param driver
	 * @throws AWTException
	 */

	public void enterKeyPress() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_M);
	}

	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws AWTException
	 */

	public void enterRelease() throws AWTException
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 *  This method will switch the frame based on index
	 * @param driver
	 * @param index
	 * @author Manjunath Yadav
	 */

	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 * @author Manjunath Yadav
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 *  This method will switch the frame based on Name ID
	 * @param driver
	 * @param nameID
	 * @author Manjunath Yadav
	 */
	public void switchToFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	/**
	 * This method is used to get the text of alert popup
	 * @param driver
	 * @return 
	 */
	public String getTextAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * This method is used to accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to cancel alert popup
	 * @param driver
	 * @author Manjunath Yadav
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This Method will be used to switch between multiple Windows based on Title
	 * @param driver
	 * @param partialTitle
	 * @author Manjunath Yadav
	 */

	public void switchToWindow(WebDriver driver,String partialTitle)
	{
		//Step1: Use getWindowhandles to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//Step2: Iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//Step3: Check whether there is next window
		while(it.hasNext())
		{
			//Step4: Capture current window ID
			String winId = it.next();
			
			//Step5: Switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//Step6: Check whether current window is expected
			if(currentWinTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		JavaUtility jLib=new JavaUtility();
		int st = jLib.random();
//		String sdt = new JavaUtility().formatSystemDate();
		String path="./ScreenShot/"+screenShotName+st+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 * @author Manjunath Yadav
	 */
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 * @author Manjunath Yadav
	 */
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
//		js.executeScript("argument[0].scrollIntoView()", element);
	}
	

}
