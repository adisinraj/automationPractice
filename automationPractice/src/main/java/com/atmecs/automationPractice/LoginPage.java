package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="a.login")
	private WebElement loginButton;
	
	@FindBy(css="input#email")
	private WebElement emailAddress;
	
	@FindBy(css="input#passwd")
	private WebElement passwordField;
	
	@FindBy(css="button#SubmitLogin")
	private WebElement login;
	
	protected void performLogin(String email, String password){
		loginButton.click();
		emailAddress.sendKeys(email);
		passwordField.sendKeys(password);
		login.click();
	}
}
