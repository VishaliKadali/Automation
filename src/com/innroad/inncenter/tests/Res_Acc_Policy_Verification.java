package com.innroad.inncenter.tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Policies;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.LogStatus;

public class Res_Acc_Policy_Verification extends TestCore {

	String ResPolicyName1, ResPolicyName2, AccountPolicyName3 = "";

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void reservation__And_Account_Policy_Verification(String url, String ClientCode, String Username,
			String Password, String propertyName, String Policytype1, String PolicyName, String Deposit_percentage,
			String PolicyText, String PolicyDesc, String Policytype2, String Checkin_Percentage, String Policytype3,
			String Acc_Checkin_Percentage2, String MarketSegment, String Referral, String Travel_Agent,
			String ExtReservation, String saluation, String FirstName, String LastName, String Address, String Line1,
			String Line2, String Line3, String City, String Country, String State, String Postalcode,
			String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,
			String TaxEmptext, String PaymentMethod, String AccountNumber, String ExpiryDate, String BillingNotes,
			String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,
			String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String Attachment, String PaymentType,
			String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype,
			String ChangeAmount, String ChangeAmountValue, String traceData, String Accounttype, String AccountName,
			String MargetSegment, String AccountFirstName, String AccountLastName, String Address1, String Address2,
			String Address3, String AcEmail, String AcState, String AcPostalcode) throws Exception

	{
		String PolicyText1, PolicyText2, PolicyText3 = "";
		ResPolicyName1 = Deposit_percentage + "% " + Policytype1 + " " + PolicyName + Utility.getTimeStamp();
		ResPolicyName2 = Checkin_Percentage + "% " + Policytype2 + " " + PolicyName + Utility.getTimeStamp();
		AccountPolicyName3 = Acc_Checkin_Percentage2 + "% " + Policytype3 + " " + PolicyName + Utility.getTimeStamp();
		PolicyText1 = Deposit_percentage + "% " + Policytype1 + " " + PolicyName + PolicyText;
		PolicyText2 = Checkin_Percentage + "% " + Policytype2 + " " + PolicyName + PolicyText;
		PolicyText3 = Acc_Checkin_Percentage2 + "% " + Policytype3 + " " + PolicyName + PolicyText;
		String Res_Confirmation_Number1 = "";
		String Res_Confirmation_Number2 = "";
		double endingbalance;
		String GetEndingBalance;
		String RemoveCurreny[];
		double processedamount;
		double processed_percent;

		test = extent
				.startTest("Reservation_And_Account_Policy_Verification", "Reservation And Account Policy Verification")
				.assignCategory("Policies").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		Reservation res = new Reservation();
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Policies Create_New_Policy = new Policies();
		Navigation Nav = new Navigation();
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		ReservationSearch search = new ReservationSearch();
		Elements_Accounts Accounts = new Elements_Accounts(driver);
		Account CreateCorporteAccount = new Account();

		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}
		try {
			res.IPropertySelector(driver, propertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}

		try {
			Nav.Inventory(driver);
			test.log(LogStatus.PASS, "Navigated to Inventory");
			app_logs.info("Navigated to Inventory");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		}

		try {

			Navigate.Menuitem_Policy_Text.click();
			Wait.explicit_wait_xpath(OR.Policy_Button);
			test.log(LogStatus.PASS, "Navigated to Policies");
			app_logs.info("Navigated to Policies");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PolicyNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PolicyNavigation");
		}

		try {

			Create_New_Policy.NewPolicybutton(driver, Policytype1);
			test.log(LogStatus.PASS, "Navigated to new Policy by clicking on new Policy button");
			app_logs.info("Navigated to new Policy by clicking on new Policy button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");
		}

		try {

			Create_New_Policy.Enter_Policy_Name(driver, ResPolicyName1);
			Create_New_Policy.Enter_Deposit_Policy_Attributes(driver, "PRC", Deposit_percentage);
			Create_New_Policy.Enter_Policy_Desc(driver, PolicyText1, PolicyDesc);
			Create_New_Policy.Associate_Sources(driver);
			Create_New_Policy.Associate_Seasons(driver);
			Create_New_Policy.Associate_RoomClasses(driver);
			Create_New_Policy.Associate_RatePlans(driver);
			Create_New_Policy.Save_Policy(driver);
			Create_New_Policy.Close_Policy_Tab(driver);
			test.log(LogStatus.PASS, "New deposit Policy saved successfully ");
			app_logs.info("New deposit Policy saved successfully");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the deposit policy", testName, "DepositPolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the deposit policy", testName, "DepositPolicy");
		}

		try {

			Create_New_Policy.Verify_Policy(driver, ResPolicyName1);
			test.log(LogStatus.PASS, "Created deposit policy showing up in search results");
			app_logs.info("Created deposit policy showing up in search results");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! Created deposit policy is not showing up in search results", testName,
					"PolicySearch");

		} catch (Error e) {
			Utility.updateReport(e, "Error! Created deposit policy is not showing up in search results", testName,
					"PolicySearch");
		}
		try {

			Create_New_Policy.NewPolicybutton(driver, Policytype2);
			test.log(LogStatus.PASS, "Navigated to new Policy by clicking on new Policy button");
			app_logs.info("Navigated to new Policy by clicking on new Policy button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");
		}
		try {

			Create_New_Policy.Enter_Policy_Name(driver, ResPolicyName2);
			Create_New_Policy.Enter_Checkin_Policy_Attributes(driver, "capture", Checkin_Percentage);
			Create_New_Policy.Enter_Policy_Desc(driver, PolicyText2, PolicyDesc);
			Create_New_Policy.Associate_Sources(driver);
			Create_New_Policy.Associate_Seasons(driver);
			Create_New_Policy.Associate_RoomClasses(driver);
			Create_New_Policy.Associate_RatePlans(driver);
			Create_New_Policy.Save_Policy(driver);
			Create_New_Policy.Close_Policy_Tab(driver);
			test.log(LogStatus.PASS, "New Checkin Policy saved successfully ");
			app_logs.info("New Checkin Policy saved successfully");

		} catch (Exception e) {

			Utility.updateReport(e, "Failed to save the Checkin policy", testName, "NewCheckinPolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the Checkin policy", testName, "NewCheckinPolicy");
		}
		try {

			Create_New_Policy.Verify_Policy(driver, ResPolicyName2);
			test.log(LogStatus.PASS, "Created Checkin policy showing up in search results");
			app_logs.info("Created Checkin policy showing up in search results");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! Created Checkin policy is not showing up in search results", testName,"PolicySearch");

		} catch (Error e) {
			Utility.updateReport(e, "Error! Created Checkin policy is not showing up in search results", testName,
					"PolicySearch");
		}
		try {

			Create_New_Policy.NewPolicybutton(driver, Policytype3);
			test.log(LogStatus.PASS, "Navigated to new Policy by clicking on new Policy button");
			app_logs.info("Navigated to new Policy by clicking on new Policy button");
		} catch (Exception e) {

			Utility.updateReport(e, "Failed Navigate to new Policy by clicking on new Policy button", testName,
					"NewPolicyPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed Navigate to new Policy by clicking on new Policy button", testName,
					"NewPolicyPage");
		}

		try {

			PolicyText = Acc_Checkin_Percentage2 + "% " + Policytype3 + " " + PolicyName + PolicyText;
			Create_New_Policy.Enter_Policy_Name(driver, AccountPolicyName3);
			Create_New_Policy.Enter_Checkin_Policy_Attributes(driver, "capture", Acc_Checkin_Percentage2);
			Create_New_Policy.Enter_Policy_Desc(driver, PolicyText3, PolicyDesc);
			Create_New_Policy.Associate_Sources(driver);
			Create_New_Policy.Associate_Seasons(driver);
			Create_New_Policy.Associate_RoomClasses(driver);
			Create_New_Policy.Associate_RatePlans(driver);
			Create_New_Policy.Save_Policy(driver);
			Create_New_Policy.Close_Policy_Tab(driver);

			test.log(LogStatus.PASS, "New Checkin Policy saved successfully " + AccountPolicyName3);
			app_logs.info("New Checkin Policy saved successfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the Checkin policy" + AccountPolicyName3, testName,
					"CheckinPolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the Checkin policy" + AccountPolicyName3, testName,
					"CheckinPolicy");
		}
		try {

			Create_New_Policy.Verify_Policy(driver, AccountPolicyName3);
			test.log(LogStatus.PASS, "Created " + AccountPolicyName3 + " showing up in search results");
			app_logs.info("Created Checkin policy showing up in search results");
		} catch (Exception e) {
			Utility.updateReport(e,
					"Error! Created  " + AccountPolicyName3 + "Checkin policy is not showing up in search results",
					testName, "PolicySearch");

		} catch (Error e) {
			Utility.updateReport(e,
					"Error! Created  " + AccountPolicyName3 + "Checkin policy is not showing up in search results",
					testName, "PolicySearch");
		}

		try {

			Nav.Reservation(driver);
			test.log(LogStatus.PASS, "Navigated to Reservations");
			app_logs.info("Navigated to Reservations");
		} catch (Exception e) {

			Utility.updateReport(e, "Failed to navigate to Reservations page", testName, "ResNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Reservations page", testName, "ResNavigation");
		}
		try {

			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Clicked new Reservation button");
			app_logs.info("Clicked new Reservation button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewResPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed click new reservation button", testName, "NewResPage");
		}
		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.verifyPolicyAssociation(driver, ResPolicyName2, Policytype2);
			res.Save_Reservation_Pay_Deposit_Policy(driver, RoomClassName, PaymentType, CardName, CCNumber, CCExpiry,
					CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData, Deposit_percentage);
			Wait.wait2Second();
			Res_Confirmation_Number1 = res.GetReservationnumber(driver);
			res.Close_Tab(driver);
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "SaveReservation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "SaveReservation");
		}
		//
		/*
		 * Closing the Reservation Tab and Opening again with Search operation
		 * to Check in, As Direct check in is not working sometimes.Taking too
		 * much to to load check in policy pop up
		 */
		try {
			//

			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {

			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName,
					"ResSearch");

		} catch (Error e) {
			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName,
					"ResSearch");
		}

		try {

			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
			app_logs.info(GetEndingBalance);
			RemoveCurreny = GetEndingBalance.split(" ");
			endingbalance = Double.parseDouble(RemoveCurreny[1]);
			app_logs.info("Ending balance before checkin " + endingbalance);
			processedamount = res.Checkin(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType,
					CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,
					traceData);
			processed_percent = (processedamount / endingbalance) * 100;
			Assert.assertEquals(Math.round(processed_percent), Math.round(Double.parseDouble(Checkin_Percentage)),
					"Expected reservation Checkin percetage and processed percentage are not equal. Ending balance"
							+ endingbalance + "Processed amount is " + processedamount);
			Wait.wait2Second();
			ReservationPage.Click_Save_Close.click();
			Wait.wait3Second();
			test.log(LogStatus.PASS, "Reservation checkin success and Validated reservation Checkin policy");
			app_logs.info("Reservation checkin success and Validated reservation Checkin policy");
		} catch (Exception e) {
			Utility.updateReport(e, "Fail to checkin reservation and Failed to	 validate reservation Checkin policy",
					testName, "VerifyResPolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Fail to checkin reservation and Failed to validate reservation Checkin policy",
					testName, "VerifyResPolicy");
		}
		try {
			Nav.Accounts(driver);
			driver.navigate().refresh();
			Wait.explicit_wait_visibilityof_webelement(Accounts.Enter_AccountName_On_SearchPage);
			test.log(LogStatus.PASS, "Navigating to Accounts");
			app_logs.info("Navigating to Accounts");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		}

		try {

			try {
				Wait.wait2Second();
				app_logs.info("Searching for given account :" + AccountName);
				Accounts.Enter_AccountName_On_SearchPage.clear();
				Accounts.Enter_AccountName_On_SearchPage.sendKeys(AccountName);
				Accounts.Click_SearchBtn_On_AccountsPage.click();
				Wait.explicit_wait_visibilityof_webelement(Accounts.First_Element_In_Account_SearchResults);
				Accounts.First_Element_In_Account_SearchResults.click();
			} catch (Exception e) {
				app_logs.info("Given" + AccountName + " account not found,So creating new corp account");
				AccountName = "Autocorp " + Utility.getTimeStamp();
				CreateCorporteAccount.NewAccountbutton(driver, Accounttype);
				CreateCorporteAccount.AccountDetails(driver, Accounttype, AccountName);
				CreateCorporteAccount.AccountAttributes(driver, MargetSegment, Referral);
				CreateCorporteAccount.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber,
						alternativenumber, Address1, Address2, Address3, Email, City, State, Postalcode);
				CreateCorporteAccount.Billinginfo(driver);
				CreateCorporteAccount.Save(driver);
				test.log(LogStatus.PASS, "Entered all required details and created new corp account");
				app_logs.info("Entered all required details and created new corp account");

			}

			Wait.explicit_wait_visibilityof_webelement(Accounts.Select_Market_Segment);
			CreateCorporteAccount.navigateFolio(driver);
			Accounts.Click_Folio_Options.click();
			Wait.explicit_wait_visibilityof_webelement(Accounts.Select_Account_Checkin_Policy);
			new Select(Accounts.Select_Account_Checkin_Policy).selectByVisibleText(AccountPolicyName3);
			Wait.wait5Second();
			CreateCorporteAccount.SaveandClose(driver);
			test.log(LogStatus.PASS, "Successully associated created policy to " + AccountName);
			app_logs.info("Successully associated created policy to" + AccountName);
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to associate created policy to " + AccountName, testName,
					"AssociatePolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to associate created policy to " + AccountName, testName,
					"AssociatePolicy");
		}
		try {
			Nav.Reservation(driver);
			driver.navigate().refresh();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.New_Reservation_Button);
			test.log(LogStatus.PASS, "Navigating to Reservation");
			app_logs.info("Navigating to Reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Navigate Reservations", testName, "ReservationsNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to Navigate Reservations", testName, "ReservationsNavigation");
		}
		try {

			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Clicked new Reservation button");
			app_logs.info("Clicked new Reservation button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewResPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewResPage");
		}

		try {

			res.Associate_CCAccount(driver, AccountName);
			ReservationPage.Enter_First_Name.sendKeys(FirstName);
			ReservationPage.Enter_Last_Name.sendKeys(LastName);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.saveReservation(driver);
			Res_Confirmation_Number2 = res.GetReservationnumber(driver);
			res.Close_Tab(driver);
			driver.navigate().refresh();
			Wait.wait2Second();
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to create new reservation to verify account policy", testName,
					"AssociateCCAccount");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to create new reservation to verify account policy", testName,
					"AssociateCCAccount");
		}

		/*
		 * Closing the Reservation Tab and Opening again with Search operation
		 * to Check in, As Direct check in is not working sometimes.Taking too
		 * much to to load check in policy pop up
		 */
		try {

			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {
			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName, "Search");

		} catch (Error e) {
			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName, "Search");
		}
		try {
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
			app_logs.info(GetEndingBalance);
			RemoveCurreny = GetEndingBalance.split(" ");
			endingbalance = Double.parseDouble(RemoveCurreny[1]);
			app_logs.info("Ending balance before checkin " + endingbalance);
			processedamount = res.Checkin(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType,
					CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,
					traceData);
			processed_percent = (processedamount / endingbalance) * 100;
			Assert.assertEquals(Math.round(processed_percent), Math.round(Double.parseDouble(Acc_Checkin_Percentage2)),
					"Account Checkin percetage and processed percentage are not equal.Processed amount "
							+ processedamount);
			Wait.wait3Second();
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Account Reservation checkin success and Validated Account Checkin policy");
			app_logs.info("Account Reservation checkin success and Validated Account Checkin policy");
		} catch (Exception e) {
			Utility.updateReport(e,
					"Failed to checkin account reservation and Failed to validate Account Checkin policy", testName,
					"VerifyAccPolicy");

		} catch (Error e) {
			Utility.updateReport(e,
					"Failed to checkin account reservation and Failed to validate Account Checkin policy", testName,
					"VerifyAccPolicy");
		}

		extent.endTest(test);

	}

	// Deleting policies after test execution
	@AfterClass
	public void delete_Policies() throws InterruptedException

	{
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		try {
			driver.navigate().refresh();
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Inventory(driver);
			app_logs.info("Navigating to Inventory");
		} catch (Exception e) {
			app_logs.error("Failed to navigate to Inventory page" + e);

		} catch (Error e) {
			app_logs.error("Failed to navigate to Inventory page" + e);
		}
		try {

			Navigate.Menuitem_Policy_Text.click();
			Wait.explicit_wait_xpath(OR.Policy_Button);
			app_logs.info("Navigating to Policies");
		} catch (Exception e) {
			app_logs.error("Failed to navigate to Policies page" + e);

		} catch (Error e) {
			app_logs.error("Failed to navigate to Policies page" + e);
		}
		// Deleting policies after test execution

		try {
			Policies policy = new Policies();
			policy.Delete_Policy(driver, ResPolicyName1);
			policy.Delete_Policy(driver, ResPolicyName2);
			driver.navigate().refresh();
			Wait.wait2Second();
			policy.Delete_Policy(driver, AccountPolicyName3);
			app_logs.info("Deleted created Policies");
		} catch (Exception e) {
			app_logs.error("Failed to Delete all created Policies" + e);

		}

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("Res_Acc_Policy_Verification", excel);
	}

}
