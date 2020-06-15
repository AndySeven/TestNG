package com.syntax.class02;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.util.BaseClass;

public class AddEmployeePage extends BaseClass{

	@FindBy(css="input#firstName")
	WebElement firstName;
	@FindBy(id="lastName")
	WebElement lastName;
	@FindBy(id="btnSave")
	WebElement btnSave;
	@FindBy(css="label.hasTopFieldHelp")
	WebElement fullNameField;
	@FindBy(xpath="//input[@id='employeeId']/preceding-sibling::label")
	WebElement employeeIdField;
	@FindBy(xpath="//input[@id='photofile']/preceding-sibling::label")
	WebElement photoField;
	@FindBy(id="photofile")
	WebElement addFile;
	
	public AddEmployeePage(){
		PageFactory.initElements(driver, this);	
	}
}
