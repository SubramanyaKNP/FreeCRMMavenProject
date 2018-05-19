package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.Base;
import com.qa.crm.util.UtilData;

public class DealsPage extends Base{

	
	@FindBy(xpath="//a[text()='Deals']")
	public WebElement _deals;
	
	@FindBy(xpath="//a[text()='New Deal']")
	public WebElement _newDeals;
	
	@FindBy(id="title")
	public WebElement _titleField;
	
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement _saveBtn;
	
	
	public DealsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void createDeals(String titleName){
		_titleField.sendKeys(titleName);
		action.moveToElement(_saveBtn).click().perform();
	}
	
	public void navigateToDeals(){
		action.moveToElement(_deals).perform();
		UtilData.clickElement_JS(_newDeals);
	}
}
