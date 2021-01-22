package com.selenium.course.yahoo.finance.test01;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInYahooFinancePage;
import pages.SignUpForYahooFinance;
import pages.YahooFinanceHomePage;
import utils.CsvReader;

import java.io.IOException;

public class YahooFinanceSignInTest extends TestUtil {

    @BeforeTest
    public void signUpBeforeTest(){
        YahooFinanceHomePage loadYahooFinanceHomePage = new YahooFinanceHomePage(driver);
        loadYahooFinanceHomePage.executeSignInButton();
        SignInYahooFinancePage signInYahooFinancePage = new SignInYahooFinancePage(driver);
        signInYahooFinancePage.executeCreateAnAccountButton();
    }

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/signin-data.csv");
    }

    @Test(dataProvider = "login-data")
    public void executeTestSignUpYahnooFinance(String name, String familyName, String mail,
                                               String pass, String phoneNumber, String bMonth,
                                               String bDay, String bYear){
        SignUpForYahooFinance signUp = new SignUpForYahooFinance(driver);
        signUp.setUpSignInData(name, familyName, mail,
                              pass, phoneNumber, bMonth,
                              bDay, bYear);

        signUp.clickContinueButton();

        signUp.validateErrorMessages();
    }
}
