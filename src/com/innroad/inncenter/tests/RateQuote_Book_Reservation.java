package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.RateQuote;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote_Book_Reservation extends TestCore {


	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}

	@Test(dataProvider = "getData", groups="Regression")
	public void CreateReservationfromRateQuoteBookicon(String url, String ClientCode, String Username, String Password,
			String propertyName, String RateQuoteNights, String RateQuoteAdults, String RateQuoteChildren,
			String RateQuoteRatePlanList, String RateQuotePromoCode, String MarketSegment, String Referral,
			String Travel_Agent, String ExtReservation, String saluation, String FirstName, String LastName,
			String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account,
			String IsTaxExempt, String TaxEmptext, String Attachment, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes

			) throws InterruptedException, IOException {

		test = extent.startTest("RateQuote_Book_Reservation", "RateQuote_Book_Reservation")
				.assignCategory("RateQuote")
				.assignCategory("Regression");	

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Login 		LOGIN 				= new Login();
		Navigation 	newQuoteNavigation 	= new Navigation();
		RateQuote 	rateQuotePage		= new RateQuote();
		Reservation res 				= new Reservation();

		try {

			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}

		try {

			newQuoteNavigation.NewQuote(driver);
			app_logs.info("Navigated to NewQuote page");
			test.log(LogStatus.PASS, "Navigated to NewQuote page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on New Quote", testName, "NewQuote");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on New Quote", testName, "NewQuote");
		}


		try {
			rateQuotePage.searchDetails(driver, RateQuoteNights, RateQuoteAdults, RateQuoteChildren,
					RateQuoteRatePlanList, RateQuotePromoCode);
			rateQuotePage.SearchRateQuoteDetails(driver);
			app_logs.info("Clicked on Search button");
			test.log(LogStatus.PASS, "Clicked on search button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Search", testName, "RateQuoteSearch");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Search", testName, "RateQuoteSearch");
		}


		try {
			rateQuotePage.clickBookicon(driver);
			app_logs.info("Clicked on Book icon");
			test.log(LogStatus.PASS, "Clicked on Book Icon");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Book", testName, "RateQuoteBook");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Book", testName, "RateQuoteBook");
		}
		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			app_logs.info("Entered marketing information");
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			app_logs.info("Entered contact information");
			res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
			app_logs.info("Entered billing information");
			res.saveReservation(driver);
			app_logs.info("Saved the reservation");
			//res.manualEmail(driver, Email, Attachment);
			res.GetReservationnumber(driver);
			test.log(LogStatus.PASS, "Reservation is created");
			app_logs.info("Reservation is created");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Create Quote", testName, "CreateQuoteReservatiom");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Create Quote", testName, "CreateQuoteReservatiom");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("RateQuote_Book_Reservation", excel);
	}
}
