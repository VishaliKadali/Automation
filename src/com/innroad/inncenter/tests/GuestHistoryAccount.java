package com.innroad.inncenter.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.GuestHistory;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GuestHistoryAccount extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);

	}

	@Test(dataProvider = "getData")
	public void guestHistory(String url, String ClientCode, String Username, String Password, String PropertyName,
			String salutation, String FirstName, String MarketSegment, String Referral, String AccountFirstName,
			String AccountLastName, String Phonenumber, String alternativeNumber, String Address1, String Address2,
			String Address3, String Email, String city, String State, String Postalcode, String AccountFname) {

		test = extent.startTest("GuestHistoryAccount", "Guest History Account").assignCategory("GuestHistory")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		// **************** Login*******************//

		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}

		// *******************Select Property ****************//
		/*
		 * try { Reservation res = new Reservation();
		 * res.IPropertySelector(driver,PropertyName); test.log(LogStatus.PASS,
		 * "Property Selection Success");
		 * app_logs.info("Selected the Property"); } catch (Exception e) {
		 * Utility.updateReport(e, "Failed to Select Property", testName,
		 * "IPropertySelector"); } catch (Error e) { Utility.updateReport(e,
		 * "Failed to Select Property", testName, "IPropertySelector"); }
		 */

		// *********************Click Guest History******************//
		try {
			GuestHistory guest_his = new GuestHistory();
			guest_his.guestHistory(driver);
			test.log(LogStatus.PASS, " System successfully Navigated to Guest History ");
			app_logs.info("System successfully Navigated to Guest History ");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Navigate to GuestHistory", testName, "GuestHistory");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Navigate to GuestHistory", testName, "GuestHistory");
		}

		// *********************Click New Account in Guest
		// History******************//

		try {
			GuestHistory guest_his = new GuestHistory();
			guest_his.guestHistory_NewAccount(driver);
			test.log(LogStatus.PASS, " System successfully Clicked on New Account button in Guest History ");
			app_logs.info("Clicked on New Account buton in Guest History ");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click New Account button", testName, "NewAccount_GuestHistory");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click New Account button", testName, "NewAccount_GuestHistory");
		}

		// *********************Enter the details in Guest
		// History******************//
		try {

			GuestHistory guest_his = new GuestHistory();
			guest_his.guestHistory_AccountDetails(driver, salutation, FirstName);
			app_logs.info("Entered the Account Details");
			guest_his.accountAttributes(driver, MarketSegment, Referral);
			app_logs.info("Entered the Account Attributes");
			guest_his.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativeNumber, Address1,
					Address2, Address3, Email, city, State, Postalcode);
			app_logs.info("Entered the Mailing Info");
			guest_his.Billinginfo(driver);
			app_logs.info("Entered the Billing Info");
			guest_his.Save(driver);
			app_logs.info("Clicked on Save button");
			// guest_his.newReservation(driver);
			// guest_his.roomAssignment(driver, PropertyName, Nights, Adults,
			// Children, RatepromoCode, CheckorUncheckAssign, RoomClassName,
			// RoomNumber);
			guest_his.closeAccount(driver);
			app_logs.info("Closed the Account");
			test.log(LogStatus.PASS, " Guest History created succesfully ");
			app_logs.info("Guest History created succesfully");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Create GuestHistory Account", testName, "GuestHistory_Account");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Create GuestHistory Account", testName, "GuestHistory_Account");
		}

		// *********************Search Guest History Account******************//
		try {

			GuestHistory guest_his = new GuestHistory();
			guest_his.searchAccount(driver, AccountFname);
			test.log(LogStatus.PASS, " Searched the GuestHistory Account");
			app_logs.info("Searched the GuestHistory succesfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Search the Guest History Account", testName,
					"Search_GuestHistoryAccount");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Search the Guest History Account", testName,
					"Search_GuestHistoryAccount");
		}

		try {

			GuestHistory guest_his = new GuestHistory();
			guest_his.deleteGuestHistoryAccount(driver);
			test.log(LogStatus.PASS, " Searched the GuestHistory Account");
			app_logs.info("Deleted the GuestHistory succesfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Delete the Guest History Account", testName,
					"Delete_GuestHistoryAccount");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Delete the Guest History Account", testName,
					"Delete_GuestHistoryAccount");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("GuestHistoryAccount", excel);
	}

}
