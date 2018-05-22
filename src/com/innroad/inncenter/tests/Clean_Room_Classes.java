package com.innroad.inncenter.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Housekepping_Status;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.relevantcodes.extentreports.LogStatus;

public class Clean_Room_Classes extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void clean_Room_Classes(String url, String ClientCode, String Username, String Password, String propertyName,
			String itemsperpage, String roomcondition) throws Exception {
		test = extent.startTest("Clean_Room_Classes", "Cleaning Room Classes Test")
				.assignCategory("Housekeeping Status").assignCategory("Regression");
		

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		
//		Reservation res = new Reservation();

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
			res.IPropertySelector(driver, propertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}
*/
		try {
			Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
			Navigate.Guest_Services_Main_Menu.click();
			Wait.explicit_wait_xpath(OR.Guest_Services_grid);
			test.log(LogStatus.PASS, "Navigated to Guest_Services");
			app_logs.info("Navigated to Guest_Services");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Guest_Services page", testName, "GuestServicesNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Guest_Services page", testName, "GuestServicesNavigation");
		}

		try {
			Navigation guest_ServicesNavigation = new Navigation();
			guest_ServicesNavigation.HouseKeepingStatus(driver);
			Wait.explicit_wait_xpath(OR.Housekeeping_Status_Title);
			test.log(LogStatus.PASS, "Navigated to HouseKeeping Status");
			app_logs.info("Navigated to HouseKeeping Status");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to HouseKeeping Status page", testName, "HouseKeepingStatusNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to HouseKeeping Status page", testName, "HouseKeepingStatusNavigation");
		}

		try {
			Housekepping_Status Clean_All_Rooms = new Housekepping_Status();
			Clean_All_Rooms.Select_Items_Per_Page(driver, itemsperpage);
			Clean_All_Rooms.Select_Room_Condition_In_Header(driver, roomcondition);
			Clean_All_Rooms.Save(driver);
			test.log(LogStatus.PASS, "Changed " + itemsperpage + " Roomclass condition to Cleaned");
			app_logs.info("Changed " + itemsperpage + " Roomclass condition to Cleaned");
		} catch (Exception e) {
			Utility.updateReport(e, "Error! in Changing Romclass conition", testName, "ChangingRCconition");
		} catch (Error e) {
			Utility.updateReport(e, "Error! in Changing Romclass conition", testName, "ChangingRCconition");
		}
		
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheet-name provided
		return Utility.getData("Clean_Room_Classes", excel);
	}

}
