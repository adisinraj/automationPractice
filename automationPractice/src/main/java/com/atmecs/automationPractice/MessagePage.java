package com.atmecs.automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessagePage extends BasePage{

	MessagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="div#contact-link a")
	private WebElement contactUsLInk;
	
	@FindBy(css="select#id_contact")
	private WebElement selectSubjectHeadline;
	
	@FindBy(css="select[name=id_order]")
	private WebElement orderReference;
	
	@FindBy(css="input[name=fileUpload]")
	private WebElement filePath;
	
	@FindBy(css="textarea#message")
	private WebElement textBody;
	
	@FindBy(css="button#submitMessage")
	private WebElement sendMessageButton;
	
	@FindBy(css="p.alert")
	private WebElement successMessage;
	
	Select headline ;
	Select reference;
	
	protected void composeMessage(String path,String message){
		headline = new Select(selectSubjectHeadline);
		reference = new Select(orderReference);
		
		headline.selectByIndex(1);
		reference.selectByIndex(0);
		orderReference.sendKeys("1234");
		filePath.sendKeys(path);
		textBody.sendKeys(message);
	}
	
	protected void sendMessage(String path,String message){
		contactUsLInk.click();
		composeMessage(path, message);
		sendMessageButton.click();
	}
	
	protected boolean messageSentSuccessful() {
		return successMessage.getText().contains("successfully");		
	}
}
