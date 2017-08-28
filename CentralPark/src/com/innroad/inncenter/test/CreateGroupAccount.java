package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.AdvGroups;
import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.ReservationSearch;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateGroupAccount extends testCore{
	
	
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("CreateGroupAccount", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 @Test(dataProvider="getData")
		public void CreateAdvGroup(String url,String ClientCode, String Username, String Password,String PropertyName,String MarketingSegment, String GroupReferral,
				String GroupAccountName, String GroupFirstName, String GroupLastName, String GroupPhn, String GroupAddress, 
				String GroupCity, String Groupstate, String GroupPostale, String Groupscountry, String BlockName, String NumberofNights, String UpdatedBlockedRoom,
				String EnterBlockedcount, String RoomClassName, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
				String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
				String Country, String State, String Postalcode, String Phonenumber,String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext
				
				) throws InterruptedException, IOException {
		 
		 ExtentTest test = extent.startTest("CreateGroupAccount", "Group Account Creation")
			 					 .assignCategory("Groups")
			 					 .assignCategory("Sanity");
		 
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
	    	 Navigation nav= new Navigation();
	    	 nav.Groups(driver);
	    	 test.log(LogStatus.PASS, "Navigating to Groups page");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate groups"); 
		     }
	    	 
		     try
		     {
		     AdvGroups advGroups = new AdvGroups();	 
	    	 advGroups.createGroupaccount(driver, MarketingSegment, GroupReferral,GroupAccountName, GroupFirstName, GroupLastName, GroupPhn, GroupAddress, GroupCity, Groupstate, GroupPostale,Groupscountry);
	    	 test.log(LogStatus.PASS, "Click on New Account and update contact info");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to click on new account and update contact info"); 
		     }
		     
		     try
		     {
		     AdvGroups advGroups = new AdvGroups();	 
	    	 advGroups.SaveAdvGroup(driver);
	    	 test.log(LogStatus.PASS, "Save the group");
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to save the group"); 
		     }
		     
		     try
		     {
		     AdvGroups advGroups = new AdvGroups();
	    	 advGroups.EnterBlockName(driver, BlockName);
	    	 advGroups.SearchGroupCriteria(driver, NumberofNights);
	    	 advGroups.updatedAutomaticallyAssignedRooms(driver, UpdatedBlockedRoom);
	    	 advGroups.BlockRoomForSelectedRoomclass(driver, EnterBlockedcount,RoomClassName);
	    	 advGroups.ClickCreateBlock(driver);
	    	 advGroups.SaveAdvGroup(driver);
	    	 test.log(LogStatus.PASS, "Create Block");
	    	
		     }
		     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to create block"); 
		     }
		     
	    	 try
	    	 {
	    	 AdvGroups advGroups = new AdvGroups();	 
	    	 advGroups.NavigateRoomBlock(driver);
	    	 advGroups.ClickBookicon(driver, RoomClassName);
	    	 Wait.wait10Second();
	    	 test.log(LogStatus.PASS, "Navigate to Room Block page and click on book icon");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to Navigate to Room Block page"); 
		     }
	    	 
	    	 try
	    	 {
	    	 Reservation res = new  Reservation();
	    	 res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	    	 res.saveReservation(driver);
	    	 test.log(LogStatus.PASS, "Navigate to new reservation page and create reservation");
	    	 }
	    	 catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to create reservation page"); 
		     }
	    	 extent.endTest(test);
	    	
		}
	 
	 

	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("CreateGroupAccount",excel);
		}

}
