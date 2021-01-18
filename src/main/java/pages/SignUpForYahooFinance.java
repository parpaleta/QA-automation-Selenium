package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SignUpForYahooFinance extends BasePage{

    public SignUpForYahooFinance(WebDriver driver) {
        super(driver);
    }

    private static final String EXPECTED_EMAIL_ERROR =  "This email address is not available for sign up, try something else";
    private static final String EXPECTED_PASSWORD_ERROR = "Your password isn’t strong enough, try making it longer.";
    private static final String EXPECTED_PHONE_ERROR = "That doesn’t look right, please re-enter your phone number.";
    private static final String EXPECTED_BIRTH_DATE_ERROR = "That doesn’t look right, please re-enter your birthday.";

    private static final String EMAIL_ERROR_MESSAGE =  "Inconsistency in the email error message";
    private static final String PASSWORD_ERROR_MESSAGE = "Inconsistency in the password error message";
    private static final String PHONE_ERROR_MESSAGE = "Inconsistency in the phone error message";
    private static final String BIRTH_DATE_ERROR_MESSAGE = "Inconsistency in the birth date error message";

    @FindBy(id="usernamereg-firstName")
    private WebElement firstName;

    @FindBy(id="usernamereg-lastName")
    private WebElement familyName;

    @FindBy(id="usernamereg-yid")
    private WebElement email;

    @FindBy(id="usernamereg-password")
    private WebElement password;

    @FindBy(id="usernamereg-phone")
    private WebElement phone;

    @FindBy(id="usernamereg-month")
    private WebElement userBirthMonth;

    @FindBy(id="usernamereg-day")
    private WebElement userBirthDay;

    @FindBy(id="usernamereg-year")
    private WebElement userBirthYear;

    @FindBy(id="reg-submit-button")
    private WebElement continueButton;

    @FindBy(id="reg-error-yid")
    private WebElement actualEmailErrorYid;

    @FindBy(id="reg-error-password")
    private WebElement actualPaswordError;

    @FindBy(id="reg-error-phone")
    private WebElement actualPhoneError;

    @FindBy(xpath="//div[contains(@class,'birthdate-error')]")
    private WebElement actualBirthDateError;

    public void setUpSignInData(String nameField, String familyNameField, String mailField,
                                String passField, String phoneNumberField, String bMonthField,
                                String bDayField, String bYearField) {

        firstName.clear();
        firstName.sendKeys(nameField);

        familyName.clear();
        familyName.sendKeys(familyNameField);

        email.clear();
        email.sendKeys(mailField);

        password.clear();
        password.sendKeys(passField);

        phone.clear();
        phone.sendKeys(phoneNumberField);

        userBirthMonth.sendKeys(bMonthField);

        userBirthDay.clear();
        userBirthDay.sendKeys(bDayField);

        userBirthYear.clear();
        userBirthYear.sendKeys(bYearField);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void validateErrorMessages(){
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(actualEmailErrorYid));

        softAssert.assertEquals(actualEmailErrorYid.getText(), EXPECTED_EMAIL_ERROR, EMAIL_ERROR_MESSAGE);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        softAssert.assertEquals(actualPaswordError.getText(), EXPECTED_PASSWORD_ERROR, PASSWORD_ERROR_MESSAGE);
        softAssert.assertEquals(actualPhoneError.getText(), EXPECTED_PHONE_ERROR, PHONE_ERROR_MESSAGE);
        softAssert.assertEquals(actualBirthDateError.getText(), EXPECTED_BIRTH_DATE_ERROR, BIRTH_DATE_ERROR_MESSAGE);

        softAssert.assertAll();
    }
}
