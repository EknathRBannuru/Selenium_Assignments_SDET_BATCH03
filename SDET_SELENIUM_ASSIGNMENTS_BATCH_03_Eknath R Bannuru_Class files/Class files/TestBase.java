package com.qa.testsScripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver Driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		
		try {
			fileLoc = new FileInputStream("D:\\SeleniumTraining\\com.qa.devlabs.selenium\\Configuration\\config.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			Driver = new InternetExplorerDriver();
		} 
		
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.get(prop.getProperty("url"));
		
	}
	
	@AfterClass
	public void tearDown() {
		Driver.quit();
	}
	
	
	
	// parent class
	// pre-requisite are coded...
	
	/*
	 * 1. instializing & Instantiating the browser 2. Open the URL 3. Maximize the
	 * window 4. Page load timeout 5. Delete cookies
	 * 
	 * 
	 * 3. Close the browser
	 */
	

}
