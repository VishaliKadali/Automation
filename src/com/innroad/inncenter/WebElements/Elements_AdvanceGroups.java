package com.innroad.inncenter.WebElements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class Elements_AdvanceGroups {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_AdvanceGroups(WebDriver driver2)
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
		
		
		
		
		
		

	

}
