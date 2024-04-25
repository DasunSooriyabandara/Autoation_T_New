package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Implicit_Wait {

	public static String browser = "chrome"; // External configuration
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// Open eBay website
		driver.get("https://www.ebay.com/");

		// Maximize the browser window
		driver.manage().window().maximize();

		// *************** Set Implicit wait******************************
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Perform mouse-over action
		WebElement element = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

		// *************** Set Explicit Wait******************************
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/div[2]/div[1]/nav[2]/ul/li[1]/a"))).click();

		// *************** Set Fluent Wait******************************
		FluentWait<WebDriver> wait = new FluentWait<>(driver).pollingEvery(Duration.ofSeconds(2))
				.withTimeout(Duration.ofSeconds(10)).withMessage("I can not find the element ")
				.ignoring(NoSuchElementException.class);
		driver.getCurrentUrl();
		System.out.println("done");
		
		// Click on the desired element after mouse-over
		// driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[2]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click();

		// Quit the browser
		driver.quit();
	}
}
