package verificationOfLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificationOfBrokenLinks {

	public static void main(String[] args) {
		WebDriver driver =  new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		
		//List<WebElement> listOfLinks= driver.findElements(By.tagName("a"));
		List<WebElement> listOfLinks= driver.findElements(By.xpath("//a[@href]"));
		

		System.out.println(listOfLinks.size());
		
		for(int i =0; i < listOfLinks.size() ; i++){
		
			WebElement anchorTag = listOfLinks.get(i);
			
			String url = anchorTag.getAttribute("href");
		//	String urlName = anchorTag.getText();     use this for getting the text of the anchor tag
			verifyUrl(url);
					}
	}

	private static void verifyUrl(String linkurl) {
		try {
			//make the URL object and pass the URL into it
			URL url = new URL(linkurl);
			
			//open the connection which will return the HttPUrlConnecti0n 
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			
			//this set the minimum time for server for respond to the request
			httpUrlConnection.setConnectTimeout(3000);
			
			if(httpUrlConnection.getResponseCode()==200){
				System.out.println( linkurl+" - "+ httpUrlConnection.getResponseMessage() );
			}
			if(httpUrlConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
				System.out.println(linkurl+" - "+ httpUrlConnection.getResponseMessage() );
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
