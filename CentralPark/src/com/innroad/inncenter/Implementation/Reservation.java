package com.innroad.inncenter.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.Interface.IReservation;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Reservation;

public class Reservation implements IReservation {
	
	public static String ReservationConfirmation;

	
	public void IPropertySelector(WebDriver driver, String PropertyName) throws InterruptedException {
		
		if(driver.findElement(By.xpath("//b[@role='presentation']")).isDisplayed())
		{
		
		driver.findElement(By.id("s2id_autogen1")).click();
		//Wait.explicit_wait_xpath("select2-drop");
		driver.findElement(By.xpath("//li/div[.='"+PropertyName+"']")).click();
        Wait.wait15Second(); 
		}
		else
		{
			System.out.println("Single Property");
		}
	}
	
	public void marketingInfo(WebDriver driver, String MarketSegment,
			String Referral, String Travel_Agent, String ExtReservation) throws InterruptedException {
		
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		try
		{
		ReservationPage.Enter_Travel_Agent.sendKeys(Travel_Agent);
		}
		catch(Exception e)
		{
			
		}
		ReservationPage.Enter_Ext_Reservation.sendKeys(ExtReservation);
	}

	public void clickNewReservationButton(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.New_Reservation_Button.click();
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}

	@Override
	public void contactInformation(WebDriver driver, String saluation,
			String FirstName, String LastName, String Address, String Line1,
			String Line2, String Line3, String City, String Country,
			String State, String Postalcode, String Phonenumber,
			String alternativenumber, String Email, String Account,String IsTaxExempt,
			String TaxEmptext) {
		
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		
		new Select(ReservationPage.Select_Saluation).selectByVisibleText(saluation);
		ReservationPage.Enter_First_Name.clear();
		ReservationPage.Enter_Last_Name.clear();
		ReservationPage.Enter_Address_Search.clear();
		ReservationPage.Enter_Line1.clear();
		ReservationPage.Enter_Line2.clear();
		ReservationPage.Enter_Line3.clear();
		ReservationPage.Enter_City.clear();
		ReservationPage.Enter_Postal_Code.clear();;
		ReservationPage.Enter_Phone_Number.clear();;
		ReservationPage.Enter_Alt_Phn_number.clear();;
		ReservationPage.Enter_email.clear();;
		ReservationPage.Enter_First_Name.sendKeys(FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
		ReservationPage.Enter_Address_Search.sendKeys(Address);
		ReservationPage.Enter_Line1.sendKeys(Line1);
		ReservationPage.Enter_Line2.sendKeys(Line2);
		ReservationPage.Enter_Line3.sendKeys(Line3);
		ReservationPage.Enter_City.sendKeys(City);
		new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
		new Select(ReservationPage.Select_State).selectByVisibleText(State);
		ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
		ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
		ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
		ReservationPage.Enter_email.sendKeys(Email);
		try
		{
		ReservationPage.Enter_Account.sendKeys(Account);
		}
		catch(Exception e)
		{
			
		}
		if(IsTaxExempt.equals("Yes"))
		{
		if(ReservationPage.Check_IsTaxExempt.isSelected())
		{
		ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);	
		}
		else
		{
			ReservationPage.Check_IsTaxExempt.click();
			ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
		}
		}
	}

	
	public void billingInformation(WebDriver driver, String PaymentMethod,
			String AccountNumber, String ExpiryDate, String BillingNotes) {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Select_Payment_Method).selectByVisibleText(PaymentMethod);
		if(PaymentMethod.equalsIgnoreCase("MC")||PaymentMethod.equalsIgnoreCase("Amex")||PaymentMethod.equalsIgnoreCase("Discover")||PaymentMethod.equalsIgnoreCase("Visa"))
		{
			ReservationPage.Enter_Account_Number.sendKeys(AccountNumber);
			ReservationPage.Enter_Exp_Card.sendKeys(ExpiryDate);
			ReservationPage.Enter_Billing_Note.sendKeys(BillingNotes);
			
		}
	}

	
	public void roomAssignment(WebDriver driver,String PropertyName, String Nights, String Adults,
			String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName,
			String RoomNumber) throws InterruptedException {
		
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_RoomPicker.click();
		Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
		Wait.wait3Second();
		/*try
		{
		new Select(ReservationPage.Select_property_RoomAssign).selectByVisibleText(PropertyName);
		}
		catch(Exception e)
		{
			new Select(ReservationPage.Select_property_RoomAssign2).selectByVisibleText(PropertyName);
		}*/
		Wait.wait15Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		ReservationPage.Click_Today.click();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		ReservationPage.Enter_Adults.sendKeys(Adults);
		ReservationPage.Enter_Children.sendKeys(Children);
		ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);
		
		if(ReservationPage.Check_Assign_Room.isSelected())
		{
//			ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
		}
		else
		{
			if(CheckorUncheckAssign.equals("Yes"))
			{
				ReservationPage.Check_Assign_Room.click();
				ReservationPage.Click_Search.click();
			}
			else
			{
				ReservationPage.Click_Search.click();
			}
		}
		try
		{
		
		new Select(ReservationPage.Select_Room_Class).selectByVisibleText(RoomClassName);
		String selectedOption = new Select(ReservationPage.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
        System.out.println("selectedOption  " +selectedOption);
		if(selectedOption.equals("--Select--"))
		{
		//new Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
			new Select(ReservationPage.Select_Room_Number).selectByIndex(1);
		}
		else
		{
			  System.out.println("Reservation is unassigned");
		}
		}
		catch(Exception e)
		{
			Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
			System.out.println("Room Class are not Available for these dates");
			
		}
		ReservationPage.Click_Select.click();
		try
		{
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		}
		catch(Exception e)
		{
			System.out.println("Verification failed");
		}
		Wait.wait5Second();
		if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
		{
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
		}
		else
		{
			System.out.println("Satisfied Rules");
		}
		
		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle=ReservationPage.Toaster_Title.getText();
		String getToastermessage=ReservationPage.Toaster_Message.getText();
		System.out.println(getTotasterTitle + " " +getToastermessage);
		Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
		Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}
		Wait.wait2Second();
		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status=ReservationPage.Get_RoomClass_Status.getText();
		System.out.println(getRoomclassName_status);
		Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[]= getRoomclassName_status.split(" ");
		//Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if(CheckorUncheckAssign.equals("Yes"))
		{
		
		}
		else
		{
			Assert.assertEquals(getRoomclassName[2],"Unassigned" );
		}
	}

	
	public void saveReservation(WebDriver driver) throws InterruptedException {
		

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		double waittime = 0.12;
		long startTime = System.currentTimeMillis();
		ReservationPage.Click_Save_ReservationDetails.click();
		Wait.wait3Second();
		try
		{
		if(ReservationPage.Verify_Depos_policy.isDisplayed())
		{
			ReservationPage.Click_Without_Deposit.click();
		}
		}
		catch (Exception ne)
		{
			
		}
		try
		{
		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle_ReservationSucess=ReservationPage.Toaster_Title.getText();
		String getToastermessage_ReservationSucess=ReservationPage.Toaster_Message.getText();
		Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");
		 long endTime   = System.currentTimeMillis();
		 double totalTime = (endTime - startTime); 
      	 System.out.println(totalTime + " in Millsecs");
      	 double TotalTimeinsecs = totalTime/1000;
      	 double ActualTime = TotalTimeinsecs - waittime - 3;
      	 System.out.println(ActualTime + " in secs");
		if(getToastermessage_ReservationSucess.endsWith("has been saved successfully"));
		
		}
		}
		catch(Exception e)
		{
			
		}
		Wait.wait10Second();
	}
	
	
public void manualEmail(WebDriver driver, String Email, String Attachment) throws InterruptedException {
		
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Email_icon.click();
		Wait.explicit_wait_xpath(OR.Verify_Send_Email_Popup);
		Wait.explicit_wait_absenceofelement(OR.Verify_loading_popup_mailContentPopUp);
		Wait.wait5Second();
		String GetEmailid=ReservationPage.Get_email_Id.getText();
		System.out.println(GetEmailid + "" + GetEmailid);
		if(GetEmailid.equals("dinesh.ganganaboina@gmail.com"))
		{
		
		}
		else
		{
			ReservationPage.Get_email_Id.clear();
			Wait.wait3Second();
			ReservationPage.Get_email_Id.sendKeys(Email);
		}
		new Select (ReservationPage.Select_Attachment).selectByVisibleText(Attachment);
		Wait.wait5Second();
		ReservationPage.Click_Send_Email.click();
		Wait.wait10Second();
	}


public void Checkin(WebDriver driver, String PropertyName, String RoomClassName, String CheckorUncheckAssign, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData ) throws InterruptedException {
	
	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	 double waittime = 0.12;
	 long startTime = System.currentTimeMillis();
	 ReservationPage.Click_Checkin.click();
	 Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
	 long endTime   = System.currentTimeMillis();
	 Wait.waitforloadpage(startTime,endTime,waittime);
	 Wait.wait5Second();
	 long Loadguestregform_StartTime = System.currentTimeMillis();
	 ReservationPage.Click_Select.click();
	Wait.wait3Second();
	try
	{
		Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
	}
	catch(Exception e)
	{
		System.out.println("Verification failed");
	}
	Wait.wait10Second();
	if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
	{
		ReservationPage.Click_Continue_RuleBroken_Popup.click();
	}
	else
	{
		System.out.println("Satisfied Rules");
	}
	if(ReservationPage.Verify_Dirty_Room_popup.isDisplayed())
	{
		ReservationPage.Confirm_button.click();
		Wait.wait15Second();
	}
	else
	{
		System.out.println("No Dirty Rooms");
	}
	
	try
	{
	if(ReservationPage.Payment_Popup.isDisplayed())
	{
	ReservationFolio Payment= new ReservationFolio();
	Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
	}
	}
	catch(Exception e)
	{
		System.out.println("Checkin Policy doesnt exist");
	}
	
	Wait.wait15Second();
	ReservationPage.Click_on_confirm.click();
	
	try
	{
	if(ReservationPage.Key_Generation_Popup.isDisplayed())
	{
	ReservationPage.Key_Generation_Close.click();
	Wait.wait15Second();
	}
	}
	catch(Exception e)
	{
		System.out.println("Key Geneartion doesnt exist");
	}
}


public void checkout(WebDriver driver, String PaymentType, String CardName,String CCNumber, String CCExpiry, String CCVCode,String Authorizationtype, String ChangeAmount,
		String ChangeAmountValue, String traceData)
		
		throws InterruptedException {
	
	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	
	try
	{
	Wait.wait15Second();	
	ReservationPage.Click_Checkout.click();
	Wait.wait15Second();
	if(ReservationPage.Payment_Popup.isDisplayed())
	{
	ReservationFolio Payment= new ReservationFolio();
	Payment.TestPaymentPopup(driver, PaymentType, CardName, CCNumber, CCExpiry, CCVCode, Authorizationtype, ChangeAmount, ChangeAmountValue,traceData);
	}
	}
	catch(Exception e)
	{
		System.out.println("CheckoutExecption");
	}
	Wait.wait15Second();
	ReservationPage.Click_Close.click();
	Wait.wait5Second();
	
}

public void AddNotes(WebDriver driver, String subject, String details,
		String NoteType,String Notestatus) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	ReservationPage.Add_Note_Reservation.click();
	Wait.explicit_wait_xpath(OR.verify_Add_Notes_popup);
	ReservationPage.Enter_Subject_Notes.sendKeys(subject);
    ReservationPage.Enter_Note_Details.sendKeys(details);
    new Select (ReservationPage.Select_Note_Type).selectByVisibleText(NoteType);
    if(ReservationPage.Check_Action_Required.isSelected())
    {
    	System.out.println("Already selected");
    }
    else
    {
    	ReservationPage.Check_Action_Required.click();
    }
    new Select ( ReservationPage.Select_Notes_Status).selectByVisibleText(Notestatus);
   
    ReservationPage.Click_Save_Note.click();
    if(ReservationPage.Verify_Added_Notes.isDisplayed())
    {
    	System.out.println("Created note Successfully");
    }
    else
    {
    	System.out.println("Fail to create note");
    }
	
}


public void GetReservationnumber(WebDriver driver) throws IOException
{
	Elements_Reservation ReservationPage = new Elements_Reservation(driver);
	ReservationConfirmation =ReservationPage.Get_Confirmation_Number.getText();
	System.out.println("ReservationConfirmation :" +ReservationConfirmation);
	try
	{
	BufferedWriter writer= new BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
	writer.write(ReservationConfirmation);
	writer.close();
	}
	catch(Exception e)
	{
		
	}
	
}

}
