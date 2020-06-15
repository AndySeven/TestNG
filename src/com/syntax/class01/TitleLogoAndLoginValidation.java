package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import com.syntax.util.PageInitializer;

public class TitleLogoAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		wait(1);
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void titleValidation() {
		String actualTitle = "Human Management System";
		if (driver.getTitle().equals(actualTitle)) {
			System.out.println("Title is " + driver.getTitle());
		} else {
			System.out.println("Test Faild");
		}
	}

	@Test
	public void logoValidation() throws Exception {
		WebElement logo = waitForPresenceOfElLocated(By.xpath("//div[@id='divLogo']/img"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is Displayed");
			// throw new Exception("YAHOOO");
		} else {
			System.out.println("Logo is NOT Displayed");
		}
	}

	@Test
	public void validLogin() {
		sendTextVis(By.id("txtUsername"), ConfigsReader.getValueOfProperty("username"));
		sendTextVis(By.id("txtPassword"), ConfigsReader.getValueOfProperty("password"));
		click(By.id("btnLogin"));
		if (waitForPresenceOfElLocated(By.id("welcome")).getText()
				.contains(ConfigsReader.getValueOfProperty("username"))) {
			System.out.println("Test case Passed, User could log in");
		} else {
			System.out.println("Test case Faild, User could NOT log in");
		}
	}
}
