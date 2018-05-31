package com.innroad.inncenter.tests;

import org.openqa.selenium.support.ui.Select;
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

import org.testng.Assert;

public class RetainPaymentInfoAfterEdit extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void retainPaymentInfoAfterEdit(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String Fname, String Lname, String Ptype, String VisaCCNumber,
			String VisaBillingNotes, String VisaExpiryDate) throws InterruptedException {

		test = extent.startTest("RetainPaymentInfoAfterEdit", "Retain PaymentInfo AfterEdit")
					 .assignCategory("Reservations")
					 .assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
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
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "ReservationDetails");
		}

		try {

			res.Add_Payment_Info(driver, saluation, FirstName, LastName, Line1, Line2, Line3, City, Country, State,
					Postalcode, Phonenumber, alternativenumber, Email, PaymentMethod, AccountNumber, VisaExpiryDate,
					VisaBillingNotes);
			ReservationPage.Click_Save_ReservationDetails.click();
			try {
				Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_Toaster_Container);
				String getTotasterTitle_ReservationSucess = ReservationPage.Toaster_Title.getText();
				Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");
			} catch (Exception e) {
				Assert.fail("Error in Saving the reservation after adding payment info ");
			}
			test.log(LogStatus.PASS, "Sucessfully saved the reservation after adding payment info");
			app_logs.info("Sucessfully saved the reservation after adding payment info");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! in Saving the reservation after adding payment info", testName,
					"AddPaymentInfo");
		} catch (Error e) {
			Utility.updateReport(e, "Error! in Saving the reservation after adding payment info", testName,
					"AddPaymentInfo");
		}

		try {
			if (ReservationPage.Payment_Info_Textarea.getAttribute("value").contains(FirstName)) {
				app_logs.info("Added FirstName showingup in textarea after saving reservation");

			} else {
				Assert.fail("Added FirstName is not showingup in textarea after saving reservation");
			}

			if (ReservationPage.Payment_Info_Textarea.getAttribute("value").contains(PaymentMethod)) {
				app_logs.info("Added PaymentMethod showingup in textarea after saving reservation");

			} else {
				Assert.fail("Added PaymentMethod is not showingup in textarea after saving reservation");
			}
			test.log(LogStatus.PASS, "Sucessfully Verified added payment info in Textarea");
			app_logs.info("Sucessfully Verified added payment info in Textarea");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! Failed to Verify added payment info in Textarea", testName,
					"VerifyPaymentInfoInTextarea");
		} catch (Error e) {
			Utility.updateReport(e, "Error! Failed to Verify added payment info in Textarea", testName,
					"VerifyPaymentInfoInTextarea");
		}

		try {
			Wait.wait5Second();
			Utility.ScrollToElement(ReservationPage.Click_Show_PaymentInfo);
			Wait.wait2Second();
			ReservationPage.Click_Show_PaymentInfo.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Folio_Billing_Info_Popup);
			Wait.wait5Second();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Enter_First_Name_PaymentInfo_Popup);
			Assert.assertEquals(ReservationPage.Enter_First_Name_PaymentInfo_Popup.getAttribute("value"), FirstName,
					"First name is not retained in payment info popup");
			Assert.assertEquals(new Select(ReservationPage.Select_Payment_Method_PaymentInfo_Popup)
					.getFirstSelectedOption().getText(), PaymentMethod,
					"PaymentMethod is not retained in payment info popup");
			ReservationPage.Enter_First_Name_PaymentInfo_Popup.click();
			ReservationPage.Enter_First_Name_PaymentInfo_Popup.clear();
			ReservationPage.Enter_First_Name_PaymentInfo_Popup.sendKeys(Fname);
			ReservationPage.Enter_Last_Name_PaymentInfo_Popup.clear();
			ReservationPage.Enter_Last_Name_PaymentInfo_Popup.sendKeys(Lname);
			new Select(ReservationPage.Select_Payment_Method_PaymentInfo_Popup).selectByVisibleText(Ptype);
			ReservationPage.Enter_Account_Number_PaymentInfo_Popup.sendKeys(VisaCCNumber);
			ReservationPage.Enter_CardExpiryDate_PaymentInfo_Popup.sendKeys(VisaExpiryDate);
			ReservationPage.Enter_BillingNotes_PaymentInfo_Popup.sendKeys(VisaBillingNotes);
			ReservationPage.Save_Btn_PaymentInfo_Popup.click();

			Wait.wait5Second();
			app_logs.info(ReservationPage.Payment_Info_Textarea.getAttribute("value"));
			ReservationPage.Click_Save_ReservationDetails.click();
			try {
				Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_Toaster_Container);
				String getTotasterTitle_ReservationSucess = ReservationPage.Toaster_Title.getText();
				Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");
			} catch (Exception e) {
				Assert.fail("Error in Saving the reservation after updating payment info ");
			}

			test.log(LogStatus.PASS,"Sucessfully Validated Previously added payment info and updated payment info in popup");
			app_logs.info("Sucessfully Validated Previously added payment info and updated payment info in popup");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! in Retaining or updating payment info in popup", testName,
					"VerifyPaymentInfoInPopUP");
		} catch (Error e) {
			Utility.updateReport(e, "Error! in Retaining or updating payment info in popup", testName,
					"VerifyPaymentInfoInPopUP");
		}

		try {
			Wait.wait2Second();
			if (ReservationPage.Payment_Info_Textarea.getAttribute("value").contains(Fname)) {
				app_logs.info("Updated First Name is showingup in textarea after saving the reservation");

			} else {
				app_logs.info("Updated Payment_Info is not showingup in textarea after saving the reservation");
			}

			if (ReservationPage.Payment_Info_Textarea.getAttribute("value").contains(Ptype)) {
				app_logs.info("Updated Payment type showingup in textarea after saving the reservation");

			} else {
				Assert.fail("Updated Payment_Info is not showingup in textarea after saving the reservation");
			}

			test.log(LogStatus.PASS, "Sucessfully Verified updated payment info in Textarea");
			app_logs.info("Sucessfully Verified updated payment info in Textarea");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! Failed to Verify updated payment info in Textarea", testName,
					"VerifyupdatedpmntinfoInTA");
		} catch (Error e) {
			Utility.updateReport(e, "Error! Failed to Verify updated payment info in Textarea", testName,
					"VerifyupdatedpmntinfoInTA");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

//		return test data from the sheet-name provided
		return Utility.getData("RetainPaymentInfoAfterEdit", excel);
	}
}
