package com.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class LoginTest extends CommonMethods {

//	@BeforeMethod
//	public void openBrower() {
//		setUpBrowser();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrower() {
//		// wait(3);
//		tearDown();
//	}

	
	@Test(groups = {"Smoke Test"})
	public void validAdminLogin() {
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);
		String expectedUser = "Welcome Admin";
		String actualUser = dash.welcome.getText();
		Assert.assertEquals("Admin is NOT logged in", expectedUser, actualUser);
		Assert.assertTrue(actualUser.contains(ConfigsReader.getValueOfProperty("username")));
	}

	@Test(priority = 1)
	public void invalidPassLogin() {
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, "adfasfasdfsadf");
		click(login.loginBtn);
		String expectedErrMsg = "Invalid credentials";
		String actualErrMsg = login.errorMsg.getText();
		Assert.assertEquals("Admin is NOT logged in", expectedErrMsg, actualErrMsg);
	}

	@Test(priority = 2)
	public void emptyPassword() {
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		click(login.loginBtn);
		String expectedErrMSG = "Password cannot be empty";
		String actualErrMsg = login.errorMsg.getText();
		Assert.assertEquals("Empty Password Error Message is NOT Matched", expectedErrMSG, actualErrMsg);
	}

	@Test(priority = 3)
	public void emptyUserName() {
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);
		String expectedErrMSG = "Username cannot be empty";
		String actualErrMsg = login.errorMsg.getText();
		Assert.assertEquals("Empty Login Error Message is NOT Matched", expectedErrMSG, actualErrMsg);
	}
	@Test(priority = 4)
	public void emptyame() {
	}
	
	

}
