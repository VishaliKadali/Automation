package com.innroad.inncenter.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
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
import com.innroad.inncenter.webelements.Elements_TapeChart;
import com.innroad.inncenter.webelements.WebElementsOverview;
import com.relevantcodes.extentreports.LogStatus;

public class CreateResWithOverridenRate extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void createReservationWithOverriddenRate(String url, String ClientCode, String Username, String Password,
			String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData,
			String OverriddenRate) throws InterruptedException {

		test = extent.startTest("CreateResWithOverridenRate", "Create Reservation With Overridden Rate")
				.assignCategory("Rates").assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");

		Reservation res = new Reservation();
		String BeforeRate="";
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
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Inventory(driver);
			test.log(LogStatus.PASS, "Navigated to Inventory");
			app_logs.info("Navigated to Inventory");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		}

		try {
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Overview(driver);
			test.log(LogStatus.PASS, "Navigated to Overview");
			app_logs.info("Navigated to Overview");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Overview page", testName, "OverviewNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Overview page", testName, "OverviewNavigation");
		}

		try {
			WebElementsOverview Overview = new WebElementsOverview(driver);
			BeforeRate=Overview.Get_Rack_Rate.getText();
			app_logs.info("Before Rate :"+BeforeRate);
			Utility.ScrollToElement(Overview.Edit_Rate);
			Overview.Edit_Rate.click();
			driver.switchTo().frame(0);
			Wait.explicit_wait_visibilityof_webelement(Overview.Rates_Override_Info_Popup);
			Overview.First_Roomclass_P1_Rate.clear();
			Overview.First_Roomclass_P1_Rate.sendKeys(OverriddenRate);
			Overview.Done_Btn_In_Rates_Override_Info_Popup.click();
			Wait.wait2Second();
			Assert.assertEquals(Overview.Get_Rack_Rate.getText().replaceAll(".00", ""), OverriddenRate,
					"Overridden Rate is not showingup on table after saving");
			test.log(LogStatus.PASS, "Successfully Overrided the Rate and Verifed it on Overview Screen");
			app_logs.info("Successfully Overrided the Rate and Verifed it on Overview Screen");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Override the Rate", testName, "RateOverride");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Override the Rate", testName, "RateOverride");
		}

		try {
			Navigation ReservationsNavigation = new Navigation();
			ReservationsNavigation.Reservation(driver);
			test.log(LogStatus.PASS, "Navigated to Reservation");
			app_logs.info("Navigated to Reservation");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Reservations page", testName, "ReservationNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Reservations page", testName, "ReservationNavigation");
		}

		try {
			Navigation TapechartNavigation = new Navigation();
			TapechartNavigation.TapeChart(driver);
			test.log(LogStatus.PASS, "Navigated to TapeChart");
			app_logs.info("Navigated to TapeChart");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to TapeChart page", testName, "TapeChartNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to TapeChart page", testName, "TapeChartNavigation");
		}

		try {
			Elements_TapeChart TapechartPage = new Elements_TapeChart(driver);
			TapechartPage.Select_Arrival_Date.click();
			TapechartPage.Click_Today.click();
			TapechartPage.Enter_Adults_Tapehchart.sendKeys(Adults);
			Wait.wait2Second();
			TapechartPage.Click_Search_TapeChart.click();
			Wait.explicit_wait_visibilityof_webelement(TapechartPage.Click_First_Available_In_First_Roomclass);
			Assert.assertEquals(TapechartPage.FirstRoomClass_Rate_In_Tapechart.getText().replace("$", ""),
					OverriddenRate, "Overridden Rate is not showingup for the RoomClass on Tapechart upon searching.");
			Utility.ScrollToElement(TapechartPage.Click_First_Available_In_First_Roomclass);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-250)", "");
			Wait.wait2Second();
			TapechartPage.Click_First_Available_In_First_Roomclass.click();
			try {
				Wait.wait3Second();
				if (TapechartPage.Rules_Broken_popup.isDisplayed()) {
					TapechartPage.Click_Book_icon_Tapechart.click();
					app_logs.info("Clicked on continue button of RulesBroken Popup");
				} else {
					app_logs.info("Satisfied Rules");
				}

			} catch (Exception e) {

			}
			test.log(LogStatus.PASS, "Successfully Verified Overridden Rate on TapeChart");
			app_logs.info("Successfully Verified Overridden Rate on TapeChart");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Verify Overridden Rate on TapeChart page", testName,
					"BookingWithOverridenRate");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Verify Overridden Rate on TapeChart page", testName,
					"BookingWithOverridenRate");
		}

		try {
			Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.saveReservation(driver);
			test.log(LogStatus.PASS, "Successfully created Reservation with Overridden Rate");
			app_logs.info("Successfully created Reservation with Overridden Rate");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to create Reservation with Overridden Rate", testName,
					"ReservationDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to create Reservation with Overridden Rate", testName,
					"ReservationDetails");
		}
		try {
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Inventory(driver);
			test.log(LogStatus.PASS, "Navigated to Inventory to Revert the Rate");
			app_logs.info("Navigated to Inventory to Revert the Rate");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page to Revert the Rate", testName, "InventoryNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page to Revert the Rate", testName, "InventoryNavigation");
		}

		try {
			Navigation inventoryNavigation = new Navigation();
			inventoryNavigation.Overview(driver);
			test.log(LogStatus.PASS, "Navigated to Overview to Revert the Rate");
			app_logs.info("Navigated to Overview to Revert the Rate");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Overview page to Revert the Rate", testName, "OverviewNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Overview page to Revert the Rate", testName, "OverviewNavigation");
		}

		try {
			WebElementsOverview Overview = new WebElementsOverview(driver);
			Utility.ScrollToElement(Overview.Edit_Rate);
			Overview.Edit_Rate.click();
			driver.switchTo().frame(0);
			Wait.explicit_wait_visibilityof_webelement(Overview.Rates_Override_Info_Popup);
			Overview.First_Roomclass_P1_Rate.clear();
	    	Overview.Done_Btn_In_Rates_Override_Info_Popup.click();
			driver.switchTo().defaultContent();
			Wait.wait3Second();
			Assert.assertEquals(Overview.Get_Rack_Rate.getText(), BeforeRate,
					"Reverted Rate is not showingup on table after saving");
			test.log(LogStatus.PASS, "Successfully Reverted the Overridden Rate to Before Rate and Verifed it on Overview Screen");
			app_logs.info("Successfully Reverted the Overridden Rate to Before Rate and Verifed it on Overview Screen");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Revert the Overridden Rate to Before Rate", testName, "RevertRate");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Revert the Overridden Rate to Before Rate", testName, "RevertRate");
		}
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("CreateResWithOverridenRate", excel);

	}
}
