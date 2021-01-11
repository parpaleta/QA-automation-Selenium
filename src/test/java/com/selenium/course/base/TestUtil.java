package com.selenium.course.base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestUtil {
    private String url;
    private int implicitWait;
    public WebDriver driver;

    @BeforeSuite
    public void readConfigProperties() {
        try(FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")){
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("url");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void initTest(){
        setupBrowserDriver();
        loadUrl();
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

    public void setupBrowserDriver(){
        driver = DriverFactory.getFirefoxDriver(implicitWait);
    }
    public void loadUrl(){
        driver.get(url);
    }
}
