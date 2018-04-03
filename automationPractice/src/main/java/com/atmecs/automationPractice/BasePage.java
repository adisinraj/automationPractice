package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;

public class BasePage {
	 
	public static WebDriver driver;
	
	BasePage(WebDriver driver){
		BasePage.driver= driver;
	}

	protected void getUrl(String url){
		driver.get(url);
	}
}
