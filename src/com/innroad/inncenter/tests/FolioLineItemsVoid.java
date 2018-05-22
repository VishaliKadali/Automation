package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.FolioLineItems;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class FolioLineItemsVoid extends TestCore {
	
	

	@BeforeTest
		public void checkRunMode(){
			
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
		
		}
	
	 
 @Test(dataProvider="getData")
	public void folioLineItemsVoid(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData, String Category, String Amount, String Notes) throws InterruptedException, IOException
		
 
 		{
	 	 test = extent.startTest("FolioLineItemsVoid", "Folio Line Items Void")
	 			 				 .assignCategory("FolioLineItemsVoid")
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
     //**********************Select the Property*******************//  
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
		    	 FolioLineItems res = new  FolioLineItems();
	 	 res.clickNewReservationButton(driver);
	 	 test.log(LogStatus.PASS, "Clicked new Reservation button");
	 	 app_logs.info(" Clicked on New Reservation button ");
		 }
	     catch (Exception e) {
	         Utility.updateReport(e, "Failed to Click New Reservation", testName, "New_Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Click New Reservation", testName, "New_Reservation");
	     }
	     
	  //*********************Enter the Reservation details and save the Reservation******************//	
	     try
	     {
	    	 FolioLineItems res = new  FolioLineItems();
	    
	 	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	 	app_logs.info("Entered Marketing Information");
	 	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
	 	app_logs.info("Entered Contact Information");
	 	res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	 	app_logs.info("Entered Billing Information");
	 	res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
	 	app_logs.info("Room Assignment Successful");
	 	// res.Guestinfo(driver);
 	 	//res.CheckStayinfocheckbox(driver);
 	 	res.saveReservation(driver);
 	 	app_logs.info("Saved the Reservation");
 	 	test.log(LogStatus.PASS, "Created Reservation Successfully");
 	 	app_logs.info("Created the Reservation");
	     }
	     catch (Exception e) {
	         Utility.updateReport(e, "Failed to Create Reservation", testName, "Create_Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Create Reservation", testName, "Create_Reservation");
	     }
	     
	     
	   //*********************Add the Folio Line Items and Void the Line Items******************//	    
	    try
	    { 
	    	FolioLineItems res=new  FolioLineItems();
	    	res.folioLineItemsVoid(driver, Category, Amount, Notes);
	    	test.log(LogStatus.PASS, " Folio Line Items Void");
	    	app_logs.info("Folio Line Items void is successful");
	    	
	    }
	    
	    catch (Exception e) {
	         Utility.updateReport(e, "Failed to Void Folio Line Items", testName, "FolioLineItems_Void");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Void Folio Line Items", testName, "FolioLineItems_Void");
	     }
	   
	     extent.endTest(test);
 	
 		}

 @DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("FolioLineItemsVoid",excel);
		}


}
