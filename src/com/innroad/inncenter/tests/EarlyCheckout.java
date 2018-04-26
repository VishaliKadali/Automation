package com.innroad.inncenter.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EarlyCheckout extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void earlyCheckout(String url, String ClientCode, String Username, String Password, String PropertyName,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData, String subject,
			String details, String NoteType, String Notestatus, String env) throws InterruptedException, IOException {

		// Creating test object for Extent Reports and adding meta information to the report
		ExtentTest test = extent.startTest("EarlyCheckout", "Verifying Early Checkout").assignCategory("Reservations")
				.assignCategory("Sanity");

		String testName=test.getTest().getName().toUpperCase();
		
		// Printing test name to the console which is useful for debugging
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		// Logging into the inncenter application
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Login into the application \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Login_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Login into the application \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		Reservation res = new Reservation();

		// Creating a new reservation with Notes and Clicking on Save button
		try {
			res.clickNewReservationButton(driver);
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			Navigation nav = new Navigation();
			nav.Guest_info(driver);
			Wait.wait5Second();
			res.AddNotes(driver, subject, details, NoteType, Notestatus);
			Wait.wait5Second();

			res.saveReservation(driver);
			app_logs.info("Create Reservation is Successful");
			test.log(LogStatus.PASS, "Create Reservation is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Create Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CreateReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Create Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		// Check In Reservation
		try {
			res.Checkin(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType, CardName, CCNumber,
					CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
			app_logs.info("Reservation Check In is Successful");
			test.log(LogStatus.PASS, "Reservation Check In is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Check In the Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CheckInReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Check In the Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		// Checking out the reservation early
		try {
			res.checkout(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount,
					ChangeAmountValue, traceData);
			app_logs.info("Reservation Check Out is Successful");
			test.log(LogStatus.PASS, "Reservation Check Out is Successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Check Out the Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CheckOutReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Check Out the Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		// Validation point: Verifying Checkout message after early checkout
		try {
			String expEarlyCheckOutMessage = "CHECKED OUT";
			String actEarlyCheckOutMessage = driver.findElement(By.xpath(OR.Early_CheckOut)).getText();

			String expReservationStatus = "Departed";
			String actReservationStatus = new Select(driver.findElement(By.xpath(OR.Reservation_Status_Dropdown)))
					.getFirstSelectedOption().getText();

			if (actEarlyCheckOutMessage.contains(expEarlyCheckOutMessage)) {
				if (actReservationStatus.contains(expReservationStatus)) {
					app_logs.info("Checkout message is displayed after early checkout and Reservation status is changed to 'Departed'");
					test.log(LogStatus.PASS, "Checkout message is displayed after early checkout and Reservation status is changed to 'Departed'");
				} else {
					app_logs.info("Checkout message is displayed after early checkout but Reservation status is NOT changed to 'Departed'" + actReservationStatus);
					test.log(LogStatus.FAIL, "Checkout message is displayed after early checkout but Reservation status is NOT changed to 'Departed'" + actReservationStatus);
				}
			} else {
				app_logs.info("Checkout message is NOT displayed after early checkout");
				test.log(LogStatus.FAIL, "Checkout message is NOT displayed after early checkout");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Early Checkout Validation Failure \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_EarlyCheckoutValidation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Early Checkout Validation Failure \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		// Saving the reservation
		try {
			res.saveReservation(driver);
			app_logs.info("Reservation is Saved Successfully");
			test.log(LogStatus.PASS, "Reservation is Saved Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Save the Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_SaveReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Save the Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		extent.endTest(test);
	}

	// Reading test data
	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("EarlyCheckout", excel);
	}

}
