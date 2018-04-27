package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class WebElements_Policies {
	
	WebDriver driver;
	
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public WebElements_Policies(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);
		
		
	}
	
	@FindBy(xpath=OR.Policy_Name_On_Policiespage)
	public WebElement Policy_Name_On_Policiespage;
	
	@FindBy(xpath=OR.Search_On_On_Policiespage)
	public WebElement Search_On_On_Policiespage;
	
	@FindBy(xpath=OR.First_Element_In_Search_Result)
	public WebElement First_Element_In_Search_Result;
	
	@FindBy(xpath=OR.Select_Policy_Type)
	public WebElement Select_Policy_Type;
	
	@FindBy(xpath=OR.New_Policy_Btn)
	public WebElement New_Policy_Btn;
	
	@FindBy(xpath=OR.Enter_Policy_Name)
	public WebElement Enter_Policy_Name;
	
	
	@FindBy(xpath=OR.Select_Deposit_Roomcharges_Radiobtn)
	public WebElement Select_Deposit_Roomcharges_Radiobtn;
	
	@FindBy(xpath=OR.Select_Deposit_Fixedamount_Radiobtn)
	public WebElement Select_Deposit_Fixedamount_Radiobtn;
	
	@FindBy(xpath=OR.Select_Deposit_Firstnightrc_Radiobtn)
	public WebElement Select_Deposit_Firstnightrc_Radiobtn;
	
	@FindBy(xpath=OR.Select_Noshow_Roomcharges_Radiobtn)
	public WebElement Select_Noshow_Roomcharges_Radiobtn;
	
	@FindBy(xpath=OR.Select_Noshow_Fixedamount_Radiobtn)
	public WebElement Select_Noshow_Fixedamount_Radiobtn;
	
	@FindBy(xpath=OR.Select_Noshow_Firstnightrc_Radiobtn)
	public WebElement Select_Noshow_Firstnightrc_Radiobtn;
	
	@FindBy(xpath=OR.Select_Checkin_Roomcharges_Radiobtn)
	public WebElement Select_Checkin_Roomcharges_Radiobtn;
	
	@FindBy(xpath=OR.Select_Checkin_Fixedamount_Radiobtn)
	public WebElement Select_Checkin_Fixedamount_Radiobtn;
	
	@FindBy(xpath=OR.Select_Roomcharges_Type_for_Deposit)
	public WebElement Select_Checkin_Firstnightrc_Radiobtn;
	
	
	@FindBy(xpath=OR.Select_Roomcharges_Type_for_Deposit)
	public WebElement Select_Roomcharges_Type_for_Deposit;
	
	@FindBy(xpath=OR.Select_Roomcharges_Type_for_Cancellation)
	public WebElement Select_Roomcharges_Type_for_Cancellation;
	
	@FindBy(xpath=OR.Select_Roomcharges_Type_for_Noshow)
	public WebElement Select_Roomcharges_Type_for_Noshow;
	
	
	@FindBy(xpath=OR.Enter_Deposit_Percentage_Charges)
	public WebElement Enter_Deposit_Percentage_Charges;
	
	@FindBy(xpath=OR.Enter_Deposit_Fixed_Amount)
	public WebElement Enter_Deposit_Fixed_Amount;
	
	@FindBy(xpath=OR.Enter_Deposit_First_Nights_RC)
	public WebElement Enter_Deposit_First_Nights_RC;
	
	
	@FindBy(xpath=OR.Enter_Noshow_Percentage_Charges)
	public WebElement Enter_Noshow_Percentage_Charges;
	
	@FindBy(xpath=OR.Enter_Noshow_Fixed_Amount)
	public WebElement Enter_Noshow_Fixed_Amount;
	
	@FindBy(xpath=OR.Enter_Noshow_First_Nights_RC)
	public WebElement Enter_Noshow_First_Nights_RC;
	
	
	@FindBy(xpath=OR. Select_Capture_Payment_for_Checkin)
	public WebElement  Select_Capture_Payment_for_Checkin;
	
	@FindBy(xpath=OR.Select_Authorize_Payment_for_Checkin)
	public WebElement Select_Authorize_Payment_for_Checkin;
	
	@FindBy(xpath=OR.Enter_Checkin_Percentage_On_balance)
	public WebElement Enter_Checkin_Percentage_On_balance;
	
	
	@FindBy(xpath=OR.Enter_Policy_Text)
	public WebElement Enter_Policy_Text;
	
	@FindBy(xpath=OR.Enter_Policy_Description)
	public WebElement Enter_Policy_Description;
	
	@FindBy(xpath=OR.Associate_Sources_Btn)
	public WebElement Associate_Sources_Btn;
	
	@FindBy(xpath=OR.Associate_Seasons_Btn)
	public WebElement Associate_Seasons_Btn;
	
	@FindBy(xpath=OR.Associate_Room_Classes_Btn)
	public WebElement Associate_Room_Classes_Btn;
	
	@FindBy(xpath=OR.Associate_Rate_Plans_Btn)
	public WebElement Associate_Rate_Plans_Btn;
	
	@FindBy(xpath=OR.Associate_Assign_All_Btn)
    public WebElement Assoociate_Assign_All_Btn;
	
	@FindBy(xpath=OR.Done_In_Popup)
	public WebElement Done_In_Popup;
	
	@FindBy(xpath=OR.Policy_Save)
	public WebElement Policy_Save;
	
	@FindBy(xpath=OR.Verify_Toaster_Container)
	public WebElement Verify_Toaster_Container;
	
	@FindBy(xpath=OR.Toaster_Title)
	public WebElement Toaster_Title;
	
	@FindBy(xpath=OR.Toaster_Message)
	public WebElement Toaster_Message;
	
	@FindBy(xpath=OR.Policy_Close_Btn)
	public WebElement Policy_Close_Btn;
	
	@FindBy(xpath=OR.Delete_Policy_Checkbox)
	public WebElement Delete_Policy_Checkbox;
	
	@FindBy(xpath=OR.Delete_Policy_Btn)
	public WebElement Delete_Policy_Btn;
	 
	
	
}
