package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.OpenCartTestBase;
import com.opencart.qa.pages.MyAccountPage;
import com.opencart.qa.pages.OpenCartLoginPage;

public class OpenCartLoginPageTest extends OpenCartTestBase {

	public OpenCartLoginPage loginPage = null;
	public MyAccountPage myAccountpage = null;

	public OpenCartLoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() {
		initialization();
		this.loginPage = new OpenCartLoginPage();
		this.myAccountpage = new MyAccountPage();
	}

	@Test(priority = 1)
	public void validateTitleOFLoginPage() {
		String titleOfPage = this.loginPage.validateLoginPageTitle();
		Assert.assertEquals(titleOfPage, properties.getProperty("title"));
	}

	@Test(priority = 2)
	public void loginTest() throws InterruptedException {
	myAccountpage =	loginPage.loginToOpenCart(properties.getProperty("email"), properties.getProperty("password"));
	}
	
	@AfterMethod
	public void browserShutdown() {
		driver.quit();
	}

}
