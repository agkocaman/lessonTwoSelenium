package lessonTwoSelenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it =handles.iterator();
		String par = it.next();
		String chl = it.next();
		driver.switchTo().window(chl);
		driver.get("https://rahulshettyacademy.com");
		String akademi = driver.findElement(By.xpath("(//h2/a[1])[1]")).getText();
		driver.switchTo().window(par);
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(akademi);
		

	}

}
