package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.DataProviders;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageNewsPage;

public class ManageNewsTest extends Base {

	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage managenewspage;

	@Test(dataProvider = "Manage News", dataProviderClass = DataProviders.class)
	public void verifyAddNews(String data) {
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		homepage.clickOnManageNewsMoreInfo();
		managenewspage = new ManageNewsPage(driver);
		managenewspage.clickOnNewButton().createNews(data).clickOnSaveButton();
		Assert.assertTrue(managenewspage.isAlertMessagePresent());

	}
}
