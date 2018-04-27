package com.innroad.inncenter.tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

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

public class CheckoutWithZeroBalance  extends TestCore{

	@BeforeTest
	public void checkRunMode(){

		PropertyConfigurator.configure("Log4j.properties");

		if(!Utility.isExecutable("CheckoutWithZeroBalance", excel))
			throw new SkipException("Skipping the test");
		app_logs.info("Verifying Test case is Skipped or not");



	}
	@Test(dataProvider="getData")
	public void checkoutWithZeroBalance(String url,String ClientCode, String Username, String Password, String MarketSegment, String Referral, String Travel_Agent, String ExtReservation,
			String saluation, String FirstName, String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account, String IsTaxExempt,String TaxEmptext, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes,String PropertyName, String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber, String 
			Attachment, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData) throws InterruptedException, IOException{


		ExtentTest test = extent.startTest("CheckOutWithZeroBalance", "CheckOutWithZeroBalance")
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
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			Reservation res = new  Reservation();
			res.marketingInfo(driver, MarketSegment, Referral, Travel_Agent, ExtReservation);
			res.contactInformation(driver, saluation, FirstName, LastName, Address, Line1, Line2, Line3, City, Country, State, Postalcode, Phonenumber, alternativenumber, Email, Account,IsTaxExempt, TaxEmptext);
			res.roomAssignment(driver,PropertyName, Nights, Adults, Children, RatepromoCode,CheckorUncheckAssign, RoomClassName, RoomNumber);
			res.saveReservation(driver);
			res.GetReservationnumber(driver);
			test.log(LogStatus.PASS, "Enter required fields and save the reservation");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Fail to save the reservation"); 
		}


		/* Closing the Reservation Tab and Opening again with Search operation to Check in,  
		 As Direct check in is not working sometimes.Taking too much to to load check in policy pop up	   */
		try
		{

			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			ReservationSearch search = new  ReservationSearch(); 
			driver.navigate().refresh();
			Wait.explicit_wait_visibilityof_webelement(resservationSearch.Basic_Res_Number);
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
			Reservation res = new  Reservation();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Checkin);
			res.Checkin(driver, PropertyName, RoomClassName, CheckorUncheckAssign, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
			test.log(LogStatus.PASS, "Sucessfully checked in");
		}
		catch(Exception e){

			test.log(LogStatus.FAIL, "Failed to checkin "); 
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
			Utility.ScrollToElement(ReservationPage.Click_Pay_Button);
			ReservationPage.Click_Pay_Button.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Payment_Popup);
			if(ReservationPage.Payment_Popup.isDisplayed()){
				ReservationFolio Payment= new ReservationFolio();
				processedamount =Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
				Assert.assertEquals(processedamount, endingbalance," ending balance"+endingbalance+"processed amount "+processedamount);
				res.GetReservationnumber(driver);
				test.log(LogStatus.PASS, "Sucessfully paid the balance amount");
			}

		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Error! Failed to pay balance amount"); 
			System.err.println("Error! Failed to pay balance amount");
		}



		try
		{
			Elements_Reservation ReservationPage = new Elements_Reservation(driver);
			ReservationPage.Click_Checkout.click();
			Wait.wait5Second();
			if(ReservationPage.Payment_Popup.isDisplayed())
			{
				Assert.fail("Payment details pop-up is showinup while checking-in the zero balance reservation");
			}

			if(ReservationPage.Resell_Rooms_Popup.isDisplayed())
			{
				ReservationPage.Resell_Rooms_Popup_Continue_Btn.click();
			}								
			else
			{
				System.out.println("No resell_Rooms_Popup");
			}
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Close);
			ReservationPage.Click_Close.click();						

			if(ReservationPage.Verify_Toaster_Container.isDisplayed())
			{
				System.out.println("Toaster_Title Text "+ReservationPage.Toaster_Title.getText());
				String getToastermessage_ReservationSucess=ReservationPage.Toaster_Message.getText();
				System.out.println("Toaster_Message "+getToastermessage_ReservationSucess);		   							
			}
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Guestinfo);
			String res_status=new Select (ReservationPage.Reservation_Status).getFirstSelectedOption().getText();
			Assert.assertEquals(res_status, "Departed","Failed to checkout Reservation or updating in roomstatus after checkout");
			test.log(LogStatus.PASS, "Sucessfully Checked out and Validated Payment details pop-up while checking-out the zero balance reservation");

		}
		catch(Exception e){

			test.log(LogStatus.FAIL, "Error! while checking-out the zero balance reservation"); 
		}
		extent.endTest(test);
	}	


	@DataProvider
	public Object [][] getData(){

		//return test data from the sheetname provided

		return Utility.getData("CheckOutWithZeroBalance",excel);
	}


}
