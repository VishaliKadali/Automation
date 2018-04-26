package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.Tapechart;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tapechart_Unassign_Reser extends TestCore {

	
	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void tapeChartUnassignedReservation(String url, String ClientCode, String Username, String Password,
			String PropertyName, String TapeChartAdults, String TapeChartChildrens, String PromoCode,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext) throws InterruptedException, IOException {

		test = extent.startTest("Tapechart_Unassign_Reser", "Creating Unassigned Reservation from Tapechart")
				.assignCategory("Tapchart")
				.assignCategory("Sanity");
		
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
			test.log(LogStatus.FAIL, "Failed to login into the application \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Login_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to login into the application \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		Reservation res = new Reservation();

		try {
			Navigation nav = new Navigation();
			nav.TapeChart(driver);
			test.log(LogStatus.PASS, "Navigated to Tapechart");
			app_logs.info("Navigated to Tapechart");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to tapechart module \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Tapechart_Navigation" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to navigate to tapechart module \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			Tapechart TS = new Tapechart();
			TS.click_Unassigned(driver);
			test.log(LogStatus.PASS, "Clicked on Unnassigned cell from tapechart");
			app_logs.info("Clicked on Unnassigned cell from tapechart");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to click on Unnasigned link \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Tapechart_Unnasigned" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to click on Unnasigned link \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			app_logs.info("Entered marketing information");
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			app_logs.info("Entered contact information");
			res.saveReservation(driver);
			app_logs.info("Saved the reservation");
			test.log(LogStatus.PASS, "Created Unassigned Reservation from Tapechart success");
			app_logs.info("Created Unassigned Reservation from Tapechart success");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to create reservation from Tapechart \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Create_Reservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to create reservation from Tapechart \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}
		extent.endTest(test);
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("Tapechart_Unassign_Reser", excel);
		
	}

}
