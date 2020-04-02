package parallelExecution;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SecondMultipleTestExecution extends BaseClassOfParallelExecution{

	
	@Test
	public void setUp()
	{       
		driver = new ChromeDriver();
                // This will write the log in HTML and on console as well 
		Reporter.log("Test21 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}
	
	@Test
	public void loginApplication()
	{
		driver = new ChromeDriver();
		Reporter.log("Test22 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}
	
	@Test
	public void logoutApplication()
	{
		driver = new ChromeDriver();
	 		Reporter.log("Test23 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}

}
