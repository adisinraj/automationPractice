package com.persistent.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, MalformedURLException {
		
		URL url;
		HttpURLConnection httpURLConnection;
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://gaana.com/album/ik-tera");
		List<WebElement> listoflinks = driver.findElements(By.cssSelector("a.sng_c"));
		System.out.println(listoflinks.size());
		for (WebElement string : listoflinks) {
			System.out.println(string.getAttribute("href"));
		}
		
		for (WebElement string : listoflinks) {
			String ref = string.getAttribute("href");
			if(ref.contains("javascript"))
				continue;
			url =new URL(ref);
			httpURLConnection=  (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			System.out.println(ref+" :"+httpURLConnection.getResponseCode());
		}
		
		
	}
}
