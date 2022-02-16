package com.Tradeling.Core;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportFolder {
	
	public String folderName;
	public static String supdir = System.getProperty("user.dir");
	public static String finalDir;
	public String fileName;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static Date date = new Date();
	public static String CurrentTime = dateFormat.format(date).toString();

	public static String SetFolderName() {
		return ReportFolder.CurrentTime;
	}

	public static String SetDirectory() {
		return ReportFolder.finalDir = supdir + "\\test-output\\" + SetFolderName();
	}

	public static void CreateDir() {
		System.out.println(SetDirectory());
		new File(SetDirectory()).mkdir();
		File dir = new File(SetDirectory());
		if (!dir.exists()) {
			System.out.println("directory was created successfully" + dir.getName());
			try {
				dir.mkdir();
			} catch (SecurityException se) {
				// handle it
			}
		} else {
			// creating the directory failed
			System.out.println("failed trying to create the directory");
		}
	}

}
