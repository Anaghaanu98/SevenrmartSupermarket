package com.sevenmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	WebDriverWait wait;
	public WaitUtility()
	{
		this.driver=driver;
		
	}
	public void elementToBeClickable(WebElement element, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time)); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void visibilityOfElement(By element, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void visibilityOfElement(String xpath, long time)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(time)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

}
