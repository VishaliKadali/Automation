package com.innroad.inncenter.properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;

public class OR {


	//Login Page
	public static final String clientCode ="txtclientCode";
	public static final String userID ="txtLoginID";
	public static final String password ="txtUserPassword";
	public static final String Login ="btnLogon";

	//Support Panel Page

	public static final String SearchIcon="ucNavShortcut_rptrMenu_btnMenuItem_0";
	public static final String ClickArrow = "//*[@id='s2id_ucPanelSupport_drpClientList']/a/span[2]/b";
	public static final String clientTextBox = "s2id_autogen1_search";

	//Select Property
	public static final String clickClientSelectorIcon="//div[@class='support_panel_client_selector_open']";
	public static final String clickPenIcon="//span[@id='select2-chosen-3']";
	public static final String enterClientName="//input[@id='s2id_autogen3_search']";

	//Reservation Page
	public static final String ReservationIcon="//*[@id='rptrMenu_btnMenuItem_0']";
	public static final String Reservationlink="rptrMenu_lbtnMenuItem_0"; 
	public static final String NewReservationButton="ucReservationControl1_btnNew"; 
	public static final String ClickonAssignRooms="StayInfo1_btnAssignRooms"; 
	public static final String UnCheckGuestProfile="chkCreateGuestProfile"; 
	public static final String GuestFirstName="txtGuestFirstName";
	public static final String GuestLastName="txtGuestLastName";
	public static final String Switchtoframe="dialog-body0";
	public static final String StartDate="//*[@id='pnlPickRoomFilter']/table/tbody/tr[3]/td[2]/table/tbody/tr/td/img";
	public static final String NumberofAdults="txtNumberOfAdults";
	public static final String SearchButton="btnAssignRooms";
	public static final String SelectRoomClass="dgRoomsList_drpRoomClass_0";
	public static final String Select="btnSelect";
	public static final String Save="btnSave";
	public static final String ClickonToday="//th[@class='today']";
	public static final String MarketSegment="drpMarketingSegment";
	public static final String ReferralDropDown="drpReferrals";
	public static final String SelectRoomClassRoomAssign="dgRoomsList_drpRoomClass_0";
	public static final String SelectRoomNumber="dgRoomsList_drpRooms_0";
	public static final String Guest_Info="//a[.='Guest Info']";
	public static final String Verify_Guest_Info="//strong[.='Reservation#: ']";
	public static final String Early_CheckOut="//*[@id='StayInfo']//p[contains(text(),'Checked out')]";
	public static final String Reservation_Status_Dropdown="//*[@id='StayInfo']//select";
	public static final String getReservationStatus="//select[contains(@data-bind,'enable: drpReservationStatusEnabled')]";

	//Lock Unlock Reservation

	public static final String advancedSearch="//button[contains(text(),'Advanced')]";		
	public static final String searchButton="(//button[.='Search'])[1]";
	public static final String getInHouseReservations="//span[contains(text(),'In House')]/ ../span[contains(@data-bind,'text: valueText')]";
	//"//span[contains(text(),'In House')]/ ../span[@class='ng-statsValue']";
	//"//span[contains(text(),'In House')]/ ../span[1]";
	public static final String getAllArrivalsReservations="//span[contains(text(),'All Arrivals')]/ ../span[1]";
	public static final String inHouseReservation="//li[@class='in-house active predefinedQueryOption']/div[1]/span[2]";
	public static final String allArrivalsReservation="//li[@class='in-house active predefinedQueryOption']/div[1]/span[2]"; 

	public static final String openReservation="(//a[contains(@data-bind,'text: GuestName')])[1]";
	public static final String lock="//button[contains(@data-bind,' visible: !DoNotMove()')]";
	public static final String unlock="//button[contains(@data-bind,' visible: DoNotMove()')]";
	public static final String getAlertMessage="//div[contains(@data-bind,' visible: ShowError')]";
	public static final String clickCancel="(//button[contains(@data-bind,'click: CancelClick')])[5]";

	//Copy Reservation
	public static final String click_SearchReservation_Button="//div[@id='ReservationSearch']//following-sibling::button[@value='Search']";
	public static final String click_Reservation_GuestName="(//a[@title='RateQuote Guest'])[1]";
	public static final String click_Copy_Button="//button[@data-bind='enable: EnableCopyButton(), click: CopyReservation']";
	public static final String close_Copied_Reservation="(//i[@data-bind='click: $parent.closeTab, clickBubble: false, visible: !IsDefaultMenuOption'])[7]";
	public static final String get_Copied_Guest_Name="(//span[contains(@data-bind,'text: GuestNameUI')])[6]";
	public static final String get_Searched_GuestName="(//a[contains(@data-bind,'text: GuestName')])[1]";
	public static final String click_RoomPicker="//button[contains(@data-bind,'enable: EnableRoomPicker()')]";
	public static final String check_AssignRoom_ChecBox="//input[contains(@data-bind,'enable: AssignRoomsEnabled')]";
	public static final String click_Search_Button="//button[contains(@data-bind,'click: SearchBtnClick')]";
	public static final String get_Room_Number="//select[contains(@data-bind,'enable: IsRoomNumberEnabled')]";
	public static final String click_Select_Button_RoomAssignment=".//*[@id='divPickRoomGrid']//select[contains(@data-bind,'enable: IsRoomNumberEnabled')]";
	public static final String click_Select_Button_RoomChargesChanged="(//button[contains(@data-bind,'click: SelectClick')])[3]";
	public static final String click_Save_button_ReservationCopy="(.//*[@id='bpjscontainer_21']//button[contains(@data-bind,'click: PreSave')])[2]";
	public static final String getUnassignedRoomNumber="//select[contains(@data-bind,'options: Rooms')]";
	public static final String click_cancel_button=".//*[@id='modalRoomPickerReservation']//button[contains(@data-bind,'click: CancelClick')]";
	public static final String click_copiedRoomPicker="(//button[contains(@data-bind,'click: showRoomPicker')])[2]";
	public static final String get_copiedRoom_Number="//select[contains(@data-bind,'options: Rooms')]";
	public static final String click_room_picker_afterCopy=".//*[@id='StayInfo']//button[contains(@data-bind,'click: showRoomPicker')]";
	public static final String get_copied_unassignedRoomNo=".//*[@id='divPickRoomGrid']//select[contains(@data-bind,'enable: IsRoomNumberEnabled')]";
	public static final String click_Select_Button_UnassignedRoomAssignment=".//*[@id='modalRoomPickerReservation']//button[contains(@data-bind,'click: SelectClick')]";
	public static final String click_room_picker_afterCopyUnassignedRoom="(.//*[@id='StayInfo']//button[contains(@data-bind,'click: showRoomPicker')])[2]";
	public static final String click_cancel_unassigned_room=".//*[@id='modalRoomPickerReservation']//button[contains(@data-bind,'click: CancelClick')]";
	public static final String getunassignedRoomNumberCopy=".//*[@id='divPickRoomGrid']/div[2]//select[contains(@data-bind,'options: Rooms')]";

	//Header_Panel_Elements

	public static final String Inventory_Icon="rptrMenu_btnMenuItem_3";

	//Season

	public static final String New_Seasons="rptrMenu_lbtnAltMenuItem_1";
	public static final String Select_Property_in_Seasons="//select[starts-with(@data-bind,'options: PropertiesList')]";
	public static final String New_Season_Button="//div[@class='footer_buttons']/button[1]";
	public static final String EG_Select_Property_in_Seasons="drpPropertyList";
	public static final String EG_New_Seasons_Button="btnNew";

	public static final String NG_Season_Name="//input[@placeholder='Season Name']";
	public static final String NG_Season_start_Date ="//input[@placeholder='Start Date']";
	public static final String NG_Season_End_Date ="//input[@placeholder='End Date']";
	public static final String NG_Season_Save="//button[contains(@data-bind, 'saveSeasonDetail')]";

	public static final String EG_Season_Name ="txtSeasonName";
	public static final String EG_start_Picker="//*[@id='ContentArea']/tbody/tr/td[2]/table[2]/tbody/tr[6]/td[2]/a";
	public static final String EG_Season_start_Date="//td[@class='day today']";
	public static final String EG_End_picker="//*[@id='ContentArea']/tbody/tr/td[2]/table[2]/tbody/tr[7]/td[2]/a/img";
	public static final String EG_Season_End_Date="txtDateEnd";
	public static final String EG_Season_Save="btnSave";

	//Select Dates BE

	public static final String BE_Page_Title="//div[@class='booking_pages_heading']";
	public static final String BE_My_Dates_are_flexible="//span[@data-bind='    text: MyDatesAreFlexible, visible: smallCalendarWidget']";
	public static final String GetCheckintext="//*[@id='divNonGroup']/div/div[6]/div[1]/div[7]/div[2]/span[2]/span";
	public static final String GetCheckouttext="//*[@id='divNonGroup']/div/div[6]/div[1]/div[7]/div[3]/span[2]/span";
	public static final String Get_NumberofAdults ="AvailabilitySearch1_txtAdults";
	public static final String AvailabilitySearch1_btnAvailabilitySearch ="AvailabilitySearch1_btnAvailabilitySearch";
	public static final String AvailabilitySearch1_lbkChkInDate="AvailabilitySearch1_lbkChkInDate";
	public static final String AvailabilitySearch1_lblChkInDayOfTheWeek = "AvailabilitySearch1_lblChkInDayOfTheWeek";
	public static final String AvailabilitySearch1_lblChkInMonthAndYear ="AvailabilitySearch1_lblChkInMonthAndYear";
	public static final String CheckInText = "//div[@id='AvailabilitySearch1_chkInPanel']/fieldset/legend";
	public static final String AvailabilitySearch1_lbkChkOutDate="AvailabilitySearch1_lbkChkOutDate";
	public static final String AvailabilitySearch1_lblChkOutDayOfTheWeek="AvailabilitySearch1_lblChkOutDayOfTheWeek";
	public static final String AvailabilitySearch1_lblChkOutMonthAndYear="AvailabilitySearch1_lblChkOutMonthAndYear";
	public static final String CheckOutText = "//div[@id='AvailabilitySearch1_chkOutPanel']/fieldset/legend";
	public static final String AvailabilitySearch1_lblPropertyName="//*[@id='AvailabilitySearch1_lblPropertyName']";
	public static final String AvailabilitySearch1_divGuests="//*[@id='AvailabilitySearch1_divGuests']/div[2]";
	public static final String GetRoomClassName_Availableroompage="//*[@id='MainContent_rptrPropertyList_trContent_0']/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div[1]";
	public static final String GetRoomClassName_Availableroompage2="//*[@id='MainContent_rptrPropertyList_trContent_1']/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div[1]";
	public static final String GetRoomClassName_Availableroompage3="//*[@id='MainContent_rptrPropertyList_trContent_2']/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div[1]";
	public static final String Click_Select_Button="//input[@value='Select']";
	public static final String Increment_Adult_Count="//a[@class='incRoomCount flL grayGradient'] [@data-bind='click: incAdults']";
	public static final String Increment_Child_Count="//a[@class='incRoomCount flL grayGradient'] [@data-bind='click: incChildren']";
	public static final String Check_in_Text="//*[@id='divNonGroup']/div/div[6]/div[1]/div[7]/div[2]/span[2]/span";
	public static final String Check_out_Text="//*[@id='divNonGroup']/div/div[6]/div[1]/div[7]/div[3]/span[2]/span";
	public static final String Get_Numberofchilds="AvailabilitySearch1_txtChildren";

	//Navigating links

	public static final String Tape_Chart="//span[.='Tape Chart']";
	public static final String Tape_Chart_Grid1="//div[@class='datemonthcell']";
	public static final String New_Quote ="//span[.='New Quote']";
	public static final String New_Quote_Search="//div[@data-bind='visible: !isSearchLoading()']";
	public static final String Guest_History ="//span[.='Guest History']";
	public static final String Guest_History_Grid="//div[@data-bind='visible: showListContent() || showAccountListContent()']";
	public static final String Groups="//span[.='Groups']";
	public static final String Groups_text="//font[@class='TitleText']";
	public static final String Accounts="head_accounts";
	public static final String Accounts2="//ul[@data-bind='foreach: MainNavigation']//li[2]";
	public static final String Accounts_sec_Nav="//li[@class='accounts here active open']";
	public static final String Statements="//span[.='Statements']";
	public static final String Statement_Content="//div[@class='main_content']";
	public static final String Unit_owner="//a[.='Unit Owner Items']";
	public static final String Unit_owner_Account="//font[.='Unit Owner Items']";
	public static final String Travel_Agent="//a[.='Travel Agent Items']";
	public static final String Travel_Agent_Grid="//*[@id='tdTitle']/font";
	public static final String Manafement_Transfers="//a[.='Management Transfers']";
	public static final String Manafement_Transfers_Grid="//*[@id='tdTitle']/font";
	public static final String Account_Distribution="//a[.='Account Distributions']";
	public static final String Account_Distribution_grid="//font[@class='TitleText']";
	public static final String Guest_Services="head_guest_services";
	public static final String Guest_Services_grid="//*[@id='tdTitle']/font";
	public static final String House_Keeping="//a[.='Housekeeping Status']";
	public static final String House_Kepping_status="//*[@id='tdTitle']/font";
	public static final String Task_List="//a[.='Task List']";
	public static final String Task_List_grid="//*[@id='tdTitle']/font";
	public static final String Room_Maintanence="//a[.='Room Maintenance']";
	public static final String Room_Maintanence_Grid="//*[@id='tdTitle']/font";
	public static final String Inventory=".//*[@class='nav-inventory nav_icon']";  //changed id "head_inventory" to xpath 
	public static final String Inventory_Grid="//*[@id='tdTitle']/font";
	public static final String Overview="//a[.='Overview']";
	public static final String Overview_grid="//*[@id='tdTitle']/font";
	public static final String Seasons="//a[.='Seasons']";
	public static final String Rates="//span[.='Rates']";
	public static final String Rates_Grid="//*[@id='tdTitle']/font";
	public static final String Rules="//a[.='Rules']";
	public static final String Rules_Grid="//button[.='New Rule']";
	public static final String Distribution="//span[.='Distribution']";
	public static final String Distribution_Gird="//div[@id='DistributionMain']";
	public static final String policies="//span[.='Policies']";
	public static final String Policy_Button="//button[.='New Policy']";
	public static final String Setup="//span[.='Setup']";
	public static final String Setup_Grid="//*[@id='tdTitle']/font";
	public static final String Propeties="//a[.='Properties']";
	public static final String Propety_Grid="//*[@id='tdTitle']/font";
	public static final String Roomclass="//a[.='Room Classes']";
	public static final String Roomclass_grid="//button[.='New Room Class']";
	public static final String Taxes="//span[.='Taxes']";
	public static final String Taxes_Grid="//*[@id='tdTitle']/font";
	public static final String Ledger_Accounts ="//a[.='Ledger Accounts']";
	public static final String Merchant_Services ="//a[.='Merchant Services']";
	public static final String Merchant_Services_Grid ="//*[@id='tdTitle']/font";
	public static final String Document_Template ="//a[.='Document Templates']";
	public static final String Documnet_Template_Grid="//*[@id='tdTitle']/font";
	public static final String List_Management="//a[.='List Management']";
	public static final String List_Management_Grid="//*[@id='tdTitle']/font";
	public static final String Task_Management ="//a[.='Task Management']";
	public static final String Admin="head_admin";
	public static final String Client_info ="//a[.='Client Info']";
	public static final String Client_info_grid ="//*[@id='tdTitle']/font";
	public static final String Users="//a[.='Users']";
	public static final String Users_grid="//button[.='New User']";
	public static final String Roles="//span[.='Roles']";
	public static final String Roles_page="//button[.='New Role']";
	public static final String Night_audit="//span[.='Night Audit']";
	public static final String Period_status="//*[@id='tdTitle']/font";
	public static final String Statement_Grid="//*[@id='tdTitle']/font";
	public static final String Seasons_button="//button[.='New Season']";
	public static final String Ledger_Account_Grid="//*[@id='tdTitle']/font";
	public static final String Admin_Grid="//*[@id='tdTitle']/font";
	public static final String Distribution_syndication="//a[.='Syndication']";
	public static final String Distribution_Blackouts="//a[.='Blackouts']";
	public static final String Reports="head_reports";
	public static final String Reports_Grid="//span[.='Reports']";
	public static final String Account_Balance="//a[.='Account Balances']";
	public static final String Account_Balance_Grid="//*[@id='tdTitle']/font";
	public static final String Ledger_Balances="//a[.='Ledger Balances']";
	public static final String Ledger_Balances_Grid="//*[@id='tdTitle']/font";
	public static final String Merchant_Trans="//a[.='Merchant Trans']";
	public static final String Merchant_Trans_grid="//*[@id='tdTitle']/font";
	public static final String Daily_flash="//a[.='Daily Flash']";
	public static final String Daily_flash_grid="//*[@id='tdTitle']/font";
	public static final String Room_Forecast="//a[.='Room Forecast']";
	public static final String Room_Forecast_grid="//*[@id='tdTitle']/font";
	public static final String Net_Sales="//a[.='Net Sales']";
	public static final String Net_Sales_Grid="//*[@id='tdTitle']/font";
	public static final String Advance_Depos="//a[.='Advance Deposit']";
	public static final String Advance_Depos_grid="//*[@id='tdTitle']/font";
	public static final String Reservation_Backward="//*[@id='head_reservations']/a";
	public static final String closeGuestHistoryRes="(//i[contains(@data-bind,'click: $parent.closeTab')])[7]";

	//Reservation page

	public static final String Guestinfo="//a[.='Guest Info']";

	//Reservation button

	public static final String New_Reservation_Button="//a[.='New Reservation']";
	public static final String New_Reservation_Tab="//span[.='New Reser...']";
	public static final String New_Reservation_Page_Load="//*[@id='ReservationDetailMain']/ul";
	public static final String Reservation_market_Segment="//select[contains(@data-bind,'MarketSegmentValue')]";
	public static final String Reservation_Referral="//select[contains(@data-bind,'ReferralsValue')]";
	public static final String Enter_Travel_Agent="//input[@placeholder='Find Account Profile']";
	public static final String Enter_Ext_Reservation="//input[@placeholder='Ext Reservation']";
	public static final String Enter_Guest_Profile ="//input[@placeholder='Find Guest Profile']";
	public static final String Select_Saluation ="//label[.='Guest:']//following-sibling::div/div/div/select";
	public static final String Enter_First_Name="//label[.='Guest:']//following-sibling::div/div/div/input[@placeholder='First Name']";
	public static final String Enter_Last_Name="//label[.='Guest:']//following-sibling::div/div/div/input[@placeholder='Last Name']";
	public static final String Enter_Address_Search="//input[@placeholder='Search Address']";
	public static final String Enter_Line1="//input[@placeholder='Line 1']";
	public static final String Enter_Line2="//input[@placeholder='Line 2']";
	public static final String Enter_Line3="//input[@placeholder='Line 3']";
	public static final String Enter_City="//input[@placeholder='City']";
	public static final String Select_Country="//label[.='Country:']//following-sibling::div/select[contains(@data-bind,'CountryId')]";
	public static final String Select_State="//label[.='State:']//following-sibling::div/div/div/select[contains(@data-bind,'TerritoryId')]";
	public static final String Enter_Postal_Code="//input[@placeholder='Postal Code']";
	//public static final String Enter_Phone_Number="//label[.='Phone:']//following-sibling::div/p/span[2]";
	public static final String Enter_Phone_Number ="//input[contains(@data-bind,'value: PhoneNumber')]";
	public static final String Enter_Alt_Phn_number="//label[.='Alternate Phone:']//following-sibling::div/div/div/input[contains(@data-bind,'AltPhoneNumber')]";
	public static final String Enter_email="//label[.='Email:']//following-sibling::div/div/div/input[contains(@data-bind,'Email')]";
	public static final String Enter_Account="//input[@placeholder='Find Account']";
	public static final String Check_IsTaxExempt="//input[contains(@data-bind,' IsTaxExempt')]";
	public static final String Enter_TaxExemptId="//input[contains(@data-bind,' TaxExemptId')]";
	public static final String Check_isLongstay="//label//input[contains(@data-bind,' IsLongStay')]";
	public static final String Select_Payment_Method="//select[contains(@data-bind,'PaymentTypeId')]";
	public static final String Enter_Account_Number="//input[@placeholder='Account Number']";
	public static final String Enter_Exp_Card="//input[contains(@data-bind,' BillingCreditCardExpiryDate')]";
	public static final String Enter_Billing_Note="//input[contains(@data-bind,' BillingNotes')]";
	public static final String Add_Note_Reservation="//a[@data-target='#ReservationNotesCreate']";
	public static final String Click_RoomPicker="//button[contains(@data-bind,'EnableRoomPicker')]";

	public static final String Room_Assignment_PopUp="//h4[.='Room Assignment']";
	public static final String Click_Arrive_Datepicker="//input[contains(@data-bind,'DateArrived')]//following-sibling::div/a/i";
	public static final String Click_Today="//table[@class='datepicker-table-condensed table-condensed']//tfoot/tr[1]/th";
	public static final String Enter_Nigts="//input[@data-bind='value: Nights']";
	public static final String Enter_Adults="//input[contains(@data-bind,'value: Adults')] [@type='text']";
	public static final String Enter_Children="//input[contains(@data-bind,'value: (Children')]";
	public static final String selectRackRate="//select[contains(@data-bind,'options: RatePlanList')]";
	public static final String Enter_Rate_Promocode="//input[contains(@data-bind,'RatePromoCode')]";
	public static final String Check_Assign_Room="//input[contains(@data-bind,'AssignRoomsEnabled')]";
	public static final String Click_Search="//button[contains(@data-bind,'SearchBtnClick')]";
	public static final String Validation_Text_NoRooms="//div[.='Room Classes are not available for the search criteria. Please change the criteria and try again']";
	public static final String Select_property_RoomAssign="//select[contains(@data-bind,'SelectedProperty')]";
	public static final String Select_property_RoomAssign2="//div[@id='modalRoomPickerReservation']//select[contains(@data-bind,'SelectedProperty')]";
	public static final String Verify_Room_Grid="//div[@id='divPickRoomGrid']";
	public static final String Select_Room_Class="//tbody//select[contains(@data-bind,'RoomClassId')]";
	public static final String Select_Room_Number="//tbody//select[contains(@data-bind,'RoomId')]";
	public static final String Select_Room_Number2="(//tbody//select[contains(@data-bind,'RoomId')])[2]";
	public static final String Validating_UnAssgined_DDL="//tbody[@data-bind='foreach: RoomListWithRules']//td[3]/select[contains(@disabled,'')]";
	public static final String Click_Select="//*[@id='modalRoomPickerReservation']/div[3]/div//button[.='Select']";
	public static final String Verify_RulesBroken_Popup=".//*[@id='myModalLabelforRuleMessage']";
	public static final String Click_Continue_RuleBroken_Popup="//button[contains(@data-bind,'isOverRideAllowed(), text: btnContinue')]";
	public static final String Verify_Toaster_Container="//div[@id='toast-container']"; 
	public static final String Toaster_Title="//div[@class='toast-title']";
	public static final String Toaster_Message="//div[@class='toast-message']";
	public static final String AccountName="//span[contains(@data-bind,'text: Account.AccountFirstName()+')]";
	public static final String AccountNo="//span[contains(@data-bind,'text: Account.AccountFirstName()+')]//following-sibling::span";
	public static final String Get_Property_Name="//*[@id='StayInfo']//following-sibling::label[.='Property:']//following-sibling::div/p";
	public static final String Get_RoomClass_Status="//*[@id='StayInfo']//following-sibling::label[.='Room(s):']/following-sibling::div/p/span";
	public static final String Click_Save_ReservationDetails="//button[.='Save']";
	public static final String Verify_Depos_policy="//div[@aria-hidden='false']//h4[.='Deposit Policy']";
	public static final String Click_Without_Deposit="//div[@aria-hidden='false']//div[3]/button[.='Without Deposit']";
	public static final String First_Element_In_Search_Result=".//*[@id='bpjscontainer_21']//tbody/tr[1]/td[1]/a";
	public static final String Click_Save_Close="//div[@class='footer_buttons']//button[.='Save and Close']";
	public static final String Reservation_Status="//label[contains(text(),'Reservation Status: ')]/following-sibling::div//select";


	public static final String Room_Assignment_PopUp_Error="//*[@id='modalRoomPickerReservation']//div[contains(@class,'alert')]";
	public static final String Room_Selector_In_Room_Assignment_PopUp="(//*[@id='modalRoomPickerReservation']//select[contains(@data-bind,'options: Rooms')])[1]";
	public static final String ReCalculate_Folio_Options_PopUp="//div[@id='divRoomPickerReCalculateFolios']";            
	public static final String ReCal_Folio_Options_PopUp_No_Charge_Changed="//div[@id='divRoomPickerReCalculateFolios']//input[@value='0']";  

	public static final String ReCal_Folio_Options_PopUp_Select_Btn="//div[@id='divRoomPickerReCalculateFolios']//button[text()='Select']"; 
	public static final String ReCal_Folio_Options_PopUp_Cancel_Btn="//div[@id='divRoomPickerReCalculateFolios']//button[text()='Cancel']"; 

	public static final String Resell_Rooms_Popup="//h4[text()='Resell Rooms']";
	public static final String Resell_Rooms_Popup_Continue_Btn="//div[contains(@data-bind,'excludeRoomContainer')]//button[text()='Continue']";
	public static final String Resell_Rooms_Popup_Cancel_Btn="//div[contains(@data-bind,'excludeRoomContainer')]//button[text()='Cancel']";
	public static final String ReservationPage_Reset_Btn="//div[@class='footer_buttons']//button[.='Reset']";
	//LineItems
	public static final String Add_LineItem="//button[contains(@data-bind,'fnAddFolioItem')]";
	public static final String Select_LineItem_Category="//select[contains(@data-bind,'LedgerAccountItems')]";
	public static final String Enter_LineItem_Amount="//td[@class='lineitem-amount']/input";
	public static final String Commit_LineItem="//button[.='Commit']";

	//New Quote

	public static final String Click_Arrive_DatePicker="//input[@placeholder='Arrive']/following-sibling::div/a/i";
	public static final String Enter_RateQuoteNights="//input[@data-bind='value: RateQuoteNights']";
	public static final String Enter_RateQuoteAdults="//input[@data-bind='value: RateQuoteAdults']";
	public static final String Enter_RateQuoteChildren="//input[@data-bind='value: RateQuoteChildren']";
	public static final String Select_RateQuoteRatePlanList="//select[contains(@data-bind,'options: RateQuoteRatePlanList')]";
	public static final String Enter_RateQuotePromoCode="//input[@data-bind='value: RateQuotePromoCode']";
	public static final String Check_RateQuoteAssignRooms="//input[@data-bind='checked: RateQuoteAssignRooms']";
	public static final String Click_searchRateQuote="//button[@data-bind='click: searchRateQuote']";
	public static final String Click_clearRateQuote="//button[@data-bind='click: clearRateQuote']";
	public static final String Verify_tblRateQuoteGrid="//*[@id='tblRateQuoteGrid']";
	public static final String Verify_Number_rate_book_green="//button[@class='rate-book-green']";
	public static final String Verify_Number_rate_book_red="//button[@class='rate-book-red']";
	public static final String Get_Property_Id="//tr[@rowtype='RoomClassHeader']";
	public static final String Click_First_Book_Icon="//tr[@rowtype='RoomClassHeader']/following-sibling::tr[1]//td[contains(@id,'td_Action')]/button[2]";
	public static final String Click_Rate_Quote_Book="//button[contains(@data-bind,'isOverRideAllowed(), text: btnQuoteOrBook')]";
	public static final String Verify_OverBook_popup="//h4[@id='myModalLabelforRuleMessage'] [@data-bind='text: ruleTitle']";
	public static final String Click_Continue_OverBook_Popup="//button[contains(@data-bind,'isOverRideAllowed(), text: btnContinue')]";



	//Accounts

	public static final String Select_Account_Type="//div[@id='accountSearchFilter']//label/following-sibling::div/select[contains(@data-bind,'AccountTypeName')]";
	public static final String Click_New_Account="//button[.='New Account']";
	public static final String Verify_New_Account_tab="//span[.='New Accou...']";
	public static final String Verify_New_Account_Page_Load="//div[@data-bind='foreach: AccountDetails']";
	public static final String Enter_Account_Name="//input[contains(@data-bind,'value: Account.AccountName')]";
	public static final String Verify_Account_Type="//div[@data-bind='foreach: AccountDetails']//label/following-sibling::div/select[contains(@data-bind,'AccountTypeName')]";
	public static final String Select_Market_Segment="//select[contains(@data-bind,'options: Marketings')]";
	public static final String Select_Referrals="//select[contains(@data-bind,'options: Referrals')]";
	public static final String Account_Enter_First_Name="//input[contains(@data-bind,'value: Account.MailingAddress.FirstName')]";
	public static final String Account_Enter_Last_Name="//input[contains(@data-bind,'value: Account.MailingAddress.LastName')]";
	public static final String Account_Phone_number="//input[contains(@data-bind,'value: Account.MailingAddress.PhoneNumber')]";
	public static final String Account_Enter_AltPhoneNumber="//input[contains(@data-bind,'value: Account.MailingAddress.AltPhoneNumber')]";
	public static final String Account_Enter_Line1="//input[contains(@data-bind,'value: Account.MailingAddress.MailingAddress1')]";
	public static final String Account_Enter_Line2="//input[contains(@data-bind,'value: Account.MailingAddress.MailingAddress2')]";
	public static final String Account_Enter_Line3="//input[contains(@data-bind,'value: Account.MailingAddress.MailingAddress3')]";
	public static final String Account_Enter_Email="//input[contains(@data-bind,'value: Account.MailingAddress.Email')]";
	public static final String Account_Enter_City="//input[contains(@data-bind,'value: Account.MailingAddress.City')]";
	public static final String Select_Account_State="//div[@data-bind='foreach: AccountDetails']//label/following-sibling::div/select[contains(@data-bind,'value: $parent.Account.MailingAddress.TerritoryId')]";
	public static final String Account_Enter_PostalCode="//input[contains(@data-bind,'value: Account.MailingAddress.PostalCode')]";
	public static final String Account_Check_Mailing_info="//input[contains(@data-bind,'checked: Account.UseMailingInfo')]";
	public static final String Account_save="//div[@class='footer_buttons accDetailBtns']//button[.='Save']";
	public static final String Account_Folio="//div[@class='AccountDetail']//a[.='Folio']";
	public static final String Account_pay="//div[@class='AccountDetail']//button[.='Pay']";
	public static final String Account_Add="//div[@class='AccountDetail']//button[.='Add']";
	public static final String Verify_Account_line_item="//div[@class='AccountDetail']//tbody[contains(@data-bind,'getElement: ComputedFolioItemsElement')]";
	public static final String Select_Line_item_Category="//div[@class='AccountDetail']//select[contains(@data-bind,'value: SelectedLedgerAccount')]";
	public static final String Enter_Line_item_Amount="//div[@class='AccountDetail']//input[contains(@data-bind,'value: Amount')]";
	public static final String Enter_Gift_Line_Item_Amount="//div[@class='AccountDetail']//td[@class='lineitem-amount']//input[contains(@data-bind,'value: Amount')]";
	public static final String Click_Commit="//div[@class='AccountDetail']//button[.='Commit']";
	public static final String Select_Account_paymethod="//div[@id='AccountPaymetItemDetail']//select[contains(@data-bind,'options: $parent.PaymentMethodsList')]";
	public static final String Click_Account_Card_info="//div[@id='AccountPaymetItemDetail']//button[contains(@data-bind,'click: $root.ShowCreditCardInfoPopup')]";
	public static final String Verify_Account_Paymnet_info_popup="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//h4";
	public static final String Enter_Account_Card_Name="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//input[contains(@data-bind,'value: NameOnCard')]";
	public static final String Enter_CC_Account_Number="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//input[contains(@data-bind,'value: $root.txtBilling_AccountNumber')]";
	public static final String Enter_ExpiryDate_Account="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//input[contains(@data-bind,'value: ExpDate')]";
	public static final String Enter_CCV_Account="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//input[contains(@data-bind,'value: CvvCode')]";
	public static final String Click_Ok_Account="//div[contains(@class,'AccountPaymentDetailCreditCardInfo')]//button[.='OK']";
	public static final String Select_Authorization_Type_Account="//div[@id='AccountPaymetItemDetail']//select[@name='AuthorizationTypeOut']";
	public static final String Enter_Change_Amount="//div[@id='AccountPaymetItemDetail']//input[contains(@data-bind,'value: $parent.formattedAmount')]";
	public static final String Click_Account_Pay_Continue="//div[@id='AccountPaymetItemDetail']//button[contains(@data-bind,'click: btnSaveTranPayClick')]";
	public static final String Click_Process_Account="//div[@id='AccountPaymetItemDetail']//button[contains(@data-bind,'click: $root.btnProcess_Click')][1]";
	public static final String Account_Payment_Method="//div[@id='AccountPaymetItemDetail']//following-sibling::div[@id='reservationList']//span[.='MC']";
	public static final String Get_Line_item_Account="//div[@class='AccountDetail']//tr[1]//td[@class='lineitem-description-2']//a";
	public static final String Verify_Ending_Balance="//label[.='Ending Balance: ']//following-sibling::span[@class='pamt']";
	public static final String Select_Property_lineitem="//div[@class='AccountDetail']//select[contains(@data-bind,'value: SelectedProperty')]";
	public static final String Apply_Advance_Deposite="//div[@id='ruleMessageForInnroad']//h4[.='Apply Advance Deposit']";
	public static final String Click_Continue_Adv_Deposite="//*[@id='ruleMessageForInnroad']//button[.='Continue']";
	public static final String Acc_Add_Button="//a[.='Add']";
	public static final String Verify_Notes_Popup="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//h4[.='Note Details']";
	public static final String Acc_Note_Enter_sub="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//input[contains(@data-bind,'value: Subject')]";
	public static final String Acc_Note_Enter_Details="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//textarea[contains(@data-bind,'value: NoteDetails')]";
	public static final String Acc_Note_Select_Note_Type="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//select[contains(@data-bind,'options: $parent.NoteTypes')]";
	public static final String Acc_Note_Select_Note_Status="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//select[contains(@data-bind,'options: $parent.Statuses')]";
	public static final String Acc_Note_Action_Req="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//input[contains(@data-bind,'checked: IsActionRequired')]";
	public static final String Acc_Note_Save="//div[@class='modal-scrollable']//div[@id='NotesDetailPopup']//button[.='Save']";
	public static final String Verify_Add_line_Notes="//tr[@data-bind='visible : showCancelledNotes()']";

	public static final String AccountsPage_Reset_Btn="//div[@class='footer_buttons accDetailBtns']//button[.='Reset']";
	public static final String AccountsPage_Click_All="//div[@id='accountSearchFilter']//a[text()='All']";
	public static final String First_Element_In_Account_SearchResults="(//tbody[@data-bind='foreach: AccountList']//tr)[1]//a";
	public static final String Enter_AccountName_On_SearchPage="//input[@data-bind='value: AccountName']";
	public static final String Enter_AccountName_On_SearchPages="//input[@data-bind='value: AccountName']";
	//Basic Search

	public static final String BasicGuestName="//input[contains(@data-bind,'textInput: BasicGuestName')]";
	public static final String Get_Guest_Name="//a[contains(@data-bind,'title: GuestName')]";
	public static final String Click_BasicSearch="//div[@id='ReservationSearch']//following-sibling::button[@value='Search']";
	public static final String Verify_Search_Loading_Gird="//div[contains(@data-bind,'visible: !isSearchLoading()')]//following-sibling::section/div";
	public static final String Basic_Res_Number="//div[@id='ReservationSearch']//input[@id='txtResNum']";
	public static final String Get_Res_Number="//span[@data-bind='text: ConfirmationNumber']";


	//Manual Email

	public static final String Click_Email_icon="//div[@id='ReservationDetailMain']//i[contains(@data-bind,'click: SendMail')]";
	public static final String Verify_Send_Email_Popup="//div[@id='mailContentPopUp']//h4[@id='myModalLabel']";
	public static final String Select_Attachment="//div[@id='mailContentPopUp']//select[contains(@data-bind,'options: MailAttachments')]";
	public static final String Verify_loading_popup_mailContentPopUp="//div[@id='mailContentPopUp']//div[@class='modules_loading']";
	public static final String Get_email_Id="//input[contains(@data-bind,'value: MailTo')]";
	public static final String Click_Send_Email="//div[@id='mailContentPopUp']//button[contains(@data-bind,'click: SendMail')]";


	//Bluk Checkin

	public static final String Check_Reservation="//tbody[@data-bind='foreach: ReservationList']//div[@class='checker']";
	public static final String Click_Bulk_Action="//button[@title='Bulk Action']";
	public static final String Select_Checkin="//span[.='Check In']";
	public static final String Verify_Bulk_Checkin_popup="//h4[.='Bulk Check In']";
	public static final String Verify_Guest_Name="//div[@id='tab1']//span[contains(@data-bind,' text: GuestName')]";
	public static final String Click_Process_Button="//button[contains(@data-bind,'click: ValidateAndProcess')]";
	public static final String Verify_Bulk_Checin_Completed="//h4[.='Bulk Check In Completed']";
	public static final String Verify_Bulk_Checkin_Success="//span[.='1']";
	public static final String click_on_Close_icon="//button[@data-bind='click: closeBulkPopup']";
	public static final String Get_Reservation_Status="//span[contains(@data-bind,'text: StatusName.replace')]";
	public static final String Select_Checkout="//span[.='Check Out']";
	public static final String Verify_Bulk_Checkout_popup="//h4[.='Bulk Checkout']";
	public static final String Verify_Bulk_Checkout_Completed="//h4[.='Bulk Checkout Completed']";
	public static final String Click_On_First_SearchResult="(//td//a[@title])[1]";
	public static final String Check_First_SearchResult="(//td//input[contains(@data-bind,'DeleteReservation')])[1]";


	//Bulk Cancellation
	public static final String selectAllArrivals="//li[@class='all-arrivals active predefinedQueryOption']";
	//public static final String inHouseReservations="//li[@class='in-house active predefinedQueryOption']";
	public static final String inHouseReservations="//li[@class='in-house predefinedQueryOption active']";

	//Folio

	public static final String Click_Pay_Button="//button[.='Pay']";
	public static final String Verify_Payment_Details_poup="//span[.='Payment Details']";
	public static final String Select_Paymnet_Method="//div[@id='ReservationPaymetItemDetail']//select[contains(@data-bind,'options: $parent.PaymentMethodsList')]";
	public static final String Click_ADD_Button="//div[@id='ReservationPaymetItemDetail']//button[.='Add'] [contains(@data-bind,'parent.btnAddEnabled()')]";
	public static final String Verify_Guest_Ledger="//div[@id='ReservationPaymetItemDetail']//following-sibling::div[@id='reservationList']";
	public static final String Get_Payment_Method="//div[@id='ReservationPaymetItemDetail']//div[@id='reservationList']//span[contains(@data-bind,'text: $data.LedgerAccountName')]";
	public static final String Click_Continue="//div[@id='ReservationPaymetItemDetail']//button[contains(@data-bind,'click: btnSaveTranPayClick')]";
	public static final String Verify_Line_item="//a[contains(@data-bind,'parent.fnPayLineItemDetail')] [.='Cash']";
	public static final String Click_Card_info="//div[@id='ReservationPaymetItemDetail']//button[contains(@data-bind,'click: $root.ShowCreditCardInfoPopup')]";
	public static final String Verify_payment_info_popup="//div[@id='ReservationPaymentDetailCreditCardInfo']//h4";
	public static final String Enter_Card_Name="//div[@id='ReservationPaymentDetailCreditCardInfo']//input[contains(@data-bind,'value: NameOnCard')]";
	public static final String Enter_Account_Number_Folio="//div[@id='ReservationPaymentDetailCreditCardInfo']//input[contains(@data-bind,'value: $root.txtBilling_AccountNumber')]";
	public static final String Enter_CC_Expiry="//div[@id='ReservationPaymentDetailCreditCardInfo']//input[contains(@data-bind,'value: ExpDate')]";
	public static final String Enter_CVVCode="//div[@id='ReservationPaymentDetailCreditCardInfo']//input[contains(@data-bind,'value: CvvCode')]";
	public static final String Click_OK="//div[@id='ReservationPaymentDetailCreditCardInfo']//button[.='OK']";
	public static final String Click_Process="(//div[@id='ReservationPaymetItemDetail']//button[text()='Process'])[1]";  			//"//div[@id='ReservationPaymetItemDetail']//button[contains(@data-bind,'$parent.btnProcessVisible()')]";
	public static final String GetMC_Payment_Method="//div[@id='ReservationPaymetItemDetail']//following-sibling::div[@id='reservationList']//span[.='MC']";
	public static final String GetAddedLine_MC="//div[@id='ReservationDetail']//tr[@data-bind='if: $parent.ShouldShowThisItem($data)'][2]//a";
	public static final String GetAddedLine_MC_Amount="//div[@id='ReservationDetail']//tr[@data-bind='if: $parent.ShouldShowThisItem($data)']//span[text()='MC']/../following-sibling::td[@class='lineitem-amount']/span";
	public static final String Verify_MC_Grid="//tbody[contains(@data-bind,'foreach: PaymentItemsArray')]//tr";

	public static final String Verify_Balance_Zero="//label[.='Balance: ']//following-sibling::span/span";
	public static final String Select_Authorization_type="//div[@id='ReservationPaymetItemDetail']//select[@name='AuthorizationTypeOut']";
	public static final String Change_Amount="//div[@id='ReservationPaymetItemDetail']//input[contains(@data-bind,'value: $parent.formattedAmount')]";

	public static final String Payment_Details_Folio_Balance=".//*[@id='StayInfo']//label[text()='Folio Balance:']/..//p/span";

	//Folio Line items void

	public static final String click_Folio_tab=".//*[@id='ReservationDetailMain']//a[contains(@data-bind,'click: switchToFoliosTab')]";
	public static final String click_Add_Button="//button[contains(@data-bind,'enable: !AccountTypeGroup(),click: fnAddFolioItem')]";
	public static final String selectCategory="//select[contains(@data-bind,'options: LedgerAccountItems')]";
	public static final String enterAmount="//input[contains(@data-bind,'value: Amount')]";
	public static final String clickSaveButton="//button[contains(@data-bind,'click: PreSave')]";
	public static final String clickOkForPopup="(//button[contains(text(),'Ok')])[2]";

	public static final String clickCommitButton="//button[contains(text(),'Commit')]";
	public static final String selectAllLineItems="//input[contains(@data-bind,'click: SelectAllLineItems')]";
	public static final String clickVoidButton="//button[contains(@data-bind,'click: fnVoidFolioItems')]";
	public static final String enterNotes="//textarea[contains(@data-bind,'value: notesPopUpNote')]";
	public static final String clickVoidButtonInNotes="//button[contains(@data-bind,'click: NotesSaveClick')]";
	public static final String DisplayVoidItemsCheckBox="//span[contains(text(),'Display Void Items')]/../input";
	public static final String getBalanceFolioLineItems="//label[.='Balance: ']//following-sibling::span/span";

	//************************Add/Post Folio Line Items*************************//

	public static final String reservationGuestName="(//a[contains(text(),'Auto Guest')])[1]";
	public static final String reservationGuestName2="(//a[contains(text(),'Auto Guest')])[2]";
	public static final String lineItem1="(//img[@src='./Folio_Images/1.gif'])[1]";
	public static final String lineItem2="(//img[@src='./Folio_Images/2.gif'])[1]";
	public static final String clickOnDescription="(//img[@src='./Folio_Images/2.gif'])[1]/../../td[8]/a";
	public static final String clickRollBackButtonInPopUp="//button[@class='btn blue']/i[@class='fa fa-reply']";
	public static final String clickContinueButton="(//button[contains(text(),'Continue')])[9]";

	//Tape Chart

	public static final String tapeChartGridLayOut="//div[@class='container ng-mobile-nospace']";
	public static final String Select_Arrival_Date="//input[contains(@data-bind,'value: ArriveDate')]//following-sibling::div//a/i";
	public static final String Enter_Adults_Tapehchart="//div[@id='tapeChartSearch']//input[contains(@data-bind,'value: Adults')]";
	public static final String Enter_Children_Tapechart="//div[@id='tapeChartSearch']//input[contains(@data-bind,'value: Children')]";
	public static final String Click_Tapechart_Rateplan="//div[@id='divReservationTapeChart']//button[@title='Rate Plan']";
	public static final String Enter_promoCode_Tapechart="//div[@id='tapeChartSearch']//input[contains(@data-bind,'value: PromoCode')]";
	public static final String Click_Search_TapeChart="//div[@id='tapeChartSearch']//button[@value='Search']";
	public static final String Click_First_Available=".//*[@id='bpjscontainer_49']/div/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[2]";
	public static final String Get_Tapechart_Rateplan="//div[@id='tapeChartSearch']//ul[@role='menu']/li/a/span[1]";
	public static final String Select_Rack_Rate="//div[@id='tapeChartSearch']//ul[@role='menu']/li/a/span[.='Rack Rate']";
	public static final String Rules_Broken_popup="//div[@id='rulesBrokenConfirmation']//h4";
	public static final String Click_Book_icon_Tapechart="//div[@id='rulesBrokenConfirmation']//button[.='Book']";
	public static final String FirstRoomClass_Rate_In_Tapechart="(//div[@class='roomRatesChart'])[1]/div[1]//div[@class='tapechartdatecell'][1]";
	public static final String Click_First_Available_In_First_Roomclass="((//div[@class='roomRatesChart'])[1]//div[text()='Available'])[1]/../../../..";


	public static final String clickAvailableRoom="(//div[.='Available'])[1]";
	public static final String get_Reservation_Status="//select[contains(@data-bind,'enable: drpReservationStatusEnabled')]";
	public static final String clickCancelButton="//a[contains(@data-bind,'click: Cancel_Reservation')]";
	public static final String cancelReason="(//textarea[contains(@data-bind,'value: cancelreason')])[2]";
	public static final String OkCancelReason="(//button[contains(@data-bind,'click: OKClick')])[2]";
	//Checkin

	public static final String Click_Checkin="//button[.='Check In']";
	public static final String Verify_Dirty_Room_popup="//h4[contains(@data-bind,'text: ModalTitleText')]";
	public static final String Confirm_button="//button[contains(@data-bind, 'enable: YesButtonEnable')]";
	public static final String Click_on_confirm="//div[@class='header-confirmation']//button[2]";
	public static final String Payment_Popup="//span[.='Payment Details']";
	public static final String Key_Generation_Popup="//h4[.='Key Generation']";
	public static final String Key_Generation_Close="//*[@id='keyGenerationPopUp']/div[3]/div/button[3]";


	//Checkin-New Objects
	public static final String Enter_Checkin_Percentage_On_balance ="(.//*[@id='checkin']//input[@type='text'])[1]";
	public static final String Select_Capture_Payment_for_Checkin="(.//*[@id='checkin']//input[@type='radio'])[1]";
	public static final String Select_Authorize_Payment_for_Checkin="(.//*[@id='checkin']//input[@type='radio'])[2]";

	public static final String Enter_Policy_Text=".//textarea[contains(@data-bind,'PolicyStatement')]";
	public static final String Enter_Policy_Description=".//textarea[contains(@data-bind,'PolicyDescription')]";
	public static final String Associate_Sources_Btn=".//button[text()='Associate Sources']";
	public static final String Associate_Seasons_Btn=".//button[text()='Associate Seasons']";
	public static final String Associate_Room_Classes_Btn=".//button[text()='Associate Room Classes']";
	public static final String Associate_Rate_Plans_Btn=".//button[text()='Associate Rate Plans']";
	public static final String Associate_Assign_All_Btn="//button[@data-bind='click: AssignAll']";
	public static final String Available_Options_In_Popup="(.//*[@id='roleModal']//select)[1]/option";
	public static final String Added_Options_In_Popup="(.//*[@id='roleModal']//select)[2]/option"; 
	public static final String Done_In_Popup =" .//*[@id='roleModal']//button[text()='Done']";
	public static final String Selected_Options_Under_Room_Class="//tbody[contains(@data-bind,'PolicyRoomClasses')]/tr[@style='']";
	public static final String Selected_Options_Under_Sources="//tbody[contains(@data-bind,'PolicySources')]/tr[@style='']";
	public static final String Selected_Options_Under_Seasons="//tbody[contains(@data-bind,'PolicySeasons')]/tr[@style='']";
	public static final String Selected_options_Under_Rateplan="//tbody[contains(@data-bind,'PolicyRatePlans')]/tr[@style='']";
	public static final String Policy_Save=".//*[@id='bpjscontainer_22']//button[text()='Save']";
	public static final String Policy_Close_Btn=".//*[@id='bpjscontainer_17']//li[contains(@class,'new-policy')]//i";
	public static final String Delete_Policy_Checkbox="(//input[@data-bind='checked: deletePolicy'])[1]";
	public static final String Delete_Policy_Btn="//button[text()='Delete']";

	//Checkout

	public static final String Click_Checkout="//div[@id='ReservationDetail']//button[.='Check Out']";
	public static final String Click_Close="//div[@class='header-confirmation']//span[.='Close']/..";


	//swipe

	public static final String Click_Swipe_Icon="//div[@id='ReservationPaymetItemDetail']//img[@title='Swipe']";
	public static final String Enter_Track_Data="//input[contains(@data-bind,'value: txtTrackData')]";
	public static final String Verify_Swipe_Popup="//div[@id='ReservationCreditCardSwipeInfoPopup']//span[.='Please swipe the card:']";

	//Notes

	public static final String	Click_Add_Res_Note="//div[@id='ReservationDetail']//a[contains(@data-bind,'click: addNotes')]";
	public static final String verify_Add_Notes_popup="//div[@id='NotesDetailPopup']//h4[.='Note Details']";
	public static final String Enter_Subject_Notes="//div[@id='NotesDetailPopup']//input[contains(@data-bind,'value: Subject')]";
	public static final String Select_Note_Type="//div[@id='NotesDetailPopup']//select[contains(@data-bind,'value: NoteTypeObj')]";
	public static final String Check_Action_Required="//div[@id='NotesDetailPopup']//input[@data-bind='checked: IsActionRequired']";
	public static final String Select_Notes_Status="//div[@id='NotesDetailPopup']//select[contains(@data-bind,'value: NoteStatusId')]";
	public static final String Enter_Note_Details="//div[@id='NotesDetailPopup']//textarea[contains(@data-bind,'value: NoteDetails')]";
	public static final String Click_Save_Note="//div[@id='NotesDetailPopup']//button[contains(@data-bind,'click: saveDetail')]";
	public static final String Verify_Added_Notes="//div[@data-bind='visible: showNotesList']//tbody[@data-bind='foreach: NoteList']";

	//Get Confirmation Number

	public static final String Get_Confirmation_Number="//span[contains(@data-bind,'ConfirmationNumberString')]";

	//Tapechart

	public static final String Click_Unassigned_Tapechart="(//div[contains(text(),'Unassigned12')])[1]";  //"//div[@class='roomClasses']//div[@class='roomRatesChart'][1]//div[@class='row unassignedrow']//div[@class='col-xs-1']";

	//Account new Reservation button

	public static final String Click_New_Reservation_Account="//div[@class='AccountDetail']//button[.='New Reservation']";

	//CP Account Pay

	public static final String Verify_CP_Lineitem="//div[@id='ReservationDetail']//tbody//tr[contains(@data-bind,'if: $parent.ShouldShowThisItem')][2]//td[@class='lineitem-description']/a";

	//Account House

	public static final String Enter_House_Account_Name="//div[@class='AccountDetail']//input[contains(@data-bind,'value: Account.AccountName')]";
	public static final String Verify_House_Account_Picker="//div[@id='ReservationAccountPicker']//span[.='House Account Picker']";
	public static final String Verify_Gift_Account_popup="//div[@id='ReservationGiftCertificatePickerPopup']//span[.='Gift Certificate Picker ']";
	public static final String Get_Gift_ID="//div[@class='AccountDetail']//input[contains(@data-bind,'value: LedgerAccountDescription')]";
	public static final String Enter_Gift_ID="//div[@id='ReservationGiftCertificatePickerPopup']//input[@data-bind='value: GCNo ']";
	public static final String Click_Go_Gift="//div[@id='ReservationGiftCertificatePickerPopup']//button[contains(@data-bind,'click: Search')]";
	public static final String Enter_Account_Res_Name="//div[@id='ReservationAccountPicker']//input[contains(@data-bind,'value: AccountName')]";
	public static final String Click_Search_House_Acc="//div[@id='ReservationAccountPicker']//button[.='Search']";
	public static final String Verify_House_Account_Grid="//div[@id='ReservationAccountPicker']//table";
	public static final String Verify_Gift_Certificate_Grid="//div[@id='ReservationGiftCertificatePickerPopup']//td[@id='reservationList']//table";
	public static final String Select_Gift_Certificate="//input[@name='GitCertificate']";
	public static final String Select_House_Acc="//div[@id='ReservationAccountPicker']//input[contains(@data-bind,'click: $parent.SelectAccount')]";
	public static final String Click_Select_House_acc="//div[@id='ReservationAccountPicker']//button[.='Select']";
	public static final String Click_Select_Gift="//div[@id='ReservationGiftCertificatePickerPopup']//button[.='Select']";
	public static final String Click_Account_Add="//div[@class='AccountDetail']//a[.='Add']";

	//Navigation to Reservationpage

	public static final String Click_Reservation=".//img[@class='nav-reservation nav_icon']";
	public static final String Verify_Reservation_Page="//div[@id='ReservationSearch']//div[@data-bind='visible: $parent.ShowQuickFilterFields()']";

	//Groups
	public  static final String GroupsNewAccount=".//*[@id='MainContent_btnNew']";
	public static final String AccountFirstName="//*[@id='MainContent_txtAccountFirstName']";
	public static final String MarketingSegment ="//*[@id='MainContent_drpMarketingSegment']";
	public static final String GroupReferral ="//*[@id='MainContent_drpReferral']";
	public static final String SalutationMailing ="//select[@id='MainContent_drpSalutationMailing']";
	public static final String GroupFirstName=".//*[@id='MainContent_txtMailing_contactFirstName']";
	public static final String GroupLastName=".//*[@id='MainContent_txtMailing_contactLastName']";
	public static final String GroupPhn=".//*[@id='MainContent_txtMailing_phoneNumber']";
	public static final String GroupAddress=".//*[@id='MainContent_txtMailing_address1']";
	public static final String GroupCity=".//*[@id='MainContent_txtMailing_city']";
	public static final String Groupstate="//select[@id='MainContent_drpMailing_territoryID']";
	public static final String GroupPostale=".//*[@id='MainContent_txtMailing_postalCode']";
	public static final String Groupscountry="//select[@id='MainContent_drpMailing_countryID']";
	public static final String Mailinginfo=".//*[@id='MainContent_ckUseMailingInfo']";
	public static final String GroupSave="//*[@id='MainContent_btnSave']";
	public static final String Verify_New_Group_Account="//span[@id='MainContent_lblTitle']";
	public static final String Verify_New_Reservation_Enabled=".//*[@id='MainContent_btnNewReservation']";

	//Adv Block Creation

	public static final String Click_New_Block_button=".//*[@id='MainContent_btnNewBlock']";
	public static final String Verify_Block_Details_Popup="//span[.='Block Details']";
	public static final String Enter_Block_Name=".//*[@id='MainContent_txtBlockName']";
	public static final String Click_Ok=".//*[@id='button-OK']";
	public static final String Verify_Rate_Quote=".//*[@id='MainContent_pnlHeadingRateQuote']/font";
	public static final String Select_Arrival_Date_Groups=".//*[@id='trArrive']/td[2]/img";
	public static final String Click_Today_Arrival_Groups="//div[@class='datepicker-days']//th[@class='today']";
	public static final String Enter_No_of_Nigts=".//*[@id='MainContent_txtTotalRooms']";
	public static final String Click_Search_Group=".//*[@id='MainContent_btnNewSearch']";
	public static final String Verify_Room_Class_Grid_Groups=".//*[@id='rateQuoteGridWithPlainKO']/div[1]/table";

	//Adv Group Updated automatically assigned rooms

	public static final String GetBlockedRowsize="//tbody[@data-bind='foreach: serverData.objListRoomClass']//tr/td[3]/input";
	public static final String txtTotalRooms ="txtTotalRooms";
	public static final String GetRoomclasses="//tbody[@data-bind='foreach: serverData.objListRoomClass']//tr/td[1]/span";
	public static final String Click_Create_Block=".//*[@id='MainContent_btnBook']";
	public static final String Verify_Release_Date_Popup="//span[.='Release Date']";
	public static final String Click_Ok_On_Rel_Popup=".//*[@id='btnRelOk']";
	public static final String Verifyroom_block_content="//div[@class='room-block-content']";
	public static final String Verify_Block_Nights="//span[.='Block Room Nights']";
	public static final String Click_Continue_Block_Night=".//*[@id='btnContinue']";
	public static final String CountofRooms="//a[contains(@onclick,'openRoomClassDetails')]";
	public static final String Navigate_Room_Block=".//*[@id='MainContent_btnRoomBlock']";


	//Old Groups

	public static final String oldGroup_startdate="//*[@id='imgDateStartGroup']";
	public static final String oldGroup_numberofNights="//*[@id='MainContent_txtNightGroup']";
	public static final String oldGroup_AccountNumber="//input[@id='MainContent_txtAccountNo']";
	public static final String oldGroup_Today="//table[@class='datepicker-table-condensed table-condensed']//tfoot/tr[1]/th";
	public static final String oldGroup_Adults="//*[@id='MainContent_txtRoomBlockAdults']";
	public static final String old_Gropups_RoomBlockPage="//div[@id='MainContent_pnlRoomBlockAttributes']";
	public static final String old_Groups_Click_Search="//input[@id='MainContent_btnRoomBlockSearch']";
	public static final String GetNumberofclasses="//td[@class='dgText'][2]";
	public static final String oldGroups_Click_Groups=".//*[@id='ucNavSecondary_rptrNavMain_lbtnNavMainItem_4']";
	public static final String oldgroups_Verify_GroupSearchpage="//font[.='Accounts']";
	public static final String oldGroups_Account_Search="//input[@id='MainContent_txtAccountNumber']";
	public static final String oldGroups_Account_ClickGo="//input[@id='MainContent_btnGoSearch']";
	public static final String oldGroups_Account_VerifyAccountNumber="//table[@id='MainContent_dgAccountList']//tr[@class='dgItem']//td[2]";
	public static final String oldGroup_SearchBookicon="//input[@id='MainContent_dgAccountList_imgPickUp_0']";
	public static final String oldGroup_Verify_GroupPickPage=".//*[@id='tdTitle']/font";
	public static final String oldGroup_Click_Roominglistbutton="//input[@id='btnRoomingList']";
	public static final String oldGroup_Verify_Roominglistpopup="//span[.='Rooming List - Pick Up Rooms']";
	public static final String oldGroups_Enter_FirstName_Roominglistpopup="//input[@id='dgRoomingList_txtFirstname_0']";
	public static final String oldGroups_Enter_LastName_Roominglistpoup="//input[@id='dgRoomingList_txtLastName_0']";
	public static final String oldGroups_Select_Roomclass_Roominglistpoup="//select[@id='dgRoomingList_drpRoomClassName_0']";
	public static final String oldGroups_Select_RoomNo_Roominglistpopup="//select[@id='dgRoomingList_drpRoomNo_0']";
	public static final String oldGroups_Select_Pickupbutton_Roominglistpopup="//input[@id='btnPickUp']";
	public static final String oldGroup_Verify_Roominglistsummary="//span[.='Rooming List - Pick Up Summary']";
	public static final String oldgroup_Verify_grid="//table[@id='dgRoomingList']";
	public static final String oldGroup_Click_Close_Roominglistsummary="//input[@id='btnClose']";
	public static final String oldGroup_AccountSearch_Accountnum="//input[@id='MainContent_txtAccountNumber']";


	//	Resell Rooms popup
	public static final String Resell_Rooms_Popup_Header="//h4[.='Resell Rooms']";
	public static final String Resell_Rooms_Popup_Continue_Button="//h4[.='Resell Rooms']//following::button[.='Continue']";


	//Policies
	public static final String Policy_Name_On_Policiespage="//input[contains(@data-bind,'value: policyName')]";
	public static final String Search_On_On_Policiespage ="//button[contains(@data-bind,'goSearchPolicies')]";
	public static final String New_Policy_Btn=".//button[text()='New Policy']";
	public static final String Select_Policy_Type="//select[contains(@data-bind,'policyTypes')]";
	public static final String Enter_Policy_Name="//input[contains(@data-bind,'PolicyName')]";

	public static final String Select_Deposit_Roomcharges_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[1]";
	public static final String Select_Deposit_Fixedamount_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[2]";
	public static final String Select_Deposit_Firstnightrc_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[3]";

	public static final String Select_Noshow_Roomcharges_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[1]";
	public static final String Select_Noshow_Fixedamount_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[2]";
	public static final String Select_Noshow_Firstnightrc_Radiobtn="(.//*[@id='deposit']//input[@type='radio'])[3]";


	public static final String Select_Checkin_Roomcharges_Radiobtn="(.//*[@id='checkin']//input[@type='radio'])[1]";
	public static final String Select_Checkin_Fixedamount_Radiobtn="(.//*[@id='checkin']//input[@type='radio'])[2]";
	public static final String Select_Checkin_Firstnightrc_Radiobtn="(.//*[@id='checkin']//input[@type='radio'])[3]";

	public static final String Select_Roomcharges_Type_for_Deposit=".//*[@id='deposit']//select";
	public static final String Select_Roomcharges_Type_for_Cancellation=".//*[@id='cancellation']//select";
	public static final String Select_Roomcharges_Type_for_Noshow=".//*[@id='noShow']//select";


	public static final String Enter_Deposit_Percentage_Charges="(.//*[@id='deposit']//input[@type='text'])[1]";
	public static final String Enter_Deposit_Fixed_Amount="((.//*[@id='deposit']//div[@class='form-group'])[2]//input[@type='text'])[1]";
	public static final String Enter_Deposit_First_Nights_RC="((.//*[@id='deposit']//div[@class='form-group'])[3]//input[@type='text'])[1]";
	public static final String Enter_Noshow_Percentage_Charges="(.//*[@id='noShow']//input[@type='text'])[1]";
	public static final String Enter_Noshow_Fixed_Amount="((.//*[@id='noShow']//div[@class='form-group'])[2]//input[@type='text'])[1]";
	public static final String Enter_Noshow_First_Nights_RC="((.//*[@id='noShow']//div[@class='form-group'])[3]//input[@type='text'])[1]";


	// Guest Services
	public static final String Guest_Services_Main_Menu="//img[@class='nav-guest-services nav_icon']";
	public static final String Guest_Services_Menu_Title="//font[.='Guest Services Menu']";
	public static final String Select_Items_Per_Page=".//select[@id='MainContent_ddlItemsPerPage']";
	public static final String Select_Rmcondition_In_Theader="//tr[@class='dgHeader']//input[@type='radio']"; ////tr[@class='dgHeader']//label[text()='Clean']/../input
	public static final String Save_Housekeeping_Status =".//*[@id='MainContent_btnSave']";

	public static final String Housekeeping_Status_Title="//font[.='Housekeeping Status']";

	public static final String Menuitem_Policy_Text=".//a[text()='Policies' and @class='MenuItem']";

	public static final String Cancel_Reservation_Icon="//a[@title='Cancel']//i";
	public static final String Cancel_Res_Popup="//h4[text()='Cancellation']";
	public static final String Cancel_Reason_Txtarea="//h4[text()='Cancellation']/../..//*[@data-bind='value: cancelreason']";
	public static final String VoidRC_Chkbox_In_Popup="//label[text()='Void Room Charges']/preceding-sibling::input";
	public static final String Cancel_Res_Popup_Ok_Btn="//h4[text()='Cancellation']/../..//button[text()='OK']";


	public static final String Close_Tab_Btn=".//span[text()='Auto Guest']/following-sibling::i";
	public static final String AlertForTab="//div[@id='alertForTab']//h4";
	public static final String AlertForTab_Yes_Btn="//div[@id='alertForTab']//button[text()='Yes']";


	public static final String Select_Delete="//span[.='Delete']";
	public static final String Verify_Bulk_Delete_popup="//h4[.='Bulk Delete']";
	public static final String Verify_Bulk_Delete_Completed="//h4[.='Bulk Delete Completed']";
	public static final String Search_Results_Alert_Msg="//div[@class='alert alert-warning']";

	public static final String Verify_Res_Number="//div[@id='tab1']//span[contains(@data-bind,'text: ConfirmationNumber')]";

	//Guest History

	public static final String Accountype_Label=".//*[@class='form-group']/label[contains(text(),'Account Type:')]";
	public static final String reservation_Menu="(//span[.='Reservations'])[2]";
	public static final String reservation_mainMenu="(//ul[@class='nav_des']/li/a)[1]";
	public static final String clickNewReservationButton="//a[contains(@data-bind,'click: NewReservation')]";
	public static final String newAccount="//button[contains(text(),'New Account')]";
	public static final String selectAccountSalutation="(//select[contains(@data-bind,'options: $root.SaluationArray')])[1]";
	public static final String accountFirstName="//input[contains(@data-bind,'value: Account.AccountFirstName')]";
	public static final String accountNumber="//label[text()='Account #:']/following-sibling::div/input";
	public static final String accountSince="//input[contains(@data-bind,'dateField')]";
	public static final String closeReservation="(//i[contains(@data-bind,'click: $parent.closeTab')])[6]";
	public static final String guestHistoryAccountNo="(//span[contains(@data-bind,'text: AccountNoToDisplay')])[1]";
	public static final String enterAccountFName="(//input[contains(@data-bind,'value: AccountFirstName')])[1]";
	public static final String enterGuestHistoryAccountNo="(//input[contains(@data-bind,'value: AccountNumber')])[2]";
	public static final String clickSearchButton="//button[contains(@data-bind,'click: GetAccountsList')]";
	public static final String selectGuestHistoryAccount="(//input[contains(@data-bind,'checked: DeleteAccount')])[1]";
	public static final String deleteButton="(//button[.='Delete'])[1]";
	public static final String newReservationButton="//button[.='New Reservation']";
	public static final String clickReservation="(//a[contains(@data-bind,'text: GuestName')])[1]";
	public static final String findGuestProfile="//input[contains(@placeholder,'Find Guest Profile')]";
	public static final String clickEditButton="//a[contains(@data-bind,'visible: ($parent.FrequentGuestId()')]";
	public static final String selectGuest="(//a[contains(@class,'ui-menu-item-wrapper')])[1]";
	public static final String continueButton="//div[@id='ReservationAccountPickerConfirmationPopup']/span/div/div/div/button[contains(text(),'Continue')]";
	public static final String reservation_Save="(//button[contains(text(),'Save')])[2]";
	//Statements

	public static final String Account_Statement_Tab =".//*[@id='MainContent_btnAccountStatement']";

	//Travel Agent Items

	public static final String Travel_Agent_Items_Title="//font[.='Travel Agent Items']";

	// Management Items

	public static final String Management_Items_Title="//font[.='Management Items']";


	// Account Distributions

	public static final String Account_Distributions_Title="//font[.='Account Distributions']";

	// Task List

	public static final String Task_List_Title="//font[.='Task List']";

	// Room Maintenance

	public static final String Room_Maintenance_Fromdate=".//*[@id='MainContent_txtDateStart']";


	// Inventory

	public static final String Inventory_Menu_Title="//font[.='Inventory Menu']";


	// Overview

	public static final String Inventory_Overview=".//*[@id='MainContent_lnkInventoryOverview']";
	public static final String Edit_Rate="//td[@class='EditRateTitle']/input";
	public static final String Iframe_Id_Of_Rates_Override_Info_Popup="MainContent_ifrmRateOverrideInfo";
	public static final String Rates_Override_Info_Popup=".//*[@id='tdTitle']/font[.='Rates Override Info']";
	public static final String First_Roomclass_P1_Rate="((.//tr[contains(@id,'UcRateOverrideInfo')])[1]//td/input)[1]";
	public static final String Save_Btn_In_Rates_Override_Info_Popup=".//*[@id='btnUpdate']";
	public static final String Done_Btn_In_Rates_Override_Info_Popup=".//*[@id='btnDone']";
	public static final String Cancel_Btn_In_Rates_Override_Info_Popup=".//*[@id='btnCancel']";
	public static final String Get_Rack_Rate="//table[@id='QA Property']/tbody/tr[3]/td[3]/nobr";


	//Season 
	public static final String New_Season_Btn="//button[contains(text(),'New Season')]";

	// Rates
	public static final String click_Inventory="//ul/li/a/span[contains(text(),'Inventory')]";
	public static final String Rates_Title="//font[.='Rates']";
	public static final String inventory_rate="//a[@id='ucNavSecondary_rptrNavMain_lbtnNavMainItem_2']";
	public static final String newRate="//input[@id='MainContent_btnNew']";
	public static final String rateName="//input[@id='MainContent_txRateName']";
	public static final String ratePlan="//select[@id='MainContent_drpRatePlan']";
	public static final String selectDerivedRate="//input[@id='MainContent_rblstRateTypes_3']";
	public static final String selectPackageRatePlan="//input[@id='MainContent_rblstRateTypes_2']";
	public static final String getRateType="//label[contains(text(),'Rooms Only')]";
	public static final String getRateType3="//label[contains(text(),'Package')]";
	public static final String getRateType4="//label[contains(text(),'Derived Rates')]";
	public static final String getPackageComponents="(//label[contains(text(),'Bundle')])[1]";

	public static final String clickPackageAddButton="//input[@id='MainContent_btnAddComponents']";
	public static final String packageComponentDescription="//input[@id='MainContent_dgRateComponents_txtDisplaycaption_0']";
	public static final String packageCalculationMethod="//select[@id='MainContent_dgRateComponents_drpCalculationMethod_0']";
	public static final String enterPackageAmount="//input[@id='MainContent_dgRateComponents_txtComponentAmount_0']";
	//"//input[contains(@class,'RAlignText')]";
	//"//input[@id='MainContent_dgRateComponents_txtComponentAmount_0']";
	public static final String selectPackageCategory="//select[@id='MainContent_dgRateComponents_drpCategory_0']";
	public static final String clickPackageAssociateRate="//input[@id='MainContent_btnAssociateRate']";
	public static final String selectRateInPackage="//input[@id='MainContent_dgRatesList_chkSelected_0']";
	public static final String clickPackageSelectButton="//input[@id='MainContent_btnSelect']";
	//"//input[@id='MainContent_dgRatesList_chkSelected_0']";
	//"//a[contains(text(),'Junior Suites')]/ ../preceding-sibling::td/span/input";



	public static final String maxAdults="//input[@id='MainContent_txtMaxAdults']";
	public static final String maxPersons="//input[@id='MainContent_txtMaxPersons']";
	public static final String baseAmount="//input[@id='MainContent_txtAmount']";
	public static final String selectDerivedRatePlan="//select[@id='MainContent_drpDerivedFromRateplan']";
	public static final String offsetAmount="//input[@id='MainContent_txtOffsetAmount']";
	public static final String additionalAdult="//input[@id='MainContent_txtAddedAdultsAmt']";
	public static final String additionalChild="//input[@id='MainContent_txtAddedPersonAmt']";
	public static final String rate_displayName="//input[@id='MainContent_txtDisplayName']";
	public static final String rate_policy="//textarea[@id='MainContent_txtRatePolicy']";
	public static final String rate_description="//textarea[@id='MainContent_txtRateDescription']";
	public static final String rate_Associate_Seasons="//input[@id='MainContent_btnEditSeasons']";	
	public static final String click_All_Seasons="//input[@id='btnPickAll']";
	public static final String doneButton="//input[@id='btnSave']";
	public static final String rate_Associate_RoomClasses="//input[@id='MainContent_btnEditRoomClasses']";
	public static final String click_All_RoomClasses="//input[@id='btnPickAll']";
	public static final String rate_Associate_Sources="//input[@id='MainContent_btnAssociateSource']";
	public static final String rate_select_Source="//input[@id='dgSourceList_chkSelectSource_0']";
	public static final String rate_Save_Button="//input[@id='MainContent_btnSave']";
	public static final String rate_done_button="//input[@id='MainContent_btnDone']";
	public static final String selectBaseRate="//a[contains(text(),'newbaserate')]/../preceding-sibling::td/span/input";
	public static final String selectDRate="//a[contains(text(),'newderivedrate')]/../preceding-sibling::td/span/input";
	public static final String selectPRate="//a[contains(text(),'newPackage')]/ ../preceding-sibling::td/span/input";
	public static final String click_goButton="//input[@id='MainContent_btnGoSearch']";
	public static final String deleteRate="//input[@id='MainContent_btnDelete']";


	//Rules
	public static final String New_Rule_Btn="//button[contains(text(),'New Rule')]";
	public static final String click_Rules="(.//a[.='Rules'])[1]";
	public static final String Click_newRule_Btn=".//*[@id='bpjscontainer_19']//button[contains(@data-bind,'click: createNewRule')]";
	public static final String Enter_ruleName="//input[contains(@data-bind,'RuleName')]";
	public static final String Select_ruleType="(//select[contains(@data-bind,'options')])[4]";
	public static final String Enter_ruleDescription="//textarea[contains(@data-bind,'RuleDescription')]";
	public static final String click_effectiveOnAsMonday="(//input[@type='checkbox'])[1]";
	public static final String click_effectiveOnAsTuesday="(//input[@type='checkbox'])[2]";
	public static final String click_associateSeasons="//button[contains(text(),'Associate Seasons')]";
	public static final String get_unassignedSeasons_list="(//select[@class='form-control'])[11]";
	public static final String click_associateSeasons_assignAll="//button[@data-bind='click: AssignAll']";
	public static final String get_assignedSeasons_list="(//select[@class='form-control'])[12]";
	public static final String click_associateSeasons_doneButton="(//button[@data-bind='click: Done'])[3]";
	public static final String click_associateRoomclass="//button[contains(text(),'Associate Room Classes')]";
	public static final String click_associateRoomclass_assignAll=".//*[@id='roleModal']//button[contains(@data-bind,'click: AssignAll')]";
	public static final String click_associateRoomclass_doneButton=".//*[@id='roleModal']//button[contains(@data-bind,'click: Done')]";
	public static final String click_associateSources="//button[contains(text(),'Associate Sources')]";
	public static final String click_associateSources_assignAll=".//*[@id='roleModal']//button[contains(@data-bind,'click: AssignAll')]";
	public static final String click_associateSources_doneButton=".//*[@id='roleModal']//button[contains(@data-bind,'click: Done')]";
	public static final String click_associateRatePlans="//button[@data-bind='click: OpenRatePlanPopup, enable: !isSaving()']";
	public static final String click_associateRatePlans_assignAll=".//*[@id='roleModal']//button[contains(@data-bind,'click: AssignAll')]";
	public static final String click_associateRatePlans_doneButton=".//*[@id='roleModal']//button[contains(@data-bind,'click: Done')]";
	public static final String Click_saveButton=".//*[@id='bpjscontainer_22']//button[contains(@data-bind,'click: saveRuleDetail')]";
	public static final String Message_newRuleCreated="//div[contains(text(),'Successfully Created Rule')]"; 
	public static final String Click_closeTab="(//i[contains(@data-bind,'click: $parent.closeTab')])[7]";
	public static final String Click_searchButton="(.//*[@id='bpjscontainer_20']//button[@class='btn blue m-icon marT5'])[2]";
	public static final String selectRule="//a[contains(text(),'newRule')]/../following::td[4]/input";
	public static final String rule_clickDeleteButton="//button[contains(text(),'Delete')]";

	// Distribution

	public static final String Table_Text=".//span[text()='innCenter']";
	public static final String clickDistributionMenu="//a[@id='ucNavSecondary_rptrNavMain_lbtnNavMainItem_4']";
	public static final String propertySelectionAlert="(//button[.='OK'])[2]";
	public static final String selectProperty="//div[@id='s2id_autogen1']";
	public static final String distribute="(//input[@type='checkbox'])[1]";
	//".//*[@id='MainContent_dgDistributionChannelList_chkIsSelected_0']";
	//".//*[@id='bpjscontainer_21']/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[5]/input";
	//"//input[@id='MainContent_dgDistributionChannelList_chkIsSelected_0']";
	public static final String defaultStatus="(//select[contains(@data-bind,'enable: IsSelected()')])[1]";
	//".//*[@id='MainContent_dgDistributionChannelList_drpStatus_0']";
	//"//select[@id='MainContent_dgDistributionChannelList_drpStatus_0']";
	public static final String clickSaveButtonDistribution="//button[.='Save']";
	//".//*[@id='MainContent_btnSave']";
	//"//input[@id='MainContent_btnSave']"; 
	public static final String Syndication_Month_Label="//span[@class='monthLabel']";
	public static final String BlackOuts_Source_Label="//label[text()='Source:']";
	public static final String Save_SourceReservationDetails="(//button[.='Save'])[4]";



	//Setup

	public static final String Setup_Menu_Title="//font[.='Setup Menu']";

	//Properties
	public static final String Properties_Title ="//font[.='Properties']";

	//Room Classes

	public static final String New_RoomClass_Btn ="//button[contains(text(),'New Room Class')]";

	//Tax Items
	public static final String Tax_Items_Title ="//font[.='Tax Items']";

	//Ledger Accounts

	public static final String Ledger_Accounts_Title ="//font[.='Ledger Accounts']";

	//Merchant Services

	public static final String Merchant_Services_Title ="//font[.='Merchant Services']";


	//Document Templates

	public static final String Document_Templates_Title ="//font[.='Document Templates']";

	//List Management

	public static final String List_Management_Title ="//font[.='List Management']";


	//Admin

	public static final String Admin_Menu_Title ="//font[.='Admin Menu']";

	//Clients

	public static final String Clients_Title ="//font[.='Clients']";

	// Users

	public static final String New_User_Btn ="//button[.='New User']";

	//Roles
	public static final String New_Role_Btn ="//button[.='New Role']";

	//Night Audit
	public static final String Period_Status_Title ="//font[.='Period Status']";

	//Reports

	public static final String Reports_Menu_Title ="//font[.='Reports Menu']";

	// Account Balance Summary 
	public static final String Account_Balance_Summary_Title ="//font[.='Account Balance Summary']";

	// Ledger Balances 
	public static final String Ledger_Balances_Title ="//font[.='Ledger Balances']";

	// Merchant Transactions
	public static final String Merchant_Transaction_From_Date_Feild =".//*[@id='MainContent_txtTransactionsDate']";

	//Deposit
	public static final String Deposit_Title ="//font[.='Advance Deposits']";

	// Daily Flash

	public static final String Daily_Flash_From_Date_Feild =".//*[@id='MainContent_TxtDailyDate']";

	// Room Forecast Report 
	public static final String Room_Forecast_From_Date_Feild=".//*[@id='MainContent_txtFromDate']";

	//Net Sales
	public static final String Net_Sales_Title ="//font[.='Net Sales']";


	public static final String Click_Continue_Deposit="//div[@aria-hidden='false']//button[.='Continue']";

	public static final String Click_Folio_Options="//span[@class='subTab']//a[text()='Folio Options']";

	public static final String Select_Account_Checkin_Policy="//label[text()='Check In Policy:']//following-sibling::div//select";

	public static final String Acc_Picker_Confirm_Continue_Btn=".//*[@id='ReservationAccountPickerConfirmationPopup']//button[text()='Continue']";

	public static final String Associated_AccountName=".//a[contains(@data-bind,'Accountname')]";
	public static final String Acc_Picker_Confirm=".//*[@id='ReservationAccountPickerConfirmationPopup']//h4";

	//PaymentInfo_Popup or Billing_Info_Popup
	public static final String Click_Show_PaymentInfo="//a[contains(@data-bind,'fnShowPaymentInfo')]";
	public static final String Folio_Billing_Info_Popup="//h4/span[.='Folio Billing Information']";
	public static final String Select_Salutation_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//select[contains(@data-bind,'parent.SaluationList')]";
	public static final String Enter_First_Name_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[@placeholder='First Name']";
	public static final String Enter_Last_Name_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[@placeholder='Last Name']";
	public static final String Enter_Phone_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//label[.='Phone:']/..//input[@placeholder='Number']";
	public static final String Enter_AltPhone_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//label[.='Alternate Phone:']/..//input[@placeholder='Number']";
	public static final String Enter_Email_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//label[.='Email:']/..//input[@placeholder='example@example.com']";
	public static final String Enter_Line1_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'MailingAddress1')]";
	public static final String Enter_Line2_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'MailingAddress2')]";
	public static final String Enter_Line3_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'MailingAddress3')]";
	public static final String Enter_City_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'City')]";
	public static final String Select_Country_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//select[contains(@data-bind,'CountryList')]";
	public static final String Select_State_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//select[contains(@data-bind,'StateList')]";
	public static final String Enter_Postal_Code_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'PostalCode')]";


	public static final String Select_Payment_Method_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//select[contains(@data-bind,'BillingTypeList')]";
	public static final String Enter_Account_Number_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@placeholder,'Account Number')]";
	public static final String Enter_CardExpiryDate_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'CardExpiryDate')]";
	public static final String Enter_BillingNotes_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//input[contains(@data-bind,'BillingNotes')]";
	public static final String Save_Btn_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//button[text()='Save']";
	public static final String Cancel_Btn_PaymentInfo_Popup="//div[@id='ReservationPaymetInfoDiv']//button[text()='Cancel']";
	public static final String Payment_Info_Textarea="//textarea[@data-bind='value: PayDetails']";	


	public static final String First_RC_Line_Item_Desc="(//span[text()='Room Charge']/../following-sibling::td[contains(@data-bind,'lineitem-description')]/a)[1]";
	public static final String First_RC_Line_Item_Amount="(//span[text()='Room Charge']/../following-sibling::td[@class='lineitem-amount']/span)[1]";
	public static final String Item_Details_Popup="//h4[.='Item Detail']";
	public static final String RC_Link_In_Item_Details_Popup ="//div[@data-bind='getElement: popUp']//span[text()='Room Charge']/../following-sibling::td/a";
	public static final String Sales_Tax_Link_In_Item_Details_Popup="//div[@data-bind='getElement: popUp']//span[text()='Sales Tax']/../following-sibling::td/a";
	public static final String Tax_Item_Details_Popup="//h4[text()='Tax Item Details']";
	public static final String Display_Name_In_Tax_Item_Details_Popup="//div[@id='popUpForInnroad']//label[text()='Display Name:']";

	public static final String Total_Charges_In_Item_Details_Popup="//div[@data-bind='getElement: popUp']//span[contains(@data-bind,'TotalSummary')]";
	public static final String Item_Details_Popup_Cancel_Btn="//div[@data-bind='getElement: popUp']//button[@data-dismiss='modal' and text()='Cancel']";
	public static final String Include_Taxes_in_Line_Items_Checkbox="//input[contains(@data-bind,'IncludeTaxesInLineItems')]";

	public static final String Rate_Details_Popup="//h4[.='Rate Details']";
	public static final String Rate_Name_In_Rate_Details_Popup="//div[@id='popUpForInnroad']//label[text()='Rate Name:']";
	public static final String Rate_Details_Popup_Cancel_Btn="//div[@id='popUpForInnroad']//button[@data-dismiss='modal' and text()='Cancel']";

	//New Reservations
	public static final String NewRervations="//span[contains(text(),'New Reservations')]";

	//Guest Info
	public static final String GuestInfo="//a[contains(text(),'Guest Info')]";

	//Edit Folio
	public static final String Edit_Folio_Btn="//img[@title='Edit Folio']";

	//Delete Folio
	public static final String Delete_Folio_Btn="//img[@title='Delete Folio']";

	// Folio

	public static final String MoveFolio_Folio="//a[contains(text(),'Folio')]";

	// Guset Folio
	public static final String MoveFolio_GuestFolio="//select[@class='form-control folioFil']";

	//New Folio
	public static final String MoveFolio_NewFolio="//img[@title='New Folio']";

	//Folio Details
	public static final String MoveFolio_NewFolioDeatils="//h4[contains(text(),'Folio details')]";

	// New Folio Name
	public static final String MoveFolio_NewFolio_Name="//label[contains(text(),'Name:  ')]/following::div/input";

	//New Folio Description
	public static final String MoveFolio_NewFolio_Description="//label[contains(text(),'Description:')]/following::div/textarea";

	//New Folio Close
	public static final String MoveFolio_NewFolio_Close="(//button[contains(text(),'Close')])[10]";

	//New Folio Save
	public static final String MoveFolio_NewFolio_Save="(//button[contains(text(),'Save')])[7]";

	//New Folio Save Reservation
	public static final String MoveFolio_NewFolio_SaveReservation="(//button[contains(text(),'Save')])[2]";

	//New Folio select folio item
	public static final String MoveFolio_SelectFiloItem="//table[@class='table table-striped table-bordered table-hover trHeight25']/tbody/tr/td[1]/input";


	//New Folio Move
	public static final String MoveFolio_Move="//button[contains(text(),'Move')]";

	//Target Folio
	public static final String MoveFolio_TargetFolio="//select[@data-bind='value: $root.selectedFolioId']";

	//Select Folio Item to move in pop up

	public static final String MoveFolio_FolioItemToMove="//table[@class='table  table-hover']/tbody/tr/td";

	//Move Selected Item
	public static final String MoveFolio_MoveSelectedItem="//button[@data-bind='click: MoveItemsToTarget, enable: SelectedFolio']";

	//close on move folio pop up
	public static final String MoveFolio_Close="//div[@id='moveFolioItemsModal']/div[3]/button";

	//************************* Room Class **********************************

	//Room Class Details
	public static final String New_RoomClass_Deails="//div[contains(text(),'Room Class Details')]";

	//New Room Class Name

	public static final String New_RoomClass_Name="//input[@placeholder='Room Class Name']";

	//New Room Class Abbrivation
	public static final String New_RoomClass_Abbrivation="//input[@placeholder='Room Class Abbreviation']";

	//New Room Class King Beds

	public static final String New_RoomClass_KingBeds="//h4[contains(text(),'King')]/following::div/input";

	//New Room Class Room Type

	public static final String New_RoomClass_RoomType_AdjoiningRooms="//span[contains(text(),'Adjoining rooms')]/../preceding-sibling::span/input";

	//New Room Class Rooms

	public static final String New_RoomClass_Rooms="//a[contains(text(),'Rooms')]";


	//New Room Class Max Adutls

	public static final String New_RoomClass_Max_Adults="//label[contains(text(),'Max Adults')]/following::div/input";

	//New Room Class Max persons

	public static final String New_RoomCLass_Max_Persons="//label[contains(text(),'Max Persons')]/following::div/input";

	//New Room Class Room Quantity

	public static final String New_RoomClass_Room_Quantity="//label[contains(text(),'Room Quantity')]/following::div/input";

	//New Room Class Create Rooms

	public static final String New_RoomClass_Create_Rooms="//button[@data-bind='click: createRooms']";


	//New Room Class Room Number
	public static final String New_RoomClass_RoomNumber="//table/tbody/tr/td[2]/input";

	//New Room Class Assign Rooms

	public static final String New_RoomClass_AssignRoomNumber="//button[@class='btn blue disableForClientUser']";

	//New Room Class Save

	public static final String New_RoomClass_Save="(//button[contains(text(),'Save')])[2]";

	//New Room Class publish

	public static final String New_RoomClass_Publish="//button[contains(text(),'Publish')]";

	//New Room Class OK

	public static final String New_RoomClass_OK="(//button[contains(text(),'OK')])[2]";

	//New Room classes
	public static final String New_RoomClasses="//span[contains(text(),'Room Classes')]";

	//New Room Classes msg After Publish

	public static final String New_RoomClass_Msg_Publish="//div[@id='toast-container']/div/div[2]";


	public static final String Click_First_Quote_Icon="//tr[@rowtype='RoomClassHeader']/following-sibling::tr[1]//td[contains(@id,'td_Action')]/button[1]";
	public static final String Get_QuoteReservation_Status="(//label[contains(text(),'Reservation Status:')]/following-sibling::div/select)";

	public static final String Click_Book_Reservation="//button[contains(text(),'Book')]";

	public static final String Check_Split_Rooms="//label[contains(text(),'Split Rooms:')]/input";

	public static final String Get_Notes="//table[@class='table table-striped table-bordered table-hover resGrid1']/tbody/tr";

	//First opened reservation

	public static final String FirstOpenedReservation="//div[@class='sec_nav_in container']/ul/li[6]/a/span[3]";

	//First opened reservation close
	public static final String FirstOpenedReservationClose="//div[@class='sec_nav_in container']/ul/li[6]/a/i";

	//Room Charges 
	public static final String Room_Charges="//label[contains(text(),'Room Charges:')]/following-sibling::span/span";

	//Incidentals
	public static final String Incidentals="//label[contains(text(),'Incidentals:')]/following-sibling::span/span";

	//Taxes and Service charges
	public static final String TaxesAndServiceCharges="//label[contains(text(),'Taxes & Service Charges:')]/following-sibling::span/span";

	//Total Charges
	public static final String TotalCharges="//label[contains(text(),'Total Charges:')]/following-sibling::span/span";

	//Tax exempt this field is required
	public static final String TaxExemptThisFieldIsdRequired="//span[contains(text(),'This field is required.')]";

	//Add incidentals

	//Add

	public static final String AddIncidental="//button[contains(text(),'Add')]";

	//Incidental category
	public static final String IncidentalCategory="//td[@class='lineitem-category']/select";

	//Incidental Amount
	public static final String IncidentalAmount="//input[@class='form-control fgInpFx']";

	//commit
	public static final String Commit="//button[contains(text(),'Commit')]";

	//Reservations sublink

	public static final String Reservations="(//span[contains(text(),'Reservations')])[2]";

	//Tax Creation

	//New Tax Item
	public static final String TaxNewItem="//input[@id='MainContent_btnNew']";

	//Item Name
	public static final String TaxItemName="//td[contains(text(),'Item Name:')]/following-sibling::td/input";

	//Display Name
	public static final String TaxDispalyName="//td[contains(text(),'Display Name:')]/following-sibling::td/input";

	//Description
	public static final String TaxDescription="//td[contains(text(),'Description:')]/following-sibling::td/textarea";

	//Tax Value
	public static final String TaxValue="//input[@id='MainContent_txtTaxItemValue']";

	//Tax exempt
	public static final String ExcludeTaxExempt="//input[@id='MainContent_chkTaxExempt']";

	//Tax Percent
	public static final String TaxPercent="//input[@id='MainContent_chkIsPercent']";

	//Tax category
	public static final String taxCategory="//select[@id='MainContent_drpCategory']";


	//Tax associate
	public static final String TaxAssociate="//input[@id='MainContent_btnEditTaxes']";

	//Tax Ledger Account pick po up

	public static final String TaxLedgerAccountPopup="//td[@id='tdTitle']/font[contains(text(),'Ledger Account Picker')]";

	//Tax Pick one
	public static final String TaxPickOne="//input[@id='btnPickOne']";

	//String Save/Done LergerAccount
	public static final String TaxLaedgerAccountDone="//input[@id='Button1']";

	// Tax Done
	public static final String TaxDone="//input[@id='MainContent_btnDone']";

	public static final String Processed_Amount_In_Paymentdetails_Popup="(//tbody[contains(@data-bind,' PaymentItemsArray')]//td[@class='text-right'])[1]/span";


	//Continue in Cash Pay
	public static final String Folio_Cash_Continue_Btn="//span[contains(text(),'Payment Details')]/../../../../following-sibling::div/div/div/button[contains(text(),'Continue')]";//span[contains(text(),'Payment Details')]/../../../../following-sibling::div/div/div/button[contains(text(),'Continue')]";


	//Enter Corp Acc Name
	public static final String Account_CorpAccountName="//input[@placeholder='Account Name']";

	public static final String Account_AutoApply="(//button[contains(text(),'Auto Apply')])[2]";

	//Folio Balance
	public static final String Folio_Balance="//div[@class='col-md-12 payInfoSection boldFx']/div/div/label[contains(text(),'Ending Balance:')]/following-sibling::span/span";
	
	//Number of Accounts
	public static final String Number_Of_Accounts="//table[@class='table table-striped table-bordered table-hover']/tbody/tr";
	
	//Account Type
	public static final String Account_Type="(//select[contains(@data-bind,'AccountTypeName')])[2]";

	//Account Name
	public static final String Account_Name="//label[contains(text(),'Account Name:')]/following-sibling::div/input";

	//Accuont #
	public static final String Account_Number="(//input[@data-bind='value: AccountNumber'])[2]";

	//Account Search
	public static final String Account_Search="//button[@data-bind='click: GetAccountsList']";
	
	
	//******************************* Groups **********************************

	//New Account
	public static final String New_Account_Btn="//input[@id='MainContent_btnNew']";

	//Group Name
	public static final String Group_Name="//input[@id='MainContent_txtAccountFirstName']";

	//Market Segment
	public static final String Market_Segment="//select[@id='MainContent_drpMarketingSegment']";

	//Referrals
	public static final String Referrls="//select[@id='MainContent_drpReferral']";

	//FirstName
	public static final String FirstName="//input[@id='MainContent_txtMailing_contactFirstName']";

	//LAst Name
	public static final String LastName="//input[@id='MainContent_txtMailing_contactLastName']";

	//Phone
	public static final String Phone="//input[@id='MainContent_txtMailing_phoneNumber']";

	//Address
	public static final String Address1="//input[@id='MainContent_txtMailing_address1']";

	//City
	public static final String City="//input[@id='MainContent_txtMailing_city']";

	//Country
	public static final String Country="//select[@id='MainContent_drpBilling_countryID']";


	//State
	public static final String State="//select[@id='MainContent_drpMailing_territoryID']";

	//Postalcode
	public static final String PostalCode="//input[@id='MainContent_txtMailing_postalCode']";

	//Mailing Info
	public static final String Check_Mailing_Info="//input[@id='MainContent_ckUseMailingInfo']";


	//Save
	public static final String Group_Save="//input[@id='MainContent_btnSave']";

	//Folio
	public static final String Group_Folio="//input[@id='MainContent_btnFolio']";

	//Add
	public static final String Group_Folio_Add_LineItem="//input[@id='MainContent_Folio1_btnAdd']";

	//Add Line Item
	public static final String Group_Folio_Commit_Lineitem="//input[@id='MainContent_Folio1_btnDone']";

	//Pay Buttom
	public static final String Group_Folio_Pay="//input[@id='MainContent_Folio1_btnPay']";

	//Card Info
	public static final String Group_Folio_CardInfo="//input[@id='btnCardInfo']";

	//Payment Method
	public static final String  Group_Folio_PaymentMethod="//select[@id='drpPaymentMethod']";

	//Name on card
	public static final String  Group_Folio_NameOnCard="//input[@id='txtNameOnCard']";

	//Card Number
	public static final String  Group_Folio_CardNumber="//input[@id='txtCreditCardNo']";

	//Exp Date
	public static final String  Group_Folio_ExpDate="//input[@id='txtExpdate']";

	//CVV
	public static final String  Group_Folio_CVV="//input[@id='txtCVVCode']";

	//OK
	public static final String  Group_Folio_OK="//input[@id='btnOK']";

	//Auth type
	public static final String  Group_Folio_AuthType="//select[@id='drpAuthType']";

	//Amount
	public static final String  Group_Folio_Amount="//input[@id='txtAmount']";

	//Process
	public static final String  Group_Folio_Process="//input[@id='btnAgingProcess']";

	//Continue
	public static final String  Group_Folio_Continue="//input[@id='btnSaveTranPay']";

	//Ending Balance
	public static final String  Group_Folio_EndingBalance="//span[@id='MainContent_Folio1_fSummary1_lblAccEndBalance']";

	//Add
	public static final String  Group_Folio_Add="//input[@id='btnAgingAdd']";

	//Group Auto Apply
	public static final String  Group_Folio_AutoApply="//input[@id='btnAutoApplyPayment']";
	
	//Advance deposit
	public static final String  Group_Folio_AdvanceDeposit="//a[@id='MainContent_Folio1_fSummary1_lbtnDisplaycaption']";
	
	//Advance deposit Add
	public static final String  Group_Folio_AdvanceDepositAdd="//input[@id='btnAgingAdd']";

	//Advance deposit AutoApply
	public static final String  Group_Folio_AdvanceDepositAutoApply="//input[@id='btnAutoApplyPayment']";
	
	//Advance deposit Continue
	public static final String  Group_Folio_AdvanceDepositContinue="//input[@id='btnSaveTranPay']";
	
	
}
