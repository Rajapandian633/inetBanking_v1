package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass //using extents keyword is to inherit the Baseclass
{                                                      //we can access the baseclass methods from here 
	
	@Test
	
	public void addnewCustomer() throws Exception
	{ //The throws keyword indicates exception type may be thrown by a method
		
		logger.info("URL is opened");
		
		//creating driver object parameter as driver
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.ClickSubmit();
		
		//creating object for add customer page 
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		//using implicit wait to handle the test failure 
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		addcust.clickAddNewCustomer();
		
		
		//using implicit wait to handle the test failure 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		logger.info("providing customer details....");
		
		//objectname.pageobject.values
		addcust.custName("Raja");
		addcust.custgender("male");
		addcust.custdob("09","18","1996");
		addcust.custaddress("Amman street");
		addcust.custcity("Chennai");
		addcust.custstate("Tamilnadu");
		addcust.custpinno("624704");
		addcust.custtelephoneno("9876543210");
		//every time login required unique gmail id so method inside the baseclass for reuse
		//here we used random string generate method to generate the random gmail for multiple login
		String email=randomestring()+"@gmail.com";
		//objectname.pageobject(email as a parameter);
		addcust.custemailid(email);
		addcust.custpassword("raja");
		addcust.custsubmit();
		
		//after created the new customer we have to check the page heading 
		//so we used this boolean for verify res object
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		//using if else condition and assert 
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Add customer test case passed....");
		}
		else
		{
			logger.info("Add customer test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	

}
