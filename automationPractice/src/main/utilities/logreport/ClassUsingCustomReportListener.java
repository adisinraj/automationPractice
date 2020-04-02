package logreport;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomReportUsingITestListener.class)
public class ClassUsingCustomReportListener {
	
	@Test
	public void test1(){
		assertTrue(true);
	}

	@Test
	public void test2(){
		assertTrue(false);
	}

	@Test(dependsOnMethods={"test2"})
	public void test3(){
		assertTrue(true);
	}

	
}
