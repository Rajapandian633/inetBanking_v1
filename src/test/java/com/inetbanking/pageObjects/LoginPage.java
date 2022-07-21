package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //creating the driver objects have to import webDriver from selenium

    WebDriver ldriver;

    //this is the constructor (webdriver is a parameter)

    public LoginPage(WebDriver rdriver)
    {
    	//initiating the driver using pagefactory.inielemts

    	ldriver=rdriver;
    	PageFactory.initElements(rdriver, this);
    }

    //finding the elements using findby

    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name="password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement btnLogin;
    
    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement lnkLogout;

    //Action methods for login page or above elements
    
    //public void using set method and using(String Name)
    public void setUserName(String uname)
    {
    	txtUserName.sendKeys(uname);
    }

    //Action methods for password

    public void setPassword(String pwd)
    {
    	txtPassword.sendKeys(pwd);
    }

    //Action methods for Login button

    public void ClickSubmit()
    {
    	btnLogin.click();
    }
    public void ClickLogout()
    {
    	lnkLogout.click();
    }



    }
