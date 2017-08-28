package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.ReservationFolio;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation_CashPayment extends testCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("CheckinCheckoutReservation", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 @Test(dataProvider="getData")
		public void Reservation_cashPayment (String url,String ClientCode, String Username, String Password,String PropertyName, String MarketSegment, String Referral, String Travel_Agent, String  ExtReservation,
				String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode, String Phonenumber,
				String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext, String Nights, String Adults, String Children, String RatepromoCode, String CheckorUncheckAssign, String
				RoomClassName, String RoomNumber, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData
				
				
				) throws InterruptedException, IOException{
		 ExtentTest test = extent.startTest("Reservation_CashPayment","Creating reservation with payment method as cash")
								 .assignCategory("Reservations")
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
	     res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	     res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	     res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign, RoomClassName, RoomNumber);
	     res.saveReservation(driver);
	     ReservationFolio rs = new ReservationFolio();
         rs.paymentMethod(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
	     Wait.wait15Second();
	     res.saveReservation(driver);
	     test.log(LogStatus.PASS, "Create Reservation with cash Success");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to Create Reservation"); 
	     }
	     
	    
	     extent.endTest(test);	 
	   }
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Reservation_CashPayment",excel);
		}

}
