package UI;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SSL_error_handle {

    public static String browserType = "chrome"; // External configuration
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
        DesiredCapabilities handleSSLError = new DesiredCapabilities();
        handleSSLError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        // Adding log to confirm the SSL capability is set
        System.out.println("Accept insecure certs: " + handleSSLError.getCapability(CapabilityType.ACCEPT_INSECURE_CERTS));

        // Setup WebDriver based on browser type
        switch (browserType.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.merge(handleSSLError);
                driver = new FirefoxDriver(ffOptions);
                break;
                
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(handleSSLError);
                driver = new ChromeDriver(chromeOptions);
                break;
                
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.merge(handleSSLError);
                driver = new EdgeDriver(edgeOptions);
                break;
                
            default:
                System.out.println("Invalid browser type specified.");
                return;
        }

        // Adding log to confirm the browser is launched
        System.out.println("Browser launched successfully.");

        // Set page load timeout
        driver.manage().timeouts().pageLoadTimeout(java.time.Duration.ofSeconds(20));

        // Open website with SSL error
        try {
            driver.get("https://expired.badssl.com/");
            System.out.println("Navigated to https://expired.badssl.com/");

            // Handle the SSL error warning page in Chrome
            if (browserType.equalsIgnoreCase("chrome")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("document.getElementById('details-button').click();");
                Thread.sleep(1000); // Wait for the button to be clickable
                js.executeScript("document.getElementById('proceed-link').click();");
            }

            // Handle the SSL error warning page in Firefox
            if (browserType.equalsIgnoreCase("firefox")) {
                driver.findElement(By.id("advancedButton")).click();
                driver.findElement(By.id("exceptionDialogButton")).click();
            }

        } catch (Exception e) {
            System.out.println("Failed to load https://expired.badssl.com/");
            e.printStackTrace();
        }

        // Maximize the window
        driver.manage().window().maximize();
        System.out.println("Window maximized.");

        // Check the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Take a screenshot
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(screenshot, new File("screenshot.png"));
//        System.out.println("Screenshot taken.");

        // Log part of the page source
        String pageSource = driver.getPageSource();
        System.out.println("Page source snippet: " + pageSource.substring(0, Math.min(pageSource.length(), 200)));

        // Sleep to keep the browser open for observation
        Thread.sleep(5000);
        
        System.out.println("Successfully Login by handle SSL Error  ");

        // Uncomment the next line to close the browser after actions are completed
        // driver.quit();
    }
}
