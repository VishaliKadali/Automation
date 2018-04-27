package com.innroad.inncenter.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.innroad.inncenter.pageobjects.Housekepping_Status;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Navigation;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_On_All_Navigation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Clean_Room_Classes  extends TestCore{
	

	@BeforeTest
	public void checkRunMode(){
		
		PropertyConfigurator.configure("Log4j.properties");
		
		if(!Utility.isExecutable("Clean_Room_Classes", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");
				
	}
	
	@Test (dataProvider="getData")
	public void clean_Room_Classes(String url,String ClientCode, String Username, String Password,String propertyName,String itemsperpage,String roomcondition) throws Exception
	{
		ExtentTest test = extent.startTest("Clean_Room_Classes", "Cleaning Room Classes Test")
                .assignCategory("Housekeeping Status")
                .assignCategory("Smoke");	
		SoftAssert softAssert= new SoftAssert();
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
	      Elements_On_All_Navigation Navigate = new Elements_On_All_Navigation(driver);
	      Navigate.Guest_Services_Main_Menu.click();
	      Wait.explicit_wait_xpath(OR.Guest_Services_grid);
 	      test.log(LogStatus.PASS, "Navigating to Guest_Services");
 	     }
 	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate to Guest_Services page"); 
	     }
 	    
       try
	     {
	      Navigation guest_ServicesNavigation = new Navigation();
	      guest_ServicesNavigation.HouseKeepingStatus(driver);
	      Wait.explicit_wait_xpath(OR.Housekeeping_Status_Title);
	      test.log(LogStatus.PASS, "Navigating to HouseKeeping Status");
	     }
	     catch(Exception e)
	     {
	    	 test.log(LogStatus.FAIL, "Fail to navigate to HouseKeeping Status page"); 
	     }
      
       try
	     {
         Housekepping_Status Clean_All_Rooms = new Housekepping_Status();
         Clean_All_Rooms.Select_Items_Per_Page(driver,itemsperpage);
         Clean_All_Rooms.Select_Room_Condition_In_Header(driver,roomcondition);
         Clean_All_Rooms.Save(driver);
         test.log(LogStatus.PASS, "Changed "+itemsperpage+" Roomclass condition to Cleaned");
	     }
	     catch(Exception e)
	     {
	    	 softAssert.assertFalse(true, "Error! in Changing Romclass conition");
	    	 test.log(LogStatus.FAIL,"Error! in Changing Romclass conition: " + test.addScreenCapture(Utility.getScreenhot())); 
	    	 test.log(LogStatus.FAIL, "Error! in Changing Romclass conition"); 
	     }

         
                
         softAssert.assertAll();
	     extent.endTest(test);           
   
	}
	
	 @DataProvider
		public Object [][] getData(){
				
		//return test data from the sheet-name provided
		return Utility.getData("Clean_Room_Classes",excel);
		  }
	

}
