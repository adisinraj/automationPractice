package alertandPopups;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PopupTest {
	@Test
	public void popuptest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aditya_Rajput\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("http://demo.guru99.com/popup.php ");
		
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		
		//Get handle of main window
		String parentWindow = driver.getWindowHandle();
		
		//Switching to the child handle from parent handle
		Set<String> childWindows = driver.getWindowHandles();
		for(String window: childWindows) {
			if(parentWindow!=window) {
				driver.switchTo().window(window);
			}
		}
			
		driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
        
        driver.findElement(By.name("btnLogin")).click();
        
        driver.close();
        
        //if we dont switch to parent window, then we will get nosuchwindow exception
        driver.switchTo().window(parentWindow);
        driver.close();
	
	}

}
