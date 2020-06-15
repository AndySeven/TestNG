package com.syntax.class02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.pages.DashBoardPageElements;
import com.syntax.pages.LoginPageElements;

//import com.pj.pages.*;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class HWAssertions extends CommonMethods {

	@BeforeClass
	public void openBrowser() {
		setUpBrowser();
	}

	@AfterClass
	public void closeBrowser() {
		tearDown();
	}

	@Test
	public void loginApp() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.userName, ConfigsReader.getValueOfProperty("username"));
		sendText(login.password, ConfigsReader.getValueOfProperty("password"));
		click(login.loginBtn);
		DashBoardPageElements dash = new DashBoardPageElements();
		String welcomeText = dash.welcome.getText();
		boolean contains = welcomeText.contains(ConfigsReader.getValueOfProperty("username"));
		Assert.assertTrue(contains, welcomeText + " --> is NOT Displayed");
		Actions action = new Actions(driver);
		action.moveToElement(dash.btnPim).perform();
		click(dash.btnAddEmp);
	}

	@Test(dependsOnMethods = "loginApp")
	public void verFields() {
		AddEmployeePage addEmp = new AddEmployeePage();
		String actualFN = "Full Name";
		String actualID = "Employee Id";
		String actualPh = "Photograph";
		boolean isFN = actualFN.equals(addEmp.fullNameField.getText());
		boolean isID = actualID.equals(addEmp.employeeIdField.getText());
		boolean isPh = actualPh.equals(addEmp.photoField.getText());
		SoftAssert s = new SoftAssert();
		s.assertTrue(isFN, addEmp.fullNameField.getText() + " is NOT Displayed");
		s.assertTrue(isID, addEmp.employeeIdField.getText() + " is NOT Displayed");
		s.assertTrue(isPh, addEmp.photoField.getText() + " is NOT Displayed");
		s.assertAll("Asserts ALLLLLLLLLLLLL");
	}

	@Test(dependsOnMethods = "verFields")
	public void addEmployee() {
		AddEmployeePage add1 = new AddEmployeePage();
		FileInputStream fis;
		Workbook book;
		Sheet sheet = null;

		String filePath = System.getProperty("user.dir") + "/data/AddEmp.xlsx";
		System.out.println(filePath);
		try {
			fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
			sheet = book.getSheet("Sheet1");
		} catch (IOException e) {
			e.printStackTrace();
		}

		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		Map<String, String> map = new LinkedHashMap<>();
		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				String key = sheet.getRow(0).getCell(c).toString();
				String val = sheet.getRow(r).getCell(c).toString();
				map.put(key, val);
			}
		}

		Set<String> keys = map.keySet();
		System.out.println(keys);
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String name = map.get(it.next());
			String lastName = map.get(it.next());
			System.out.println(name + "" + lastName);
			wait(2);
			sendText(add1.firstName, name);
			sendText(add1.lastName, lastName);
		}

		sendText(add1.addFile, "/Users/robespierre/Downloads/6000200094514.jpg");

		click(add1.btnSave);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File("screenshots/apple.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
