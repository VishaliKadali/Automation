package com.innroad.inncenter.pageobjects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation implements IReservation {

	public static String ReservationConfirmation;
	public static Logger reservationLogger = Logger.getLogger("Reservation");

	public void IPropertySelector(WebDriver driver, String PropertyName) throws InterruptedException {

		try {

			if (driver.findElement(By.xpath("//b[@role='presentation']")).isDisplayed()) {

				driver.findElement(By.id("s2id_autogen1")).click();
				// Wait.explicit_wait_xpath("select2-drop");
				driver.findElement(By.xpath("//li/div[.='" + PropertyName + "']")).click();
				Wait.wait15Second();
			} else {
				// System.out.println("Single Property");
				reservationLogger.info("Single Property Client");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void marketingInfo(WebDriver driver, String MarketSegment, String Referral, String Travel_Agent,
			String ExtReservation) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		try {
			new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
			reservationLogger.info("Selected Market Segment");
			new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
			reservationLogger.info("Selected Referral");
			
			try {
				ReservationPage.Enter_Travel_Agent.sendKeys(Travel_Agent);
			} catch (Exception e) {

			}
			reservationLogger.info("Entered Travel_Agent Info");
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed in MarketingInfo \n" + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Reservation_MarketingInfo" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed in MarketingInfo \n");
			e.printStackTrace();
		}
		ReservationPage.Enter_Ext_Reservation.sendKeys(ExtReservation);
		reservationLogger.info("Entered ExtReservation");
	}

	public void clickNewReservationButton(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.waitUntilPresenceOfElementLocated(OR.New_Reservation_Button);
		ReservationPage.New_Reservation_Button.click();
		reservationLogger.info("Clicked on NewReservationButton");
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}

	@Override
	public void contactInformation(WebDriver driver, String saluation, String FirstName, String LastName,
			String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account,
			String IsTaxExempt, String TaxEmptext) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		try {
			new Select(ReservationPage.Select_Saluation).selectByVisibleText(saluation);
			ReservationPage.Enter_First_Name.clear();
			ReservationPage.Enter_Last_Name.clear();
			ReservationPage.Enter_Address_Search.clear();
			ReservationPage.Enter_Line1.clear();
			ReservationPage.Enter_Line2.clear();
			ReservationPage.Enter_Line3.clear();
			ReservationPage.Enter_City.clear();
			ReservationPage.Enter_Postal_Code.clear();
			ReservationPage.Enter_Phone_Number.clear();
			ReservationPage.Enter_Alt_Phn_number.clear();
			ReservationPage.Enter_email.clear();
			ReservationPage.Enter_First_Name.sendKeys(FirstName);
			ReservationPage.Enter_Last_Name.sendKeys(LastName);
			ReservationPage.Enter_Address_Search.sendKeys(Address);
			ReservationPage.Enter_Line1.sendKeys(Line1);
			ReservationPage.Enter_Line2.sendKeys(Line2);
			ReservationPage.Enter_Line3.sendKeys(Line3);
			ReservationPage.Enter_City.sendKeys(City);
			new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
			new Select(ReservationPage.Select_State).selectByVisibleText(State);
			ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
			ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
			ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
			ReservationPage.Enter_email.sendKeys(Email);
			reservationLogger.info("Entered required contact information");
			
			try
			{
				ReservationPage.Enter_Account.sendKeys(Account);
			}
			catch(Exception e)
			{
				
			}
			
			if (IsTaxExempt.equals("Yes")) {
				if (ReservationPage.Check_IsTaxExempt.isSelected()) {
					ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
					reservationLogger.info("Entered TaxExcemptID");
				} else {
					ReservationPage.Check_IsTaxExempt.click();
					reservationLogger.info("Clicked on TaxExcempt checkbox");
					ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
					reservationLogger.info("Entered TaxExcemptID");
				}
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed in contact Information \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Reservation_ContactInfo" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed in contact Information \n");
			e.printStackTrace();
		}
	}

	public void billingInformation(WebDriver driver, String PaymentMethod, String AccountNumber, String ExpiryDate,
			String BillingNotes) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		try {

			new Select(ReservationPage.Select_Payment_Method).selectByVisibleText(PaymentMethod);
			if (PaymentMethod.equalsIgnoreCase("MC") || PaymentMethod.equalsIgnoreCase("Amex")
					|| PaymentMethod.equalsIgnoreCase("Discover") || PaymentMethod.equalsIgnoreCase("Visa")) {
				ReservationPage.Enter_Account_Number.sendKeys(AccountNumber);
				ReservationPage.Enter_Exp_Card.sendKeys(ExpiryDate);
				ReservationPage.Enter_Billing_Note.sendKeys(BillingNotes);
				reservationLogger.info("Entered Billing Information");

			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed in billing Information \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Reservation_BillingInfo" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed in billing Information \n");
			e.printStackTrace();
		}
	}

	public void roomAssignment(WebDriver driver, String PropertyName, String Nights, String Adults, String Children,
			String RatepromoCode, String CheckorUncheckAssign, String RoomClassName, String RoomNumber)
			throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		try {

			ReservationPage.Click_RoomPicker.click();
			reservationLogger.info("Clicked on RoomPicker button");
			Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
			Wait.wait3Second();
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed to click on RoomPicker button \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_RoomPicker_Button" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed to click on RoomPicker button \n");
			e.printStackTrace();
		}

		/*
		 * try { new Select(ReservationPage.Select_property_RoomAssign).
		 * selectByVisibleText(PropertyName); } catch(Exception e) { new
		 * Select(ReservationPage.Select_property_RoomAssign2).
		 * selectByVisibleText(PropertyName); }
		 */

		Wait.wait5Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		reservationLogger.info("Clicked on Arrival Datapicker");
		ReservationPage.Click_Today.click();
		reservationLogger.info("Selected today's date");

		if (Nights.equals("")) {
			ReservationPage.Enter_Nigts.sendKeys(Nights);
			reservationLogger.info("Entered No of Nights");
		} else {

			ReservationPage.Enter_Nigts.clear();
			ReservationPage.Enter_Nigts.sendKeys(Nights);
			reservationLogger.info("Entered No of Nights");
		}
		ReservationPage.Enter_Adults.sendKeys(Adults);
		reservationLogger.info("Entered No of Adults");
		ReservationPage.Enter_Children.sendKeys(Children);
		reservationLogger.info("Entered No of Children");
		ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);
		reservationLogger.info("Entered Promocode");
		reservationLogger.info("Verifying AssignRooms checkbox is selected or not?");
		if (ReservationPage.Check_Assign_Room.isSelected()) {
			// ReservationPage.Check_Assign_Room.click();
			reservationLogger.info("AssignRooms checkbox is selected");
			ReservationPage.Click_Search.click();
			reservationLogger.info("Clicked on Search button");
		} else {
			reservationLogger.info(
					"AssignRooms checkbox is not selected. Hence, verifying test data value to select the AssignRooms checkbox");
			if (CheckorUncheckAssign.equals("Yes")) {
				ReservationPage.Check_Assign_Room.click();
				reservationLogger.info("AssignRooms checkbox is selected");
				ReservationPage.Click_Search.click();
				reservationLogger.info("Clicked on Search button");
			} else {
				ReservationPage.Click_Search.click();
				reservationLogger.info("Clicked on Search button");
			}
		}
		try {

			new Select(ReservationPage.Select_Room_Class).selectByVisibleText(RoomClassName);
			reservationLogger.info("RoomClass is selected");
			String selectedOption = new Select(ReservationPage.Validating_UnAssgined_DDL).getFirstSelectedOption()
					.getText();
			// System.out.println("selectedOption " + selectedOption);
			reservationLogger.info("RoomNumber selectedOption is:  " + selectedOption);
			if (selectedOption.equals("--Select--")) {
				// new
				// Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
				new Select(ReservationPage.Select_Room_Number).selectByIndex(1);
				reservationLogger.info("Selected first available room from the list");
			} else {
				// System.out.println("Reservation is unassigned");
				reservationLogger.info("Reservation is unassigned");
			}
		} catch (Exception e) {
			Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
			TestCore.test.log(LogStatus.FAIL, "Room classes are not available for these dates \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_RoomClass_Rates" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Room classes are not available for these dates \n");
			e.printStackTrace();

		}

		try {

			ReservationPage.Click_Select.click();
			reservationLogger.info("Clicked on select button from Room Picker Popup");
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed to click on select button from Room Picker Popup \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Select-Button_RoomPicker_Popup" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed to click on select button from Room Picker Popup \n");
			e.printStackTrace();
		}

		try {
			Wait.wait2Second();
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			reservationLogger.info("Waiting for RulesBroken popup to be displayed");
//			Wait.wait5Second();
			if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
				reservationLogger.info("RulesBroken popup is displayed");
				ReservationPage.Click_Continue_RuleBroken_Popup.click();
				reservationLogger.info("Clicked on RulesBroken popup continue button");
			} else {
				reservationLogger.info("Satisfied Rules hence, RulesBroken popup is not displayed");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Exception while waiting for rulesBroken popup \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Waiting_RulesBroken_Popup" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Exception while waiting for rulesBroken popup \n");
			e.printStackTrace();

		}

		try {

			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				String getTotasterTitle = ReservationPage.Toaster_Title.getText();
				String getToastermessage = ReservationPage.Toaster_Message.getText();
				reservationLogger.info("RoomAssignment Toaster Title: " + getTotasterTitle);
				reservationLogger.info("RoomAssignment Toaster Message: " + getToastermessage);
				Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
				Assert.assertEquals(getToastermessage, "Room assignment has changed.");
				reservationLogger.info("Verified Room Assignment toaster title and message");
			}
			
			Wait.wait2Second();
			String getPropertyName = ReservationPage.Get_Property_Name.getText();
			String getRoomclassName_status = ReservationPage.Get_RoomClass_Status.getText();
			reservationLogger.info("Room Class Status:" + getRoomclassName_status);
			Assert.assertEquals(getPropertyName, PropertyName);
			String getRoomclassName[] = getRoomclassName_status.split(" ");
			// Assert.assertEquals(getRoomclassName[0],RoomClassName );
			if (CheckorUncheckAssign.equals("Yes")) {

			} else {
				Assert.assertEquals(getRoomclassName[2], "Unassigned");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Exception occurred while verifying toaster message \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Waiting_Toaster" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Exception occurred while verifying toaster message \n");
			e.printStackTrace();
		}

	}

	public void saveReservation(WebDriver driver) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Save_ReservationDetails.click();
		Wait.wait2Second();
		try {
			if (ReservationPage.Verify_Depos_policy.isDisplayed()) {
				ReservationPage.Click_Without_Deposit.click();
			}
		} catch (Exception ne) {

		}
		try {
			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				String getTotasterTitle_ReservationSucess = ReservationPage.Toaster_Title.getText();
				String getToastermessage_ReservationSucess = ReservationPage.Toaster_Message.getText();
				Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");
				if (getToastermessage_ReservationSucess.endsWith("has been saved successfully"))
					;
			}
		} catch (Exception e) {

		}
		Wait.wait5Second();
	}

	public void manualEmail(WebDriver driver, String Email, String Attachment) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Email_icon.click();
		Wait.explicit_wait_xpath(OR.Verify_Send_Email_Popup);
		Wait.explicit_wait_absenceofelement(OR.Verify_loading_popup_mailContentPopUp);
		Wait.wait5Second();
		String GetEmailid = ReservationPage.Get_email_Id.getText();
//		System.out.println(GetEmailid + "" + GetEmailid);
		if (GetEmailid.equals("dinesh.ganganaboina@gmail.com")) {

		} else {
			ReservationPage.Get_email_Id.clear();
			Wait.wait3Second();
			ReservationPage.Get_email_Id.sendKeys(Email);
		}
		new Select(ReservationPage.Select_Attachment).selectByVisibleText(Attachment);
		Wait.wait5Second();
		ReservationPage.Click_Send_Email.click();
		Wait.wait10Second();
	}

	public void Checkin(WebDriver driver, String PropertyName, String RoomClassName, String CheckorUncheckAssign,
			String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)
			throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		try {
			ReservationPage.Click_Checkin.click();
			reservationLogger.info("Clicked on CheckIn button");
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed to click on check-in button \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_Click_CheckinButton" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Failed to click on check-in button \n");
			e.printStackTrace();
		}
		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		Wait.wait5Second();
		// long Loadguestregform_StartTime = System.currentTimeMillis();
		try {
			ReservationPage.Click_Select.click();
			reservationLogger.info("Clicked on select button of room assignment popup");
			Wait.wait3Second();
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Failed to click on check-in button \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_CheckIn_SelectButton_RoomAssignment" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Verification failed");
			reservationLogger.info("Failed to clicked on select button of room assignment popup while check-in \n");
			e.printStackTrace();
		}
		
		Wait.wait10Second();

		try {

			if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
				ReservationPage.Click_Continue_RuleBroken_Popup.click();
				reservationLogger.info("Clicked on continue button of RulesBroken Popup");
			} else {
				reservationLogger.info("Satisfied Rules");
			}
			if (ReservationPage.Verify_Dirty_Room_popup.isDisplayed()) {
				ReservationPage.Confirm_button.click();
				reservationLogger.info("Clicked on confirm button of DirtyRoom Popup");
				Wait.wait15Second();
			} else {
				reservationLogger.info("No Dirty Rooms");
			}
		} catch (Exception e) {
			
		}

		try {
			if (ReservationPage.Payment_Popup.isDisplayed()) {
				reservationLogger.info("Payment popup is displayed");
				ReservationFolio Payment = new ReservationFolio();
				Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
						ChangeAmount, ChangeAmountValue, traceData);
				reservationLogger.info("Payment process is completed");
			}
		} catch (Exception e) {
			reservationLogger.info("Checkin Policy doesn't exist");
		}

		Wait.wait15Second();
		ReservationPage.Click_on_confirm.click();
		reservationLogger.info("Clicked on Confirm button of Guest Registration Form");
		try {
			if (ReservationPage.Key_Generation_Popup.isDisplayed()) {
				ReservationPage.Key_Generation_Close.click();
				Wait.wait15Second();
			}
		} catch (Exception e) {
			reservationLogger.info("Key Geneartion doesnt exist");
		}
	}

	public void checkout(WebDriver driver, String PaymentType, String CardName, String CCNumber, String CCExpiry,
			String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)

			throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		try {
			Wait.wait5Second();
			ReservationPage.Click_Checkout.click();
			reservationLogger.info("Clicked on CHECKOUT button");
			Wait.wait5Second();

			if (driver.findElement(By.xpath(OR.Resell_Rooms_Popup_Header)).isDisplayed()) {
				driver.findElement(By.xpath(OR.Resell_Rooms_Popup_Continue_Button)).click();
			}

			Wait.wait5Second();

			if (ReservationPage.Payment_Popup.isDisplayed()) {
				reservationLogger.info("Payment Popup is displayed");
				ReservationFolio Payment = new ReservationFolio();
				Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype,
						ChangeAmount, ChangeAmountValue, traceData);
				reservationLogger.info("Payment is processed");
			} else {
				reservationLogger.info("Payment Popup is NOT displayed");
			}
		} catch (Exception e) {
			TestCore.test.log(LogStatus.FAIL, "Checkout is Failed \n"  + e.getMessage() + 
					"\n\n <br> Attaching screenshot below : \n" + TestCore.test.addScreenCapture(Utility.captureScreenShot(TestCore.test.getTest().getName() + "_CheckOut" + Utility.getTimeStamp(), driver)));
			reservationLogger.info("Checkout is Failed \n");
			e.printStackTrace();
		}
/*		Wait.wait5Second();
		Wait.waitUntilPresenceOfElementLocated(OR.Click_Close);
		ReservationPage.Click_Close.click();
		reservationLogger.info("Clicked on CLOSE button of Guest Statement Report");*/
		Wait.wait5Second();

	}

	public void AddNotes(WebDriver driver, String subject, String details, String NoteType, String Notestatus) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		jse.executeScript("arguments[0].click();", ReservationPage.Add_Note_Reservation);
		// ReservationPage.Add_Note_Reservation.click();
		Wait.explicit_wait_xpath(OR.verify_Add_Notes_popup);
		ReservationPage.Enter_Subject_Notes.sendKeys(subject);
		ReservationPage.Enter_Note_Details.sendKeys(details);
		new Select(ReservationPage.Select_Note_Type).selectByVisibleText(NoteType);
		if (ReservationPage.Check_Action_Required.isSelected()) {
			reservationLogger.info("Action Requited checkbox is already selected");
		} else {
			ReservationPage.Check_Action_Required.click();
		}
		new Select(ReservationPage.Select_Notes_Status).selectByVisibleText(Notestatus);

		ReservationPage.Click_Save_Note.click();
		if (ReservationPage.Verify_Added_Notes.isDisplayed()) {
			reservationLogger.info("Created note Successfully");
		} else {
			reservationLogger.info("Failed to add notes");
		}

	}

	public void GetReservationnumber(WebDriver driver) throws IOException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationConfirmation = ReservationPage.Get_Confirmation_Number.getText();
		reservationLogger.info("ReservationConfirmation :" + ReservationConfirmation);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
			writer.write(ReservationConfirmation);
			writer.close();
		} catch (Exception e) {

		}

	}

}
