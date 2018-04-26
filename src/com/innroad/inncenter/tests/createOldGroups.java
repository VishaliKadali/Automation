package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.OldGroups;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class createOldGroups extends TestCore {
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("CreateOldGroups", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 @Test(dataProvider="getData")
		public void CreateOldGroups(String url,String ClientCode, String Username, String Password,String PropertyName,String MarketingSegment, String GroupReferral, String NumberofNights,
				String GroupAccountName, String GroupFirstName, String GroupLastName, String GroupPhn, String GroupAddress, 
				String GroupCity, String Groupstate, String GroupPostale, String Groupscountry, String Adults, String BlockName, String UpdatedBlockedRoom,
				String EnterBlockedcount, String RoomClassName, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
				String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City,
				String Country, String State, String Postalcode, String Phonenumber,String alternativenumber, String Email, String Account, String IsTaxExempt, String TaxEmptext
				
				) throws InterruptedException, IOException
		{
		 
		 ExtentTest test = extent.startTest("CreateGroupAccount", "Executing on training.innroad.com");
	    	
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
	      OldGroups oldGroups = new OldGroups();	 
	      oldGroups.createGroupaccount(driver, MarketingSegment, GroupReferral,NumberofNights,GroupAccountName, GroupFirstName, GroupLastName, GroupPhn, GroupAddress, GroupCity, Groupstate, GroupPostale,Groupscountry);
    	 test.log(LogStatus.PASS, "Click on New Account and update contact info");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to click on new account and update contact info"); 
	     }
	     
	     try
	     {
	    	OldGroups oldGroups = new OldGroups(); 
	    	 oldGroups.SaveAdvGroup(driver);
	    	 Wait.wait10Second();
    	 test.log(LogStatus.PASS, "Save the group");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to save the group"); 
	     }
	     
	     try
	     {
	    	 OldGroups oldGroups = new OldGroups(); 
	    	 oldGroups.NavigateRoomBlock(driver);
	    	 oldGroups.oldRoomBlock(driver, Adults);
	    	 oldGroups.BlockRoomForSelectedRoomclass(driver, EnterBlockedcount, RoomClassName);
	    	 oldGroups.SaveAdvGroup(driver);
	    	 oldGroups.SearchGroupAccount(driver);
	    	 oldGroups.SearchBookicon(driver);
	    	 oldGroups.pickfromRoominglist(driver, FirstName, LastName);
	    	 test.log(LogStatus.PASS, "Navigate to Room Blocks Page");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate Room Blocks page"); 
	     }
		}
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("CreateOldGroups",excel);
		}
}
