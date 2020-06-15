package com.syntax.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class Test2FunctionsFacebook extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// send text data to the text boxes of FaceBook sign Up page
		sendText(getWebElement("input[name='firstname']"),"Gregory");
		sendText(getWebElement("input[name='lastname']"), "Smith");
		sendText(getWebElement("input[name='reg_email__']"),"roberto42dd@gmail.com");
		sendText(getWebElement("input[name='reg_email_confirmation__']"),"roberto42dd@gmail.com");
		sendText(getWebElement("input[name='reg_passwd__']"),"123123reeas");
		// choosing date in DDs on FaceBook signUp page
		selectDDValue(getWebElement("select[name='birthday_month']"), "Feb");
		selectDDValue(getWebElement("select[name='birthday_day']"), 3);
		//selectDDValue(getWebElement("select[name='birthday_month']"), "Feb");
		
		// Checking sex at RadioButtons block on FaceBook signUp page
		List<WebElement>listR = driver.findElements(By.cssSelector("input[type='radio']"));
		clickRadioOrCheckBox(listR,"2");
		
		tearDown();
}
public static WebElement getWebElement(String locator) {
		return driver.findElement(By.cssSelector(locator));
	}

}
