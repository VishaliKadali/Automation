package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.SourceStatus;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class SourceDefaultStatus extends TestCore{
	

		
		 @BeforeTest
		public void checkRunMode(){
				
			 String testName=this.getClass().getSimpleName().trim();
				app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
				if (!Utility.isExecutable(testName, excel))
					throw new SkipException("Skipping the test - "+ testName);
				
				}

		 @Test(dataProvider="getData")
			public void changeSourceDefaultStatus(String url,String ClientCode, String Username, String Password, String PropertyName1, String selectProperty, String MarketSegment, String  Referral, String Travel_Agent,String ExtReservation, String saluation, String FirstName,String LastName,String Address,String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode, String Phonenumber,String alternativenumber, String Email, String Account,String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,String ExpiryDate, String BillingNotes, String PropertyName,String Nights, String Adults,String Children,String RatepromoCode,String CheckorUncheckAssign, String RoomClassName,String  RoomNumber) throws InterruptedException, IOException
			
			{
			
			test = extent.startTest("changeSourceDefaultStatus", " Change default status for Source")
					 				 .assignCategory("SourceDefaultStatus")
					 				 .assignCategory("Regression");
			 
			 String testName=test.getTest().getName().toUpperCase();
				
				app_logs.info("##################################################################################");
				app_logs.info("EXECUTING: " + testName + " TEST.");
				app_logs.info("##################################################################################");
			 
			 //**************** Login*******************//
			 
			 try{

				 Login LOGIN = new Login();
					LOGIN.login(driver, url, ClientCode, Username, Password);
					test.log(LogStatus.PASS, "Logged into the application");
					app_logs.info("Logged into the application");
				     } 
			 	 	catch (Exception e) {
			        Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
			 }
			 
			 
			     
		    
			//*******************Select Property ****************//
			 try
			 {

				 SourceStatus source = new SourceStatus();
				 source.selectProperty(driver,PropertyName1);
			     test.log(LogStatus.PASS, "Property Selection Success");
			     app_logs.info("Selected the Property");
			     }
			     catch (Exception e) {
			         Utility.updateReport(e, "Failed to Select Property", testName, "selectProperty");
			     } catch (Error e) {
			         Utility.updateReport(e, "Failed to Select Property", testName, "selectProperty");
			     }
			 

		 	 //*********************Select the Property******************//	
			     try
			     {
			    	 Reservation res = new  Reservation();
				     res.IPropertySelector(driver,selectProperty);
				     test.log(LogStatus.PASS, "Property Selection Success");
				     app_logs.info("Selected the Property");
				     }
				     catch (Exception e) {
				         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
				     } catch (Error e) {
				         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
				     }
			 
			 //*****************Navigate to Inventory Distribution*************************//
			 
			try
			 	{
				   SourceStatus source= new SourceStatus();
				   source.inventory_Distribution(driver);
				   test.log(LogStatus.PASS, "System successfully Navigated to Inventory Distribution");
				   app_logs.info("Successfully Navigated to Inventory Distribution");
			 	}
				catch (Exception e) {
		         Utility.updateReport(e, " Fail to Navigate Inventory Distribution", testName, "Inventory_Distribution");
				} catch (Error e) {
		         Utility.updateReport(e, " Fail to Navigate Inventory Distribution", testName, "Inventory_Distribution");
				}
					
			
			//******************Select the required fields in  Inventory Distribution and Save the Reservation *************************//
			try
		 		{
			    	SourceStatus source= new SourceStatus();
			    	source.channels(driver);
			    	test.log(LogStatus.PASS, "System successfully Verified Channels in distrubution");
			    	app_logs.info("Successfully Verified Channels in distrubution");
		 		}
			
			catch (Exception e) {
		         Utility.updateReport(e, " Fail to verify Channels in Distribution ", testName, "SourceChannels");
				} catch (Error e) {
		         Utility.updateReport(e, " Fail to verify Channels in Distribution ", testName, "SourceChannels");
				}
			
			
			try
		 		{
			    	SourceStatus source= new SourceStatus();
			    	source.navigateReservation(driver) ;
			    	test.log(LogStatus.PASS, "System successfully Navigated to Reservation");
			    	app_logs.info("Successfully Navigated to Reservation");
		 		}
				catch (Exception e) {
		         Utility.updateReport(e, " Failed to Navigate to Reservation ", testName, "NavigateReservation");
				} catch (Error e) {
		         Utility.updateReport(e, " Failed to Navigate to Reservation  ", testName, "NavigateReservation");
				}
			
			
			try
		 	{
				Reservation res = new  Reservation();
		    	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
		    	 app_logs.info("Entered required Marketing Information");
		    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
		    	 app_logs.info("Entered Contact Information");
		    	 res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
		    	 app_logs.info("Entered Billing Information");
		    	 res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
		    	 app_logs.info("Room assignment is successful");
		    	 test.log(LogStatus.PASS, "Entered required fields in Reservation");
		    	 app_logs.info("Entered required fields in Reservation");
			     }
				catch (Exception e) {
		         Utility.updateReport(e, " Failed to Enter the required details in Reservation ", testName, "Reservation");
				} catch (Error e) {
		         Utility.updateReport(e, " Failed to Enter the required details in Reservation  ", testName, "Reservation");
				}
			
			
			try
		 	{
				SourceStatus source = new SourceStatus();
				source.saveSourceReservation(driver);
		    	 test.log(LogStatus.PASS, " Saved the Reservation ");
		    	 app_logs.info("Saved the Reservation");
			     }
				catch (Exception e) {
		         Utility.updateReport(e, " Failed to save the reservation ", testName, "Save_Reservation");
				} catch (Error e) {
		         Utility.updateReport(e, " Failed to save the reservation  ", testName, "Save_Reservation");
				} 
				
			  try {
				  SourceStatus source = new  SourceStatus();
				  source.verify_reservaionStatus(driver);
				  test.log(LogStatus.PASS, "Verifed Reservation Status and Source Status ");
				  app_logs.info("Successfully Verifed Reservation Status and Source Status");
			  		}
			  	catch (Exception e) {
			    Utility.updateReport(e, " Failed to Verify Reservation Status and Source Status ", testName, "Verify_ReservationStatus_SourceStatus");
					} 
			  	catch (Error e) {
			    Utility.updateReport(e, " Failed to Verify Reservation Status and Source Status ", testName, "Verify_ReservationStatus_SourceStatus");
					}
			  
			  try {
				  SourceStatus source = new  SourceStatus();
				  source.changeStatusToDefault(driver);
				  test.log(LogStatus.PASS, " Changed the Status to Default ");
				  app_logs.info("Changed the Status to Default");
			  		}
			  	catch (Exception e) {
			    Utility.updateReport(e, " Failed to Change the status to Default ", testName, "changeStatusToDefault");
					} 
			  	catch (Error e) {
			    Utility.updateReport(e, " Failed to Change the status to Default ", testName, "changeStatusToDefault");
					}
			 
			extent.endTest(test); 
			 
			}
		 
		 
		 
		 
		 @DataProvider
			public Object [][] getData(){
				
				//return test data from the sheetname provided
				
				return Utility.getData("SourceDefaultStatus",excel);
				
			}

}
	
