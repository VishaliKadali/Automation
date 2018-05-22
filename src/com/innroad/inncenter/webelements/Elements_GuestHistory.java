package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_GuestHistory {

	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_GuestHistory(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);		 
		}
		
		@FindBy(xpath=OR.reservation_Menu)
		public WebElement reservation_Menu;
		
		@FindBy(xpath=OR.Guest_History)
		public WebElement Guest_History;
		
		@FindBy(xpath=OR.newAccount)
		public WebElement newAccount;

		@FindBy(xpath=OR.selectAccountSalutation)
		public WebElement selectAccountSalutation;
		
		@FindBy(xpath=OR.accountFirstName)
		public WebElement accountFirstName;
		
		@FindBy(xpath=OR.accountNumber)
		public WebElement accountNumber;
		
		@FindBy(xpath=OR.accountSince)
		public WebElement accountSince;

		@FindBy(xpath=OR.Select_Market_Segment)
		public WebElement Select_Market_Segment;
		
		@FindBy(xpath=OR.Select_Referrals)
		public WebElement Select_Referrals;
		
		@FindBy(xpath=OR.closeReservation)
		public WebElement closeReservation;
		
		@FindBy(xpath=OR.guestHistoryAccountNo)
		public WebElement guestHistoryAccountNo;
		
		@FindBy(xpath=OR.enterAccountFName)
		public WebElement enterAccountFName;
		
		@FindBy(xpath=OR.enterGuestHistoryAccountNo)
		public WebElement enterGuestHistoryAccountNo;
		
		@FindBy(xpath=OR.clickSearchButton)
		public WebElement clickSearchButton;
		
		@FindBy(xpath=OR.selectGuestHistoryAccount)
		public WebElement selectGuestHistoryAccount;
		
		@FindBy(xpath=OR.deleteButton)
		public WebElement deleteButton;
		
		@FindBy(xpath=OR.newReservationButton)
		public WebElement newReservationButton;
		
		@FindBy(xpath=OR.New_Reservation_Page_Load)
		public WebElement New_Reservation_Page_Load;

		@FindBy(xpath=OR.closeGuestHistoryRes)
		public WebElement closeGuestHistoryRes;
		
}
