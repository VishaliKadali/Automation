package com.innroad.inncenter.tests;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.RatePackage;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PackageRate extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			}

	 @Test(dataProvider="getData")
		public void createPackageRate(String url,String ClientCode, String Username, String Password, String PropertyName, String ratename, String PackageCompDescription, String PackageAmount,String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException
		{
		
		 test = extent.startTest("createPackageRate", " create Package Rate")
				 				 .assignCategory("PackageRate")
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
			    	RatePackage packageRate= new RatePackage();
			    	packageRate.inventory_Rate(driver);
			    	app_logs.info("Navigated to Inventory Rate");
			    	packageRate.package_details(driver, ratename);
			    	test.log(LogStatus.PASS, "Entered package details");
			    	app_logs.info("Entered package details");
		   }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Enter Package Details", testName, "PackageDetails");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Enter Package Details", testName, "PackageDetails");
	     }
				
		 
		 
		 try
		 
		   {
			    	RatePackage packageRate= new RatePackage();
			    	packageRate.package_components(driver, PackageCompDescription, PackageAmount);
			    	test.log(LogStatus.PASS, "System successfully entered package components");
			    	app_logs.info("Entered the package components");
		   }

		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Enter Package components", testName, "PackageComponents");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Enter Package components", testName, "PackageComponents");
	     }
		 
		 
		 try
		 
		   {
			    	RatePackage packageRate= new RatePackage();
			    	packageRate.package_descriptiveInformation(driver, rateDisplayName, ratePolicy, rateDescription);
			    	
			    	test.log(LogStatus.PASS, "System successfully entered the  Package descriptive information ");
			    	app_logs.info(" Entered the package descriptive information ");
		   }
		 
		 	catch (Exception e) {
	         Utility.updateReport(e, "Failed to Enter Package descriptive information", testName, "PackageDescriptiveInformation");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Enter Package descriptive information", testName, "PackageDescriptiveInformation");
	     }
			
		 
		 try
		 
		   {
			   RatePackage packageRate= new RatePackage();
			   packageRate.associateRate(driver);
			    	
			   test.log(LogStatus.PASS, "System successfully associated the Rate and created the Package ");
			   app_logs.info(" successfully associated the Rate and created the Package  ");
			    	
		   }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to associated the Rate and created the Package ", testName, "Package");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to associated the Rate and created the Package ", testName, "Package");
	     }
			
		 
		 try
		 
		   {
			    	RatePackage packageRate= new RatePackage();
			    	packageRate.delete_rate(driver);
			    	test.log(LogStatus.PASS, "System successfully Deleted Package Rate");
			    	app_logs.info(" Successfully   ");
		   }
		 
		 	catch (Exception e) {
	         Utility.updateReport(e, "Failed to Delete the Package ", testName, "DeletePackage");
		 	} catch (Error e) {
	         Utility.updateReport(e, "Failed to Delete the Package ", testName, "DeletePackage");
		 	}
			
			 	
		 extent.endTest(test); 
		 
			}
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("PackageRate",excel);
		}
}
