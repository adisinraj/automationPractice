package com.atmecs.automationPractice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	
  @Test
  public void performLoginFromHomepage() {
	  String url = properties.getProperty("url");
	  String email = properties.getProperty("email");
	  String password = properties.getProperty("password");
			  
	  loginPage = new LoginPage(driver);
	  loginPage.getUrl(url);
	  loginPage.performLogin(email, password);
	//  assertTrue(loginPage.verifyLogin());
  }
}
