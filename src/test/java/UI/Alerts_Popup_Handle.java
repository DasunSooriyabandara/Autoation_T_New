package UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_Popup_Handle {

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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");

		// Manage
		driver.manage().window().maximize();

		// ..................Handle Iframe........
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.cssSelector("body > button")).click();

		// ...........HAndle alert.........
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		
		Alert alertfunction = driver.switchTo().alert();
		driver.switchTo().alert().accept(); // .....ACCEPT.........//
		//driver.switchTo().alert().dismiss(); // .....DISMISS.........//
		
//		alertfunction.sendKeys("test send keys");  //.........add text to TEXTAREA......
//		alertfunction.accept();                    //.........ACCEPT ALERT..........
		
		driver.switchTo().parentFrame(); 
		System.out.println(driver.getTitle());

	}
}
