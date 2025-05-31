package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	
	WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath=("//input[@name='username']"))
	WebElement userNameField;
	@FindBy(xpath=("//input[@name='password']"))
	WebElement passwordField;
	@FindBy(xpath=("//button[@class='btn btn-dark btn-block']"))
	WebElement signInButton;
	@FindBy(xpath=("//div[@class='alert alert-danger alert-dismissible']"))
	WebElement alertMessage;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterUserName(String username)
	{
		userNameField.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void clickOnSignInButton()
	{
		WaitUtility waitutility = new WaitUtility();
		waitutility.elementToBeClickable(signInButton, 30);
		signInButton.click();
	}
	
	public HomePage login(String username, String password)
	{
		enterUserName(username); 
		enterPassword(password);
		clickOnSignInButton();
		return new HomePage(driver);
		
	}
	public boolean InvalidLogin(String username, String password,String text)
	{
		enterUserName(username); 
		enterPassword(password);
		clickOnSignInButton();
		return(alertMessage.getText().contains(text));
		
	}
	public HomePage login()
	{
		String username =properties.getProperty("username");
		String password =properties.getProperty("password");
		enterUserName(username); 
		enterPassword(password);
		clickOnSignInButton();
		return new HomePage(driver);
	}
	

}
