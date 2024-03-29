package com.opencart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.opencart.qa.commonutils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartTestBase {

	public static WebDriver driver = null;
	public static Properties properties = null;
	FileInputStream file = null;
	static DesiredCapabilities capabilities = null;
	static ChromeOptions chromeOptions = null;

	public OpenCartTestBase() {
		super();
		try {
			this.file = new FileInputStream(System.getProperty("user.dir") + "./config/config.properties");
			System.out.println(file);
			properties = new Properties();
			properties.load(file);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void initialization() {
		capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notification");
		chromeOptions.merge(capabilities);
		String browserName = properties.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver(chromeOptions);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMLICITILY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}

}
