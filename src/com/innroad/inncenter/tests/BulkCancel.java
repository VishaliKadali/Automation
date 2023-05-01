package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.FolioLineItems;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.pageobjects.ReservationSearchCopy;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class BulkCancel extends TestCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			
			
		}
	
	 
@Test(dataProvider="getData")
	public void bulkCancel(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData) throws InterruptedException, IOException
	{
	 test = extent.startTest("BulkCancel", "Bulk Cancel of Reservation ")
			 				 .assignCategory("BulkCancellation")
			 				 .assignCategory("Regression");
	 
	 String testName=test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
		Login LOGIN = new Login();
		Reservation res = new  Reservation();
		ReservationSearchCopy assignRoom = new  ReservationSearchCopy();
		FolioLineItems resNumber = new  FolioLineItems();
		ReservationSearch 	advancedSearch	= new ReservationSearch();
	
	/*	create reservation
		Cancel reservation without void room charges
		search reservation
		validation with 1. Cancel status 
			2.Folio line item
		Roll back the reservation
		Go to dashboard
		search reservation
		select bulk cancel with void charges
		search reservation
		validation with 1. Cancel status 
			2.Folio line item
			*/
		//*********************Login******************//		
	 try
	     {
		
		LOGIN.login(driver, url, ClientCode, Username, Password);
		test.log(LogStatus.PASS, "Logged into the application");
		app_logs.info("Logged into the application");
	     } 
	 	catch (Exception e) {
     Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
	     }
   
	 
	     
	   //*********************Click New Reservation button******************//
	     
	     try
	     {
	     
	     res.clickNewReservationButton(driver);
	     test.log(LogStatus.PASS, "Clicked on new Reservation button");
	     app_logs.info("Clicked on new Reservation button");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Fail to click new reservation button", testName, "New_Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to click new reservation button", testName, "New_Reservation");
	     }
	     
	     
	     
	   //*********************Enter Marketing Information ******************//	  
	     try
	     {
	     
	     res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	     test.log(LogStatus.PASS, " Entered Marketing Info details ");
	     app_logs.info(" Entered Marketing Info details");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Fail to Enter Marketing Info Details", testName, "MarketingInfo");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Enter Marketing Info Details", testName, "MarketingInfo");
	     }
	     
	   //*********************Enter Contact Information ******************//	  
	     try
	     {
	     
	     res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
	     test.log(LogStatus.PASS, " Entered Contact Information ");
	     app_logs.info(" Entered Contact Information");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Fail to Enter Contact Information", testName, "contactInformation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Enter Contact Information", testName, "contactInformation");
	     }
	     
	     //*********************Enter Billing Information ******************// 
	     try
	     {
	     
	     res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	     test.log(LogStatus.PASS, " Enter Billing Information ");
	     app_logs.info(" Entered Billing Information ");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Fail to Enter Billing Information", testName, "BillingInformation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Enter Billing Information", testName, "BillingInformation");
	     }
	   
	     
	     
	     //*********************Assign Rooms ******************//
	     try
		    {
		    
	    	 assignRoom.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
		     test.log(LogStatus.PASS, "Room Assignment is Successful");
		     app_logs.info("Room Assignment is Successful");
		     }
	     	catch (Exception e) {
	         Utility.updateReport(e, "Failed to Assign Room ", testName, "Room_Assignment");
	     	} catch (Error e) {
	         Utility.updateReport(e, "Failed to Assign Room ", testName, "Room_Assignment");
	     	}
		  
	     
	     //*********************Save the Reservation Details ******************//  
	     try
	    {
	    
	     res.saveReservation(driver);
	 
	     test.log(LogStatus.PASS, " Save the Reservation ");
	     app_logs.info(" Created Reservation Successfully ");
	     }
	     
	     catch (Exception e) {
	         Utility.updateReport(e, " Fail to Save the Reservation", testName, "SaveReservation");
	     } catch (Error e) {
	         Utility.updateReport(e, " Fail to Save the Reservation", testName, "SaveReservation");
	     }
	    
	     //************************get Reservation Number************************//
	     try
		    {
	    	 
	    	 resNumber.getReservationNumber(driver);
	    	 test.log(LogStatus.PASS, " Copied Reservation Number ");
		     app_logs.info(" Copied Reservation Number ");
		     }
		     
		     catch (Exception e) {
		         Utility.updateReport(e, "Copied Reservation Number Successfully", testName, "ReservationNumber");
		     } catch (Error e) {
		         Utility.updateReport(e, " Fail to Copy the Reservation number", testName, "ReservationNumber");
		    
		     }
	     
	     
			//***********************Close the Reservation**************************// 
			 try
			 {
				 advancedSearch.closeReservation(driver);
				 test.log(LogStatus.PASS, "Closed the Reservation Successfully");
				 app_logs.info("Closed the Reservation");
			}
			catch (Exception e) {
				Utility.updateReport(e, "Fail to close the Reservation", testName, "closeReservation");
			} catch (Error e) {
				Utility.updateReport(e, "Fail to close the Reservation", testName, "closeReservation");
			}
			
			 //************************Search the Reservation***************************//
	     
			 
			 try
			 {
				 advancedSearch.searchReservation(driver);
				 test.log(LogStatus.PASS, "Reservtaion Search Successful");
				 app_logs.info("Reservtaion Search Successful");
			}
			catch (Exception e) {
				Utility.updateReport(e, " Fail to Search the Reservation ", testName, " searchReservation ");
			} catch (Error e) {
				Utility.updateReport(e, " Fail to Search the Reservation ", testName, " searchReservation ");
			}
			 
			 
		//********************************Select the Reservation and Bulk Cancel****************************//
			 try
		     
			    {
		    	 ReservationSearch lineItems = new  ReservationSearch();
		    	 lineItems.selectBulkCancel(driver);
			 
			     test.log(LogStatus.PASS, " Bulk Cancellation Successful ");
			     app_logs.info("  Bulk Cancel of Reservation is successful ");
			     }
			     
			     catch (Exception e) {
			         Utility.updateReport(e, " Fail to bulk cancel the Reservation ", testName, "BulkCancellation");
			     } catch (Error e) {
			         Utility.updateReport(e, " Fail to bulk cancel the Reservation ", testName, "BulkCancellation");
			     }   
			 
			 
			 
			 
			 //******************************Folio line Items without void room charges******************//
			 try
	     
		    {
	    	 ReservationSearch lineItems = new  ReservationSearch();
	    	 lineItems.verifyBulkCancelWithoutVoidRoomCharges(driver);
		 
		     test.log(LogStatus.PASS, " Verififcation of Bulk Cancel without Void Room Charges Successful ");
		     app_logs.info(" Verification of Bulk Cancel without Void room charges is successful ");
		     }
		     
		     catch (Exception e) {
		         Utility.updateReport(e, " Fail to Verify Bulk Cancel without Void Room Charges ", testName, "BulkCancelVoidRoomCharges");
		     } catch (Error e) {
		         Utility.updateReport(e, " Fail to Verify Bulk Cancel without Void Room Charges ", testName, "BulkCancelVoidRoomCharges");
		     }  
			 
		
			 //********************************Open Reservation*********************************//
			/* try
			 {
				 ReservationSearch.openReservation(driver);
				 test.log(LogStatus.PASS, " Clicked on Reservation Successfully ");
				 app_logs.info("Clicked on Reservation Successfully ");
			}
			catch (Exception e) {
				Utility.updateReport(e, "Fail to Click the Reservation ", testName, "openReservation");
			} catch (Error e) {
				Utility.updateReport(e, "Fail to Click the Reservation ", testName, "openReservation");
			}*/
	     
			 try
		     
			    {
		    	 ReservationSearch lineItems = new  ReservationSearch();
		    	 lineItems.rollbackReservation(driver);
			 
			     test.log(LogStatus.PASS, " Rolled back the Reservation Succesfully ");
			     app_logs.info(" Reservation Rolled back Successfully ");
			     }
			     
			     catch (Exception e) {
			         Utility.updateReport(e, " Fail to Rollback the Reservation ", testName, "ReservationRollBack");
			     } catch (Error e) {
			         Utility.updateReport(e, " Fail to Rollback the Reservation ", testName, "ReservationRollBack");
			     }  
				 
			 
			 //*********************Folio line Items with void room charges*****************************//
			 try
		    {
	    	 ReservationSearch lineItems = new  ReservationSearch();
	    	 lineItems.verifyBulkCancelWithVoidRoomCharges(driver);
		 
		     test.log(LogStatus.PASS, " Verififcation of Bulk Cancel with Void Room Charges Successful ");
		     app_logs.info(" Verification of Bulk Cancel with Void room charges is successful ");
		     }
		     
		     catch (Exception e) {
		         Utility.updateReport(e, " Fail to Verify Bulk Cancel with Void Room Charges ", testName, "BulkCancelVoidRoomCharges");
		     } catch (Error e) {
		         Utility.updateReport(e, " Fail to Verify Bulk Cancel with Void Room Charges ", testName, "BulkCancelVoidRoomCharges");
		     }  
			 
			 
	     
   
	     extent.endTest(test);
	
	}

@DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("BulkCancel",excel);
	}
			  

	

}
