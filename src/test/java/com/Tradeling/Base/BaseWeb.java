package com.Tradeling.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import com.Tradeling.WebUI.CurrencyPage;
import com.Tradeling.WebUI.DealsPage;
import com.Tradeling.WebUI.HomePage;
import com.Tradeling.WebUI.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Tradeling.utils.Constants;

public class BaseWeb extends BaseDriver {
	
	public HomePage homePage;
	public DealsPage dealsPage;
	public CurrencyPage currencyPage;
	public SearchResultsPage searchResultsPage;

	public void openBrowser(String Browser) throws MalformedURLException {
		if (Browser.equals(Constants.ExecutionData.ChromeBrowser)) {
			wdriver = new RemoteWebDriver(new URL(Constants.ExecutionData.GridURL), DCManager.ChromeDC());
		} else if (Browser.equals(Constants.ExecutionData.FFBrowser)) {
			wdriver = new RemoteWebDriver(new URL(Constants.ExecutionData.GridURL), DCManager.FFDC());
		}
		setWebDriver(wdriver);
		setTestType(Constants.WebTest);
		homePage = new HomePage(getDriver());
		dealsPage = new DealsPage(getDriver());
		currencyPage = new CurrencyPage(getDriver());
		searchResultsPage = new SearchResultsPage(getDriver());
	}

	@Parameters({ "browser" })
	@BeforeMethod()
	public void setup(String browser) throws MalformedURLException, Throwable {
		openBrowser(browser);
		getDriver().get(Constants.WebTestData.AmazonUrL);
		getDriver().setLogLevel(Level.ALL);
		// getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
	}

	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}

	protected void WaitTextDisplayed(String txt) {
		String genericXpath = String.format("//*[contains(text(),'%s')]", txt);
		By xpath_ = By.xpath(genericXpath);
	}

	protected boolean CheckForTextDisplayed(String txt) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String scrollElementIntoMiddle = "arguments[0].style.border='3px solid green'";
		String genericXpath = String.format("//*[contains(text(),'%s')]", txt);
		WebElement elm = getDriver().findElementByXPath(genericXpath);
		if (getDriver().findElementByXPath(genericXpath).isDisplayed()) {
			js.executeScript(scrollElementIntoMiddle, elm);
			return true;
		} else {
			return false;
		}

	}

}
