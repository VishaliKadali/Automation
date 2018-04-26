package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_On_All_Navigation {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_On_All_Navigation(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}
		
		
		@FindBy(xpath=OR.Tape_Chart)
		public WebElement Tape_Chart;
		
		@FindBy(xpath=OR.Tape_Chart_Grid1)
		public WebElement Tape_Chart_Grid;
		
		@FindBy(xpath=OR.New_Quote)
		public WebElement New_Quote;
		
		@FindBy(xpath=OR.New_Quote_Search)
		public WebElement New_Quote_Search;
		
		@FindBy(xpath=OR.Guest_History)
		public WebElement Guest_History;
		
		@FindBy(xpath=OR.Guest_History_Grid)
		public WebElement Guest_History_Grid;
		
		@FindBy(xpath=OR.Groups)
		public WebElement Groups;
		
		@FindBy(xpath=OR.Groups_text)
		public WebElement Groups_text;
		
		@FindBy(id=OR.Accounts)
		public WebElement Accounts;
		
		@FindBy(xpath=OR.Accounts2)
		public WebElement Accounts2;
		
		@FindBy(xpath=OR.Accounts_sec_Nav)
		public WebElement Accounts_sec_Nav;
		
		@FindBy(xpath=OR.Statements)
		public WebElement Statements;
		
		@FindBy(xpath=OR.Statement_Grid)
		public WebElement  Statement_Grid;
		
		@FindBy(xpath=OR.Unit_owner)
		public WebElement Unit_owner;
		
		@FindBy(xpath=OR.Unit_owner_Account)
		public WebElement Unit_owner_Account;
		
		@FindBy(xpath=OR.Travel_Agent)
		public WebElement Travel_Agent;
		
		@FindBy(xpath=OR.Travel_Agent_Grid)
		public WebElement Travel_Agent_Grid;
		
		@FindBy(xpath=OR.Manafement_Transfers)
		public WebElement Manafement_Transfers;
		
		@FindBy(xpath=OR.Manafement_Transfers_Grid)
		public WebElement Manafement_Transfers_Grid;
		
		@FindBy(xpath=OR.Account_Distribution)
		public WebElement Account_Distribution;
		
		@FindBy(xpath=OR.Account_Distribution_grid)
		public WebElement Account_Distribution_grid;
		
		@FindBy(id=OR.Guest_Services)
		public WebElement Guest_Services;
		
		@FindBy(xpath=OR.Guest_Services_grid)
		public WebElement Guest_Services_grid;
		
		@FindBy(xpath=OR.House_Keeping)
		public WebElement House_Keeping;
		
		@FindBy(id=OR.House_Kepping_status)
		public WebElement House_Kepping_status;
		
		@FindBy(xpath=OR.Task_List)
		public WebElement Task_List;
		
		@FindBy(xpath=OR.Task_List_grid)
		public WebElement Task_List_grid;
		
		@FindBy(xpath=OR.Room_Maintanence)
		public WebElement Room_Maintanence;
		
		@FindBy(xpath=OR.Room_Maintanence_Grid)
		public WebElement Room_Maintanence_Grid;
		
		@FindBy(id=OR.Inventory_Grid)
		public WebElement Inventory_Grid;
		
		@FindBy(id=OR.Inventory)
		public WebElement Inventory;
		
		@FindBy(xpath=OR.Overview)
		public WebElement Overview;
		
		@FindBy(xpath=OR.Overview_grid)
		public WebElement Overview_grid;
		
		@FindBy(xpath=OR.Seasons)
		public WebElement Seasons;
		
		@FindBy(xpath=OR.Seasons_button)
		public WebElement Seasons_button;
		
		@FindBy(xpath=OR.Rates)
		public WebElement Rates;
		
		@FindBy(xpath=OR.Rates_Grid)
		public WebElement Rates_Grid;
		
		@FindBy(xpath=OR.Rules)
		public WebElement Rules;
		
		@FindBy(xpath=OR.Rules_Grid)
		public WebElement Rules_Grid;
		
		@FindBy(xpath=OR.Distribution)
		public WebElement Distribution;
		
		@FindBy(xpath=OR.Distribution_Gird)
		public WebElement Distribution_Gird;
		
		@FindBy(xpath=OR.Distribution_syndication)
		public WebElement Distribution_syndication;
		
		@FindBy(xpath=OR.Distribution_Blackouts)
		public WebElement Distribution_Blackouts;
		

		@FindBy(xpath=OR.policies)
		public WebElement policies;
		
		@FindBy(xpath=OR.Policy_Button)
		public WebElement Policy_Button;
		
		@FindBy(xpath=OR.Setup)
		public WebElement Setup;
		
		@FindBy(xpath=OR.Setup_Grid)
		public WebElement Setup_Grid;
		
		@FindBy(xpath=OR.Propeties)
		public WebElement Propeties;
		
		@FindBy(xpath=OR.Propety_Grid)
		public WebElement Propety_Grid;
		
		@FindBy(xpath=OR.Roomclass)
		public WebElement Roomclass;
		
		@FindBy(xpath=OR.Roomclass_grid)
		public WebElement Roomclass_grid;
		
		@FindBy(xpath=OR.Taxes)
		public WebElement Taxes;
		
		@FindBy(xpath=OR.Taxes_Grid)
		public WebElement Taxes_Grid;
		
		@FindBy(xpath=OR.Ledger_Accounts)
		public WebElement Ledger_Accounts;
		
		@FindBy(xpath=OR.Ledger_Account_Grid)
		public WebElement Ledger_Account_Grid;
		
		@FindBy(xpath=OR.Merchant_Services)
		public WebElement Merchant_Services;
		
		@FindBy(xpath=OR.Merchant_Services_Grid)
		public WebElement Merchant_Services_Grid;
		
		@FindBy(xpath=OR.Document_Template)
		public WebElement Document_Template;
		
		@FindBy(xpath=OR.Documnet_Template_Grid)
		public WebElement Documnet_Template_Grid;
		
		@FindBy(xpath=OR.List_Management)
		public WebElement List_Management;
		
		@FindBy(xpath=OR.List_Management_Grid)
		public WebElement List_Management_Grid;
		
		@FindBy(xpath=OR.Task_Management)
		public WebElement Task_Management;
		
		@FindBy(id=OR.Admin)
		public WebElement Admin;
		

		@FindBy(xpath=OR.Client_info)
		public WebElement Client_info;
		
		@FindBy(xpath=OR.Client_info_grid)
		public WebElement Client_info_grid ;
		
		@FindBy(xpath=OR.Users)
		public WebElement Users;
		
		@FindBy(xpath=OR.Users_grid)
		public WebElement Users_grid;
		
		@FindBy(xpath=OR.Roles)
		public WebElement Roles;
		
		@FindBy(xpath=OR.Roles_page)
		public WebElement Roles_page;
		
		@FindBy(xpath=OR.Night_audit)
		public WebElement Night_audit;
		
		@FindBy(xpath=OR.Period_status)
		public WebElement Period_status;
		
		
		@FindBy(id=OR.Reports)
		public WebElement Reports;
		
		@FindBy(xpath=OR.Reports_Grid)
		public WebElement Reports_Grid;
		
		@FindBy(xpath=OR.Account_Balance)
		public WebElement Account_Balance;
		
		@FindBy(xpath=OR.Account_Balance_Grid)
		public WebElement Account_Balance_Grid;
		
		@FindBy(xpath=OR.Ledger_Balances)
		public WebElement Ledger_Balances;
		
		@FindBy(xpath=OR.Ledger_Balances_Grid)
		public WebElement Ledger_Balances_Grid;
		
		@FindBy(xpath=OR.Merchant_Trans)
		public WebElement Merchant_Trans;
		
		@FindBy(xpath=OR.Merchant_Trans_grid)
		public WebElement Merchant_Trans_grid;
		
		@FindBy(xpath=OR.Daily_flash)
		public WebElement Daily_flash;
		
		@FindBy(xpath=OR.Daily_flash_grid)
		public WebElement Daily_flash_grid;
		
		@FindBy(xpath=OR.Room_Forecast)
		public WebElement Room_Forecast;
		
		@FindBy(xpath=OR.Net_Sales)
		public WebElement Net_Sales;
		
		@FindBy(xpath=OR.Advance_Depos)
		public WebElement Advance_Depos;
		
		@FindBy(xpath=OR.Click_Reservation)
		public WebElement Click_Reservation;
		
		@FindBy(xpath=OR.Reservation_Backward)
		public WebElement Reservation_Backward;
		
		@FindBy(xpath=OR.Guest_Info)
		public WebElement Guest_Info;
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
