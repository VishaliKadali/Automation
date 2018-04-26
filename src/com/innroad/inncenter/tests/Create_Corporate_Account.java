package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.RateQuote;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_Corporate_Account extends TestCore {

	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Create_Corporate_Account", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
		
		
		
	}
	
	 @Test(dataProvider="getData")
		public void CreateReservationfromRateQuoteBookicon(String url,String ClientCode, String Username, String Password, String propertyName,
				String Accounttype, String AccountName, String MargetSegment, String Referral, String AccountFirstName, String AccountLastName, String Phonenumber,
				String alternativeNumber, String Address1, String Address2, String Address3, String Email, String city, String State, String Postalcode,
				String SelectCategory, String Amount, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
				String Authorizationtype, String ChangeAmount, String ChangeAmountValue
				
				
				) throws InterruptedException, IOException
		{
		 ExtentTest test = extent.startTest("Create_Corporate_Account", "Corporate account creation")
		 			 		     .assignCategory("Accounts")
		 			             .assignCategory("Sanity");
	    	
	    	 
	    	 try
		     {
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 Wait.wait25Second();
	    	 test.log(LogStatus.PASS, "Login successfully");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Login unsuccess"); 
		     }
	          
		     try
		     {
		     Reservation res = new  Reservation();
	    	 res.IPropertySelector(driver,propertyName);
	    	 Wait.wait25Second();
	    	 test.log(LogStatus.PASS, "Property Selection Success");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to select property"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Navigation newQuoteNavigation = new Navigation();
	    	 newQuoteNavigation.Accounts(driver);
	    	 Wait.wait25Second();
	    	 test.log(LogStatus.PASS, "Navigating to Accounts");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate to accounts page"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Account CreateCorporteAccount=new Account();
	    	 CreateCorporteAccount.NewAccountbutton(driver, Accounttype);
	    	 test.log(LogStatus.PASS, "Navigate to new Account by clicking on new Account");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate new account page"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Account CreateCorporteAccount=new Account();
	    	 CreateCorporteAccount.AccountDetails(driver, Accounttype, AccountName);
	    	 CreateCorporteAccount.AccountAttributes(driver, MargetSegment, Referral);
	    	 CreateCorporteAccount.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativeNumber, Address1, Address2, Address3, Email, city, State, Postalcode);
	    	 CreateCorporteAccount.Billinginfo(driver);
	    	 CreateCorporteAccount.Save(driver);
	    	 test.log(LogStatus.PASS, "Enter all required details and save the reservation");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to save the account"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Account CreateCorporteAccount=new Account();
	    	 CreateCorporteAccount.navigateFolio(driver);
	    	 CreateCorporteAccount.addLineitem(driver, propertyName,SelectCategory, Amount);
	    	 CreateCorporteAccount.Commit(driver);
	    	 test.log(LogStatus.PASS, "Navigate to folio and add line item");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate to folio and fail to adding line item"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Account CreateCorporteAccount=new Account();
	    	 CreateCorporteAccount.Payment(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue);
	    	 CreateCorporteAccount.Save(driver);
	    	 test.log(LogStatus.PASS, "payment success and save the account");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to save the account"); 
		     }
	    	 extent.endTest(test);
		}

	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Create_Corporate_Account",excel);
		}
	
	
	

}
