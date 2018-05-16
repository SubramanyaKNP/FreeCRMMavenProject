package com.qa.crm.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.crm.base.Base;
import com.qa.crm.pages.*;



@Listeners(com.qa.crm.TestNGListeners.TestListener.class)

public class LoginPageTests extends Base{

	LoginPage lgnPge;
	HomePage hmePge;
	
	public LoginPageTests(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initalization();
		lgnPge = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void login(){
		hmePge = lgnPge.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
