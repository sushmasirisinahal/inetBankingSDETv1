package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}

	}

	//Methods to read each value
	//get application url method
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	//get application username method
	public String getUserName()
	{
		String uname=pro.getProperty("username");
		return uname;
	}

	//get application password method
	public String getPassword()
	{
		String pswd=pro.getProperty("password");
		return pswd;
	}

	//get application chromepath method
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	//get application firefox path method
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	//get application IE path method
	public String getIEpath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

	//get application MS Edge path method
	public String getMSEdgepath()
	{
		String msEdgepath=pro.getProperty("msedgepath");
		return msEdgepath;
	}



}
