package com.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {
	@Test(groups = {"Smoke Test"})
	public void addEmployee() {
		String firstName = "Alibas";
		String lastName = "Gustaffson";
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));
		dash.navigateToAddEmp();
		addEmp.addFirstAndLastNameAndUploadPhoto(firstName, lastName,
				"/Users/robespierre/Downloads/636652141935608122-GettyImages-482658895.jpg");
		click(addEmp.btnSave);
		String expectedFullName = firstName + " " + lastName;
		String actualFullName = pDetails.fullNameHeader.getText();
		Assert.assertEquals("Header doesn't contain user Full Name", expectedFullName, actualFullName);
		// Assert.assertTrue("Photo has NOT been loaded", pDetails.photo.isDisplayed());
		getScrShot("screenshots", "user23");
	}

	/**
	 * US 12678 As an Admin I should be able to create login credentials while
	 * adding employee
	 */
	@Test(priority = 1)
	public void addLoginCredetials() {
		String firstName = "Gaspacho";
		String lastName = "Fettuccini";
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));
		dash.navigateToAddEmp();
		addEmp.addFirstAndLastNameAndUploadPhoto(firstName, lastName,
				"/Users/robespierre/Downloads/1024px-giraffe_close_up.jpg");
		clickSingleCheckBox(addEmp.singleCheckBox);
		String nickName = "Jasper89";
		String password = "Lpoiuytrewqasdfghjk90$";
		sendText(addEmp.nickName, nickName);
		sendText(addEmp.userPassword, password);
		sendText(addEmp.rePassword, password);
		selectDDValue(addEmp.statusDD, "Enabled");
		click(addEmp.btnSave);
		click(dash.welcome);
		click(pDetails.logout);
		login.login(nickName, password);
		System.out.println(dash.welcome.getText());
		Assert.assertTrue("User has NOT logged", dash.welcome.getText().contains(firstName));
	}

	/**
	 * US 67789 As an admin while adding employee if I leave required fields empty I
	 * should see “Required” message. Note: first name and last name are required
	 * fields
	 */
	@Test(priority = 2)
	public void emptyFields() {
		String firstName = "";
		String lastName = "Gustaffson";
		login.login(ConfigsReader.getValueOfProperty("username"), ConfigsReader.getValueOfProperty("password"));
		dash.navigateToAddEmp();
		addEmp.addFirstAndLastNameAndUploadPhoto(firstName, lastName,
				"/Users/robespierre/Downloads/636652141935608122-GettyImages-482658895.jpg");
		click(addEmp.btnSave);
		SoftAssert soft = new SoftAssert();
		String actual = addEmp.errMsgFirstName.getText();
		String expected = "Required";
		soft.assertEquals(actual, expected, "Expected msg is NOT presented");
		firstName = "Alibas";
		lastName = "";
		addEmp.addFirstAndLastNameAndUploadPhoto(firstName, lastName,
				"/Users/robespierre/Downloads/636652141935608122-GettyImages-482658895.jpg");
		click(addEmp.btnSave);
		String actual2 = addEmp.errMsgLastName.getText();
		String expected2 = "Required";
		soft.assertEquals(actual2, expected2, "Expected msg is NOT presented");
		soft.assertAll();
		
		
	}
}
