package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilites.Browserfactory;
import com.automation.utilites.ExcelDataProvider;
import com.automation.utilites.Helper;

public class LoginTest extends BaseClass{
	
	
	@Test
	public void loginTest()
	{
		System.out.println(ldriver.getTitle());	
		
		logger=report.createTest("Login to Guru99Bank");
		
		//Abstraction - only high level code is visible and essential code is hidden
	LoginPage log = PageFactory.initElements(ldriver,LoginPage.class);
	
	logger.info("Starting application");
	
	 log.Login_Button(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
	 
	 logger.pass("Login done successfully");
	 }
	
}
 