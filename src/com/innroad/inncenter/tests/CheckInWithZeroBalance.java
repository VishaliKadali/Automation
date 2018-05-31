package com.innroad.inncenter.tests;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Policies;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationFolio;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.innroad.inncenter.webelements.WebElements_Policies;
import com.relevantcodes.extentreports.LogStatus;

public class CheckInWithZeroBalance extends TestCore {

	String ResPolicyName;

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void checkInWithZeroBalance(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData,
			String Policytype, String PolicyName, String Checkin_Percentage, String PolicyText, String PolicyDesc)
			throws InterruptedException, IOException {

		test = extent.startTest("CheckInWithZeroBalance", "CheckInWithZeroBalance").assignCategory("Check In")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		Reservation res = new Reservation();
		Navigation Nav = new Navigation();
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Policies Create_New_Policy = new Policies();
		ResPolicyName = Checkin_Percentage + "% " + Policytype + " " + PolicyName + Utility.getTimeStamp();
		PolicyText = Checkin_Percentage + "% " + Policytype + " " + PolicyName + PolicyText;
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}
		try {
			res.IPropertySelector(driver, PropertyName);
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
			WebElements_Policies PolicyElements = new WebElements_Policies(driver);
			Navigate.Menuitem_Policy_Text.click();
			Wait.explicit_wait_visibilityof_webelement(PolicyElements.New_Policy_Btn);
			test.log(LogStatus.PASS, "Navigating to Policies");
			app_logs.info("Navigated to Policies");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PolicyNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Policies page", testName, "PolicyNavigation");
		}

		try {

			Create_New_Policy.NewPolicybutton(driver, Policytype);
			test.log(LogStatus.PASS, "Navigate to new Policy by clicking on new Policy button");
			app_logs.info("Navigate to new Policy by clicking on new Policy button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to new Policy page", testName, "NewPolicyPage");
		}

		try {

			Create_New_Policy.Enter_Policy_Name(driver, ResPolicyName);
			Create_New_Policy.Enter_Checkin_Policy_Attributes(driver, "capture", Checkin_Percentage);
			Create_New_Policy.Enter_Policy_Desc(driver, PolicyText, PolicyDesc);
			Create_New_Policy.Associate_Sources(driver);
			Create_New_Policy.Associate_Seasons(driver);
			Create_New_Policy.Associate_RoomClasses(driver);
			Create_New_Policy.Associate_RatePlans(driver);
			Create_New_Policy.Save_Policy(driver);
			Create_New_Policy.Close_Policy_Tab(driver);

			test.log(LogStatus.PASS, "New Checkin Policy saved successfully " + ResPolicyName);
			app_logs.info("New Checkin Policy saved successfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the Checkin policy" + ResPolicyName, testName, "CheckinPolicy");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the Checkin policy" + ResPolicyName, testName, "CheckinPolicy");
		}

		try {

			Nav.Reservation(driver);
			test.log(LogStatus.PASS, "Navigate to Reservation");
			app_logs.info("Navigate to Reservation");
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
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewReservation");
		}

		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.verifyPolicyAssociation(driver, ResPolicyName, Policytype);
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		}

		try {
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			res.Pay_Balance_Amount(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
					ChangeAmount, ChangeAmountValue, traceData);
			res.GetReservationnumber(driver);
			ReservationPage.Click_Save_Close.click();
			test.log(LogStatus.PASS, "Sucessfully paid the balance");
			app_logs.info("Sucessfully paid the balance");

		} catch (Exception e) {
			Utility.updateReport(e, "Error! Failed to pay balance amount", testName, "PayBalanceAmount");
		} catch (Error e) {
			Utility.updateReport(e, "Error! Failed to pay balance amount", testName, "PayBalanceAmount");
		}

		/*
		 * Closing the Reservation Tab and Opening again with Search operation
		 * to Check in, As Direct check in is not working sometimes.Taking too
		 * much to to load check in policy pop up
		 */
		try {

			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			ReservationSearch search = new ReservationSearch();
			Wait.explicit_wait_visibilityof_webelement(resservationSearch.Basic_Res_Number);
			driver.navigate().refresh();
			Wait.wait2Second();
			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName,
					"ResservationSearch");
		} catch (Error e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName,
					"ResservationSearch");
		}

		try {
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Checkin);
			Wait.wait2Second();
			Actions action = new Actions(driver);
			action.moveToElement(ReservationPage.Click_Checkin).doubleClick().build().perform();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Room_Assignment_PopUp);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Select);
			Wait.wait1Second();
			ReservationPage.Click_Select.click();

			try {
				Wait.wait2Second();
				if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
					ReservationPage.Click_Continue_RuleBroken_Popup.click();
				} else {
					app_logs.info("Satisfied Rules");
				}
			} catch (Exception | AssertionError e) {
				app_logs.info("Verification failed");
			}
			try {
				Wait.wait2Second();
				ReservationPage.Confirm_button.click();
			} catch (Exception e) {
				app_logs.info("No Dirty Rooms");
			}

			try {
				Wait.wait2Second();
				if (ReservationPage.ReCalculate_Folio_Options_PopUp.isDisplayed()) {
					ReservationPage.ReCal_Folio_Options_PopUp_No_Charge_Changed.click();
					Wait.wait2Second();
					ReservationPage.ReCal_Folio_Options_PopUp_Select_Btn.click();

				}
			} catch (Exception e) {
				app_logs.info("No ReCalculate Folio Options PopUp");
			}

			try {
				if (ReservationPage.Payment_Popup.isDisplayed()) {
					Assert.fail("Payment details pop-up is showinup while checking-in the zero balance reservation");
				}
			} catch (Exception e) {
				app_logs.info("No Payment PopUp");
			}
			test.log(LogStatus.PASS, "Validated Payment details pop-up while checking-in the zero balance reservation");
			app_logs.info("Validated Payment details pop-up while checking-in the zero balance reservation");

		} catch (Exception e) {
			Utility.updateReport(e, "Error! While checking-in the zero balance reservation", testName, "Checkin");
		} catch (Error e) {
			Utility.updateReport(e, "Error! While checking-in the zero balance reservation", testName, "Checkin");
		}
		try {
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_on_confirm);
			Wait.wait2Second();
			ReservationPage.Click_on_confirm.click();
			Wait.wait2Second();
			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				app_logs.info("Toaster_Title Text " + ReservationPage.Toaster_Title.getText());
				String getToastermessage_ReservationSucess = ReservationPage.Toaster_Message.getText();
				app_logs.info("Toaster_Message " + getToastermessage_ReservationSucess);
			}
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			String res_status = new Select(ReservationPage.Reservation_Status).getFirstSelectedOption().getText();
			Assert.assertEquals(res_status, "In-House",
					"Failed to check in Reservation or updating in roomstatus after checkin");
			test.log(LogStatus.PASS,
					"Sucessfully Checked in and Validated Payment details pop-up while checking-in the zero balance reservation");
			app_logs.info(
					"Sucessfully Checked in and Validated Payment details pop-up while checking-in the zero balance reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to checkin the zero balance reservation", testName, "RoomStatus");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to checkin the zero balance reservation", testName, "RoomStatus");
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
			WebElements_Policies PolicyElements = new WebElements_Policies(driver);
			Navigate.Menuitem_Policy_Text.click();
			Wait.explicit_wait_visibilityof_webelement(PolicyElements.New_Policy_Btn);
			app_logs.info("Navigating to Policies");
		} catch (Exception e) {
			app_logs.error("Failed to navigate to Policies page" + e);

		} catch (Error e) {
			app_logs.error("Failed to navigate to Policies page" + e);
		}

		try {
			Policies policy = new Policies();
			policy.Delete_Policy(driver, ResPolicyName);
			app_logs.info("Deleted created Policies");
		} catch (Exception e) {
			app_logs.error("Failed to Delete all created Policies" + e);

		}

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheet name provided

		return Utility.getData("CheckInWithZeroBalance", excel);
	}

}
