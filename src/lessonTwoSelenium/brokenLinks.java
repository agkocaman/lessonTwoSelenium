package lessonTwoSelenium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import java.net.HttpURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*String url = driver.findElement(By.cssSelector("a[href*='broken']")).getAttribute("href");
		HttpsURLConnection conn = (HttpsURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respoenseCode = conn.getResponseCode();
		System.out.println("status code: "+respoenseCode);*/
		
		
		
		List <WebElement> Links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement Link : Links) {
			String url = Link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respoenseCode = conn.getResponseCode();
			System.out.println("status code: "+respoenseCode);
			if(respoenseCode > 400) {
				System.out.println("Bu "+url+" adreste ve bu "+Link.getText()+" başlıkta kırık link tespit edildi status code:"+respoenseCode);
				Assert.assertTrue(false);
			}
	
			
		}
		System.out.println("finish control");
		
	}

}
