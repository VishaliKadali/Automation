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
import com.innroad.inncenter.webelements.Elements_MovieFolio;
import com.relevantcodes.extentreports.LogStatus;

public class MoveFolioItemsAccrossReservations extends TestCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	// Move folio items inside the reservation
	@Test(dataProvider="getData", groups="Regression")
	public void MoveFolioItemsAccrossRes(String url,String ClientCode, String Username, String Password,String MarketSegment,String Referral,String FirstName,String LastName,String Line1, String City, String State, String Country,String Postalcode,String Phonenumber, String PaymentMethod,String AccountNumber,String ExpiryDate,String BillingNotes,String Nights,String Adults,String Children,String CheckorUncheckAssign,String RoomClassName) throws InterruptedException, IOException{


		test = extent.startTest("MoveFolioItemsAccrossReservations", "MoveFolioItemsAccrossReservations")
				.assignCategory("Folio")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		String resNumber1 = null,resNumber2 = null;

		Login 				LOGIN 		= new Login();
		Folio 				folio 		= new Folio();
		Reservation 		res 		= new Reservation();
		Elements_MovieFolio moveFolio 	= new Elements_MovieFolio(driver);

		Double d = null,d2=null;

		// Login to InnCenter
		try{
			LOGIN.login(driver,url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "System successfully logged in the site");
			app_logs.info("System successfully logged in the site");
		}catch(Exception e){

			test.log(LogStatus.FAIL, "System fail to login");
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
			res.marketingInfo(driver, test, MarketSegment, Referral);


		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		}

		// fill the contact info
		try{
			res.contactInformation(driver, test, FirstName, LastName, Line1, City, Country, State, Postalcode, Phonenumber);

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		}

		// Fill the payment info
		try{
			res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		}

		//Fill the room details
		try{
			res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign, RoomClassName);

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		}


		try{
			res.saveReservation(driver,test);
			resNumber1=res.GetReservationnumber(driver,test);

			d=res.get_FolioBalance(driver);
			moveFolio.FirstOpenedReservationClose.click();

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
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
			res.marketingInfo(driver, test, MarketSegment, Referral);


		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Market Info", testName, "MarketInfo");
		}

		// fill the contact info
		try{
			res.contactInformation(driver, test, FirstName, LastName, Line1, City, Country, State, Postalcode, Phonenumber);

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Contact Info", testName, "ContactInfo");
		}

		// Fill the payment info
		try{
			res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Payment Info", testName, "PaymentInfo");
		}

		//Fill the room details
		try{
			res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign, RoomClassName);

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Fill Room Info", testName, "RoomInfo");
		}


		try{
			res.saveReservation(driver,test);
			resNumber2=res.GetReservationnumber(driver,test);
			d2=res.get_FolioBalance(driver);
			moveFolio.FirstOpenedReservationClose.click();
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Save Reservarion", testName, "SaveReservarion");
		}
		//Move folio items across the reservations
		try{
			folio.MoveFolioInsideReservation(driver, test, resNumber1, resNumber2,d,d2);

		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Move Folio Items", testName, "FolioItems");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Move Folio Items", testName, "FolioItems");
		}

	}

	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("Move Folio Accross Reservations",excel);
	}

}
