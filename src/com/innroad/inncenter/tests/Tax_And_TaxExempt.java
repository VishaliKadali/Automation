package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.pageobjects.Tax;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.webelements.Elements_Tax;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Tax_And_TaxExempt extends TestCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}



	// Create New Room Class
	@Test(dataProvider="getData", groups="Regression")
	public void taxAndTaxExempt(String url,String ClientCode, String Username, String Password,String MarketSegment,String Referral,String FirstName,String LastName,String Line1, String City, String State, String Country,String Postalcode,String Phonenumber, String PaymentMethod,String AccountNumber,String ExpiryDate,String BillingNotes,String Nights,String Adults,String Children,String CheckorUncheckAssign,String RoomClassName,String taxName,String displayName,String description,String value,String category,String taxLedgerAccount,String amount){

		test = extent.startTest("taxAndTaxExempt", "taxAndTaxExempt")
				.assignCategory("taxAndTaxExempt")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");




		Reservation 			res	  	  =	new Reservation();
		Login 					LOGIN 	  = new Login();
		Tax 					tax       = new Tax();
		Elements_Tax 			tax1  	  = new Elements_Tax(driver);
		Navigation 				Nav	 	  = new Navigation();
		ReservationSearch 		resSearch = new ReservationSearch();


		String reservation = null;

		// Login to InnCenter
		try{

			LOGIN.login(driver,url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "System successfully logged in the site");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}


		// Clicking on New Reservation
		try{
			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Successfully clicked on New Reservation");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to click on new Reservation", testName, "NewReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click on new Reservation", testName, "NewReservation");
		}

		// fill the marketing info
		try{
			res.marketingInfo(driver, test,MarketSegment, Referral);

			System.out.println("successfully filled the market info");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		}



		// fill the contact info
		try{
			res.contactInformation(driver, test, FirstName, LastName, Line1, City, Country, State, Postalcode, Phonenumber);

			System.out.println("successfully filled the contact info");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		}

		// Fill the payment info
		try{
			res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
			System.out.println("successfully filled the payment info");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		}


		//Fill the room details
		try{
			res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign, RoomClassName);
			System.out.println("successfully filled the room info");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		}

		//Validating tax exempt
		try{
			res.saveReservation(driver,test);
			reservation=res.GetReservationnumber(driver,test);
			res.vaidatePaymentDetails(driver, test);
			res.clickGuestInfo(driver,test);
			res.validateTaxExempt(driver, test);
			res.saveReservation(driver, test);
			res.click_Folio(driver, test);
			res.taxDetails(driver, test);


		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
		}

		try
		{
			Nav.Setup(driver);
			Assert.assertTrue("Fail to navigate Setup",Utility.return_element_status_after_explicit_wait(OR.Setup_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Setup");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Navigate Setup", testName, "Setup");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Navigate Setup", testName, "Setup");
		}


		try
		{				
			Nav.TaxesAfterCloseReservation(driver);
			Assert.assertTrue("Fail to navigate Taxes",Utility.return_element_status_after_explicit_wait(OR.Tax_Items_Title));
			test.log(LogStatus.PASS, "Navigate Taxes");

			tax1.TaxNewItem.click();
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Navigate New Tax Btn", testName, "NewTaxBtn");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Navigate New Tax Btn", testName, "NewTaxBtn");
		}

		try{

			tax.createTax(driver, test, taxName, displayName, description, value, category, taxLedgerAccount);

			resSearch.basicSearch_WithResNumber(driver,reservation);
			app_logs.info("Reservation Opened : "+reservation);
			resSearch.uncheck_TaxExempt(driver, test);
			res.click_Folio(driver, test);
			res.saveReservation(driver, test);
			resSearch.addIncidentals(driver, test, taxLedgerAccount, amount);
			res.saveReservation(driver, test);
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Create Tax", testName, "TaxExempt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Create Tax", testName, "TaxExempt");
		}

	}

	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("Taxes and Tax Exempt",excel);
	}




}
