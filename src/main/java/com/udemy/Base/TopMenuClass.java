package com.udemy.Base;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mysql.cj.api.log.Log;
import com.udemy.crmHome.Accounts.AccountsPage;

public class TopMenuClass {

	WebDriver driver;
	public TopMenuClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToHome() {
		
	}
public void goToleads() {
	
}

public void goToContacts() {
	
}

public AccountsPage goToAccounts() throws FileNotFoundException {
	BasePage.click("accountstab_xpath");
	BasePage.log.debug("Clicked on Accounts from Topmenu");
return new AccountsPage();
}

public void goToDeals() {
	
}

public void goTosignout() {
	
}
}

