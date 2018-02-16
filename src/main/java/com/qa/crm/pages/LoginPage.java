package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.crm.base.Base;

public class LoginPage extends Base{

	@FindBy(name="username")
	WebElement usrname;
	
	@FindBy(name="password")
	WebElement pwrd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement lgnBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	public HomePage login(String uname,String pwd){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(usrname));
		usrname.sendKeys(uname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pwrd.sendKeys(pwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(lgnBtn));
		//lgnBtn.click();
		action.moveToElement(lgnBtn).build().perform();
		action.click().build().perform();
		return new HomePage();
	}
	
}
