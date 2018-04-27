package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Delete_Reservation extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("Delete_Reservation", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 
	 
	 @Test(dataProvider="getData")
		public void delete_Reservation(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
				String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
				String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
				String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
				Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData
				
				) throws InterruptedException, IOException
		{
	    	 ExtentTest test = extent.startTest("delete_Reservation", "Deleting Reservation")
	    			 				 .assignCategory("Reservations")
	    			 				 .assignCategory("Smoke");
	    	 
	    	 System.out.println("Executing: " + test.getTest().getName()+ " test.");
	    	 
	    	String ResConfirmation_number ="";
	    	 
	    	 try{
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 test.log(LogStatus.PASS, "Login successfully");
		     }
		     catch(Exception e){
		    	 test.log(LogStatus.FAIL, "Login unsuccess"); 
		     }
	          
		     try
		     {
		     Reservation res = new  Reservation();
	    	 res.IPropertySelector(driver,PropertyName);
	    	 test.log(LogStatus.PASS, "Property Selection Success");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to select property"); 
		     }
		     
		     try
		     {
		     Reservation res = new  Reservation();
	    	 res.clickNewReservationButton(driver);
	    	 test.log(LogStatus.PASS, "Click new Reservation button");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to click new reservation button"); 
		     }
		     
		     try
		    {
		     Reservation res = new  Reservation();
	    	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
	    	 res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	    	 res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
	    	 res.saveReservation(driver);
	    	 ResConfirmation_number = res.GetReservationnumber(driver);
	   	     test.log(LogStatus.PASS, "Enter required fields and save the reservation");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to save the reservation"); 
		     }
		     
		     
		     try
			  {
			   Reservation res = new  Reservation();
			   res.Cancel_Reservation(driver);
		       test.log(LogStatus.PASS, "Canceled the reservation");
			  }
			   catch(Exception e)
			  {
			     test.log(LogStatus.FAIL, "Fail to Cancel the reservation"); 
			  } 
		     
		       try
			     {
		    	  Reservation res = new  Reservation();
		  	      res.Close_Tab(driver); 
			      test.log(LogStatus.PASS, "Navigating to Reservation");
			     }
			     catch(Exception e)
			     {
			    	 test.log(LogStatus.FAIL, "Fail Navigate Reservations"); 
			     }
		       
		     try
		      {
			    	ReservationSearch res_Serach= new ReservationSearch();
			    	res_Serach.basicSearch_WithResNumber(driver);
			    	test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");					
		      }
			    catch(Exception e)
		      {
			    	 test.log(LogStatus.FAIL, "System fail to validate Basic Search with Reservation number");
		      }
		     
		     
		     try
		      {
			    	ReservationSearch res_Serach= new ReservationSearch();
			    	res_Serach.delete_Res_WithResNumber(driver, ResConfirmation_number);
			    	test.log(LogStatus.PASS, "Sucessfully Deleted Reservation");										
		      }
			    catch(Exception e)
		      {
			    	 test.log(LogStatus.FAIL, "failed to Delete  the given Reservation");
		      }
		    
		     
		     extent.endTest(test);
	    	
		}
	
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Delete_Reservation",excel);
		}
	

}
