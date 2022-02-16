package com.Tradeling.WebTest;

import com.Tradeling.Base.BaseWeb;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CheckProductDetailsPage extends BaseWeb {
    @Test(description = "Check filter by department in Deals and Promotions page")
    public void Scenario2(ITestContext arg) {
        try {
            logInfo("browser " + arg.getCurrentXmlTest().getParameter("browser"));

            homePage.selectSearchOption("Electronics");
            logInfo("user click on todays deal");



        } catch (Exception e) {
            logException(e.getStackTrace().toString());
        }
    }
}
