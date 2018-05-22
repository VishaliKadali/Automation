package com.innroad.inncenter.tests;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Rate;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class BaseRate extends TestCore{
	

	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			}

	 @Test(dataProvider="getData")
		public void createBaseRate(String url,String ClientCode, String Username, String Password, String PropertyName, String ratename,String maxAdults, String maxPersons, String baseAmount, String additionalAdult, String additionalChild, String rateDisplayName, String ratePolicy, String rateDescription)
		{
		
		 test = extent.startTest("createBaseRate", " Create Base Rate")
				 				 .assignCategory("createBaseRate")
				 				 .assignCategory("Regression");
		 
		 String testName=test.getTest().getName().toUpperCase();
			
			app_logs.info("##################################################################################");
			app_logs.info("EXECUTING: " + testName + " TEST.");
			app_logs.info("##################################################################################");

		 
		 
		 //**************** Login*******************//
		 
			try
		     {
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
		 
		 //********************************Navigate to Inventory*********************************//
		 
		 try
		  {
			 Rate baseRate= new Rate();
			 baseRate.inventory_Rate(driver);
			 test.log(LogStatus.PASS, "System successfully navigated to Inventory_Rate");
			 app_logs.info("System successfully navigated to Inventory_Rate");
		  }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Navigate to Inventory Rate", testName, "Navigate_InventoryRate");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Navigate to Inventory Rate", testName, "Navigate_InventoryRate");
	     }
		 

		 //****************Enter the required details in create new rate************************//
		 try
		   {
			    Rate baseRate= new Rate();
			    baseRate.new_Rate(driver, ratename, maxAdults, maxPersons, baseAmount, additionalAdult, additionalChild, rateDisplayName, ratePolicy, rateDescription);
			    test.log(LogStatus.PASS, " System successfully entered the details to create new rate ");
			    app_logs.info(" System successfully entered the details to create new rate ");
		   }
			
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Create Rate", testName, "CreateRate");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Create Rate", testName, "CreateRate");
	     }
		 
		//*************************************Delete the Rate**********************************//
		 try
		   {
			    Rate baseRate= new Rate();
			    baseRate.delete_rate(driver);
			    test.log(LogStatus.PASS, " System successfully Deleted the Rate ");
			    app_logs.info(" Successfully Deleted the Rate ");
		   }
		 
		 	catch (Exception e) {
			 	Utility.updateReport(e, "Failed to Delete Rate", testName, "DeleteRate");
		 	} catch (Error e) {
		 		Utility.updateReport(e, "Failed to Delete Rate", testName, "DeleteRate");
		 	}
				
		 
		 extent.endTest(test); 
		 
			}
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("BaseRate",excel);
		}
}
