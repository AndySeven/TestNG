package com.syntax.review02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.syntax.util.CommonMethods;

public class SourceParameterDemo extends CommonMethods {

	@Parameters({ "username", "password" })
	@Test
	public void loginToSauceDemo(String username, String password) {
		// driver.get("https://www.saucedemo.com/");
		sendText(sauceDemoPage.userNameTextBox, username);
		sendText(sauceDemoPage.passwordTextBox, password);
		click(sauceDemoPage.loginButton);
		if (username.equals("locked_out_user")) {
			String s = waitForVisibilityLocator(By.cssSelector("div.login-box h3")).getText();
			System.out.println(" HELLO -->  " + s);
			Assert.assertTrue(s.contains("Epic sadface"));
		} else {
			String d = waitForPresenceOfElLocated(By.cssSelector("div.product_label")).getText();
			Assert.assertEquals(d, "Products", "Products Header is NOT displayed");
		}

	}

}
