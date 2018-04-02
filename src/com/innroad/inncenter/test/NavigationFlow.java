package com.innroad.inncenter.test;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Predicate;
import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class NavigationFlow extends testCore {

	@BeforeTest
	public void checkRunMode(){

		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("NavigationFlow", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");		
	}


	@Test(dataProvider="getData")
	public void navigationFlow(String url,String ClientCode, String Username, String Password, String PropertyName ) throws InterruptedException, IOException {

		ExtentTest test = extent.startTest("NavigationFlow", "Navigation across all innCenter modules");

		System.out.println("Executing: " + test.getTest().getName()+ " test.");
		try
		{
			Login LOGIN = new Login();
			LOGIN.login(driver,url, ClientCode, Username, Password);

			test.log(LogStatus.PASS, "Login successfully");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Login unsuccess"); 
		}

		try
		{
			Reservation res = new  Reservation();
			res.IPropertySelector(driver,PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to select property"); 
		}


		try
		{
			Navigation Nav= new Navigation();
			Nav.TapeChart(driver);
			Assert.assertTrue("Fail to navigate tapechart",Utility.return_element_status_after_explicit_wait(OR.Enter_Adults_Tapehchart));
			test.log(LogStatus.PASS, "Navigate tapechart");
		}
		catch(Exception e)
		{		
			test.log(LogStatus.FAIL, "Fail to navigate tapechart"); 
		}	 

		try
		{
			Navigation Nav= new Navigation();
			Nav.NewQuote(driver);
			Assert.assertTrue("Fail to navigate NewQuote",Utility.return_element_status_after_explicit_wait(OR.Enter_RateQuoteNights));
			test.log(LogStatus.PASS, "Navigate NewQuote");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate NewQuote"); 
		}	 

		try
		{
			Navigation Nav= new Navigation();
			Nav.GuestHistory(driver);
			Assert.assertTrue("Fail to navigate GuestHistory",Utility.return_element_status_after_explicit_wait(OR.Accountype_Label));
			test.log(LogStatus.PASS, "Navigate GuestHistory");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate GuestHistory"); 
		}	 


		try
		{
			Navigation Nav= new Navigation();
			Nav.Groups(driver);
			Assert.assertTrue("Fail to navigate Groups",Utility.return_element_status_after_explicit_wait(OR.GroupsNewAccount));
			test.log(LogStatus.PASS, "Navigate Groups");
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Groups"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Accounts(driver);
			Assert.assertTrue("Fail to navigate Accounts",Utility.return_element_status_after_explicit_wait(OR.Click_New_Account));
			test.log(LogStatus.PASS, "Navigate Accounts");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Accounts"); 
		}	
		Wait.wait10Second();	 
		try
		{
			Navigation Nav= new Navigation();
			Nav.Accounts_sec_Nav(driver);
			Assert.assertTrue("Fail to navigate Accounts_sec_Nav",Utility.return_element_status_after_explicit_wait(OR.Click_New_Account));
			test.log(LogStatus.PASS, "Navigate Accounts_sec_Nav");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Accounts_sec_Nav"); 
		}	
		Wait.wait10Second();	 	 
		try
		{
			Navigation Nav= new Navigation();
			Nav.Statements(driver);
			Assert.assertTrue("Fail to navigate Statements",Utility.return_element_status_after_explicit_wait(OR.Account_Statement_Tab));
			test.log(LogStatus.PASS, "Navigate Statements");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Statements"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.UnitownerAccount(driver);
			Assert.assertTrue("Fail to navigate UnitownerAccount Items",Utility.return_element_status_after_explicit_wait(OR.Unit_owner_Account));
			test.log(LogStatus.PASS, "Navigate UnitownerAccount Items");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate UnitownerAccount"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.TravelAgent(driver);
			Assert.assertTrue("Fail to navigate TravelAgent Items",Utility.return_element_status_after_explicit_wait(OR.Travel_Agent_Items_Title));
			test.log(LogStatus.PASS, "Navigate TravelAgent Items");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate TravelAgent Items"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.ManagementTransfers(driver);
			Assert.assertTrue("Fail to navigate ManagementTransfers",Utility.return_element_status_after_explicit_wait(OR.Management_Items_Title));
			test.log(LogStatus.PASS, "Navigate ManagementTransfers");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate ManagementTransfers"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.AccountDistribution(driver);
			Assert.assertTrue("Fail to navigate AccountDistribution",Utility.return_element_status_after_explicit_wait(OR.Account_Distributions_Title));
			test.log(LogStatus.PASS, "Navigate AccountDistribution");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate AccountDistribution"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Guestservices(driver);
			Assert.assertTrue("Fail to navigate Guestservices",Utility.return_element_status_after_explicit_wait(OR.Guest_Services_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Guestservices");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Guestservices"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.HouseKeepingStatus(driver);
			Assert.assertTrue("Fail to navigate HouseKeepingStatus",Utility.return_element_status_after_explicit_wait(OR.Housekeeping_Status_Title));
			test.log(LogStatus.PASS, "Navigate HouseKeepingStatus");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate HouseKeepingStatus"); 
		}	


		try
		{
			Navigation Nav= new Navigation();
			Nav.TaskList(driver);
			Assert.assertTrue("Fail to navigate TaskList",Utility.return_element_status_after_explicit_wait(OR.Task_List_Title));
			test.log(LogStatus.PASS, "Navigate TaskList");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate TaskList"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.RoomMaintenance(driver);
			Assert.assertTrue("Fail to navigate RoomMaintenance",Utility.return_element_status_after_explicit_wait(OR.Room_Maintenance_Fromdate));
			test.log(LogStatus.PASS, "Navigate RoomMaintenance");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate RoomMaintenance"); 
		}	

		try
		{
			Navigation Nav1= new Navigation(); 
			Nav1.Inventory(driver);
			Assert.assertTrue("Fail to navigate Inventory",Utility.return_element_status_after_explicit_wait(OR.Inventory_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Inventory");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Inventory"); 
		}	
		try
		{
			Navigation Nav= new Navigation();
			Nav.Overview(driver);
			Assert.assertTrue("Fail to navigate Overview",Utility.return_element_status_after_explicit_wait(OR.Inventory_Overview));
			test.log(LogStatus.PASS, "Navigate Overview");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Overview"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Seasons(driver);
			Assert.assertTrue("Fail to navigate Seasons",Utility.return_element_status_after_explicit_wait(OR.New_Season_Btn));
			test.log(LogStatus.PASS, "Navigate Seasons");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Seasons"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Rates(driver);
			Assert.assertTrue("Fail to navigate Rates",Utility.return_element_status_after_explicit_wait(OR.Rates_Title));
			test.log(LogStatus.PASS, "Navigate Rates");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Rates"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Rules(driver);
			Assert.assertTrue("Fail to navigate Rules",Utility.return_element_status_after_explicit_wait(OR.New_Rule_Btn));
			test.log(LogStatus.PASS, "Navigate Rules");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Rules"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Distribution(driver);
			Assert.assertTrue("Fail to navigate Distribution",Utility.return_element_status_after_explicit_wait(OR.Table_Text));
			test.log(LogStatus.PASS, "Navigate Distribution");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Distribution"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Distribution_syndication(driver);
			Assert.assertTrue("Fail to navigate Distribution_syndication",Utility.return_element_status_after_explicit_wait(OR.Syndication_Month_Label));
			test.log(LogStatus.PASS, "Navigate Distribution_syndication");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Distribution_syndication"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.DistributionBlackouts(driver);
			Assert.assertTrue("Fail to navigate DistributionBlackouts",Utility.return_element_status_after_explicit_wait(OR.BlackOuts_Source_Label));
			test.log(LogStatus.PASS, "Navigate DistributionBlackouts");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate DistributionBlackouts"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.policies(driver);
			Assert.assertTrue("Fail to navigate policies",Utility.return_element_status_after_explicit_wait(OR.New_Policy_Btn));
			test.log(LogStatus.PASS, "Navigate policies");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate policies"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Setup(driver);
			Assert.assertTrue("Fail to navigate Setup",Utility.return_element_status_after_explicit_wait(OR.Setup_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Setup");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Setup"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Properties(driver);
			Assert.assertTrue("Fail to navigate Properties",Utility.return_element_status_after_explicit_wait(OR.Properties_Title));
			test.log(LogStatus.PASS, "Navigate Properties");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Properties"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.RoomClass(driver);
			Assert.assertTrue("Fail to navigate RoomClass",Utility.return_element_status_after_explicit_wait(OR.New_RoomClass_Btn));
			test.log(LogStatus.PASS, "Navigate RoomClass");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate RoomClass"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Taxes(driver);
			Assert.assertTrue("Fail to navigate Taxes",Utility.return_element_status_after_explicit_wait(OR.Tax_Items_Title));
			test.log(LogStatus.PASS, "Navigate Taxes");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Taxes"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.LedgerAccounts(driver);
			Assert.assertTrue("Fail to navigate LedgerAccounts",Utility.return_element_status_after_explicit_wait(OR.Ledger_Accounts_Title));
			test.log(LogStatus.PASS, "Navigate LedgerAccounts");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate LedgerAccounts"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Merchantservices(driver);
			Assert.assertTrue("Fail to navigate Merchantservices",Utility.return_element_status_after_explicit_wait(OR.Merchant_Services_Title));
			test.log(LogStatus.PASS, "Navigate Merchantservices");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Merchantservices"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.DocumentTemplate(driver);
			Assert.assertTrue("Fail to navigate DocumentTemplate",Utility.return_element_status_after_explicit_wait(OR.Document_Templates_Title));
			test.log(LogStatus.PASS, "Navigate DocumentTemplate");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate DocumentTemplate"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.ListManagemnet(driver);
			Assert.assertTrue("Fail to navigate ListManagemnet",Utility.return_element_status_after_explicit_wait(OR.List_Management_Title));
			test.log(LogStatus.PASS, "Navigate ListManagemnet");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate ListManagemnet"); 
		}	

		try  
		{
			Navigation Nav= new Navigation();
			Nav.Admin(driver);
			Assert.assertTrue("Fail to navigate Admin",Utility.return_element_status_after_explicit_wait(OR.Admin_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Admin");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Admin"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Clientinfo(driver);
			Assert.assertTrue("Fail to navigate Clientinfo",Utility.return_element_status_after_explicit_wait(OR.Clients_Title));
			test.log(LogStatus.PASS, "Navigate Clientinfo");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Clientinfo"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Users(driver);
			Assert.assertTrue("Fail to navigate Users",Utility.return_element_status_after_explicit_wait(OR.New_User_Btn));
			test.log(LogStatus.PASS, "Navigate Users");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Users"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Roles(driver);
			Assert.assertTrue("Fail to navigate Roles",Utility.return_element_status_after_explicit_wait(OR.New_Role_Btn));
			test.log(LogStatus.PASS, "Navigate Roles");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Roles"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.NightAudit(driver);
			Assert.assertTrue("Fail to navigate NightAudit",Utility.return_element_status_after_explicit_wait(OR.Period_Status_Title));
			test.log(LogStatus.PASS, "Navigate NightAudit");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate NightAudit"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.Reports(driver);
			Assert.assertTrue("Fail to navigate Reports",Utility.return_element_status_after_explicit_wait(OR.Reports_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Reports");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate Reports"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.AccountBalances(driver);
			Assert.assertTrue("Fail to navigate AccountBalances",Utility.return_element_status_after_explicit_wait(OR.Account_Balance_Summary_Title));
			test.log(LogStatus.PASS, "Navigate AccountBalances");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate AccountBalances"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.LedgerBalances(driver);
			Assert.assertTrue("Fail to navigate LedgerBalances",Utility.return_element_status_after_explicit_wait(OR.Ledger_Balances_Title));
			test.log(LogStatus.PASS, "Navigate LedgerBalances");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate LedgerBalances"); 
		}	

		try
		{
			Navigation Nav= new Navigation();
			Nav.MerchantTrans(driver);
			Assert.assertTrue("Fail to navigate MerchantTrans",Utility.return_element_status_after_explicit_wait(OR.Merchant_Transaction_From_Date_Feild));
			test.log(LogStatus.PASS, "Navigate MerchantTrans");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate MerchantTrans"); 
		}	




		try
		{
			Navigation Nav= new Navigation();
			Nav.DailyFalsh(driver);
			Assert.assertTrue("Fail to navigate DailyFalsh",Utility.return_element_status_after_explicit_wait(OR.Daily_Flash_From_Date_Feild));
			test.log(LogStatus.PASS, "Navigate DailyFalsh");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate DailyFalsh"); 
		}	
		try
		{
			Navigation Nav= new Navigation();
			Nav.RoomForecast(driver);
			Assert.assertTrue("Fail to navigate RoomForecast",Utility.return_element_status_after_explicit_wait(OR.Room_Forecast_From_Date_Feild));
			test.log(LogStatus.PASS, "Navigate RoomForecast");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate RoomForecast"); 
		}	


		try
		{
			Navigation Nav= new Navigation();
			Nav.NetSales(driver);
			Assert.assertTrue("Fail to navigate NetSales",Utility.return_element_status_after_explicit_wait(OR.Net_Sales_Title));
			test.log(LogStatus.PASS, "Navigate NetSales");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate NetSales"); 
		}	


		try
		{
			Navigation Nav= new Navigation();
			Nav.AdvanceDeposite(driver);
			Assert.assertTrue("Fail to navigate AdvanceDeposite",Utility.return_element_status_after_explicit_wait(OR.Deposit_Title));
			test.log(LogStatus.PASS, "Navigate AdvanceDeposite");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to navigate AdvanceDeposite"); 
		}	

		extent.endTest(test);
	}



	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("NavigationFlow",excel);
	}








}
