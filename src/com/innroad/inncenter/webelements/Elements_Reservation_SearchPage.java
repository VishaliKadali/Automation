package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_Reservation_SearchPage {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_Reservation_SearchPage(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}
		
		@FindBy(xpath=OR.BasicGuestName)
		public WebElement BasicGuestName;
		
		@FindBy(xpath=OR.Get_Guest_Name)
		public WebElement Get_Guest_Name;
		
		@FindBy(xpath=OR.Click_BasicSearch)
		public WebElement Click_BasicSearch;
		
		@FindBy(xpath=OR.Verify_Search_Loading_Gird)
		public WebElement Verify_Search_Loading_Gird;
		
		@FindBy(xpath=OR.Basic_Res_Number)
		public WebElement Basic_Res_Number;
		
		@FindBy(xpath=OR.Get_Res_Number)
		public WebElement Get_Res_Number;
		
		@FindBy(xpath=OR.Check_Reservation)
		public WebElement Check_Reservation;
		
		@FindBy(xpath=OR.Click_Bulk_Action)
		public WebElement Click_Bulk_Action;
		
	
		
		@FindBy(xpath=OR.Select_Checkin)
		public WebElement Select_Checkin;
		
		@FindBy(xpath=OR.Verify_Bulk_Checkin_popup)
		public WebElement Verify_Bulk_Checkin_popup;
		
		@FindBy(xpath=OR.Click_Process_Button)
		public WebElement Click_Process_Button;
		
		@FindBy(xpath=OR.click_on_Close_icon)
		public WebElement click_on_Close_icon;
		
		@FindBy(xpath=OR.Verify_Guest_Name)
		public WebElement Verify_Guest_Name;
		
		@FindBy(xpath=OR.Verify_Bulk_Checkin_Success)
		public WebElement Verify_Bulk_Checkin_Success;
		
		@FindBy(xpath=OR.Get_Reservation_Status)
		public WebElement Get_Reservation_Status;
		
		@FindBy(xpath=OR.Select_Checkout)
		public WebElement Select_Checkout;
		
		@FindBy(xpath=OR.Verify_Bulk_Checkout_popup)
		public WebElement Verify_Bulk_Checkout_popup;
		
		@FindBy(xpath=OR.Verify_Bulk_Checkout_Completed)
		public WebElement Verify_Bulk_Checkout_Completed;
		
		@FindBy(xpath=OR.Click_On_First_SearchResult)
		public WebElement Click_On_First_SearchResult;
	
		@FindBy(xpath=OR.Select_Delete)
		public WebElement Select_Delete;
		
		@FindBy(xpath=OR.Verify_Bulk_Delete_popup)
		public WebElement Verify_Bulk_Delete_popup;
		
		@FindBy(xpath=OR.Verify_Bulk_Delete_Completed)
		public WebElement Verify_Bulk_Delete_Completed;
		
		@FindBy(xpath=OR.Check_First_SearchResult)
		public WebElement Check_First_SearchResult;
		
		@FindBy(xpath=OR.Verify_Res_Number)
		public WebElement Verify_Res_Number;
		
		@FindBy(xpath=OR.Search_Results_Alert_Msg)
		public WebElement Search_Results_Alert_Msg;
		
		@FindBy(xpath=OR.AddIncidental)
		public WebElement AddIncidental;
		
		@FindBy(xpath=OR.IncidentalCategory)
		public WebElement IncidentalCategory;
		
		@FindBy(xpath=OR.IncidentalAmount)
		public WebElement IncidentalAmount;
		
		@FindBy(xpath=OR.Commit)
		public WebElement Commit;
		
		
		//Bulk Cancellation
<<<<<<< HEAD
		
		@FindBy(xpath=OR.selectAllArrivals)
		public WebElement selectAllArrivals;
=======
>>>>>>> feature/AUTOMATION-90
		
		@FindBy(xpath=OR.selectAllArrivals)
		public WebElement selectAllArrivals;
	
		@FindBy(xpath=OR.unassignedReservations)
		public WebElement unassignedReservations;
					
		@FindBy(xpath=OR.clickReservation)
		public WebElement clickReservation;
					
		@FindBy(xpath=OR.click_Folio_tab)
		public WebElement click_Folio_tab;
		
		@FindBy(xpath=OR.clickVoidButton)
		public WebElement clickVoidButton;
		
		@FindBy(xpath=OR.clickRollBackButton)
		public WebElement clickRollBackButton;
		
		@FindBy(xpath=OR.roomAssignmentpopUpSelectButton)
		public WebElement roomAssignmentpopUpSelectButton;
					
		@FindBy(xpath=OR.folioCancelReservation)
		public WebElement folioCancelReservation;
					
		@FindBy(xpath=OR.getBalanceFolioLineItems)
		public WebElement getBalanceFolioLineItems;
					
		@FindBy(xpath=OR.Click_Pay_Button)
		public WebElement Click_Pay_Button;
					
		@FindBy(xpath=OR.Payment_Details_Folio_Balance)
		public WebElement Payment_Details_Folio_Balance;
					
		@FindBy(xpath=OR.Verify_Payment_Details_poup)
		public WebElement Verify_Payment_Details_poup;
					
		@FindBy(xpath=OR.Select_Paymnet_Method)
		public WebElement Select_Paymnet_Method;
					
		@FindBy(xpath=OR.payment_AddButton)
		public WebElement payment_AddButton;
					
		@FindBy(xpath=OR.payment_ContinueButton)
		public WebElement payment_ContinueButton;
					
		@FindBy(xpath=OR.folioSaveButton)
		public WebElement folioSaveButton;
					
		@FindBy(xpath=OR.closeReservation)
		public WebElement closeReservation;
					
		@FindBy(xpath=OR.enterAdvResNumber)
		public WebElement enterAdvResNumber;
		
		@FindBy(xpath=OR.enterResNumber)
		public WebElement enterResNumber;
		
					
		@FindBy(xpath=OR.resNumber)
		public WebElement resNumber;
					
		@FindBy(xpath=OR.selectCancel)
		public WebElement selectCancel;	
		
		@FindBy(xpath=OR.enterCancellationReason)
		public WebElement enterCancellationReason;	
		
		@FindBy(xpath=OR.voidRoomChargesCheckBox)
		public WebElement voidRoomChargesCheckBox;
		
		@FindBy(xpath=OR.processButton)
		public WebElement processButton;
					
		@FindBy(xpath=OR.closeAdvancedSearch)
		public WebElement closeAdvancedSearch;
					
		@FindBy(xpath=OR.advanced)
		public WebElement advanced;
					
		@FindBy(xpath=OR.advancedSearchStatus)
		public WebElement advancedSearchStatus;
		
		@FindBy(xpath=OR.advancedSearchReservedStatus)
		public WebElement advancedSearchReservedStatus;
					
		@FindBy(xpath=OR.reservedStatus)
		public WebElement reservedStatus;		
		
		@FindBy(xpath=OR.reservedTocancelledStatus)
		public WebElement reservedTocancelledStatus;
		
		@FindBy(xpath=OR.searchButton)
		public WebElement searchButton;
		
		@FindBy(xpath=OR.basicSearchIcon)
		public WebElement basicSearchIcon;
					
		@FindBy(xpath=OR.selectReservation)
		public WebElement selectReservation;
			
		@FindBy(xpath=OR.bulkCancelpopup)
		public WebElement bulkCancelpopup;
		
		@FindBy(xpath=OR.bulkCancellationMessage)
		public WebElement bulkCancellationMessage;
		
		@FindBy(xpath=OR.bulkNoShowMessage)
		public WebElement bulkNoShowMessage;
		
		@FindBy(xpath=OR.bulkPopupClose)
		public WebElement bulkPopupClose;
		
		@FindBy(xpath=OR.cancelledReservation)
		public WebElement cancelledReservation;
		
		@FindBy(xpath=OR.basicSearchNoShowReservation)
		public WebElement basicSearchNoShowReservation;
		
		@FindBy(xpath=OR.basicSearchcancelledReservation)
		public WebElement basicSearchcancelledReservation;
		
		@FindBy(xpath=OR.Toaster_Title)
		public WebElement Toaster_Title;
		
		//Bulk No Show
		@FindBy(xpath=OR.selectNoShow)
		public WebElement selectNoShow;
		
		@FindBy(xpath=OR.bulkNoShowpopup)
		public WebElement bulkNoShowpopup;
		
		//SummaryTab
		
		@FindBy(xpath=OR.clickSummaryTab)
		public WebElement clickSummaryTab;
		
		@FindBy(xpath=OR.clickGuestInfoTab)
		public WebElement clickGuestInfoTab;
		
		@FindBy(xpath=OR.notesDelete)
		public WebElement notesDelete;
		
		
}
