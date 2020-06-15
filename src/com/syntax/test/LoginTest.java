package com.syntax.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class LoginTest extends CommonMethods {

	public static void main(String[] args) {

		/**
		 * User should be able to login to the app with valid credentials
		 */

		setUpBrowser();
		
		// sending user name from .properties file
		WebElement userName = driver.findElement(By.id("txtUsername"));
		sendText(userName, ConfigsReader.getValueOfProperty("username"));

		// sending password
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getValueOfProperty("password"));
		
		//click on login
		
		
		// close browser
		tearDown();
	}
}
