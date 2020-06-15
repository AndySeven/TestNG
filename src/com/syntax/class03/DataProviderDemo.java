package com.syntax.class03;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.util.CommonMethods;
import com.syntax.util.ExcelReaderMine;

public class DataProviderDemo extends CommonMethods {
	@Test(dataProvider = "getDataFromExcel")
	// @Test(dataProvider = "getData")
	public void login(String username, String password) {
		sendText(login.userName, username);
		sendText(login.password, password);
		click(login.loginBtn);
		Assert.assertTrue(dash.welcome.isDisplayed(), "is NOT displayed");
	}

	@DataProvider
	public Object[][] getDataFromExcel() {
		Sheet sheet = ExcelReaderMine.getSheet(System.getProperty("user.dir") + "/data/DataProvider.xlsx", "Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows - 1][cols];

		for (int r = 1; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Object k = sheet.getRow(0).getCell(c).toString();
				Object v = sheet.getRow(r).getCell(c).toString();
				System.out.print(r + " " + c);
				data[r - 1][c] = v;
				System.out.println();
			}
		}
		return data;
	}

//	@DataProvider
//	public Object[][] getData() {
//		Object[][] data = { { "Admin", "Hum@nhrm123" }, { "Bob", "Hum@nhm123" }, { "Fox", "Hm@nhrm123" },
//				{ "Wolf", "Hum@nrm23" } };
//		// 2 way
//		Object[][] data2 = new Object[3][3];
//		data2 [0][0] = "Admin";
//		data2 [0][1] = "Hum@nhrm123";
//		data2 [0][0] = "Bob";
//		data2 [0][1] = "Admin";
//		return data;
//	}

}
