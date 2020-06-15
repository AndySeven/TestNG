package com.syntax.test;

import com.syntax.util.CommonMethods;
import com.syntax.pages.*;

public class HrmsLogo extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		LoginPageElements logo = new LoginPageElements();
		
		logoIsDisplayed(logo.logo);
		
		wait(3);
		tearDown();
		
	}

}
