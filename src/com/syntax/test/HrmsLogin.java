package com.syntax.test;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import com.syntax.pages.*;

public class HrmsLogin extends CommonMethods {

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		LoginPageElements login = new LoginPageElements();
		
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);

		wait(5);
		tearDown();
	}
}
