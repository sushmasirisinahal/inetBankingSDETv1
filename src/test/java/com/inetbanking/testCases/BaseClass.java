package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

//import Demo.log4jDemo;


public class BaseClass {
	//Hard coding
	/*
	public String baseURL="http://demo.guru99.com/V1/index.php";
	public String username="mngr47659";
	public String password="123456@";
	public static WebDriver driver;			*/
	
	//Dynamic coding from ReadConfig.java
	
		ReadConfig readconfig=new ReadConfig();
	
		public String baseURL=readconfig.getApplicationURL();
		public String username=readconfig.getUserName();
		public String password=readconfig.getPassword();;
		public static WebDriver driver;	
	
	public static Logger logger;
	
	
	//annotation for browser from testng.xml
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) //add the variable to get browser variable from testng.xml
	{
		//Log4j configuration
		//logger= LogManager.getLogger(BaseClass.class.getName());
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe"); //give the chromepath
		//System.setProperty("webdriver.chrome.driver", readconfig.getChromepath()); //path in properties file
		//driver=new ChromeDriver();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath()); 
			driver=new ChromeDriver();	
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath()); 
			driver=new FirefoxDriver();	
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath()); 
			driver=new InternetExplorerDriver();	
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getMSEdgepath()); 
			driver=new EdgeDriver();	
		}
		
		driver.get(baseURL); // earlier used in in TC where @Test annotation is available, moved here when using testng.xml
			
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	//To capture screenshots we get from Reporting class and place them in Screenshots folder
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+"_"+timeStamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//random string for email address as it will not take email repeatedly
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
		
	//random string for email address as it will not take email repeatedly
	public String randomnumber()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
}
