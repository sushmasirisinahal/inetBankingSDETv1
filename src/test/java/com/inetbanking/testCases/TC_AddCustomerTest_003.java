package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{

	@Test
	public void addNewCustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Provided Username");
		lp.setPassword(password);
		logger.info("Provided Password");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		driver.manage().window().maximize();
		
		logger.info("Providing customer details..");
		
		addcust.custName("Pavan");
		addcust.custGender("male");
		addcust.custDob("10","15","1985");
		Thread.sleep(3000);
		logger.info("DOB entered.");
		addcust.custAddress("INDIA");
		addcust.custCity("HYD");
		addcust.custState("AP");
		addcust.custPin(501505);
		addcust.custTelephone("987890091");
		String email=randomstring()+"@gmail.com";
		addcust.custEmail(email);
		addcust.custPassword("abcdef");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		logger.info("Validation started...");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed.");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed.");
		}

		
	}
	
	
}
