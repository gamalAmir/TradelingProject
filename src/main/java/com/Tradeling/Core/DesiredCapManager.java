package com.Tradeling.Core;

import java.util.Collections;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.Tradeling.utils.Constants;
import com.Tradeling.utils.Constants.DriverDesiredCapablities;

import io.appium.java_client.remote.MobileCapabilityType;

public class DesiredCapManager {

	private DesiredCapabilities dc;

	private DesiredCapabilities WebFfDC;

	private DesiredCapabilities WebChDC;

	private DesiredCapabilities S7Web;
	private ThreadLocal<DesiredCapabilities> s7web = new ThreadLocal<DesiredCapabilities>();

	public DesiredCapabilities getS7Web() {
		return s7web.get();
	}

	public void setS7Web() {
		S7Web = new DesiredCapabilities();
		S7Web.setCapability(MobileCapabilityType.UDID, Constants.DriverDesiredCapablities.RealDeviceOreo.OreoDeviceID);
		S7Web.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		// S7Web.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		// S7Web.setCapability(MobileCapabilityType.DEVICE_NAME,
		// Constants.DriverDesiredCapablities.RealDeviceOreo.OreoDevice);
		S7Web.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		s7web.set(S7Web);
	}

	private DesiredCapabilities S9Web;
	private ThreadLocal<DesiredCapabilities> s9web = new ThreadLocal<DesiredCapabilities>();

	public DesiredCapabilities getS9Web() {
		return s9web.get();
	}

	public void setS9Web() {
		S9Web = new DesiredCapabilities();
		S9Web.setCapability(MobileCapabilityType.UDID, Constants.DriverDesiredCapablities.RealDeviceN.NDeviceID);
		S9Web.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		S9Web.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.0");
//		S9Web.setCapability(MobileCapabilityType.DEVICE_NAME, Constants.DriverDesiredCapablities.RealDeviceN.NDevice);
		S9Web.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		s9web.set(S9Web);
	}

	public DesiredCapabilities MobileChromeDC() {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, DriverDesiredCapablities.RealDeviceOreo.OreoDeviceID);
		dc.setCapability("appPackage", Constants.DriverDesiredCapablities.appPackage);
		dc.setCapability("appActivity", Constants.DriverDesiredCapablities.appActivity);
		dc.setCapability("automationName", Constants.DriverDesiredCapablities.UIAutomatorFramework);
		dc.setCapability("ignoreUnimportantViews", true);
		dc.setCapability("skipDeviceInitialization", true);
		dc.setCapability("noReset", true);
		return dc;
	}

	public DesiredCapabilities SamsungOreoMobileDC() {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, DriverDesiredCapablities.RealDeviceOreo.OreoDeviceID);
		dc.setCapability("appPackage", Constants.DriverDesiredCapablities.appPackage);
		dc.setCapability("appActivity", Constants.DriverDesiredCapablities.appActivity);
		dc.setCapability("automationName", Constants.DriverDesiredCapablities.UIAutomatorFramework);
		dc.setCapability("ignoreUnimportantViews", true);
		dc.setCapability("skipDeviceInitialization", true);
		dc.setCapability("noReset", true);
		return dc;
	}

	public DesiredCapabilities SonyMobileDC() {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, DriverDesiredCapablities.RealDeviceLollipop.LolDeviceID);
		dc.setCapability("appPackage", Constants.DriverDesiredCapablities.appPackage);
		dc.setCapability("appActivity", Constants.DriverDesiredCapablities.appActivity);
		dc.setCapability("automationName", Constants.DriverDesiredCapablities.UIAutomatorFramework);
		dc.setCapability("ignoreUnimportantViews", true);
		dc.setCapability("skipDeviceInitialization", true);
		dc.setCapability("noReset", true);
		return dc;

	}

	public DesiredCapabilities SamsungNMobileDC() {
		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.UDID, DriverDesiredCapablities.RealDeviceN.NDeviceID);
		dc.setCapability("appPackage", Constants.DriverDesiredCapablities.appPackage);
		dc.setCapability("appActivity", Constants.DriverDesiredCapablities.appActivity);
		dc.setCapability("automationName", Constants.DriverDesiredCapablities.UIAutomatorFramework);
		dc.setCapability("ignoreUnimportantViews", true);
		dc.setCapability("skipDeviceInitialization", true);
		dc.setCapability("noReset", true);
		return dc;
	}

	public DesiredCapabilities ChromeDC() {
		WebChDC = new DesiredCapabilities();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//		options.setExperimentalOption("useAutomationExtension", false);
		WebChDC = DesiredCapabilities.chrome();
//		WebChDC.setCapability(ChromeOptions.CAPABILITY, options);
		WebChDC.setBrowserName(Constants.ExecutionData.ChromeBrowser);
		WebChDC.setJavascriptEnabled(true);
		WebChDC.setPlatform(Platform.ANY);
		return WebChDC;
	}

	public DesiredCapabilities FFDC() {
		WebFfDC = new DesiredCapabilities();
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("webdriver-active", false);
		WebFfDC = DesiredCapabilities.firefox();
		WebFfDC.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		WebFfDC.setBrowserName(Constants.ExecutionData.FFBrowser);
		WebFfDC.setPlatform(Platform.ANY);
		WebFfDC.setJavascriptEnabled(true);
		return WebFfDC;
	}
}
