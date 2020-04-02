package parallelExecution;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class BaseClassOfParallelExecution {
	WebDriver driver;
	@BeforeTest
	public void setDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Adu\\Downloads\\chromedriver.exe");
	}

	@AfterClass
	public void teardown(){
		driver.quit();
	}
}
