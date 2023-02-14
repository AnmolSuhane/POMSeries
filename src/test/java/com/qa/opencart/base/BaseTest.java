package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.Driverfactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	Driverfactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected ResultsPage resultsPage;

	protected Properties prop;

	protected SoftAssert softAssert;
	protected ProductInfoPage prodInfoPage;

	@BeforeTest
	public void setup() {
		df = new Driverfactory();
		prop = df.intprop();
		driver = df.intdriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
