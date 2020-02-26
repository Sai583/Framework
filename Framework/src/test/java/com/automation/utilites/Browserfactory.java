package com.automation.utilites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactory {

	static WebDriver driver;
	
	
	  public static WebDriver Crosbrowser(WebDriver ldriver,String browsername,String Url) {
		  
		  if(browsername.equalsIgnoreCase("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			  driver = new FirefoxDriver();	 
		   }
		  
		  else if(browsername.equalsIgnoreCase("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			  driver = new ChromeDriver(); 
		  }
		  
		  else if(browsername.equalsIgnoreCase("IE"))
		  {
			  System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			  driver = new InternetExplorerDriver(); 
		}
		  else
		  {
			  System.out.println("we do not support this browser");
		  }
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(Url);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;
	  }
	  
	  public static void quitBrowser(WebDriver driver)
	  {
		  driver.quit();
	  }
}
