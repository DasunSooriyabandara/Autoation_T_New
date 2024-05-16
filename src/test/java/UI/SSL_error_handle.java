package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SSL_error_handle {

    public static String browserType = "chrome"; // External configuration
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities handleSSLError = new DesiredCapabilities();
        handleSSLError.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.merge(handleSSLError);
            driver = new FirefoxDriver(ffOptions);
        } else if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(handleSSLError);
            driver = new ChromeDriver(chromeOptions);
        } else if (browserType.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.merge(handleSSLError);
            driver = new EdgeDriver(edgeOptions);
        }

        // Open website
        driver.get("https://www.expired.badssl.com/");

        // Maximize the window
        driver.manage().window().maximize();

        Thread.sleep(5000); // Delay for 5 seconds

        // Keep the browser open for further actions, or close it if needed
        // driver.quit();
    }
}