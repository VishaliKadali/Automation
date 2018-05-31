package com.innroad.inncenter.tests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.Reservation_WithPromoCode;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation_PromoCode extends TestCore {

	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
		}
	 

	 @Test(dataProvider="getData")
		public void createResWithPromoCode(String url,String ClientCode, String Username, String Password,String PropertyName, String TapeChartAdults, String TapeChartChildrens, String PromoCode, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,String FirstName, String LastName, String Address, String Line1,String  Line2, String Line3, String City,String Country,String State, String Postalcode, String Phonenumber,String alternativenumber, String Email, String Account,String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber, String ExpiryDate, String BillingNotes, String Reason) throws InterruptedException, IOException
		{
			
		 test = extent.startTest("Reservation_PromoCode", "Create Reservation with Promocode")
				 				 .assignCategory("Promocode")
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
	    	
			Reservation_WithPromoCode  res_promo= new Reservation_WithPromoCode();
			res_promo.clickTapeChart(driver);
	    	 
	    	 test.log(LogStatus.PASS, "Navigated to Tapechart ");
	    	 app_logs.info("Navigated to Tapechart successfully");
         }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Navigate to Tapechart", testName, "Navigate_Tapechart");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Navigate to Tapechart", testName, "Navigate_Tapechart");
	     }	
  		
		 
		 try
    	 {
		Reservation_WithPromoCode res_promo= new Reservation_WithPromoCode();
		res_promo.checkAvailabilityWithPromoCode(driver, TapeChartAdults, TapeChartChildrens,PromoCode);
		//res_promo.click_availableRoomClass(driver);
		Thread.sleep(5000);
		res_promo.click_availableRoom(driver);
		Thread.sleep(5000);
    	test.log(LogStatus.PASS, "Checked the availability of Reservation with Promocode ");
    	 app_logs.info("Checked the availability of Reservation with Promocode");
    	 }	
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to check the availability rooms of Reservation with Promocode ", testName, "Reservation_Promo");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to check the availability rooms of Reservation with Promocode ", testName, "Reservation_Promo");
	     }	
  	
		 
		 try
		    {
		     Reservation res = new  Reservation();
	    	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 app_logs.info("Entered Marketing Info");
	    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
	    	 app_logs.info("Entered Contact Info");
	    	 res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	    	 app_logs.info("Entered Billing Info");
	    	 res.saveReservation(driver);
	    	 test.log(LogStatus.PASS, "Enter required fields and saved the reservation");
	    	 app_logs.info("Enter required fields and saved the reservation");
		     }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to save the reservation ", testName, "Save_Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to save the reservation ", testName, "Save_Reservation");
	     }	
		 	 
		 try
		 {
			 Reservation_WithPromoCode res_promo = new  Reservation_WithPromoCode();
			 res_promo.cancelReservation(driver, Reason);
			 test.log(LogStatus.PASS, " Cancelled the Reservation ");
			 app_logs.info("Cancelled the Reservation");
		 } 
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to Cancel the reservation ", testName, "Cancel_Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Cancel the reservation ", testName, "Cancel_Reservation");
	     }	
		 
	      extent.endTest(test);  
	     }


		@DataProvider
			public Object [][] getData()
			{
				//return test data from the sheetname provided
				
				return Utility.getData("Reservation_PromoCode",excel);
			}
		
}
