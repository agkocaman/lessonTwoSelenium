package lessonTwoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(move).contextClick().build().perform();
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();

	}

}
