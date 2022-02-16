package com.Tradeling.WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class CurrencyPage extends BasePage{
    public CurrencyPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@method='post']")
    private WebElement pageForm;

    @FindBy(xpath = "//form[@method='post']//span[contains(text(),'Select the currency')]/following-sibling::p//select/following-sibling::span//span[@id='a-autoid-0-announce']")
    private WebElement currencyDDL;


    @FindBy(xpath = "//span[@id='icp-btn-save-announce']")
    private WebElement saveChanges;

    private WebElement currencyItem(String currrency) {
        return driver.findElement(By.xpath("//ul[@aria-multiselectable='false']//a[contains(text(),'" + currrency + "')]"));
    }

    public void SelectCurrency(String currency) throws InterruptedException {
        Thread.sleep(8000);
        switchToForm(pageForm);
        clickOnElement(currencyDDL);
        clickOnElement(currencyItem(currency));
        clickOnElement(saveChanges);
    }
}
