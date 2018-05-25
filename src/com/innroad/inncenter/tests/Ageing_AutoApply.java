package com.innroad.inncenter.tests;


import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Groups;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class Ageing_AutoApply extends TestCore{

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
	public void Ageing(String url,String ClientCode, String Username, String Password,String AccountType,String AccountName,String MargetSegment,String Referral,String AccountFirstName,String AccountLastName,String Phonenumber,String alternativeNumber,String Address1,String Address2,String Address3,String Email,String city,String Country,String State,String Postalcode,String AmountToPay,String PaymentType,String CardName,String CCNumber,String CCExpiry,String CCVCode,String Authorizationtype,String ChangeAmount,String ChangeAmountValue) throws InterruptedException{

		test = extent.startTest("Ageing_AutoApply", "Ageing_AutoApply")
				.assignCategory("Ageing")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Account 	account = new Account();
		Login 		LOGIN 	= new Login();
		Navigation 	Nav		= new Navigation();
		Groups 		group = new Groups();

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

		if(AccountType.contains("Corporate")){

			// Clicking on New Reservation
			try{

				Nav.Accounts(driver);
				test.log(LogStatus.PASS, "Navigate Accounts");
				System.out.println("successfully clicked on Accounts");
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
			}

			//Account Create
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
				Utility.updateReport(e, "Failed to get account details", testName, "AccountDetails");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to get account details", testName, "AccountDetails");
			}

			//select account folio
			try{
				account.select_AccountFolio(driver, test, AccountName);
				account.addLineItems(driver, test);

				account.ageingPaymentAutoApply(driver, test, AccountType,PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Pay the account autp apply", testName, "AccountAutoApply");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Pay the account autp apply", testName, "AccountAutoApply");
			}


		}else if(AccountType.contains("Group")){

			//Navigate to Groups
			try{
				Nav.Groups(driver);
			}catch (Exception e) {
				Utility.updateReport(e, "Failed to Navigate to groups", testName, "NavigateGroups");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to Navigate to groups", testName, "NavigateGroups");
			}

			
			//Create Group
			try{
				group.type_GroupName(driver, test, AccountName);
				group.type_AccountAttributes(driver, test, MargetSegment, Referral);
				group.type_MailingAddrtess(driver, test, AccountFirstName, AccountLastName, Phonenumber, Address1, city, State, Country, Postalcode);
				group.Billinginfo(driver, test);
				group.Save(driver, test);

			}catch (Exception e) {
				Utility.updateReport(e, "Failed to create group", testName, "CreateGroup");
			} catch (Error e) {
				Utility.updateReport(e, "Failed to create group", testName, "CreateGroup");
			}
			
			try{
			group.navigateFolio(driver, test);
			group.addLineItems(driver, test);

			group.ageingPaymentAutoApply(driver, test, AccountType, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue);
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Pay the group auto apply", testName, "GroupAutoApply");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Pay the group auto apply", testName, "GroupAutoApply");
		}



		}
	}
	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("Ageing_AutoApply",excel);
	}


}
