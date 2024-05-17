package UI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authentication_popup {

    public static String browser = "chrome"; // External configuration
    public static WebDriver driver;
    
    
    public static String username = "admin";  //reading from external sourse like XLS,CSV
    public static String password = "admin";  //reading from external sourse like XLS,CSV
    

    public static void main(String[] args) throws InterruptedException, IOException {
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

        // Open ASX website
        driver.get("https://"+username+":"+password+"@the-internet.hrokuapp.com/basic_auth/");
        
     // -------------------OPEN WEBSITE FROM EXTERNAL SOURSE----------------------------------
        driver.get("https://admin:admin@the-internet.hrokuapp.com/basic_auth/");

        // Maximize the window
        driver.manage().window().maximize();
        
        
       
    }
}
