package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Account;
import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.RateQuote;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_Corporate_Account extends testCore {
	
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Create_Corporate_Account", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
		
		
		
	}
	
	 @Test(dataProvider="getData")
		public void Create_Corporate_account(String url,String ClientCode, String Username, String Password, String propertyName,
				String Accounttype, String AccountName, String MargetSegment, String Referral, String AccountFirstName, String AccountLastName, String Phonenumber,
				String alternativeNumber, String Address1, String Address2, String Address3, String Email, String city, String State, String Postalcode,
				String SelectCategory, String Amount, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
				String Authorizationtype, String ChangeAmount, String ChangeAmountValue	) throws InterruptedException, IOException {
		 

		 ExtentTest test = extent.startTest("Create_Corporate_Account", "Corporate account creation")
		 		                 .assignCategory("Accounts")
		 		                 .assignCategory("Smoke");	
		 
		 System.out.println("Executing: " + test.getTest().getName()+ " test.");
	    	 
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
	    	
	    	 extent.endTest(test);
		}
	 
	
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Create_Corporate_Account",excel);
		}
	
	
	

}
