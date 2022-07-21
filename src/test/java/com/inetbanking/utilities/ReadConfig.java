package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


//this class is used to read the config.properties file 
public class ReadConfig
{

	Properties pro;
	//creating the constructor to read the properties file
	public ReadConfig()
	{
	File src = new File("./Configuration/config.properties");//folder location
	try 
	{
		FileInputStream fis = new FileInputStream(src);//FileInputStream is to read
		pro = new Properties();
		pro.load(fis);//load is a method
	}
	catch (Exception e)
	{
		System.out.println("Exception is " + e.getMessage());
	}
	}
	
	//action methods for below details
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
		}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
		}
	public String getpassword()
	{
		String password=pro.getProperty("password");
		return password;
		}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
		}
	public String getedgepath()
	{
		String edgepath=pro.getProperty("edgepath");
		return edgepath;
		}


	}

