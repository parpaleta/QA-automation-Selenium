package com.selenium.course.base;

import driver.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

@Slf4j

public class TestUtil {
    private String url;
    private String browser;
    private int implicitWait;
    public WebDriver driver;

    @BeforeSuite
    public void readConfigProperties() {
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void initTest(){
        setupBrowserDriver(browser);
        loadUrl();

        acceptCookies();
//        executeSignInButton();
//        executeCreateAnAccountButton();

    }

    public void acceptCookies(){
        List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='btn primary']"));
        if (elementList.size() > 0) {
            WebElement acceptCookies =  driver.findElement(By.xpath("//button[@class='btn primary']"));
            acceptCookies.click();
        }
    }
//    public void executeSignInButton(){
//        WebElement singInButton = driver.findElement(By.id("header-signin-link"));
//        singInButton.click();
//    }
//    public void executeCreateAnAccountButton(){
//        WebElement createAnAccountButton = driver.findElement(By.xpath("//p[contains(@class,'sign-up-link')]"));
//        createAnAccountButton.click();
//    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    public void setupBrowserDriver(String browser){
        switch(browser.toLowerCase(Locale.ROOT)){
            case "firefox":
                driver = DriverFactory.getFirefoxDriver(implicitWait);
                break;
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("Unexpected browser name value: " + browser);

        }
    }
    public void loadUrl(){
        driver.get(url);
    }
}
