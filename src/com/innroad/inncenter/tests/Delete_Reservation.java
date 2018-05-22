package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Delete_Reservation extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void delete_Reservation(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData

	) throws InterruptedException, IOException {
		test = extent.startTest("delete_Reservation", "Deleting Reservation").assignCategory("Reservations")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		String ResConfirmation_number = "";

		Reservation res = new Reservation();
		ReservationSearch res_Serach = new ReservationSearch();
		
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
			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Clicked new Reservation button");
			app_logs.info("Clicked new Reservation button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
		}

		try {

			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.saveReservation(driver);
			ResConfirmation_number = res.GetReservationnumber(driver);
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Enter all reqiured details and save the reservation", testName, "ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Enter all reqiured details and save the reservation", testName, "ReservationDetails");
		}

		try {
			res.Cancel_Reservation(driver);
			test.log(LogStatus.PASS, "Successfully Canceled the reservation");
			app_logs.info("Successfully Canceled the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Cancel the reservation", testName, "CancelReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Cancel the reservation", testName, "CancelReservation");
		}

		try {
			res.Close_Tab(driver);
			test.log(LogStatus.PASS, "Navigated back to Reservations page");
			app_logs.info("Navigated back to Reservations page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed Navigate back to Reservations page", testName, "ReservationsPage");
		} catch (Error e) {
			Utility.updateReport(e, "Failed Navigate back to Reservations page", testName, "ReservationsPage");
		}

		try {

			res_Serach.basicSearch_WithResNumber(driver);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName,
					"BasicSearch");
		} catch (Error e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName,
					"BasicSearch");
		}

		try {
			res_Serach.delete_Res_WithResNumber(driver, ResConfirmation_number);
			test.log(LogStatus.PASS, "Sucessfully Deleted Reservation");
			app_logs.info("Sucessfully Deleted Reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "failed to Delete the given Reservation", testName, "DeleteReservation");
		} catch (Error e) {
			Utility.updateReport(e, "failed to Delete the given Reservation", testName, "DeleteReservation");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

//		return test data from the sheet-name provided
		return Utility.getData("Delete_Reservation", excel);
	}

}
