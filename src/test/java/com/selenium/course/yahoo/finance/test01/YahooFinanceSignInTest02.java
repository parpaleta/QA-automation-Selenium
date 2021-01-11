package com.selenium.course.yahoo.finance.test01;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;
import java.util.List;

public class YahooFinanceSignInTest02 extends TestUtil {
//    WebDriver driver = null;

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signin-data.csv");
    }

//    @BeforeTest
//    public void setUpDriver(){
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

    @Test(dataProvider = "login-data")
    public void setSignUpData(String name, String familyName, String mail,
                              String pass, String phoneNumber, String bMonth,
                              String bDay, String bYear){
//        driver.get("https://finance.yahoo.com/");

        List<WebElement> elementList = driver.findElements(By.xpath("//button[@class='btn primary']"));
        if (elementList.size() > 0) {
            WebElement acceptCookies =  driver.findElement(By.xpath("//button[@class='btn primary']"));
            acceptCookies.click();
        }

        executeSignInButton();
        executeCreateAnAccountButton();

        WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
        firstName.sendKeys(name);

        WebElement lastName = driver.findElement(By.id("usernamereg-lastName"));
        lastName.sendKeys(familyName);

        WebElement email = driver.findElement(By.id("usernamereg-yid"));
        email.sendKeys(mail);

        WebElement password = driver.findElement(By.id("usernamereg-password"));
        password.sendKeys(pass);

        WebElement phone = driver.findElement(By.id("usernamereg-phone"));
        phone.sendKeys(phoneNumber);

        WebElement userBirthMonth = driver.findElement(By.id("usernamereg-month"));
        userBirthMonth.sendKeys(bMonth);

        WebElement userBirthDay = driver.findElement(By.id("usernamereg-day"));
        userBirthDay.sendKeys(bDay);

        WebElement userBirthYear = driver.findElement(By.id("usernamereg-year"));
        userBirthYear.sendKeys(bYear);

        WebElement continueButton = driver.findElement(By.id("reg-submit-button"));
        continueButton.click();

    }
    public void executeSignInButton(){
        WebElement singInButton = driver.findElement(By.id("header-signin-link"));
        singInButton.click();
    }
    public void executeCreateAnAccountButton(){
        WebElement createAnAccountButton = driver.findElement(By.xpath("//p[contains(@class,'sign-up-link')]"));
        createAnAccountButton.click();
    }

//    @AfterTest
//    public void closeDriver(){
//        driver.quit();
//    }

}
