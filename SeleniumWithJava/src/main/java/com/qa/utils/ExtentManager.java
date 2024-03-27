package com.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extentReports ;
	
    public static ExtentReports createExtentReports() 
    {
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");	
    	Date date = new Date();
    	String actualDate = format.format(date);
    	
    	String reportpath = System.getProperty("user.dir")+"\\Reports\\ExtentReport_"+actualDate+".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);
        
        extentReports= new ExtentReports();
        
        reporter.config().setReportName("Extent Report for Automation run");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Sreelakshmi");
        return extentReports;
    }

}
    
