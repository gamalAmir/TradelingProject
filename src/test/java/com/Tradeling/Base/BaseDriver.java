package com.Tradeling.Base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.Tradeling.Core.DesiredCapManager;
import com.Tradeling.CustomTestListeners.CustomTestListener;
import com.Tradeling.utils.Constants;
import com.Tradeling.utils.ExtentManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseDriver {

	protected DesiredCapManager DCManager = new DesiredCapManager();
	public Logger log = Logger.getLogger(BaseDriver.class);

	// report thread safe
	protected static ExtentReports extent = ExtentManager.createInstance();
	protected static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	protected ThreadLocal<ExtentTest> Parentest = new ThreadLocal<ExtentTest>();

	// testType thread safe
	protected String TestType;
	protected static ThreadLocal<String> GlobalTest = new ThreadLocal<String>();

	public String getTestType() {
		return GlobalTest.get();
	}

	public void setTestType(String testType) {
		GlobalTest.set(testType);
	}

	// WebDriver Thread Safe
	protected RemoteWebDriver wdriver;
	protected static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

	public void setWebDriver(RemoteWebDriver driver) {
		dr.set(driver);

	}

	public RemoteWebDriver getDriver() {
		return dr.get();
	}

	// MobileDriver thread safe
	protected AndroidDriver<MobileElement> mDriver;
	public static ThreadLocal<AndroidDriver<MobileElement>> dm = new ThreadLocal<AndroidDriver<MobileElement>>();

	public AndroidDriver<MobileElement> getmDriver() {
		return dm.get();
	}

	public void setmDriver(AndroidDriver<MobileElement> mDriver) {
		dm.set(mDriver);

	}

	public void logInfo(String message) {
		Markup m = MarkupHelper.createLabel(message, ExtentColor.GREY);
		CustomTestListener.test.get().info(m);
		log.info("in test timing::" + getcurrentdateandtime() + " " + message);
	}

	public void logException(String message) {
		if (!message.isEmpty() && message != null) {
			Markup m = MarkupHelper.createLabel(message, ExtentColor.BLACK);
			CustomTestListener.test.get().info(m);
			log.trace("Log ::" + getcurrentdateandtime() + " " + message);
		} else {
			Markup m = MarkupHelper.createLabel(message, ExtentColor.WHITE);
			CustomTestListener.test.get().info(m);
			log.trace("No Exception logged");
		}
	}

	public void logPassFail(String message, boolean passFail) {
		if (passFail) {
			Markup m = MarkupHelper.createLabel(message, ExtentColor.GREEN);
			CustomTestListener.test.get().log(Status.PASS, m);
			log.info("in test timing::" + getcurrentdateandtime() + " " + message);
		} else {
			Markup m = MarkupHelper.createLabel(message, ExtentColor.RED);
			CustomTestListener.test.get().log(Status.FAIL, m);
			log.info("in test timing::" + getcurrentdateandtime() + " " + message);
		}
	}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src/test/resources/properties"
				+ File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void logScreenshot(String message) throws IOException, InterruptedException {

		if (getTestType().equals(Constants.WebTest)) {
			CustomTestListener.test.get().info(message).addScreenCaptureFromPath(takeWebScreenShot());
			log.info("in test timing::" + getcurrentdateandtime() + " " + message);
		} else if (getTestType().equals(Constants.MobileTest)) {
			CustomTestListener.test.get().info(message).addScreenCaptureFromPath(takeScreenShot());
			log.info("in test timing::" + getcurrentdateandtime() + " " + message);
		}
	}

	public String takeScreenShot() throws IOException, InterruptedException {
		Thread.sleep(500);
		TakesScreenshot screen = (TakesScreenshot) getmDriver();
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = ExtentManager.reportDir + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String takeWebScreenShot() throws IOException, InterruptedException {
		Thread.sleep(500);
		TakesScreenshot screen = (TakesScreenshot) getDriver();
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = ExtentManager.reportDir + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {

		}
		return str;
	}

}
