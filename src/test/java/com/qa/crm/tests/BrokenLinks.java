package com.qa.crm.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.crm.base.Base;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.UtilData;

public class BrokenLinks extends Base {

	public BrokenLinks() {
		super();
		initalization();
		LoginPage lp = new LoginPage();
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void validateForBrokenLinks() {
		driver.switchTo().frame(prop.getProperty("homePage_frame"));
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		// linksList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activeLinksList = new ArrayList<WebElement>();
		for (WebElement we : linksList) {
			if (we.getAttribute("href") != null && !we.getAttribute("href").toString().contains("javascript"))
				activeLinksList.add(we);
		}
		try {
			UtilData.validateForBrokenLinks(activeLinksList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

}
