package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CompanyStatisticsPage extends BasePage{
    public CompanyStatisticsPage(WebDriver driver) {
        super(driver);
    }

    private static final String CURRENT_PRICE_BOOK_ERROR_MESSAGE="Current Price/Book doesn't match expected Price/Book value.";

    //span[text()='Current']//ancestor::table[@class='W(100%) Bdcl(c)  M(0) Whs(n) BdEnd Bdc($seperatorColor) D(itb)']//tr[7]//td[2]
    @FindBy(xpath = "//span[text()='Current']//ancestor::table[contains(@class,'BdEnd Bdc')]//tr[7]//td[2]")
    private WebElement currentPriceBook;

    public void validateCurrentPriceBook(String currentPriceBookField){
        Assert.assertEquals(currentPriceBook.getText(), currentPriceBookField, CURRENT_PRICE_BOOK_ERROR_MESSAGE);
    }
}
