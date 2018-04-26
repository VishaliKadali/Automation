package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BulkCheckinCheckout extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void bulkCheckinCheckout(String url, String ClientCode, String Username, String Password,
			String PropertyName, String GuestName) throws InterruptedException, IOException {

		ExtentTest test = extent.startTest("BulkCheckinCheckout", "Bulk-Checkin and Bulk-Checkout")
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

		ReservationSearch ReservationSearchpage = new ReservationSearch();
		
		try {
			ReservationSearchpage.basicSearch_WithResNumber(driver);
			app_logs.info("Searching for the reservation with ReservationNumber");
			ReservationSearchpage.Bulkcheckin(driver, GuestName);
			test.log(LogStatus.PASS, "Bulk checkin is successful");
			app_logs.info("Bulk checkin is successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to perform Bulk checkin \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Bulk_CheckIn_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to perform Bulk checkin \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
//			ReservationSearch ReservationSearchpage = new ReservationSearch();
			ReservationSearchpage.Bulkcheckout(driver, GuestName);
			test.log(LogStatus.PASS, "Bulk checkout is successful");
			app_logs.info("Bulk checkin is successful");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to perform Bulk checkout \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Bulk_CheckOut_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to perform Bulk checkout \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}
		
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("BulkCheckinCheckout", excel);
	}

}
