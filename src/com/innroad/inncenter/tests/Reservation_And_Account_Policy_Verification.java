package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Policies;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.innroad.inncenter.webelements.WebElements_Create_Reservation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation_And_Account_Policy_Verification extends TestCore{
	
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Res_Acc_Policy_Verification", excel))
			throw new SkipException("Skipping the test");
		    app_logs.info("Verifying Test case is Skipped or not");
				
	     }
	 @Test(dataProvider="getData")
	public void reservation__And_Account_Policy_Verification(String url,String ClientCode, String Username, String Password,String propertyName,String  Policytype1, 
			String PolicyName,String Deposit_percentage,String PolicyText,String PolicyDesc,String  Policytype2,String Checkin_Percentage,String Policytype3,String Acc_Checkin_Percentage2 , String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext,String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData,String Accounttype, String AccountName, String MargetSegment,String AccountFirstName, String AccountLastName,
		    String Address1, String Address2, String Address3, String AcEmail,String AcState, String AcPostalcode) throws Exception
	
	{
		 String ResPolicyName1,ResPolicyName2,AccountPolicyName3,PolicyText1,PolicyText2,PolicyText3="";
		ResPolicyName1=Deposit_percentage+"% "+Policytype1+" "+PolicyName+Utility.getTimeStamp() ;
		ResPolicyName2=Checkin_Percentage+"% "+Policytype2+" "+PolicyName+Utility.getTimeStamp() ;
		AccountPolicyName3= Acc_Checkin_Percentage2+"% "+Policytype3+" "+PolicyName+Utility.getTimeStamp() ;
		AccountName= AccountName +Utility.getTimeStamp();
		PolicyText1 = Deposit_percentage+"% "+ Policytype1+" "+PolicyName+PolicyText;
		PolicyText2 = Checkin_Percentage+"% "+ Policytype2+" "+PolicyName+PolicyText;
		PolicyText3 = Acc_Checkin_Percentage2+"% "+ Policytype3+" "+PolicyName+PolicyText;
		String Res_Confirmation_Number1="";
		String Res_Confirmation_Number2="";
		
		ExtentTest test = extent.startTest("Reservation_And_Account_Policy_Verification", "New Policy creation Test")
	                 .assignCategory("Policies")
	                 .assignCategory("Smoke");	

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
    	  res.IPropertySelector(driver,propertyName);
   	      test.log(LogStatus.PASS, "Property Selection Success");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to select property"); 
	     }
        
        try
  	     {
  	      Navigation inventoryNavigation = new Navigation();
  	      inventoryNavigation.Inventory(driver);
  	      test.log(LogStatus.PASS, "Navigating to Inventory");
  	     }
  	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate to Inventory page"); 
	     }
  	 
        
        try
   	     {
	      Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
	      Navigate.Menuitem_Policy_Text.click();
	      Wait.explicit_wait_xpath(OR.Policy_Button);
   	      test.log(LogStatus.PASS, "Navigating to Policies");
   	     }
   	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate to Policies page"); 
	     }
         
        
        
         try
   	     {
          Policies Create_New_Policy = new Policies();
   	      Create_New_Policy.NewPolicybutton(driver, Policytype1);
   	      test.log(LogStatus.PASS, "Navigate to new Policy by clicking on new Policy button");
   	     }
   	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate new Policy page"); 
	     }
         
         
         try
         {
        	 Policies Create_New_Policy = new Policies();
        	 Create_New_Policy.Enter_Policy_Name(driver, ResPolicyName1);
        	 Create_New_Policy.Enter_Deposit_Policy_Attributes(driver, "PRC", Deposit_percentage);
        	 Create_New_Policy.Enter_Policy_Desc(driver, PolicyText1, PolicyDesc);
        	 Create_New_Policy.Associate_Sources(driver);
        	 Create_New_Policy.Associate_Seasons(driver);
        	 Create_New_Policy.Associate_RoomClasses(driver);
        	 Create_New_Policy.Associate_RatePlans(driver);
        	 Create_New_Policy.Save_Policy(driver);
        	 Create_New_Policy.Close_Policy_Tab(driver);
      
        	 test.log(LogStatus.PASS, "New deposit Policy saved successfully ");
        	 
         }
         catch(Exception e)
         {
        	 test.log(LogStatus.FAIL, "Fail to save the deposit policy"); 
         }
         
        try
        {
         Policies Create_New_Policy = new Policies();
         Create_New_Policy.Verify_Policy(driver, ResPolicyName1);
         test.log(LogStatus.PASS, "Created deposit policy showing up in search results");
        }
         catch(Exception e)
        {
           test.log(LogStatus.FAIL, "Error! Created deposit policy is not showing up in search results"); 
        }
        
        
        try
  	     {
         Policies Create_New_Policy = new Policies();
  	      Create_New_Policy.NewPolicybutton(driver, Policytype2);
  	      test.log(LogStatus.PASS, "Navigate to new Policy by clicking on new Policy button");
  	     }
  	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate new Policy page"); 
	     }
        
        try
        {
         PolicyText = Checkin_Percentage+"% "+ Policytype2+" "+PolicyName+PolicyText;
       	 Policies Create_New_Policy = new Policies();
       	 Create_New_Policy.Enter_Policy_Name(driver, ResPolicyName2);
       	 Create_New_Policy.Enter_Checkin_Policy_Attributes(driver, "capture", Checkin_Percentage);
       	 Create_New_Policy.Enter_Policy_Desc(driver, PolicyText2, PolicyDesc);
       	 Create_New_Policy.Associate_Sources(driver);
       	 Create_New_Policy.Associate_Seasons(driver);
       	 Create_New_Policy.Associate_RoomClasses(driver);
       	 Create_New_Policy.Associate_RatePlans(driver);
       	 Create_New_Policy.Save_Policy(driver);
       	 Create_New_Policy.Close_Policy_Tab(driver);
     
       	 test.log(LogStatus.PASS, "New Checkin Policy saved successfully ");
       	 
        }
        catch(Exception e)
        {
       	 test.log(LogStatus.FAIL, "Fail to save the Checkin policy"); 
        }
        
       try
       {
        Policies Create_New_Policy = new Policies();
        Create_New_Policy.Verify_Policy(driver, ResPolicyName2);
        test.log(LogStatus.PASS, "Created Checkin policy showing up in search results");
       }
        catch(Exception e)
       {
          test.log(LogStatus.FAIL, "Error! Created Checkin policy is not showing up in search results"); 
       }
        
       
//             
//       
       try
 	     {
          Policies Create_New_Policy = new Policies();
 	      Create_New_Policy.NewPolicybutton(driver, Policytype3);
 	      test.log(LogStatus.PASS, "Navigate to new Policy by clicking on new Policy button");
 	     }
 	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate new Policy page"); 
	     }
       
       try
       {
    	 
          PolicyText = Acc_Checkin_Percentage2+"% "+ Policytype3+" "+PolicyName+PolicyText;
      	  Policies Create_New_Policy = new Policies();
      	 Create_New_Policy.Enter_Policy_Name(driver, AccountPolicyName3);
      	 Create_New_Policy.Enter_Checkin_Policy_Attributes(driver, "capture", Acc_Checkin_Percentage2);
      	 Create_New_Policy.Enter_Policy_Desc(driver, PolicyText3, PolicyDesc);
      	 Create_New_Policy.Associate_Sources(driver);
      	 Create_New_Policy.Associate_Seasons(driver);
      	 Create_New_Policy.Associate_RoomClasses(driver);
      	 Create_New_Policy.Associate_RatePlans(driver);
      	 Create_New_Policy.Save_Policy(driver);
      	 Create_New_Policy.Close_Policy_Tab(driver);
 
      	 test.log(LogStatus.PASS, "New Checkin Policy saved successfully "+AccountPolicyName3);
      	 
       }
       catch(Exception e)
       {
      	 test.log(LogStatus.FAIL, "Fail to save the Checkin policy "+AccountPolicyName3); 
       }
       
      try
      {
       Policies Create_New_Policy = new Policies();
       Create_New_Policy.Verify_Policy(driver, AccountPolicyName3);
       test.log(LogStatus.PASS, "Created "+AccountPolicyName3+"Checkin policy showing up in search results");
      }
       catch(Exception e)
      {
         test.log(LogStatus.FAIL, "Error! Created  "+AccountPolicyName3+"Checkin policy is not showing up in search results"); 
      }
       

       try
	     {
	    	 Navigation Nav= new Navigation();
	    	 Nav.Reservation(driver);
	    	 test.log(LogStatus.PASS, "Navigate to Reservation");
	     }
	     catch(Exception e)
	     {
	    	
	    	 test.log(LogStatus.FAIL, "Fail to navigate Reservation: "+ test.addScreenCapture(Utility.getScreenhot())); 
	     }	 
	    	 
       
       
       try
	     {
	    
	     Reservation res = new  Reservation();
  	     res.clickNewReservationButton(driver);
  	     test.log(LogStatus.PASS, "Click new Reservation button");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to click new reservation button"); 
	     }
	     
	     try
	    {
	    Reservation res = new  Reservation();    	     	     
  	    res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
  	    res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
  	    res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
  	    res.Save_Reservation_Pay_Deposit_Policy(driver, RoomClassName, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData,Deposit_percentage);
  	    Wait.wait2Second();
  	    Res_Confirmation_Number1 = res.GetReservationnumber(driver);
  	    res.Close_Tab(driver);
  	    test.log(LogStatus.PASS, "Entered required fields and saved the reservation");
  	    
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to save the reservation"); 
	     }
  	  
/* Closing the Reservation Tab and Opening again with Search operation to Check in,  
	 As Direct check in is not working sometimes.Taking too much to to load check in policy pop up	   */
  	    try
        {
  	    	
  	    	Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
  	    	ReservationSearch search = new  ReservationSearch(); 
  	    	search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
        }
	    catch(Exception e)
        {
	    	 test.log(LogStatus.FAIL, "System fail to validate Basic Search with Reservation number");
        }
  	     
  	      
	     try
	     {
	     Reservation res = new  Reservation();
	     Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	     
	     Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);    
	     double endingbalance;
			String GetEndingBalance=ReservationPage.Payment_Details_Folio_Balance.getText();
			System.out.println(GetEndingBalance);
			String RemoveCurreny[]=GetEndingBalance.split(" ");
			endingbalance= Double.parseDouble(RemoveCurreny[1]);
			System.out.println("Ending balance before checkin "+endingbalance);
		 double processedamount=res.CheckinNew(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
	     double processed_percent=(processedamount/endingbalance)*100;
	     Assert.assertEquals(Math.round(Double.parseDouble(Checkin_Percentage)), Math.round(processed_percent),"Expected reservation Checkin percetage and processed percentage are not equal. Ending balance"+endingbalance+"Processed amount is "+processedamount);
         ReservationPage.Click_Save_Close.click(); 
	     Wait.wait3Second();
	     test.log(LogStatus.PASS, "Reservation checkin success and Validated reservation Checkin policy");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to checkin reservation and Failed to validate reservation Checkin policy");  
	     }
	     
	     
	     
	 	 try
    	 {
    	 Navigation AccouuntsNavigation = new Navigation();
    	 driver.navigate().refresh();
    	 AccouuntsNavigation.Accounts(driver);
    	 test.log(LogStatus.PASS, "Navigating to Accounts");
    	 }
    	 catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate to accounts page"); 
	     }
	 	 
	// Creating Corporate Account and associating Check in Policy
	     try
    	 {
	     
    	 Account CreateCorporteAccount=new Account();
    	 Elements_Reservation ReservationPage = new Elements_Reservation(driver);
    	 CreateCorporteAccount.NewAccountbutton(driver, Accounttype);
    	 CreateCorporteAccount.AccountDetails(driver, Accounttype, AccountName);
    	 CreateCorporteAccount.AccountAttributes(driver, MargetSegment, Referral);
    	 CreateCorporteAccount.Mailinginfo(driver, AccountFirstName, AccountLastName, Phonenumber, alternativenumber, Address1, Address2, Address3, Email, City, State, Postalcode);
    	 CreateCorporteAccount.Billinginfo(driver);
    	 CreateCorporteAccount.navigateFolio(driver);
       	 Elements_Accounts ClickFolio=new Elements_Accounts(driver);
       	 ClickFolio.Click_Folio_Options.click();
    	 Wait.explicit_wait_visibilityof_webelement(ClickFolio.Select_Account_Checkin_Policy);
    	 new Select (ClickFolio.Select_Account_Checkin_Policy).selectByVisibleText(AccountPolicyName3);
		 Wait.wait2Second();
    	 CreateCorporteAccount.Save(driver);
    	 Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_Toaster_Container);
    	 if(ReservationPage.Verify_Toaster_Container.isDisplayed())
			{
				System.out.println("Toaster_Title Text "+ReservationPage.Toaster_Title.getText());
				String getToastermessage=ReservationPage.Toaster_Message.getText();
				System.out.println("Toaster_Message Text "+getToastermessage);		   							
			}
    	 test.log(LogStatus.PASS, "Enter all required details and created new corp account");
    	 }
    	 catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to save the account"); 
	     }
    	
   
    	 try
	     {
	    
  	      Navigation Reservations = new Navigation();
  	      Reservations.Reservation(driver);
  	      Wait.wait1Second();
	      test.log(LogStatus.PASS, "Navigating to Reservation");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail Navigate Reservations"); 
	     }
    	 
    	 try
	     {
	    
	     Reservation res = new  Reservation();
  	     res.clickNewReservationButton(driver);
  	     test.log(LogStatus.PASS, "Click new Reservation button");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to click new reservation button"); 
	     }
    	 
    	 try
	     {    	 
    	Reservation res = new  Reservation();    	 
    	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
    	res.Associate_CCAccount(driver, AccountName);
    	ReservationPage.Enter_First_Name.sendKeys(FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
   	    res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber); 	 
   	    res.saveReservation(driver);
   	    Res_Confirmation_Number2 = res.GetReservationnumber(driver);
	    driver.navigate().refresh();
   	    test.log(LogStatus.PASS, "Enter required fields and save the reservation");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to create new reservation to verify account policy"); 
	     }
        
    	 /* Closing the Reservation Tab and Opening again with Search operation to Check in,  
    	 As Direct check in is not working sometimes.Taking too much to to load check in policy pop up	     */ 	    
	    try
      {
	     	Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
  	    	ReservationSearch search = new  ReservationSearch(); 
  	    	search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			
      }
	    catch(Exception e)
      {
	    	 test.log(LogStatus.FAIL, "System fail to validate Basic Search with Reservation number");
      }
	     
	    
	    
	    
	     try
	     {
	     Reservation res = new  Reservation();
	     Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	     Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);    
	     double endingbalance;
			String GetEndingBalance=ReservationPage.Payment_Details_Folio_Balance.getText();
			System.out.println(GetEndingBalance);
			String RemoveCurreny[]=GetEndingBalance.split(" ");
			endingbalance= Double.parseDouble(RemoveCurreny[1]);
			System.out.println("Ending balance before checkin "+endingbalance);
			double processedamount=res.CheckinNew(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
			double processed_percent=(processedamount/endingbalance)*100;
	     Assert.assertEquals(Math.round(Double.parseDouble(Acc_Checkin_Percentage2)), Math.round(processed_percent),"Account Checkin percetage and processed percentage are not equal.Processed amount "+processedamount);
	     res.Close_Tab(driver); 	
	     Wait.wait3Second();
	     test.log(LogStatus.PASS, "Account Reservation checkin success and Validated Account Checkin policy");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to checkin account reservation and Failed to validate Account Checkin policy");  
	     }

	     // Deleting policies after test execution 
	     
	       try
	  	     {
	    	  driver.navigate().refresh();
	  	      Navigation inventoryNavigation = new Navigation();
	  	      inventoryNavigation.Inventory(driver);
	  	      test.log(LogStatus.PASS, "Navigating to Inventory");
	  	     }
	  	     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate to Inventory page"); 
		     }
	  	 
	        
	        try
	   	     {
		      Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
		      Navigate.Menuitem_Policy_Text.click();
		      Wait.explicit_wait_xpath(OR.Policy_Button);
	   	      test.log(LogStatus.PASS, "Navigating to Policies");
	   	     }
	   	     catch(Exception e)
		     {
		    	 test.log(LogStatus.FAIL, "Fail to navigate to Policies page"); 
		     }
	      // Deleting policies after test execution 
	     try
	     {
	     
	    	 Policies policy =new Policies();
	    	 policy.Delete_Policy(driver, ResPolicyName1);
	    	 policy.Delete_Policy(driver, ResPolicyName2);
	    	 driver.navigate().refresh();
	    	 policy.Delete_Policy(driver, AccountPolicyName3);
	    	 test.log(LogStatus.PASS, " Deleted created Policies");  
	     }
	     catch(Exception e)
	     {
	    	System.err.println("Failed to Delete all created Policies");
	     }
	    
	     extent.endTest(test);
   	    
	}
	
	
	 
	
	 @DataProvider
	public Object [][] getData(){
			
	//return test data from the sheetname provided
	return Utility.getData("Res_Acc_Policy_Verification",excel);
	  }
	
}
