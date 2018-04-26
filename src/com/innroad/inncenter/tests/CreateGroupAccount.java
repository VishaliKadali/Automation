package com.innroad.inncenter.tests;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.AdvGroups;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateGroupAccount extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName=this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - "+ testName);
	}
	
	@Test(dataProvider = "getData")
	public void CreateAdvGroup(String url, String ClientCode, String Username, String Password, String PropertyName,
			String MarketingSegment, String GroupReferral, String GroupAccountName, String GroupFirstName,
			String GroupLastName, String GroupPhn, String GroupAddress, String GroupCity, String Groupstate,
			String GroupPostale, String Groupscountry, String BlockName, String NumberofNights,
			String UpdatedBlockedRoom, String EnterBlockedcount, String RoomClassName, String MarketSegment,
			String Referral, String Travel_Agent, String ExtReservation, String saluation, String FirstName,
			String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country,
			String State, String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account,
			String IsTaxExempt, String TaxEmptext

	) throws InterruptedException, IOException {

		ExtentTest test = extent.startTest("CreateGroupAccount", "Group Account Creation").assignCategory("Groups")
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
			test.log(LogStatus.FAIL, "Failed to Login into the application \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Login_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Login into the application \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}
		
		Reservation res = new Reservation();

		try {
			Navigation nav = new Navigation();
			nav.Groups(driver);
			app_logs.info("Navigated to GROUPS sub-module page");
			test.log(LogStatus.PASS, "Navigated to GROUPS sub-module page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to navigate to groups page \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_Groups_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to navigate to groups page \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		AdvGroups advGroups = new AdvGroups();
		try {
			app_logs.info("Creating new advanced group");
			advGroups.createGroupaccount(driver, MarketingSegment, GroupReferral, GroupAccountName, GroupFirstName, GroupLastName, GroupPhn, GroupAddress, GroupCity, Groupstate, GroupPostale, Groupscountry);
			app_logs.info("Clicked on New Account and updating contact info");
			test.log(LogStatus.PASS, "Clicked on New Account and updating contact info");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to click on new account and update the contact info \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CreateNewGroup_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to click on new account and update the contact info", e);
			throw new SkipException(e.getMessage());
		}

		try {
//			AdvGroups advGroups = new AdvGroups();
			advGroups.SaveAdvGroup(driver);
			app_logs.info("Saved the group");
			test.log(LogStatus.PASS, "Saved the group");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to save the group \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_SaveGroup_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to saved the group \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
//			AdvGroups advGroups = new AdvGroups();
			advGroups.EnterBlockName(driver, BlockName);
			advGroups.SearchGroupCriteria(driver, NumberofNights);
			advGroups.updatedAutomaticallyAssignedRooms(driver, UpdatedBlockedRoom);
			advGroups.BlockRoomForSelectedRoomclass(driver, EnterBlockedcount, RoomClassName);
			advGroups.ClickCreateBlock(driver);
			advGroups.SaveAdvGroup(driver);
			app_logs.info("Created block and saved");
			test.log(LogStatus.PASS, "Created block and saved");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to create block \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CreateBlock_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to create block \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
//			AdvGroups advGroups = new AdvGroups();
			advGroups.NavigateRoomBlock(driver);
			advGroups.ClickBookicon(driver, RoomClassName);
			Wait.wait10Second();
			app_logs.info("Navigated to Room Block page and clicked on book ico");
			test.log(LogStatus.PASS, "Navigated to Room Block page and clicked on book icon");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to Navigate to Room Block page \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_RoomBlock_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to Navigate to Room Block page \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}

		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			app_logs.info("Entered marketing information");
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			app_logs.info("Entered contact information");
			res.saveReservation(driver);
			app_logs.info("Saved the reservation");
			test.log(LogStatus.PASS, "Navigated to new reservation page and created reservation");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to create reservation \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + test.addScreenCapture(Utility.captureScreenShot(testName + "_CreateRreservation_" + Utility.getTimeStamp(), driver)));
			app_logs.error("Failed to create reservation \n");
			e.printStackTrace();
			throw new SkipException(e.getMessage());
		}
		
		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

//		return test data from the sheet name provided
		return Utility.getData("CreateGroupAccount", excel);
	}

}
