package com.selenium.course.yahoo.finance.test01;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

public class YahooFinanceSignInTest02 extends TestUtil {

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signin-data.csv");
    }


    @Test(dataProvider = "login-data")
    public void setSignUpData(String name, String familyName, String mail,
                              String pass, String phoneNumber, String bMonth,
                              String bDay, String bYear) {

        WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
        firstName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        firstName.sendKeys(name);

        WebElement lastName = driver.findElement(By.id("usernamereg-lastName"));
        lastName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        lastName.sendKeys(familyName);

        WebElement email = driver.findElement(By.id("usernamereg-yid"));
        email.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        email.sendKeys(mail);

        WebElement password = driver.findElement(By.id("usernamereg-password"));
        password.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        password.sendKeys(pass);

        WebElement phone = driver.findElement(By.id("usernamereg-phone"));
        phone.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        phone.sendKeys(phoneNumber);

        WebElement userBirthMonth = driver.findElement(By.id("usernamereg-month"));
        userBirthMonth.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userBirthMonth.sendKeys(bMonth);

        WebElement userBirthDay = driver.findElement(By.id("usernamereg-day"));
        userBirthDay.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userBirthDay.sendKeys(bDay);

        WebElement userBirthYear = driver.findElement(By.id("usernamereg-year"));
        userBirthYear.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        userBirthYear.sendKeys(bYear);

        WebElement continueButton = driver.findElement(By.id("reg-submit-button"));
        continueButton.click();
        validateErrorMessages();

    }
    public void validateErrorMessages(){
        String actualRegErrorYid = driver.findElement(By.id("reg-error-yid")).getText();
        String expectedRegErrorYid = "This email address is not available for sign up, try something else";
        Assert.assertEquals(actualRegErrorYid, expectedRegErrorYid);

        String actualRegErrorPasword = driver.findElement(By.id ("reg-error-password")).getText();
        String expectedRegErrorPassword = "Your password isn’t strong enough, try making it longer.";
        Assert.assertEquals(actualRegErrorPasword, expectedRegErrorPassword);

        String actualRegErrorPhone = driver.findElement(By.id ("reg-error-phone")).getText();
        String expectedRegErrorPhone = "That doesn’t look right, please re-enter your phone number.";
        Assert.assertEquals(actualRegErrorPhone, expectedRegErrorPhone);

        String actualRegErrorbirthDate = driver.findElement(By.id ("reg-error-birthDate")).getText();
        String expectedRegErrorbirthDate = "That doesn’t look right, please re-enter your birthday.";
        Assert.assertEquals(actualRegErrorbirthDate, expectedRegErrorbirthDate);
    }


}
