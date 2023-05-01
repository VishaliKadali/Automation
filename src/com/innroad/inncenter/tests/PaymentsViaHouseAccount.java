package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.FolioLineItems;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.LogStatus;

public class PaymentsViaHouseAccount extends TestCore{
	

	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!com.innroad.inncenter.utils.Utility.isExecutable("BulkCheckInWithZeroBalance", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");	
			
			}

	
	 @Test(dataProvider="getData")
		public void paymentsHouseAccount(String url,String ClientCode, String Username, String Password, String Accounttype, String AccountType, String AccountName) throws InterruptedException, IOException
			{
		
		 test = extent.startTest("paymentsHouseAccount", " Payment via House Account ")
				 .assignCategory("paymentsHouseAccount")
				 .assignCategory("Regression");

		 String testName=test.getTest().getName().toUpperCase();

		 app_logs.info("##################################################################################");
		 app_logs.info("EXECUTING: " + testName + " TEST.");
		 app_logs.info("##################################################################################");
		 
		 

		 	Login 					LOGIN 				= new Login();
		 	Navigation 				accounts 			= new Navigation();
		 	Account 				houseAccount 		= new Account();	 		
			
			
			//*********************Login******************//			
			 	try
			     {
				
				LOGIN.login(driver, url, ClientCode, Username, Password);
				test.log(LogStatus.PASS, "Logged into the application");
				app_logs.info("Logged into the application");
			     } 
			 	catch (Exception e) {
			 		Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
			     }
			 	
			 	
			//********************Navigate to Accounts*******************// 	
			 	
			 	try
			 	{
				
			 	accounts.Accounts(driver);
			 	accounts.Accounts_sec_Nav(driver);
				test.log(LogStatus.PASS, "Navigated to Accounts");
				app_logs.info("Navigated to Accounts");
			 	}
				catch (Exception e) {
					Utility.updateReport(e, " Fail to Navigate Accounts ", testName, "Accounts");
				} catch (Error e) {
				    Utility.updateReport(e, " Fail to Navigate Accounts ", testName, "Accounts");
				}
			 	
			//*****************************************Create House Account**********************************//

			 	try
			 	{
			 	houseAccount.NewAccountbutton(driver, Accounttype);
				test.log(LogStatus.PASS, " Successfully created House Account ");
				app_logs.info(" Successfully created House Account ");
			 	}
				catch (Exception e) {
					Utility.updateReport(e, " Fail to Create House Account ", testName, "CreateHouseAccount");
				} catch (Error e) {
				    Utility.updateReport(e, " Fail to Create House Account ", testName, "CreateHouseAccount");
				}
			 	
			 	
			//***************************************Enter Account Details**********************************//
				try
			 	{
			 	houseAccount.AccountDetails(driver, AccountType , AccountName);
				test.log(LogStatus.PASS, " Successfully entered House Account details");
				app_logs.info(" Successfully entered House Account details ");
			 	}
				catch (Exception e) {
					Utility.updateReport(e, " Fail to Enter House Account Details ", testName, "HouseAccountDetails");
				} catch (Error e) {
				    Utility.updateReport(e, " Fail to Enter House Account Details ", testName, "HouseAccountDetails");
				} 	
			 	 
			    extent.endTest(test);
		   
				}
	 
			 	@DataProvider
				public Object [][] getData(){
					
					//return test data from the sheetname provided
					return Utility.getData("PaymentsViaHouseAccount",excel);
				}

}
