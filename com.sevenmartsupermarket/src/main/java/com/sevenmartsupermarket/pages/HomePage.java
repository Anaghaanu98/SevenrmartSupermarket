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
		@FindBy(xpath ="//div[@class='small-box bg-info']//a[contains(@href,'/admin/list-news')]")
		WebElement moreInfo1;
		@FindBy(xpath="//div[@class='small-box bg-info']//a[contains(@href,'com/admin/list-product')]")
		WebElement moreInfoProduct;
		public HomePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		public String getProfileName()
		{
			return profileName.getText();
		}
		public AdminUserPage clickOnAdminUserMoreInfoButton()
		{
			moreInfo.click();
			return new AdminUserPage(driver);
		}
		public void clickOnManageNewsMoreInfo()
		{
			moreInfo1.click();
		}
		public ManageProductPage clickOnManageProductMoreInfo()
		{
			moreInfoProduct.click();
			return new ManageProductPage(driver);
		}
		
}
