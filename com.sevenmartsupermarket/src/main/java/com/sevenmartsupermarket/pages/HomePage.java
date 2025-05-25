package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		WebDriver driver;
		@FindBy(xpath =("//a[@class='d-block']"))
		WebElement profileName;
		@FindBy(xpath=("//p[text()='Admin Users']//following::a[@class='small-box-footer'][1]"))
		WebElement moreInfo;
		
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public String getProfileName()
		{
			return profileName.getText();
		}
		public void verifyAdminUserMoreInfoButton()
		{
			moreInfo.click();
		}
		
}
