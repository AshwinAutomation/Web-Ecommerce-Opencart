package com.opencart.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.qa.base.OpenCartTestBase;

public class OpenCartLoginPage extends OpenCartTestBase {

	@CacheLookup
	@FindBy(name = "email")
	WebElement usernameInput;

	@CacheLookup
	@FindBy(name = "password")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@name='password']//following::a[1]")
	WebElement forgottenPasswordButton;

	public OpenCartLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		String loginPageTitleName = driver.getTitle();
		return loginPageTitleName;
	}

	public MyAccountPage loginToOpenCart(String username, String password) throws InterruptedException {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		Thread.sleep(5000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", loginButton);
		loginButton.click();
		Thread.sleep(5000);
		return new MyAccountPage();
	}

}
