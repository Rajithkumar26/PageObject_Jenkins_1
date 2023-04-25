package com.udemy.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.udemy.Base.BasePage;

public class ExtentManager {

	private static ExtentReports extentreport;

	public static ExtentReports getInstance() {
		
		if(extentreport==null) {
			extentreport= new ExtentReports("C:\\Users\\Vaibhav\\eclipse-workspace\\PageOobjectModel_Udemy2\\target\\surefire-reports\\html\\extentreports.html", true, DisplayOrder.OLDEST_FIRST);
			(extentreport) .loadConfig(new File("C:\\Users\\Vaibhav\\eclipse-workspace\\PageOobjectModel_Udemy2\\src\\test\\resources\\ExtentConfig\\ReportsConfig.xml"));
		}
		return extentreport;
		
	}
	
}
