package com.innroad.inncenter.tests;

import java.io.IOException;


import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Folio;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyCashPayInRes extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData", groups = "Regression")
	public void Verify_CashPayment(String url, String ClientCode, String Username, String Password, String propertyName,
			String MargetSegment, String Referral, String FirstName, String LastName, String Phonenumber,
			String alternativeNumber, String Address1, String Address2, String Address3, String Email, String city,
			String State, String Postalcode, String SelectCategory, String RoomClass, String Payment_Type,
			String ClientType, String Line1, String Line2, String Line3, String Country, String Account,
			String saluation, String IsTaxExempt, String TaxEmptext, String Amount)
			throws InterruptedException, IOException {

		test = extent.startTest("VerifyCashPayInRes", "Create reservation and verify cash payment")
				.assignCategory("Accounts").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Login LOGIN = new Login();

		Reservation res = new Reservation();

		Folio payament = new Folio();

		// Login to InnCenter
		try {

			LOGIN.login(driver, url, ClientCode, Username, Password);
			Wait.wait10Second();
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}

		// Reservation
		try {
			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Navigate to New Reservation");
			app_logs.info("Navigate to New Reservation");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click New reservation button", testName, "Reservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click New reservation button", testName, "Reservation");
		}

		// New Reservation
		try {
			
			res.marketingInfo(driver, test, MargetSegment, Referral);;
			res.contactInformation(driver, saluation, FirstName, LastName, Address1,
					Line1, Line2, Line3, city, Country, State, Postalcode, Phonenumber, alternativeNumber, Email, Account, IsTaxExempt, TaxEmptext);;
			res.RoomAssign(driver, test, RoomClass);
			res.SaveReservation(driver);
			test.log(LogStatus.PASS, "Entered all reqiured details and save the reservation");
			app_logs.info("Entered all reqiured details and save the reservation");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Create New Reservation", testName, "CreateReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Create New Reservation", testName, "CreateReservation");
		}

		// Line item
		try {
			Folio folio = new Folio();
			folio.LineItem(driver, SelectCategory, Amount);
			folio.VerifyLineItem(driver, "", propertyName, SelectCategory, Amount);
			test.log(LogStatus.PASS, "Add and verify line item has been added successfully");
			app_logs.info("Add and verify line item has been added successfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Addd Line Item", testName, "Folio");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Addd Line Item", testName, "Folio");
		}

		// Cash payment
		try {

			payament.Cash_Payment(driver, Amount, Payment_Type);
			res.SaveReservation(driver);
			test.log(LogStatus.PASS, "Payment Via Cash succussfully");
			app_logs.info("Payment Via Cash succussfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Payment Via Cash", testName, "PrepaidPayment");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Payment Via Cash", testName, "PrepaidPayment");
		}
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("VerifyCashPayInRes", excel);
	}

}
