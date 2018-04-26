package com.innroad.inncenter.tests;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;


public class RoomAssignment extends TestCore{
	
	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("NavigationFlow", excel))
				throw new SkipException("Skipping the test");

			}
	 
	 @Test(dataProvider="getData")
	 public void loginLoad(String url,String ClientCode, String Username, String Password,String Nights, String Adults,String Children ) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
		 LOGIN.login(driver,url, ClientCode, Username, Password);
	     Wait.explicit_wait_xpath("//small[.='Items Per Page']");
	     double waittime = 0.12;
	     Reservation res = new  Reservation();	 
	     res.clickNewReservationButton(driver);
	     Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
			Wait.wait3Second();
	     Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	     ReservationPage.Click_RoomPicker.click();
		 Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		 Wait.wait15Second();
			ReservationPage.Click_Arrive_Datepicker.click();
			ReservationPage.Click_Today.click();
			ReservationPage.Enter_Nigts.clear();
			ReservationPage.Enter_Nigts.sendKeys(Nights);
			ReservationPage.Enter_Adults.sendKeys(Adults);
			ReservationPage.Enter_Children.sendKeys(Children);
			ReservationPage.Check_Assign_Room.click();
			long startTime = System.currentTimeMillis();
			ReservationPage.Click_Search.click();
			Wait.explicit_wait_xpath("//tbody[@data-bind='foreach: RoomListWithRules']//td[3]/select[contains(@disabled,'')]");
			long endTime   = System.currentTimeMillis();
			 Wait.waitforloadpage(startTime,endTime,waittime);
			
	    
	     	}
				
        @DataProvider
				public Object [][] getData(){
					
					//return test data from the sheetname provided
					
					return Utility.getData("RoomAssignment",excel);
				}
}