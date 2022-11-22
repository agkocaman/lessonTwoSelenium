package lessonTwoSelenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumPractise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
		int j=0;
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<products.size(); i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			List itemNeededList = Arrays.asList(itemsNeeded);
			Thread.sleep(1000);
			if(itemNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				if(j==itemNeededList.size())   {
					System.out.println("çıkış");
					break;
					
				}
				
				
			}
		}

	}

}
