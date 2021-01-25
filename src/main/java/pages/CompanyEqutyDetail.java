package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

@Slf4j
public class CompanyEqutyDetail extends BasePage{
    private static final String DIVIDEND_ERROR_MESSAGE =  "Dividend actual result doesn't match the expected dividend value";

    public CompanyEqutyDetail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@data-test='DIVIDEND_AND_YIELD-value']")
    private WebElement forwardDividendAndYield;

    @FindBy(xpath = "//span[text()='Statistics']")
    private WebElement statisticsTab;

    public void getAndValidateCompanyDividend(String dividend){
        log.info("Company dividend: " + forwardDividendAndYield.getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(forwardDividendAndYield.getText(), dividend, DIVIDEND_ERROR_MESSAGE);
        softAssert.assertAll();
    }

    public CompanyStatisticsPage goToStatisticsTab(){
        statisticsTab.click();

        return new CompanyStatisticsPage(driver);

    }
}
