package com.Tradeling.WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CurrencyPage extends BasePage{
    public CurrencyPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@method='post']")
    private WebElement pageForm;

    @FindBy(xpath = "//form[@method='post']//span[contains(text(),'Select the currency')]/following-sibling::p//select/following-sibling::span//span[@id='a-autoid-0-announce']")
    private WebElement currencyDDL;

    private WebElement currencyselect(){
        return driver.findElement(By.xpath("//form[@method='post']//span[contains(text(),'Select the currency')]/following-sibling::p//select/following-sibling::span//span[@id='a-autoid-0-announce']"));
    }

    @FindBy(xpath = "//span[@id='icp-btn-save-announce']")
    private WebElement saveChanges;

    private WebElement currencyItem(String currrency) {
        return driver.findElement(By.xpath("//ul[@aria-multiselectable='false']//a[contains(text(),'" + currrency + "')]"));
    }

    public void SelectCurrency(String currency) throws InterruptedException {
        Select select = new Select(currencyselect());
        select.selectByValue(currency);
        clickOnElement(saveChanges);
    }
}
