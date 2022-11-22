package lessonTwoSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class homeWork3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String userName = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[1]")).getText();
		String passWord = driver.findElement(By.xpath("//p[@class='text-center text-white']/b[2]")).getText();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select  dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(2);
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//input[@id='terms']")).isSelected());
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		int card = driver.findElements(By.xpath("//button[@class='btn btn-info']")).size();
		System.out.println(card);
		
		for(int i=0; i<card; ) {
			i++;
			String text = "(//button[@class='btn btn-info'])["+i+"]";
			driver.findElement(By.xpath(text)).click();
			
		}
		
		
		
	}

}
