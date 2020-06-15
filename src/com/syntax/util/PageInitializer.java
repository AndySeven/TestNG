package com.syntax.util;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;
import com.syntax.pages.AddEmployeePageElements;
import com.syntax.pages.PersonalDetailsPageElements;
import com.syntax.review02.sauseDemoLoginPage;

/**
 * Method initialize all page classes and store ref in static var
 * that will called/used in that classes
 *
 */
public class PageInitializer extends BaseClass {
	public static LoginPageElements login;
	public static DashBoardPageElements dash;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pDetails;
	public static sauseDemoLoginPage sauceDemoPage;

	public static void initialize() {
		login = new LoginPageElements();
		dash = new DashBoardPageElements();
		addEmp = new AddEmployeePageElements();
		pDetails = new PersonalDetailsPageElements();
		sauceDemoPage = new sauseDemoLoginPage();
	}
}
