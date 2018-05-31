package com.innroad.inncenter.webelements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;
public class Elements_FolioLineItemsVoid {

	

	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_FolioLineItemsVoid(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);		 
		}
		
		@FindBy(xpath=OR.ReservationIcon)
		public WebElement ReservationIcon;
		
		@FindBy(xpath=OR.Reservationlink)
		public WebElement Reservationlink;
		
		@FindBy(xpath=OR.NewReservationButton)
		public WebElement NewReservationButton;
		
		@FindBy(xpath=OR.New_Reservation_Button)
		public WebElement New_Reservation_Button;
		
		@FindBy(xpath=OR.Reservation_market_Segment)
		public WebElement Reservation_market_Segment;
		
		@FindBy(xpath=OR.Enter_Travel_Agent)
		public WebElement Enter_Travel_Agent;
		
		@FindBy(xpath=OR.Enter_Ext_Reservation)
		public WebElement Enter_Ext_Reservation;
		
		@FindBy(xpath=OR.Reservation_Referral)
		public WebElement Reservation_Referral;
		
		@FindBy(xpath=OR.Select_Saluation)
		public WebElement Select_Saluation;
		
		@FindBy(id=OR.UnCheckGuestProfile)
		public WebElement UnCheckGuestProfile;
		
		@FindBy(id=OR.GuestFirstName)
		public WebElement GuestFirstName;
		
		@FindBy(id=OR.GuestLastName)
		public WebElement GuestLastName;
		
		@FindBy(xpath=OR.Enter_City)
		public WebElement Enter_City;
		
		@FindBy(xpath=OR.Select_Payment_Method)
		public WebElement Select_Payment_Method;
		
		@FindBy(xpath=OR.Select_Country)
		public WebElement Select_Country;
		
		@FindBy(xpath=OR.Select_State)
		public WebElement Select_State;
		
		@FindBy(xpath=OR.Enter_Postal_Code)
		public WebElement Enter_Postal_Code;
		
		@FindBy(xpath=OR.Enter_Phone_Number)
		public WebElement Enter_Phone_Number;
		
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
		
		@FindBy(xpath=OR.Enter_Account_Number)
		public WebElement Enter_Account_Number;
		
		@FindBy(xpath=OR.Enter_Exp_Card)
		public WebElement Enter_Exp_Card;
		
		@FindBy(xpath=OR.Enter_Billing_Note)
		public WebElement Enter_Billing_Note;
		
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
		
		@FindBy(xpath=OR.Select_Room_Class)
		public WebElement Select_Room_Class;
		
		@FindBy(xpath=OR.Validating_UnAssgined_DDL)
		public WebElement Validating_UnAssgined_DDL;
		
		@FindBy(xpath=OR.Select_Room_Number)
		public WebElement Select_Room_Number;
		
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

		@FindBy(xpath=OR.click_Folio_tab)
		public WebElement click_Folio_tab;

		@FindBy(xpath=OR.click_Add_Button)
		public WebElement click_Add_Button;
		
		@FindBy(xpath=OR.selectCategory)
		public WebElement selectCategory;

		@FindBy(xpath=OR.enterAmount)
		public WebElement enterAmount;
		
		@FindBy(xpath=OR.clickSaveButton)
		public WebElement clickSaveButton;
		
		@FindBy(xpath=OR.clickOkForPopup)
		public WebElement clickOkForPopup;
		
		@FindBy(xpath=OR.closeReservation)
		public WebElement closeReservation;

		@FindBy(xpath=OR.clickCommitButton)
		public WebElement clickCommitButton;
		
		@FindBy(xpath=OR.selectAllLineItems)
		public WebElement selectAllLineItems;
		
		@FindBy(xpath=OR.clickVoidButton)
		public WebElement clickVoidButton;
		
		@FindBy(xpath=OR.enterNotes)
		public WebElement enterNotes;
		
		@FindBy(xpath=OR.clickVoidButtonInNotes)
		public WebElement clickVoidButtonInNotes;
		
		@FindBy(xpath=OR.DisplayVoidItemsCheckBox)
		public WebElement DisplayVoidItemsCheckBox;

		@FindBy(xpath=OR.getBalanceFolioLineItems)
		public WebElement getBalanceFolioLineItems;

		//************************Add/Post Folio Line Items*************************//
		
		@FindBy(xpath=OR.reservationGuestName)
		public WebElement reservationGuestName;
		
		@FindBy(xpath=OR.reservationGuestName2)
		public WebElement reservationGuestName2;
		
		@FindBy(xpath=OR.verifyCheckboxPendingStatus)
		public WebElement verifyCheckboxPendingStatus;
		
		@FindBy(xpath=OR.lineItemPendingStatus)
		public WebElement lineItemPendingStatus;
		
		@FindBy(xpath=OR.verifyCheckboxPostStatus)
		public WebElement verifyCheckboxPostStatus;
		
		@FindBy(xpath=OR.lineItemPostStatus)
		public WebElement lineItemPostStatus;
		
		@FindBy(xpath=OR.pendingItemDescription)
		public WebElement pendingItemDescription;
		
		@FindBy(xpath=OR.selectCategoryItem)
		public WebElement selectCategoryItem;
		
		@FindBy(xpath=OR.itemDescription)
		public WebElement itemDescription;
		
		@FindBy(xpath=OR.foliolineItemAmount)
		public WebElement foliolineItemAmount;
		
		@FindBy(xpath=OR.foliolineItemNotes)
		public WebElement foliolineItemNotes;
		
		@FindBy(xpath=OR.foliolineItemAddButton)
		public WebElement foliolineItemAddButton;
		
		@FindBy(xpath=OR.foliolineItemContinueButton)
		public WebElement foliolineItemContinueButton;
		
		@FindBy(xpath=OR.clickOnDescription)
		public WebElement clickOnDescription;
		
		@FindBy(xpath=OR.clickRollBackButtonInPopUp)
		public WebElement clickRollBackButtonInPopUp;

		@FindBy(xpath=OR.clickContinueButton)
		public WebElement clickContinueButton;
		
		@FindBy(xpath=OR.folioSaveButton)
		public WebElement folioSaveButton;
		
		@FindBy(css=OR.SelectCategory)
		public WebElement SelectCategory;
		
		@FindBy(css=OR.LineItemsFields)
		public List<WebElement> LineItemsAmountFields;
		
		@FindBy(xpath=OR.CommitButton)
		public List<WebElement> CommitButton;
		
		@FindBy(css=OR.LineItems)
		public List<WebElement> LineItems;
		
		@FindBy(xpath=OR.RoomCharger_Tax)
		public List<WebElement> RoomCharger_Tax;
		
		
}

	
