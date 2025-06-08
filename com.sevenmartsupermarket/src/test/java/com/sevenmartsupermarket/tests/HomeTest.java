package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listeners.RetryAnalyzer;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	
	HomePage homepage;
	LoginPage loginpage;

	@Test(groups="smoke")
	public void verifyAdminMoreInfoButton()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUserMoreInfoButton();
		String actualResult = driver.getTitle();
		String expectedResult = "Admin Users | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verifyNavigationToManageNewsMoreInfo()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.clickOnManageNewsMoreInfo();	
		String actualResult = driver.getTitle();
		String expectedResult= "Manage News | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void verifyRetryFailure()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(false);
	}
}
