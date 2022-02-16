package com.Tradeling.MobileUI;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;

public class BaseActivity {

	private  AndroidDriver<MobileElement> driver = null;

	private static WebDriverWait wait;

	public BaseActivity(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		BaseActivity.wait = new WebDriverWait(this.driver, 10);

	}

	protected  void WaitAndTab(AndroidElement elm) {
		wait.until(ExpectedConditions.visibilityOf(elm)).click();
	}

	protected  void SwipeHorizentallyToElement(AndroidElement from, AndroidElement to) {
		int startY = from.getLocation().getY() + (from.getSize().getHeight() / 2);
		int startX = from.getLocation().getX() + (from.getSize().getWidth() / 2);
		int endX = to.getLocation().getX() + (to.getSize().getWidth() / 2);
		int endY = to.getLocation().getY() + (to.getSize().getHeight() / 2);
		new TouchAction(driver).press(ElementOption.point(startX, startY))
				.waitAction(waitOptions(Duration.ofMillis(3000))).moveTo(ElementOption.point(endX, endY)).release()
				.perform();
	}

	protected  void swipeWholeScreenHorizentally(String Device) {
		driver.executeScript("mobile:shell", "input swipe 1005 957 78 1023");
	}

	protected  void WaitUntillElementNotDisplayed(AndroidElement elm) {
		wait.until(ExpectedConditions.invisibilityOf(elm));
	}

	protected  void WaitUntillElementDisplayed(AndroidElement elm) {
		wait.until(ExpectedConditions.visibilityOf(elm));
	}

	protected  void SwipeVertically(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);
		new TouchAction(driver).press(point(anchor, startPoint)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(anchor, endPoint)).release().perform();
	}

}
