package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Folio;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class New_Edit_Delete_Folio extends TestCore{

	//Before Test
	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	// Move folio items inside the reservation
	@Test(dataProvider="getData", groups="Regression")
	public void moveFolio(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation, 
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode,
			String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext, String Attachment, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String Nights,String Adults,String Children,String CheckorUncheckAssign,String newFolioName,String newFolioDescription) throws InterruptedException, IOException{


		
		test = extent.startTest("New Edit Delete Folio", "New Edit Delete Folio")
				.assignCategory("Folio")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");


		
		String resNum = null;
		


			Reservation 	res 	= new Reservation();
			Login 			LOGIN 	= new Login();
			Folio 			folio 	= new Folio();

			// Login to InnCenter
			try{

				LOGIN.login(driver,url, ClientCode, Username, Password);
				test.log(LogStatus.PASS, "System successfully logged in the site");
				app_logs.info("System successfully logged in the site");
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to login", testName, "Login");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to login", testName, "Login");
			}


			// Clicking on New Reservation
			try{
				res.clickNewReservationButton(driver);
				test.log(LogStatus.PASS, "Successfully clicked on New Reservation");
				app_logs.info("Successfully clicked on New Reservation");
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to click on new Reservation", testName, "NewReservation");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to click on new Reservation", testName, "NewReservation");
			}


			try
			{

				res.marketingInfo(driver,test, MarketSegment, Referral, Travel_Agent, ExtReservation);
				res.contactInformation(driver, test,saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
				res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
				res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign);
				res.saveReservation(driver,test);
				resNum= res.GetReservationnumber(driver, test);
				res.validateAccount(driver,test, Account);
				/* res.manualEmail(driver,test, Email, Attachment);
		    	 res.GetReservationnumber(driver,test);
		    	 test.log(LogStatus.PASS, "Reservation created Success");*/
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Create Reservation", testName, "CreateReservation");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Create Reservation", testName, "CreateReservation");
			}


			try{
				
				folio.newFolio(driver, test, resNum,newFolioName, newFolioDescription);

			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Create Folio", testName, "NewFolio");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Create Folio", testName, "NewFolio");
			}
	}

	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("New Edit Delete Folio",excel);
	}
}
