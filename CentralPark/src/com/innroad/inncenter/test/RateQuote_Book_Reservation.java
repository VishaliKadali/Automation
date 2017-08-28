package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.RateQuote;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote_Book_Reservation extends testCore{
	
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("RateQuote_Book_Reservation", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
		
		
		
	}
	
	
	 @Test(dataProvider="getData")
		public void CreateReservationfromRateQuoteBookicon(String url,String ClientCode, String Username, String Password, String propertyName, String RateQuoteNights, String RateQuoteAdults, String
				RateQuoteChildren, String RateQuoteRatePlanList, String RateQuotePromoCode, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation, 
				String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode,
				String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext, String Attachment, String PaymentMethod, String AccountNumber,
				String ExpiryDate, String BillingNotes
				
				
				) throws InterruptedException, IOException
		{
		 
		 ExtentTest test = extent.startTest("RateQuote_Book_Reservation", "Reservation Booking RateQuote")
				 				 .assignCategory("RateQuote")
				 				 .assignCategory("Sanity");
	    
		 System.out.println("Executing: " + test.getTest().getName()+ " test.");
		 
		     try
		     {
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 test.log(LogStatus.PASS, "Login successfully");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Login unsuccess"); 
		     }
	          
             try
             {
	    	 Reservation res = new Reservation();
	    	 res.IPropertySelector(driver, propertyName);
	    	 test.log(LogStatus.PASS, "Property Selection Success");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to select property"); 
		     }
             
             try
             {
	    	 Navigation newQuoteNavigation = new Navigation();
	    	 newQuoteNavigation.NewQuote(driver);
	    	 test.log(LogStatus.PASS, "Navigating to NewQuote page");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate NewQuote"); 
		     }
             
             try
             {
	    	 RateQuote rateQuotePage=new RateQuote();
	    	 rateQuotePage.searchDetails(driver, RateQuoteNights, RateQuoteAdults, RateQuoteChildren, RateQuoteRatePlanList, RateQuotePromoCode); 
	    	 rateQuotePage.SearchRateQuoteDetails(driver);
	    	 test.log(LogStatus.PASS, "Available Filter room classes");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to filter available rooms"); 
		     }
             
             try
             {
	    	 RateQuote rateQuotePage=new RateQuote();
	    	 rateQuotePage.clickBookicon(driver);
	    	 test.log(LogStatus.PASS, "Click on Book Icon");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to click book icon"); 
		     }
             
           //  try
           //  {
             Reservation res = new Reservation();
	    	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	         res.billingInformation(driver, PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	    	 res.saveReservation(driver);
	    	 res.manualEmail(driver, Email, Attachment);
	    	 res.GetReservationnumber(driver);
	    	 test.log(LogStatus.PASS, "Reservation created Success");
		   /*  }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to create reservation"); 
		     }*/
	    	
	    	
             extent.endTest(test);
	 
	    	
	    	
		}
	
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("RateQuote_Book_Reservation",excel);
		}
}
