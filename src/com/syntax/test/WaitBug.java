package com.syntax.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.CommonMethods;

public class WaitBug extends CommonMethods{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement userNameW = driver.findElement(By.id("txtUsername"));
			userNameW.sendKeys("Admin");
			WebElement passwordW = driver.findElement(By.id("txtPassword"));
			passwordW.sendKeys("Hum@nhrm123");
			WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
			loginButton.click();
			
		 
			
			
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).build().perform();
			
			new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("menu_pim_viewPimModule")))).click();
			
			new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id='btnAdd']")))).click();
			
			//driver.quit();
			
		
		
	}

}
