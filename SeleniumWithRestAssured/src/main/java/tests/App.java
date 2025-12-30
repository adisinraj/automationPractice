package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws AWTException {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.google.com");
        new Actions(driver).keyDown(Keys.SHIFT).sendKeys("aDITYa").build().perform();
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("ADITYA");

        //synchronization in selenium
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath(""))));

        FluentWait<WebDriver> fwait = new FluentWait<>(driver);
        fwait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("")));
        //
        driver.manage().window();

        JavascriptExecutor jsEx= (JavascriptExecutor)driver;
        jsEx.executeScript("");


        new Actions(driver).sendKeys(Keys.ENTER).perform();
        Robot robot = new Robot();
      //  robot.keyPress(KeyEvent.VK_ENTER);

        /*WebDriverManager.chromedriver().setup();
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get("https://www.google.com");
        driverChrome.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("ADITYA");
        robot.keyPress(KeyEvent.VK_ENTER);
*/

        /*
         // Serialize
        User user = new User("Aditya", 25);
        String json = mapper.writeValueAsString(user);
        System.out.println("Serialized JSON: " + json);

        // Deserialize
        User deserialized = mapper.readValue(json, User.class);
        System.out.println("Deserialized User: " + deserialized.getName() + ", " + deserialized.getAge());


         */
    }
}


