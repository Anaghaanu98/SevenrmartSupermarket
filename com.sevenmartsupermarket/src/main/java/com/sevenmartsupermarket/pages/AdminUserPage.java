package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminUserPage {

	WebDriver driver;
	Properties properties = new Properties();
	
	PageUtility pageutility;
	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newButton;
	@FindBy(id = ("username"))
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "user_type")
	WebElement usertype;
	@FindBy(xpath=("//button[@name='Create']"))
	WebElement save;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void createAddNewUser(String username1 , String password1) 
	{
	
		username.sendKeys(username1);
		password.sendKeys(password1);
		pageutility = new PageUtility(driver);
		pageutility.selectByVisisbleText(usertype, "Staff");
		save.click();
		

	}

}
