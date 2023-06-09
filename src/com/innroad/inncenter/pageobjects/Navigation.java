package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.innroad.inncenter.interfaces.INavigation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;

public class Navigation implements INavigation {

	public static Logger navigationLogger = Logger.getLogger("Navigation");

	public void TapeChart(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Tape_Chart.click();
		navigationLogger.info("Clicked on tape chart sub-menu option");
//		Wait.explicit_wait_xpath(OR.Tape_Chart_Grid1);
		Wait.waitUntilPresenceOfElementLocated(OR.tapeChartGridLayOut);
	}

	// New Quote

	public void NewQuote(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.New_Quote.click();
		Wait.explicit_wait_xpath(OR.New_Quote_Search);
		navigationLogger.info("Click on New Quote");
	}

	// Guest History

	public void GuestHistory(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Guest_History.click();
		Wait.explicit_wait_xpath(OR.Guest_History_Grid);
	}

	// Groups

	public void Groups(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Groups.click();
		Wait.explicit_wait_xpath(OR.Groups_text);
	}

	// Accounts

	public void Accounts(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		try {

			Navigate.Accounts2.click();
			
		} catch (Exception e) {
			Navigate.Accounts.click();
		}
		Wait.explicit_wait_visibilityof_webelement(Navigate.Accounts_sec_Nav);
		Wait.wait2Second();
		

	}

	public void Accounts_sec_Nav(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Accounts_sec_Nav.click();

	}

	// Statements

	public void Statements(WebDriver driver) throws InterruptedException {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Statements.click();
		Wait.explicit_wait_xpath(OR.Statement_Grid);
		Wait.wait15Second();
	}

	// Unit owner Account

	public void UnitownerAccount(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Unit_owner.click();
		Wait.explicit_wait_xpath(OR.Unit_owner_Account);
	}

	// Travel Agent

	public void TravelAgent(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Travel_Agent.click();
		Wait.explicit_wait_xpath(OR.Travel_Agent_Grid);
	}

	// Management Transfers

	public void ManagementTransfers(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Manafement_Transfers.click();
		Wait.explicit_wait_xpath(OR.Manafement_Transfers_Grid);
	}

	// Account Distribution

	public void AccountDistribution(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Account_Distribution.click();
		Wait.explicit_wait_xpath(OR.Account_Distribution_grid);
	}

	// Guest services

	public void Guestservices(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Guest_Services.click();
		Wait.explicit_wait_xpath(OR.Guest_Services_grid);

	}

	// HouseKeeping Status

	public void HouseKeepingStatus(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.House_Keeping.click();
		Wait.explicit_wait_xpath(OR.House_Kepping_status);
	}

	// Task List

	public void TaskList(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Task_List.click();
		Wait.explicit_wait_xpath(OR.Task_List_grid);
	}

	// Room Maintenance

	public void RoomMaintenance(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Room_Maintanence.click();
		Wait.explicit_wait_xpath(OR.Room_Maintanence_Grid);

	}

	// Inventory

	public void Inventory(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Inventory.click();
		Wait.explicit_wait_xpath(OR.Inventory_Grid);
	}

	// Overview

	public void Overview(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Overview.click();
		Wait.explicit_wait_xpath(OR.Overview_grid);

	}

	// Seasons

	@Override
	public void Seasons(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Seasons.click();
		Wait.explicit_wait_xpath(OR.Seasons_button);
	}

	// Rates

	public void Rates(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Rates.click();
		Wait.explicit_wait_xpath(OR.Rates_Grid);
	}

	// Rules

	public void Rules(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Rules.click();
		Wait.explicit_wait_xpath(OR.Rules_Grid);

	}

	// Distribution

	public void Distribution(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Distribution.click();
		Wait.explicit_wait_xpath(OR.Distribution_Gird);
	}

	// Distribution_syndication

	public void Distribution_syndication(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);

		Navigate.Distribution_syndication.click();
	}

	// Distribution Blackouts

	public void DistributionBlackouts(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Distribution_Blackouts.click();
	}

	// policies

	public void policies(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.policies.click();
		Wait.explicit_wait_xpath(OR.Policy_Button);
	}

	// Setup

	public void Setup(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Setup.click();
		Wait.explicit_wait_xpath(OR.Setup_Grid);
		navigationLogger.info("Click on Setup");
		
	}

	// Properties

	public void Properties(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Propeties.click();
		Wait.explicit_wait_xpath(OR.Propety_Grid);

	}

	// Taxes

	public void Taxes(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Taxes.click();
		Wait.explicit_wait_xpath(OR.Taxes_Grid);
	}

	// Ledger Accounts
	public void LedgerAccounts(WebDriver driver) {

		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Ledger_Accounts.click();
		Wait.explicit_wait_xpath(OR.Ledger_Account_Grid);

	}

	// Merchant services
	public void Merchantservices(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Merchant_Services.click();
		Wait.explicit_wait_xpath(OR.Merchant_Services_Grid);

	}

	// Document Template
	public void DocumentTemplate(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Document_Template.click();
		Wait.explicit_wait_xpath(OR.Documnet_Template_Grid);
	}

	// List Managemnet

	public void ListManagemnet(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.List_Management.click();
		Wait.explicit_wait_xpath(OR.List_Management_Grid);

	}

	// Admin

	public void Admin(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Admin.click();
		Wait.explicit_wait_xpath(OR.Admin_Grid);
	}

	// Client info

	public void Clientinfo(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Client_info.click();
		Wait.explicit_wait_xpath(OR.Client_info_grid);

	}

	// Users

	public void Users(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Users.click();
		Wait.explicit_wait_xpath(OR.Users_grid);
	}

	// Roles

	public void Roles(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Roles.click();
		Wait.explicit_wait_xpath(OR.Roles_page);
	}

	// Night Audit

	public void NightAudit(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Night_audit.click();
		Wait.explicit_wait_xpath(OR.Period_status);
	}

	// Reports

	public void Reports(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Reports.click();
		Wait.explicit_wait_xpath(OR.Reports_Grid);
	}

	// Account Balances

	public void AccountBalances(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Account_Balance.click();
		Wait.explicit_wait_xpath(OR.Account_Balance_Grid);
	}

	// Ledger Balances

	public void LedgerBalances(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Ledger_Balances.click();
		Wait.explicit_wait_xpath(OR.Ledger_Balances_Grid);
	}

	// Merchant Trans

	public void MerchantTrans(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Merchant_Trans.click();
		Wait.explicit_wait_xpath(OR.Merchant_Trans_grid);

	}

	// Daily Falsh

	public void DailyFalsh(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Daily_flash.click();
		Wait.explicit_wait_xpath(OR.Daily_flash_grid);
	}

	// Room Forecast

	public void RoomForecast(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Room_Forecast.click();
		Wait.explicit_wait_xpath(OR.Room_Forecast_grid);

	}

	// Net Sales

	public void NetSales(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Net_Sales.click();
		Wait.explicit_wait_xpath(OR.Net_Sales_Grid);

	}

	// Advance Deposite
	public void AdvanceDeposite(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Advance_Depos.click();
		Wait.explicit_wait_xpath(OR.Advance_Depos_grid);

	}

	@Override
	public void RoomClass(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Roomclass.click();
		Wait.explicit_wait_xpath(OR.Roomclass_grid);
	}

	public void NewRoomClass(WebDriver driver) throws InterruptedException{
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Thread.sleep(3000);
	    Navigate.New_RoomClass.click();
	    Wait.explicit_wait_xpath(OR.New_RoomClass_Deails);
	}
	
	public void Reservation(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Click_Reservation.click();
		Wait.explicit_wait_xpath(OR.Verify_Reservation_Page);
	}

	public void Reservation_Backward(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Reservation_Backward.click();
		// Wait.explicit_wait_xpath(OR.Verify_Reservation_Page);
	}

	public void Guest_info(WebDriver driver) {
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		Navigate.Guest_Info.click();
		Wait.explicit_wait_xpath(OR.Verify_Guest_Info);
	}

	public void TaxesAfterCloseReservation(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		//Wait.wait3Second();
		Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		
		Wait.WaitForElement(driver, "//a[contains(text(),'Taxes\')]");
		 driver.findElement(By.xpath("//a[contains(text(),'Taxes\')]")).click();
		    Wait.explicit_wait_xpath(OR.Taxes_Grid);
	}
	
	
	
	
}
