package UI;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_all_links_in_the_page {

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
		driver.get("https://www.sugarcrm.com/au/request-demo/");

		// Manage
		driver.manage().window().maximize();

//		Accepct cookies
		driver.findElement(By.xpath("/html/body/div[1]/div")).click();

		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total tagsare:" + alltags.size());

		for (int i = 0; i < alltags.size(); i++) {
			System.out.println("Links on the page" + alltags.get(i).getAttribute("href"));
			System.out.println("Links on the page" + alltags.get(i).getText());
			System.out.println("------------------------------------");
		}

	}

}
