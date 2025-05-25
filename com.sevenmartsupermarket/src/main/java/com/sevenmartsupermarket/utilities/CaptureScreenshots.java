package com.sevenmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenmartsupermarket.constants.Constants;

public class CaptureScreenshots {

	TakesScreenshot takesscreenshot;

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {
			takesscreenshot = (TakesScreenshot) driver;
			File screenShot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constants.SCREENSHOTS_FILE_PATH + imageName + "_" + timeStamp + ".png";
			File destination = new File(path);
			FileHandler.copy(screenShot, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
