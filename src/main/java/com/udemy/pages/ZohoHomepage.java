package com.udemy.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.udemy.Base.BasePage;
import com.udemy.CRM.CRMHomePage;

public class ZohoHomepage extends BasePage{


	
	public ZohoHomepage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CRMHomePage goToCRM() throws FileNotFoundException {
		click("crmLogo_xpath");
		log.debug("Clicked on CRM Icon");
	//	test.log(null, browser);
		return new CRMHomePage();
	}
	
	public void goToBooks() {
		click("BooksLogo_xpath");
		log.debug("CLicked on Books");
	}
}
