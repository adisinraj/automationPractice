package dragaAndDrop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
 
public class DragAndDrop {
 
    public static void main(String[] args) throws Exception {
 
    WebDriver driver = new FirefoxDriver();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://jqueryui.com/droppable/#default");
    driver.manage().window().maximize();
    
    Actions action = new Actions(driver);
    
    // If the element is not able to be catched directly by the cssSelector and throw NoSuchElementException,
    // then look for the iframe, it might be the resason element is not  getting selected. In this case,it was.
    
    WebElement frame = driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(frame);
    
   // WebElement draggedelement =driver.findElement(By.cssSelector("div#draggable"));
    WebElement draggedelement = driver.findElement(By.xpath("//*[@id='draggable']"));
    
    System.out.println(draggedelement.getLocation());
    
   // WebElement dropable = driver.findElement(By.cssSelector("div#droppable"));
    WebElement dropable = driver.findElement(By.xpath("//*[@id='droppable']"));
    
    System.out.println(dropable.getLocation());
    
 
   // action.dragAndDropBy(draggedelement, 168, 100).build().perform();  
   // action.dragAndDrop(draggedelement, dropable).build().perform();
    action.clickAndHold(draggedelement).moveToElement(dropable).release() .build().perform();
   // driver.quit();
 
    
    }
} 