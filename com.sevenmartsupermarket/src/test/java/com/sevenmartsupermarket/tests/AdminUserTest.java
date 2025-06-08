package com.sevenmartsupermarket.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {
	
	
	AdminUserPage adminuserpage;
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();	
	@Test(groups={"regression","smoke"})
	public void verifyAbleToCreateNewUser()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();		
		adminuserpage =homepage.clickOnAdminUserMoreInfoButton();	
		adminuserpage.clickOnNewButton();	
		excelreader.setExcelFile("AdminUserTestdata");
		String user=excelreader.getCellData(2, 0);
		String pass =excelreader.getCellData(2, 1);
		Assert.assertTrue(adminuserpage.createAddNewUser(GeneralUtility.getRandomName(),pass,"User Created Successfully"));							
	}
	@Test
	public void getDeletionAlertText()
	{
		loginpage = new LoginPage(driver);
		homepage =loginpage.login();		
		adminuserpage=homepage.clickOnAdminUserMoreInfoButton();	
		Assert.assertTrue(adminuserpage.deleteAlert());
	}
	

}
