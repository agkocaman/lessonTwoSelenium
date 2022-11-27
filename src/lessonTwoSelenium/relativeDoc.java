package lessonTwoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relativeDoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		WebElement birthDateEditBox = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(By.xpath("//input[@max='3000-12-31']")).sendKeys("19041987");
		driver.findElement(with(By.tagName("input")).below(birthDateEditBox)).click();
		WebElement text = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(text)).click();
	}

}
