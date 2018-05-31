package com.innroad.inncenter.tests;

import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.LogStatus;

public class CheckoutWithZeroBalance extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void checkoutWithZeroBalance(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)
			throws InterruptedException, IOException {

		test = extent.startTest("CheckOutWithZeroBalance", "CheckOutWithZeroBalance")
					 .assignCategory("Check Out")
					 .assignCategory("Regression");
		
		String testName = test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
		Reservation res = new Reservation();
		
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		ReservationSearch search = new ReservationSearch();
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		
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
			res.IPropertySelector(driver, PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}
*/		
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
			res.saveReservation(driver);
			res.GetReservationnumber(driver);
			res.Close_Tab(driver);
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		}

		/*
		 * Closing the Reservation Tab and Opening again with Search operation
		 * to Check in, As Direct check in is not working sometimes.Taking too
		 * much to to load check in policy pop up
		 */
		try {

			driver.navigate().refresh();
			Wait.explicit_wait_visibilityof_webelement(resservationSearch.Basic_Res_Number);
			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName, "BasicSearch");
		} catch (Error e) {
			Utility.updateReport(e, "System failed to validate Basic Search with Reservation number", testName, "BasicSearch");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Checkin);
			res.Checkin(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType, CardName, CCNumber,
					CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
			test.log(LogStatus.PASS, "Sucessfully checked in");
			app_logs.info("Sucessfully checked in");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to checkin", testName, "Checkin");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to checkin", testName, "Checkin");
		}

		try {
			res.Pay_Balance_Amount(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
					ChangeAmount, ChangeAmountValue, traceData);
			res.GetReservationnumber(driver);
			test.log(LogStatus.PASS, "Sucessfully paid the balance");
			app_logs.info("Sucessfully paid the balance");

		} catch (Exception e) {
			Utility.updateReport(e, "Error! Failed to pay balance amount", testName, "PayBalanceAmount");
		} catch (Error e) {
			Utility.updateReport(e, "Error! Failed to pay balance amount", testName, "PayBalanceAmount");
		}

		try {

			ReservationPage.Click_Checkout.click();
			Wait.wait5Second();
			if (ReservationPage.Payment_Popup.isDisplayed()) {
				Assert.fail(
						"Payment details pop-up is showing up while checking- Out with the zero balance reservation");
			}

			if (ReservationPage.Resell_Rooms_Popup.isDisplayed()) {
				ReservationPage.Resell_Rooms_Popup_Continue_Btn.click();
			} else {
				app_logs.info("No resell_Rooms_Popup");
			}

			try {
				Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Close);
				ReservationPage.Click_Close.click();
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				ReservationPage.Click_Close.click();
			}
			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				app_logs.info("Toaster_Title Text " + ReservationPage.Toaster_Title.getText());
				String getToastermessage_ReservationSucess = ReservationPage.Toaster_Message.getText();
				app_logs.info("Toaster_Message " + getToastermessage_ReservationSucess);
			}
			
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			String res_status = new Select(ReservationPage.Reservation_Status).getFirstSelectedOption().getText();
			Assert.assertEquals(res_status, "Departed","Failed to checkout Reservation or updating in roomstatus after checkout");
			test.log(LogStatus.PASS,"Sucessfully Checked out and Validated Payment details pop-up while checking-out the zero balance reservation");
			app_logs.info("Sucessfully Checked out and Validated Payment details pop-up while checking-out the zero balance reservation");
			
		} catch (Exception e) {
			Utility.updateReport(e, "Error! while checking-out the zero balance reservation", testName, "Checkout");
		} catch (Error e) {
			Utility.updateReport(e, "Error! while checking-out the zero balance reservation", testName, "Checkout");
		}
		extent.endTest(test);
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("CheckOutWithZeroBalance", excel);
	}

}
