package UI;

import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.zeromq.ZStar.Set;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_Windows {

	public static String browser = "chrome"; // External configuration
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
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
		driver.get("https://www.salesforce.com/ap/?ir=1");

		// Manage
		driver.manage().window().maximize();

		// ..................CLICK BUTTON........
		driver.findElement(By.xpath("//*[@id=\"1707962206997_xa6\"]/div[1]/article/div[2]/div/pbc-button[1]/a")).click();
		
		java.util.Set<String> windowhandles = driver.getWindowHandles();   //  .........SWITCH WINDOWS...........
		System.out.println(windowhandles); 
		
		
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();					 //...1. Making Window Handles for switching windows(it is handle for switch windows and if tehre are 2 windows it has 2 window handles)
		System.out.println(parentwindow);						//....2. Make iterator for find where we want to switch that previously make window handles   
		String childwindow = iterator.next();
		System.out.println(childwindow);						
		
		driver.switchTo().window(childwindow);					//...3.switch to child window using iterator that make of window handles 
		//..........PRINT WINDDOW..............
		driver.findElement(By.name("UserFirstName")).sendKeys("TestFname");
		driver.findElement(By.name("UserLastName")).sendKeys("TestLname");

	}
}

//...1. Making Window Handles for switching windows(it is handle for switch windows and if there are 2 windows it has 2 window handles)
//...2. Make iterator for find which window we wont to switch that previously make window handles    
//...3.   Iterator to parent window it gets window handle for Parent window
//...4.   Iterator to child window it gets window handle for child window
//...5. we can use this window handle to switch between windows using iterator
