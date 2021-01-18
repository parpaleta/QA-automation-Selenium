package com.selenium.course.yahoo.finance.test02;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompanyEqutyDetail;
import pages.CompanyStatisticsPage;
import pages.YahooFinanceHomePage;
import utils.CsvReader;

import java.io.IOException;

public class CheckStatisticsForACompanyStock extends TestUtil {

    @DataProvider(name = "company-data")
    public static Object[][] dataProviderData() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/company-data.csv");
    }

    @Test(dataProvider = "company-data")
    public void executeTestCompanyDividends(String company, String dividend, String currentPriceBook) {

        YahooFinanceHomePage yahooHome = new YahooFinanceHomePage(driver);
        yahooHome.searchCompany(company);

        CompanyEqutyDetail companyEqutyDetail = new CompanyEqutyDetail(driver);
        companyEqutyDetail.getAndValidateCompanyDividend(dividend);
        companyEqutyDetail.goToStatisticsTab();

        CompanyStatisticsPage companyStatisticsPage = new CompanyStatisticsPage(driver);
        companyStatisticsPage.validateCurrentPriceBook(currentPriceBook);

    }


}
