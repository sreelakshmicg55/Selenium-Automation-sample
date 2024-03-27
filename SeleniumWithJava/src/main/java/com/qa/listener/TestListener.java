package com.qa.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utils.ExtentManager;
import com.qa.utils.TestUtils;

public class TestListener extends TestUtils implements ITestListener{
	

	static ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case "+result.getMethod().getMethodName()+" passed successfully");
		test.log(Status.PASS, "Test Case "+result.getMethod().getMethodName()+" passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case "+result.getMethod().getMethodName()+" got failed");
		
		//Take Screenshot
		TestUtils.TakeScreenShotWhenFailed(result.getMethod().getMethodName());
		
		//Log to ExtentReport
		test.log(Status.FAIL, "Test Case "+result.getMethod().getMethodName()+" got failed");
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case "+result.getMethod().getMethodName()+" got skipped");
		
		//Take Screenshot
				TestUtils.TakeScreenShotWhenFailed(result.getMethod().getMethodName());
				
		
		//Log to ExtentReport
		test.log(Status.SKIP, "Test Case "+result.getMethod().getMethodName()+" got skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
		report = ExtentManager.createExtentReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		// Flush to ExtentReport
		report.flush();
	}
	
	


}
