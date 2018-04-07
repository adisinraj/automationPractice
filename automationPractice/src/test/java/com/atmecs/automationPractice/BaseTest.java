package com.atmecs.automationPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Unit test for simple App.
 */
public class BaseTest{
	
	public WebDriver driver = null;
	public static Properties properties= null;
	
	@Parameters("browser")
	@BeforeClass
	public void loadConfigurationFile(String browser) {
		properties = new Properties();
		System.out.println(1);
		ClassLoader classLoader = getClass().getClassLoader();
		System.out.println(2);
		String filePath = classLoader.getResource("config.properties").getPath();
		System.out.println(3);
		
		try {
			properties.load(new FileInputStream(new File(filePath)));
			} catch (IOException e) { 
			e.printStackTrace();
			}
		
	if(browser.equalsIgnoreCase("chrome")){
		  System.setProperty(properties.getProperty("chromedriverkey"),properties.getProperty("chromedriverpath"));
		  driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
	}
	}
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
	}