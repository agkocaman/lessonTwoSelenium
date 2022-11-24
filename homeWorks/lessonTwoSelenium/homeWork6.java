package lessonTwoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class homeWork6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkboxDriver = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset"));
		int  inputSize =checkboxDriver.findElements(By.tagName("input")).size();
		checkboxDriver.findElements(By.tagName("input")).get(inputSize-2).sendKeys( Keys.chord(Keys.SPACE));
		String inputName = checkboxDriver.findElements(By.tagName("input")).get(inputSize-2).getAttribute("value");
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue(inputName);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(inputName);
		driver.findElement(By.id("alertbtn")).click();
		Assert.assertEquals(driver.switchTo().alert().getText(),
				"Hello " + inputName + ", share this practice page and share your knowledge");
		
		
		// 
		
	}

}
