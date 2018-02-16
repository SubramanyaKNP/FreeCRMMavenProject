package com.qa.crm.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.crm.util.UtilData;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
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
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32_new\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		else if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilData.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilData.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, UtilData.WEBDRIVERWAIT_TIMEOUT);
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
