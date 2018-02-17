package com.qa.crm.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Failed Test case::: "+arg0.toString());
		System.out.println("Taking screen shot....");
		UtilData.screenShot();
		System.out.println("Screen shot taken");
	}

	public void onTestSkipped(ITestResult arg0) {
	
		System.out.println("Skipped Testcases::: "+arg0.getName().toString());
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("Starting the test "+arg0.toString());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("passed test case "+arg0.toString());
	}

}
