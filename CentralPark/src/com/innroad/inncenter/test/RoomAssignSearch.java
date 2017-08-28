package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.PerformanceMethods;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;

public class RoomAssignSearch extends testCore{
	

	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("RoomAssignSearch", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
		}
	 
	 @Test(dataProvider="getData", groups="Somke")
		public void roomAssignSearch(String url,String ClientCode, String Username, String Password,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber ) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
	     LOGIN.login(driver,url, ClientCode, Username, Password);
	     Wait.wait5Second();
	     
	     Reservation res= new Reservation();
 	     res.clickNewReservationButton(driver);
 	     Wait.wait5Second();
 	     
 	    PerformanceMethods pm= new PerformanceMethods();
 	    pm.RoomAssignmentSearch(driver, PropertyName, Nights, Adults, Children, RatepromoCode, CheckorUncheckAssign,RoomClassName, RoomNumber);
	
		 
		}
	 
	
	 @DataProvider
		public Object [][] getData(){
			//return test data from the sheetname provided
			
			return Utility.getData("RoomAssignSearch",excel);
		}


}
