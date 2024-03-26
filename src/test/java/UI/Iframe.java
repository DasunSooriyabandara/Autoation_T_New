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

public class Iframe {

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
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_scripts_intro");

        // Manage
        driver.manage().window().maximize();
        
        
        //............................Iframe access............
      //.....................................Iframe access by INDEX ............
        
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("/html/body/button")).click();
        
      //.....................................Iframe access by ID ............
        
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();
        
     //.....................................Iframe access by Web Element ............
        WebElement frame1 = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("/html/body/button")).click();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }
    }
