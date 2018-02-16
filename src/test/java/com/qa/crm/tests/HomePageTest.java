package com.qa.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.Base;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.UtilData;

public class HomePageTest extends Base {

	LoginPage lgnPge;
	HomePage hmePge;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initalization();
		lgnPge=new LoginPage();
		hmePge = lgnPge.login(prop.getProperty("username"),prop.getProperty("password"));
		UtilData.switchToFrame(prop.getProperty("homePage_frame"));
	}
	
	@Test(priority=1)
	public void verifyHomePageUsername(){
		String homePageUsername = hmePge.getHomePageUsername();
		homePageUsername=homePageUsername.trim();
		Assert.assertEquals("User: Naveen K",homePageUsername);
	}

	@Test(priority=2)
	public void clickOnContacts(){
		hmePge.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
