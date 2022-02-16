package com.Tradeling.WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends BasePage{
    public DealsPage(RemoteWebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Departments')]")
    private WebElement departmentsSection;

    private WebElement deptSelection(String value){
        return driver.findElement(By.xpath("//span[@aria-label='Departments filter']/div[last()]/div//span[contains(text(),'"+value+"')]"));
    }

    private WebElement deptSelectionCheckBox(String value){
        return driver.findElement(By.xpath("//span[@aria-label='Departments filter']/div[last()]/div//span[contains(text(),'"+value+"')]/preceding-sibling::input"));
    }

    public void SelectDesiredDept(String dept) throws InterruptedException {
        WaitUntilElementVisisble(departmentsSection);
        ScrollToElement(deptSelection(dept));
        clickOnElement(deptSelection(dept));
        Thread.sleep(1000);
    }

    public Boolean checkDeptSelected(String dept){
        if (deptSelectionCheckBox(dept).isSelected()){
            HighlightValidtion(deptSelection(dept));
        }else{
            HighlightError(deptSelection(dept));
        }
        return deptSelectionCheckBox(dept).isSelected();
    }
}
