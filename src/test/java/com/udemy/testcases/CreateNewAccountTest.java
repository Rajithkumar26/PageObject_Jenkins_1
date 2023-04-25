package com.udemy.testcases;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.udemy.Base.BasePage;
import com.udemy.crmHome.Accounts.AccountsPage;
import com.udemy.crmHome.Accounts.CreateAccountsPage;
import com.udemy.pages.SigninPage;
import com.udemy.pages.ZohoHomepage;
import com.udemy.pages.ZohoWebsitePage;
import com.udemy.utilities.TestUtil;

public class CreateNewAccountTest {

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void createNewAccountTest(Hashtable<String, String> data) throws FileNotFoundException, InterruptedException {
//		ZohoWebsitePage landingpage= new ZohoWebsitePage();
//		SigninPage signin= landingpage.goToLogin();
//		ZohoHomepage zohohome= signin.doLogin(data.get("username"), data.get("password"));
	ZohoHomepage zohohome = new ZohoHomepage();
		zohohome.goToCRM();

			AccountsPage accountspage =BasePage.topmenu.goToAccounts();
			 CreateAccountsPage createaccount=accountspage.gotoCreateAccount();
			createaccount.CreatingAnAccount(data.get("accountName"));
	}
}
