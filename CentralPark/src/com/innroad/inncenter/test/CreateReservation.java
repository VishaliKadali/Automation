package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Create_Reservation;
import com.innroad.inncenter.Implementation.Header_Panel_Elements;
import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.SupportPanle_ClientSelection;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;

public class CreateReservation extends testCore {
	
	 @BeforeTest
		public void checkRunMode()
	 {
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("CreateReservation", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
	  }
	 
	 
	 @Test(dataProvider="getData")
		public void Create_Reservation(String url,String ClientCode, String Username, String Password, String ClientName, String MarketSegment, String ReferralDropDown, String FirstName,
				String LastName, String Adults, String SelectRoomClassRoomAssign, String SelectRoomNumber
				
				) throws InterruptedException, IOException
		{
			
	    	
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    	 
	    	 Header_Panel_Elements SEARCHICON =  new Header_Panel_Elements();
	    	 SEARCHICON.iSearchIcon(driver);
	    	 //SEARCHICON.iInventoryIcon(driver);
	    	  
	    	 SupportPanle_ClientSelection CLIENTSELECTION = new SupportPanle_ClientSelection();
	    	 CLIENTSELECTION.Client_Selection(driver, ClientName);
	    	 
	    	 Create_Reservation CREATERESERVATIONS = new Create_Reservation();
	    	 CREATERESERVATIONS.createReservation(driver, MarketSegment, ReferralDropDown, FirstName, LastName, Adults, SelectRoomClassRoomAssign, SelectRoomNumber);
	    	    	
	    	
		}
	 
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("CreateReservation",excel);
		}

}
