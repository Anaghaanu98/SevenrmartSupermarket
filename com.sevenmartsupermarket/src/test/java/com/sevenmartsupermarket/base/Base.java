package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.CaptureScreenshots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	CaptureScreenshots capturescreenshots = new CaptureScreenshots();
	Properties properties = new Properties();

	public Base() {
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initialize **/
	public void initialize(String browser, String url)// to call any web browser we initialize
	{
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
	@Parameters("Browser")
	@BeforeMethod(enabled=false)
	public void launchBrowser(String Browser) {

		String url = properties.getProperty("url");
		
		initialize(Browser, url);

	}
	@BeforeMethod(enabled=true,alwaysRun =true)
	public void launchBrowser() {

		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		initialize(browser, url);
	}

	@AfterMethod(alwaysRun =true) 
	public void terminateSession(ITestResult itestresult)
	{
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			capturescreenshots.takeScreenShot(driver, itestresult.getName());
		}
	}
}
