package com.qa.crm.util;

import com.qa.crm.base.Base;

public class UtilData extends Base{

	public static long PAGELOAD_TIMEOUT=20;
	public static long IMPLICIT_TIMEOUT=20;
	public static long WEBDRIVERWAIT_TIMEOUT=20;
	
	public static void switchToFrame(String frameName){
		driver.switchTo().frame(frameName);
	}
	
	
}
