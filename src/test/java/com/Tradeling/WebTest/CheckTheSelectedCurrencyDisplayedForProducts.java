package com.Tradeling.WebTest;

import com.Tradeling.Base.BaseWeb;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckTheSelectedCurrencyDisplayedForProducts extends BaseWeb {

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Check The Selected Currency Displayed For Products")
    public void Scenario3(ITestContext arg) {
        try {
            logInfo("browser " + arg.getCurrentXmlTest().getParameter("browser"));

            homePage.changeCurrencyToAED();
            logInfo("user attempt to change currency");

            currencyPage.SelectCurrency("AED");
            logInfo("user change currency to AED - Arab Emirates Dirham");

            softAssert.assertTrue(homePage.checkSelectedCurrency("United Arab Emirates Dirham"),"User can not change language");

        } catch (Exception e) {
            logException(e.getStackTrace().toString());
        }
    }

}
