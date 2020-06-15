package com.syntax.test;
import org.openqa.selenium.By;
//US 89876: As an admin user should be able to add an employee
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.syntax.util.CommonMethods;
import com.syntax.util.CommonMethodsTest;
import com.syntax.util.ConfigsReader;


public class AddigEmployeeAsAdmin extends CommonMethodsTest{
	String firstName, lastName, id, userName, password, status;
	//WebElement empListW, addButtonW, statusDDW, buttonSaveW, empListW2, firstNameW, lastNameW, idW, createLoginDetailsButtonW, userNameW, passwordW, confirmPassword, statusW;
	public AddigEmployeeAsAdmin(String firstName, String lastName, 
			String id, String userName, String password, String status) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.status = status;
}
	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		AddigEmployeeAsAdmin emp = new AddigEmployeeAsAdmin("Bruno","Gonzales","91289","bruno45","LimonLeopard939$","Enabled");
		
		emp.logInUsingSignUpValidCredentials();
		emp.goToFillingForm();
		emp.fillTextBoxes();
		emp.selectDDStatus();
		emp.clickOnSaveButton();
		emp.checkRegistration();
		tearDown();
	}
	
	public void logInUsingSignUpValidCredentials() {
		
		SignUpValidCredentials.userName = ConfigsReader.getValueOfProperty("username");
		SignUpValidCredentials.password = ConfigsReader.getValueOfProperty("password");
		SignUpValidCredentials.fillTextBoxes();
		SignUpValidCredentials.submitLogin();
		SignUpValidCredentials.liginVerification();
	}
	
	public void goToFillingForm() {
		CommonMethods.getWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"))).build().perform();
		CommonMethods.getWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		CommonMethods.click(driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		//CommonMethods.click(driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")));
		CommonMethods.getWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnAdd']")));
		CommonMethods.click(driver.findElement(By.xpath("//input[@id='btnAdd']")));
	}
	
	public void fillTextBoxes() {
		
		fillTextBox(driver.findElement(By.xpath("//input[@id='firstName']")), firstName);
		fillTextBox(driver.findElement(By.id("lastName")), lastName);
		fillTextBox(driver.findElement(By.id("employeeId")), id);
		clickSingleCheckBox(driver.findElement(By.id("chkLogin")));
		fillTextBox(driver.findElement(By.id("user_name")), userName);
		fillTextBox(driver.findElement(By.id("user_password")), password);
		fillTextBox(driver.findElement(By.id("re_password")), password);
	}
	public void selectDDStatus() {
		
		selectDDValue(driver.findElement(By.xpath("//select[@id='status']")), status);
	}
	
	public void clickOnSaveButton() {
		
		clickButton(driver.findElement(By.id("btnSave")));
	}
	public void checkRegistration() {
		CommonMethods.getWaitObject().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']")));
		clickButton(driver.findElement(By.id("menu_pim_viewEmployeeList")));
		fillTextBox(driver.findElement(By.id("empsearch_id")), id);
		clickButton(driver.findElement(By.id("searchBtn")));
		
		WebElement result = getWEByXPath("//a[contains(@href,'viewEmployee/empNumber')]");
		if((result.getText().contains(id)) | (result.getText().contains(firstName)) | (result.getText().contains(lastName))){
			System.out.println("Text Case Passed");
		}else {
			System.out.println("Text Case FAILD");
		}
	}
	

}
