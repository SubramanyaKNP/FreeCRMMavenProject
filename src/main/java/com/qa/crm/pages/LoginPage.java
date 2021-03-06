package com.qa.crm.pages;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.crm.base.*;

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
		//UtilData.flash(lgnBtn, driver);
		//UtilData.drawBorder(lgnBtn, driver);
		System.out.println("Username is "+uname);
		System.out.println("Pssword is "+pwd);
		//wait.until(ExpectedConditions.visibilityOf(usrname));
		WebElement usrname1=wait2.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver){
				return usrname; 
			}
		});
		usrname1.sendKeys(uname);
		wait.until(ExpectedConditions.visibilityOf(pwrd));
		pwrd.sendKeys(pwd);
		wait.until(ExpectedConditions.elementToBeClickable(lgnBtn));
		/*action.moveToElement(lgnBtn).build().perform();
		action.click().build().perform();
		*/
		action.moveToElement(lgnBtn).click().build().perform();
		return new HomePage();
	}
	
}
