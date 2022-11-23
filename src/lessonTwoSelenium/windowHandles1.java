package lessonTwoSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandles1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String[] email2 = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ");
		String emailOrj  = email2[0];
		
		//String email = driver.findElement(By.xpath("//p[@class='im-para red']//a")).getText();
		driver.switchTo().window(parentID);
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(emailOrj);
		System.out.println("başarılı");
		
	}

}

