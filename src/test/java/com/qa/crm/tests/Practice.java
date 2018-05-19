package com.qa.crm.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.crm.base.Base;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.UtilData;

public class Practice extends Base{

	
	
	@FindBy(xpath="//a[text()='Deals']")
	public WebElement deal;
	
	@FindBy(name="cs_closed")
	public WebElement radio;
	
	public Practice() {
		super();
		initalization();
		PageFactory.initElements(driver, this);
		LoginPage lp=new LoginPage();
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		
}
	
	@Test
	public void testIt() throws IOException{
		UtilData.switchToFrame(prop.getProperty("homePage_frame"));
		String attr=prop.getProperty("dealAttrbute");
		//action.moveToElement(task).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(deal));
		action.moveToElement(deal).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(radio));
		List<WebElement> radios=driver.findElements(By.name("cs_closed"));
		for(int i=0;i<radios.size();i++){
			if(radios.get(i).getAttribute("value").equals(attr)){
				radios.get(i).click();
				break;
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	
}
