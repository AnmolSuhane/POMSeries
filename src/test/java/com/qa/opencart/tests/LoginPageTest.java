package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.AppErrors;

public class LoginPageTest extends BaseTest {

	@Test
	public void LoginPagegetTitleTest() {
		String actualtitle = loginPage.getLoginPageTitletext();
		System.out.println("Actual title:" + " " + actualtitle);
		Assert.assertEquals(actualtitle, AppConstants.Login_Page_Title, AppErrors.Login_Page_Title);

	}

	@Test

	public void LoginPagegetUrltest() {
		String PageUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(PageUrl.contains(AppConstants.Login_Page_PartialUrl), AppErrors.Login_Page_PartialUrl);
	}

	@Test

	public void forgetPassword() {
		Assert.assertTrue(loginPage.isForgotPwdLinkDisplayed());

	}

	@Test(priority = 4)

	public void LoginPagelogintest() {
		accPage = loginPage.ToDoLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExsist());
	}
}
