package com.innroad.inncenter.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Policies;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.relevantcodes.extentreports.LogStatus;

public class Create_New_Policy extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void create_New_Policy(String url, String ClientCode, String Username, String Password, String propertyName,
			String Policytype, String PolicyName, String Percentage, String PolicyText, String PolicyDesc)
			throws InterruptedException {

		PolicyName = Percentage + "% " + Policytype + " " + PolicyName + Utility.getTimeStamp();

		test = extent.startTest("Create_New_Policy", "New Policy creation Test").assignCategory("Policies")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

//		Reservation res = new Reservation();
		
		Policies Create_New_Policy = new Policies();
		
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}
		
/*		
		try {
			res.IPropertySelector(driver, propertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}
*/
		
		try {
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Inventory(driver);
			test.log(LogStatus.PASS, "Navigated to Inventory");
			app_logs.info("Navigated to Inventory");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		}

		try {
			Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
			Navigate.Menuitem_Policy_Text.click();
			Wait.explicit_wait_xpath(OR.Policy_Button);
			test.log(LogStatus.PASS, "Navigated to Policies");
			app_logs.info("Navigated to Policies");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PoliciesNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PoliciesNavigation");
		}

		try {
			Create_New_Policy.NewPolicybutton(driver, Policytype);
			test.log(LogStatus.PASS, "Navigated to new Policy by clicking on new Policy button");
			app_logs.info("Navigated to new Policy by clicking on new Policy button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicy");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicy");
		}

		try {

			Create_New_Policy.Enter_Policy_Name(driver, PolicyName);
			Create_New_Policy.Enter_Deposit_Policy_Attributes(driver, "PRC", Percentage);
			Create_New_Policy.Enter_Policy_Desc(driver, PolicyText, PolicyDesc);
			Create_New_Policy.Associate_Sources(driver);
			Create_New_Policy.Associate_Seasons(driver);
			Create_New_Policy.Associate_RoomClasses(driver);
			Create_New_Policy.Associate_RatePlans(driver);
			Create_New_Policy.Save_Policy(driver);
			Create_New_Policy.Close_Policy_Tab(driver);

			test.log(LogStatus.PASS, "New Policy saved successfully ");
			app_logs.info("New Policy saved successfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the policy", testName, "PolicyDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the policy", testName, "PolicyDetails");
		}

		try {
			Create_New_Policy.Verify_Policy(driver, PolicyName);
			test.log(LogStatus.PASS, "Created policy showing up in search results");
			app_logs.info("Created policy showing up in search results");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! Created policy is not showing up in search results", testName, "PolicySearch");
		} catch (Error e) {
			Utility.updateReport(e, "Error! Created policy is not showing up in search results", testName, "PolicySearch");
		}

		// Deleting policies after test execution
		try {

			Policies policy = new Policies();
			policy.Delete_Policy(driver, PolicyName);
			
		} catch (Exception e) {
			app_logs.info("Failed to Delete created Policie");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("Create_New_Policy", excel);
	}

}
