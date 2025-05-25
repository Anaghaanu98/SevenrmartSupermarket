package com.sevenmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	WebDriver driver;
	Actions action;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver)
	{
		this.driver= driver;
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	public void selectByIndex(WebElement element, int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectByVisisbleText(WebElement element, String visibletext)
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
	}
	public void scrollAndClick(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();",element);
	}
	public void mouseAction(WebElement element)
	{
		action.moveToElement(element).build().perform();
		action.click(element).build().perform();
	}
	

}
