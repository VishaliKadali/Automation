package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationFolio;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_CP_Res_CPPay extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void create_CP_Res_CPPay(String url, String ClientCode, String Username, String Password,
			String propertyName, String Accounttype, String AccountName, String MargetSegment, String Referral,
			String AccountFirstName, String AccountLastName, String Phonenumber, String alternativeNumber,
			String Address1, String Address2, String Address3, String Email, String city, String State,
			String Postalcode, String subject, String details, String NoteType, String Notestatus, String Travel_Agent,
			String ExtReservation, String saluation, String FirstName, String LastName, String Address, String Line1,
			String Line2, String Line3, String City, String Country, String Account, String IsTaxExempt,
			String TaxEmptext, String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,
			String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException, IOException {

		ExtentTest test = extent.startTest("Create_CP_Res_CPPay", "Creating corporate account and reservation for it")
				.assignCategory("Accounts").assignCategory("Sanity");
		
		String testName=test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Login into the application \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Login_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Login into the application \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		Reservation res = new Reservation();

		try {
			Navigation newQuoteNavigation = new Navigation();
			newQuoteNavigation.Accounts(driver);
			Wait.wait25Second();
			app_logs.info("Navigated to Accounts page");
			test.log(LogStatus.PASS, "Navigated to Accounts");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to accounts page \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_AccountsNavigation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to navigate to accounts page \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			Account CreateCorporteAccount = new Account();
			CreateCorporteAccount.NewAccountbutton(driver, Accounttype);
			app_logs.info("Navigated to new Account by clicking on new Account");
			test.log(LogStatus.PASS, "Navigated to new Account by clicking on new Account");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to new account page \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_NewCPAccount_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to navigate to new account page \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			Account CreateCorporteAccount = new Account();
			CreateCorporteAccount.AccountDetails(driver, Accounttype, AccountName);
			app_logs.info("Entered account details");
			CreateCorporteAccount.AccountAttributes(driver, MargetSegment, Referral);
			app_logs.info("Entered account attributes");
//			CreateCorporteAccount.AccAddNotes(driver, subject, details, NoteType, Notestatus);
//			app_logs.info("Added account Notes");
			CreateCorporteAccount.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativeNumber, Address1, Address2, Address3, Email, city, State, Postalcode);
			app_logs.info("Entered mailing details");
			CreateCorporteAccount.Billinginfo(driver);
			app_logs.info("Entered billing details");
			CreateCorporteAccount.Save(driver);
			app_logs.info("Entered all required details and saved the account");
			test.log(LogStatus.PASS, "Entered all required details and saved the account");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to save the account \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_SaveCPAccount_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to save the account \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			Account CreateCorporteAccount = new Account();
			CreateCorporteAccount.CreateNewReservation(driver);
			app_logs.info("Clicked on New Reservation button");
			test.log(LogStatus.PASS, "Clicked on New Reservation button");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to click on new Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_NewReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to click on new Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
//			Reservation res = new Reservation();
			res.marketingInfo(driver, MargetSegment, Referral, Travel_Agent, ExtReservation);
			app_logs.info("Entered marketing information");
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativeNumber, Email, Account, IsTaxExempt, TaxEmptext);
			app_logs.info("Entered contact information");
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign, RoomClassName, RoomNumber);
			app_logs.info("Room assignment is completed");
			res.saveReservation(driver);
			app_logs.info("Saved the reservation");
			test.log(LogStatus.PASS, "Enter all reqiured details and saved the reservation");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Enter all reqiured details and save the reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_ReservationDetails_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Enter all reqiured details and save the reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			ReservationFolio Accountpay = new ReservationFolio();
			Accountpay.Paytype_CP_Account(driver, ChangeAmount, ChangeAmountValue);
//			Reservation res = new Reservation();
			res.saveReservation(driver);
			app_logs.info("Payment with account and save reservation is successful");
			test.log(LogStatus.PASS, "Payment with account and Save reservation is successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to pay and save the reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_PayAndSaveReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to pay and save the reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		extent.endTest(test);
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("Create_CP_Res_CPPay", excel);
	}
}
