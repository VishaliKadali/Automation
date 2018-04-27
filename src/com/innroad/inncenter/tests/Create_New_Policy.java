package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Account;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Policies;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Create_New_Policy extends TestCore {
	
	
	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Create_New_Policy", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
				
		
	}
	
	
	@Test (dataProvider="getData")
	public void create_New_Policy(String url,String ClientCode, String Username, String Password,String propertyName,String  Policytype, String PolicyName,String Percentage,String PolicyText,String PolicyDesc) throws InterruptedException
	{
		
		
		PolicyName= Percentage+"% "+Policytype+" "+PolicyName +Utility.getTimeStamp();
		
				
		ExtentTest test = extent.startTest("Create_New_Policy", "New Policy creation Test")
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
   	      Create_New_Policy.NewPolicybutton(driver, Policytype);
   	      test.log(LogStatus.PASS, "Navigate to new Policy by clicking on new Policy button");
   	     }
   	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate new Policy page"); 
	     }
         
         
         try
         {
        	 Policies Create_New_Policy = new Policies();
        	 Create_New_Policy.Enter_Policy_Name(driver, PolicyName);
        	 Create_New_Policy.Enter_Deposit_Policy_Attributes(driver, "PRC", Percentage);
        	 Create_New_Policy.Enter_Policy_Desc(driver, PolicyText, PolicyDesc);
        	 Create_New_Policy.Associate_Sources(driver);
        	 Create_New_Policy.Associate_Seasons(driver);
        	 Create_New_Policy.Associate_RoomClasses(driver);
        	 Create_New_Policy.Associate_RatePlans(driver);
        	 Create_New_Policy.Save_Policy(driver);
        	 Create_New_Policy.Close_Policy_Tab(driver);
      
        	 test.log(LogStatus.PASS, "New Policy saved successfully ");
        	 
         }
         catch(Exception e)
         {
        	 test.log(LogStatus.FAIL, "Fail to save the policy"); 
         }
         
        try
        {
         Policies Create_New_Policy = new Policies();
         Create_New_Policy.Verify_Policy(driver, PolicyName);
         test.log(LogStatus.PASS, "Created policy showing up in search results");
        }
         catch(Exception e)
        {
           test.log(LogStatus.FAIL, "Error! Created policy is not showing up in search results"); 
        }
                 
 	     extent.endTest(test);
         
                  
	}
         
        
   	 
	 @DataProvider
	public Object [][] getData(){
			
	//return test data from the sheetname provided
	return Utility.getData("Create_New_Policy",excel);
	  }
	

}
