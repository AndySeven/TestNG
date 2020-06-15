package com.syntax.test;

import com.syntax.pages.FaceBookLoginPage;
import com.syntax.util.BaseClass;
import com.syntax.util.CommonMethods;

public class FaceBookLoginTest extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://www.facebook.com");
		
		FaceBookLoginPage fb = new FaceBookLoginPage();
		
		fb.fillTextBoxes("Armen", "Porter", "porter4435hologogo@mail.com", "asasH543jj");
		fb.fillBirthDD("Feb", "12", "1992");
		fb.pickSex("2");
		fb.logoChecking();
		fb.submitButton();
		
		wait(2);
		tearDown();
	}

}
