package com.Tradeling.WebTest;

import com.Tradeling.Base.BaseWeb;
import com.Tradeling.WebUI.HomePage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Tradeling.utils.Constants;

public class CheckTheTotalDisplayedNumberResultsForCategory extends BaseWeb {



	@Test(description = "Check the total displayed number of results for category Smart Home")
	public void Scenario1(ITestContext arg) {
		try {
			logInfo("browser " + arg.getCurrentXmlTest().getParameter("browser"));

			homePage.GoToCategoryList();
			logInfo("user go to category list");

			homePage.ChooseCategory("Smart Home");
			logInfo("user choose category smart home");

			homePage.ChooseSubCategory("smart home","Home Entertainment");
			logInfo("user choose sub category Home Entertainment");

			homePage.ChooseSubCategoryProduct("Televisions");
			logInfo("user choose category televisions");

			Assert.assertEquals(homePage.GetNumberOfDisItems("Smart Home","Home Entertainment"),homePage.GetActualDisplayedItems(),"Number of displayed items not equall");


		} catch (Exception e) {
			logException(e.getStackTrace().toString());
		}
	}

}