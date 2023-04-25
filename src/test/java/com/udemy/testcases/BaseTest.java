package com.udemy.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.udemy.Base.BasePage;

public class BaseTest {

	@AfterSuite
	public void teardown() {
	
		BasePage.quit();
	}
}
