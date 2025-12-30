package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners({ITestListenerImpl.class, IISuiteListenerImpl.class, RetryListener.class })
//@Listeners({ITestListenerImpl.class, IISuiteListenerImpl.class} )
@Listeners(RetryListener.class)
public class ListenerClass {
    WebDriver driver;
    @BeforeTest
    public void initializeDriver(){
      //  WebDriverManager.edgedriver().setup();
     //   driver = new EdgeDriver();
    }


    @Test
    void test1(){
        System.out.println("test 1");
        Assert.assertTrue(false);
    }

    @Test
    void test2(){
        System.out.println("test 2");
        Assert.assertTrue(true);
    }
}


/*class ITestListenerAdapterImpl extends TestListenerAdapter {

}*/


