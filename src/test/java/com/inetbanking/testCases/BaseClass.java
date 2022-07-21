package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;



//created base class = tear down method
//this are the reusable components

public class BaseClass {


	//creating object to access the Readconfig.java

	ReadConfig readconfig = new ReadConfig();
	public String baseURL =readconfig.getApplicationURL();
	public String username =readconfig.getUsername();
	public String password =readconfig.getpassword();
	public static WebDriver driver;

	//implementing logger4j

	public static Logger logger;

	//using testng annotations for setup method

	//this is the setup method and its reusable

	@Parameters("browser")//using @parameter annotations to achieve multiple browser test
	@BeforeClass
	public void setup(String br)
	{
		
		//implemented the logger and used getlogger method to get
        
		logger = Logger.getLogger("ebanking");

		//using configure method to configure the log4j propertyfiles

		PropertyConfigurator.configure("log4j.properties");
		

		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
		driver=new ChromeDriver();
		}
		
		else if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver",readconfig.getedgepath());
		driver=new EdgeDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//using wait statement
		driver.get(baseURL);
	}

	//this is the teardown method
    //it will execute after class
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Browser closed");
	}
	
	// this method is to tack screenshot we can reuse this method 
	public void captureScreen(WebDriver driver, String tname) throws Exception 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//this method is to generate the random string for multiple login generate gmailid 
	//we can resue this method 
	
	public String  randomestring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
	//this method is to create random number we can resue this method
	
	public static String randomNum()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return generatedString2;
	}

}


