package com.syntax.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class MyAssertionDemo extends CommonMethods {

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	// Hard assertion. Assertion error is handled within TestNG
	@Test
	public void titlevalidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		// 1st way
		// Assert.assertEquals(actualTitle, expectedTitle);
		// 2nd way. You are giving a message
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
		// if hard assertion fails it wont be executed
		System.out.println("Text after asserion message");
	}

	@Test(priority = 2)
	public void logoValidation() {
		LoginPageElements login = new LoginPageElements();
		boolean logoDis = login.logo.isDisplayed();
		logoDis = false;
		// Code will be executed after soft assert fails
		SoftAssert sof = new SoftAssert();
		sof.assertTrue(logoDis, "Logo is not Displayed");
		sof.assertAll();
		// HARD ASSERT - code will not be executed
		// Assert.assertEquals(logoDis, true, "Logo is not Displayed");
		// Assert.assertTrue(logoDis, "Logo is not Displayed");
	}

	@Test(priority = 3)
	public void login() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);

		DashBoardPageElements dash = new DashBoardPageElements();
		boolean message = dash.welcome.getText().contains(ConfigsReader.getValueOfProperty("username"));

		// Assert.assertTrue(message, "Admin is NOT displayed");
		// System.out.println("After assertion");
		SoftAssert soft = new SoftAssert();

		soft.assertTrue(message, "Logo is not Displayed");

		// this collect all soft assertions and decide TC passed or not
		soft.assertAll();

		// Execution after assertAll will not be executed
		System.out.println("asdasdasd");

	}
}
