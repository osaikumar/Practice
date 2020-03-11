package vtigerframework;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.generic.lib.BaseClass1;

public class Listner extends BaseClass implements ITestListener {

	public void onFinish(ITestContext result) {
		extentreports.flush();
		
	}

	public void onStart(ITestContext result) {
		reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\extent.html"));
	   reporter.config().setTheme(Theme.DARK);
		extentreports = new ExtentReports();
		extentreports.attachReporter(reporter);
		extentreports.setSystemInfo("OS", "windows");
		extentreports.setSystemInfo("browser","chrome");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		extenttest.log(Status.FAIL, "");
		
	}

	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.SKIP, "");
		
	}

	public void onTestStart(ITestResult result) {
		extenttest = extentreports.createTest(result.getName().toString());
		
	}

	public void onTestSuccess(ITestResult result) {
		extenttest = extentreports.createTest("test1");
		
	}

	
}
