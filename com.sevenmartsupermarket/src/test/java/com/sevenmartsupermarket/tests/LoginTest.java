package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage ;
	ExcelReader excelreader = new ExcelReader();
	@Test(groups="smoke")
	public void verifyValidLogin()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);

}
	@Test(groups ="smoke")
	public void dummyTestCase()
	{
		excelreader.setExcelFile("AdminUserTestdata");
		String data =excelreader.getCellData(1, 1);
		System.out.println(data);
		Assert.assertTrue(false);
	}
	
}