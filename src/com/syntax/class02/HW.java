package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import com.syntax.util.Constants;

public class HW extends CommonMethods {
	//@Test(priority = 1, dependsOnMethods = "invalidLogin") // 1st execution, if invalidLogin() is not executing - CError
	@Test
	//@Test(priority = 1, enabled = true)
	public void validLogin() {
		// WebElement username = driver.findElement(By.id("txtUsername"));
		// 1st way
		// username.sendKeys("Admin");
		// 2nd way
		// sendText(username, ConfigsReader.getValueOfProperty("username"));
		// 3rd way using POM Page Factory
		LoginPageElements login = new LoginPageElements();
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		// 1st way
		// WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		// wait.until(ExpectedConditions.elementToBeClickable(login.loginBtn));
		// login.loginBtn.click();
		// 2nd way
		// waitForClickability(login.loginBtn);
		// login.loginBtn.click();

		// 3rd way
		click(login.loginBtn);

		DashBoardPageElements dashboard = new DashBoardPageElements();

		boolean displayed = dashboard.logo.isDisplayed();
		if (displayed) {
			System.out.println("good logo is here");
		} else {
			System.out.println("NO Good ligo is absent");
		}
		wait(1);

	}
	
	//@Test(dependsOnMethods = {"validLogin", "method2" , "method3"})
	//@Test(dependsOnMethods = {"validLogin"})
	//@Test(dependsOnMethods = "validLogin")
	@Test(priority = 2, enabled = true)
	public void invalidLogin() throws Exception {
		LoginPageElements login = new LoginPageElements();
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		click(login.loginBtn);

		if (login.errorMsg.isDisplayed()) {
			System.out.println("Fantastic error is displayed: --> " + login.errorMsg.getText());
		} else {
			System.out.println("Does NOt displayed error message");
		}
		wait(2);
		
		//When an exception is thrown the test id fails
		throw new Exception();
	}

	@BeforeMethod
	public void openBrowserAndNavigate() {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}
