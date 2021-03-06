package com.qa.crm.base;

import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.util.UtilData;
import com.qa.crm.util.WebdriverEventListener;

public class Base {

	public static WebDriver driver;
	public static EventFiringWebDriver eventDriver;
	public static WebdriverEventListener eventListener;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Wait<WebDriver> wait2;
	public static Actions action;
	
	public Base(){
		FileInputStream fp;
		prop = new Properties();
		try {
			fp=new FileInputStream("C:\\Users\\SUBRAMANYA K N P\\workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\crm\\util\\config.properties");
			prop.load(fp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initalization(){
		
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver_2.38\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		else if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		eventDriver=new EventFiringWebDriver(driver);
		eventListener=new WebdriverEventListener();
		eventDriver.register(eventListener);
		driver=eventDriver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilData.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilData.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, UtilData.WEBDRIVERWAIT_TIMEOUT);
		wait2=new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).
				pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		action=new Actions(driver);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
