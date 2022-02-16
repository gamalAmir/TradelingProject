package com.Tradeling.WebUI;

import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.functions.ExpectedCondition;


public class BasePage {

    protected RemoteWebDriver driver;

    private WebDriverWait wait;

    private JavascriptExecutor js;

    public BasePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
        js = (JavascriptExecutor) this.driver;

    }

    protected void WaitUntilElementVisisble(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    protected boolean checkElmEnabled(By elm) {
        return driver.findElement(elm).isDisplayed();
    }

    protected void WaitAndTypeOnElement(WebElement elm, String txt) {
        wait.until(ExpectedConditions.visibilityOf(elm)).sendKeys(txt);

    }

    protected void WaitAndClickOnElement(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
        elm.click();
    }

    protected void SelectFromDDL(WebElement ddl, String Option) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOf(ddl));
        Thread.sleep(6000);
        Select select = new Select(ddl);
        select.deselectByVisibleText(Option);
    }

    protected void waitForElementToBeDisplayed(WebElement elm){
        wait.until(ExpectedConditions.visibilityOf(elm));
    }

    protected void hoverAndClick(WebElement hoverElm, WebElement clickElm) {
        wait.until(ExpectedConditions.visibilityOf(hoverElm));
        hoverElm.click();
        Actions action = new Actions(driver);
        action.moveToElement(hoverElm).click(clickElm).build().perform();
    }

    protected void hover(WebElement hoverElm) {
        wait.until(ExpectedConditions.visibilityOf(hoverElm));
        Actions action = new Actions(driver);
        action.moveToElement(hoverElm).build().perform();
    }

    protected void WaitAndTypeInElement(WebElement elm, String text) {
        wait.until(ExpectedConditions.visibilityOf(elm)).sendKeys(text);
    }

    protected void ScrollToElement(WebElement elm) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        js.executeScript(scrollElementIntoMiddle, elm);
    }

    protected void fluentWaitUntilElementVisibel(WebElement elm) {
        Awaitility.await().atMost(30, TimeUnit.SECONDS).until(elm::isDisplayed);
    }

    protected void fluentWaitUntilElementNotVisibel(WebElement elm) {
        Awaitility.await().atMost(30, TimeUnit.SECONDS).until(elm::isDisplayed);
    }

    protected void WaitUntilElementNotVisibel(WebElement elm) {
        wait.until(ExpectedConditions.invisibilityOf(elm));
    }

    protected void HighlightValidtion(WebElement elm) {
        String scrollElementIntoMiddle = "arguments[0].style.border='3px solid green'";
        js.executeScript(scrollElementIntoMiddle, elm);
    }

    protected void AdvancedClick(WebElement elm){
        String clickScript = "arguments[0].click();";
        js.executeScript(clickScript, elm);
    }

    protected void HighlightError(WebElement elm) {
        String scrollElementIntoMiddle = "arguments[0].style.border='3px solid red'";
        js.executeScript(scrollElementIntoMiddle, elm);
    }

    protected WebElement ReturnElement(By locator) {
        WebElement elm = driver.findElement(locator);
        return elm;
    }

    protected void clickOnElement(WebElement elm) {
        elm.click();
    }

    protected String GetText(WebElement elm) {
        return elm.getText();
    }

    protected void switchToForm(WebElement elm){
        driver.switchTo().frame(elm);
    }

    public void waitForElementAreComplete(By by, int expected) {
        ExpectedCondition<Boolean> angularLoad = driver -> {
            int loadingElements = this.driver.findElements(by).size();
            return loadingElements >= expected;
        };
        wait.until(angularLoad);
    }


    public void waitAllRequest() {
        waitUntilJSReady();
        ajaxComplete();
        waitUntilJQueryReady();
        waitUntilAngularReady();
        waitUntilAngular5Ready();
    }

    private void waitUntilJSReady() {
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) this.driver)
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {
                wait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    protected void ajaxComplete() {
        js.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    public void waitUntilAngularReady() {
        try {
            Boolean angularUnDefined = (Boolean) js.executeScript("return window.angular === undefined");
            if (!angularUnDefined) {
                Boolean angularInjectorUnDefined = (Boolean) js.executeScript("return angular.element(document).injector() === undefined");
                if (!angularInjectorUnDefined) {
                    poll(20);

                    waitForAngularLoad();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }

    protected void waitUntilAngular5Ready() {
        try {
            Object angular5Check = js.executeScript("return getAllAngularRootElements()[0].attributes['ng-version']");
            if (angular5Check != null) {
                Boolean angularPageLoaded = (Boolean) js.executeScript("return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1");
                if (!angularPageLoaded) {
                    poll(20);

                    waitForAngular5Load();

                    poll(20);
                }
            }
        } catch (WebDriverException ignored) {
        }
    }


    protected void waitUntilJQueryReady() {
        Boolean jQueryDefined = (Boolean) js.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll(20);

            waitForJQueryLoad();

            poll(20);
        }
    }

    private void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForJQueryLoad() {
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                wait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private void waitForAngular5Load() {
        String angularReadyScript = "return window.getAllAngularTestabilities().findIndex(x=>!x.isStable()) === -1";
        angularLoads(angularReadyScript);
    }

    private void waitForAngularLoad() {
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        angularLoads(angularReadyScript);
    }

    private void angularLoads(String angularReadyScript) {
        try {
            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript(angularReadyScript).toString());

            boolean angularReady = Boolean.valueOf(js.executeScript(angularReadyScript).toString());

            if (!angularReady) {
                wait.until(angularLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }


}
