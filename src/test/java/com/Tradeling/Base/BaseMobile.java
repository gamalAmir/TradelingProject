package com.Tradeling.Base;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Tradeling.utils.Constants;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseMobile extends BaseDriver {

	@Parameters({ "device" })
	@BeforeMethod
	public void setup(String device) throws Throwable {
		if (device.equals(Constants.DriverDesiredCapablities.RealDeviceOreo.OreoDevice)) {
			mDriver = new AndroidDriver<MobileElement>(new URL(Constants.ExecutionData.GridURL),
					DCManager.SamsungOreoMobileDC());

		} else if (device.equals(Constants.DriverDesiredCapablities.RealDeviceLollipop.LolDevice)) {
			mDriver = new AndroidDriver<MobileElement>(new URL(Constants.ExecutionData.GridURL),
					DCManager.SonyMobileDC());
		} else {
			mDriver = new AndroidDriver<MobileElement>(new URL(Constants.ExecutionData.GridURL),
					DCManager.SamsungNMobileDC());
		}
		setmDriver(mDriver);
		setTestType(Constants.MobileTest);
		getmDriver();
		getmDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		getmDriver().quit();
	}

}
