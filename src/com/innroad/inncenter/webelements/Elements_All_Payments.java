package com.innroad.inncenter.webelements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.innroad.inncenter.properties.OR;

public class Elements_All_Payments {
	

	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_All_Payments(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}

		@FindBy(xpath=OR.PaymentInfoButton)
		public WebElement PaymentInfoButton;
		
		@FindBy(xpath=OR.PaymentPopUp)
		public WebElement PaymentPopUp;
		
		@FindBy(xpath=OR.PaymentInfoButton)
		public List<WebElement> PaymentInfoButtons;
		
		@FindBy(css=OR.PaymentInfo_Input_Fields)
		public List<WebElement> PaymentInfo_Input_Fields;
		
		@FindBy(xpath=OR.OkButton)
		public List<WebElement> OkButton;
		
		@FindBy(xpath=OR.PaymentType)
		public WebElement PaymentType; 
		
		@FindBy(xpath=OR.Folio)
		public List<WebElement> Folio;
		
		@FindBy(xpath=OR.Enter_Amount)
		public WebElement Enter_Amount;
		
		@FindBy(xpath=OR.Add_Pay_Button)
		public WebElement Add_Pay_Button;
		
		@FindBy(xpath=OR.Continue_Pay_Button)
		public WebElement Continue_Pay_Button;
		
		@FindBy(xpath=OR.Enter_CardName)
		public WebElement Enter_CardName;
		
		@FindBy(xpath=OR.Enter_CardNum)
		public WebElement Enter_CardNum;
		
		@FindBy(xpath=OR.Enter_ExpDate)
		public WebElement Enter_ExpDate;
		
		@FindBy(xpath=OR.Enter_Card_CVVCode)
		public WebElement Enter_Card_CVVCode;
		
		@FindBy(xpath=OR.Enter_Address)
		public WebElement Enter_Address;
		
		@FindBy(xpath=OR.Enter_Card_City)
		public WebElement Enter_Card_City;
		
		@FindBy(xpath=OR.Enter_Card_State)
		public WebElement Enter_Card_State;
		
		@FindBy(xpath=OR.Enter_PostalCode)
		public WebElement Enter_PostalCode;
		
		@FindBy(xpath=OR.Enter_ApprovalCode)
		public WebElement Enter_ApprovalCode;
			
		@FindBy(xpath=OR.CardOK_Button)
		public WebElement CardOK_Button;
		
		@FindBy(xpath=OR.Payment_Info_Button)
		public WebElement Payment_Info_Button;
		
		@FindBy(xpath=OR.Process_Button)
		public WebElement Process_Button;
		
		
		@FindBy(xpath=OR.PaymentSwipe_Img)
		public WebElement PaymentSwipe_Img;
		
		@FindBy(xpath=OR.SwipeCard_Field)
		public WebElement SwipeCard_Field;
		
		@FindBy(xpath=OR.SubmitButton)
		public WebElement SubmitButton;
		
		
		
		
		
		
}
