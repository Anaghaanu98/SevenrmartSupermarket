package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.PageUtility;

public class EditProductPage {
	WebDriver driver;
	PageUtility pageutility;
	@FindBy(id="main_img")
	WebElement mainImage;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	public EditProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void editMainImage()
	{
		pageutility = new PageUtility(driver);
		pageutility.scrollAndClick(mainImage);
		String path ="C:\\Users\\anakh\\OneDrive\\Desktop\\Selenium Java Obsqura\\Selenium\\pepsodent.jpg";
		mainImage.sendKeys(path);
		
	}
	

}
