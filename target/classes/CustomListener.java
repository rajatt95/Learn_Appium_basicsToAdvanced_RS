package com.learning.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.learning.base.TestBase_Install_App_EveryTime;

public class CustomListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("onFinish()");
	}

	public void onStart(ITestContext arg0) {
		System.out.println("onStart()");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("onTestFailedButWithinSuccessPercentage()");
	}

	public void onTestFailure(ITestResult result) {
		// System.out.println("testName : " + result.getTestName());

		
		String testCaseName=result.getName();
		System.out.println("Test case name: " + testCaseName);
		System.out.println("onTestFailure()");

		TestBase_Install_App_EveryTime.captureScreenshot(testCaseName);

	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("onTestSkipped()");
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("onTestStart()");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("onTestSuccess()");
	}

}
