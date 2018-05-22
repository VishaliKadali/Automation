package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.Rules;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class CreateRule extends TestCore{

	 @BeforeTest
		public void checkRunMode(){
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			
			
		}
	
	 
   @Test(dataProvider="getData")
	public void createNewRule(String url,String ClientCode, String Username, String Password,String RuleName,  String RuleType, String RuleDescription) throws InterruptedException, IOException
	{
   	 test = extent.startTest("CreateRule", "Create Rule")
   			 				 .assignCategory("New Rule")
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
    
    //************* Enter the data for new Rule   *******************//  
  try
   {
   Rules newRule = new  Rules();
   
    newRule.create_Rule(driver, RuleName, RuleType, RuleDescription);
	 test.log(LogStatus.PASS, "Entered required fields and saved the new rule");
	 app_logs.info("Created the Rule Successfully");
    }
  
  catch (Exception e) {
      Utility.updateReport(e, "Failed to Create the Rule", testName, "create_Rule");
  } catch (Error e) {
      Utility.updateReport(e, "Failed to Create the Rule", testName, "create_Rule");
  }
  
  
  try
  {
	  Rules rule = new  Rules(); 
	  rule.deleteRule(driver);
	  test.log(LogStatus.PASS, " Deleted the Rule ");
	  app_logs.info("Deleted the Rule Successfully");
  }
  
  catch (Exception e) {
      Utility.updateReport(e, "Failed to Delete the Rule", testName, "Delete_Rule");
  } catch (Error e) {
      Utility.updateReport(e, "Failed to Delete the Rule", testName, "Delete_Rule");
  }
 
    extent.endTest(test);
	
	}
  
   @DataProvider
	public Object [][] getData(){
		
		//return test data from the sheetname provided
		
		return Utility.getData("CreateRule",excel);
	}
}


