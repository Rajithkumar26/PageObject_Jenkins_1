package com.udemy.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.udemy.Base.BasePage;

public class ZohoWebsitePage extends BasePage{

		
	public ZohoWebsitePage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void goToCustomers() {
		driver.findElement(By.xpath("//a[@href='customers.html' and text()='Customers']")).click();
	//	js.executeScript("arguments[0].click()", registeruser);

	}
	
	
	public void goToContactSales() {
		driver.findElement(By.xpath("//a[@href='customers.html' and text()='Customers']//following-sibling::a[text()='Contact Sales']")).click();

	}
	
	public void goToSupport() {
		driver.findElement(By.xpath("//a[@href='customers.html' and text()='Customers']//following-sibling::a[text()='Support']")).click();

	}
	
	public SigninPage goToLogin() throws FileNotFoundException {
		click("loginlink_xpath");
		log.debug("Clicked on SignIn");
return  new SigninPage();
	}
	
	
}
