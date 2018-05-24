package com.innroad.inncenter.tests;



import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;



public class Accounts_Payment_Cash extends TestCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	// Create split reservation
	@Test(dataProvider="getData", groups="Regression")
	public void AccountPayCash(String url,String ClientCode, String Username, String Password,String AccountType,String AccountName,String AmountToPay,String PaymentType,String MargetSegment,String Referral,String AccountFirstName,String AccountLastName,String Phonenumber,String alternativeNumber,String Address1,String Address2,String Address3,String Email,String city,String Country,String State,String Postalcode){
		
	
			test = extent.startTest("Account Cash Payment", "Account Cash Payment")
					.assignCategory("Payment")
					.assignCategory("Regression");

			String testName = test.getTest().getName().toUpperCase();

			app_logs.info("##################################################################################");
			app_logs.info("EXECUTING: " + testName + " TEST.");
			app_logs.info("##################################################################################");
			
			
			Account 	account = new Account();
			Login 		LOGIN 	= new Login();
			Navigation 	Nav		= new Navigation();
			
			String AccountNumber = null;
			
			// Login to InnCenter
			try{
				LOGIN.login(driver,url, ClientCode, Username, Password);
				test.log(LogStatus.PASS, "System successfully logged in the site");
				app_logs.info("System successfully logged in the site");
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to login", testName, "Login");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to login", testName, "Login");
			}

			// Clicking on New Reservation
			try{
				
				Nav.Accounts(driver);
				test.log(LogStatus.PASS, "Navigate Accounts");
				
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
			}
			
			
			try{
				account.NewAccountbutton(driver, AccountType);
				account.type_CorpAccName(driver, test, AccountName);
				account.AccountAttributes(driver, test,MargetSegment, Referral);
				account.Mailinginfo(driver, test,AccountFirstName, AccountLastName, Phonenumber, alternativeNumber, Address1, Address2, Address3, Email, city, State, Postalcode);
				account.Billinginfo(driver,test);
				account.Save(driver,test);
				AccountNumber=account.getAccountNumber(driver, test,AccountName);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Create Corporate Account", testName, "CorporateAccount");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Create Corporate Account", testName, "CorporateAccount");
			}

			// Get Account Details
			try{
				account.get_AccountDetails(driver, test, AccountType, AccountName,AccountNumber);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Get Account Details", testName, "AccountDetails");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Get Account Details", testName, "AccountDetails");
			}


			//select account folio
			try{
				account.select_AccountFolio(driver, test, AccountName);
				account.addLineItems(driver, test);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Select Account Folio", testName, "AccountFolio");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Select Account Folio", testName, "AccountFolio");
			}
			
			
			//Account Cash payment
			try{
				account.cashPayment(driver, test,AccountType,AccountName, AmountToPay, PaymentType);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Pay Via Cash", testName, "CashPayment");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Pay Via Cash", testName, "CashPayment");
			}
			
			
		

	}
	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("Account Cash Payment",excel);
	}


}
