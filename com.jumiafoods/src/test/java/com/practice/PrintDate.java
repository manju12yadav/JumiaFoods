package com.practice;

import java.util.Date;

public class PrintDate {

	public static void main(String[] args) 
	{
//		JavaUtility jLib = new JavaUtility();
//		String st = jLib.formatSystemDate();
		Date dt = new Date();
		String st = dt.toString();
		System.out.println(st);
	}

}
