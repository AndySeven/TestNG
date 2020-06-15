package com.syntax.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * Method set up the driver's properties for browser and run the corresponding
	 * browser
	 * 
	 * @author robespierre
	 */
	@BeforeMethod (alwaysRun = true)// to make this method run before every @test method
	public static WebDriver setUpBrowser() {
		ConfigsReader.readConfigs(Constants.PROPERTIES_FILE_PATH);
		switch (ConfigsReader.getValueOfProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", Constants.FIREFOX_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		default:
			throw new RuntimeException("browser is not supported");
		}
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME,
		// TimeUnit.SECONDS);
		driver.get(ConfigsReader.getValueOfProperty("url"));
		PageInitializer.initialize(); // initialize all page objects of setUpBrowser
		return driver;

	}

	/**
	 * Method close the browser session
	 * 
	 * @author robespierre
	 */
	@AfterMethod (alwaysRun = true) // to make this method run after @Test method
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
