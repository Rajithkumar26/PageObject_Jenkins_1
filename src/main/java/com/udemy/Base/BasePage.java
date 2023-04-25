package com.udemy.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.udemy.utilities.ExcelReader;
import com.udemy.utilities.ExtentManager;
import com.udemy.utilities.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
public static  TopMenuClass topmenu;
public static  Properties config= new Properties();;
public static Properties OR= new Properties();;
public  static FileInputStream fis;
//@SuppressWarnings("deprecation")
public  static Logger log = Logger.getLogger("devpinoyLogger");
public  static ExcelReader excel=  new ExcelReader("C:\\Users\\Vaibhav\\eclipse-workspace\\PageOobjectModel_Udemy2\\src\\test\\resources\\Excel\\testdata.xlsx");
public static WebDriverWait wait=null;
public static ExtentReports extentreport= ExtentManager.getInstance();
public static ExtentTest test= ( extentreport).startTest("Login test");

public String browser;
ChromeOptions ops= new ChromeOptions();

	public BasePage() throws FileNotFoundException {
	if(driver==null) {
			
		
		try {
			fis= new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\PageOobjectModel_Udemy2\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config File loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fis= new FileInputStream("C:\\Users\\Vaibhav\\eclipse-workspace\\PageOobjectModel_Udemy2\\src\\test\\resources\\properties\\OR.properties");
		try {
			OR.load(fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty())
		{
			browser =System.getenv("browser");
		}
		else {
			browser=config.getProperty("browser");
		}
	//	config.setProperty("browser", browser);
		if(config.getProperty("browser").equals(browser)) {
		
//			Map<String , Object> prefs= new HashMap<String , Object>();
//			prefs.put("credentials_enable_service", false);
//			prefs.put("profile.password_manager_enabled", false);
//			
//			ops.setExperimentalOption("prefs", prefs);
			ops.setExperimentalOption("exclude Switches", Collections.singleton("enable-automation"));
			ops.addArguments("--disable extensions");
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.debug("Chrome Browser  Launched");
		}
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to Expected URL: "+ config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		topmenu= new TopMenuClass(driver);
	}
	}
	
	
	public static void quit() {
		driver.quit();
		try {
			extentreport.endTest(test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentreport.flush();
	}
	
	public static void click(String locator) {
		if(locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_name")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}
		log.debug("performed clicking action");
	test.log(LogStatus.INFO, "CLicking on"+ locator);
	}
	
	public void type(String locator, String input) {
		if(locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(input);
		}else if(locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(input);
		}else if(locator.endsWith("_name")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(input);
		}
		log.debug("performed clicking action");

		(test).log(LogStatus.INFO, "Typing in "+locator+ "entered value is "+input);
	}
	
	
	public static void VerifyEquals(String Expected, String Actual) {
		try {
			Assert.assertEquals(Actual, Expected);
		}catch(Throwable e) {
			try {
				TestUtil.CaptureScreenshot();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
