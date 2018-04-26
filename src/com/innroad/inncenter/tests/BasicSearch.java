package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasicSearch extends TestCore {
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("BasicSearch", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	
	
	 @Test(dataProvider="getData", groups="Somke")
		public void login(String url,String ClientCode, String Username, String Password,String PropertyName, String GuestName
				
				
				) throws InterruptedException, IOException
		{
			
		 ExtentTest test = extent.startTest("BasicSearch", "Executing on Training.innroad.com");
		 
		 try{
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 test.log(LogStatus.PASS, "System successfully logged in the site");
		 }
		 catch(Exception e)
		 {
			 test.log(LogStatus.FAIL, "System fail to login");
		 }
	    
           try
           {
	    	 Reservation res= new Reservation();
	    	res.IPropertySelector(driver,PropertyName);
	    	test.log(LogStatus.PASS, "System successfully changed property");
           }
  		 catch(Exception e)
  		 {
  			 test.log(LogStatus.FAIL, "System fail to select Property");
  		 }	
	    	
           try
           {
	    	 ReservationSearch ReservationSearchPage=new ReservationSearch();
	    	 ReservationSearchPage.basicSearch_WithGuestName(driver, GuestName);
	    	 
	    	 test.log(LogStatus.PASS, "System successfully validated Basic Search with Guest Name");
           }
    		 catch(Exception e)
    		 {
    			 test.log(LogStatus.FAIL, "System fail to validate Basic Search with Guest Name");
    		 }	 
	    
           try
           {
        	   ReservationSearch ReservationSearchPage=new ReservationSearch();
  	    	 ReservationSearchPage.basicSearch_WithResNumber(driver);
  	    	test.log(LogStatus.PASS, "System successfully validated Basic Search with Reservation number");
           }
	    catch(Exception e)
           {
	    	 test.log(LogStatus.FAIL, "System fail to validate Basic Search with Reservation number");
           }
           extent.endTest(test);
		}
	 

	 @DataProvider
		public Object [][] getData(){
			//return test data from the sheetname provided
			
			return Utility.getData("BasicSearch",excel);
		}

}
