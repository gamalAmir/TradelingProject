package com.Tradeling.Core;

import com.Tradeling.utils.Constants;

public class ExecutionLauncher {

	public static void launchGrid() throws Throwable {
		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		String ExecGridComm = String.format(
				"cmd /c start cmd.exe /K \"%s && java -jar selenium-server-standalone-3.141.59.jar -role hub\"",
				GoToDirComm);
		try {
			Runtime.getRuntime().exec(ExecGridComm);
		} catch (Exception e) {
			System.out.println("U r Doing Something Wrong ");
			e.printStackTrace();
		}
		Thread.sleep(4000);
	}

	public static void launchWebNode(String browserName) throws Throwable {
		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		if (browserName.equals(Constants.ExecutionData.ChromeBrowser)) {
			String ExecGridComm = String.format(
					"cmd /c start cmd.exe /K \"%s && java -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.gecko.driver=geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig ChromeNode.json\"",
					GoToDirComm);
			try {
				Runtime.getRuntime().exec(ExecGridComm);
				System.out.println(ExecGridComm);
			} catch (Exception e) {
				System.out.println("U r Doing Something Wrong ");
				e.printStackTrace();
			}
		} else if (browserName.equals(Constants.ExecutionData.FFBrowser)) {
			String ExecGridComm = String.format(
					"cmd /c start cmd.exe /K \"%s && java -Dwebdriver.chrome.driver=chromedriver.exe -Dwebdriver.gecko.driver=geckodriver.exe -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig FireFoxNode.json\"",
					GoToDirComm);
			try {
				Runtime.getRuntime().exec(ExecGridComm);
				System.out.println(ExecGridComm);
			} catch (Exception e) {
				System.out.println("U r Doing Something Wrong ");
				e.printStackTrace();
			}
		} else if (browserName.equals(Constants.DriverDesiredCapablities.RealDeviceOreo.OreoDevice)) {
			String ExecGridComm = String.format(
					"cmd /c start cmd.exe /K \"%s && appium -p 3445 --nodeconfig S7Edge.json --chromedriver-executable chromedriver.exe --session-override\"",
					GoToDirComm);
			try {
				Runtime.getRuntime().exec(ExecGridComm);
				Thread.sleep(2000);
				System.out.println(ExecGridComm);
			} catch (Exception e) {
				System.out.println("U r Doing Something Wrong ");
				e.printStackTrace();
			}
		}else if (browserName.equals(Constants.DriverDesiredCapablities.RealDeviceN.NDevice)) {
			String ExecGridComm = String.format(
					"cmd /c start cmd.exe /K \"%s && appium -p 5674 --nodeconfig S9Plus.json --chromedriver-executable chromedriver.exe --session-override\"",
					GoToDirComm);
			try {
				Runtime.getRuntime().exec(ExecGridComm);
				Thread.sleep(2000);
				System.out.println(ExecGridComm);
			} catch (Exception e) {
				System.out.println("U r Doing Something Wrong ");
				e.printStackTrace();
			}
		}
		Thread.sleep(2000);
	}

	public static void launchSamsungMobileNode() throws Throwable {

		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		String ExecGridComm = String.format(
				"cmd /c start cmd.exe /K \"%s && appium -p 3446 --nodeconfig nodeTwo.json --session-override\"",
				GoToDirComm);
		try {
			Runtime.getRuntime().exec(ExecGridComm);
			System.out.println(ExecGridComm);
		} catch (Exception e) {
			System.out.println("U r Doing Something Wrong ");
			e.printStackTrace();
		}
		Thread.sleep(4000);

	}

	public static void launchSamsungNMobileNode() throws Throwable {

		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		String ExecGridComm = String.format(
				"cmd /c start cmd.exe /K \"%s && appium -p 3447 --nodeconfig nodeThree.json --session-override\"",
				GoToDirComm);
		try {
			Runtime.getRuntime().exec(ExecGridComm);
			System.out.println(ExecGridComm);
		} catch (Exception e) {
			System.out.println("U r Doing Something Wrong ");
			e.printStackTrace();
		}
		Thread.sleep(4000);

	}

	public static void launchSamsungChromeNode() throws Throwable {
		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		String ExecGridComm = String.format(
				"cmd /c start cmd.exe /K \"%s && appium -p 3445 --nodeconfig samsung.json --chromedriver-executable chromedriver.exe --session-override\"",
				GoToDirComm);
		try {
			Runtime.getRuntime().exec(ExecGridComm);
			System.out.println(ExecGridComm);
		} catch (Exception e) {
			System.out.println("U r Doing Something Wrong ");
			e.printStackTrace();
		}
		Thread.sleep(4000);
	}

	public static void launchSonyMobileNode() throws Throwable {
		String GridDir = System.getProperty("user.dir") + Constants.ExecutionData.gridDir;
		String GoToDirComm = "cd " + GridDir;
		String ExecGridComm = String.format(
				"cmd /c start cmd.exe /K \"%s && appium -p 3456 --nodeconfig node.json --session-override\"",
				GoToDirComm);
		try {
			Runtime.getRuntime().exec(ExecGridComm);
			System.out.println(ExecGridComm);
		} catch (Exception e) {
			System.out.println("U r Doing Something Wrong ");
			e.printStackTrace();
		}
		Thread.sleep(4000);

	}
	
	

	

}
