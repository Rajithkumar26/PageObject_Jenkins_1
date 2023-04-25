package com.udemy.testcases;

import java.io.FileNotFoundException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.udemy.pages.SigninPage;
import com.udemy.pages.ZohoHomepage;
import com.udemy.pages.ZohoWebsitePage;
import com.udemy.utilities.TestUtil;

public class LoginTest extends BaseTest{

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void loginTest(Hashtable<String, String> data) throws FileNotFoundException, InterruptedException {
		ZohoWebsitePage landingpage= new ZohoWebsitePage();
		SigninPage signin= landingpage.goToLogin();
		ZohoHomepage zohohome= signin.doLogin(data.get("username"), data.get("password"));
Thread.sleep(5000);
	}
}
