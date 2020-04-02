package com.persistent.basics;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VideoTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.navigate().to("https://www.youtube.com/watch?v=dP1YzqKnnTo");
	  WebElement video = driver.findElement(By.xpath("//video[contains(@tabindex,'1')]"));
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	  
	  Robot robot;
	try {
		Thread.sleep(4000);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyPress(KeyEvent.VK_SPACE);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(video.getAttribute("src"));
	  video.click();
	// JavascriptExecutor jsexecutor = (JavascriptExecutor)driver;
	// jsexecutor.executeScript(" vid.playbackRate = 0.5;
	// , args);
	  
	  Alert alert = new WebDriverWait(driver, 5).until(ExpectedConditions.alertIsPresent());
	  
		
  }
}
