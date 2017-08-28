package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.Implementation.Login;
import com.innroad.inncenter.Implementation.Navigation;
import com.innroad.inncenter.Implementation.Reservation;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;

public class NewResButtonSearch extends testCore {
	

	 @BeforeTest
		public void checkRunMode(){
			
			PropertyConfigurator.configure("Log4j.properties");
			
			if(!Utility.isExecutable("NewResButtonSearch", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");
			
			
			
		}
	 @Test(dataProvider="getData", groups="Somke")
		public void newResButtonSearch(String url,String ClientCode, String Username, String Password,String PropertyName) throws InterruptedException, IOException
		{
		 
		 Login LOGIN = new Login();
 	     LOGIN.login(driver,url, ClientCode, Username, Password);
 	     Wait.wait5Second();
 	     double waittime = 0.12;
 	     Reservation res= new Reservation();
 	     long startTime = System.currentTimeMillis();
   	     res.clickNewReservationButton(driver);
   	     Wait.explicit_wait_absenceofelement("//div[@class='modules_loading']");
   	     long endTime   = System.currentTimeMillis();
    	 Wait.waitforloadpage(startTime,endTime,waittime);
 	     
 	
		 
		}
	 
	
	 @DataProvider
		public Object [][] getData(){
			//return test data from the sheetname provided
			
			return Utility.getData("NewResButtonSearch",excel);
		}


}
