package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.PageUtility;

public class EditProductPage {
	WebDriver driver;
	PageUtility pageutility;
	
	@FindBy(id="main_img")
	WebElement mainImage;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//p[@class='help-block']//img")
	WebElement Image;
	public EditProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void editMainImage()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(mainImage);
		mainImage.sendKeys(Constants.IMAGE_PATH);
		
	}
	public boolean ImageIsDisplayed()
	{
		return(Image.isDisplayed());
		
	}
	

}
