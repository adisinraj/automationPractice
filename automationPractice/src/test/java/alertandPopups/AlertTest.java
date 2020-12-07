package alertandPopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTest {

	@Test
	public void testAlert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Aditya_Rajput\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
        
        // Alert Message handling
                    		
        driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();	
        
        //switching to alert
        Alert alert = driver.switchTo().alert();
        
        //capturing the text of alert
        String alertmessage = alert.getText();
        System.out.println(alertmessage);
        
       // Thread.sleep(3000);
        
        //dismissing the alert
        alert.dismiss();
        
        String confirmationText = driver.switchTo().alert().getText();
        System.out.println(confirmationText);
        
       driver.findElement(By.name("submit")).submit();	
        Thread.sleep(5000);
        
        //Accepting the alert
        driver.switchTo().alert().accept();
        
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
        driver.quit();  
	}
}
