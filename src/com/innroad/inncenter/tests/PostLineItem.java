package com.innroad.inncenter.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.AddOrPostLineItem;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class PostLineItem extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			}

	 @Test(dataProvider="getData")
		public void addOrPostLineItem(String url,String ClientCode, String Username, String Password, String PropertyName) throws InterruptedException
		{
		
		 test = extent.startTest("AddPostLineItem", "addOrPostLineItem")
				 				 .assignCategory("addOrPostLineItem")
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
		 
		 //*********************click On Guest Name in reservation************************//
		 
		 try
		 {
	    	AddOrPostLineItem FolioLineItems= new AddOrPostLineItem();
	    	FolioLineItems.guestNameReservation(driver);	
	    	test.log(LogStatus.PASS, "clicked on Guestname in Reservation ");
	    	app_logs.info(" Clicked on Guestname in Reservation ");
		 }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to click Guest Name in Reservation", testName, "GuestName");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to click Guest Name in Reservation", testName, "GuestName");
	     }
		 
		 
		 
		//*********************click Folio tab************************//
		
		 try
		 {
	    	AddOrPostLineItem FolioLineItems= new AddOrPostLineItem();
	    	FolioLineItems.clickFoliotab(driver);	
	    	test.log(LogStatus.PASS, "Clicked on Folio tab in Reservation ");
	    	app_logs.info(" Clicked on Folio tab in Reservation ");
		 }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to click on Folio tab in Reservation", testName, "Foliotab");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to click on Folio tab in Reservation", testName, "Foliotab");
	     }
		
		 //********************Add Line Item**************************//
		 
		try
		 {
	    	AddOrPostLineItem FolioLineItems= new AddOrPostLineItem();
	    	//FolioLineItems.addLineItem(driver, Category, Amount);	
	    	FolioLineItems.adjustLineItem(driver);
	    	test.log(LogStatus.PASS, " Enter the data for Line items ");
	    	app_logs.info(" Entered the data for Line items  ");
		}
		
		catch (Exception e) {
	         Utility.updateReport(e, "Failed to Adjust Line Item", testName, "AdjustFolioLineItem");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Adjust Line Item", testName, "AdjustFolioLineItem");
	     }
		 
		 
		 extent.endTest(test);
		 	
 		}

 @DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("PostLineItem",excel);
		}
		
	 
}
