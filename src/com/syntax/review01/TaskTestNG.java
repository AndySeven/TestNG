package com.syntax.review01;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.util.CommonMethods;

/**
 * go to https://www.saucedemo.com   sign in   verify the products text appears
 * quit go to https://www.saucedemo.com sign in on the sorting dropdown select
 * Price (low to high) verify product Sauce Labs Onesi appears first
 * 
 */
public class TaskTestNG extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		setUpBrowser();
		driver.get("https://www.saucedemo.com");
		sendText(By.id("user-name"), "standard_user");
		sendText(By.id("password"), "secret_sauce");
		click(By.cssSelector("input.btn_action"));
	}

	@AfterMethod
	public void closeBrowser() {
		wait(3);
		tearDown();
	}

	@Test
	public void verifyProductText() {
		
		WebElement productsHeader = waitForPresenceOfElLocated(By.className("product_label"));
		boolean isDis = productsHeader.getText().equals("Products");
		//isDis = false;
		Assert.assertTrue("Is NOT displayed", isDis);
	}

	@Test(dependsOnMethods = "verifyProductText")
	public void lowPrice() {

		WebElement dd = driver.findElement(By.className("product_sort_container"));
		selectDDValue(dd, "Price (low to high)");
		WebElement lpProd = waitForPresenceOfElLocated(By.className("inventory_item_name"));
		boolean isDis = lpProd.isDisplayed();
		//isDis = false;
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(isDis, "Lowest Price method is not Displayed");
		soft.assertAll();
	}

}
