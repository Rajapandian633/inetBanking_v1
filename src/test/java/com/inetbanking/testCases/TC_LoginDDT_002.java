package com.inetbanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass //using extents keyword is to inherit the Baseclass
{                                                //we can access the baseclass methods from here

	private static final TimeUnit Seconds = null;


	@Test(dataProvider="LoginData") //using testng dataprovider 
	public void loginDDT(String user,String pwd) throws Exception 
	//The throws keyword indicates exception type may be thrown by a method
	{ 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);// creating object
		
		lp.setUserName(user);
		
		logger.info("user name provided"); //using log4j to generate the logs
		
		lp.setPassword(pwd);
		
		logger.info("password provided");
		
		lp.ClickSubmit();
		
		//Thread.sleep(3000);// using thread.sleep to handle test failure due to network issue
		
		
		//using is alertpresent() to check the alerts presented in the page or not 
		if(isAlertPresent()==true)
		{  
			driver.switchTo().alert().accept();//its used to close alert
			logger.warn("Login Failed");
			driver.switchTo().defaultContent();//it is used to redirect the flow towards login
			Assert.assertTrue(false);
					
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			lp.ClickLogout();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.switchTo().alert().accept();//its used to close logout alert			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is preset or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	//scanning the data using two dimensional array
	@DataProvider(name="LoginData") //using testng dataprovider method 
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;//return 
	}
	
}