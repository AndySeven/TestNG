package com.syntax.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethodsTest extends BaseClass {
	/**
	 * Method gets WebElement type obj using id locator
	 * 
	 * @param id
	 * @return WebElement
	 */
	public static WebElement getWEByID(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement getWEByXPath(String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * Method puts text into Text Box
	 * 
	 * @param element
	 * @param keys
	 */
	public static void fillTextBox(WebElement element, String keys) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(keys);
	}

	public static WebDriverWait getWebDriverWaitOBJ() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static void waitForClickability(WebElement element) {
		getWebDriverWaitOBJ().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForVisibility(WebElement element) {
		getWebDriverWaitOBJ().until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitUntilLoaded(By locator) {
		getWebDriverWaitOBJ().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void clickButton(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	public static void clickButtonLocator(WebElement element, By locator) {
		waitUntilLoaded(locator);
		element.click();
	}

	/**
	 * Method checks for text in an element
	 * 
	 * @param element
	 * @param text
	 */
	public static void checkTextinElement(WebElement element, String text) {
		waitForVisibility(element);
		if (element.getText().contains(text)) {
			System.out.println("<" + text + "> Text is presented in <" + element.getText() + ">");
		} else {
			System.out.println("<" + text + "> Text is NOT presented in <" + element.getText() + ">");
		}
	}

	/**
	 * Method checks the Single CheckBox
	 * 
	 * @param element
	 */
	public static void clickSingleCheckBox(WebElement element) {
		waitForVisibility(element);
		if (!element.isSelected()) {
			element.click();
		} else {
			System.out.println("<" + element.getText() + "> element was ALREADY selected");
		}
	}

	public static void selectDDValue(WebElement element, String value) {
		waitForVisibility(element);
		Select select = new Select(element);
		List<WebElement> listDD = select.getOptions();
		for (WebElement opt : listDD) {
			if (opt.getText().equalsIgnoreCase(value)) {
				select.selectByVisibleText(value);
				break;
			} else {
				System.out.println("Mistake");
			}

		}
	}
}
