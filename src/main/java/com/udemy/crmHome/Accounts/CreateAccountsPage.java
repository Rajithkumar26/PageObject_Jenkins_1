package com.udemy.crmHome.Accounts;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;

import com.udemy.Base.BasePage;

public class CreateAccountsPage extends BasePage {

	public CreateAccountsPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void CreatingAnAccount(String ActName) {
	//	driver.findElement(By.id("Crm_Accounts_ACCOUNTNAME_LInput")).sendKeys(ActName);
		type("accountname_id", ActName);
	log.debug("ClicKED ON aCCOUNT NAME FIELD and entered data");
	}
	
	
}
