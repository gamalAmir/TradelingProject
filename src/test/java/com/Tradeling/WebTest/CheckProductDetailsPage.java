package com.Tradeling.WebTest;

import com.Tradeling.Base.BaseWeb;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckProductDetailsPage extends BaseWeb {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Check Product Details Page")
    public void Scenario2(ITestContext arg) {
        try {
            logInfo("browser " + arg.getCurrentXmlTest().getParameter("browser"));

            homePage.selectSearchOption("Electronics");
            logInfo("user select electronics from search dropdownList");

            homePage.typeSearch("apple");
            logInfo("user type apple to search on");

            searchResultsPage.ClickOnSearchResult();
            logInfo("user select first searchResult");

            softAssert.assertTrue(searchResultsPage.verifyAvailblityDisplayed(),"product availblity not displayed");

            softAssert.assertTrue(searchResultsPage.verifyPriceDisplayed(),"product price not displayed");

            softAssert.assertAll();

        } catch (Exception e) {
            logException(e.getStackTrace().toString());
        }
    }
}
