package com.Tradeling.WebTest;

import com.Tradeling.Base.BaseWeb;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CheckFilterByDepartmentInDealsAndPromotionsPage extends BaseWeb {

    @Test(description = "Check filter by department in Deals and Promotions page")
    public void Scenario2(ITestContext arg) {
        try {
            logInfo("browser " + arg.getCurrentXmlTest().getParameter("browser"));

            homePage.ClickOnTodaysDeal();
            logInfo("user click on todays deal");

            dealsPage.SelectDesiredDept("Software");
            logInfo("user click on software department");

            Assert.assertTrue(dealsPage.checkDeptSelected("Software"),"Web app doesnt respond to department change");

        } catch (Exception e) {
            logException(e.getStackTrace().toString());
        }
    }
}
