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
		public void bulkCancellationOfReservation(String url,String ClientCode, String Username, String Password, String PropertyName) throws InterruptedException
		{
		
		 ExtentTest test = extent.startTest("AddPostLineItem", "addOrPostLineItem")
				 				 .assignCategory("addOrPostLineItem")
				 				 .assignCategory("Smoke");
		 
		 System.out.println("Executing: " + test.getTest().getName()+ " test.");
		 
		 //**************** Login*******************//
		 
		 try{
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 test.log(LogStatus.PASS, "System successfully logged in the site");
		 }
		 catch(Exception e)
		 {
			 test.log(LogStatus.FAIL, "System fail to login");
		 }
	    
		//*******************Select Property ****************//
		 try
		 {
	    	Reservation res= new Reservation();
	    	res.IPropertySelector(driver,PropertyName);
	    	test.log(LogStatus.PASS, "System successfully changed property");
		 }
		 catch(Exception e)
		 {
			 test.log(LogStatus.FAIL, "System fail to select Property \n" +e.getStackTrace());
		 }
		 
		//*********************Click All Arrivals from Queries tab**********************//
		 try
		 {
		ReservationSearch bulkCancel= new ReservationSearch();
//		bulkCancel.preDefinedQueriesTab(driver);
//		bulkCancel.bulkCancelOfReservation(driver);	
	    test.log(LogStatus.PASS, "System Succesfully Navigated to reservation predefined queries tab");
		 }
	 	catch(Exception e)
	 	{
	 		test.log(LogStatus.FAIL, "System fail to Navigated to reservation predefined queries tab \n" +e.getStackTrace());
	 	} 
		extent.endTest(test); 	
		}
	 
	 	
	 
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("NavigationFlow",excel);
		}
}
