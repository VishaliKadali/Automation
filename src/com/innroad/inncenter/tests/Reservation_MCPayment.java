package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationFolio;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation_MCPayment extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void Reservation_mCPayment(String url, String ClientCode, String Username, String Password,
			String PropertyName, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2,
			String Line3, String City, String Country, String State, String Postalcode, String Phonenumber,
			String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext,
			String Nights, String Adults, String Children, String RatepromoCode, String CheckorUncheckAssign,
			String RoomClassName, String RoomNumber, String PaymentType, String CardName, String CCNumber,
			String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue,
			String traceData

	) throws InterruptedException, IOException {
		
		ExtentTest test = extent
				.startTest("Reservation_MCPayment", "Creating reservation with payment method as Master Card")
				.assignCategory("Reservations").assignCategory("Sanity");

		String testName=test.getTest().getName().toUpperCase();
		
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

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
		
		try {
			res.clickNewReservationButton(driver);
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.saveReservation(driver);
			ReservationFolio rs = new ReservationFolio();
			rs.paymentMethod(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
					ChangeAmount, ChangeAmountValue, traceData);
			Wait.wait15Second();
			res.saveReservation(driver);
			app_logs.info("Created Reservation with MC Success");
			test.log(LogStatus.PASS, "Create Reservation with MC Success");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Create Reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_MCPayAndSaveReservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Create Reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		extent.endTest(test);
	}

	@DataProvider
	public Object[][] getData() {

//		return test data from the sheet-name provided
		return Utility.getData("Reservation_MCPayment", excel);
		
	}
}
