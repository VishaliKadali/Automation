package com.innroad.inncenter.WebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class Elements_Reservation {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_Reservation(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}
		
		
		@FindBy(xpath=OR.New_Reservation_Button)
		public WebElement New_Reservation_Button;
		
		@FindBy(xpath=OR.Reservation_market_Segment)
		public WebElement Reservation_market_Segment;
		
		@FindBy(xpath=OR.Reservation_Referral)
		public WebElement Reservation_Referral;
		
		@FindBy(xpath=OR.Enter_Travel_Agent)
		public WebElement Enter_Travel_Agent;
		
		@FindBy(xpath=OR.Enter_Ext_Reservation)
		public WebElement Enter_Ext_Reservation;
		
		@FindBy(xpath=OR.Enter_Guest_Profile)
		public WebElement Enter_Guest_Profile;
		
		@FindBy(xpath=OR.Select_Saluation)
		public WebElement Select_Saluation;
		
		@FindBy(xpath=OR.Enter_First_Name)
		public WebElement Enter_First_Name;
		
		@FindBy(xpath=OR.Enter_Last_Name)
		public WebElement Enter_Last_Name;
		
		@FindBy(xpath=OR.Enter_Address_Search)
		public WebElement Enter_Address_Search;
		
		@FindBy(xpath=OR.Enter_Line1)
		public WebElement Enter_Line1;
		
		@FindBy(xpath=OR.Enter_Line2)
		public WebElement Enter_Line2;
		
		@FindBy(xpath=OR.Enter_Line3)
		public WebElement Enter_Line3;
		
		@FindBy(xpath=OR.Enter_City)
		public WebElement Enter_City;
		
		@FindBy(xpath=OR.Select_Country)
		public WebElement Select_Country;
		
		@FindBy(xpath=OR.Select_State)
		public WebElement Select_State;
		
		@FindBy(xpath=OR.Enter_Postal_Code)
		public WebElement Enter_Postal_Code;
		
		@FindBy(xpath=OR.Enter_Phone_Number)
		public WebElement Enter_Phone_Number;
		
		@FindBy(xpath=OR.Enter_Alt_Phn_number)
		public WebElement Enter_Alt_Phn_number;
		
		@FindBy(xpath=OR.Enter_email)
		public WebElement Enter_email;
		
		@FindBy(xpath=OR.Enter_Account)
		public WebElement Enter_Account;
		
		@FindBy(xpath=OR.Check_IsTaxExempt)
		public WebElement Check_IsTaxExempt;
		
		@FindBy(xpath=OR.Enter_TaxExemptId)
		public WebElement Enter_TaxExemptId;
		
		@FindBy(xpath=OR.Check_isLongstay)
		public WebElement Check_isLongstay;
		
		@FindBy(xpath=OR.Select_Payment_Method)
		public WebElement Select_Payment_Method;
		
		@FindBy(xpath=OR.Enter_Account_Number)
		public WebElement Enter_Account_Number;
		
		@FindBy(xpath=OR.Enter_Exp_Card)
		public WebElement Enter_Exp_Card;
		
		@FindBy(xpath=OR.Enter_Billing_Note)
		public WebElement Enter_Billing_Note;
		
		@FindBy(xpath=OR.Add_Note_Reservation)
		public WebElement Add_Note_Reservation;
		
		@FindBy(xpath=OR.Click_RoomPicker)
		public WebElement Click_RoomPicker;
		
		@FindBy(xpath=OR.Click_Arrive_Datepicker)
		public WebElement Click_Arrive_Datepicker;
		
		@FindBy(xpath=OR.Click_Today)
		public WebElement Click_Today;
		
		@FindBy(xpath=OR.Enter_Nigts)
		public WebElement Enter_Nigts;
		
		@FindBy(xpath=OR.Enter_Adults)
		public WebElement Enter_Adults;
		
		@FindBy(xpath=OR.Enter_Children)
		public WebElement Enter_Children;
		
		@FindBy(xpath=OR.Enter_Rate_Promocode)
		public WebElement Enter_Rate_Promocode;
		
		@FindBy(xpath=OR.Check_Assign_Room)
		public WebElement Check_Assign_Room;
		
		@FindBy(xpath=OR.Click_Search)
		public WebElement Click_Search;
		
		@FindBy(xpath=OR.Select_property_RoomAssign)
		public WebElement Select_property_RoomAssign;
		
		@FindBy(xpath=OR.Select_Room_Class)
		public WebElement Select_Room_Class;
		
		@FindBy(xpath=OR.Select_Room_Number)
		public WebElement Select_Room_Number;
		
		@FindBy(xpath=OR.Validating_UnAssgined_DDL)
		public WebElement Validating_UnAssgined_DDL;
		
		@FindBy(xpath=OR.Click_Select)
		public WebElement Click_Select;
		
		@FindBy(xpath=OR.Verify_RulesBroken_Popup)
		public WebElement Verify_RulesBroken_Popup;
		
		@FindBy(xpath=OR.Click_Continue_RuleBroken_Popup)
		public WebElement Click_Continue_RuleBroken_Popup;
		
		@FindBy(xpath=OR.Verify_Toaster_Container)
		public WebElement Verify_Toaster_Container;
		
		@FindBy(xpath=OR.Toaster_Title)
		public WebElement Toaster_Title;
		
		@FindBy(xpath=OR.Toaster_Message)
		public WebElement Toaster_Message;
		
		@FindBy(xpath=OR.Get_Property_Name)
		public WebElement Get_Property_Name;
		
		@FindBy(xpath=OR.Get_RoomClass_Status)
		public WebElement Get_RoomClass_Status;
		
		@FindBy(xpath=OR.Click_Save_ReservationDetails)
		public WebElement Click_Save_ReservationDetails;
		
		@FindBy(xpath=OR.Verify_Depos_policy)
		public WebElement Verify_Depos_policy;
		
		@FindBy(xpath=OR.Click_Without_Deposit)
		public WebElement Click_Without_Deposit;
		
		@FindBy(xpath=OR.Click_Email_icon)
		public WebElement Click_Email_icon;
		
		@FindBy(xpath=OR.Select_Attachment)
		public WebElement Select_Attachment;
		
		@FindBy(xpath=OR.Get_email_Id)
		public WebElement Get_email_Id;
		
		@FindBy(xpath=OR.Click_Send_Email)
		public WebElement Click_Send_Email;
		
		
		//Folio 
		
		
		@FindBy(xpath=OR.Click_Pay_Button)
		public WebElement Click_Pay_Button;
		
		@FindBy(xpath=OR.Verify_Payment_Details_poup)
		public WebElement Verify_Payment_Details_poup;
		
		@FindBy(xpath=OR.Select_Paymnet_Method)
		public WebElement Select_Paymnet_Method;
		
		@FindBy(xpath=OR.Click_ADD_Button)
		public WebElement Click_ADD_Button;
		
		@FindBy(xpath=OR.Verify_Guest_Ledger)
		public WebElement Verify_Guest_Ledger;
		
		@FindBy(xpath=OR.Get_Payment_Method)
		public WebElement Get_Payment_Method;
		
		@FindBy(xpath=OR.Click_Continue)
		public WebElement Click_Continue;
		
		@FindBy(xpath=OR.Verify_Line_item)
		public WebElement Verify_Line_item;
		
		@FindBy(xpath=OR.Click_Card_info)
		public WebElement Click_Card_info;
		
		@FindBy(xpath=OR.Verify_payment_info_popup)
		public WebElement Verify_payment_info_popup;
		
		@FindBy(xpath=OR.Enter_Card_Name)
		public WebElement Enter_Card_Name;
		

		@FindBy(xpath=OR.Enter_Account_Number_Folio)
		public WebElement Enter_Account_Number_Folio;
		
		@FindBy(xpath=OR.Enter_CC_Expiry)
		public WebElement Enter_CC_Expiry;
		
		@FindBy(xpath=OR.Enter_CVVCode)
		public WebElement Enter_CVVCode;
		
		
		@FindBy(xpath=OR.Click_OK)
		public WebElement Click_OK;
		
		@FindBy(xpath=OR.Click_Process)
		public WebElement Click_Process;
		
		@FindBy(xpath=OR.GetMC_Payment_Method)
		public WebElement GetMC_Payment_Method;
		
		@FindBy(xpath=OR.GetAddedLine_MC)
		public WebElement GetAddedLine_MC;
		
		@FindBy(xpath=OR.Verify_MC_Grid)
		public WebElement Verify_MC_Grid;
		
		@FindBy(xpath=OR.Verify_Balance_Zero)
		public WebElement Verify_Balance_Zero;
		
		@FindBy(xpath=OR.Select_Authorization_type)
		public WebElement Select_Authorization_type;
		
		@FindBy(xpath=OR.Change_Amount)
		public WebElement Change_Amount;
		
		
		
		//checkin
		
		@FindBy(xpath=OR.Click_Checkin)
		public WebElement Click_Checkin;
		
		@FindBy(xpath=OR.Verify_Dirty_Room_popup)
		public WebElement Verify_Dirty_Room_popup;
		
		@FindBy(xpath=OR.Confirm_button)
		public WebElement Confirm_button;
		
		@FindBy(xpath=OR.Click_on_confirm)
		public WebElement Click_on_confirm;
		
		@FindBy(xpath=OR.Payment_Popup)
		public WebElement Payment_Popup;
		
		@FindBy(xpath=OR.Key_Generation_Popup)
		public WebElement Key_Generation_Popup;
		
		@FindBy(xpath=OR.Key_Generation_Close)
		public WebElement Key_Generation_Close;
		

		@FindBy(xpath=OR.Click_Checkout)
		public WebElement Click_Checkout;
		

		@FindBy(xpath=OR.Click_Close)
		public WebElement Click_Close;
		
		@FindBy(xpath=OR.Click_Swipe_Icon)
		public WebElement Click_Swipe_Icon;
		
		@FindBy(xpath=OR.Enter_Track_Data)
		public WebElement Enter_Track_Data;
		
		
		//Notes
		
		@FindBy(xpath=OR.Click_Add_Res_Note)
		public WebElement Click_Add_Res_Note;
		
		@FindBy(xpath=OR.verify_Add_Notes_popup)
		public WebElement verify_Add_Notes_popup;
		
		@FindBy(xpath=OR.Enter_Subject_Notes)
		public WebElement Enter_Subject_Notes;
		
		@FindBy(xpath=OR.Select_Note_Type)
		public WebElement Select_Note_Type;
		
		@FindBy(xpath=OR.Check_Action_Required)
		public WebElement Check_Action_Required;
		
		@FindBy(xpath=OR.Select_Notes_Status)
		public WebElement Select_Notes_Status;
		
		@FindBy(xpath=OR.Enter_Note_Details)
		public WebElement Enter_Note_Details;
		
		@FindBy(xpath=OR.Click_Save_Note)
		public WebElement Click_Save_Note;
		
		@FindBy(xpath=OR.Verify_Added_Notes)
		public WebElement Verify_Added_Notes;
		
		@FindBy(xpath=OR.Get_Confirmation_Number)
		public WebElement Get_Confirmation_Number;
		
		@FindBy(xpath=OR.Select_property_RoomAssign2)
		public WebElement Select_property_RoomAssign2;
		
		@FindBy(xpath=OR.Enter_Account_Res_Name)
		public WebElement Enter_Account_Res_Name;
		
		@FindBy(xpath=OR.Click_Search_House_Acc)
		public WebElement Click_Search_House_Acc;
		
		@FindBy(xpath=OR.Select_House_Acc)
		public WebElement Select_House_Acc;
		
		@FindBy(xpath=OR.Click_Select_House_acc)
		public WebElement Click_Select_House_acc;
		
		@FindBy(xpath=OR.Enter_Gift_ID)
		public WebElement Enter_Gift_ID;
		
		@FindBy(xpath=OR.Click_Go_Gift)
		public WebElement Click_Go_Gift;
		
		@FindBy(xpath=OR.Select_Gift_Certificate)
		public WebElement Select_Gift_Certificate;
		
		@FindBy(xpath=OR.Click_Select_Gift)
		public WebElement Click_Select_Gift;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
