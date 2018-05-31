package com.innroad.inncenter.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.AssociateReservationGuestHistory;
import com.innroad.inncenter.pageobjects.GuestHistory;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class AssociateResWithGuestHistory extends TestCore{

	
	 @BeforeTest
		public void checkRunMode(){
			
		 String testName=this.getClass().getSimpleName().trim();
			app_logs.info("Verifying Test case "+ testName.toUpperCase() +" is Skipped or not");
			if (!Utility.isExecutable(testName, excel))
				throw new SkipException("Skipping the test - "+ testName);
			}
	 
	 @Test(dataProvider="getData")
		public void associateResWithGuestHistory(String url,String ClientCode, String Username, String Password, String PropertyName, String salutation, String FirstName, String MarketSegment, String Referral, String AccountFirstName, String AccountLastName, String Phonenumber, String alternativeNumber, String Address1, String Address2, String Address3, String Email, String city, String State, String Postalcode, String GuestProfile)
		{
		
		 test = extent.startTest("AssociateResWithGuestHistory", "Associate Reservation With GuestHistory")
				 				 .assignCategory("AssociateResWithGuestHistory")
				 				 .assignCategory("Regression");
		 
		 String testName=test.getTest().getName().toUpperCase();
			
			app_logs.info("##################################################################################");
			app_logs.info("EXECUTING: " + testName + " TEST.");
			app_logs.info("##################################################################################");

		 
		 //**************** Login*******************//
		 
			 try
		     {
				 Login LOGIN = new Login();
				 LOGIN.login(driver, url, ClientCode, Username, Password);
				 test.log(LogStatus.PASS, "Logged into the application");
				 app_logs.info("Logged into the application");
				 } 
			 	 catch (Exception e) {
			     Utility.updateReport(e, "Failed to Login into the application", testName, "Login");
		     }
	    
		//*******************Select Property ****************//
			 try
		     {
				 Reservation res = new  Reservation();
			     res.IPropertySelector(driver,PropertyName);
			     test.log(LogStatus.PASS, "Property Selection Success");
			     app_logs.info("Selected the Property");
			     }
			     catch (Exception e) {
			         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
			     } catch (Error e) {
			         Utility.updateReport(e, "Failed to Select Property", testName, "IPropertySelector");
		     }
			 
		//*********************Click Guest History******************//	 
		 try
		 {
	    	GuestHistory guest_his= new GuestHistory();
	    	guest_his.guestHistory(driver);
	    	test.log(LogStatus.PASS, " System successfully Navigated to Guest History ");
	    	app_logs.info("System successfully Navigated to Guest History");
		 }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Navigate Guest History", testName, "Navigate_GuestHistory");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Navigate Guest History", testName, "Navigate_GuestHistory");
	     }
		 
		 
		 
		 //*********************Click New Account in Guest History******************//			 
		 try
		 	{
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.guestHistory_NewAccount(driver);
		    test.log(LogStatus.PASS, " System successfully Clicked on New Account button in Guest History ");
		    app_logs.info("System successfully Clicked on New Account button in Guest History");
	         }
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Click New Account Button in Guest History", testName, "NewAccount_GuestHistory");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Click New Account Button in Guest History", testName, "NewAccount_GuestHistory");
	     }
		 
		//*********************Enter the Account details in Guest History ******************//		 
		 try
		 	{
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.guestHistory_AccountDetails(driver, salutation, FirstName);
			 test.log(LogStatus.PASS, " Guest History details entered sucessfully ");
			 app_logs.info("Guest History details entered sucessfully");
	         }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to enter Guest History Account Details", testName, "GuestHistory_AccountDetails");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to enter Guest History Account Details", testName, "GuestHistory_AccountDetails");
	     }
	
		//*********************Enter the Account Attributes************************//
		 try
		 {
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.accountAttributes(driver, MarketSegment, Referral);
			 test.log(LogStatus.PASS, " Sucessfully entered the Account Attribute details ");	
			 app_logs.info("Sucessfully entered the Account Attribute details");
	     }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Enter the Account Attributes", testName, "GuestHistory_accountAttributes");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Enter the Account Attributes", testName, "GuestHistory_accountAttributes");
	     }
		 
		 
		//*********************Enter the Mailing Info Details************************//
		 try
		 {
			
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativeNumber, Address1, Address2, Address3, Email, city, State, Postalcode);
			 test.log(LogStatus.PASS, " Sucessfully entered the Mailing Info details ");
			 app_logs.info("Sucessfully entered the Mailing Info details");
			    
	     }
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to Enter the Mailing Info details", testName, "GuestHistory_MailingInfo");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Enter the Mailing Info details", testName, "GuestHistory_MailingInfo");
	     }
		 
		 
		 //*********************Enter the Billing Info Details************************//
		 try
		 {
			
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.Billinginfo(driver);
			 test.log(LogStatus.PASS, " Sucessfully entered the Billing Info details ");
			 app_logs.info(" Sucessfully entered the Billing Info details ");  
	     }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to Enter the Billing Info details", testName, "GuestHistory_BillingInfo");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Enter the Billing Info details", testName, "GuestHistory_BillingInfo");
	     }
		 
		 
		 //*********************Save the Guest History Details************************//
		 try
		 {
			
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.Save(driver);
			 test.log(LogStatus.PASS, " Sucessfully Saved the Guest History Details ");
			 app_logs.info(" Sucessfully Saved the Guest History Details ");     
	     }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to Save the Guest History details", testName, "GuestHistory_Save");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Save the Guest History details", testName, "GuestHistory_Save");
	     }
		 
		//*********************Close the Guest History account page************************//
		 try
		 {
			
			 GuestHistory guest_his= new GuestHistory();
			 guest_his.closeAccount(driver);
			 test.log(LogStatus.PASS, " Sucessfully Closed the Guest History Account Page ");
			 app_logs.info(" Sucessfully Closed the Guest History Account Page ");   
	     }
		 catch (Exception e) {
	         Utility.updateReport(e, "Fail to Close the Guest History Account Page", testName, "Close_GuestHistory");
	     } catch (Error e) {
	         Utility.updateReport(e, "Fail to Close the Guest History Account Page", testName, "Close_GuestHistory");
	     }
		
		 //************************Associate Guest to the Reservation********************//
		 try
		 {
			
			 AssociateReservationGuestHistory res_guestHis=new AssociateReservationGuestHistory();
			 res_guestHis.associateGuestToReservation(driver, GuestProfile);
			 test.log(LogStatus.PASS, " Associated Reservation with Guest History ");
			 app_logs.info(" Associated Reservation with Guest History  ");     
	     }
		 
		 catch (Exception e) {
	         Utility.updateReport(e, "Failed to Associate Reservation with Guest History", testName, "AsscoiateGuestToRes");
	     } catch (Error e) {
	         Utility.updateReport(e, "Failed to Associate Reservation with Guest History", testName, "AsscoiateGuestToRes");
	     }
		 extent.endTest(test);
	 	}
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("AssociateResWithGuestHistory",excel);
		}
	 
		}
