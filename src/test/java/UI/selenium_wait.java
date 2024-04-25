import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class selenium_wait {
	public static void main(String[] args) throws InterruptedException {
		// Set up ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Open Sauce Demo website
		driver.get("https://www.singersl.com/");

		// Maximize browser
		driver.manage().window().maximize();

		// current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// Get Title
		String Title = driver.getTitle();
		System.out.println("Title of the web" + Title);

		
		

	}

}
