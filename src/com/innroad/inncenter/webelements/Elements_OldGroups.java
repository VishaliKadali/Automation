package com.innroad.inncenter.webelements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_OldGroups {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_OldGroups(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}

		@FindBy(xpath=OR.GroupsNewAccount)
		public WebElement GroupsNewAccount;
		
		@FindBy(xpath=OR.AccountFirstName)
		public WebElement AccountFirstName;
		
		@FindBy(xpath=OR.MarketingSegment)
		public WebElement MarketingSegment;
		
		@FindBy(xpath=OR.GroupReferral)
		public WebElement GroupReferral;
		
		@FindBy(xpath=OR.SalutationMailing)
		public WebElement SalutationMailing;
		
		@FindBy(xpath=OR.Select_Account_Type)
		public WebElement Select_Account_Type;
		
		@FindBy(xpath=OR.GroupFirstName)
		public WebElement GroupFirstName;
		
		@FindBy(xpath=OR.GroupLastName)
		public WebElement GroupLastName;
		
		@FindBy(xpath=OR.GroupPhn)
		public WebElement GroupPhn;
		
		@FindBy(xpath=OR.GroupAddress)
		public WebElement GroupAddress;
		
		@FindBy(xpath=OR.GroupCity)
		public WebElement GroupCity;
		
		@FindBy(xpath=OR.Groupstate)
		public WebElement Groupstate;
		
		@FindBy(xpath=OR.GroupPostale)
		public WebElement GroupPostale;
		
		@FindBy(xpath=OR.Groupscountry)
		public WebElement Groupscountry;
		
		@FindBy(xpath=OR.Mailinginfo)
		public WebElement Mailinginfo;

		@FindBy(xpath=OR.GroupSave)
		public WebElement GroupSave;
		
		@FindBy(xpath=OR.Click_New_Block_button)
		public WebElement Click_New_Block_button;
		
		@FindBy(xpath=OR.Enter_Block_Name)
		public WebElement Enter_Block_Name;
		
		@FindBy(xpath=OR.Click_Ok)
		public WebElement Click_Ok;
		
		@FindBy(xpath=OR.Select_Arrival_Date_Groups)
		public WebElement Select_Arrival_Date_Groups;
		
		@FindBy(xpath=OR.Click_Today_Arrival_Groups)
		public WebElement Click_Today_Arrival_Groups;
		
		@FindBy(xpath=OR.Enter_No_of_Nigts)
		public WebElement Enter_No_of_Nigts;
		
		@FindBy(xpath=OR.Click_Search_Group)
		public WebElement Click_Search_Group;
		
	/*	@FindBy(xpath=OR.GetBlockedRowsize)
		public WebElement GetBlockedRowsize;*/
		
		@FindBy(id=OR.txtTotalRooms)
		public WebElement txtTotalRooms;
		
		@FindBy(xpath=OR.GetBlockedRowsize)
		public List<WebElement> GetBlockedRowsize;
		
		@FindBy(xpath=OR.GetRoomclasses)
		public List<WebElement> GetRoomclasses;
		
		@FindBy(xpath=OR.Click_Create_Block)
		public WebElement Click_Create_Block;
		
		@FindBy(xpath=OR.Click_Ok_On_Rel_Popup)
		public WebElement Click_Ok_On_Rel_Popup;
		
		@FindBy(xpath=OR.Verify_Block_Nights)
		public WebElement Verify_Block_Nights;
		
		@FindBy(xpath=OR.Click_Continue_Block_Night)
		public WebElement Click_Continue_Block_Night;
		
		@FindBy(xpath=OR.CountofRooms)
		public List<WebElement> CountofRooms;
		
		@FindBy(xpath=OR.Navigate_Room_Block)
		public WebElement Navigate_Room_Block;
		
		@FindBy(xpath=OR.oldGroup_startdate)
		public WebElement oldGroup_startdate;
		
		@FindBy(xpath=OR.oldGroup_numberofNights)
		public WebElement oldGroup_numberofNights;
		
		@FindBy(xpath=OR.oldGroup_AccountNumber)
		public WebElement oldGroup_AccountNumber;
		
		@FindBy(xpath=OR.oldGroup_Today)
		public WebElement oldGroup_Today;
		
		@FindBy(xpath=OR.oldGroup_Adults)
		public WebElement oldGroup_Adults;
		
		@FindBy(xpath=OR.old_Groups_Click_Search)
		public WebElement old_Groups_Click_Search;
		
		@FindBy(xpath=OR.GetNumberofclasses)
		public List<WebElement> GetNumberofclasses;
		
		@FindBy(xpath=OR.oldGroups_Click_Groups)
		public WebElement oldGroups_Click_Groups;
		
		@FindBy(xpath=OR.oldGroups_Account_Search)
		public WebElement oldGroups_Account_Search;
		
		@FindBy(xpath=OR.oldGroups_Account_ClickGo)
		public WebElement oldGroups_Account_ClickGo;
		
		@FindBy(xpath=OR.oldGroups_Account_VerifyAccountNumber)
		public WebElement oldGroups_Account_VerifyAccountNumber;
		
		@FindBy(xpath=OR.oldGroup_SearchBookicon)
		public WebElement oldGroup_SearchBookicon;
		
		@FindBy(xpath=OR.oldGroup_Click_Roominglistbutton)
		public WebElement oldGroup_Click_Roominglistbutton;
		
		@FindBy(xpath=OR.oldGroups_Enter_FirstName_Roominglistpopup)
		public WebElement oldGroups_Enter_FirstName_Roominglistpopup;
		
		@FindBy(xpath=OR.oldGroups_Enter_LastName_Roominglistpoup)
		public WebElement oldGroups_Enter_LastName_Roominglistpoup;
		
		@FindBy(xpath=OR.oldGroups_Select_Roomclass_Roominglistpoup)
		public WebElement oldGroups_Select_Roomclass_Roominglistpoup;
		
		@FindBy(xpath=OR.oldGroups_Select_RoomNo_Roominglistpopup)
		public WebElement oldGroups_Select_RoomNo_Roominglistpopup;
		
		@FindBy(xpath=OR.oldGroups_Select_Pickupbutton_Roominglistpopup)
		public WebElement oldGroups_Select_Pickupbutton_Roominglistpopup;
		
		@FindBy(xpath=OR.oldGroup_Click_Close_Roominglistsummary)
		public WebElement oldGroup_Click_Close_Roominglistsummary;
		
		@FindBy(xpath=OR.oldGroup_AccountSearch_Accountnum)
		public WebElement oldGroup_AccountSearch_Accountnum;
		
		
		
		
		
		
		
		
}
