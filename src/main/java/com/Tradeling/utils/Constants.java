package com.Tradeling.utils;

public class Constants {

	public static final String WebTest = "web";
	public static final String MobileTest = "mobile";
	
	public class WebTestData{
		public static final String AmazonUrL = "https://www.amazon.com/";
		public static final String userName = "test2323@mailinator.com";
		public static final String InvalidUserName = "test@test.com";
		public static final String passWrd = "1234@STA.com";
		public static final String invalidPassword = "dsadasdsdasda";
		public static final String invalidPsswrdValidation = "It appears that your email and/or password is incorrect";
	}

	public class DriverDesiredCapablities {
		public static final String app = "C:\\Users\\gamal.amir\\eclipse-workspace\\OoredooTest\\src\\test\\resources\\Apks\\Ooredoo.apk";
		public static final String platformName = "Andriod";
		public static final String EspressoFramework = "Espresso";
		public static final String UIAutomatorFramework = "UiAutomator2";
		public static final String InstallTimeOut = "40000";
		public static final String appActivity = ".facelift.activities.MaintainanceActivity t9247";
		public static final String appPackage = "qa.ooredoo.android";

		public class NougatDevice {
			public static final String NougatDevice = "Andriod_Nouget_Device";
			public static final String NougatDeviceID = "emulator-5554";
		}

		public class PieDevice {
			public static final String PieDevice = "Andriod_Pie_Device";
			public static final String PieDeviceID = "emulator-5556";
		}

		public class RealDeviceOreo {
			public static final String OreoDevice = "SM-G935FD";
			public static final String OreoDeviceID = "ce0117115bdf663005";
			public static final String OreoDeviceConfig = "";
		}
		
		public class RealDeviceN {
			public static final String NDevice = "SM-G965F/DS";
			public static final String NDeviceID = "38992b98263f7ece";
			public static final String OreoDeviceConfig = "";
		}

		public class RealDeviceLollipop {
			public static final String LolDevice = "D6503";
			public static final String LolDeviceID = "CB5A28213K";
			public static final String LolDeviceConfig = "";
		}

	}


	public class ExecutionData {
		public static final String gridDir = "/src/test/resources/Drivers";
		public static final String GridURL = "http://localhost:4444/wd/hub";
		public static final String GridUrlReg = "http://localhost:4444/grid/register";
		public static final String ChromeBrowser = "chrome";
		public static final String ChromePath = "/src/test/resources/Drivers/chromedriver.exe";
		public final String FFPath = System.getProperty("user.dir") + "/src/test/resources/Drivers/geckodriver.exe";
		public static final String FFBrowser = "firefox";
		public static final String IEBrowser = "iexplore";
	}

}
