package com.innroad.inncenter.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyResetOption extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void verifyResetOption(String url, String ClientCode, String Username, String Password, String PropertyName)
			throws InterruptedException {
		test = extent.startTest("VerifyResetOption", "Verify Reset Option")
				.assignCategory("Reservation")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
//		Reservation res = new Reservation();

		String Beforeediting="";

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
			res.IPropertySelector(driver, PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}
*/
		
		try {
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Opened first Reservation from the Reservations list");
			app_logs.info("Opened first Reservation from the Reservations list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first reservation from the Reservations list", testName,
					"SearchResult");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first reservation from the Reservations list", testName,
					"SearchResult");
		}

		try {
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			Utility.ScrollToElement(ReservationPage.Enter_First_Name);
			Wait.wait2Second();
			Beforeediting = ReservationPage.Enter_First_Name.getAttribute("value");
			ReservationPage.Enter_First_Name.clear();
			ReservationPage.Enter_First_Name.sendKeys("EditedFName");
			ReservationPage.Enter_Last_Name.clear();
			ReservationPage.Enter_Last_Name.sendKeys("EditedLName");
			Wait.wait5Second();
			if (ReservationPage.ReservationPage_Reset_Btn.isEnabled()) {
				ReservationPage.ReservationPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(ReservationPage.Enter_First_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in Reservation Page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Reservation info");
			}

			test.log(LogStatus.PASS, "Sucessfully verified Reset option in Reservation page ");
			app_logs.info("Sucessfully verified Reset option in Reservation page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option on Reservation page,", testName, "VerifyReset");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option on Reservation page", testName, "VerifyReset");
		}

		try {
			Navigation navigation = new Navigation();
			navigation.Accounts(driver);
			test.log(LogStatus.PASS, "Navigated to Accounts");
			app_logs.info("Navigated to Accounts");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		}

		try {
			Elements_Accounts CreateAccount = new Elements_Accounts(driver);
			Wait.wait3Second();
			CreateAccount.AccountsPage_Click_All.click();
			Wait.explicit_wait_visibilityof_webelement(CreateAccount.First_Element_In_Account_SearchResults);
			CreateAccount.First_Element_In_Account_SearchResults.click();
			Wait.explicit_wait_visibilityof_webelement(CreateAccount.Enter_Account_Name);
			test.log(LogStatus.PASS, "Opened first account from the accounts list");
			app_logs.info("Opened first account from the accounts list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first account from the accounts list", testName, "AccountsDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first account from the accounts list", testName, "AccountsDetails");
		}

		try {

			Elements_Accounts CreateAccount = new Elements_Accounts(driver);
			Utility.ScrollToElement(CreateAccount.Account_Enter_First_Name);
			Wait.wait2Second();
			Beforeediting = CreateAccount.Account_Enter_First_Name.getAttribute("value");
			CreateAccount.Account_Enter_First_Name.clear();
			CreateAccount.Account_Enter_Last_Name.clear();
			CreateAccount.Account_Enter_First_Name.sendKeys("EditedFName");
			CreateAccount.Account_Enter_Last_Name.sendKeys("EditedLName");
			Wait.wait5Second();
			if (CreateAccount.AccountsPage_Reset_Btn.isEnabled()) {
				CreateAccount.AccountsPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(CreateAccount.Account_Enter_First_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in accounts page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing account info");
			}

			test.log(LogStatus.PASS, "Sucessfully verified Reset option in Accounts page ");
			app_logs.info("Sucessfully verified Reset option in Accounts page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Accounts page", testName, "AccountsResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Accounts page", testName, "AccountsResetOpt");
		}
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

//		return test data from the sheet-name provided
		return Utility.getData("VerifyResetOption", excel);

	}
}
