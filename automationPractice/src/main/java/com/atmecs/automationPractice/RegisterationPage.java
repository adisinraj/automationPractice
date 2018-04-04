package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterationPage extends BasePage{

	RegisterationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input#email_create")
	private WebElement emailAddress;

	@FindBy(css="button#SubmitCreate")
	private WebElement createAnAccountButton;
	
	@FindBy(css="input#id_gender1")
	private WebElement genderTitle; 
	
	@FindBy(css="input#customer_firstname")
	private WebElement customerFirstName;
	
	@FindBy(css="input#customer_lastname")
	private WebElement customerLastName;
	
	@FindBy(css="input#passwd")
	private WebElement password;
	
	@FindBy(css="select#days")
	private WebElement days;
	
	@FindBy(css="select#months")
	private WebElement months;
	
	@FindBy(css="select#years")
	private WebElement years;
	
	@FindBy(css="input#address1")
	private WebElement address;
	
	@FindBy(css="input#city")
	private WebElement city;
	
	@FindBy(css="select#id_state")
	private WebElement states;
	
	@FindBy(css="input#postcode")
	private WebElement zipcode;
	
	@FindBy(css="select#id_country")
	private WebElement countrys;
	
	@FindBy(css="input#phone_mobile")
	private WebElement phoneNumber;
	
	@FindBy(css="button#submitAccount")
	private WebElement registerButton;
	
	Select date;
	Select month;
	Select year;
	
	Select state;
	Select country;
	
	protected void selectDOB(){
		date = new Select(days);
		month = new Select(months);
		year =  new Select(years);
		
		date.selectByIndex(25);
		month.selectByValue("3");
		year.selectByVisibleText("1994");
	}
	
	protected void selectStateAndCountry(){
		state = new Select(states);
		country = new Select(countrys);
		
		state.selectByIndex(4);
		country.selectByIndex(1);
	}
	
	protected void performRegisteration(String firstName, String lastName, String passwrd, String address, String city, String zipcode, String mobileNo){
		genderTitle.click();
		customerFirstName.sendKeys(firstName);
		customerLastName.sendKeys(lastName);
		password.sendKeys(passwrd);
		selectDOB();
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		selectStateAndCountry();
		this.zipcode.sendKeys(zipcode);
		this.phoneNumber.sendKeys(mobileNo);
		
	}
}
