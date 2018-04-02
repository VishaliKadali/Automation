package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Implementation.Tapechart;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tapechart_Reservation extends testCore {

	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("Tapechart_Reservation", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 
	 @Test(dataProvider="getData")
		public void TapechartReservation(String url,String ClientCode, String Username, String Password,String PropertyName, String TapeChartAdults,String TapeChartChildrens,
				String PromoCode, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation, String saluation, String FirstName, String LastName,
				String Address, String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode, String Phonenumber, String alternativenumber,
				String Email, String Account, String IsTaxExempt, String TaxEmptext	) throws InterruptedException, IOException {
		 
		 ExtentTest test = extent.startTest("TapechartReservation", "Reservation from Tapechart")
	 				 			 .assignCategory("Tapechart")
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
	    	
	    	 
	    	// Navigation nav= new Navigation();
	    	// nav.TapeChart(driver);
          try
          {
                 Navigation nav= new Navigation();
	    	     nav.TapeChart(driver);
	    	     test.log(LogStatus.PASS, "System sucessfully navigated to Tapechart");
          }
	    	
          catch(Exception e)
 	     {
        	  test.log(LogStatus.FAIL, "System fail to navigate tapchart");
 	     }
	    	 
	    	
	    	 try
	    	 {
	    	 Tapechart TS= new Tapechart();
	    	 TS.TapeChartSearch(driver, TapeChartAdults, TapeChartChildrens,PromoCode);
	    	 TS.click_availableRoomClass(driver);
	    	 //TS.click_availableRoomClass(driver);
	    	  test.log(LogStatus.PASS, "System sucessfully clicked on Avaialble Room");
	    	  }
		    	
	          catch(Exception e)
	 	     {
	        	  test.log(LogStatus.FAIL, "System fail to click on Avaiable Room");
	 	     }
	    	 
	    	 try
	    	 {
	    	 Reservation Res = new Reservation();
	    	 Res.marketingInfo(driver, test,MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 Res.contactInformation(driver,test, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	    	 Res.saveReservation(driver,test);
	    	  test.log(LogStatus.PASS, "System sucessfully created reservation");
	    	  }
		    	
	          catch(Exception e)
	 	     {
	        	  test.log(LogStatus.FAIL, "System fail to created reservation");
	 	     }
	   
	    	
	    	
		}
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Tapechart_Reservation",excel);
		}
	    
	 
	 

}
