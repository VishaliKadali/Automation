package com.innroad.inncenter.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservation;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.testcore.TestCore;
import com.innroad.inncenter.tests.CheckinCheckoutReservation;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reservation implements IReservation {

	public static String ReservationConfirmation;
	public static Logger reservationLogger = Logger.getLogger("Reservation");
	public static boolean checkinpolicy = false;
	public static boolean flag = false;

	public void IPropertySelector(WebDriver driver, String PropertyName) throws InterruptedException {

		try {

			if (driver.findElement(By.xpath("//b[@role='presentation']")).isDisplayed()) {

				driver.findElement(By.id("s2id_autogen1")).click();
				// Wait.explicit_wait_xpath("select2-drop");
				driver.findElement(By.xpath("//li/div[.='" + PropertyName + "']")).click();
				Wait.wait15Second();
			} else {
				// reservationLogger.info("Single Property");
				reservationLogger.info("Single Property Client");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Double get_FolioBalance(WebDriver driver){

		String Balance=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance=Balance.replace("$", "");

		Double d = Double.parseDouble(Balance);
		reservationLogger.info("Folio First Balance : " + d);
		return d;

	}
<<<<<<< HEAD
=======
	
	
>>>>>>> feature/AUTOMATION-90

	public void marketingInfo(WebDriver driver, String MarketSegment, String Referral, String Travel_Agent,
			String ExtReservation) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
		reservationLogger.info("Selected Market Segment");
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		reservationLogger.info("Selected Referral");

		try {
			ReservationPage.Enter_Travel_Agent.sendKeys(Travel_Agent);
		} catch (Exception e) {

		}
		reservationLogger.info("Entered Travel_Agent Info");
		ReservationPage.Enter_Ext_Reservation.sendKeys(ExtReservation);
		reservationLogger.info("Entered ExtReservation");
	}

	public void clickNewReservationButton(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.New_Reservation_Button);
		ReservationPage.New_Reservation_Button.click();
		reservationLogger.info("Clicked on NewReservationButton");
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Enter_First_Name);
	}

	@Override
	public void contactInformation(WebDriver driver, String saluation, String FirstName, String LastName,
			String Address, String Line1, String Line2, String Line3, String City, String Country, String State,
			String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account,
			String IsTaxExempt, String TaxEmptext) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

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

		try {
			ReservationPage.Enter_Account.sendKeys(Account);
		} catch (Exception e) {

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
	}

	public void billingInformation(WebDriver driver, String PaymentMethod, String AccountNumber, String ExpiryDate,
			String BillingNotes) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Select_Payment_Method).selectByVisibleText(PaymentMethod);
		if (PaymentMethod.equalsIgnoreCase("MC") || PaymentMethod.equalsIgnoreCase("Amex")
				|| PaymentMethod.equalsIgnoreCase("Discover") || PaymentMethod.equalsIgnoreCase("Visa")) {
			ReservationPage.Enter_Account_Number.sendKeys(AccountNumber);
			ReservationPage.Enter_Exp_Card.sendKeys(ExpiryDate);
			ReservationPage.Enter_Billing_Note.sendKeys(BillingNotes);
			reservationLogger.info("Entered Billing Information");
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
			ReservationPage.Enter_Nigts.clear();
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
			// reservationLogger.info("selectedOption " + selectedOption);
			reservationLogger.info("RoomNumber selectedOption is:  " + selectedOption);
			if (selectedOption.equals("--Select--")) {
				// new
				// Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
				new Select(ReservationPage.Select_Room_Number).selectByIndex(1);
				reservationLogger.info("Selected first available room from the list");
			} else {
				// reservationLogger.info("Reservation is unassigned");
				reservationLogger.info("Reservation is unassigned");
			}
		} catch (Exception e) {

		}

		try {

			ReservationPage.Click_Select.click();
			reservationLogger.info("Clicked on select button from Room Picker Popup");
		} catch (Exception e) {

		}

		try {
			Wait.wait2Second();
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			reservationLogger.info("Waiting for RulesBroken popup to be displayed");
			// Wait.wait5Second();
			if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
				reservationLogger.info("RulesBroken popup is displayed");
				ReservationPage.Click_Continue_RuleBroken_Popup.click();
				reservationLogger.info("Clicked on RulesBroken popup continue button");
			} else {
				reservationLogger.info("Satisfied Rules hence, RulesBroken popup is not displayed");
			}
		} catch (Exception e) {

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
//			String getPropertyName = ReservationPage.Get_Property_Name.getText();
			String getRoomclassName_status = ReservationPage.Get_RoomClass_Status.getText();
			reservationLogger.info("Room Class Status:" + getRoomclassName_status);
			Wait.wait15Second();
			//	Assert.assertEquals(getPropertyName,PropertyName);
			String getRoomclassName[] = getRoomclassName_status.split(" ");
			// Assert.assertEquals(getRoomclassName[0],RoomClassName );

			if (CheckorUncheckAssign.equalsIgnoreCase("Yes")) {

			} else {
				Assert.assertEquals(getRoomclassName[getRoomclassName.length - 1], "Unassigned");
			}
		} catch (Exception e) {

		}

	}

	public void saveReservation(WebDriver driver) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.wait2Second();
		ReservationPage.Click_Save_ReservationDetails.click();
		Wait.wait2Second();
		try {
			if (ReservationPage.Verify_Depos_policy.isDisplayed()) {
				ReservationPage.Click_Without_Deposit.click();
			}
		} catch (Exception e) {

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
		// reservationLogger.info(GetEmailid + "" + GetEmailid);
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

	public double Checkin(WebDriver driver, String PropertyName, String RoomClassName, String CheckorUncheckAssign,
			String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)
					throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Actions action = new Actions(driver);
		double processedamount = 0;
		double endingbalance;

		String GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
		reservationLogger.info(GetEndingBalance);
		String RemoveCurreny[] = GetEndingBalance.split(" ");
		endingbalance = Double.parseDouble(RemoveCurreny[1]);
		reservationLogger.info("Ending balance before checkin " + endingbalance);

		Wait.explicit_wait_elementToBeClickable(ReservationPage.Click_Checkin);
		// action.moveToElement(ReservationPage.Click_Checkin).doubleClick().build().perform();
		Wait.wait1Second();
		ReservationPage.Click_Checkin.click();
		reservationLogger.info("Clicked on CheckIn button");

		try {
			Wait.explicit_wait_10sec(ReservationPage.Already_Checked_In_Confirm_Popup);
			ReservationPage.Already_Checked_In_Confirm_Popup_Confirm_Btn.click();
			flag = true;
		} catch (Exception e) {

			reservationLogger.info("No conflicts with room assignment");
		}
		if (flag == true) {
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Room_Assignment_PopUp);
			Select selectRoomNumber = new Select(ReservationPage.Select_Room_Number);
			String selectedOption = selectRoomNumber.getFirstSelectedOption().getText();
			if (selectedOption.contains("(O and")) {

				String RoomwithVandC = driver.findElement(By.xpath("//option[contains(text(),'(V and C)')] "))
						.getAttribute("value");
				selectRoomNumber.selectByValue(RoomwithVandC);
				reservationLogger.info("Selected first available room with V and C status from the list");
				Wait.wait2Second();
				ReservationPage.Click_Select.click();
				reservationLogger.info("Clicked on select button of room assignment popup");
				try {

					Wait.explicit_wait_visibilityof_webelement(ReservationPage.ReCalculate_Folio_Options_PopUp);
					if (ReservationPage.ReCalculate_Folio_Options_PopUp.isDisplayed()) {
						ReservationPage.ReCal_Folio_Options_PopUp_No_Charge_Changed.click();
						action.moveToElement(ReservationPage.ReCal_Folio_Options_PopUp_Select_Btn).click().build()
								.perform();

					}
				} catch (Exception e) {
					reservationLogger.info("No ReCalculate Folio Options PopUp");
				}

			} else {

				reservationLogger.info("No Issues");
			}
		}
		if (flag == false) {
			Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
			Wait.wait5Second();
			// long Loadguestregform_StartTime = System.currentTimeMillis();
			try {
				ReservationPage.Click_Select.click();
				reservationLogger.info("Clicked on select button of room assignment popup");
				Wait.wait3Second();
				Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			} catch (Exception e) {

			}
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
			} else {
				reservationLogger.info("No Dirty Rooms");
			}
		} catch (Exception e) {

		}

		try {
			if (ReservationPage.Payment_Popup.isDisplayed()) {
				reservationLogger.info("This Reservation has checkin ploicy, Payment popup is displayed");
				ReservationFolio Payment = new ReservationFolio();
				checkinpolicy = true;
				processedamount = Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode,
						Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
				reservationLogger.info("Payment process is completed");
			}
		} catch (Exception e) {
			reservationLogger.info("Checkin Policy doesn't exist");
		}


		if(checkinpolicy==false)
		{
			reservationLogger.info("Trying to Clicking on Confirm button of Guest Registration Form in Reservation.java");
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_on_confirm);
			ReservationPage.Click_on_confirm.click();
			Wait.wait3Second();
		}

		try {
			if (ReservationPage.Key_Generation_Popup.isDisplayed()) {
				ReservationPage.Key_Generation_Close.click();
				Wait.wait15Second();
			}
		} catch (Exception e) {
			reservationLogger.info("Key Geneartion doesnt exist");
		}
		checkinpolicy = false;
		return processedamount;
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
			TestCore.test
			.log(LogStatus.FAIL,
					"Checkout is Failed \n" + e.getMessage() + "\n\n <br> Attaching screenshot below : \n"
							+ TestCore.test.addScreenCapture(Utility.captureScreenShot(
									TestCore.test.getTest().getName() + "_CheckOut" + Utility.getTimeStamp(),
									driver)));
			reservationLogger.info("Checkout is Failed \n");
			e.printStackTrace();
		}
		/*
		 * Wait.wait5Second();
		 * Wait.waitUntilPresenceOfElementLocated(OR.Click_Close);
		 * ReservationPage.Click_Close.click(); reservationLogger.
		 * info("Clicked on CLOSE button of Guest Statement Report");
		 */
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

	/*
	 * public void GetReservationnumber(WebDriver driver) throws IOException {
	 * Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	 * ReservationConfirmation =
	 * ReservationPage.Get_Confirmation_Number.getText();
	 * reservationLogger.info("ReservationConfirmation :" +
	 * ReservationConfirmation); try { BufferedWriter writer = new
	 * BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
	 * writer.write(ReservationConfirmation); writer.close(); } catch (Exception
	 * e) {
	 * 
	 * }
	 * 
	 * }
	 */

<<<<<<< HEAD
=======
	
	
	
	/*
	public void clickCheckIn(WebDriver driver) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Checkin);
		// action.moveToElement(ReservationPage.Click_Checkin).doubleClick().build().perform();
		//Wait.wait1Second();
		ReservationPage.Click_Checkin.click();
		reservationLogger.info("Clicked on CheckIn button");
		
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.roomAssignmentpopUpSelectButton);
		ReservationPage.roomAssignmentpopUpSelectButton.click();
		
		
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Save_ReservationDetails);
		ReservationPage.Click_Save_ReservationDetails.click();
		
	}*/
	
	
>>>>>>> feature/AUTOMATION-90
	public void Cancel_Reservation(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Utility.ScrollToElement(ReservationPage.Cancel_Reservation_Icon);
		ReservationPage.Cancel_Reservation_Icon.click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Cancel_Res_Popup);
		if (ReservationPage.Cancel_Res_Popup.isDisplayed()) {
			ReservationPage.Cancel_Reason_Txtarea.sendKeys("Deletion Checking");
			Wait.wait1Second();
			ReservationPage.VoidRC_Chkbox_In_Popup.click();
			ReservationPage.Cancel_Res_Popup_Ok_Btn.click();

		}
		Wait.wait2Second();
		String res_status = new Select(ReservationPage.Reservation_Status).getFirstSelectedOption().getText();
		Assert.assertEquals(res_status, "Cancelled", "Failed to Cancel Reservation");

	}

	public void Close_Tab(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Utility.ScrollToElement(ReservationPage.Close_Tab_Btn);
		Wait.wait1Second();
		ReservationPage.Close_Tab_Btn.click();
		Wait.wait2Second();
		if (ReservationPage.AlertForTab.isDisplayed()) {

			ReservationPage.AlertForTab_Yes_Btn.click();
		}
		Wait.wait1Second();
	}

	public String GetReservationnumber(WebDriver driver) throws IOException, InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.wait1Second();
		ReservationConfirmation = ReservationPage.Get_Confirmation_Number.getText();
		reservationLogger.info("ReservationConfirmation :" + ReservationConfirmation);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
			writer.write(ReservationConfirmation);
			writer.flush();
			writer.close();
		} catch (Exception e) {

		}
		return ReservationConfirmation;

	}

	public void Save_Reservation_Pay_Deposit_Policy(WebDriver driver, String RoomClassName, String PaymentType,
			String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype,
			String ChangeAmount, String ChangeAmountValue, String traceData, String Deposit_percentage)
					throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		float processedamount;
		float endingbalance;
		String GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
		String RemoveCurreny[] = GetEndingBalance.split(" ");
		endingbalance = Float.parseFloat(RemoveCurreny[1]);
		reservationLogger.info(endingbalance);
		Wait.explicit_wait_elementToBeClickable(ReservationPage.Click_Save_ReservationDetails);
		Actions action = new Actions(driver);
		action.moveToElement(ReservationPage.Click_Save_ReservationDetails).click().build().perform();
		// ReservationPage.Click_Save_ReservationDetails.click();
		WebDriverWait wait = new WebDriverWait(TestCore.driver, 120);

		wait.until(ExpectedConditions.visibilityOf((ReservationPage.Click_Continue_Deposit)));
		if (ReservationPage.Verify_Depos_policy.isDisplayed()) {
			ReservationPage.Click_Continue_Deposit.click();

			wait.until(ExpectedConditions.visibilityOf((ReservationPage.Payment_Popup)));
			if (ReservationPage.Payment_Popup.isDisplayed()) {
				reservationLogger.info("This Reservation has deposit ploicy");
				ReservationFolio Payment = new ReservationFolio();
				processedamount = Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode,
						Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);

				float expected_amount = ((Float.parseFloat(Deposit_percentage) * endingbalance) / 100);

				Assert.assertEquals(Math.round(processedamount), Math.round(expected_amount),
						"Calculating " + Deposit_percentage + "% of ending balance " + endingbalance
								+ ",expected amount is " + expected_amount + ", processed amount is "
								+ processedamount);

			} else {
				reservationLogger.error("Payment popup for Deposit Policy is not showing up");
			}
		} else {
			reservationLogger.error("Deposit Policy doesnt exist");
		}

	}

	public void Associate_CCAccount(WebDriver driver, String accountname) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Utility.ScrollToElement(ReservationPage.Enter_Account);
		ReservationPage.Enter_Account.clear();
		ReservationPage.Enter_Account.sendKeys(accountname);
		Wait.explicit_wait_visibilityof_webelement(
				driver.findElement(By.xpath("//a[contains(@title,'" + accountname + "')]")));
		driver.findElement(By.xpath("//a[contains(@title,'" + accountname + "')]")).click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Acc_Picker_Confirm);
		ReservationPage.Acc_Picker_Confirm_Continue_Btn.click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Associated_AccountName);
		if (ReservationPage.Associated_AccountName.getText().equalsIgnoreCase(accountname)) {
			reservationLogger.info("Account associated sucessfully to Reservation");
		} else {

			reservationLogger.error("Failed! to associate Account to Reservation");
		}
	}

	public void Add_Payment_Info(WebDriver driver, String saluation, String FirstName, String LastName, String Line1,
			String Line2, String Line3, String City, String Country, String State, String Postalcode,
			String Phonenumber, String alternativenumber, String Email, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Utility.ScrollToElement(ReservationPage.Click_Show_PaymentInfo);
		ReservationPage.Click_Show_PaymentInfo.click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Folio_Billing_Info_Popup);
		Wait.wait2Second();
		new Select(ReservationPage.Select_Salutation_PaymentInfo_Popup).selectByVisibleText(saluation);
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Enter_First_Name_PaymentInfo_Popup);
		ReservationPage.Enter_First_Name_PaymentInfo_Popup.click();
		ReservationPage.Enter_First_Name_PaymentInfo_Popup.sendKeys(FirstName);
		ReservationPage.Enter_Last_Name_PaymentInfo_Popup.sendKeys(LastName);
		ReservationPage.Enter_Line1_PaymentInfo_Popup.sendKeys(Line1);
		ReservationPage.Enter_Line2_PaymentInfo_Popup.sendKeys(Line2);
		ReservationPage.Enter_Line3_PaymentInfo_Popup.sendKeys(Line3);
		ReservationPage.Enter_City_PaymentInfo_Popup.sendKeys(City);
		new Select(ReservationPage.Select_Country_PaymentInfo_Popup).selectByVisibleText(Country);
		new Select(ReservationPage.Select_State_PaymentInfo_Popup).selectByVisibleText(State);
		ReservationPage.Enter_Postal_Code_PaymentInfo_Popup.sendKeys(Postalcode);
		ReservationPage.Enter_Phone_PaymentInfo_Popup.sendKeys(Phonenumber);
		ReservationPage.Enter_AltPhone_PaymentInfo_Popup.sendKeys(alternativenumber);
		ReservationPage.Enter_Email_PaymentInfo_Popup.sendKeys(Email);
		new Select(ReservationPage.Select_Payment_Method_PaymentInfo_Popup).selectByVisibleText(PaymentMethod);
		ReservationPage.Enter_Account_Number_PaymentInfo_Popup.sendKeys(AccountNumber);
		ReservationPage.Enter_CardExpiryDate_PaymentInfo_Popup.sendKeys(ExpiryDate);
		ReservationPage.Enter_BillingNotes_PaymentInfo_Popup.sendKeys(BillingNotes);
		ReservationPage.Save_Btn_PaymentInfo_Popup.click();
		Wait.wait5Second();
		reservationLogger.info(ReservationPage.Payment_Info_Textarea.getAttribute("value"));
	}

	public void Verify_Line_Item_Details(WebDriver driver) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		if (ReservationPage.Include_Taxes_in_Line_Items_Checkbox.isSelected()) {
			reservationLogger.info("Taxes are included in line Items by defult ");
		} else {
			ReservationPage.Include_Taxes_in_Line_Items_Checkbox.click();
			reservationLogger.info("Taxes are not included in line Items by defult so checking check box");

		}
		String Roomcharge = ReservationPage.First_RC_Line_Item_Amount.getText();
		reservationLogger.info("First RC Line Item Amount -- " + Roomcharge);
		String RemoveCurreny1[] = Roomcharge.split(" ");
		Float roomcharge_amount = Float.parseFloat(RemoveCurreny1[1]);
		reservationLogger.info(roomcharge_amount);
		Utility.ScrollToElement(ReservationPage.First_RC_Line_Item_Desc);
		ReservationPage.First_RC_Line_Item_Desc.click();

		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Item_Details_Popup);
		String Total_Roomcharge = ReservationPage.Total_Charges_In_Item_Details_Popup.getText();
		reservationLogger.info("Total_Roomcharges in line item details popup -- " + Total_Roomcharge);
		String RemoveCurreny2[] = Roomcharge.split(" ");
		Float total_roomcharge_amount = Float.parseFloat(RemoveCurreny2[1]);
		reservationLogger.info(total_roomcharge_amount);
		Assert.assertEquals(roomcharge_amount, total_roomcharge_amount);

		try {
			ReservationPage.Sales_Tax_Link_In_Item_Details_Popup.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Tax_Item_Details_Popup);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Display_Name_In_Tax_Item_Details_Popup);
			reservationLogger.info("Tax Details Popup is displaying, when click on link in line item details Popup");
			ReservationPage.Rate_Details_Popup_Cancel_Btn.click();

		} catch (Exception e) {
			Assert.fail("Tax Details Popup is not displaying, when click on link in line item details Popup");
			reservationLogger
					.error("Tax Details Popup is not displaying, when click on link in line item details Popup");

		}

		try {
			Wait.wait2Second();
			ReservationPage.RC_Link_In_Item_Details_Popup.click();
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Rate_Details_Popup);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Rate_Name_In_Rate_Details_Popup);
			reservationLogger.info("Rate Details Popup is displaying, when click on link in line item details Popup");
			ReservationPage.Rate_Details_Popup_Cancel_Btn.click();
		} catch (Exception e) {
			Assert.fail("Rate Details Popup is not displaying, when click on link in line item details Popup");
			reservationLogger
					.error("Rate Details Popup is not displaying, when click on link in line item details Popup");
			ReservationPage.Item_Details_Popup_Cancel_Btn.click();
		}
	}

	public void marketingInfo(WebDriver driver, ExtentTest test, String MarketSegment, String Referral,
			String Travel_Agent, String ExtReservation) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
		test.log(LogStatus.PASS, "Select market segment : " + MarketSegment);
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		test.log(LogStatus.PASS, "Select Referral : " + Referral);
		try {
			ReservationPage.Enter_Travel_Agent.sendKeys(Travel_Agent);
			test.log(LogStatus.PASS, "Tavel Agent : " + Travel_Agent);
		} catch (Exception e) {

		}
		ReservationPage.Enter_Ext_Reservation.sendKeys(ExtReservation);
		test.log(LogStatus.PASS, "Ext Reservation : " + ExtReservation);
	}

	// @Override
	public void contactInformation(WebDriver driver, ExtentTest test, String saluation, String FirstName,
			String LastName, String Address, String Line1, String Line2, String Line3, String City, String Country,
			String State, String Postalcode, String Phonenumber, String alternativenumber, String Email, String Account,
			String IsTaxExempt, String TaxEmptext) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

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
		test.log(LogStatus.PASS, "Enter First name : " + FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
		test.log(LogStatus.PASS, "Enter Last name : " + LastName);
		ReservationPage.Enter_Address_Search.sendKeys(Address);
		test.log(LogStatus.PASS, "Enter Address : " + Address);
		ReservationPage.Enter_Line1.sendKeys(Line1);
		test.log(LogStatus.PASS, "Enter Line1 : " + Line1);
		ReservationPage.Enter_Line2.sendKeys(Line2);
		test.log(LogStatus.PASS, "Enter Line2 : " + Line2);
		ReservationPage.Enter_Line3.sendKeys(Line3);
		test.log(LogStatus.PASS, "Enter Line3 : " + Line3);
		ReservationPage.Enter_City.sendKeys(City);
		test.log(LogStatus.PASS, "Enter City : " + City);
		new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
		test.log(LogStatus.PASS, "Select Country : " + Country);
		new Select(ReservationPage.Select_State).selectByVisibleText(State);
		test.log(LogStatus.PASS, "Select State : " + State);
		ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
		test.log(LogStatus.PASS, "Enter PostalCode : " + Postalcode);
		ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
		test.log(LogStatus.PASS, "Enter Phone number : " + Phonenumber);
		ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
		test.log(LogStatus.PASS, "Enter Alternate Number : " + alternativenumber);
		ReservationPage.Enter_email.sendKeys(Email);
		test.log(LogStatus.PASS, "Enter Email : " + Email);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			ReservationPage.Enter_Account.sendKeys(Account);
			Wait.wait3Second();

			if (!Account.equalsIgnoreCase("")) {
				Wait.WaitForElement(driver, "//span[@class='span-account-name']");
				if (driver.findElements(By.xpath("//span[@class='span-account-name']")).size() > 0) {
					driver.findElement(By.xpath("//span[@class='span-account-name']")).click();
					//Wait.wait3Second();

					Wait.WaitForElement(driver, "//button[@data-bind='click: continueClicked']");
					driver.findElement(By.xpath("//button[@data-bind='click: continueClicked']")).click();
					//Wait.wait3Second();
				}
				//Wait.wait3Second();
			}
			test.log(LogStatus.PASS, "Enter Account : " + Account);
		} catch (Exception e) {

			reservationLogger.info("Account");
			e.printStackTrace();
		}
		if (IsTaxExempt.equals("Yes")) {
			if (ReservationPage.Check_IsTaxExempt.isSelected()) {

				Wait.WaitForElement(driver, OR.Enter_TaxExemptId);
				ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
				test.log(LogStatus.PASS, "Enter Tax Exempt : " + TaxEmptext);
			} else {
				Wait.WaitForElement(driver, OR.Check_IsTaxExempt);
				ReservationPage.Check_IsTaxExempt.click();
				test.log(LogStatus.PASS, "click Tax Exempt");
				reservationLogger.info("click Tax Exempt");
				ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
				test.log(LogStatus.PASS, "Enter Tax Exempt : " + TaxEmptext);
			}
		}
	}

	public void billingInformation(WebDriver driver, ExtentTest test, String PaymentMethod, String AccountNumber,
			String ExpiryDate, String BillingNotes) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.WaitForElement(driver, OR.Select_Payment_Method);
		new Select(ReservationPage.Select_Payment_Method).selectByVisibleText(PaymentMethod);
		test.log(LogStatus.PASS, "Successfully selected the state : " + PaymentMethod);
		if (PaymentMethod.equalsIgnoreCase("MC") || PaymentMethod.equalsIgnoreCase("Amex")
				|| PaymentMethod.equalsIgnoreCase("Discover") || PaymentMethod.equalsIgnoreCase("Visa")) {
			ReservationPage.Enter_Account_Number.sendKeys(AccountNumber);
			test.log(LogStatus.PASS, "Successfully entered the Account number : " + AccountNumber);
			Wait.WaitForElement(driver, OR.Enter_Exp_Card);
			ReservationPage.Enter_Exp_Card.sendKeys(ExpiryDate);
			test.log(LogStatus.PASS, "Successfully entered the expiry date : " + ExpiryDate);
			ReservationPage.Enter_Billing_Note.sendKeys(BillingNotes);
			test.log(LogStatus.PASS, "Successfully entered the billing notes : " + BillingNotes);
		}
	}

	public void saveReservation(WebDriver driver, ExtentTest test) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		double waittime = 0.12;
		long startTime = System.currentTimeMillis();
		ReservationPage.Click_Save_ReservationDetails.click();
		test.log(LogStatus.PASS, "Successfully clicked on save reservation");
		reservationLogger.info("Successfully clicked on save reservation");

		Wait.wait3Second();
		try {
			if (ReservationPage.Verify_Depos_policy.isDisplayed()) {
				ReservationPage.Click_Without_Deposit.click();
				test.log(LogStatus.PASS, "Successfully clicked with out deposit");
				reservationLogger.info("Successfully clicked with out deposit");
			}
		} catch (Exception ne) {

		}
		try {
			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				Wait.wait3Second();
				String getTotasterTitle_ReservationSucess = ReservationPage.Toaster_Title.getText();
				String getToastermessage_ReservationSucess = ReservationPage.Toaster_Message.getText();
				Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");

				long endTime = System.currentTimeMillis();
				double totalTime = (endTime - startTime);
				double TotalTimeinsecs = totalTime / 1000;
				double ActualTime = TotalTimeinsecs - waittime - 3;
				if (getToastermessage_ReservationSucess.endsWith("has been saved successfully"))
					;
			}
		} catch (Exception e) {

		}
		//Wait.wait5Second();
	}

	public void clickBook(WebDriver driver) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Book_Reservation.click();
		Wait.wait3Second();
	}

	public void saveReservationQuote(WebDriver driver, ExtentTest test) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		double waittime = 0.12;
		long startTime = System.currentTimeMillis();
		ReservationPage.Click_Save_ReservationDetails.click();
		test.log(LogStatus.PASS, "Successfully clicked on save reservation");
		Wait.wait2Second();
		try {
			if (ReservationPage.Verify_Depos_policy.isDisplayed()) {
				ReservationPage.Click_Without_Deposit.click();
				test.log(LogStatus.PASS, "Successfully clicked with out deposit");
			}
		} catch (Exception ne) {

		}
		try {
			if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
				String getTotasterTitle_ReservationSucess = ReservationPage.Toaster_Title.getText();
				String getToastermessage_ReservationSucess = ReservationPage.Toaster_Message.getText();
				Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");

				long endTime = System.currentTimeMillis();
				double totalTime = (endTime - startTime);
				// reservationLogger.info(totalTime + " in Millsecs");
				double TotalTimeinsecs = totalTime / 1000;
				double ActualTime = TotalTimeinsecs - waittime - 3;
				// reservationLogger.info(ActualTime + " in secs");

				if (getToastermessage_ReservationSucess.endsWith("has been saved successfully"))
					;
			}
		} catch (Exception e) {

		}
		Wait.wait2Second();

		try {

			Select sel = new Select(driver.findElement(By.xpath(OR.Get_QuoteReservation_Status)));

			WebElement ele = sel.getFirstSelectedOption();

			String str = ele.getText();
			reservationLogger.info(str);
			assertTrue(str.equalsIgnoreCase("Reserved") || str.equalsIgnoreCase("Confirmed")
					|| str.equalsIgnoreCase("On Hold"));
			test.log(LogStatus.PASS, "Reservation status : " + str);
		} catch (Exception e) {
			e.printStackTrace();
			reservationLogger.info("Reservation status is not Reserved/Confirmed/On Hold");
		}
	}

	public void manualEmail(WebDriver driver, ExtentTest test, String Email, String Attachment)
			throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Email_icon.click();
		test.log(LogStatus.PASS, "Click on Email icon");
		Wait.explicit_wait_xpath(OR.Verify_Send_Email_Popup);
		Wait.explicit_wait_absenceofelement(OR.Verify_loading_popup_mailContentPopUp);
		Wait.wait3Second();
		String GetEmailid = ReservationPage.Get_email_Id.getText();
		// reservationLogger.info(GetEmailid + "" + GetEmailid);
		if (GetEmailid.equals("dinesh.ganganaboina@gmail.com")) {

		} else {
			ReservationPage.Get_email_Id.clear();
			Wait.wait3Second();
			ReservationPage.Get_email_Id.sendKeys(Email);
			test.log(LogStatus.PASS, "Enter  Email : " + Email);
		}
		new Select(ReservationPage.Select_Attachment).selectByVisibleText(Attachment);
		test.log(LogStatus.PASS, "Select Attachment : " + Attachment);
		Wait.wait3Second();
		ReservationPage.Click_Send_Email.click();
		test.log(LogStatus.PASS, "Click on send Email");
		Wait.wait3Second();
	}

	public String GetReservationnumber(WebDriver driver, ExtentTest test) throws IOException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationConfirmation = ReservationPage.Get_Confirmation_Number.getText();
		reservationLogger.info("ReservationConfirmation :" + ReservationConfirmation);
		test.log(LogStatus.PASS, "Reservation Number is : " + ReservationConfirmation);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
			writer.write(ReservationConfirmation);
			writer.flush();
			writer.close();
		} catch (Exception e) {

		}

		return ReservationConfirmation;
	}

	public void marketingInfo(WebDriver driver, ExtentTest test, String MarketSegment, String Referral)
			throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
		test.log(LogStatus.PASS, "Successfully selected the maraket segment : " + MarketSegment);
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		test.log(LogStatus.PASS, "Successfully selected the referral : " + Referral);
	}

	public void contactInformation(WebDriver driver, ExtentTest test, String FirstName, String LastName, String Line1,
			String City, String Country, String State, String Postalcode, String Phonenumber) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		// new
		// Select(ReservationPage.Select_Saluation).selectByVisibleText(saluation);
		ReservationPage.Enter_First_Name.clear();
		ReservationPage.Enter_Last_Name.clear();
		ReservationPage.Enter_Address_Search.clear();
		ReservationPage.Enter_Line1.clear();
		ReservationPage.Enter_Line2.clear();
		ReservationPage.Enter_Line3.clear();
		ReservationPage.Enter_City.clear();
		ReservationPage.Enter_Postal_Code.clear();
		;
		ReservationPage.Enter_Phone_Number.clear();
		;
		ReservationPage.Enter_Alt_Phn_number.clear();
		;
		ReservationPage.Enter_email.clear();
		;
		ReservationPage.Enter_First_Name.sendKeys(FirstName);
		test.log(LogStatus.PASS, "Successfully entered the first name : " + FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
		test.log(LogStatus.PASS, "Successfully entered the last name : " + LastName);
		// ReservationPage.Enter_Address_Search.sendKeys(Address);
		ReservationPage.Enter_Line1.sendKeys(Line1);
		test.log(LogStatus.PASS, "Successfully entered the Address Line1 : " + Line1);
		// ReservationPage.Enter_Line2.sendKeys(Line2);
		// ReservationPage.Enter_Line3.sendKeys(Line3);
		ReservationPage.Enter_City.sendKeys(City);
		test.log(LogStatus.PASS, "Successfully entered the City : " + City);
		new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
		test.log(LogStatus.PASS, "Successfully selected the Country : " + Country);
		new Select(ReservationPage.Select_State).selectByVisibleText(State);
		test.log(LogStatus.PASS, "Successfully selected the state : " + State);
		ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
		test.log(LogStatus.PASS, "Successfully entered the postal code : " + Postalcode);
		ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
		test.log(LogStatus.PASS, "Successfully entered the phone number : " + Phonenumber);
		// ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
		// ReservationPage.Enter_email.sendKeys(Email);
	}

	public void roomAssignment(WebDriver driver, ExtentTest test, String Nights, String Adults, String Children,
			String CheckorUncheckAssign, String RoomClassName, String RoomClassName2) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		Wait.WaitForElement(driver, OR.Click_RoomPicker);
		ReservationPage.Click_RoomPicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on Rooms Picker");
		reservationLogger.info("Successfully clicked on Rooms Picker");

		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		//Wait.wait3Second();
		/*
		 * try { new Select(ReservationPage.Select_property_RoomAssign).
		 * selectByVisibleText(PropertyName); } catch(Exception e) { new
		 * Select(ReservationPage.Select_property_RoomAssign2).
		 * selectByVisibleText(PropertyName); }
		 */
		//Wait.wait5Second();

		Wait.WaitForElement(driver, OR.Click_Arrive_Datepicker);
		ReservationPage.Click_Arrive_Datepicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on arrival date");
		reservationLogger.info("Successfully clicked on arrival date");

		Wait.WaitForElement(driver, OR.Click_Today);
		ReservationPage.Click_Today.click();
		test.log(LogStatus.PASS, "Successfully clicked on Today");
		reservationLogger.info("Successfully clicked on Today");

		Wait.WaitForElement(driver, OR.Enter_Nigts);
		ReservationPage.Enter_Nigts.clear();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		test.log(LogStatus.PASS, "Successfully entered the nights : " + Nights);
		ReservationPage.Enter_Adults.clear();
		ReservationPage.Enter_Adults.sendKeys(Adults);
		test.log(LogStatus.PASS, "Successfully entered the audlts : " + Adults);
		ReservationPage.Enter_Children.clear();
		ReservationPage.Enter_Children.sendKeys(Children);
		test.log(LogStatus.PASS, "Successfully entered the childrens : " + Children);
		// ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);

		if (!ReservationPage.Check_Split_Rooms.isSelected()) {
			ReservationPage.Check_Split_Rooms.click();
			test.log(LogStatus.PASS, "Successfully clicked on split rooms");
			reservationLogger.info("Successfully clicked on split rooms");
		}

		if (ReservationPage.Check_Assign_Room.isSelected()) {
			// ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
			test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
		} else {
			if (CheckorUncheckAssign.equals("Yes")) {
				ReservationPage.Check_Assign_Room.click();
				test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
				reservationLogger.info("Successfully clicked on assign rooms");

				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			} else {

				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
				reservationLogger.info("Successfully clicked on search");
			}
		}

		Thread.sleep(4000);

		int count = 1;
		while (Integer.parseInt(Nights) >= count) {
			Wait.WaitForElement(driver, "//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[2]/select");
			WebElement ele = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[2]/select"));

			Wait.WaitForElement(driver, "//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[3]/select");
			WebElement ele1 = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[3]/select"));
			Select sel = new Select(ele);

			if(count==1){
				//	System.out.println(RoomClassName);
				sel.selectByVisibleText(RoomClassName);
				test.log(LogStatus.PASS, "Successfully selected the room class : "+RoomClassName);
				reservationLogger.info("Successfully selected the room class : "+RoomClassName);

				sel=new Select(ele1);
				java.util.List<WebElement> options = sel.getOptions(); 
				int roomCount=0;
				for(WebElement item:options) 
				{  
					//System.out.println(item.getText());
					if(roomCount==1){
						sel.selectByIndex(1);
						test.log(LogStatus.PASS, "Successfully selected the room number : "+item.getText());
						reservationLogger.info("Successfully selected the room number : "+item.getText());

						break;
					}
					roomCount++;
				}  

			}else{
				sel.selectByVisibleText(RoomClassName2);
				test.log(LogStatus.PASS, "Successfully selected the room class : "+RoomClassName2);
				reservationLogger.info("Successfully selected the room class : "+RoomClassName2);

				sel=new Select(ele1);

				java.util.List<WebElement> options = sel.getOptions(); 
				int roomCount=0;
				for(WebElement item:options) 
				{  
					//System.out.println(item.getText());
					if(roomCount==1){
						sel.selectByIndex(1);
						test.log(LogStatus.PASS, "Successfully selected the room number : "+item.getText());
						reservationLogger.info("Successfully selected the room number : "+item.getText());
						break;
					}
					roomCount++;
				}  
			}
			count++;
		}

		ReservationPage.Click_Select.click();
		test.log(LogStatus.PASS, "Successfully clicked on select");
		try {
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		} catch (Exception e) {
		}
		Wait.wait3Second();
		if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
			test.log(LogStatus.PASS, "Successfully clicked on rule brocken pop up");
		} else {
			reservationLogger.info("Satisfied Rules");
		}

		if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
			String getTotasterTitle = ReservationPage.Toaster_Title.getText();
			String getToastermessage = ReservationPage.Toaster_Message.getText();
			reservationLogger.info(getTotasterTitle + " " + getToastermessage);
			Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
			Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}

		Wait.WaitForElement(driver, OR.Get_RoomClass_Status);
		//		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status = ReservationPage.Get_RoomClass_Status.getText();
		reservationLogger.info(getRoomclassName_status);
		// Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[] = getRoomclassName_status.split(" ");
		// Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if (CheckorUncheckAssign.equals("Yes")) {

		} else {

//			Assert.assertEquals(getRoomclassName[3], "Unassigned");
			Assert.assertEquals(getRoomclassName.length-1,"Unassigned" );
		}
	}

	public void clickGuestInfo(WebDriver driver, ExtentTest test) {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.GuestInfo.click();
		test.log(LogStatus.PASS, "Successfully clicked on Guest Info");
		reservationLogger.info("Successfully clicked on Guest Info");
	}

	public void getNotesCreated(WebDriver driver, ExtentTest test) {

		int count = driver.findElements(By.xpath(OR.Get_Notes)).size();
		String str;
		for (int i = 1; i <= count; i++) {

			str = "//table[@class='table table-striped table-bordered table-hover resGrid1']/tbody/tr[" + i
					+ "]/td[3]/a";
			reservationLogger.info(driver.findElement(By.xpath(str)).getText());
			test.log(LogStatus.PASS, "Successfully get the note : " + driver.findElement(By.xpath(str)).getText());
		}
	}

	public void roomAssignment(WebDriver driver, ExtentTest test, String Nights, String Adults, String Children,
			String CheckorUncheckAssign, String RoomClassName) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_RoomPicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on Rooms Picker");
		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		Wait.WaitForElement(driver, OR.Click_Arrive_Datepicker);
		/*
		 * try { new Select(ReservationPage.Select_property_RoomAssign).
		 * selectByVisibleText(PropertyName); } catch(Exception e) { new
		 * Select(ReservationPage.Select_property_RoomAssign2).
		 * selectByVisibleText(PropertyName); }
		 */
		//Wait.wait5Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on arrival date");
		ReservationPage.Click_Today.click();
		test.log(LogStatus.PASS, "Successfully clicked on Today");
		ReservationPage.Enter_Nigts.clear();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		test.log(LogStatus.PASS, "Successfully entered the nights : " + Nights);
		ReservationPage.Enter_Adults.clear();
		ReservationPage.Enter_Adults.sendKeys(Adults);
		test.log(LogStatus.PASS, "Successfully entered the audlts : " + Adults);
		ReservationPage.Enter_Children.clear();
		ReservationPage.Enter_Children.sendKeys(Children);
		test.log(LogStatus.PASS, "Successfully entered the childrens : " + Children);
		// ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);

		/*
		 * if(!ReservationPage.Check_Split_Rooms.isSelected()){
		 * ReservationPage.Check_Split_Rooms.click(); test.log(LogStatus.PASS,
		 * "Successfully clicked on split rooms"); }
		 */

		if (ReservationPage.Check_Assign_Room.isSelected()) {
			// ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
			test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
		} else {
			if (CheckorUncheckAssign.equals("Yes")) {
				ReservationPage.Check_Assign_Room.click();
				test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			} else {
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			}
		}

		/*
		 * try {
		 * 
		 * new Select(ReservationPage.Select_Room_Class).selectByVisibleText(
		 * RoomClassName); String selectedOption = new
		 * Select(ReservationPage.Validating_UnAssgined_DDL).
		 * getFirstSelectedOption().getText();
		 * reservationLogger.info("selectedOption  " +selectedOption);
		 * if(selectedOption.equals("--Select--")) { //new
		 * Select(ReservationPage.Select_Room_Number).selectByVisibleText(
		 * RoomNumber); new
		 * Select(ReservationPage.Select_Room_Number).selectByIndex(1); } else {
		 * reservationLogger.info("Reservation is unassigned"); } }
		 * catch(Exception e) {
		 * Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
		 * reservationLogger.info("Room Class are not Available for these dates"
		 * );
		 * 
		 * }
		 */


		//Wait.wait5Second();
		int count = 1;
		while (Integer.parseInt(Nights) >= count) {

			Wait.WaitForElement(driver, "//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[2]/select");
			WebElement ele = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[2]/select"));

			Wait.WaitForElement(driver, "//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[3]/select");
			WebElement ele1 = driver.findElement(By	.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+ count + "]/td[3]/select"));
			Select sel = new Select(ele);
			if (count == 1) {
				reservationLogger.info(RoomClassName);
				sel.selectByVisibleText(RoomClassName);
				test.log(LogStatus.PASS, "Successfully selected the room class : " + RoomClassName);
				sel = new Select(ele1);
				java.util.List<WebElement> options = sel.getOptions();
				int roomCount = 0;
				for (WebElement item : options) {
					reservationLogger.info(item.getText());
					if (roomCount == 1) {
						sel.selectByIndex(1);
						test.log(LogStatus.PASS, "Successfully selected the room number : " + item.getText());

						break;
					}
					roomCount++;
				}
			}
			count++;
		}

		ReservationPage.Click_Select.click();
		test.log(LogStatus.PASS, "Successfully clicked on select");
		try {
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		} catch (Exception e) {
			reservationLogger.info("Verification failed");
		}
		Wait.wait2Second();
		if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
			test.log(LogStatus.PASS, "Successfully clicked on rule brocken pop up");
		} else {
			reservationLogger.info("Satisfied Rules");
		}

		if (ReservationPage.Verify_Toaster_Container.isDisplayed()) {
			String getTotasterTitle = ReservationPage.Toaster_Title.getText();
			String getToastermessage = ReservationPage.Toaster_Message.getText();
			reservationLogger.info(getTotasterTitle + " " + getToastermessage);
			Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
			Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}

		//Wait.wait10Second();

		Wait.WaitForElement(driver, OR.Get_RoomClass_Status);
		//		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status = ReservationPage.Get_RoomClass_Status.getText();
		reservationLogger.info(getRoomclassName_status);
		// Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[] = getRoomclassName_status.split(" ");
		// Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if (CheckorUncheckAssign.equals("Yes")) {

		} else {
	//			Assert.assertEquals(getRoomclassName[3], "Unassigned");
			Assert.assertEquals(getRoomclassName.length-1,"Unassigned" );
		}
	}

	public void vaidatePaymentDetails(WebDriver driver, ExtentTest test) {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		String roomChargers = ReservationPage.Room_Charges.getText();
		String incidentals = ReservationPage.Incidentals.getText();
		String taxAndServiceCharges = ReservationPage.TaxesAndServiceCharges.getText();
		String Total = ReservationPage.TotalCharges.getText();

		// test.log(LogStatus.PASS, "Tax is : " + taxAndServiceCharges);

		roomChargers = roomChargers.replace("$", "").trim();
		incidentals = incidentals.replace("$", "").trim();
		taxAndServiceCharges = taxAndServiceCharges.replace("$", "").trim();
		Total = Total.replace("$", "").trim();

		if (Double.parseDouble(roomChargers) + Double.parseDouble(incidentals)
		+ Double.parseDouble(taxAndServiceCharges) == Double.parseDouble(Total)) {
			test.log(LogStatus.PASS, "Totals are equal");
		} else {

			test.log(LogStatus.FAIL, "Totals are not equal");
			reservationLogger.info("Totals are not equal");
		}
	}

	public void validateTaxExempt(WebDriver driver, ExtentTest test) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		Wait.wait2Second();
		// Java script object creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		if (!ReservationPage.Check_IsTaxExempt.isSelected()) {

			Wait.WaitForElement(driver, OR.Check_IsTaxExempt);
			ReservationPage.Check_IsTaxExempt.click();
			test.log(LogStatus.PASS, "Tax exempt check box selected");
			reservationLogger.info("Tax exempt check box selected");

			String str = ReservationPage.TaxExemptThisFieldIsdRequired.getText();

			test.log(LogStatus.PASS, str);

			ReservationPage.Enter_TaxExemptId.sendKeys("123");
			test.log(LogStatus.PASS, "Entered Tax exempt id : " + "123");
		}
	}

	public void click_Folio(WebDriver driver, ExtentTest test) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		//Wait.wait5Second();

		Wait.WaitForElement(driver, OR.MoveFolio_Folio);
		ReservationPage.MoveFolio_Folio.click();
		reservationLogger.info("Click on Folio");
	}

	public void taxDetails(WebDriver driver, ExtentTest test) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		//Wait.wait3Second();

		Wait.WaitForElement(driver, OR.Room_Charges);
		String roomChargers = ReservationPage.Room_Charges.getText();
		String incidentals = ReservationPage.Incidentals.getText();
		String taxAndServiceCharges = ReservationPage.TaxesAndServiceCharges.getText();
		String Total = ReservationPage.TotalCharges.getText();

		test.log(LogStatus.PASS, "Tax is : " + taxAndServiceCharges);

		roomChargers = roomChargers.replace("$", "").trim();
		incidentals = incidentals.replace("$", "").trim();
		taxAndServiceCharges = taxAndServiceCharges.replace("$", "").trim();
		Total = Total.replace("$", "").trim();

		if (Double.parseDouble(taxAndServiceCharges) == 0) {
			test.log(LogStatus.PASS, "Tax is Zero");
		} else {
			test.log(LogStatus.PASS, "Tax are not Zero");
			reservationLogger.info("Tax are not Zero");
		}

		ReservationPage.FirstOpenedReservationClose.click();
		//Wait.wait3Second();
	}

	public double CheckinNew(WebDriver driver, String PropertyName, String RoomClassName, String CheckorUncheckAssign,
			String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode,
			String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)
			throws InterruptedException {


		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		double waittime = 0.12;
		long startTime = System.currentTimeMillis();

		double processedamount = 0;
		double endingbalance;
		String GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
		reservationLogger.info(GetEndingBalance);
		String RemoveCurreny[] = GetEndingBalance.split(" ");
		endingbalance = Double.parseDouble(RemoveCurreny[1]);
		reservationLogger.info("Ending balance before checkin " + endingbalance);
		Wait.wait1Second();
		Actions action = new Actions(driver);
		action.moveToElement(ReservationPage.Click_Checkin).doubleClick().build().perform();
		// ReservationPage.Click_Checkin.click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Room_Assignment_PopUp);
		long endTime = System.currentTimeMillis();
		Wait.waitforloadpage(startTime, endTime, waittime);
		Wait.wait5Second();

		ReservationPage.Click_Select.click();

		try {
			// Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_RulesBroken_Popup);

			Wait.wait2Second();
			if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {
				ReservationPage.Click_Continue_RuleBroken_Popup.click();
			} else {
				reservationLogger.info("Satisfied Rules");
			}
		} catch (Exception e) {
			reservationLogger.info("Verification failed");
		}

		if (ReservationPage.Room_Assignment_PopUp_Error.isDisplayed()) {
			if (ReservationPage.Room_Assignment_PopUp_Error.getText()
					.equalsIgnoreCase("Select valid rooms on all the listed dates")) {
				new Select(ReservationPage.Room_Selector_In_Room_Assignment_PopUp).selectByIndex(2);

				ReservationPage.Click_Select.click();
				Wait.wait2Second();
				if (ReservationPage.Verify_RulesBroken_Popup.isDisplayed()) {

					ReservationPage.Click_Continue_RuleBroken_Popup.click();
				} else {
					reservationLogger.info("Satisfied Rules");
				}
				ReservationPage.Click_Select.click();
			}
		}

		try {
			// Wait.explicit_wait_visibilityof_webelement(ReservationPage.Verify_Dirty_Room_popup);
			Wait.wait2Second();
			ReservationPage.Confirm_button.click();
		} catch (Exception e) {
			reservationLogger.info("No Dirty Rooms");
		}

		try {

			Wait.wait2Second();
			if (ReservationPage.ReCalculate_Folio_Options_PopUp.isDisplayed()) {
				ReservationPage.ReCal_Folio_Options_PopUp_No_Charge_Changed.click();
				Wait.wait2Second();
				action.moveToElement(ReservationPage.ReCal_Folio_Options_PopUp_Select_Btn).click().build().perform();

			}
		} catch (Exception e) {
			reservationLogger.info("No ReCalculate Folio Options PopUp");
		}

		try {
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Payment_Popup);
			if (ReservationPage.Payment_Popup.isDisplayed()) {
				ReservationFolio Payment = new ReservationFolio();
				checkinpolicy = true;
				processedamount = Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode,
						Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);

				reservationLogger.info("Processed amount " + processedamount);
			}
		} catch (Exception e) {
			reservationLogger.info("Checkin Policy doesn't exist");
		}

		if (checkinpolicy == false) {
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_on_confirm);
			ReservationPage.Click_on_confirm.click();
			Wait.wait3Second();
		}

		try {
			if (ReservationPage.Key_Generation_Popup.isDisplayed()) {
				ReservationPage.Key_Generation_Close.click();
				Wait.wait15Second();
			}
		} catch (Exception e) {
			reservationLogger.info("Key Geneartion doesnt exist");
		}
		checkinpolicy = false;
		return processedamount;
	}

	public void Pay_Balance_Amount(WebDriver driver, String PaymentType, String CardName, String CCNumber,
			String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue,
			String traceData) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		float endingbalance;
		Float processedamount;
		String GetEndingBalance = ReservationPage.Payment_Details_Folio_Balance.getText();
		reservationLogger.info("Balance Amount :" + GetEndingBalance);
		String RemoveCurreny[] = GetEndingBalance.split(" ");
		endingbalance = Float.parseFloat(RemoveCurreny[1]);
		Utility.ScrollToElement(ReservationPage.Click_Pay_Button);
		ReservationPage.Click_Pay_Button.click();
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Payment_Popup);
		if (ReservationPage.Payment_Popup.isDisplayed()) {
			ReservationFolio Payment = new ReservationFolio();
			processedamount = Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode,
					Authorizationtype, ChangeAmount, ChangeAmountValue, traceData);
			Assert.assertEquals(processedamount, endingbalance,
					" ending balance " + endingbalance + " processed amount " + processedamount);
		}

	}


	public void roomAssignment(WebDriver driver, ExtentTest test,String Nights, String Adults,
			String Children, String CheckorUncheckAssign
			) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.WaitForElement(driver, OR.Click_RoomPicker);
		ReservationPage.Click_RoomPicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on Rooms Picker");
		reservationLogger.info("Successfully clicked on Rooms Picker");

		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		//Wait.wait5Second();

		Wait.WaitForElement(driver, OR.Click_Arrive_Datepicker);
		ReservationPage.Click_Arrive_Datepicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on arrival date");
		reservationLogger.info("Successfully clicked on arrival date");

		ReservationPage.Click_Today.click();
		test.log(LogStatus.PASS, "Successfully clicked on Today");
		reservationLogger.info("Successfully clicked on Today");

		ReservationPage.Enter_Nigts.clear();
		ReservationPage.Enter_Nigts.sendKeys(Nights);

		test.log(LogStatus.PASS, "Successfully entered the nights : "+Nights);
		reservationLogger.info("Successfully entered the nights : "+Nights);

		ReservationPage.Enter_Adults.clear();
		ReservationPage.Enter_Adults.sendKeys(Adults);
		test.log(LogStatus.PASS, "Successfully entered the audlts : "+Adults);
		reservationLogger.info("Successfully entered the audlts : "+Adults);

		ReservationPage.Enter_Children.clear();
		ReservationPage.Enter_Children.sendKeys(Children);
		test.log(LogStatus.PASS, "Successfully entered the childrens : "+Children);
		reservationLogger.info("Successfully entered the childrens : "+Children);

		if(ReservationPage.Check_Assign_Room.isSelected())
		{
			//			ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
			test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
			reservationLogger.info("Successfully clicked on assign rooms");
		} else {
			if (CheckorUncheckAssign.equals("Yes")) {
				ReservationPage.Check_Assign_Room.click();
				test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
				reservationLogger.info("Successfully clicked on assign rooms");

				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
				reservationLogger.info("Successfully clicked on search");
			} else {
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
				reservationLogger.info("Successfully clicked on search");
			}
		}

		Wait.wait5Second();
		int count = 1;

		WebElement ele = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["
						+ count + "]/td[2]/select"));
		WebElement ele1 = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["
						+ count + "]/td[3]/select"));
		Select sel = new Select(ele);
		if (count == 1) {

			sel.selectByIndex(1);
			test.log(LogStatus.PASS,
					"Successfully selected the room class : " + sel.getFirstSelectedOption().getText());
			reservationLogger.info("Successfully selected the room class : " + sel.getFirstSelectedOption().getText());
			sel = new Select(ele1);
			java.util.List<WebElement> options = sel.getOptions();
			int roomCount = 0;
			for (WebElement item : options) {
				// System.out.println(item.getText());
				if (roomCount == 1) {
					sel.selectByIndex(1);
					test.log(LogStatus.PASS, "Successfully selected the room number : " + item.getText());
					reservationLogger.info("Successfully selected the room number : " + item.getText());

					break;
				}
				roomCount++;
			}
		}

		ReservationPage.Click_Select.click();
		test.log(LogStatus.PASS, "Successfully clicked on select");
		reservationLogger.info("Successfully clicked on select");
		try {
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		} catch (Exception e) {
			// System.out.println("Verification failed");
		}
		Wait.wait3Second();
		if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
		{
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
			test.log(LogStatus.PASS, "Successfully clicked on rule brocken pop up");
			reservationLogger.info("Successfully clicked on rule brocken pop up");
		} else {
			// System.out.println("Satisfied Rules");
		}

		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
			Wait.wait2Second();
			String getTotasterTitle=ReservationPage.Toaster_Title.getText();
			String getToastermessage=ReservationPage.Toaster_Message.getText();
			//System.out.println(getTotasterTitle + " " +getToastermessage);
			reservationLogger.info(getTotasterTitle + " " +getToastermessage);
			Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
			Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}

		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status = ReservationPage.Get_RoomClass_Status.getText();
		// System.out.println(getRoomclassName_status);
		reservationLogger.info(getRoomclassName_status);
		// Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[] = getRoomclassName_status.split(" ");
		// Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if (CheckorUncheckAssign.equals("Yes")) {

		} else {
			Assert.assertEquals(getRoomclassName.length - 1, "Unassigned");
		}
	}

	public void validateAccount(WebDriver driver, ExtentTest test, String Account) {

		driver.findElement(By.xpath("//a[contains(text(),'" + Account.trim() + "')]")).getText();
		test.log(LogStatus.PASS, Account + " added successfully to Reservation");
		reservationLogger.info(Account + " added successfully to Reservation");
	}

	public void verifyPolicyAssociation(WebDriver driver, String PolicyName, String PolicyType)
			throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		String Beforeediting = "";
		Select PolicySelect;
		Utility.ScrollToElement(ReservationPage.Reservation_Folio);
		Wait.wait1Second();
		ReservationPage.Reservation_Folio.click();
		ReservationPage.Reservation_Folio_Options.click();
		switch (PolicyType.toLowerCase()) {

		case "deposit":

			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Select_Reservation_Deposit_Policy);
			Utility.ScrollToElement(ReservationPage.Select_Reservation_Deposit_Policy);
			PolicySelect = new Select(ReservationPage.Select_Reservation_Deposit_Policy);
			Beforeediting = PolicySelect.getFirstSelectedOption().getText();
			if (Beforeediting.equalsIgnoreCase(PolicyName)) {
				reservationLogger.info("Given Policy " + PolicyName + " is Associated Bydeafult");

			} else {
				reservationLogger.error("Given Policy is not Associated Bydeafult");
				reservationLogger.error(
						"Assosiating " + PolicyName + " Manully, Check there may be multiple policies of same type");
				PolicySelect.selectByVisibleText(PolicyName);
				Wait.wait3Second();
				Assert.assertNotEquals(PolicySelect.getFirstSelectedOption().getText(), Beforeediting,
						"Failed to Associate policy to Reservation.");
			}

			break;

		case "check in":
			Utility.ScrollToElement(ReservationPage.Select_Reservation_Checkin_Policy);
			Wait.explicit_wait_visibilityof_webelement(ReservationPage.Select_Reservation_Checkin_Policy);
			Utility.ScrollToElement(ReservationPage.Select_Reservation_Checkin_Policy);
			PolicySelect = new Select(ReservationPage.Select_Reservation_Checkin_Policy);
			Beforeediting = PolicySelect.getFirstSelectedOption().getText();
			if (Beforeediting.equalsIgnoreCase(PolicyName)) {
				reservationLogger.info("Given Policy " + PolicyName + " is Associated Bydeafult");

			} else {
				reservationLogger.error("Given Policy is not Associated Bydeafult");
				reservationLogger.error(
						"Assosiating " + PolicyName + " Manully, Check there may be multiple policies of same type");
				PolicySelect.selectByVisibleText(PolicyName);
				Wait.wait3Second();
			}
			break;
		case "cancellation":

			break;
		case "no show":

			break;
		}

		Utility.ScrollToElement(ReservationPage.Reservation_Folio_Details);
		Wait.wait1Second();
		ReservationPage.Reservation_Folio_Details.click();// navigating back to
															// folio detials for
															// payments
		Wait.explicit_wait_visibilityof_webelement(ReservationPage.Click_Pay_Button);
	}

public void RoomAssign(WebDriver driver, ExtentTest test, String RoomClass) throws InterruptedException {

	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	ReservationPage.RoomAssignmentButton.click();
	Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
	Wait.wait2Second();
	ReservationPage.RoomAssignment_DateIcon.click();
	ReservationPage.SelectDate.click();
	ReservationPage.SearchRoomButton.click();
	Wait.wait2Second();
	new Select(ReservationPage.SelectRoomClasses).selectByVisibleText(RoomClass);
	test.log(LogStatus.PASS, "Select Room Class: " + RoomClass);
	reservationLogger.info("Select Room Class: " + RoomClass);
	new Select(ReservationPage.SelectRoomNumbers).selectByIndex(1);
	Wait.wait2Second();
	String CheckRule = ReservationPage.CheckRule.getText();
	String AvailableRoom = ReservationPage.AvailableRoom.getText();
	int CheckRoom = Integer.parseInt(AvailableRoom);
	ReservationPage.SelectButton.click();
	Wait.wait2Second();
	if (CheckRoom == 0 || CheckRoom < 0) {
		ReservationPage.Continue.get(9).click();
		Wait.wait2Second();
	}
	if (CheckRule.equals("1") || CheckRule.equals("2")) {
		ReservationPage.RoleBroken_Continue.click();
	}

	Wait.wait2Second();
}
public void RoomAssignedReservation(WebDriver driver, ExtentTest test, String RoomClass) throws InterruptedException {

	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	ReservationPage.RoomAssignmentButton.click();
	Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
	Wait.wait2Second();
	ReservationPage.RoomAssignment_DateIcon.click();
	ReservationPage.SelectDate.click();
	ReservationPage.RoomAssign_Check.click();
	ReservationPage.SearchRoomButton.click();
	Wait.wait2Second();
	new Select(ReservationPage.SelectRoomClasses).selectByVisibleText(RoomClass);
	test.log(LogStatus.PASS, "Select Room Class: " + RoomClass);
	reservationLogger.info("Select Room Class: " + RoomClass);
	new Select(ReservationPage.SelectRoomNumbers).selectByIndex(1);
	Wait.wait2Second();
	String CheckRule = ReservationPage.CheckRule.getText();
	String AvailableRoom = ReservationPage.AvailableRoom.getText();
	int CheckRoom = Integer.parseInt(AvailableRoom);
	ReservationPage.SelectButton.click();
	Wait.wait2Second();
	if (CheckRoom == 0 || CheckRoom < 0) {
		ReservationPage.Continue.get(9).click();
		Wait.wait2Second();
	}
	if (CheckRule.equals("1") || CheckRule.equals("2")) {
		ReservationPage.RoleBroken_Continue.click();
	}

	Wait.wait2Second();
}

public void SaveReservation(WebDriver driver) throws InterruptedException {

	Elements_Reservation Elements_Reservations = new Elements_Reservation(driver);
	Wait.explicit_wait_xpath(OR.ReservationSaveButton);
	Elements_Reservations.ReservationSaveButton.get(0).click();
	Utility.ElementFinderUntillNotShow(By.xpath(OR.Toaster_Message), driver);
	Wait.wait2Second();
	boolean size =driver.findElements(By.cssSelector(OR.CancelDepositePolicy_Button)).size()>0;
	if (size) {
		Elements_Reservations.CancelDepositePolicy_Button.get(3).click();
		Wait.wait2Second();
	}
	Wait.wait2Second();
}

  public void CopyButton(WebDriver driver) throws InterruptedException {

	Elements_Reservation Elements_Reservations = new Elements_Reservation(driver);
	Elements_Reservations.CopyButton.click();
	Wait.wait2Second();
	int size = Elements_Reservations.ReservationTab.size();
	assertTrue(Elements_Reservations.ReservationTab.get(size - 1).getText().contains("copy"),
			"Copy of reservation does not create");

}

  public void Apply_Delta(WebDriver driver) throws InterruptedException{
	  
	  Elements_Reservation Elements_Reservations = new Elements_Reservation(driver);
	  String before_apply_delta = Elements_Reservations.Depart_Value.get(1).getText();
	  Elements_Reservations.ExtendReservation_Button.click();
	  Wait.wait2Second();
	  assertEquals(Elements_Reservations.RoomChargerPopup.getText(), "Room Charges Changed",
				"Room charger popup deos not display");
	  Elements_Reservations.ApplyDeltaEnabled_RadioButton.click();
	  Elements_Reservations.Button_RoomChargerSelect.click(); 
	  
	  Utility.ElementFinderUntillNotShow(By.xpath(OR.Toaster_Message), driver);
	  
	  String after_apply_delta =  Elements_Reservations.Depart_Value.get(1).getText();
	  assertNotEquals(after_apply_delta, before_apply_delta,"Apply deleta does not perform");
  }
  
public void Recalcualte_Folio(WebDriver driver) throws InterruptedException{
	  
	  Elements_Reservation Elements_Reservations = new Elements_Reservation(driver);
	  String before_recalculate = Elements_Reservations.Depart_Value.get(1).getText();
	  Elements_Reservations.ExtendReservation_Button.click();
	  Wait.wait2Second();
	  assertEquals(Elements_Reservations.RoomChargerPopup.getText(), "Room Charges Changed",
				"Room charger popup deos not display");
	  Elements_Reservations.RecalculateFolio_RadioButton.click();
	  Elements_Reservations.Button_RoomChargerSelect.click(); 
	  
	  Utility.ElementFinderUntillNotShow(By.xpath(OR.Toaster_Message), driver);
	  
	  String after_recalculate =  Elements_Reservations.Depart_Value.get(1).getText();
	  assertNotEquals(after_recalculate, before_recalculate,"Recalculate folio does not perform");
  }

public void Ext_Dec_Stay_Date(WebDriver driver) throws InterruptedException{
	  
	  Elements_Reservation Elements_Reservations = new Elements_Reservation(driver);
	  String before_ext_date = Elements_Reservations.Depart_Value.get(1).getText();
	  Elements_Reservations.ExtendReservation_Button.click();
	  Wait.wait2Second();
	  assertEquals(Elements_Reservations.RoomChargerPopup.getText(), "Room Charges Changed",
				"Room charger popup deos not display");
	  Elements_Reservations.ApplyDeltaEnabled_RadioButton.click();
	  Elements_Reservations.Button_RoomChargerSelect.click(); 
	  
	  Utility.ElementFinderUntillNotShow(By.xpath(OR.Toaster_Message), driver);
	  
	  String after_ext_date =  Elements_Reservations.Depart_Value.get(1).getText();
	  assertNotEquals(after_ext_date, before_ext_date,"Date does not extend or decend");
}
  
}
