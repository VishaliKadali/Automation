package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifySaveBtnFuncForAccounts extends TestCore {
	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void Create_Corporate_account(String url, String ClientCode, String Username, String Password,
			String propertyName, String Accounttype, String AccountName, String MargetSegment, String Referral,
			String AccountFirstName, String AccountLastName, String Phonenumber, String alternativeNumber,
			String Address1, String Address2, String Address3, String Email, String city, String State,
			String Postalcode, String SelectCategory, String Amount, String PaymentType, String CardName,
			String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException, IOException {

		test = extent
				.startTest("VerifySaveBtnFunctionalityForAccounts", "Verify Save Button Functionality For Accounts")
				.assignCategory("Accounts").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
		Account CreateCorporteAccount = new Account();
		Elements_Accounts CreateAccount = new Elements_Accounts(driver);
		Boolean SaveBtnStatusBefore;
		Boolean SaveBtnStatusAfter;
		
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}
		
/*		
		try {
			Reservation res = new Reservation();
			res.IPropertySelector(driver, propertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}
*/
		
		try {
			Navigation accountsNavigation = new Navigation();
			accountsNavigation.Accounts(driver);
			test.log(LogStatus.PASS, "Navigated to Accounts");
			app_logs.info("Navigated to Accounts");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		}

		try {
			CreateCorporteAccount.NewAccountbutton(driver, Accounttype);
			test.log(LogStatus.PASS, "Navigate to new Account by clicking on new Account");
			app_logs.info("Navigate to new Account by clicking on new Account");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate new account page", testName, "NewAccount");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate new account page", testName, "NewAccount");
		}
		try {
			CreateCorporteAccount.AccountDetails(driver, Accounttype, AccountName);
			CreateCorporteAccount.AccountAttributes(driver, MargetSegment, Referral);
			CreateCorporteAccount.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativeNumber,
					Address1, Address2, Address3, Email, city, State, Postalcode);
			CreateCorporteAccount.Billinginfo(driver);
			CreateCorporteAccount.Save(driver);
			test.log(LogStatus.PASS, "Entered all required details and saved the Account");
			app_logs.info("Entered all required details and saved the Account");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the account", testName, "NewAccountDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the account", testName, "NewAccountDetails");
		}
		try {

			SaveBtnStatusBefore = CreateAccount.Account_save.isEnabled();
			CreateAccount.Account_Enter_First_Name.clear();
			CreateAccount.Account_Enter_Last_Name.clear();
			CreateAccount.Account_Enter_First_Name.sendKeys("EditedFName");
			CreateAccount.Account_Enter_Last_Name.sendKeys("EditedLName");
			Wait.wait1Second();
			SaveBtnStatusAfter = CreateAccount.Account_save.isEnabled();
			Assert.assertTrue(SaveBtnStatusAfter, "Save button is not re-enabled after editing First and Last Name");
			CreateCorporteAccount.Save(driver);

			test.log(LogStatus.PASS, "Save button is re-enabled after editing First and Last Name");
			app_logs.info("Save button is re-enabled after editing First and Last Name");
		} catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after editing First and Last Name", testName,
					"VerifySaveAED");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after editing First and Last Name", testName,
					"VerifySaveAED");
		}
		try {

			Utility.ScrollToElement(CreateAccount.Account_Folio);
			Wait.wait2Second();
			CreateAccount.Account_Folio.click();
			CreateCorporteAccount.addLineitem(driver, propertyName, SelectCategory, "10");
			CreateCorporteAccount.Commit(driver);
			SaveBtnStatusAfter = CreateAccount.Account_save.isEnabled();
			Assert.assertTrue(SaveBtnStatusAfter, "Save button is not enabled after adding LineItem");
			CreateCorporteAccount.Save(driver);
			test.log(LogStatus.PASS, "Save button is re-enabled after adding LineItem");
			app_logs.info("Save button is re-enabled after adding LineItem");
		} catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after adding LineItem", testName, "VerifySaveAALI");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after adding LineItem", testName, "VerifySaveAALI");
		}

		try {

			CreateCorporteAccount.Payment(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
					ChangeAmount, ChangeAmountValue);
			Wait.wait2Second();
			SaveBtnStatusAfter = CreateAccount.Account_save.isEnabled();
			Assert.assertTrue(SaveBtnStatusAfter, "Save button is not enabled after making payments");
			CreateCorporteAccount.Save(driver);

			test.log(LogStatus.PASS, "Save button is re-enabled after making payments");
			app_logs.info("Save button is re-enabled after making payments");
		} catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after making payments", testName, "VerifySaveAAP");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after making payments", testName, "VerifySaveAAP");
		}
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("VerifySaveBtnFuncForAccounts", excel);
	}

}
