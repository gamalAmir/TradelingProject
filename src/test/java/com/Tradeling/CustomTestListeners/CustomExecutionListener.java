package com.Tradeling.CustomTestListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;
import org.testng.IExecutionListener;

import com.Tradeling.Core.ExecutionLauncher;
import com.Tradeling.utils.Constants;
import com.Tradeling.utils.ExtentManager;

public class CustomExecutionListener extends ExecutionLauncher implements IExecutionListener {

	public void onExecutionStart() {
		ExtentManager.getReportFileLocation(Platform.WINDOWS);
		
		try {
			ExecutionLauncher.launchGrid();
			ExecutionLauncher.launchWebNode(Constants.ExecutionData.ChromeBrowser);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		File source = new File(System.getProperty("user.dir") + File.separator + "src/test/resources/Logs"
				+ File.separator + "applog.txt");
		File dest = new File(ExtentManager.windowsPath);
		try {
		    FileUtils.copyFileToDirectory(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}

	}

}
  