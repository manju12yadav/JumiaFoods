package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/**
	 * This method is used to get the Random num
	 * @return
	 * @author Manjunath Yadav
	 */
	public int random()
	{
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	/**
	 * This method is used to get System Date
	 * @return
	 */
	public String getSystemDate()
	{
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	/**
	 * This method is used to get the date in desired format
	 * @return
	 */
	public String formatSystemDate()
	{
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		 Date dt=new Date();
		 String getDtAndTm = dateFormat.format(dt);
		 getDtAndTm.replace(":","-");
		 return getDtAndTm;
	}
}
