package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MessagePage extends BasePage{

	MessagePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="div#contact-link a")
	private WebElement contactUsLInk;
	
	@FindBy(css="select#id_contact")
	private WebElement selectHeadline;
	
	@FindBy(css="select[name=id_order]")
	private WebElement orderReference;
	
	@FindBy(css="span.filename")
	private WebElement filePath;
	
	@FindBy(css="textarea#message")
	private WebElement textBody;
	
	Select headline = new Select(selectHeadline);
	Select reference = new Select(orderReference);
	
	protected void composeMessage(String path,String message){
		headline.selectByIndex(1);
		reference.selectByIndex(0);
		filePath.sendKeys(path);
		textBody.sendKeys(message);
	}
}
