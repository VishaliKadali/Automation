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
		
		
		
		
		
		
		
		
}
