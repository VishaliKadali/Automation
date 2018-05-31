package com.innroad.inncenter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.pageobjects.SupportPanle_ClientSelection;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.Elements_Blackouts;
import com.innroad.inncenter.webelements.Elements_Channels;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.innroad.inncenter.webelements.Elements_Roles;
import com.innroad.inncenter.webelements.Elements_Rules;
import com.innroad.inncenter.webelements.Elements_Syndication;
import com.innroad.inncenter.webelements.Elements_Users;
import com.innroad.inncenter.webelements.WebElements_Create_Seasons;
import com.innroad.inncenter.webelements.WebElements_Policies;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyResetOption extends TestCore {

	@BeforeTest
	public void checkRunMode() {
		String testName = this.getClass().getSimpleName().trim();
		app_logs.info("Verifying Test case " + testName.toUpperCase() + " is Skipped or not");
		if (!Utility.isExecutable(testName, excel))
			throw new SkipException("Skipping the test - " + testName);
	}

	@Test(dataProvider = "getData")
	public void verifyResetOption(String url, String clientcodetologin, String Username, String Password,
			String PropertyName, String clientcodetoselect, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation,
			String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
			String Country, String State, String Postalcode, String Phonenumber, String alternativenumber, String Email,
			String Account, String IsTaxExempt, String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes, String propertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber,
			String Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData) throws InterruptedException {
		test = extent.startTest("VerifyResetOption", "Verify Reset Option").assignCategory("Resetfeature")
				.assignCategory("Regression");

		String testName = test.getTest().getName().toUpperCase();
		app_logs.info("##################################################################################");
		app_logs.info("EXECUTING: " + testName + " TEST.");
		app_logs.info("##################################################################################");
		Reservation res = new Reservation();
		Navigation navigation = new Navigation();
		SupportPanle_ClientSelection ClientSelection = new SupportPanle_ClientSelection();
		Elements_Accounts CreateAccount = new Elements_Accounts(driver);
		Elements_Rules Rules = new Elements_Rules(driver);
		Elements_Roles Roles = new Elements_Roles(driver);
		Elements_Users Users = new Elements_Users(driver);
		Elements_Syndication Syndication = new Elements_Syndication(driver);
		Elements_Channels Channels = new Elements_Channels(driver);
		Elements_Blackouts Blackouts = new Elements_Blackouts(driver);
		WebElements_Policies Policy = new WebElements_Policies(driver);
		WebElements_Create_Seasons Seasons = new WebElements_Create_Seasons(driver);
		ReservationSearch search = new ReservationSearch();
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 60);
		String Beforeediting;

		try {
			Login LOGIN = new Login();
			LOGIN.login(driver, url, clientcodetologin, Username, Password);
			test.log(LogStatus.PASS, "Logged into the application");
			app_logs.info("Logged into the application");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		}

		try {

			ClientSelection.Client_Selection_WithId(driver, clientcodetoselect);
			test.log(LogStatus.PASS, "Selected Given " + clientcodetoselect + " client successfully");
			app_logs.info("Selected Given " + clientcodetoselect + " client successfully");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to Select Given " + clientcodetoselect + " client successfully", testName,
					"ClientSelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to Select Given " + clientcodetoselect + " client successfully", testName,
					"ClientSelection");
		}

		try {
			res.IPropertySelector(driver, PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
			app_logs.info("Property Selection Success");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to select property", testName, "PropertySelection");
		}

/*		try {
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			Wait.explicit_wait_visibilityof_webelement(resservationSearch.Click_On_First_SearchResult);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Opened first Reservation from the Reservations list");
			app_logs.info("Opened first Reservation from the Reservations list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first reservation from the Reservations list", testName,
					"SearchResult");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first reservation from the Reservations list", testName,
					"SearchResult");
		}*/
		
		try {

			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Clicked new Reservation button");
			app_logs.info("Clicked new Reservation button");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to click new reservation button", testName, "NewResPage");

		} catch (Error e) {
			Utility.updateReport(e, "Failed click new reservation button", testName, "NewResPage");
		}
		
		try {
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country,
					State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,
					RoomClassName, RoomNumber);
			res.saveReservation(driver);
			Wait.wait2Second();
			res.GetReservationnumber(driver);
			res.Close_Tab(driver);
			test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
			app_logs.info("Entered required fields and saved the reservation");

		} catch (Exception e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "SaveReservation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to save the reservation", testName, "SaveReservation");
		}
	
		try {
		
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
			app_logs.info("Validated Basic Search with Reservation number");
		} catch (Exception e) {

			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName,
					"ResSearch");

		} catch (Error e) {
			Utility.updateReport(e, "System fail to validate Basic Search with Reservation number", testName,
					"ResSearch");
		}

		try {
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			Utility.ScrollToElement(ReservationPage.Enter_First_Name);
			Wait.wait2Second();
			Beforeediting = ReservationPage.Enter_First_Name.getAttribute("value");
			ReservationPage.Enter_First_Name.clear();
			ReservationPage.Enter_First_Name.sendKeys("EditedFName");
			ReservationPage.Enter_Last_Name.clear();
			ReservationPage.Enter_Last_Name.sendKeys("EditedLName");
			Wait.explicit_wait_elementToBeClickable(ReservationPage.ReservationPage_Reset_Btn);
			if (ReservationPage.ReservationPage_Reset_Btn.isEnabled()) {
				ReservationPage.ReservationPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(ReservationPage.Enter_First_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in Reservation Page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Reservation info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Reservation page ");
			app_logs.info("Successfully verified Reset option in Reservation page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option on Reservation page,", testName, "VerifyReset");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option on Reservation page", testName, "VerifyReset");
		}

		try {
			navigation.Accounts(driver);
			test.log(LogStatus.PASS, "Navigated to Accounts");
			app_logs.info("Navigated to Accounts");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to accounts page", testName, "AccountsNavigation");
		}

		try {

			Wait.explicit_wait_visibilityof_webelement(CreateAccount.AccountsPage_Click_All);
			CreateAccount.AccountsPage_Click_All.click();
			Wait.explicit_wait_visibilityof_webelement(CreateAccount.First_Element_In_Account_SearchResults);
			CreateAccount.First_Element_In_Account_SearchResults.click();
			Wait.explicit_wait_visibilityof_webelement(CreateAccount.Enter_Account_Name);
			test.log(LogStatus.PASS, "Opened first account from the accounts list");
			app_logs.info("Opened first account from the accounts list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first account from the accounts list", testName, "AccountsDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first account from the accounts list", testName, "AccountsDetails");
		}

		try {

			Utility.ScrollToElement(CreateAccount.Account_Enter_First_Name);
			Wait.wait2Second();
			Beforeediting = CreateAccount.Account_Enter_First_Name.getAttribute("value");
			CreateAccount.Account_Enter_First_Name.clear();
			CreateAccount.Account_Enter_Last_Name.clear();
			CreateAccount.Account_Enter_First_Name.sendKeys("EditedFName");
			CreateAccount.Account_Enter_Last_Name.sendKeys("EditedLName");
			Wait.explicit_wait_elementToBeClickable(CreateAccount.AccountsPage_Reset_Btn);
			if (CreateAccount.AccountsPage_Reset_Btn.isEnabled()) {
				CreateAccount.AccountsPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(CreateAccount.Account_Enter_First_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in accounts page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing account info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Accounts page ");
			app_logs.info("Successfully verified Reset option in Accounts page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Accounts page", testName, "AccountsResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Accounts page", testName, "AccountsResetOpt");
		}

		try {
			navigation.Inventory(driver);
			test.log(LogStatus.PASS, "Navigated to Inventory");
			app_logs.info("Navigated to Inventory");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Inventory page", testName, "InventoryNavigation");
		}

		try {
			navigation.Seasons(driver);
			test.log(LogStatus.PASS, "Navigated to Seasons");
			app_logs.info("Navigated to Seasons");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Seasons", testName, "InventoryNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Seasons", testName, "InventoryNavigation");
		}

		try {
           
			try{
			Wait.explicit_wait_visibilityof_webelement(Seasons.NG_Season_Search);
			Seasons.NG_Season_Search.click();
			Wait.explicit_wait_visibilityof_webelement(Seasons.First_Element_In_Season_SearchResults);
			Seasons.First_Element_In_Season_SearchResults.click();
			test.log(LogStatus.PASS, "Opened first Season from the Seasons list");
			app_logs.info("Opened first Season from the Seasons list");
			}
			catch(Exception e)
			{
				Seasons.NG_New_Season_Btn.click();
				test.log(LogStatus.PASS, "No seasons found, Cliking new season button");
				app_logs.info("No seasons found, Cliking new season button");
			}
			Wait.explicit_wait_visibilityof_webelement(Seasons.NG_Season_Name);
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first Season from the Seasons list", testName, "SeasonsDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first Season from the Seasons list", testName, "SeasonsDetails");
		}

		try {

			Beforeediting = Seasons.NG_Season_Name.getAttribute("value");
			Seasons.NG_Season_Name.clear();
			Seasons.NG_Season_Name.sendKeys("EditedName");
			Wait.explicit_wait_elementToBeClickable(Seasons.SeasonsPage_Reset_Btn);
			if (Seasons.SeasonsPage_Reset_Btn.isEnabled()) {
				Seasons.SeasonsPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(Seasons.NG_Season_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in Seasons page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Seasons info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Seasons page ");
			app_logs.info("Successfully verified Reset option in Seasons page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Seasons page", testName, "SeasonsResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Seasons page", testName, "SeasonsResetOpt");
		}

		try {
			// Can't use already existing xpath for rules tab as there is no
			// common locator in .aspx and .html pages.
			driver.findElement(By.xpath("//span[.='Rules']")).click();
			Wait.explicit_wait_xpath(OR.Rules_Grid);
			test.log(LogStatus.PASS, "Navigated to Rules");
			app_logs.info("Navigated to Rules");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Rules", testName, "RulesNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Rules", testName, "RulesNavigation");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(Rules.Rules_Search_Btn);
			Rules.Rules_Search_Btn.click();
			try {
				Wait.explicit_wait_10sec(Rules.First_Element_In_Rules_SearchResults);
				Rules.First_Element_In_Rules_SearchResults.click();
			} catch (Exception e) {
				app_logs.info("No rules found, Clicking new rule button");
				Rules.New_Rule_Btn.click();
			}
			Wait.explicit_wait_visibilityof_webelement(Rules.Select_Rule_Satus);
			test.log(LogStatus.PASS, "Opened first Rule from the Rules list");
			app_logs.info("Opened first Rule from the Rules list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first Rule from the Rules list", testName, "RuleDetails");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first Rule from the Rules list", testName, "RuleDetails");
		}

		try {

			Select selectRuleSatus = new Select(Rules.Select_Rule_Satus);
			Beforeediting = selectRuleSatus.getFirstSelectedOption().getText();
			selectRuleSatus.selectByVisibleText("Inactive");
			Wait.explicit_wait_elementToBeClickable(Rules.RulesPage_Reset_Btn);
			if (Rules.RulesPage_Reset_Btn.isEnabled()) {
				Rules.RulesPage_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(selectRuleSatus.getFirstSelectedOption().getText(), Beforeediting,
						"Reset_Btn is not working as expected in Rules page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Rules info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Rules page ");
			app_logs.info("Successfully verified Reset option in Rules page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Rules page", testName, "RulesResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Rules page", testName, "RulesResetOpt");
		}

		try {
			navigation.policies(driver);
			test.log(LogStatus.PASS, "Navigated to Policies");
			app_logs.info("Navigated to Policies");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Policies", testName, "PoliciesNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Policies", testName, "PoliciesNavigation");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(Policy.Search_On_On_Policiespage);
			Policy.Search_On_On_Policiespage.click();
			try {
				Wait.explicit_wait_visibilityof_webelement(Policy.First_Element_In_Search_Result);
				Policy.First_Element_In_Search_Result.click();
				test.log(LogStatus.PASS, "Opened first Policy from the Policies list");
				app_logs.info("Opened first Policy from the Policies list");
			} catch (Exception e) {
				app_logs.info("No policies found, So clicking new policy button");
				Policy.New_Policy_Btn.click();
				test.log(LogStatus.PASS, "Clicked new policy button");
			}
			Wait.explicit_wait_visibilityof_webelement(Policy.Enter_Policy_Name);
			
			
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first Policy from the Policies list", testName, "PolicySearch");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first Policy from the Policies list", testName, "PolicySearch");
		}
		try {

			Beforeediting = Policy.Enter_Policy_Name.getAttribute("value");
			Policy.Enter_Policy_Name.clear();
			Policy.Enter_Policy_Name.sendKeys("EditedName");
			Wait.explicit_wait_elementToBeClickable(Policy.Policy_Reset_Btn);
			if (Policy.Policy_Reset_Btn.isEnabled()) {
				Policy.Policy_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(Policy.Enter_Policy_Name.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in Policy page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Policy info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Policies page ");
			app_logs.info("Successfully verified Reset option in Policies page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Policies page", testName, "PoliciesResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Policies page", testName, "PoliciesResetOpt");
		}

		try {
			navigation.Distribution(driver);
			test.log(LogStatus.PASS, "Navigated to Distribution");
			app_logs.info("Navigated to Distribution");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Distribution", testName, "DistributionNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Distribution", testName, "DistributionNavigation");
		}

		try {

			boolean beforestate = Channels.Channels_FirstAvailable_Checkbox.isSelected();
			app_logs.info("Before editing checkbox state :" + beforestate);
			Channels.Channels_FirstAvailable_Checkbox.click();
			if (beforestate == true) {
				wait.until(
						ExpectedConditions.elementSelectionStateToBe(Channels.Channels_FirstAvailable_Checkbox, false));
			} else {
				wait.until(
						ExpectedConditions.elementSelectionStateToBe(Channels.Channels_FirstAvailable_Checkbox, true));
			}
			boolean afterstate = Channels.Channels_FirstAvailable_Checkbox.isSelected();
			app_logs.info("After editing checkbox state :" + afterstate);
			Wait.explicit_wait_elementToBeClickable(Channels.Channels_Reset_Button);
			if (Channels.Channels_Reset_Button.isEnabled()) {
				Channels.Channels_Reset_Button.click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(Channels.Channels_FirstAvailable_Checkbox,
						beforestate));
				Assert.assertEquals(Channels.Channels_FirstAvailable_Checkbox.isSelected(), beforestate,
						"Reset_Btn is not working as expected in Syndication page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Channels info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Channels page ");
			app_logs.info("Successfully verified Reset option in Channels page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Channels page", testName, "ChannelsResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Channels page", testName, "ChannelsResetOpt");
		}

		try {
			navigation.Distribution_syndication(driver);
			Wait.explicit_wait_xpath(OR.Syndication_Month_Label);
			test.log(LogStatus.PASS, "Navigated to Syndication");
			app_logs.info("Navigated to Syndication");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Syndication", testName, "SyndicationNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Syndication", testName, "SyndicationNavigation");
		}

		try {

			boolean beforestate = Syndication.Syndication_FirstAvailable_Checkbox.isSelected();
			app_logs.info("Before editing checkbox state :" + beforestate);
			Syndication.Syndication_FirstAvailable_Checkbox.click();
			if (beforestate == true) {
				wait.until(ExpectedConditions.elementSelectionStateToBe(Syndication.Syndication_FirstAvailable_Checkbox,
						false));
			} else {
				wait.until(ExpectedConditions.elementSelectionStateToBe(Syndication.Syndication_FirstAvailable_Checkbox,
						true));
			}
			boolean afterstate = Syndication.Syndication_FirstAvailable_Checkbox.isSelected();
			app_logs.info("After editing checkbox state :" + afterstate);
			Wait.explicit_wait_elementToBeClickable(Syndication.Syndication_Reset_Button);
			if (Syndication.Syndication_Reset_Button.isEnabled()) {
				Syndication.Syndication_Reset_Button.click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(Syndication.Syndication_FirstAvailable_Checkbox,
						beforestate));
				Assert.assertEquals(Syndication.Syndication_FirstAvailable_Checkbox.isSelected(), beforestate,
						"Reset_Btn is not working as expected in Syndication page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Syndication info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Syndication page ");
			app_logs.info("Successfully verified Reset option in Syndication page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Syndication page", testName,
					"SyndicationResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Syndication page", testName,
					"SyndicationResetOpt");
		}

		try {
			navigation.DistributionBlackouts(driver);
			Wait.explicit_wait_xpath(OR.BlackOuts_Source_Label);
			test.log(LogStatus.PASS, "Navigated to BlackOuts");
			app_logs.info("Navigated to BlackOuts");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to BlackOuts", testName, "BlackOutsNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to BlackOuts", testName, "BlackOutsNavigation");
		}

		try {

			boolean beforestate = Blackouts.BlackOuts_FirstAvailable_Checkbox.isSelected();
			app_logs.info("Before editing checkbox state :" + beforestate);
			Blackouts.BlackOuts_FirstAvailable_Checkbox.click();
			if (beforestate == true) {
				wait.until(ExpectedConditions.elementSelectionStateToBe(Blackouts.BlackOuts_FirstAvailable_Checkbox,
						false));
			} else {
				wait.until(ExpectedConditions.elementSelectionStateToBe(Blackouts.BlackOuts_FirstAvailable_Checkbox,
						true));
			}
			boolean afterstate = Blackouts.BlackOuts_FirstAvailable_Checkbox.isSelected();
			app_logs.info("After editing checkbox state :" + afterstate);
			Wait.explicit_wait_elementToBeClickable(Blackouts.BlackOuts_Reset_Button);
			if (Blackouts.BlackOuts_Reset_Button.isEnabled()) {
				Blackouts.BlackOuts_Reset_Button.click();
				wait.until(ExpectedConditions.elementSelectionStateToBe(Blackouts.BlackOuts_FirstAvailable_Checkbox,
						beforestate));
				Assert.assertEquals(Blackouts.BlackOuts_FirstAvailable_Checkbox.isSelected(), beforestate,
						"Reset_Btn is not working as expected in BlackOuts page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing BlackOuts info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in BlackOuts page ");
			app_logs.info("Successfully verified Reset option in BlackOuts page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in BlackOuts page", testName, "BlackOutsResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in BlackOuts page", testName, "BlackOutsResetOpt");
		}

		try {
			navigation.Admin(driver);
			Wait.explicit_wait_xpath(OR.Admin_Menu_Title);
			test.log(LogStatus.PASS, "Navigated to Admin");
			app_logs.info("Navigated to Admin");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Admin", testName, "AdminNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Admin", testName, "AdminNavigation");
		}

		try {
			navigation.Users(driver);
			;
			test.log(LogStatus.PASS, "Navigated to Users");
			app_logs.info("Navigated to Users");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Users", testName, "UsersNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Users", testName, "UsersNavigation");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(Users.Users_Search_Btn);
			Users.Users_Search_Btn.click();
			try {
				Wait.explicit_wait_visibilityof_webelement(Users.First_Element_In_Users_SearchResults);
				Users.First_Element_In_Users_SearchResults.click();
			} catch (Exception e) {
				app_logs.info("No users found, So clicking new user button");
				Users.New_User_Btn.click();
			}
			Wait.explicit_wait_visibilityof_webelement(Users.Enter_User_LoginId);
			test.log(LogStatus.PASS, "Opened first User from the Users list");
			app_logs.info("Opened first User from the Users list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first User from the Users list", testName, "UsersSearch");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first User from the Users list", testName, "UsersSearch");
		}
		try {

			Beforeediting = Users.Enter_User_LoginId.getAttribute("value");
			Users.Enter_User_LoginId.clear();
			Users.Enter_User_LoginId.sendKeys("EditedName");
			Wait.explicit_wait_elementToBeClickable(Users.Users_Reset_Btn);
			if (Users.Users_Reset_Btn.isEnabled()) {
				Users.Users_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(Users.Enter_User_LoginId.getAttribute("value"), Beforeediting,
						"Reset_Btn is not working as expected in Users page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Users info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Users page ");
			app_logs.info("Successfully verified Reset option in Users page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Users page", testName, "UsersResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Users page", testName, "UsersResetOpt");
		}

		try {
			navigation.Roles(driver);
			test.log(LogStatus.PASS, "Navigated to Roles");
			app_logs.info("Navigated to Roles");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to navigate to Roles", testName, "RolesNavigation");

		} catch (Error e) {
			Utility.updateReport(e, "Failed to navigate to Roles", testName, "RolesNavigation");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(Roles.Roles_Search_Btn);
			Roles.Roles_Search_Btn.click();
			Wait.explicit_wait_visibilityof_webelement(Roles.First_Element_In_Roles_SearchResults);
			Roles.First_Element_In_Roles_SearchResults.click();
			Wait.explicit_wait_visibilityof_webelement(Roles.Enter_Role_Name);
			test.log(LogStatus.PASS, "Opened first Role from the Roles list");
			app_logs.info("Opened first Role from the Roles list");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to open first Role from the Roles list", testName, "RolesSearch");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to open first Role from the Roles list", testName, "RolesSearch");
		}
		try {

			Select selectRoleSatus = new Select(Roles.Select_Role_Satus);
			Beforeediting = selectRoleSatus.getFirstSelectedOption().getText();
			selectRoleSatus.selectByVisibleText("Inactive");
			Roles.Enter_Role_Name.clear();
			Roles.Enter_Role_Name.sendKeys("EditedName");
			Wait.explicit_wait_elementToBeClickable(Roles.Roles_Reset_Btn);
			if (Roles.Roles_Reset_Btn.isEnabled()) {
				Roles.Roles_Reset_Btn.click();
				Wait.wait5Second();
				Assert.assertEquals(selectRoleSatus.getFirstSelectedOption().getText(), Beforeediting,
						"Reset_Btn is not working as expected in Roles page");

			} else {
				Assert.fail("Reset_Btn is not enabled after editing Roles info");
			}

			test.log(LogStatus.PASS, "Successfully verified Reset option in Roles page ");
			app_logs.info("Successfully verified Reset option in Roles page");
		} catch (Exception e) {
			Utility.updateReport(e, "Failed to verify Reset option in Roles page", testName, "RolesResetOpt");
		} catch (Error e) {
			Utility.updateReport(e, "Failed to verify Reset option in Roles page", testName, "RolesResetOpt");
		}

		extent.endTest(test);

	}

	@DataProvider
	public Object[][] getData() {

		// return test data from the sheetname provided
		return Utility.getData("VerifyResetOption", excel);

	}
}
