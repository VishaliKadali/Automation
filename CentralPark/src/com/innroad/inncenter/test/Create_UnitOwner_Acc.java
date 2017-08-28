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
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.ReservationFolio;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_UnitOwner_Acc extends testCore{
	
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Create_UnitOwner_Acc", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
		
		
		
	}
	
	
	@Test(dataProvider="getData")
	public void create_UnitOwner_Account(String url,String ClientCode, String Username, String Password, String propertyName,
			String Accounttype, String AccountName, String MargetSegment, String Referral, String AccountFirstName, String AccountLastName, String Phonenumber,
			String alternativeNumber, String Address1, String Address2, String Address3, String Email, String city, String State, String Postalcode,String Travel_Agent, String ExtReservation,
			String saluation,String FirstName,String LastName, String Address, String Line1,String  Line2,String Line3,String City,String Country,String Account,String IsTaxExempt, String TaxEmptext,String PropertyName,
			String Nights,String Adults,String Children,String RatepromoCode,String CheckorUncheckAssign,String RoomClassName, String RoomNumber, String ChangeAmount, String ChangeAmountValue
		
			
			) throws InterruptedException, IOException
	{
		
		ExtentTest test = extent.startTest("Create_UnitOwner_Acc", "Creating UnitOwner Account")
								.assignCategory("Accounts")
								.assignCategory("Sanity");
		
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
    	 
    	 try
    	 {
    	 Account CreateCorporteAccount=new Account();
    	 CreateCorporteAccount.CreateNewReservation(driver);
    	 test.log(LogStatus.PASS, "Click on New Reservation button");
    	 }
    	 catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to click on new Reservation"); 
	     }
    	 
    	 try
    	 {
    	 Reservation res = new  Reservation();
    	 res.marketingInfo(driver, MargetSegment, Referral, Travel_Agent, ExtReservation);
    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativeNumber, Email, Account, IsTaxExempt, TaxEmptext);
    	 res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign, RoomClassName, RoomNumber);
    	 res.saveReservation(driver);
    	 test.log(LogStatus.PASS, "Enter all reqiured details and save the reservation");
    	 }
    	 catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to Enter all reqiured details and save the reservation"); 
	     }
    	 
    	 try
    	 {
    	 ReservationFolio Accountpay= new ReservationFolio();
    	 Accountpay.Paytype_CP_Account(driver, ChangeAmount, ChangeAmountValue);
    	 Reservation res = new  Reservation();
    	 res.saveReservation(driver);
    	 test.log(LogStatus.PASS, "paymnet with account and Save reservation success");
    	 }
    	 catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to pay and save the reservation"); 
	     }
    	 extent.endTest(test);
    	 
    	
	}

	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Create_UnitOwner_Acc",excel);
		}

}
