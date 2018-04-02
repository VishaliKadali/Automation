package com.innroad.inncenter.test;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReservationWithSplitRooms extends testCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("ReservationWithSplitRooms", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");	
	}

	// Create split reservation
	@Test(dataProvider="getData", groups="Somke")
	public void reservationWithSplitRooms(String url,String ClientCode, String Username, String Password,String MarketSegment,String Referral,String FirstName,String LastName,String Line1, String City, String State, String Country,String Postalcode,String Phonenumber, String PaymentMethod,String AccountNumber,String ExpiryDate,String BillingNotes,String Nights,String Adults,String Children,String CheckorUncheckAssign,String RoomClassName,String RoomClassName2 ){

		Reservation res = new Reservation();
		

		try{
			ExtentTest test = extent.startTest("Reservation with Split Rooms", "Reservation with Split Rooms")
					.assignCategory("Reservation with Split Rooms")
					.assignCategory("Smoke");

			System.out.println("Executing: " + test.getTest().getName()+ " test.");

			// Login to InnCenter
			try{
				Login LOGIN = new Login();
				LOGIN.login(driver,url, ClientCode, Username, Password);
				test.log(LogStatus.PASS, "System successfully logged in the site");
			}catch(Exception e){
				System.out.println(e);
				test.log(LogStatus.FAIL, "System fail to login");
			}


			// Clicking on New Reservation
			try{
				res.clickNewReservationButton(driver);
				test.log(LogStatus.PASS, "Successfully clicked on New Reservation");
				System.out.println("successfully clicked on new reservation");
			}catch(Exception e){
				System.out.println("************* Failed to click new reservation **************");
				e.printStackTrace();
			}

			// fill the marketing info
			try{
				res.marketingInfo(driver, test,MarketSegment, Referral);
			
				System.out.println("successfully filled the market info");
			}catch(Exception e){
				System.out.println("************* Failed to fill the market info **************");
				e.printStackTrace();
			}
			
			// fill the contact info
			try{
				res.contactInformation(driver, test, FirstName, LastName, Line1, City, Country, State, Postalcode, Phonenumber);
			
				System.out.println("successfully filled the contact info");
			}catch(Exception e){
				System.out.println("************* Failed to fill the contact info **************");
				e.printStackTrace();
			}
			
			// Fill the payment info
			try{
				res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
				System.out.println("successfully filled the payment info");
			}catch(Exception e){
				System.out.println("************* Failed to fill the payment info **************");
				e.printStackTrace();
			}
			
			//Fill the room details
			
			try{
				res.roomAssignment(driver, test, Nights, Adults, Children,  CheckorUncheckAssign, RoomClassName, RoomClassName2);
				System.out.println("successfully filled the room info");
			}catch(Exception e){
				System.out.println("************* Failed to fill the room info **************");
				e.printStackTrace();
			}
			

			try{
				res.saveReservation(driver,test);
				res.GetReservationnumber(driver,test);
				res.clickGuestInfo(driver,test);
				res.getNotesCreated(driver,test);
			}catch(Exception e){
				System.out.println("************* Failed to save reservation **************");
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception");

		}

	}
	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("Reservation with Split Rooms",excel);
	}

}
