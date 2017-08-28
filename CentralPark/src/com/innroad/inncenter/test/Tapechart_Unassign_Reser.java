package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.Tapechart;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tapechart_Unassign_Reser extends testCore {
	
	@BeforeTest
	public void checkRunMode() {

		PropertyConfigurator.configure("Log4j.properties");

		if (!Utility.isExecutable("Tapechart_Unassign_Reser", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");

	}
	 
	 
	 
	@Test(dataProvider = "getData")
	public void TapechartUnassignedReservation(String url, String ClientCode, String Username, String Password,
			String PropertyName, String TapeChartAdults, String TapeChartChildrens, String PromoCode,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext) throws InterruptedException, IOException {
		
		ExtentTest test = extent.startTest("Tapechart_Unassign_Reser", "Creating Unassigned Reservation from Tapechart")
				                .assignCategory("Tapchart")
				                .assignCategory("Sanity");
		
		System.out.println("Executing: " + test.getTest().getName()+ " test.");
		
		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "Login successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login unsuccess");
		}

		try {
			Reservation res = new Reservation();
			res.IPropertySelector(driver, PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to select property");
		}

		try {
			Navigation nav = new Navigation();
			nav.TapeChart(driver);
			test.log(LogStatus.PASS, "Navigate to Tapechart Success");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to navigate to Tapechart");
		}

		try {
			Tapechart TS = new Tapechart();
			TS.click_Unassigned(driver);
			test.log(LogStatus.PASS, "Successfully clicked on Unnasigned");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to click on Unnasigned link");
		}

		try {
			Reservation res = new Reservation();
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Created Unassigned Reservation from Tapechart success");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to create reservation from Tapechart");
		}
		extent.endTest(test);
	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("Tapechart_Unassign_Reser", excel);
	}

}
