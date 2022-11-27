package lessonTwoSelenium;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class newWindow {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C://Drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String par = it.next();
		String chl = it.next();
		driver.switchTo().window(chl);
		driver.get("https://rahulshettyacademy.com");
		String akademi = driver.findElement(By.xpath("(//h2/a[1])[1]")).getText();
		driver.switchTo().window(par);

		WebElement aka = driver.findElement(By.xpath("(//input[@name='name'])[1]"));
		aka.sendKeys(akademi);
		File file = aka.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("deneme.png"));
	}

}
