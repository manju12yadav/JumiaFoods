package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgYantraProjectTest {

	public static void main(String[] args) throws Throwable 
	{
		Random rd=new Random();
		int ran = rd.nextInt(100);
		Connection con =null;
		String eProj = "Namma Metro_"+ran;
		try {	
		WebDriverManager.chromedriver().create();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver:8084");
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			driver.findElement(By.xpath("//span[.='Create Project']")).click();
			driver.findElement(By.name("projectName")).sendKeys(eProj);
			driver.findElement(By.name("createdBy")).sendKeys("Govt of Karnataka_"+ran);
			WebElement prStatus = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s=new Select(prStatus);
			s.selectByVisibleText("Created");
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			
			Driver dr=new Driver();
			DriverManager.registerDriver(dr);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stat = con.createStatement();
			String query = "select * from project;";
			ResultSet result = stat.executeQuery(query);
			
			boolean flag=false;
			while(result.next())
			{
				String aProj = result.getString(4);
				System.out.println(aProj);
				if(aProj.equalsIgnoreCase(eProj))
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				System.out.println("Project Created");
			}
			else
			{
				System.out.println("Project not Created");
			}
		}
		catch (Exception e) 
		{
		}
		finally 
		{
			con.close();
		}

			
		}

}
