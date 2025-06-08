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
	public void verifyNavigationToNewButton()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		manageproductpage= homepage.clickOnManageProductMoreInfo();		
		manageproductpage.clickOnNewButton();
		String actualResult =manageproductpage.headerText();
		System.out.println(actualResult);
		String expectedResult = "Add Product";
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test
	public void verifyNavigationToPepsodentProductEditButton()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login();
		manageproductpage= homepage.clickOnManageProductMoreInfo();
		manageproductpage.clickOnPepsodentProductEditButton();
		String actualResult = manageproductpage.headerText();
		String expectedResult = "Edit Product";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
