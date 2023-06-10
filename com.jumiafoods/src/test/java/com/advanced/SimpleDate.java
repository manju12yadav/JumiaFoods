package com.advanced;

import java.text.ParseException;

import com.GenericUtilities.JavaUtility;

public class SimpleDate 
{

	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jLib=new JavaUtility();
		String dt = jLib.simpleDate("15/08/2021");
		System.out.println(dt);
		
	}

}
