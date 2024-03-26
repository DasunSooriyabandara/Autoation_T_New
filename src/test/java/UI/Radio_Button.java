package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radio_Button {

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
        driver.get("https://www.singaporeair.com/en_UK/lk/home#/book/bookflight");

        // Manage
        driver.manage().window().maximize();

        // ----------------------------------Radio Button 1 ----------------------------------------------
//        WebElement radio1 = driver.findElement(By.id("bookFlights"));
//        r
