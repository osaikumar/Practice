package vtigerframework;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {

	@Test
	public void test1()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\extent.html"));
		ExtentReports extentreports = new ExtentReports();
		extentreports.attachReporter(reporter);
		ExtentTest extenttest = extentreports.createTest("test1");
		extenttest.log(Status.PASS, "test1 is pass");
		extentreports.flush();
	}
}
