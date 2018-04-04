package com.atmecs.automationPractice;

import org.testng.annotations.Test;

public class RegisterationTest extends BaseTest{
  
	RegisterationPage registerationPage;
	
	@Test
  public void performRegisteration() {
		String url = properties.getProperty("url");
	  String firstName=properties.getProperty("firstName");
	  String lastName=properties.getProperty("lastName");
	  String passwrd=properties.getProperty("password");
	  String address=properties.getProperty("address");
	  String city=properties.getProperty("city");
	  String zipcode= properties.getProperty("zipcode");
	  String mobileNo=properties.getProperty("mobileNo");
	  
	  
	registerationPage = new RegisterationPage(driver);
	registerationPage.getUrl(url);
	registerationPage.navigateToRegistrationForm();
	registerationPage.performRegisteration(firstName, lastName, passwrd, address, city, zipcode, mobileNo);
	  
  }
}
