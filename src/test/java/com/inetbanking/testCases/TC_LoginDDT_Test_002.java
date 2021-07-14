package com.inetbanking.testCases;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_Test_002 extends BaseClass 
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User name is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		//verify if the alert is open (with invalid login details)
		if(isALertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();	//focus back to home page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true); // make it true and click on logout link to go back to home page
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	//verify if the alert is open (with invalid login details), this is reusable alert
	public boolean isALertPresent()
	{	
		try
		{
		//if alert is present it will switch else it will throw exception
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData") //get data from excel to 2 dimensional array
	String[][] getData() throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
				
		String logindata[][]=new String [rownum][colcount];
				
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j); //1,0
				
			}
		}
		return logindata;
	}
}
