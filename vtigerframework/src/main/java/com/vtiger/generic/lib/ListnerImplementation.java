package com.vtiger.generic.lib;

import java.awt.ItemSelectable;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation extends BaseClass implements ITestListener {
	public void onFinish(ITestContext arg0) {	
	}
	public void onStart(ITestContext arg0) {	
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {	
	}
	public void onTestFailure(ITestResult name) {
		String testName = name.getName();
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File actFile = efw.getScreenshotAs(OutputType.FILE);
		File srcFile = new File("./screenshot/"+testName+".png");
		try {
			FileUtils.copyFile(actFile, srcFile);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult arg0) {	
	}
	public void onTestStart(ITestResult arg0) {	
	}
	public void onTestSuccess(ITestResult arg0) {			
	}
}