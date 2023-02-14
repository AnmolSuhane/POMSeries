package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void Setup() {
		accPage = loginPage.ToDoLogin(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test
	public void accountPageTitleTest() {
		String title = accPage.getCurrentPageTitle();
		Assert.assertEquals(title, AppConstants.Account_Page_Title);
	}

	@Test
	public void accountCurrentURL() {

		String accURL = accPage.getCurrentUrl();
		Assert.assertTrue(accURL.contains(AppConstants.Account_Page_PartialUrl));
	}

	@Test
	public void accountSearchTest() {
		Assert.assertTrue(accPage.isSearchExsist());

	}

	@Test
	public void accountHeaderListTest() {
		List<String> accHeaderList = accPage.getHeaders();
		Assert.assertEquals(accHeaderList, AppConstants.Expected_Account_Headers_List);
	}

	@Test
	public void isLogoutExsistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExsist());

	}

	public void ProductSearchTest() {
		String ProductName = "MacBook";
		resultsPage =accPage.performSearch(ProductName);
	}

	@DataProvider
	public Object[][] getProductName() {
		return new Object[][] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
			
		};
	}
	
	//TDD
	@Test(dataProvider = "getProductName")
	public void productSearchTest(String productName) {
		resultsPage = accPage.performSearch(productName);
		String actTitle = resultsPage.getSearchPageTitle(productName);
		System.out.println("search page title : " + actTitle);
		softAssert.assertEquals(actTitle, AppConstants.SEARCH_PAGE_TITLE+" "+productName);
		Assert.assertTrue(resultsPage.getSearchProductsCount()>0);
		
	}


}
