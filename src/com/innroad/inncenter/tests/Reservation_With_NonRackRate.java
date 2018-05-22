package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationNonRackRate;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation_With_NonRackRate  extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			
			
		}
	
	 
 @Test(dataProvider="getData")
	public void createReservationNonrackRate(String url,String ClientCode, String Username, String Password, String PropertyName,String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName1, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber) throws InterruptedException, IOException
	{
 	 test = extent.startTest("createReservationNonrackRate", "Create reservation with non rack rate ")
 			 				 .assignCategory("ReservationWithRackRate")
 			 				 .assignCategory("Regression");
 	 
 	 String testName=test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
 	 
 	 
 	//*********************Login******************//	  	 
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
      
 	 //*********************Select the Property******************//	
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
	     
	   //*********************Click New Reservation button******************//
	     
	     try
	     {
	     Reservation res = new  Reservation();
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
	     Reservation res = new  Reservation();
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
	     Reservation res = new  Reservation();
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
	     Reservation res = new  Reservation();
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
		     ReservationNonRackRate res = new  ReservationNonRackRate();
		    
	 	
	 	 res.roomAssignment(driver,PropertyName1, Nights, Adults ,Children,RatepromoCode, CheckorUncheckAssign, RoomClassName, RoomNumber);
	 	
	 	 test.log(LogStatus.PASS, " Assigned the Rooms ");
	 	 app_logs.info(" Room Assignment Successful ");
		     }
	     catch (Exception e) {
	         Utility.updateReport(e, " Fail to Assign the Rooms", testName, "RoomAssignment");
	     } catch (Error e) {
	         Utility.updateReport(e, " Fail to Assign the Rooms", testName, "RoomAssignment");
	     }
		  
	     
	     //*********************Save the Reservation Details ******************//  
	     try
	    {
	     Reservation res = new  Reservation();
	     res.saveReservation(driver);
 	 
	     test.log(LogStatus.PASS, " Save the Reservation ");
	     app_logs.info(" Created Reservation Successfully ");
	     }
	     
	     catch (Exception e) {
	         Utility.updateReport(e, " Fail to Save the Reservation", testName, "SaveReservation");
	     } catch (Error e) {
	         Utility.updateReport(e, " Fail to Save the Reservation", testName, "SaveReservation");
	     }
	     
	     extent.endTest(test);
 	
	}

 @DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("Reservation_With_NonRackRate",excel);
	}
			  

}
