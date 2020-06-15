package com.syntax.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.syntax.util.CommonMethods;

public class FacebookSignUPByFunctions extends CommonMethods {
	
	public static void main(String[] args) {
		setUpBrowser();
		FacebookSignUPByFunctions f = new FacebookSignUPByFunctions
				("Bobby", "Johnson", "bobaringo876apple@gmail.com","123qweqwe123", "Mar", "23","1992");
		f.fillTextBoxes();
		f.fillDDs();
		f.fillRadioSex();
		f.clickSignUpButton();
		f.verificationOfRegistartion();
		tearDown();
	}
	String firstName, lastName, email, password, month, day, year;
	WebElement firstNameW, lastNameW, emailW, emailConfW, passwordW, monthDD, dayDD, yearDD, signUpButton, errorMessage;

	public FacebookSignUPByFunctions(String firstName, String lastName, 
			String email, String password, String month, String day, String year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public void fillTextBoxes() {
		driver.get("http://www.facebook.com");
		firstNameW = CommonMethods.getWebElementByCSS("input[name='firstname']");
		firstNameW.sendKeys(firstName);
		lastNameW = CommonMethods.getWebElementByCSS("input[name='lastname']");
		lastNameW.sendKeys(lastName);
		emailW = CommonMethods.getWebElementByCSS("input[name='reg_email__']");
		emailW.sendKeys(email);
		emailConfW = CommonMethods.getWebElementByCSS("input[name='reg_email_confirmation__']");
		emailConfW.sendKeys(email);
		passwordW = CommonMethods.getWebElementByCSS("input[name='reg_passwd__']");
		passwordW.sendKeys(password);
	}
	
	public void fillDDs() {
		monthDD = CommonMethods.getWebElementByCSS("select#month");
		CommonMethods.selectDDValue(monthDD, month);
		dayDD = CommonMethods.getWebElementByCSS("select#day");
		CommonMethods.selectDDValue(dayDD, day);
		yearDD = CommonMethods.getWebElementByCSS("select#year");
		CommonMethods.selectDDValue(yearDD, year);
	}
	
	public void fillRadioSex() {
		List<WebElement>listB = driver.findElements(By.cssSelector("input[type='radio']"));
		clickRadioOrCheckBox(listB, "2");
	}
	
	public void clickSignUpButton() {
		signUpButton = CommonMethods.getWebElementByCSS("button[name='websubmit']");
		click(signUpButton);
	}
	
	public void verificationOfRegistartion() {
		
		errorMessage = CommonMethods.getWebElementByCSS("div#reg_error_inner");
		getWaitObject();
		waitForVisibility(errorMessage);
		if(errorMessage.getText().contains("There was an error with")) {
			System.out.println("Successfull. We got a error");
		}else {
			System.out.println("Something wrong");
		}
	}
}
