package com.qa.crm.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.qa.crm.base.Base;

public class HomePage extends Base{

	@FindBy(xpath="//td[contains(text(),'User: Naveen')]")
	WebElement userName_homePage;
	
	@FindBy(xpath="//a[.='Contacts']")
	WebElement contactsLink;
	
	
	@FindBy(linkText="Deals")
	WebElement dealsLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver,this);
	}
	
	public String getHomePageUsername(){
		wait.until(ExpectedConditions.visibilityOf(userName_homePage));
		return userName_homePage.getText().toString();
	}
	
	
	public ContactsPage clickOnContactsLink(){
		action.moveToElement(contactsLink).build().perform();
		action.click(contactsLink).build().perform();
		//contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
}
