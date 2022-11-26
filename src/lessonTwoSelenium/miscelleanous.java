package lessonTwoSelenium;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;


public class miscelleanous {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().addCookie(new Cookie("key", "value"));
		Thread.sleep(5000);
		driver.manage().deleteAllCookies();

	}

}
