package com.syntax.class03;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import com.syntax.util.ExcelReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW extends CommonMethods {

	@Test(dataProvider = "userDataFromExcell", groups = {"homework","regression","addEmp"})
	public void add5Emp(String FN, String LN, String UN, String P) {
		// login application
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));
		
		// navigate to AddEmployee Page
		jsClick(dash.pim);
		jsClick(dash.btnAddEmp);
		
		// adding first and last name
		sendText(addEmp.firstName, FN);
		sendText(addEmp.lastName, LN);
		
		// clicking on single check Box
		clickSingleCheckBox(addEmp.singleCheckBox);
		
		// adding credentials data
		sendText(addEmp.nickName, UN);
		sendText(addEmp.userPassword, P);
		sendText(addEmp.rePassword, P);
		click(addEmp.btnSave);
		
		// Validation of registration user
		String expectedFullName = FN + " " + LN;
		WebElement el = waitForVisibility(pDetails.fullNameHeader);
		String actualFullName = el.getText();
		Assert.assertEquals(actualFullName, expectedFullName,"Header doesn't contain user Full Name");
		
		// computing number of photo and making a screenshot
		//getScrShot("HRMS", FN+""+LN);
		
	}
	@DataProvider(name = "userDataFromExcell")
	public Object[][] getdata2(){
		return ExcelReader.excelIntroArray(System.getProperty("user.dir")+"/data/DataProvider2.xlsx", "Sheet1");
	}

//	@DataProvider
//	public Object[][] dataGenerator() {
//		Sheet sheet = ExcelReaderMine.getSheet(System.getProperty("user.dir") + "/data/DataProvider2.xlsx", "Sheet1");
//		int rows = sheet.getPhysicalNumberOfRows();
//		int cols = sheet.getRow(0).getLastCellNum();
//		Object[][] data = new Object[rows - 1][cols];
//		for (int r = 1; r < rows; r++) {
//			for (int c = 0; c < cols; c++) {
//				data[r - 1][c] = sheet.getRow(r).getCell(c).toString();
//			}
//		}
//		return data;
//	}
	
}
