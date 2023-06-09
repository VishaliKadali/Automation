package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

<<<<<<< HEAD
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
=======
import com.innroad.inncenter.pageobjects.FolioLineItems;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
>>>>>>> feature/AUTOMATION-90
import com.relevantcodes.extentreports.LogStatus;

public class BulkCancellation extends TestCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
<<<<<<< HEAD
			if(!com.innroad.inncenter.utils.Utility.isExecutable("PostLineItem", excel))
=======
			if(!com.innroad.inncenter.utils.Utility.isExecutable("BulkCancellation", excel))
>>>>>>> feature/AUTOMATION-90
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");	
			
			}

	 @Test(dataProvider="getData")
<<<<<<< HEAD
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
	 
	 	
=======
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
		 ReservationSearch 	advancedSearch	= new ReservationSearch();
		 FolioLineItems		balance			= new FolioLineItems();
		 
		 
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
		 

		 
		 //*********************Search the Reservation with Advanced Search**********************//
		 
		 try
		 {
			 advancedSearch.searchResWithAdvancedSearch(driver);
			 test.log(LogStatus.PASS, " Searching Reservation with Advanced Search is Successful");
			 app_logs.info("Reservation Search Successful");
		}
		 catch (Exception e) {
		 	Utility.updateReport(e, "Fail to Search the Reservation with Advanced Search", testName, "searchResWithAdvancedSearch");
		} 
		 catch (Error e) {
		 	Utility.updateReport(e, "Fail to Search the Reservation with Advanced Search", testName, "searchResWithAdvancedSearch");
		}
		 
		 
		//*************************Open the Reservation*************************//
		 
		 try
		 {
			 advancedSearch.openReservation(driver);
			 test.log(LogStatus.PASS, " Clicked on Reservation Successfully ");
			 app_logs.info("Clicked on Reservation Successfully ");
		}
		catch (Exception e) {
			Utility.updateReport(e, "Fail to Click the Reservation ", testName, "openReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Fail to Click the Reservation ", testName, "openReservation");
		}
		 
		 
		//***********************Verify Folio Balanace*************************//
		 
		 try
		 {
			 balance.verifyFolioBalance(driver);
			test.log(LogStatus.PASS, "Verified Folio Balanace");
			app_logs.info("Verification of Folio Balance Successful");
		}
		catch (Exception e) {
			Utility.updateReport(e, "Fail to Verify Folio Balanace", testName, "FolioBalance");
		} catch (Error e) {
			Utility.updateReport(e, "Fail to Verify Folio Balanace", testName, "FolioBalance");
		}
		 
		 
		 
		 
		//***********************Close the Reservation**************************// 
		 try
		 {
			 advancedSearch.closeReservation(driver);
			 test.log(LogStatus.PASS, "Closed the Reservation Successfully");
			 app_logs.info("Closed the Reservation");
		}
		catch (Exception e) {
			Utility.updateReport(e, "Fail to close the Reservation", testName, "closeReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Fail to close the Reservation", testName, "closeReservation");
		}
		 
		 
		 
		 
		//**********Search Reservation after verification of Folio Balance**********//
		 try
		 {
			 advancedSearch.advanceSearchReservation(driver);
			 test.log(LogStatus.PASS, "Reservtaion Search Successful");
			 app_logs.info("Reservtaion Search Successful");
		}
		catch (Exception e) {
			Utility.updateReport(e, " Fail to Search the Reservation ", testName, " searchReservation ");
		} catch (Error e) {
			Utility.updateReport(e, " Fail to Search the Reservation ", testName, " searchReservation ");
		}
		 
		 
		 
		//**********Bulk Cancellation of Reservation**********// 
		 try
		 {
			 advancedSearch.bulkCancellation(driver);
			 test.log(LogStatus.PASS, " Verified Bulk Cancellation Successfully ");
			 app_logs.info("Bulk Cancellation Successful");
		}
		catch (Exception e) {
			Utility.updateReport(e, " Fail to Cancel the Reservation ", testName, "BulkCancellation");
		} catch (Error e) {
			Utility.updateReport(e, " Fail to Cancel the Reservation ", testName, "BulkCancellation");
		}
		 
		 
		 extent.endTest(test);
	 	}
		
>>>>>>> feature/AUTOMATION-90
	 
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
<<<<<<< HEAD
			return Utility.getData("NavigationFlow",excel);
=======
			return Utility.getData("BulkCancellation",excel);
>>>>>>> feature/AUTOMATION-90
		}
}
