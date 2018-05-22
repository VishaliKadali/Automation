package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
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
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote_Book_Quote extends TestCore{
	@BeforeTest
	public void checkRunMode(){

		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}


	@Test(dataProvider="getData",groups="Regression")
	public void CreateReservationfromRateQuoteBookicon(String url,String ClientCode, String Username, String Password, String propertyName, String RateQuoteNights, String RateQuoteAdults, String
			RateQuoteChildren, String RateQuoteRatePlanList, String RateQuotePromoCode, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation, 
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode,
			String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext, String Attachment, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes	) throws InterruptedException, IOException {

		test = extent.startTest("RateQuote_Book_Quote", "RateQuote_Book_Quote")
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


		// Login to InnCenter
		try{

			LOGIN.login(driver,url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "System successfully logged in the site");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}


		try{
			newQuoteNavigation.NewQuote(driver);
			test.log(LogStatus.PASS, "Navigating to NewQuote page");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on New Quote", testName, "NewQuote");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on New Quote", testName, "NewQuote");
		}

		try{
			rateQuotePage.searchDetails(driver,test, RateQuoteNights, RateQuoteAdults, RateQuoteChildren, RateQuoteRatePlanList, RateQuotePromoCode); 
			rateQuotePage.SearchRateQuoteDetails(driver,test);
			test.log(LogStatus.PASS, "Available Filter room classes");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Search", testName, "RateQuoteSearch");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Search", testName, "RateQuoteSearch");
		}

		try{
			rateQuotePage.clickQuoteIcon(driver,test);
			//test.log(LogStatus.PASS, "Click on Quote Icon");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Icon", testName, "QuoteIcon");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Click on Rate Quote Icon", testName, "QuoteIcon");
		}

		try {
			res.marketingInfo(driver,test, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, test,saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
			res.saveReservation(driver,test);
			res.clickBook(driver);
			res.saveReservationQuote(driver, test);
			res.manualEmail(driver, test,Email, Attachment);
			res.GetReservationnumber(driver,test);
			test.log(LogStatus.PASS, "Reservation created Success");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Create Quote", testName, "CreateQuote");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Create Quote", testName, "CreateQuote");
		}

		extent.endTest(test);

	}


	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided
		return Utility.getData("RateQuote_Book_Quote",excel);
	}
}
