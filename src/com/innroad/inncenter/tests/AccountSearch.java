package com.innroad.inncenter.tests;


import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class AccountSearch extends TestCore{
	//Before Test
	@BeforeTest
	public void checkRunMode(){
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	// Create split reservation
	@Test(dataProvider="getData", groups="Regression")
	public void reservationWithSplitRooms(String url,String ClientCode, String Username, String Password,String AccountType,String AccountName,String AccountNumber ){




		test = extent.startTest("AccountSearch", "AccountSearch")
				.assignCategory("AccountSearch")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();

		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");


		Account 	account = new Account();
		Login 		LOGIN 	= new Login();
		Navigation 	Nav		= new Navigation();

		// Login to InnCenter
		try{
			;
			LOGIN.login(driver,url, ClientCode, Username, Password);
			test.log(LogStatus.PASS, "System successfully logged in the site");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to login", testName, "Login");
		}


		// Clicking on New Reservation
		try{
			Nav.Accounts(driver);
			test.log(LogStatus.PASS, "Navigate Accounts");
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Navigate Accounts", testName, "NavigateAccounts");
		}
		
		// Get Account Details
		try{
			account.get_AccountDetails(driver, test, AccountType, AccountName, AccountNumber);
		}catch (Exception e) {
			Utility.updateReport(e, "Failed to Get Account Details", testName, "AccountDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Get Account Details", testName, "AccountDetails");
		}

	}
	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("AccountSearch",excel);
	}
}
