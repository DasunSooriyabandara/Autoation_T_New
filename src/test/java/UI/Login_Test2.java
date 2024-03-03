package UI;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test2 {

	public static String browser = "firefox"; // External configuration
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
		driver.get("https://www.saucedemo.com/");

		//Basic Methods
		
		//Manage
		driver.manage().window().maximize();
		
		//current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//Get Title
		String Title = driver.getTitle();
		System.out.println(Title);
				
		//page Source
		String pgsource = driver.getPageSource();
		System.out.println(pgsource);
		
		//navigate 
		driver.navigate().to("https://google.com");
		
		//Quit browser
		driver.quit();
		

		// Close the browser window
		// driver.quit();

	}

}
