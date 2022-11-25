package lessonTwoSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class javaScriptExecutor {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
		js.executeScript("document.querySelector(\".tableFixHead\").scroll(0,200)");
		List<WebElement> values =  driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum = 0;
		for(int i=0; i<values.size(); i++) {
			
			sum = sum +Integer.parseInt( values.get(i).getText());
		}
		System.out.println(sum);
		int amount = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim()) ;
		Assert.assertEquals(amount, sum);
	}

}
