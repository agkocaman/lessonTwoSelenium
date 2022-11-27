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
		driver.findElement(By.xpath("//th[1]")).click();
		List<WebElement> values = driver.findElements(By.xpath("//td[1]"));
		List<String> orginalList = values.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList =  orginalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(orginalList.equals(sortedList));
		List<String> price;
		
		do {
		List<WebElement> rows = driver.findElements(By.xpath("//td[1]"));
		price = rows.stream().filter(s->s.getText().contains("Mango")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(a-> System.out.println(a));
		if(price.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}
		while(price.size()<1);
		
		
	}
	
	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
		
	}
}
