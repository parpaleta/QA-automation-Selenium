package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooFinanceHomePage extends BasePage{

    public YahooFinanceHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="yfin-usr-qry")
    private WebElement searchArea;

    @FindBy(xpath = "//span[text()='Equity - NYQ']")
    private WebElement companyEuqityStockExchange;

//    @FindBy(xpath = "//ul[@class='modules_list__1zFHY']//li[@data-index='0' and @data-test='srch-sym']")
    @FindBy(xpath = "//li[@data-index='0' and @data-test='srch-sym']")
    private WebElement searchedCompanyEquity;

    @FindBy(id = "header-signin-link")
    private WebElement singInButton;

    public SignInYahooFinancePage executeSignInButton(){
        singInButton.click();
        return new SignInYahooFinancePage(driver);
    }

    public CompanyEqutyDetail searchCompany(String company){
        searchArea.clear();
        searchArea.sendKeys(company);

        searchedCompanyEquity.click();
        return new CompanyEqutyDetail(driver);

    }
}
