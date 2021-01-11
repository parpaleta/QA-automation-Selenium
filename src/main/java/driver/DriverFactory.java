package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getFirefoxDriver(int implicitWait){
        FirefoxOptions options = new FirefoxOptions();

        WebDriverManager.getInstance(FirefoxDriver.class).setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

        return driver;
    }

    // same for Chrome
}
