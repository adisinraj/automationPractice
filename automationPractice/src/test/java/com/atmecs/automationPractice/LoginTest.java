package com.atmecs.automationPractice;

import org.eclipse.jetty.util.security.Password;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	LoginPage loginPage;
	String email = properties.getProperty("email");
	String password = properties.getProperty("password");
	
  @Test
  public void performLoginFromHomepage() {
	  loginPage = new LoginPage(driver);
	  loginPage.performLogin(email, password);
  }
}
