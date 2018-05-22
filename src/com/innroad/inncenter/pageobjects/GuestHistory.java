package com.innroad.inncenter.pageobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IGuestHistory;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.Elements_GuestHistory;
import com.innroad.inncenter.webelements.Elements_Reservation;

public class GuestHistory implements IGuestHistory{
	
	public static String getAccountNo;
	public static Logger guestHistoryLogger = Logger.getLogger("GuestHistory");
	
	public void guestHistory(WebDriver driver) throws InterruptedException {
		Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
		Wait.wait3Second();
		guest_his.Guest_History.click();
		Wait.wait3Second();
		guestHistoryLogger.info(" System successfully Navigated to Guest History ");
		Wait.wait3Second();
	}
	
	public void guestHistory_NewAccount(WebDriver driver)throws InterruptedException {
		Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
		guest_his.newAccount.click();
		Wait.wait3Second();
		
	}
	
	public void guestHistory_AccountDetails(WebDriver driver, String salutation, String FirstName ){
		Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
		new Select(guest_his.selectAccountSalutation).selectByVisibleText(salutation);
		guest_his.accountFirstName.sendKeys(FirstName);
	//	String getAccountNumber= guest_his.accountNumber.getText();
	//	guestHistoryLogger.info(" Account Number is " +getAccountNumber);
		
	}
	
	public void accountAttributes(WebDriver driver, String MarketSegment, String Referral){
		Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
		//String getAccountSince= guest_his.accountSince.getText();
		//guestHistoryLogger.info(" Account Since " +getAccountSince);
		new Select(guest_his.Select_Market_Segment).selectByVisibleText(MarketSegment);
		new Select(guest_his.Select_Referrals).selectByVisibleText(Referral);
		
	}
	
	public void Mailinginfo(WebDriver driver, String AccountFirstName,
			String AccountLastName, String Phonenumber,
			String alternativeNumber, String Address1, String Address2,
			String Address3, String Email, String city, String State,
			String Postalcode) {
	
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		CreateAccount.Account_Enter_First_Name.sendKeys(AccountFirstName);
    	CreateAccount.Account_Enter_Last_Name.sendKeys(AccountLastName);
    	CreateAccount.Account_Phone_number.sendKeys(Phonenumber);
    	CreateAccount.Account_Enter_AltPhoneNumber.sendKeys(alternativeNumber);
    	
    	 JavascriptExecutor js1 = (JavascriptExecutor) driver;
         js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         
    	CreateAccount.Account_Enter_Line1.sendKeys(Address1);
    	CreateAccount.Account_Enter_Line2.sendKeys(Address2);
    	CreateAccount.Account_Enter_Line3.sendKeys(Address3);
    	CreateAccount.Account_Enter_Email.sendKeys(Email);
    	CreateAccount.Account_Enter_City.sendKeys(city);
    	new Select (CreateAccount.Select_Account_State).selectByVisibleText(State);
    	CreateAccount.Account_Enter_PostalCode.sendKeys(Postalcode);
		
	}

	
	public void Billinginfo(WebDriver driver) throws InterruptedException {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		Wait.wait5Second();
		if(CreateAccount.Account_Check_Mailing_info.isSelected())
		{
			guestHistoryLogger.info("Check box already checked");
		}
		else
		{
			
			CreateAccount.Account_Check_Mailing_info.click();
		}
		
	}

	
	public void Save(WebDriver driver) throws InterruptedException, IOException {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		CreateAccount.Account_save.click();
		Thread.sleep(5000);
		
		
		
		if(CreateAccount.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle_ReservationSucess=CreateAccount.Toaster_Title.getText();
		String getToastermessage_ReservationSucess=CreateAccount.Toaster_Message.getText();
		Assert.assertEquals(getTotasterTitle_ReservationSucess, "Account Saved");
		Thread.sleep(3000);
		String getAccountName=CreateAccount.AccountName.getText();
		guestHistoryLogger.info( " Account Name of created guest is  " +getAccountName );
		Thread.sleep(3000);
		
		String getAccountNo=CreateAccount.AccountNo.getText();
		guestHistoryLogger.info( " Account Number of created guest is  " +getAccountNo );
		FileOutputStream fos=new FileOutputStream(".\\guestHistoryAccountNo.txt");
		byte b[]=getAccountNo.getBytes();
		fos.write(b);
		fos.close();
		Wait.wait5Second();
		
		
	//	if(getToastermessage_ReservationSucess.equals("The account Test Account has been successfully created."));
		}
	}
	
	
	public void newReservation(WebDriver driver) throws InterruptedException {
		Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
		guest_his.newReservationButton.click();
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
		Wait.wait15Second();
	}
	
	/*public void roomAssignment(WebDriver driver,String PropertyName, String Nights, String Adults,
			String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName,
			String RoomNumber) throws InterruptedException {
		
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_RoomPicker.click();
		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		Wait.wait3Second();
		try
		{
		new Select(ReservationPage.Select_property_RoomAssign).selectByVisibleText(PropertyName);
		}
		catch(Exception e)
		{
			new Select(ReservationPage.Select_property_RoomAssign2).selectByVisibleText(PropertyName);
		}
		Wait.wait15Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		ReservationPage.Click_Today.click();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		ReservationPage.Enter_Adults.sendKeys(Adults);
		ReservationPage.Enter_Children.sendKeys(Children);
		ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);
		
		if(ReservationPage.Check_Assign_Room.isSelected())
		{
//			ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
		}
		else
		{
			if(CheckorUncheckAssign.equals("Yes"))
			{
				ReservationPage.Check_Assign_Room.click();
				ReservationPage.Click_Search.click();
			}
			else
			{
				ReservationPage.Click_Search.click();
			}
		}
		try
		{
		
		new Select(ReservationPage.Select_Room_Class).selectByVisibleText(RoomClassName);
		String selectedOption = new Select(ReservationPage.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
        guestHistoryLogger.info("selectedOption  " +selectedOption);
		if(selectedOption.equals("--Select--"))
		{
		//new Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
			new Select(ReservationPage.Select_Room_Number).selectByIndex(1);
			Wait.wait5Second();
		}
		else
		{
			  guestHistoryLogger.info("Reservation is unassigned");
		}
		}
		catch(Exception e)
		{
			Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
			guestHistoryLogger.info("Room Class are not Available for these dates");
			
		}
		ReservationPage.Click_Select.click();
		try
		{
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		}
		catch(Exception e)
		{
			guestHistoryLogger.info("Verification failed");
		}
		Wait.wait5Second();
		if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
		{
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
		}
		else
		{
			guestHistoryLogger.info("Satisfied Rules");
		}
		
		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle=ReservationPage.Toaster_Title.getText();
		String getToastermessage=ReservationPage.Toaster_Message.getText();
		guestHistoryLogger.info(getTotasterTitle + " " +getToastermessage);
		Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
		Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}
		Wait.wait2Second();
		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status=ReservationPage.Get_RoomClass_Status.getText();
		guestHistoryLogger.info(getRoomclassName_status);
		Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[]= getRoomclassName_status.split(" ");
		//Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if(CheckorUncheckAssign.equals("Yes"))
		{
		
		}
		else
		{
			Assert.assertEquals(getRoomclassName[3],"Unassigned" );
		}
		
		
		}
	*/
	
	
		public void guestHistoryAccountNo(WebDriver driver) throws InterruptedException, IOException{
			Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
			getAccountNo=guest_his.guestHistoryAccountNo.getText();
			guestHistoryLogger.info("Guest History Account Number is :" +getAccountNo);
			FileOutputStream fos=new FileOutputStream(".\\guestHistoryAccountNo.txt");
			byte b[]=getAccountNo.getBytes();
			fos.write(b);
			fos.close();
			Wait.wait5Second();
			
		}
	
		public void closeGuestHistoryReservation(WebDriver driver) throws InterruptedException {
			Elements_GuestHistory guest_his_res= new Elements_GuestHistory(driver);
		guest_his_res.closeGuestHistoryRes.click();
		Wait.wait10Second();
		
		}
	
	
		
		public void closeAccount(WebDriver driver) throws InterruptedException{
			Elements_GuestHistory guest_his= new Elements_GuestHistory(driver);
			guest_his.closeReservation.click();
			Wait.wait5Second();
		
		}
		public void searchAccount(WebDriver driver, String AccountFname) throws InterruptedException {
			Elements_GuestHistory guest_his=new Elements_GuestHistory(driver);
			guest_his.enterAccountFName.sendKeys(AccountFname);
			Wait.wait10Second();
			
			try
			{
			//guestHistoryLogger.info("GuestHistoryAccountNumber :"+getGuestHistoryAccountNumber);
			FileReader fr= new FileReader(".\\guestHistoryAccountNo.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while((getAccountNo=br.readLine())!=null)
			{
				guestHistoryLogger.info(" Guest History Account Number :"+getAccountNo);
				
				Wait.wait10Second();
				guest_his.enterGuestHistoryAccountNo.sendKeys(getAccountNo);
			
			}
			br.close();
			}
			catch(IOException e)
			{
				guestHistoryLogger.info("File not found");
			}
			guest_his.clickSearchButton.click();
			//Wait.wait60Second();
			Wait.explicit_wait_xpath(OR.selectGuestHistoryAccount);		
		}
		
		public void deleteGuestHistoryAccount(WebDriver driver) throws InterruptedException{
			Elements_GuestHistory guest_his=new Elements_GuestHistory(driver);
			guest_his.selectGuestHistoryAccount.click();	
			guest_his.deleteButton.click();
			Wait.wait10Second();
		}
		}
