package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.EditProductPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageProductPage;

public class EditProductTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminUserPage adminuserpage;
	ManageProductPage manageproductpage;
	EditProductPage editproductpage;
	@Test
	public void verifyEditMainImage()
	{
		loginpage = new LoginPage(driver);
		homepage = loginpage.login();
		manageproductpage = homepage.clickOnManageProductMoreInfo();
		editproductpage = manageproductpage.clickOnPepsodentProductEditButton();
		editproductpage.editMainImage();
		Assert.assertTrue(true);
	}

}
