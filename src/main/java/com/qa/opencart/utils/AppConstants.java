package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class AppConstants {

	public static final String Login_Page_Title = "Account Login";
	public static final String Login_Page_PartialUrl = "route=account/login";
	public static final String Account_Page_Title = "My Account";
	public static final String Account_Page_PartialUrl = "?route=account/account";
	public static final List<String> Expected_Account_Headers_List = Arrays.asList("My Account", "My Orders",
			"My Affiliate Account", "Newsletter");
	public static final String SEARCH_PAGE_TITLE = "Search -";
}
