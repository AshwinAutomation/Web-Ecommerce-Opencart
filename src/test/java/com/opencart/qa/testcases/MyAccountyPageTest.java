package com.opencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.qa.base.OpenCartTestBase;
import com.opencart.qa.pages.MyAccountPage;
import com.opencart.qa.pages.OpenCartLoginPage;

public class MyAccountyPageTest extends OpenCartTestBase {
	public OpenCartLoginPage loginPage = null;
	public MyAccountPage myAccountpage = null;

	public MyAccountyPageTest() {
		super();
	}

	@BeforeMethod
	public void setUP() throws InterruptedException {
		initialization();
		this.loginPage = new OpenCartLoginPage();
		this.myAccountpage = new MyAccountPage();
		myAccountpage = loginPage.loginToOpenCart(properties.getProperty("email"), properties.getProperty("password"));
	}

	@Test(priority = 1)
	public void validateMyAccountText() {
		String text = myAccountpage.verifyMyAccountText();
		Assert.assertEquals(text, properties.getProperty("text"));
	}

	@AfterMethod
	public void browserShutdown() {
		driver.quit();
	}
}
