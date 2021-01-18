package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInYahooFinancePage extends BasePage{
    public SignInYahooFinancePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(@class,'sign-up-link')]")
    private WebElement createAnAccountButton;

    public SignUpForYahooFinance executeCreateAnAccountButton(){
        createAnAccountButton.click();
        return new SignUpForYahooFinance(driver);
    }
}
