package com.innroad.inncenter.Interface;

import org.openqa.selenium.WebDriver;

import com.innroad.inncenter.WebElements.Elements_Reservation;
import com.relevantcodes.extentreports.ExtentTest;

public interface IReservation {
	
	void marketingInfo(WebDriver driver,ExtentTest test,String MarketSegment,String Referral, String Travel_Agent,String ExtReservation)throws InterruptedException;
   
	void clickNewReservationButton(WebDriver driver )throws InterruptedException;
	
	void contactInformation(WebDriver driver,ExtentTest test,String saluation, String FirstName, String LastName,String Address,String Line1, String Line2, String Line3, String City, String Country, String State, String Postalcode,String Phonenumber, String alternativenumber, String Email, String Account,String IsTaxExempt, String TaxEmptext);
	
	void billingInformation(WebDriver driver,ExtentTest test,String PaymentMethod, String AccountNumber, String ExpiryDate, String BillingNotes);
	void roomAssignment(WebDriver driver, ExtentTest test,String Nights, String Adults,String Children, String CheckorUncheckAssign, String RoomClassName,String RoomClassName2) throws InterruptedException;
	void roomAssignment(WebDriver driver,String PropertyName,String Nights, String Adults, String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber)throws InterruptedException;
	
	void IPropertySelector(WebDriver driver,String PropertyName)throws InterruptedException;
	
	void saveReservation(WebDriver driver, ExtentTest test)throws InterruptedException;
	
	void Checkin(WebDriver driver, String PropertyName, String RoomClassName, String CheckorUncheckAssign,String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)throws InterruptedException;
	
	void checkout(WebDriver driver,String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData)throws InterruptedException;
	
	void AddNotes(WebDriver driver, String subject, String details, String NoteType,String Notestatus);
	
}
