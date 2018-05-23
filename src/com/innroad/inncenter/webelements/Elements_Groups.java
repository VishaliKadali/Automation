package com.innroad.inncenter.webelements;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;


public class Elements_Groups {


	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_Groups(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}

		
		@FindBy(xpath=OR.New_Account_Btn)
		public WebElement New_Account_Btn;
		
		
		@FindBy(xpath=OR.Group_Name)
		public WebElement Group_Name;
		
		@FindBy(xpath=OR.Market_Segment)
		public WebElement Market_Segment;
		
		@FindBy(xpath=OR.Referrls)
		public WebElement Referrls;
		
		
		@FindBy(xpath=OR.FirstName)
		public WebElement FirstName;
		
		@FindBy(xpath=OR.LastName)
		public WebElement LastName;
		
		@FindBy(xpath=OR.Phone)
		public WebElement Phone;
		
		@FindBy(xpath=OR.Address1)
		public WebElement Address1;
		
		
		@FindBy(xpath=OR.City)
		public WebElement City;
		
		@FindBy(xpath=OR.Country)
		public WebElement Country;
		
		@FindBy(xpath=OR.State)
		public WebElement State;
		
		@FindBy(xpath=OR.PostalCode)
		public WebElement PostalCode;
		
		@FindBy(xpath=OR.Check_Mailing_Info)
		public WebElement Check_Mailing_Info;
		
		@FindBy(xpath=OR.Group_Save)
		public WebElement Group_Save;
		
		
		@FindBy(xpath=OR.Group_Folio_Add_LineItem)
		public WebElement Group_Folio_Add_LineItem;
	
		@FindBy(xpath=OR.Group_Folio_Commit_Lineitem)
		public WebElement Group_Folio_Commit_Lineitem;
		
		@FindBy(xpath=OR.Group_Folio_CardInfo)
		public WebElement Group_Folio_CardInfo;
		
		@FindBy(xpath=OR. Group_Folio_PaymentMethod)
		public WebElement Group_Folio_PaymentMethod;
		
		@FindBy(xpath=OR.Group_Folio_NameOnCard)
		public WebElement Group_Folio_NameOnCard;
		
		@FindBy(xpath=OR.Group_Folio_CardNumber)
		public WebElement Group_Folio_CardNumber;
		
		@FindBy(xpath=OR.Group_Folio_ExpDate)
		public WebElement Group_Folio_ExpDate;
		
		@FindBy(xpath=OR.Group_Folio_CVV)
		public WebElement Group_Folio_CVV;
		
		@FindBy(xpath=OR.Group_Folio_OK)
		public WebElement Group_Folio_OK;
		
		@FindBy(xpath=OR.Group_Folio_AuthType)
		public WebElement Group_Folio_AuthType;
		
		@FindBy(xpath=OR.Group_Folio_Process)
		public WebElement Group_Folio_Process;
		
		@FindBy(xpath=OR.Group_Folio_Amount)
		public WebElement Group_Folio_Amount;
		
		
		
		@FindBy(xpath=OR.Group_Folio_Continue)
		public WebElement Group_Folio_Continue;
		
		
		@FindBy(xpath=OR.Group_Folio_EndingBalance)
		public WebElement Group_Folio_EndingBalance;
		
		
		@FindBy(xpath=OR.Group_Folio_Add)
		public WebElement Group_Folio_Add;
		
		
		@FindBy(xpath=OR.Group_Folio)
		public WebElement Group_Folio;
		
		@FindBy(xpath=OR.Group_Folio_AutoApply)
		public WebElement Group_Folio_AutoApply;
		
		
}
