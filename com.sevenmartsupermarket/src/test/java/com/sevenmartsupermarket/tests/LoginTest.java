package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataprovider.DataProviders;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;



public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage ;
	ExcelReader excelreader = new ExcelReader();
	@Test(groups="smoke")
	public void verifyValidLogin()
	{
		loginpage= new LoginPage(driver);
		homepage= loginpage.login();		
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);

}
	@Test(dataProvider="Login Credentials",dataProviderClass=DataProviders.class)
	public void VerifyInvalidLogin(String username, String password)
	{
		loginpage= new LoginPage(driver);
		//loginpage.InvalidLogin(username,password,"The password field is required.");
		Assert.assertTrue(loginpage.InvalidLogin(username, password, "Invalid Username/Password"));
	}
	
	
	
}