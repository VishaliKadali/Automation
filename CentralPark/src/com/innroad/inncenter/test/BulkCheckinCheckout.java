package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.ReservationSearch;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BulkCheckinCheckout  extends testCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("BulkCheckinCheckout", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}

	 @Test(dataProvider="getData")
		public void bulkCheckinCheckout(String url,String ClientCode, String Username, String Password,String PropertyName, String GuestName ) throws InterruptedException, IOException {
			
		 ExtentTest test = extent.startTest("BulkCheckinCheckout", "Bulk-Checkin and Bulk-Checkout")
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
	    ReservationSearch ReservationSearchpage= new ReservationSearch();
	    ReservationSearchpage.basicSearch_WithResNumber(driver);
	    ReservationSearchpage.Bulkcheckin(driver, GuestName);
	    test.log(LogStatus.PASS, "Bulk checkin success");
	    }
	    catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to Bulk checkin"); 
	     }
	    
	    try
	    {
	    	 ReservationSearch ReservationSearchpage= new ReservationSearch();
	    ReservationSearchpage.Bulkcheckout(driver, GuestName);
	    test.log(LogStatus.PASS, "Bulk checkout success");
	    }
	    catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to Bulk checkout"); 
	     }
	    extent.endTest(test);
	    	
	    	
		}
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("BulkCheckinCheckout",excel);
		}
	    
}
