package com.innroad.inncenter.tests;


import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.GuestHistory;
import com.innroad.inncenter.pageobjects.LockFunctionality;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LockUnlockFunctionality extends TestCore {
	
	 @BeforeTest
		public void checkRunMode(){
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			}
	 
	 
	 @Test(dataProvider="getData")
		public void lockUnlockRooms(String url,String ClientCode, String Username, String Password, String PropertyName)
		{
		
		 test = extent.startTest("lockUnlockRooms", "Verify lock unlock rooms")                                                                                                                                                                                                                           
				 				 .assignCategory("lockUnlockRooms")
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
		    	LockFunctionality lock_Unlock= new LockFunctionality();
		    	lock_Unlock.search(driver);
		    	app_logs.info("Clicked on Search button");
	      }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to click on Search button", testName, "Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to click on Search button", testName, "Reservation");
	     }	
		 
		 
		 try
         {
			 LockFunctionality lock_Unlock= new LockFunctionality();
			 lock_Unlock.clickReservation(driver);
		    app_logs.info("Clicked on Reservation");
	    	test.log(LogStatus.PASS, " Successfully clicked on Reservation");
         }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Click on Reservation", testName, "Reservation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Click on Reservation", testName, "Reservation");
	     }
		 
		 
		 try
         {
			 LockFunctionality lock_Unlock= new LockFunctionality();
			 lock_Unlock.verifyLockUnlock(driver);
		    app_logs.info("Clicked on Lock and Unlock");
	    	test.log(LogStatus.PASS, " Sucessfully locked and Unlocked the Reservation ");
         }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Click on Lock and Unlock Reservation", testName, "LockUnlock");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Click on Lock and Unlock Reservation", testName, "LockUnlock");
	     }	
			 

	 	 extent.endTest(test);
			 
			 
		 	}
		 
	
	 
		@DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("LockUnlockFunctionality",excel);
		}
}




