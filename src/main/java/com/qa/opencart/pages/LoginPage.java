package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. Private By Locators
	private By EmailId = By.name("email");
	private By Password = By.name("password");
	private By forgotPassword = By.linkText("Forgotten Password");
	private By Loginbtn = By.xpath("//input[@value= 'Login']");
	private By Logout = By.linkText("Logout");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Page actions
	public String getLoginPageTitletext() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public boolean isForgotPwdLinkDisplayed() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public AccountPage ToDoLogin(String un, String Pwd) {

		driver.findElement(EmailId).sendKeys(un);
		driver.findElement(Password).sendKeys(Pwd);
		driver.findElement(Loginbtn).click();
		System.out.println("My Cred:" + un + " : " + Pwd);
		return new AccountPage(driver);
	}

}
