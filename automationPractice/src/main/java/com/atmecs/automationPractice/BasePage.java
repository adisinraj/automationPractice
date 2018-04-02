package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;

public class BasePage {
	 
	public static WebDriver driver;
	
	BasePage(WebDriver driver){
		BasePage.driver= driver;
	}

	protected String getTitle(){
		return driver.getTitle();
		
	}
}
