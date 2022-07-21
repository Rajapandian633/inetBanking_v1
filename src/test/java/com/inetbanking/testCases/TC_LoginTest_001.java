package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass //using extents keyword is to inherit the Baseclass
{                                                //we can access the baseclass methods from here
	@Test
	public void loginTest() throws Exception //The throws keyword indicates exception type may be thrown by a method
	{
		//calling the driver object to get the website

		//using logger

		logger.info("URL is opened");

		//maximizing the window

		//driver.manage().window().maximize();

		//creating the object Loginpage =lp parameter as a driver

        LoginPage lp=new LoginPage(driver);

        // using set method

        lp.setUserName(username);

        //using logger to check username entering

        logger.info("Entered Username");

        lp.setPassword(password);

        //using logger to check entering password

        logger.info("Entered password");

        lp.ClickSubmit();
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //using assert to verify the element on the page or not

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
        {
        	Assert.assertTrue(true);

        	//using logger to check the test

        	logger.info("Login test passed");
        }
        else
        {   
        	//calling the screenshot capture method from baseclass
        	captureScreen(driver,"loginTest");
        	logger.info("Login test failed");
        	Assert.assertTrue(false);
        	

        }
	}
}


