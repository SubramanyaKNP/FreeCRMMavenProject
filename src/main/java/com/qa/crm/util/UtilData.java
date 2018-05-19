package com.qa.crm.util;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.qa.crm.base.Base;

public class UtilData extends Base{

	public static long PAGELOAD_TIMEOUT=50;
	public static long IMPLICIT_TIMEOUT=20;
	public static long WEBDRIVERWAIT_TIMEOUT=20;
	//public static JavascriptExecutor js;
	public static void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
	}

	public static void validateForBrokenLinks(List<WebElement> list) throws MalformedURLException, IOException{
		for(int i=0;i<list.size();i++){
			String link=list.get(i).getAttribute("href");
			HttpURLConnection url = (HttpURLConnection) new URL(link).openConnection();
			url.connect();
			String response = url.getResponseMessage();
			url.disconnect();
			System.out.println("The response of the url "+link+" is "+response);
		}
	}
	
	
	public static void screenShot(){
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		/*
		 * FileUtils is not available from selenium 3.6 onwards. Instead use FileHandler from selenium.io file handler 
		 */
		//FileUtils.copyFile(src, new File("C:\\Users\\SUBRAMANYA K N P\\workspace\\FreeCRMTest\\Screenshots"+System.currentTimeMillis()+".png"));
		/*
		 * File handler is available from 3.6 onwards 
		 */
		try{
		FileHandler.copy(src, new File("C:\\Users\\SUBRAMANYA K N P\\workspace\\FreeCRMTest\\Screenshots\\"+System.currentTimeMillis()+".png"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void flash(WebElement element,WebDriver driver){
		String bgColor=element.getCssValue("backGroundColor");
		for(int i=0;i<2;i++){
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgColor,element,driver);
		}
	}
	
	public static void changeColor(String bgColor,WebElement element,WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+bgColor+"'",element);
		try{Thread.sleep(2000);}
		catch(Exception e){e.printStackTrace();}
	}
	
	public static void drawBorder(WebElement element,WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='6px solid red'", element);
	}
	
	public static WebElement findElementUsingID_JS(String ID){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=null;
		element = (WebElement) js.executeScript("return document.getElementById("+ID+")",element);
		return element;
	}
	
	public static void clickElement_JS(WebElement element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	
	public static void ClickOnRadioByAttribute(){
		
	}
	
	
}
