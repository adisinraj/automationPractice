package com.atmecs.automationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
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
	
	@FindBy(css=" a.account")
	private WebElement customername;
	
	protected void performLogin(String email, String password){
		loginButton.click();
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		emailAddress.sendKeys(email);
		passwordField.sendKeys(password);
		login.click();
	}

	/**
	 * replace the string text with the first name from the property file
	 * @return
	 */
	
	public boolean verifyLogin() {
			return customername.getText().contains("View my customer account");
	}
}
