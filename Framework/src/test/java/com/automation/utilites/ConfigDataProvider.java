package com.automation.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src= new File("./Config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro= new Properties();
			
			pro.load(fis);
		} 
		catch (Exception e) {

			System.out.println("Unable to read Excel file"+ e.getMessage());	
		}
		
		
	}
	
	public String getDatafromConfig(String keytosearch)
	{
		return pro.getProperty(keytosearch);
		
	}
	
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
		
	}
	
	
	public String getStaggingUrl()
	{
		return pro.getProperty("qaUrL");
		
	}

}
