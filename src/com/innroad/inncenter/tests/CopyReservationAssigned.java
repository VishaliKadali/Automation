package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationCopy_Assigned;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CopyReservationAssigned extends TestCore{
			
@BeforeTest
	public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
		}
	
	 
@Test(dataProvider="getData")
	public void copyReservationAssigned(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData
			
			) throws InterruptedException, IOException
	{
 	 test = extent.startTest("CopyReservationAssigned", "create assigned Reservation copy")
 			 				 .assignCategory("CopyReservationAssigned")
 			 				 .assignCategory("Regression");
 	 
 	String testName=test.getTest().getName().toUpperCase();
	
	app_logs.info("##################################################################################");
	app_logs.info("EXECUTING: " + testName + " TEST.");
	app_logs.info("##################################################################################");

 	 
 	 try
	     {
 		Login LOGIN = new Login();
		LOGIN.login(driver, url, ClientCode, Username, Password);
		test.log(LogStatus.PASS, "Logged into the application");
		app_logs.info("Logged into the application");
	     } 
 	 	catch (Exception e) {
        Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
 	 	} 
 	 
	  try
	     {
	     Reservation res = new  Reservation();
	     res.IPropertySelector(driver,PropertyName);
	     test.log(LogStatus.PASS, "Property Selection Success");
	     app_logs.info("Selected the Property");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
	     }
	     
	     
	   try
	     {
	     Reservation res = new  Reservation();
	     res.clickNewReservationButton(driver);
	     test.log(LogStatus.PASS, "Clicked new Reservation button");
	     app_logs.info("Clicked new Reservation button");
	     }
	     catch (Exception e) {
	     Utility.updateReport(e, "Failed to Click New Reservation button", testName, "New_Reservation");
	 	 } catch (Error e) {
	     Utility.updateReport(e, "Failed to Click New Reservation button", testName, "New_Reservation");
	 	 }
	     
	     try
	     {
	     Reservation res = new  Reservation();  
	     res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	     test.log(LogStatus.PASS, "Entered the required marketing Info ");
	     app_logs.info("Entered the required marketing Info");
	     }
	     catch (Exception e) {
		  Utility.updateReport(e, "Failed to enter Marketing Information", testName, "Marketing_Info");
		 } catch (Error e) {
		  Utility.updateReport(e, "Failed to enter Marketing Information", testName, "Marketing_Info");
		 }
	     
	     try
	     {
	     Reservation res = new  Reservation(); 
	     res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
	     test.log(LogStatus.PASS, "Entered required contact Information");
	     app_logs.info("Entered required contact Information");
	     }
	     
	     catch (Exception e) {
			  Utility.updateReport(e, "Failed to enter Contact Information", testName, "Contact_Information");
			 } catch (Error e) {
			  Utility.updateReport(e, "Failed to enter Contact Information", testName, "Contact_Information");
			 }
	     
	     try
	    {
	     Reservation res = new  Reservation(); 
	     res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	     test.log(LogStatus.PASS, "Enter the Billing Information ");
	     app_logs.info("Entered required Billing Information");
	     
	     }
	     catch (Exception e) {
			  Utility.updateReport(e, "Failed to enter Billing Information", testName, "Billing_Information");
			 } catch (Error e) {
			  Utility.updateReport(e, "Failed to enter Billing Information", testName, "Billing_Information");
			 }
	    
	     
	     
	     try
		    {
		     ReservationCopy_Assigned res = new  ReservationCopy_Assigned();
		     res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
		     test.log(LogStatus.PASS, "Room Assignment is Successful");
		     app_logs.info("Room Assignment is Successful");
		     }
	     	catch (Exception e) {
			  Utility.updateReport(e, "Failed to Assign Room", testName, "Room_Assignment");
			 } catch (Error e) {
			  Utility.updateReport(e, "Failed to Assign Room", testName, "Room_Assignment");
			 }
		     
	     try
		    {
		     ReservationCopy_Assigned res = new  ReservationCopy_Assigned();
		     res.saveReservation(driver);
		     test.log(LogStatus.PASS, "Saved the reservation details");
		     app_logs.info("Successfully Saved the Reservation Details");
		     }
	     	catch (Exception e) {
				  Utility.updateReport(e, "Failed to Save the Reservation Details", testName, "Save_Reservation");
				 } catch (Error e) {
				  Utility.updateReport(e, "Failed to Save the Reservation Details", testName, "Save_Reservation");
				 }
	     try
		    {
		     ReservationCopy_Assigned res = new  ReservationCopy_Assigned();
		     res.copyReservation(driver);
		     test.log(LogStatus.PASS, "Copied the Reservation ");
		     app_logs.info("Copy of Reservation is successful ");
		     }
	     		catch (Exception e) {
				  Utility.updateReport(e, "Failed to Copy the Reservation", testName, "Copy_Reservation_Assigned");
				 } catch (Error e) {
				  Utility.updateReport(e, "Failed to Copy the Reservation", testName, "Copy_Reservation_Assigned");
				 }
	 
	     extent.endTest(test);
 	
	}

@DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("CopyReservationAssigned",excel);
	}

			}
	

