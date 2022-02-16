package com.Tradeling.WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(id = "nav-hamburger-menu")
    private WebElement sideMenuBtn;

    @FindBy(xpath = "//div[@id='nav-xshop']/a[contains(text(),'Today')]")
    private WebElement todayDealBtn;

    @FindBy(xpath = "//div[@aria-labelledby='glow-toaster-title']")
    private WebElement alert;

    @FindBy(xpath = "//a[@aria-label='Choose a language for shopping.']")
    private WebElement currencyLabel;

    @FindBy(xpath = "//div[@id='nav-flyout-icp']//a[@href='/gp/customer-preferences/select-currency/ref=icp_cop_flyout_change?preferencesReturnUrl=%2F']")
    private WebElement changeCurrency;

    @FindBy(xpath = "//div[@class='glow-toaster-footer']//input[@data-action-type='DISMISS']")
    private WebElement alertDismmisBtn;

    @FindBy(xpath = "//div[@id='nav-flyout-icp']//span[contains(text(),'Change currency ')]/parent::span/following-sibling::span[1]//span[@dir]/parent::span")
    private WebElement selectedCurrency;

    @FindBy(xpath = "//div[contains(@id,'Card')]/child::div[contains(@class,'result')]/div")
    private List<WebElement> displayedItems;

    @FindBy(id = "searchDropdownBox")
    private WebElement searchDDL;

    private WebElement sideMenuItem(String itemTxt) {
        return driver.findElement(By.xpath("//div[@id='hmenu-content']//li[(not(contains(@class,'hmenu-separator')))]//div[contains(text(),'" + itemTxt + "')]"));
    }

    private WebElement sideMenuSubItem(String firstItme, String Category) {
        return driver.findElement(By.xpath("//div[contains(text(),'" + firstItme + "')]/parent::li/following-sibling::li/a[contains(text(),'" + Category + "')]"));
    }

    private WebElement subCategory(String SubCategory) {
        return driver.findElement(By.xpath("//img[contains(@alt,'" + SubCategory + "')]"));
    }

    public void GoToCategoryList() {
        WaitAndClickOnElement(sideMenuBtn);
    }

    public void ChooseCategory(String Category) {
        clickOnElement(sideMenuItem(Category));
    }

    public void ChooseSubCategory(String Category, String SubCategory) throws InterruptedException {
        clickOnElement(sideMenuSubItem(Category, SubCategory));
    }

    public void ChooseSubCategoryProduct(String Category) throws InterruptedException {
        Thread.sleep(2000);
        WaitUntilElementVisisble(subCategory(Category));
        ScrollToElement(subCategory(Category));
        clickOnElement(subCategory(Category));
    }

    public int GetNumberOfDisItems(String Category, String SubCategory) {
        By num = By.xpath("//div[contains(@id,'Card')]//span[contains(text(),'" + Category + ": " + SubCategory + "')]/preceding-sibling::span");
        String totalNumberTxt = GetText(ReturnElement(num));
        totalNumberTxt = totalNumberTxt.substring(0, totalNumberTxt.indexOf("of") - 1);
        totalNumberTxt = totalNumberTxt.substring(2);
        int number = Integer.valueOf(totalNumberTxt);
        return number;
    }

    public void changeCurrencyToAED() {
        hoverAndClick(currencyLabel, changeCurrency);
    }

    public void selectSearchOption(String option) throws InterruptedException {
        waitForElementToBeDisplayed(searchDDL);
        SelectFromDDL(searchDDL,option);
    }

    public boolean checkSelectedCurrency(String currency) throws InterruptedException {
        hover(currencyLabel);
        Thread.sleep(1000);
        if (selectedCurrency.getText().contains("United Arab Emirates Dirham")) {
            HighlightValidtion(selectedCurrency);
            return true;
        } else {
            return false;
        }
    }

    public void ClickOnTodaysDeal() {
        AdvancedClick(todayDealBtn);
    }

    public int GetActualDisplayedItems() {
        return displayedItems.size();
    }


}
