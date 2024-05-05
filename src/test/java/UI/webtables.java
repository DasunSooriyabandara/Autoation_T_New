package UI;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtables {

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
        driver.get("https://www.asx.com.au/markets/trade-our-cash-market/equity-market-prices");

        // Maximize the window
        driver.manage().window().maximize();

        // Accept cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        acceptCookiesButton.click();

        // Find the number of rows
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr"));
        System.out.println("Number of rows " + rows.size()); 
        
        int rowSize = rows.size();

        // Find the number of columns (assuming all rows have the same number of columns)
        List<WebElement> columns = driver.findElements(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr[2]/td"));
        System.out.println("Number of columns " + columns.size());
        
        int columnSize = columns.size();

        
        System.out.println("Test one");
        
        Thread.sleep(5000);
        
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        Boolean acceptCookiesButton1 = wait1.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table")));
//        
        //Get heading
        System.out.println(driver.findElement(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/caption")).getText());
        
        
        
        
        // Iterate through each cell of the table and print its text
        for(int i = 1; i <= rowSize; i++) {
            for (int j = 1; j <= columnSize; j++) {
               System.out.println(  driver.findElement(By.xpath("//*[@id=\"home_top_twenty\"]/div/div[1]/div/div[1]/table/tr["+ i +"]/td["+ j +"]"))
            		   .getText());								
            }
            System.out.println();
        }
        
        
        
      //*[@id="home_top_twenty"]/div/div[1]/div/div[1]/table/tr[2]
      //body[1]/div[1]/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tr[2]
      //*[@id="home_top_twenty"]/div/div[1]/div/div[1]/table/tr[2]/td[1]

        // Close the browser
        driver.quit();
    }
}
