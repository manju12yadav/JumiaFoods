package com.GenericUtilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;

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
	
	/**
	 * This method is used to get the date in dd/m/yy
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	
	public String simpleDate(String date) throws ParseException
	{
//		String date="12/05/2023";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/m/yy");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
//		cal.add(Calendar.DAY_OF_MONTH, 0);
		String newdate = sdf.format(cal.getTime());
		String exp = newdate.replace('/', '-');
//		System.out.println(exp);
		return exp;
	}	
	
	public String standardSystemDate()
	{
		Date cdt=new Date();
		String[] d = cdt.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];
		String travelDate = day+" "+month+" "+date+" "+year;
		
		return travelDate;
	}
	
}
