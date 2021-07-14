package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL); //get base URL from set up method, this will be used in base url itself under setup method when using testng.xml
		
		//log4j
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login is successful.");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.info("Login failed.");
		}
		
	}
	
	

}
