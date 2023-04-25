package com.udemy.crmHome.Accounts;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;

import com.udemy.Base.BasePage;

public class AccountsPage extends BasePage {

public AccountsPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

public CreateAccountsPage gotoCreateAccount() throws FileNotFoundException  {
	click("createaccountbtn_xpath");
	log.debug("Clicked on create account button");
	return new CreateAccountsPage();
	}
	
}
