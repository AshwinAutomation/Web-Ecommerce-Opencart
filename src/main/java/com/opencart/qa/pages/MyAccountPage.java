package com.opencart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class MyAccountPage extends OpenCartTestBase {

	@FindBy(xpath = "//div[@id='content']/h2[1]")
	WebElement myAccountText;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyMyAccountText() {
		return myAccountText.getText();
	}

	
}
