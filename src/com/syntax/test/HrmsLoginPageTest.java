package com.syntax.test;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class HrmsLoginPageTest extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		LoginPageElements login = new LoginPageElements();
		
		login.userName.sendKeys(ConfigsReader.getValueOfProperty("username"));
		login.password.sendKeys(ConfigsReader.getValueOfProperty("password"));
		
		//sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		//sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		
		click(login.loginBtn);
		
		//DashBoardPageElements welcome = new DashBoardPageElements();
		
		wait(3);
		tearDown();

	}
}
