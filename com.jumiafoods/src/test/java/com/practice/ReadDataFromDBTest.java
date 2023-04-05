package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBTest 
{
	
	public static void main(String[] args) throws SQLException 
	{
		Connection con=null;
		try {
		Driver driver=new Driver();
//		Step 1: Register to DB
		DriverManager.registerDriver(driver);
//		Step 2: Create or Establish Connection b/w DB
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manjusdb","root","root");
//		Step 3: Create Statement
		Statement state = con.createStatement();
		String query = "select * from students;";
//		Step 4: Execute the Query
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
		}
		}
		catch (Exception e) {
		}
		finally {
//		Step 5:	Close the Connection b/w DB
			con.close();	
		}
		
	}

}
