package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToDBTest {

	public static void main(String[] args) throws SQLException 
	{
		Connection con = null;
		int result = 0;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jumia_food","root","root");
		Statement state = con.createStatement();
		String query = "insert into students values('Baalu',386,'AirPortRoad','Sriram',7);";
		result = state.executeUpdate(query);
		}
		catch (Exception e) {
		}
		finally {
			
		if(result==1)
		{
			System.out.println("Data is Updated");
		}
		else
		{
			System.err.println("Data is not Updated");
		}
		
		con.close();
		}
		
	}

}
