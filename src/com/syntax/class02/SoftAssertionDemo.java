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

public class SoftAssertionDemo extends CommonMethods {
//	Open Application
//	Verify logo is displayed
//	Enter valid credentials
//	Verify user successfully logged in
//	by verifying welcome message

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void logoAndWelcomeValidation() {
		LoginPageElements login = new LoginPageElements();
		DashBoardPageElements dashboard = new DashBoardPageElements();

		// Logo assertion
		boolean logoDisplayed = login.logo.isDisplayed();

		// I am failing on purpose
		logoDisplayed = false;

		// If I do a (hard) Assert, the code will not continue executing
		//Assert.assertTrue(logoDisplayed, "Logo is not displayed");

		// If I do a (soft) Assert, the code will continue executing
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(logoDisplayed, "Logo is not displayed");
		
		System.out.println("After first assertion");

		// Logging in
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);

		// Welcome msg assertion
		boolean msgDisplayed = dashboard.welcome.isDisplayed();
		//Assert.assertTrue(msgDisplayed, "Welcome msg not displayed");
		soft.assertTrue(msgDisplayed, "Welcome msg not displayed");
		System.out.println("After second assertion");
		// This will collect all soft assertions and then decide if TC passed or failed
		soft.assertAll();

		// Execution stops after assertAll
		// This statement will not be executed
		System.out.println("After assertAll");
	}
	@Test(priority = 2)
	public void test() {
		System.out.println("test");
	}
}