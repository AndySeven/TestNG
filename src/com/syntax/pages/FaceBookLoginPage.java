package com.syntax.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.util.CommonMethods;
import com.syntax.util.PageInitializer;
/**
 * Class initialize all WebElements from LoginPage
 * 
 */
public class FaceBookLoginPage extends CommonMethods {
	
	@FindBy(xpath="//div[@class='placeholder']/following-sibling::input[@name='firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//div[@class='placeholder']/following::input[@name='lastname']")
	public WebElement lastName;

	@FindBy(css="input[name='reg_email__']")
	public WebElement email;
	
	@FindBy(name="reg_email_confirmation__")
	public WebElement emailRe;
	
	@FindBy(name="reg_passwd__")
	public WebElement password;
	
	@FindBy(id="month")
	public WebElement monthDD;
	
	@FindBy(id="day")
	public WebElement dayDD;

	@FindBy(id="year")
	public WebElement yearDD;
	
	@FindBy(css = "input[type='radio']")
	public List<WebElement> sexRadio;
	
	@FindBy(name="websubmit")
	public WebElement signUnBtn;
	
	@FindBy(css="i[class*='fb_logo i']")
	public WebElement logo;
	
	public FaceBookLoginPage(){
		PageFactory.initElements(driver, this);
	}

	public void fillTextBoxes(String name, String lastName, String email, String pass) {
		sendText(firstName, name);
		sendText(this.lastName, lastName);
		sendText(this.email, email);
		sendText(emailRe, email);
		sendText(password, pass);
			
	}
	
	public void fillBirthDD(String string, String string2, String string3) {
		selectDDValue(monthDD, string);
		selectDDValue(dayDD, string2);
		selectDDValue(yearDD, string3);
	}
	
	public void pickSex(String value1or2or3) {
		clickRadioOrCheckBox(sexRadio, value1or2or3);
	}
	
	public void logoChecking() {
		logoIsDisplayed(logo);
	}
	
	public void submitButton() {
		click(signUnBtn);
	}
}
