package com.syntax.review02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.util.CommonMethods;

public class sauceDemoTest extends CommonMethods {
	
	@DataProvider(name = "dataProvider")
	public Object[][] setUpData(){
		Object[][] data = new Object[4][2];
		data[0][0] = "standard_user";
		data[0][1] = "secret_sauce";
		
		data[1][0] = "problem_user";
		data[1][1] = "secret_sauce";
		
		data[2][0] = "locked_out_user";
		data[2][1] = "secret_sauce";
		
		data[3][0] = "performance_glitch_user";
		data[3][1] = "secret_sauce";
		
		return data;
	}
	
	
	@Test(dataProvider = "dataProvider", groups = {"smoke"})
	public void loginToSauceDemo(String username, String password) {
		//driver.get("https://www.saucedemo.com/");
		sendText(sauceDemoPage.userNameTextBox, username);
		sendText(sauceDemoPage.passwordTextBox, password);
		click(sauceDemoPage.loginButton);
		if(username.equals("locked_out_user")) {
			String s = waitForVisibilityLocator(By.cssSelector("div.login-box h3")).getText();
			System.out.println(" HELLO -->  "+s);
			Assert.assertTrue(s.contains("Epic sadface"));
		}else {
			String d = waitForPresenceOfElLocated(By.cssSelector("div.product_label")).getText();
			Assert.assertEquals(d, "Products", "Products Header is NOT displayed");
		}
		
	}
	
}
