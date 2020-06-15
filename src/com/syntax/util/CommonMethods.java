package com.syntax.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {

	/**
	 * 
	 * @return WebDriverWait
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	/**
	 * Method sets EX Condition waitForVisibility
	 * 
	 * @param element
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibilityLocator(By locator) {
		return getWaitObject().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Method set Expected Condition waitForClickability
	 * 
	 * @param element
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickabilityLocator(By locator) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitForPresenceOfElLocated(By locator) {
		return getWaitObject().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// ========================================================================================================================================

	/**
	 * Method gets WebElement type obj using id locator
	 * 
	 * @param id
	 * @return WebElement
	 */
	public static WebElement getWEByID(String id) {
		return driver.findElement(By.id("txtUsername"));
	}

	/**
	 * Method gets the WebElement using CSS locator
	 * 
	 * @param locator
	 * @return WebElement
	 */
	public static WebElement getWebElementByCSS(String locator) {
		return driver.findElement(By.cssSelector(locator));
	}

	/**
	 * Method gets the WE using xPath
	 * 
	 * @param xPath
	 * @return WebElement
	 */
	public static WebElement getWEByXPath(String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	// ========================================================================================================================================

	/**
	 * Method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * 
	 * @param locator
	 * @param text
	 */
	public static void sendText(By locator, String text) {
		waitForPresenceOfElLocated(locator).sendKeys(text);
	}

	/**
	 * 
	 * @param locator
	 * @param text
	 */
	public static void sendTextVis(By locator, String text) {
		waitForVisibilityLocator(locator).sendKeys(text);
	}

	// ========================================================================================================================================

	/**
	 * Method checks if Radio/CheckBox is enabled and clicks it
	 * 
	 * @param radioOrCheckBox
	 * @param value
	 */
	public static void clickRadioOrCheckBox(List<WebElement> radioOrCheckBox, String value) {
		String actualValue;
		for (WebElement el : radioOrCheckBox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	// ========================================================================================================================================

	/**
	 * Method that selects value by visible text in DD
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectDDValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element); // throw UnexpectedTagNameException id element is not of "select" tag
													// type
			List<WebElement> opt = select.getOptions();
			for (WebElement o : opt) {
				if (o.getText().equalsIgnoreCase(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that selects value by index in DD
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDDValue(WebElement element, int index) {
		waitForVisibility(element);
		try {
			Select select = new Select(element);
			List<WebElement> opt = select.getOptions();
			int size = opt.size();
			if (size > index) {
				select.selectByIndex(index);
			} else {
				System.out.println("Max Index is: " + (size - 1));
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

//	public static void selectDDValue(WebElement element, String value, String value2) {
//		try {
//			Select select = new Select(element);
//			List<WebElement> opt = select.getOptions();
//			int size = opt.size();
//			
//		}
//	}

	/**
	 * Method choose the value in DD not select type
	 * 
	 * @param element
	 * @param tagName
	 * @param textToSelect
	 */
//	public static void selectDDValue(WebElement element, String elementAttribute, String textToSelect) {
//		List<WebElement>ddOpt = driver.findElements(By.elementAttribute(tagName));
//		for(WebElement o: ddOpt) {
//			if(o.getText().equalsIgnoreCase(textToSelect)) {
//				o.click();
//				break;
//			}
//		}
//	}

	// ========================================================================================================================================

	/**
	 * Method accept the Alert Information
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method dismisses the Alert info
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method send keys to Alert text box
	 * 
	 * @param keysToSend
	 */
	public static void sendKeysToAlert(String keysToSend) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(keysToSend);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method gets text from Alert
	 * 
	 * @return String alert text
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	// ========================================================================================================================================

	/**
	 * Method switches focus to the Frame using name or id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method switches focus to the Frame using web element
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		waitForVisibility(element);
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method switches focus to the Frame using index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	// ========================================================================================================================================

	/**
	 * Method click on element after using explicit wait
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	public static void click(By locator) {
		waitForClickabilityLocator(locator).click();
	}

	public static JavascriptExecutor getJSEObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void clickJSE(WebElement element) {
		getJSEObject().executeScript("arguments[0].click()", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSEObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * Method that will scroll the page down based on passed pixels
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSEObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on passed pixels
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSEObject().executeScript("window.scrollBy(0, -" + pixel + ")");
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

	// ========================================================================================================================================

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

	public static void checkTitle(String expectedTitle) {
		if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
			System.out.println(driver.getTitle() + " --> is Displayed");
		} else {
			System.out.println(driver.getTitle() + " --> is NOT Displayed");
		}
	}

//====================================================================================================================
	/**
	 * Method switches focus to a child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String w : windows) {
			if (!w.equals(mainWindow)) {
				driver.switchTo().window(w);
				break;
			}
		}
	}

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods checks logo is Displayed or Not
	 * 
	 * @param element
	 */
	public static void logoIsDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("Logo is Displayed");
		} else {
			System.out.println("Logo is NOT Displayed");
		}
	}

	/**
	 * Method selects date from calendar
	 * 
	 * @param tdDates
	 * @param date
	 */
	public static void setCalendarDate(List<WebElement> tdDates, String date) {
		for (WebElement d : tdDates) {
			if (d.isEnabled()) {
				if (d.getText().equals(date)) {
					d.click();
					break;
				}
			}
		}

	}
	
	public static JavascriptExecutor getJSEObj() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

	}

	public static void jsClick(WebElement element) {
		getJSEObj().executeScript("arguments[0].click();", element);
	}

	public static TakesScreenshot getScrShotObj() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts;
	}

	public static File getFileObj() {
		File shot = getScrShotObj().getScreenshotAs(OutputType.FILE);
		return shot;
	}

	public static void getScrShot(String folderName, String fileName) {
		try {
			FileUtils.copyFile(getScrShotObj().getScreenshotAs(OutputType.FILE), new File("screenshots/"+folderName+"/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void uploadFile(WebElement element, String path) {
		sendText(element, path);
	}

//	public static void switchToChildWindow() {
//		String parentWindow = driver.getWindowHandle();
//		Set<String> setW = driver.getWindowHandles();
//		for(String w: setW) {
//			if(!w.equalsIgnoreCase(parentWindow)) {
//				driver.switchTo().window(w);
//			}
//		}
//	}
//	public static void switchToParentWindow() {
//		String parentWindow = driver.getWindowHandle();
//		driver.switchTo().window(parentWindow);
//
//	}
//	
//	public static String getParentWindoeHandle() {
//		return driver.getWindowHandle();
//	}
//
//	public static String getChildWindowHandle() {
//		String parentWindow = driver.getWindowHandle();
//		String child = null;
//		Set<String> setW = driver.getWindowHandles();
//		for (String w : setW) {
//			if (!w.equalsIgnoreCase(parentWindow))
//				child = w;
//		}
//		return child;
//	}
}
