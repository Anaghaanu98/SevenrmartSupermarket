package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class ManageProductPage {
	
	WebDriver driver;
	PageUtility pageutility;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//a[contains(@href,'Product/edit?edit=436&page_ad=1&un=&ct=&sb=&Search=sr')]")
	WebElement productEditButton;
	
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnNewButton()
	{
		newButton.click();
	}
	public EditProductPage clickOnPepsodentProductEditButton()
	{
		pageutility= new PageUtility(driver);
		pageutility.scrollAndClick(productEditButton);
		return new EditProductPage(driver);
	}

}
