package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Folio;
import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MoveFolioItemsAccrossReservations extends TestCore{

	//Before Test
			@BeforeTest
			public void checkRunMode(){
				PropertyConfigurator.configure("Log4j.properties");

				if(!Utility.isExecutable("MoveFolioItemsAccrossReservations", excel))
					throw new SkipException("Skipping the test");
				app_logs.info("Verifying Test case is Skipped or not");	
			}
			
			// Move folio items inside the reservation
			@Test(dataProvider="getData", groups="Somke")
			public void MoveFolioItemsAccrossRes(String url,String ClientCode, String Username, String Password,String resNumber1,String resNumber2) throws InterruptedException, IOException{
				
				try{
					ExtentTest test = extent.startTest("MoveFolioItemsAccrossReservations", "MoveFolioItemsAccrossReservations")
						.assignCategory("MoveFolioItemsAccrossReservations")
						.assignCategory("Smoke");

					System.out.println("Executing: " + test.getTest().getName()+ " test.");

					// Login to InnCenter
					try{
						Login LOGIN = new Login();
						LOGIN.login(driver,url, ClientCode, Username, Password);
						test.log(LogStatus.PASS, "System successfully logged in the site");
					}catch(Exception e){
						
						test.log(LogStatus.FAIL, "System fail to login");
					}
					
					//Move folio items across the reservations
					try{
						Folio folio = new Folio();
						
						folio.MoveFolioInsideReservation(driver, test, resNumber1, resNumber2);
						
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

				//return test data from the sheetname provided

				return Utility.getData("Move Folio Accross Reservations",excel);
			}

}
