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
import com.innroad.inncenter.Implementation.RoomClass;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class NewRoomClass extends testCore{

	//Before Test
	@BeforeTest
	public void checkRunMode(){
		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("NewRoomClass", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");	
	}

	
	// Create New Room Class
	@Test(dataProvider="getData", groups="Somke")
	public void newRoomClass(String url,String ClientCode, String Username, String Password,String PropertyName,String roomClassName,String roomClassAbbrivation,String bedsCount,String maxAdults,String maxPersopns,String roomQuantity) throws InterruptedException, IOException{
		
		try{
		ExtentTest test = extent.startTest("New Room Class", "Room Class")
				.assignCategory("RoomClass")
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
		
		/*
		try{
			Reservation res= new Reservation();
			res.IPropertySelector(driver,PropertyName);
			test.log(LogStatus.PASS, "System successfully changed property");
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "System fail to select Property");
		}	*/
		
		
		// Click on Setup
		try{
			Navigation Nav= new Navigation();
			Nav.Setup(driver);
			Assert.assertTrue("Fail to navigate Setup",Utility.return_element_status_after_explicit_wait(OR.Setup_Menu_Title));
			test.log(LogStatus.PASS, "Navigate Setup");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to navigate Setup"); 
		}	
		
		// Click on Room Classes
		try{
			Navigation Nav= new Navigation();
			Nav.RoomClass(driver);
			Assert.assertTrue("Fail to navigate RoomClass",Utility.return_element_status_after_explicit_wait(OR.New_RoomClass_Btn));
			test.log(LogStatus.PASS, "Navigate RoomClass");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to navigate RoomClass"); 
		}
		
		
		// Click on New Room Class
		try{
			Navigation Nav= new Navigation();
			
			Nav.NewRoomClass(driver);
			Assert.assertTrue("Fail to navigate NewRoomClass",Utility.return_element_status_after_explicit_wait(OR.New_RoomClass_Btn));
			test.log(LogStatus.PASS, "Navigate New Room Class");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to navigate New RoomClass"); 
		}	
		
		
		// Create a new Room Class
		try{
			RoomClass set= new RoomClass();
			boolean flag=set.roomClassInfo(driver, roomClassName, roomClassAbbrivation, bedsCount, maxAdults, maxPersopns,roomQuantity, test);
			System.out.println("Sample :"+flag);
			Assert.assertTrue("Fail to navigate NewRoomClass",Utility.return_element_status_after_explicit_wait(OR.New_RoomClass_Btn));
			test.log(LogStatus.PASS, "successfully Created new room classs");
			
			if(flag==true){
				test.log(LogStatus.PASS, "successfully found new room classs");
			}else{
				test.log(LogStatus.FAIL, "not found new room classs");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to Create new room class"); 
		}	
		
		// Stop report
		extent.endTest(test);
		
		}catch(Exception e){e.printStackTrace();
			System.out.println("Exception");
			System.out.println(e);
		}
	}
	
	
	// Data provider to read the data from excel
	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("New Room Class",excel);
	}

}
