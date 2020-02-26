package com.automation.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(name="uid") 
	@CacheLookup
	WebElement Username;
	
	@FindBy(how=How.NAME, using ="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH, using ="//input[@name=\"btnLogin\"]")
	WebElement Login_Button;
	
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
		 	
	}
	
	public void Login_Button(String uid,String pass)
	{
		Username.sendKeys(uid);
		Password.sendKeys(pass);
		Login_Button.click();
	}
	


}
