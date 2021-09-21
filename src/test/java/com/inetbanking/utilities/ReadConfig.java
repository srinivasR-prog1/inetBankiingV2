package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	
	public ReadConfig()
	{
	
	File src = new File("./Configuration/config.properties");
	
	try{
		
		FileInputStream fis = new FileInputStream(src);
		
		prop= new Properties();
		prop.load(fis);
		
		
	}catch(Exception e)
	{
		System.out.println("Exception is"+e.getMessage());
		
	}
			
			
	}
	
	public String getApplicationURL()
	{
		
		String url = prop.getProperty("baseURL");
		return url;
		
		
		
	}
	public String getUsername()
	{
		
		String usrname = prop.getProperty("username");
		return usrname;
		
		
		
	}
	public String getPassword()
	{
		
		String paswd = prop.getProperty("password");
		return paswd;
		
		
		
	}
	public String getChromePath()
	{
		
		String chromepath = prop.getProperty("chropath");
		return chromepath;
		
		
		
	}
	public String getFirefoxPath()
	{
		
		String firefoxpath = prop.getProperty("ffpath");
		return firefoxpath;
		
		
		
	}

}
