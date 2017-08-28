package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NavigationFlow extends testCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("NavigationFlow", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 
	 @Test(dataProvider="getData")
		public void login(String url,String ClientCode, String Username, String Password, String PropertyName
				
				
				) throws InterruptedException, IOException
		{
			
		 ExtentTest test = extent.startTest("NavigationFlow", "Executing on training.innroad.com");
		 
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
	    	 
	    	 test.log(LogStatus.PASS, "Navigate UnitownerAccount");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate UnitownerAccount"); 
	     }	
	    	 
	     try
	     {
	    	 Navigation Nav= new Navigation();
	    	 Nav.TravelAgent(driver);
	    	 test.log(LogStatus.PASS, "Navigate TravelAgent");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate TravelAgent"); 
	     }	
	    	 
	     try
	     {
	    	 Navigation Nav= new Navigation();
	    	 Nav.ManagementTransfers(driver);
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
	    	 test.log(LogStatus.PASS, "Navigate RoomMaintenance");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate RoomMaintenance"); 
	     }	
	    	 
	     try
	     {
	    	 Navigation Nav= new Navigation(); 
	    	 Nav.Inventory(driver);
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
	    	 test.log(LogStatus.PASS, "Navigate RoomClass");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate RoomClass"); 
	     }	
	    	
	     try
	     {
	    	 Navigation Nav= new Navigation();
	    	 Nav.LedgerAccounts(driver);
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
	    	 test.log(LogStatus.PASS, "Navigate DocumentTemplate");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate DocumentTemplate"); 
	     }	
	     
	     try
	     {
	    	 Navigation Nav= new Navigation();
	    	 Nav.Admin(driver);
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
	    	 test.log(LogStatus.PASS, "Navigate AdvanceDeposite");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate AdvanceDeposite"); 
	     }	
	     extent.endTest(test);
		}
	 
	/* @AfterSuite
	 public void stop() {
		 extent.flush();
		 StopDriver stp = new StopDriver(driver);
		 stp.Stopdriver();
	}*/
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("NavigationFlow",excel);
		}
	    


}
