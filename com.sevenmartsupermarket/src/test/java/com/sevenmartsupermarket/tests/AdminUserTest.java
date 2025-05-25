package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;
import com.sevenmartsupermarket.utilities.ExcelReader;

public class AdminUserTest extends Base {
	
	
	AdminUserPage adminuserpage ;
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	CaptureScreenshots capturescreenshots = new CaptureScreenshots();
	@Test(groups={"regression","smoke"})
	public void verifyAdminUserPageNewButton()
	{
		loginpage = new LoginPage(driver);
		loginpage.login();
		homepage = new HomePage(driver);
		homepage.verifyAdminUserMoreInfoButton();
		adminuserpage = new AdminUserPage(driver);
		adminuserpage.clickOnNewButton();
		excelreader.setExcelFile("AdminUserTestdata");
		String user=excelreader.getCellData(2, 0);
		String pass =excelreader.getCellData(2, 1);
		adminuserpage.createAddNewUser(user,pass);
		capturescreenshots.takeScreenShot(driver, "AdminUser");
	}
	

}
