package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BulkCancellation extends TestCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!com.innroad.inncenter.utils.Utility.isExecutable("PostLineItem", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");	
			
			}

	 @Test(dataProvider="getData")
		public void bulkCancellationOfReservation(String url,String ClientCode, String Username, String Password) throws InterruptedException
		{
		
		 test = extent.startTest("BulkCancellation", "Bulk Cancellation of Reservation")
				 .assignCategory("BulkCancellation")
				 .assignCategory("Regression");

		 String testName=test.getTest().getName().toUpperCase();

		 app_logs.info("##################################################################################");
		 app_logs.info("EXECUTING: " + testName + " TEST.");
		 app_logs.info("##################################################################################");
		 
		 

		 Login 				LOGIN 			= new Login();
		 ReservationSearch 	bulkCancel		= new ReservationSearch();
		 
		 
		 
		 
		 
		 
		 
		 //**************** Login*******************//

		 try
		 {
			 
			 LOGIN.login(driver, url, ClientCode, Username, Password);
			 test.log(LogStatus.PASS, "Logged into the application");
			 app_logs.info("Logged into the application");
		 } 
		 	catch (Exception e) 
		 {
		 	Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		 }
		 

		 
		 //*********************Bulk Cancellation of Reservation**********************//
		 try
		 {
		
		bulkCancel.bulkCancellation(driver);
		test.log(LogStatus.PASS, "Bulk Cancellation Successful");
		app_logs.info("Bulk Cancellation");
		}
		catch (Exception e) {
	     Utility.updateReport(e, "Fail to Cancel the Reservation", testName, "BulkCancellation");
		} catch (Error e) {
	     Utility.updateReport(e, "Fail to Cancel the Reservation", testName, "BulkCancellation");
		}
		 extent.endTest(test);
	 	}
		
	 
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("BulkCancellation",excel);
		}
}
