package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Auto_suggest_DropDown {

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

		// Open Sauce Demo website
		driver.get("https://www.makemytrip.com/");

		// Manage
		driver.manage().window().maximize();

		// -----------------------------SINGLE SELECT
		// DROPDOWN---------------------------------------------------
		driver.findElement(By.xpath("//span[text()='From']")).click();

		((WebElement) driver.findElements(By.className("react-autosuggest__input react-autosuggest__input--open"))).sendKeys("Sydney");
		WebElement from = (WebElement) driver.findElements(By.xpath("//input[@placeholder='From']"));
		// Thread.sleep(2000);
		((WebElement) from).sendKeys(Keys.ARROW_DOWN);
		((WebElement) from).sendKeys(Keys.ENTER);

		// Quit browser
		driver.quit();

		// ------------------------------- MULTI SELECT
		// DROPDOWN---------------------------------------------------
//		driver.get("https://carbondesignsystem.com/components/dropdown/usage/");
//
//		// Manage
//		driver.manage().window().maximize();
//		
//		WebElement ddown = driver.findElement(By.id("downshift-47-toggle-button"));
//		Select select = new Select(ddown);
//		
//		select.deselectByValue("51 - 100 employees");

//Quit browser
		driver.quit();

		// Close the browser window
		// driver.quit();

	}

}
