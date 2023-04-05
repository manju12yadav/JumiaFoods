package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con=null;
	
	/**
	 * This method is used to connect to Database
	 * @throws Throwable
	 * @author Manjunath Yadav
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUSERNAME,IPathConstants.DBPASSWORD);
	}
	
	/**
	 * This method is used to executeQueryAndGetData from DataBase
	 * @param query
	 * @param exData
	 * @param columnIndex
	 * @return
	 * @throws SQLException
	 * @author Manjunath Yadav
	 */
	
	public String executeQueryAndGetData(String query,String exData,int columnIndex) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(exData))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println(exData+" is Verified");
			return exData;
		}
		else
		{
			System.err.println(exData+" is not Verified");
			return "";
		}
	}
	
	/**
	 * This method is used to close the DataBase Connection
	 * @throws SQLException
	 * @author Manjunath Yadav
	 */
	public void closeDB() throws SQLException
	{
		con.close();
		System.out.println("DataBase Connection Closed");
	}
}
