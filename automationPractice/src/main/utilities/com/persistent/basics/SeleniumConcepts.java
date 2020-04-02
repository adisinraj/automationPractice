package com.persistent.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class SeleniumConcepts 

{

	static WebDriver driver;
	
	@BeforeTest
	public void loadDriver(){
		DesiredCapabilities capabilities= new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\agraw\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
	}
	
	@Test
	public void youtubeFastforward() throws AWTException, IOException, InterruptedException{
		driver.manage().window().maximize();	
		driver.navigate().to("https://www.toolsqa.com/automation-practice-switch-windows/");
		//WebElement formSubmitbutton = driver.findElement(By.id("account-creation_form"));
	//	driver.findElement(By.id("email_create")).sendKeys("arvas@rt.com");
	//	driver.findElement(By.id("create-account_form")).getCssValue("color"); 
	/*	driver.findElement(By.id("create-account_form")).submit();
		
		driver.switchTo().frame(0);
		driver.switchTo().parentFrame();
		WebElement g = null;
		driver.switchTo().frame(g);
		driver.switchTo().defaultContent();
		
		Actions actions = new Actions(driver);
		actions.doubleClick(g);*/
		System.out.println(driver.manage().logs());

		
		WebElement newWindowButton = driver.findElement(By.id("button1"));
		for(int i=0;i<3;i++){
			newWindowButton.click();
			Thread.sleep(3000);
		}
		String parentHandle =driver.getWindowHandle();
		driver.get("https://www.facebook.com/");
		
		Set<String> windowhandles = driver.getWindowHandles();
		
		for (String string : windowhandles) {
			driver.switchTo().window(string);
			driver.get("https://www.facebook.com/");
		}
		
	//	driver.switchTo().defaultContent();
		driver.switchTo().window(parentHandle);
		driver.get("https://twitter.com/");
		
		
		for (String string : windowhandles) {
			driver.switchTo().window(string);
			if(!string.equals(parentHandle))
			driver.close();
		}
		
	//	File rawfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(rawfile, new File("D:\\sample.png"));
		
		Robot robot= new Robot();
		robot.mouseMove(500, 700);
		//formSubmitbutton.submit();
	}
}
