package com.innroad.inncenter.WebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class Elements_Accounts {
	

	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_Accounts(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
			 
		}

		@FindBy(xpath=OR.Select_Account_Type)
		public WebElement Select_Account_Type;
		
		@FindBy(xpath=OR.Click_New_Account)
		public WebElement Click_New_Account;
		
		@FindBy(xpath=OR.Verify_New_Account_Page_Load)
		public WebElement Verify_New_Account_Page_Load;
		
		@FindBy(xpath=OR.Enter_Account_Name)
		public WebElement Enter_Account_Name;
		
		@FindBy(xpath=OR.Verify_Account_Type)
		public WebElement Verify_Account_Type;
		
		@FindBy(xpath=OR.Select_Market_Segment)
		public WebElement Select_Market_Segment;
		
		@FindBy(xpath=OR.Account_Enter_First_Name)
		public WebElement Account_Enter_First_Name;
		
		@FindBy(xpath=OR.Account_Phone_number)
		public WebElement Account_Phone_number;
		
		@FindBy(xpath=OR.Account_Enter_AltPhoneNumber)
		public WebElement Account_Enter_AltPhoneNumber;
		
		@FindBy(xpath=OR.Account_Enter_Line1)
		public WebElement Account_Enter_Line1;
		
		@FindBy(xpath=OR.Account_Enter_Line2)
		public WebElement Account_Enter_Line2;
		
		@FindBy(xpath=OR.Account_Enter_Line3)
		public WebElement Account_Enter_Line3;
		
		@FindBy(xpath=OR.Account_Enter_Email)
		public WebElement Account_Enter_Email;
		
		@FindBy(xpath=OR.Account_Enter_City)
		public WebElement Account_Enter_City;
		
		@FindBy(xpath=OR.Select_Account_State)
		public WebElement Select_Account_State;
		
		@FindBy(xpath=OR.Account_Enter_PostalCode)
		public WebElement Account_Enter_PostalCode;
		
		@FindBy(xpath=OR.Account_Check_Mailing_info)
		public WebElement Account_Check_Mailing_info;
		
		@FindBy(xpath=OR.Account_save)
		public WebElement Account_save;
		
		@FindBy(xpath=OR.Select_Referrals)
		public WebElement Select_Referrals;
		
		@FindBy(xpath=OR.Account_Enter_Last_Name)
		public WebElement Account_Enter_Last_Name;
		
		@FindBy(xpath=OR.Verify_Toaster_Container)
		public WebElement Verify_Toaster_Container;
		
		@FindBy(xpath=OR.Toaster_Title)
		public WebElement Toaster_Title;
		
		@FindBy(xpath=OR.Toaster_Message)
		public WebElement Toaster_Message;
		
		@FindBy(xpath=OR.Account_Folio)
		public WebElement Account_Folio;
		
		@FindBy(xpath=OR.Account_pay)
		public WebElement Account_pay;
		
		@FindBy(xpath=OR.Account_Add)
		public WebElement Account_Add;
		
		@FindBy(xpath=OR.Verify_Account_line_item)
		public WebElement Verify_Account_line_item;
		
		@FindBy(xpath=OR.Select_Line_item_Category)
		public WebElement Select_Line_item_Category;
		
		@FindBy(xpath=OR.Enter_Line_item_Amount)
		public WebElement Enter_Line_item_Amount;
		
		@FindBy(xpath=OR.Click_Commit)
		public WebElement Click_Commit;
		
		@FindBy(xpath=OR.Select_Account_paymethod)
		public WebElement Select_Account_paymethod;
		
		@FindBy(xpath=OR.Click_Account_Card_info)
		public WebElement Click_Account_Card_info;
		
		@FindBy(xpath=OR.Verify_Account_Paymnet_info_popup)
		public WebElement Verify_Account_Paymnet_info_popup;
		
		@FindBy(xpath=OR.Enter_Account_Card_Name)
		public WebElement Enter_Account_Card_Name;
		
		@FindBy(xpath=OR.Enter_CC_Account_Number)
		public WebElement Enter_CC_Account_Number;
		
		@FindBy(xpath=OR.Enter_ExpiryDate_Account)
		public WebElement Enter_ExpiryDate_Account;
		
		@FindBy(xpath=OR.Enter_CCV_Account)
		public WebElement Enter_CCV_Account;
		
		@FindBy(xpath=OR.Click_Ok_Account)
		public WebElement Click_Ok_Account;
		
		@FindBy(xpath=OR.Select_Authorization_Type_Account)
		public WebElement Select_Authorization_Type_Account;
		
		@FindBy(xpath=OR.Enter_Change_Amount)
		public WebElement Enter_Change_Amount;
		
		@FindBy(xpath=OR.Click_Account_Pay_Continue)
		public WebElement Click_Account_Pay_Continue;
		
		@FindBy(xpath=OR.Click_Process_Account)
		public WebElement Click_Process_Account;
		
		@FindBy(xpath=OR.Account_Payment_Method)
		public WebElement Account_Payment_Method;
		
		@FindBy(xpath=OR.Get_Line_item_Account)
		public WebElement Get_Line_item_Account;
		
		@FindBy(xpath=OR.Verify_Ending_Balance)
		public WebElement Verify_Ending_Balance;
		
		@FindBy(xpath=OR.Select_Property_lineitem)
		public WebElement Select_Property_lineitem;
		
		@FindBy(xpath=OR.Apply_Advance_Deposite)
		public WebElement Apply_Advance_Deposite;
		
		@FindBy(xpath=OR.Click_Continue_Adv_Deposite)
		public WebElement Click_Continue_Adv_Deposite;
		
		@FindBy(xpath=OR.Click_New_Reservation_Account)
		public WebElement Click_New_Reservation_Account;
		
		@FindBy(xpath=OR.Enter_House_Account_Name)
		public WebElement Enter_House_Account_Name;
		
		@FindBy(xpath=OR.Get_Gift_ID)
		public WebElement Get_Gift_ID;
		
		@FindBy(xpath=OR.Enter_Gift_Line_Item_Amount)
		public WebElement Enter_Gift_Line_Item_Amount;
		
		@FindBy(xpath=OR.Acc_Add_Button)
		public WebElement Acc_Add_Button;
		
		@FindBy(xpath=OR.Acc_Note_Enter_sub)
		public WebElement Acc_Note_Enter_sub;
		
		@FindBy(xpath=OR.Acc_Note_Enter_Details)
		public WebElement Acc_Note_Enter_Details;
		
		@FindBy(xpath=OR.Acc_Note_Select_Note_Type)
		public WebElement Acc_Note_Select_Note_Type;
		
		@FindBy(xpath=OR.Acc_Note_Select_Note_Status)
		public WebElement Acc_Note_Select_Note_Status;
		
		@FindBy(xpath=OR.Acc_Note_Action_Req)
		public WebElement Acc_Note_Action_Req;
		
		@FindBy(xpath=OR.Acc_Note_Save)
		public WebElement Acc_Note_Save;
		
		@FindBy(xpath=OR.Verify_Add_line_Notes)
		public WebElement Verify_Add_line_Notes;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
