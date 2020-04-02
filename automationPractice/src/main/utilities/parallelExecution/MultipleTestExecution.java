package parallelExecution;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MultipleTestExecution  extends BaseClassOfParallelExecution
{
		
	@Test
	public void setUp()
	{       
		driver = new ChromeDriver();
                // This will write the log in HTML and on console as well 
		Reporter.log("Test1 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}
	
	@Test
	public void loginApplication()
	{
		driver = new ChromeDriver();
		Reporter.log("Test2 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}
	
	@Test
	public void logoutApplication()
	{
		driver = new ChromeDriver();
	 		Reporter.log("Test3 is executed via Thread and Thread Id is "+Thread.currentThread().getId(), true);
	}

}