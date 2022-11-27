package lessonTwoSelenium;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filter {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("#search-field")).sendKeys("Rice");
		List<WebElement> Sebzeler = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> donen =Sebzeler.stream().filter(s-> s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(donen.size(), Sebzeler.size());
	}

}
