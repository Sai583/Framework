package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilites.Browserfactory;
import com.automation.utilites.ConfigDataProvider;
import com.automation.utilites.ExcelDataProvider;
import com.automation.utilites.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver ldriver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupsuite()
	{
		Reporter.log("Setting up  reports ", true);
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reporters/guru99bank"+Helper.getCurrentDateFormat()+".html"));
		 report = new ExtentReports();
		 report.attachReporter(extent);
		 Reporter.log("Setting up  reports-done ", true);
	}
	
	@BeforeClass
	public void startup()
	{
		Reporter.log("Browser started ", true);
		ldriver=	Browserfactory.Crosbrowser(ldriver,config.getBrowser(),config.getStaggingUrl());
		Reporter.log("Application is up and running ", true);
	}
	
	
	@AfterMethod
	public void screenshot(ITestResult result) throws IOException 

	{
		Reporter.log("Taking the screenshot ", true);
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Testpassed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(ldriver)).build());
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
	
			logger.fail("Testfailed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(ldriver)).build());
		}
		
		report.flush();
		Reporter.log("Test Completed >> Reports generated", true);
	}
	
	@AfterClass
	public void teardown()
	{
		  Browserfactory.quitBrowser(ldriver);
	}

}
