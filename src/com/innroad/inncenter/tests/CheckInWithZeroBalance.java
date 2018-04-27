package com.innroad.inncenter.tests;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.innroad.inncenter.pageobjects.Login;
import com.innroad.inncenter.pageobjects.Reservation;
import com.innroad.inncenter.pageobjects.ReservationFolio;
import com.innroad.inncenter.pageobjects.ReservationSearch;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckInWithZeroBalance extends TestCore{

	@BeforeTest
	public void checkRunMode(){

		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("CheckInWithZeroBalance", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");



	}
	@Test(dataProvider="getData")
	public void checkInWithZeroBalance(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData) throws InterruptedException, IOException{


		ExtentTest test = extent.startTest("CheckInWithZeroBalance", "CheckInWithZeroBalance")
				.assignCategory("Reservations")
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

		try
		{
			Reservation res = new  Reservation();
			res.IPropertySelector(driver,PropertyName);
			test.log(LogStatus.PASS, "Property Selection Success");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to select property"); 
		}

		try
		{
			Reservation res = new  Reservation();
			res.clickNewReservationButton(driver);
			test.log(LogStatus.PASS, "Click new Reservation button");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to click new reservation button"); 
		}

		try
		{
			Reservation res = new  Reservation();
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
			res.saveReservation(driver); 
			test.log(LogStatus.PASS, "Enter required fields and save the reservation");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to save the reservation"); 
		}

		try
		{
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Reservation res = new  Reservation();
			float endingbalance;
			Float processedamount;
			String GetEndingBalance=ReservationPage.Payment_Details_Folio_Balance.getText();
			System.out.println(GetEndingBalance);
			String RemoveCurreny[]=GetEndingBalance.split(" ");
			endingbalance= Float.parseFloat(RemoveCurreny[1]);
			ReservationPage.Click_Pay_Button.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Payment_Popup);
			if(ReservationPage.Payment_Popup.isDisplayed()){
				ReservationFolio Payment= new ReservationFolio();
				processedamount =Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
				Assert.assertEquals(processedamount, endingbalance," ending balance"+endingbalance+"processed amount "+processedamount);
				res.GetReservationnumber(driver);
				ReservationPage.Click_Save_Close.click();
				test.log(LogStatus.PASS, "Sucessfully paid the balance");
			}

		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Error! Failed to pay balance amount"); 
			System.err.println("Error! Failed to pay balance amount");
		}


		/* Closing the Reservation Tab and Opening again with Search operation to Check in,  
		 As Direct check in is not working sometimes.Taking too much to to load check in policy pop up	   */
		try
		{

			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			ReservationSearch search = new  ReservationSearch(); 
			Wait.explicit_wait_visibilityof_webelement(resservationSearch.Basic_Res_Number);
			driver.navigate().refresh();
			search.basicSearch_WithResNumber(driver);
			resservationSearch.Click_On_First_SearchResult.click();
			Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			test.log(LogStatus.PASS, "Validated Basic Search with Reservation number");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "System fail to validate Basic Search with Reservation number");
		}


		try{
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Checkin);
			Wait.wait2Second();
			Actions action =new Actions(driver);
			action.moveToElement(ReservationPage.Click_Checkin).doubleClick().build().perform();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Room_Assignment_PopUp);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Select);
			ReservationPage.Click_Select.click();

			try
			{
				//Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_RulesBroken_Popup);
				Wait.wait2Second();
				if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
				{
					ReservationPage.Click_Continue_RuleBroken_Popup.click();
				}
				else
				{
					System.out.println("Satisfied Rules");
				}
			}
			catch(Exception e)
			{
				System.out.println("Verification failed");
			}
			try
			{
				//Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_Dirty_Room_popup);
				Wait.wait2Second();
				ReservationPage.Confirm_button.click();
			}
			catch(Exception e)
			{
				System.out.println("No Dirty Rooms");
			}


			try
			{
				Wait.wait2Second();
				if(ReservationPage.ReCalculate_Folio_Options_PopUp.isDisplayed())
				{
					ReservationPage.ReCal_Folio_Options_PopUp_No_Charge_Changed.click();
					Wait.wait2Second();
					ReservationPage.ReCal_Folio_Options_PopUp_Select_Btn.click();

				}
			}
			catch(Exception e)
			{
				System.out.println("No ReCalculate Folio Options PopUp");
			}

			if(ReservationPage.Payment_Popup.isDisplayed())
			{
				Assert.fail("Payment details pop-up is showinup while checking-in the zero balance reservation");
			}				
			test.log(LogStatus.PASS, "Validated Payment details pop-up while checking-in the zero balance reservation");

		}
		catch(Exception e){

			test.log(LogStatus.FAIL, "Payment details pop-up is showinup while checking-in the zero balance reservation"); 
		}
//		try
//		{   
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_on_confirm);
			Wait.wait3Second();
			ReservationPage.Click_on_confirm.click();
			test.log(LogStatus.PASS, "Sucessfully checked in");
//		}
//		catch(Exception e){
//
//			test.log(LogStatus.FAIL, "Failed to checkin "); 
//		}
		extent.endTest(test);

	}

	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("CheckInWithZeroBalance",excel);
	}





}
