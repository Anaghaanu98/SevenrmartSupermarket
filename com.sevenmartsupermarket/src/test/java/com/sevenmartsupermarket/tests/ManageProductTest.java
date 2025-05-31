package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageProductPage;

public class ManageProductTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	ManageProductPage manageproductpage;
	@Test
	public void verifyClickNewButton()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		manageproductpage= homepage.clickOnManageProductMoreInfo();		
		manageproductpage.clickOnNewButton();
		String actualResult = driver.getTitle();
		System.out.println(actualResult);
		String expectedResult = "Add Product | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verifyPepsodentProductEditButton()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		manageproductpage= homepage.clickOnManageProductMoreInfo();
		manageproductpage.clickOnPepsodentProductEditButton();
		String actualResult = driver.getTitle();
		String expectedResult = "Edit Product | 7rmart supermarket";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
