package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	
	/**
	 * This method is used to get the data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 * @author Manjunath Yadav
	 */
	public String readFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstants.FILEPATH);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
}
