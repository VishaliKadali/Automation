package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Distribution;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.Tapechart;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.LogStatus;

public class BlackoutRoom extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData", groups = "Regression")
	public void BlackOutTheRooms(String url, String ClientCode, String Username, String Password, String Blackout,
			String ClientType, String Client1, String Client2) throws InterruptedException, IOException {

		test = extent.startTest("BlackoutRoom", "Creation of blackout room and verify in reservation")
				.assignCategory("Reservation").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Login LOGIN = new Login();

		Navigation nav = new Navigation();

		Distribution distribution = new Distribution();

		Tapechart tapechart = new Tapechart();

		// Login to InnCenter
		try {

			LOGIN.login(driver, url, ClientCode, Username, Password);
			Wait.wait10Second();
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}

		// Inventory
		try {

			nav.Inventory(driver);

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click Inventory", testName, "Inventory");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click Inventory", testName, "Inventory");
		}
         // Blackout
		try {

			distribution.BlackOutRoom(driver, test, true, Client1, Client2);
			Wait.wait2Second();
			test.log(LogStatus.PASS, "Room has been black out successfully");
			app_logs.info("Room has been black out successfully");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to find blackout room ", testName, "BlackOut");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to find blackout room ", testName, "BlackOut");
		}

		// Reservation
		try {

			tapechart.Verify_BlackOutRoom(driver);
			test.log(LogStatus.PASS, "Varify room has been black out in Tapchart and New Quote");
			app_logs.info("Varify room has been black out in Tapchart and New Quote");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to find blackout room in Tapchart and New Quote  ", testName, "BlackOut");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to find blackout room in Tapchart and New Quotess ", testName, "BlackOut");
		}

		// Inventory
		try {

			nav.Inventory(driver);

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click Inventory", testName, "Inventory");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to click Inventory", testName, "Inventory");
		}
		
		// Blackout
		try {

			distribution.BlackOutRoom(driver, test, false, Client1, Client2);
			test.log(LogStatus.PASS, "Uncheck blackout room successfully");
			app_logs.info("Uncheck blackout room successfully");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to uncheck blackout room", testName, "BlackOut");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to uncheck blackout room", testName, "BlackOut");
		}

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided

		return Utility.getData("BlackoutRoom", excel);
	}

}
