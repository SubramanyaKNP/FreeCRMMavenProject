package com.qa.crm.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frames{

	@Test
	public void test1() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32_new\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("C:\\Users\\SUBRAMANYA K N P\\Desktop\\Frames.html");
		String mainWindow = driver.getWindowHandle();
		driver.switchTo().frame("frame1");
		driver.findElement(By.name("textbox")).sendKeys("Frame1");
		Thread.sleep(4000);
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("inp1")).sendKeys("outside frame");
		Thread.sleep(4000);
		driver.close();
	}
	
}
