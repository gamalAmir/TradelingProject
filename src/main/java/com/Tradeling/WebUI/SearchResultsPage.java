package com.Tradeling.WebUI;

import com.Tradeling.Core.DataGenarator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage{

    public SearchResultsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'s-main-slot')]/div")
    private List<WebElement> searchRslts;

    @FindBy(xpath = "//form[@id = 'addToCart']/div//div[contains(@id,'price')]//span[@class='a-offscreen']")
    private WebElement productPrice;

    @FindBy(xpath = "//form[@id = 'addToCart']/div//div[@id = 'availability']/span")
    private WebElement productAvailablity;

    public void ClickOnSearchResult() throws InterruptedException {
        ScrollToElement(searchRslts.get(searchRslts.size() - 10));
        clickOnElement(searchRslts.get(searchRslts.size() - 10));
        Thread.sleep(3000);
    }

    public Boolean verifyPriceDisplayed(){
        if (productPrice.isDisplayed()){
            HighlightValidtion(productPrice);
            return true;
        }else{
            return false;
        }
    }

    public Boolean verifyAvailblityDisplayed(){
        if (productAvailablity.isDisplayed()){
            HighlightValidtion(productAvailablity);
            return true;
        }else{
            return false;
        }
    }
}
