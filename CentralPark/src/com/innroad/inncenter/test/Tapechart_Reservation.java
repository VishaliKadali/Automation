package com.innroad.inncenter.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
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
				String Email, String Account, String IsTaxExempt, String TaxEmptext
				
				
				) throws InterruptedException, IOException
		{
			
	    	
	    	 Login LOGIN = new Login();
	    	 LOGIN.login(driver,url, ClientCode, Username, Password);
	    
	    	 Reservation res= new Reservation();
	    	 res.IPropertySelector(driver,PropertyName);
	    	 
	    	 Navigation nav= new Navigation();
	    	 nav.TapeChart(driver);
	    	 
	    	 Tapechart TS= new Tapechart();
	    	 TS.TapeChartSearch(driver, TapeChartAdults, TapeChartChildrens,PromoCode);
	    	 TS.click_availableRoomClass(driver);
	    	 
	    	 Reservation Res = new Reservation();
	    	 Res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
	    	 Res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account, IsTaxExempt, TaxEmptext);
	    	 Res.saveReservation(driver);
	    	
	   
	    	
	    	
		}
	 @DataProvider
		public Object [][] getData(){
			
			//return test data from the sheetname provided
			
			return Utility.getData("Tapechart_Reservation",excel);
		}
	    
	 
	 

}
