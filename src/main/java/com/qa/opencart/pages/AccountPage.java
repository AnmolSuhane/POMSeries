package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By search = By.name("search");
	private By searchicon = By.cssSelector("div#search button");
	private By logout = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	} 

	public String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public String getCurrentPageTitle() {

		return driver.getTitle();

	}

	public boolean isSearchExsist() {
		return driver.findElement(search).isDisplayed();
	}

	public void searchIconClick() {
		driver.findElement(searchicon).click();
	}

	public boolean isLogoutLinkExsist() {
		return driver.findElement(logout).isDisplayed();
	}

	public List<String> getHeaders() {
		List<WebElement> searchHeadersList = driver.findElements(headers);
		List<String> searchHeaderValueList = new ArrayList<String>();
		for (WebElement e : searchHeadersList) {
			String Text = e.getText();
			searchHeaderValueList.add(Text);
		}
		return searchHeaderValueList;

	}

	public ResultsPage performSearch(String productName) {
		if (isSearchExsist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchicon);
			driver.findElement(search).clear();
			return new ResultsPage(driver);
		}

		return null;
	}
}
