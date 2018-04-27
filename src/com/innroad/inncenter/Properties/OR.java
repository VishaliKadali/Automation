package com.innroad.inncenter.properties;

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
	public static final String Inventory="head_inventory";
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
	
	
	//Reservation page
	
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
	public static final String Enter_Rate_Promocode="//input[contains(@data-bind,'RatePromoCode')]";
	public static final String Check_Assign_Room="//input[contains(@data-bind,'AssignRoomsEnabled')]";
	public static final String Click_Search="//button[contains(@data-bind,'SearchBtnClick')]";
	public static final String Validation_Text_NoRooms="//div[.='Room Classes are not available for the search criteria. Please change the criteria and try again']";
	public static final String Select_property_RoomAssign="//select[contains(@data-bind,'SelectedProperty')]";
	public static final String Select_property_RoomAssign2="//div[@id='modalRoomPickerReservation']//select[contains(@data-bind,'SelectedProperty')]";
	public static final String Verify_Room_Grid="//div[@id='divPickRoomGrid']";
	public static final String Select_Room_Class="//tbody//select[contains(@data-bind,'RoomClassId')]";
	public static final String Select_Room_Number="//tbody//select[contains(@data-bind,'RoomId')]";
	public static final String Validating_UnAssgined_DDL="//tbody[@data-bind='foreach: RoomListWithRules']//td[3]/select[contains(@disabled,'')]";
	public static final String Click_Select="//*[@id='modalRoomPickerReservation']/div[3]/div//button[.='Select']";
	public static final String Verify_RulesBroken_Popup=".//*[@id='myModalLabelforRuleMessage']";
	public static final String Click_Continue_RuleBroken_Popup="//button[contains(@data-bind,'isOverRideAllowed(), text: btnContinue')]";
	public static final String Verify_Toaster_Container="//div[@id='toast-container']";
	public static final String Toaster_Title="//div[@class='toast-title']";
	public static final String Toaster_Message="//div[@class='toast-message']";
	public static final String Get_Property_Name="//*[@id='StayInfo']//following-sibling::label[.='Property:']//following-sibling::div/p";
	public static final String Get_RoomClass_Status="//*[@id='StayInfo']//following-sibling::label[.='Room(s):']/following-sibling::div/p/span";
	public static final String Click_Save_ReservationDetails="//button[.='Save']";
	public static final String Verify_Depos_policy="//div[@aria-hidden='false']//h4[.='Deposit Policy']";
	public static final String Click_Without_Deposit="//div[@aria-hidden='false']//div[3]/button[.='Without Deposit']";
	
	
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
	public static final String Click_Process="//div[@id='ReservationPaymetItemDetail']//button[contains(@data-bind,'$parent.btnProcessVisible()')]";
	public static final String GetMC_Payment_Method="//div[@id='ReservationPaymetItemDetail']//following-sibling::div[@id='reservationList']//span[.='MC']";
	public static final String GetAddedLine_MC="//div[@id='ReservationDetail']//tr[@data-bind='if: $parent.ShouldShowThisItem($data)'][2]//a";
	public static final String Verify_MC_Grid="//tbody[contains(@data-bind,'foreach: PaymentItemsArray')]//tr";
	public static final String Verify_Balance_Zero="//label[.='Balance: ']//following-sibling::span[@class='pamt']";
	public static final String Select_Authorization_type="//div[@id='ReservationPaymetItemDetail']//select[@name='AuthorizationTypeOut']";
	public static final String Change_Amount="//div[@id='ReservationPaymetItemDetail']//input[contains(@data-bind,'value: $parent.formattedAmount')]";
	
	
	
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
	
	
	
	//Checkin
	
	public static final String Click_Checkin="//button[.='Check In']";
	public static final String Verify_Dirty_Room_popup="//h4[contains(@data-bind,'text: ModalTitleText')]";
	public static final String Confirm_button="//button[contains(@data-bind, 'enable: YesButtonEnable')]";
	public static final String Click_on_confirm="//div[@class='header-confirmation']//button[2]";
	public static final String Payment_Popup="//span[.='Payment Details']";
	public static final String Key_Generation_Popup="//h4[.='Key Generation']";
	public static final String Key_Generation_Close="//*[@id='keyGenerationPopUp']/div[3]/div/button[3]";
	
	//Checkout
	
	public static final String Click_Checkout="//div[@id='ReservationDetail']//button[.='Check Out']";
	public static final String Click_Close="//div[@class='header-confirmation']//button";
	
	
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
	
	public static final String Click_Reservation="//div[@class='innCenterNavigation']//span[.='Reservations']";
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
    
    
    
	
}
