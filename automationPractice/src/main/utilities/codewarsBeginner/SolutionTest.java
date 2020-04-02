package codewarsBeginner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SolutionTest {

		 public  static void main(String[] args) {
		
			 WebDriver driver = new FirefoxDriver();
			 driver.navigate().to("https://www.google.co.in/");
			 WebElement element = driver.findElement(By.tagName("br"));
		//	 List<WebElement> element = driver.findElements(By.tagName("button"));
			 driver.close();
			
		}
}
