package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    protected static WebDriver driver;
    public static WebDriverWait wait;

   
    public void initializeDriver(String browser) {
        if (driver == null) {
            switch (browser.toLowerCase()) {
            
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.setExperimentalOption("useAutomationExtension", false);
                
                driver = new ChromeDriver(options);
                break;
                
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;    
                
                
            }
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
