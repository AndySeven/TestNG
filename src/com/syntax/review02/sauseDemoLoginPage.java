package com.syntax.review02;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.util.CommonMethods;

public class sauseDemoLoginPage extends CommonMethods{
	
	@FindBy(id = "user-name")
	public WebElement userNameTextBox;
	
	@FindBy(id = "password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@class = 'btn_action']")
	public WebElement loginButton;
	
	public sauseDemoLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
