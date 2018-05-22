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
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.relevantcodes.extentreports.LogStatus;

public class VerifySaveBtnFuncForReservation extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void verifySaveBtnFuncForReservation(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData

	) throws InterruptedException, IOException {

		test = extent.startTest("VerifySaveBtnFunctionalityForReservation", "VerifySaveBtnFunctionalityForReservation")
				.assignCategory("Reservation").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Boolean SaveBtnStatus;
		Reservation res = new Reservation();
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
		}  catch (Exception e) {
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
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");

		}  catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		}

		try {

			app_logs.info("Save button status before making payments "+ ReservationPage.Click_Save_ReservationDetails.isEnabled());
			res.Pay_Balance_Amount(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
					ChangeAmount, ChangeAmountValue, traceData);
			SaveBtnStatus = ReservationPage.Click_Save_ReservationDetails.isEnabled();
			Assert.assertTrue(SaveBtnStatus, "Save button is not enabled after making payments");
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Save button is re-enabled after making payments");
			app_logs.info("Save button is re-enabled after making payments");
		}  catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after making payments", testName, "VerifySaveAMP");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after making payments", testName, "VerifySaveAMP");
		}

		try {

			app_logs.info("Save button status before adding LineItem "
					+ ReservationPage.Click_Save_ReservationDetails.isEnabled());
			ReservationPage.Add_LineItem.click();
			Wait.wait2Second();
			Utility.ScrollToElement(ReservationPage.Select_LineItem_Category);
			Wait.wait2Second();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Select_LineItem_Category);
			new Select(ReservationPage.Select_LineItem_Category).selectByIndex(3);
			ReservationPage.Enter_LineItem_Amount.sendKeys("10");
			ReservationPage.Commit_LineItem.click();
			Wait.wait1Second();
			SaveBtnStatus = ReservationPage.Click_Save_ReservationDetails.isEnabled();
			Assert.assertTrue(SaveBtnStatus, "Save button is not enabled after adding LineItem");
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Save button is re-enabled after adding LineItem");
			app_logs.info("Save button is re-enabled after adding LineItem");
		}  catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after adding LineItem", testName, "VerifySaveAAL");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after adding LineItem", testName, "VerifySaveAAL");
		}

		try {

			Utility.ScrollToElement(ReservationPage.Guestinfo);
			Wait.wait2Second();
			ReservationPage.Guestinfo.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Reservation_market_Segment);
			Utility.ScrollToElement(ReservationPage.Enter_First_Name);
			Wait.wait1Second();
			app_logs.info("Save button status before updating: " + ReservationPage.Click_Save_ReservationDetails.isEnabled());
			ReservationPage.Enter_First_Name.clear();
			ReservationPage.Enter_Last_Name.clear();
			ReservationPage.Enter_First_Name.sendKeys("EditedFName");
			ReservationPage.Enter_Last_Name.sendKeys("EditedLName");
			Wait.wait1Second();
			SaveBtnStatus = ReservationPage.Click_Save_ReservationDetails.isEnabled();
			Assert.assertTrue(SaveBtnStatus, "Save button is not re-enabled after editing First and Last Name");
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Save button is re-enabled after editing First and Last Name");
			app_logs.info("Save button is re-enabled after editing First and Last Name");
		}  catch (Exception e) {
			Utility.updateReport(e, "Save button is not re-enabled after editing First and Last Name ", testName, "VerifySaveAAFN");
		} catch (Error e) {
			Utility.updateReport(e, "Save button is not re-enabled after editing First and Last Name ", testName, "VerifySaveAAFN");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheet-name provided
		return Utility.getData("VerifySaveBtnFuncForReservation", excel);

	}

}
