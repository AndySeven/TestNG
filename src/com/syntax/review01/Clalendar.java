package com.syntax.review01;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class Clalendar extends CommonMethods {

	public static void main(String[] args) {
		
		setUpBrowser();
		driver.get("https://jqueryui.com/");
		click(By.xpath("//a[contains(text(),'pic')]"));

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		click(By.id("datepicker"));
		String monthYear = waitForPresenceOfElLocated(By.cssSelector("div.ui-datepicker-title")).getText();

		while (true) {
			monthYear = waitForPresenceOfElLocated(By.cssSelector("div.ui-datepicker-title")).getText();
			if (!monthYear.equals("October 2020")) {
				waitForClickability(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")))
						.click();
			} else {
				break;
			}
		}

//		while (!(monthYear.equals("October 2020"))) {
//			waitForClickability(driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")))
//					.click();
//			monthYear = waitForPresenceOfElLocated(By.cssSelector("div.ui-datepicker-title")).getText();
//		}
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
//		for (WebElement date : dates) {
//			if (date.getText().equals("8")) {
//				date.click();
//				break;
//			}
//		}
		
		setCalendarDate(dates, "7");
		
		driver.switchTo().defaultContent();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File shot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(shot, new File ("screenshots/oct7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Robot r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait(4);
		tearDown();
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
