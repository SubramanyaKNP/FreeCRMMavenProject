package com.qa.crm.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.qa.crm.base.Base;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

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
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
