package com.Tradeling.CustomTestListeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.Tradeling.Base.BaseDriver;
import com.Tradeling.utils.Constants;

public class CustomTestListener extends BaseDriver implements ITestListener {

	public ExtentTest extentTest = null;
	public ExtentTest supTest = null;

	public void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		supTest = Parentest.get().createNode(result.getMethod().getMethodName(), result.getMethod().getDescription());
		test.set(supTest);
		if (getTestType().equals(Constants.MobileTest)) {
			test.get().log(Status.INFO, result.getMethod().getMethodName() + "started at" + getcurrentdateandtime());
		} else if (getTestType().equals(Constants.WebTest)) {
			test.get().log(Status.INFO, result.getMethod().getMethodName() + "started at" + getcurrentdateandtime());
		}

	}

	public void onStart(ITestContext context) {
		configureLogging();
		extentTest = extent.createTest("Test Suite : " + context.getName());
		Parentest.set(extentTest);
		log.info(System.getProperty("line.separator"));
		log.info("Test Suite : " + context.getName() + " started at " + context.getStartDate());
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup testMarkup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		try {
			if (getTestType().equals(Constants.MobileTest)) {
				test.get().pass(testMarkup).addScreenCaptureFromPath(takeScreenShot());
			} else if (getTestType().equals(Constants.WebTest)) {
				test.get().pass(testMarkup).addScreenCaptureFromPath(takeWebScreenShot());
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		System.out.println((result.getMethod().getMethodName() + " failed!"));
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>" + " \n");
		// test.get().log(Status.FAIL, m);
		try {
			if (getTestType().equals(Constants.MobileTest)) {
				test.get().fail(m).addScreenCaptureFromPath(takeScreenShot());
				log.info("Exception thrown at Test Case " + result.getMethod().getMethodName() + " " + excepionMessage);
				log.info(System.getProperty("line.separator"));
			} else if (getTestType().equals(Constants.WebTest)) {
				test.get().fail(m).addScreenCaptureFromPath(takeWebScreenShot());
				log.info("Exception thrown at Test Case " + result.getMethod().getMethodName() + " " + excepionMessage);
				log.info(System.getProperty("line.separator"));
			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.get().skip(m);
		test.get().skip(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		System.out.println(("Test Complete"));
		if (extent != null) {
			extent.flush();
			log.info("Test Suite : " + context.getName() + " finished at " + context.getEndDate());
			log.info(System.getProperty("line.separator"));
		}
	}

}
