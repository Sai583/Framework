package com.automation.utilites;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	//Screenshots, alerts, frames, windows, sync Issues, javascript Executor
	
	public static String capturescreenshot(WebDriver driver)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		String screenshot_path=System.getProperty("user.dir")+"./Screenshots/guru99"+getCurrentDateFormat() +".png";
		File Dest= new File(screenshot_path);
		
		try {
			FileHandler.copy(src, Dest);
			
			System.out.println("Screenshot capture");
		} 
		catch (Exception e)
		{
			System.out.println("Unable to capture screenshot"+e.getMessage());
		}
		
		return screenshot_path;
		
		
	}
	
	public static String getCurrentDateFormat()
	{
		DateFormat custom=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss ");
		
		Date currentDate= new Date();
		return custom.format(currentDate);
		
	}

}
