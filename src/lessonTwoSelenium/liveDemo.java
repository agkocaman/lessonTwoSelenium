package lessonTwoSelenium;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class liveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//th[1]")).click();
		List<WebElement> values = driver.findElements(By.xpath("//td[1]"));
		List<String> orginalList = values.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList =  orginalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orginalList.equals(sortedList));
	}

}
