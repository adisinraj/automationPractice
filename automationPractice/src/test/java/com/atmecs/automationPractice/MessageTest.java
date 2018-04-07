package com.atmecs.automationPractice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class MessageTest extends BaseTest{
	
	MessagePage messagePage;
	
	@Test
	public void performLogin(){
		String email = properties.getProperty("email");
		String password = properties.getProperty("password");	
		String url = properties.getProperty("url");
			  
		 LoginPage loginPage = new LoginPage(driver);
		  loginPage.getUrl(url);
		  loginPage.performLogin(email, password);
	}
	
	
  @Test(dependsOnMethods={"performLogin"})
  public void composeAndSendMessage() {
	String pathOfFile = properties.getProperty("pathOfFile");
	String message = properties.getProperty("message");

	 
	  messagePage = new MessagePage(driver);
	messagePage.sendMessage(pathOfFile, message);
	assertTrue(messagePage.messageSentSuccessful());
  }
}
