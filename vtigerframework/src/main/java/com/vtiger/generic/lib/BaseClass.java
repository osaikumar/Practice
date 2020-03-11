package com.vtiger.generic.lib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.LoginClass;

public class BaseClass {

	public FileData data = new FileData();
	public static WebDriver driver = null;
	@BeforeSuite
	public void configBS()
	{
		System.out.println("--------DB Connection start---------");
	}
	@BeforeClass
	public void configBC() throws IOException
	{
		String browser = data.fetchDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}else
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	public WebDriverCommonLib wlib = new WebDriverCommonLib();
	@BeforeMethod
	public void configBM() throws IOException
	{
		driver.get(data.fetchDataFromProperty("url"));
		LoginClass login = PageFactory.initElements(driver, LoginClass.class);
		login.getUn().sendKeys(data.fetchDataFromProperty("username"));
		login.getPwd().sendKeys(data.fetchDataFromProperty("password"));
		login.getLoginBtn().click();
	}
	@AfterMethod
	public void configAM()
	{
	WebElement logoutBtn = driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td"));
	Actions act = new Actions(driver);
	act.moveToElement(logoutBtn).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("---------Db Connection end------------");
	}

}
