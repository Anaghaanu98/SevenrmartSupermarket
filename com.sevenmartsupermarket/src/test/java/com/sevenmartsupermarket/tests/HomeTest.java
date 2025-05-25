package com.sevenmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
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
		homepage.verifyAdminUserMoreInfoButton();
	}

}
