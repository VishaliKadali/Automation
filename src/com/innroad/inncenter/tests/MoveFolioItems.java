package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Folio;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MoveFolioItems extends TestCore{
	

	//Before Test
		@BeforeTest
		public void checkRunMode(){
			PropertyConfigurator.configure("Log4j.properties");

			if(!Utility.isExecutable("MoveFolioItems", excel))
				throw new SkipException("Skipping the test");
			app_logs.info("Verifying Test case is Skipped or not");	
		}
		
		// Move folio items inside the reservation
		@Test(dataProvider="getData", groups="Somke")
		public void moveFolio(String url,String ClientCode, String Username, String Password,String resNumber1,String newFolioName,String newFolioDescription) throws InterruptedException, IOException{
			
			try{
				ExtentTest test = extent.startTest("Move Folio", "Move Folio")
					.assignCategory("moveFolio")
					.assignCategory("Smoke");

				System.out.println("Executing: " + test.getTest().getName()+ " test.");

				// Login to InnCenter
				try{
					Login LOGIN = new Login();
					LOGIN.login(driver,url, ClientCode, Username, Password);
					test.log(LogStatus.PASS, "System successfully logged in the site");
				}catch(Exception e){
					System.out.println(e);
					test.log(LogStatus.FAIL, "System fail to login");
				}
				
				try{
					Folio folio = new Folio();
					
					folio.MoveFolioInsideReservation(driver, test, resNumber1,newFolioName, newFolioDescription);
					
				}catch(Exception e){
					System.out.println("Failed");
					e.printStackTrace();
				}
				
				
				
				
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		// Data provider to read the data from excel
		@DataProvider
		public Object [][] getData(){

			//return test data from the sheet-name provided

			return Utility.getData("Move Folio",excel);
		}
}
