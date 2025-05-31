package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	WebDriver driver;
	PageFactory pagefactory = new PageFactory();
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id="news")
	WebElement newsSpace;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public ManageNewsPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageNewsPage createNews(String news)
	{
		newsSpace.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean isAlertMessagePresent()
	{
		boolean message =alert.getText().contains("News Created Successfully");
		return message;
	}
	
}
