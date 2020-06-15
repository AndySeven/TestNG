package com.syntax.test;
// US 89647: User should be able to login using valid credentials
import org.openqa.selenium.WebElement;
import com.syntax.util.CommonMethodsTest;
import com.syntax.util.ConfigsReader;

public class SignUpValidCredentials extends CommonMethodsTest {
	public static String userName, password;
	public static WebElement userNameW, passwordW, loginButton, loginCheck;

	public static void main(String[] args) {
		setUpBrowser();
		userName = ConfigsReader.getValueOfProperty("username");
		password = ConfigsReader.getValueOfProperty("password");

		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		fillTextBoxes();
		submitLogin();
		liginVerification();

		tearDown();

	}
	public static void fillTextBoxes() {
		userNameW = CommonMethodsTest.getWEByID("txtUsername");
		fillTextBox(userNameW, userName);
		passwordW = CommonMethodsTest.getWEByID("txtPassword");
		fillTextBox(passwordW, password);
	}
	public static void submitLogin() {
		loginButton = getWEByID("btnLogin");
		clickButton(loginButton);
	}
	public static void liginVerification() {
		loginCheck = getWEByID("welcome");
		checkTextinElement(loginCheck, userName);
	}
}
