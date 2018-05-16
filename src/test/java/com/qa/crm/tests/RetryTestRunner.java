package com.qa.crm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qa.crm.util.UtilData;

public class RetryTestRunner{

	public WebDriver driver;
	
	public RetryTestRunner(){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32_new\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	
@Test
public void test1(){
	driver.get("https://ssc.larsentoubro.com/PrmHome");
	WebElement input=UtilData.findElementUsingID_JS("username");
	input.sendKeys("abcdef");
}

}
