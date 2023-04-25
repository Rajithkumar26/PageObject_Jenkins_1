package com.udemy.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.udemy.Base.BasePage;

public class SigninPage extends BasePage  {
	
	public SigninPage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ZohoHomepage doLogin(String uname, String pwd) throws FileNotFoundException, InterruptedException {
		//-----
		log.debug("Landed on SignIn page");
type("email_id", uname);
click("signbtn_id");
type("password_id", pwd);
Thread.sleep(2000);;
click("signbtn_id");
	click("skip_xpath");
	log.debug("Clicked on signIN button");
	return new  ZohoHomepage();
			}
	
	
}
