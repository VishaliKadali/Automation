package com.innroad.inncenter.tests;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.RateDerived;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DerivedRate extends TestCore{
	
	@BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			}

	 @Test(dataProvider="getData")
		public void createDerivedRate(String url,String ClientCode, String Username, String Password, String PropertyName, String ratename, String offsetAmount, String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException
		{
		
		test = extent.startTest("createDerivedRate", " create Derived Rate")
				 				 .assignCategory("DerivedRate")
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
		 
		 //*****************Navigate to Inventory*************************//
		 
		try
		 	{
			    	RateDerived derivedRate= new RateDerived();
			    	derivedRate.inventory_Rate(driver);
			    	app_logs.info("Navigated to Inventory Rate \n");
			    	derivedRate.new_RateDerived(driver, ratename, offsetAmount, rateDisplayName, ratePolicy, rateDescription);
			    	app_logs.info("Entered the required details and Saved the Derived Rate \n");
			    	test.log(LogStatus.PASS, "Successfully Created the Derived Rate");
		 	}
			
		catch (Exception e) {
		         Utility.updateReport(e, "Failed to Create Derived Rate", testName, "Create_DerivedRate");
		     } catch (Error e) {
		         Utility.updateReport(e, "Failed to Create Derived Rate", testName, "Create_DerivedRate");
		  }		
			
		try
	 	{
		    	RateDerived derivedRate= new RateDerived();
		    	derivedRate.delete_rate(driver);
		    	app_logs.info(" Successfully Deleted the Derived Rate \n");
		    	test.log(LogStatus.PASS, "Successfully Deleted the Derived Rate");
	 	}
		
	catch (Exception e) {
	         Utility.updateReport(e, "Failed to Deleted Derived Rate", testName, "Delete_DerivedRate");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Deleted Derived Rate", testName, "Delete_DerivedRate");
	  }		
		
		 extent.endTest(test); 
		 
			}
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("DerivedRate",excel);
		}

}
