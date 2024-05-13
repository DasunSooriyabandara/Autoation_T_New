package UI;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

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

        // Open ASX website
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        // Maximize the window
        driver.manage().window().maximize();
        JavascriptExecutor jsexec = (JavascriptExecutor) driver;
        
        //Print the title of the page
        String script = "return document.title;";
        String title = (String)jsexec.executeScript(script);
        System.out.println(title);
        
        //Click Button
        driver.switchTo().frame("iframeResult");
        jsexec.executeScript("myFunction()");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        
        //Highlight
        WebElement button = driver.findElement(By.xpath("/html/body/button"));
        jsexec.executeScript("arguments[0].style.border='3px solid red'",args);
        
        
        //Scroll
        driver.navigate().to("https://www.w3schools.com/");
        WebElement certifiedbutton = driver.findElement(By.xpath("//*[@id=\"main\"]/div[16]/p/a"));
        jsexec.executeScript("arguments[0].scrollIntoView(true);", certifiedbutton);)
        

        // Close the browser
        driver.quit();
    }
}
