package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.RateQuote;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote_Book_Quote extends TestCore{
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("RateQuote_Book_Quote", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
		
	}
	
	
	 @Test(dataProvider="getData")
		public void CreateReservationfromRateQuoteBookicon(String url,String ClientCode, String Username, String Password, String propertyName, String RateQuoteNights, String RateQuoteAdults, String
				RateQuoteChildren, String RateQuoteRatePlanList, String RateQuotePromoCode, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation, 
				String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode,
				String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext, String Attachment, String PaymentMethod, String AccountNumber,
				String ExpiryDate, String BillingNotes	) throws InterruptedException, IOException {
		 
		 ExtentTest test = extent.startTest("RateQuote_Book_Quote", "RateQuote_Book_Quote")
 				 				 .assignCategory("RateQuote")
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
	          
            /* try
             {
	    	 Reservation res = new Reservation();
	    	 res.IPropertySelector(driver, propertyName);
	    	 test.log(LogStatus.PASS, "Property Selection Success");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to select property"); 
		     }*/
             
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
	    	 rateQuotePage.searchDetails(driver,test, RateQuoteNights, RateQuoteAdults, RateQuoteChildren, RateQuoteRatePlanList, RateQuotePromoCode); 
	    	 rateQuotePage.SearchRateQuoteDetails(driver,test);
	    	 test.log(LogStatus.PASS, "Available Filter room classes");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to filter available rooms"); 
		     }
             
             try
             {
	    	 RateQuote rateQuotePage=new RateQuote();
	    	 rateQuotePage.clickQuoteIcon(driver,test);
	    	 //test.log(LogStatus.PASS, "Click on Quote Icon");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to click Quote icon"); 
		     }
             
           //  try
           //  {
             Reservation res = new Reservation();
	    	 res.marketingInfo(driver,test, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 res.contactInformation(driver, test,saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	         res.billingInformation(driver, test,PaymentMethod, AccountNumber, ExpiryDate, BillingNotes);
	    	 res.saveReservation(driver,test);
	    	 res.clickBook(driver);
	    	 res.saveReservationQuote(driver, test);
	    	 res.manualEmail(driver, test,Email, Attachment);
	    	 res.GetReservationnumber(driver,test);
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
			
			return Utility.getData("RateQuote_Book_Quote",excel);
		}
}
