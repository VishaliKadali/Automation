package com.innroad.inncenter.Implementation;

import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.Interface.IReservation;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Reservation;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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

	public void marketingInfo(WebDriver driver, ExtentTest test,String MarketSegment,
			String Referral, String Travel_Agent, String ExtReservation) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);
		test.log(LogStatus.PASS, "Select market segment : "+MarketSegment);
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		test.log(LogStatus.PASS, "Select Referral : "+Referral);
		try
		{
			ReservationPage.Enter_Travel_Agent.sendKeys(Travel_Agent);
			test.log(LogStatus.PASS, "Tavel Agent : "+Travel_Agent);
		}
		catch(Exception e)
		{

		}
		ReservationPage.Enter_Ext_Reservation.sendKeys(ExtReservation);
		test.log(LogStatus.PASS, "Ext Reservation : "+ExtReservation);
	}


	public void marketingInfo(WebDriver driver, ExtentTest test,String MarketSegment,
			String Referral) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Reservation_market_Segment).selectByVisibleText(MarketSegment);

		test.log(LogStatus.PASS, "Successfully selected the maraket segment : "+MarketSegment);
		new Select(ReservationPage.Reservation_Referral).selectByVisibleText(Referral);
		test.log(LogStatus.PASS, "Successfully selected the referral : "+Referral);

	}


	public void clickNewReservationButton(WebDriver driver) throws InterruptedException {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.New_Reservation_Button.click();
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}

	@Override
	public void contactInformation(WebDriver driver, ExtentTest test,String saluation,
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
		test.log(LogStatus.PASS, "Enter First name : "+FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
		test.log(LogStatus.PASS, "Enter Last name : "+LastName);
		ReservationPage.Enter_Address_Search.sendKeys(Address);
		test.log(LogStatus.PASS, "Enter Address : "+Address);
		ReservationPage.Enter_Line1.sendKeys(Line1);
		test.log(LogStatus.PASS, "Enter Line1 : "+Line1);
		ReservationPage.Enter_Line2.sendKeys(Line2);
		test.log(LogStatus.PASS, "Enter Line2 : "+Line2);
		ReservationPage.Enter_Line3.sendKeys(Line3);
		test.log(LogStatus.PASS, "Enter Line3 : "+Line3);
		ReservationPage.Enter_City.sendKeys(City);
		test.log(LogStatus.PASS, "Enter City : "+City);
		new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
		test.log(LogStatus.PASS, "Select Country : "+Country);
		new Select(ReservationPage.Select_State).selectByVisibleText(State);
		test.log(LogStatus.PASS, "Select State : "+State);
		ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
		test.log(LogStatus.PASS, "Enter PostalCode : "+Postalcode);
		ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
		test.log(LogStatus.PASS, "Enter Phone number : "+Phonenumber);
		ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
		test.log(LogStatus.PASS, "Enter Alternate Number : "+alternativenumber);
		ReservationPage.Enter_email.sendKeys(Email);
		test.log(LogStatus.PASS, "Enter Email : "+Email);
		try
		{
			ReservationPage.Enter_Account.sendKeys(Account);
			test.log(LogStatus.PASS, "Enter Account : "+Account);
		}
		catch(Exception e)
		{

		}
		if(IsTaxExempt.equals("Yes"))
		{
			if(ReservationPage.Check_IsTaxExempt.isSelected())
			{
				ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);	
				test.log(LogStatus.PASS, "Enter Tax Exempt : "+TaxEmptext);
			}
			else
			{
				ReservationPage.Check_IsTaxExempt.click();
				test.log(LogStatus.PASS, "click Tax Exempt");
				ReservationPage.Enter_TaxExemptId.sendKeys(TaxEmptext);
				test.log(LogStatus.PASS, "Enter Tax Exempt : "+TaxEmptext);
			}
		}
	}



	public void contactInformation(WebDriver driver, ExtentTest test,
			String FirstName, String LastName, String Line1,
			String City, String Country,
			String State, String Postalcode, String Phonenumber) {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		//new Select(ReservationPage.Select_Saluation).selectByVisibleText(saluation);
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
		test.log(LogStatus.PASS, "Successfully entered the first name : "+FirstName);
		ReservationPage.Enter_Last_Name.sendKeys(LastName);
		test.log(LogStatus.PASS, "Successfully entered the last name : "+LastName);
		//ReservationPage.Enter_Address_Search.sendKeys(Address);
		ReservationPage.Enter_Line1.sendKeys(Line1);
		test.log(LogStatus.PASS, "Successfully entered the Address Line1 : "+Line1);
		//ReservationPage.Enter_Line2.sendKeys(Line2);
		//ReservationPage.Enter_Line3.sendKeys(Line3);
		ReservationPage.Enter_City.sendKeys(City);
		test.log(LogStatus.PASS, "Successfully entered the City : "+City);
		new Select(ReservationPage.Select_Country).selectByVisibleText(Country);
		test.log(LogStatus.PASS, "Successfully selected the Country : "+Country);
		new Select(ReservationPage.Select_State).selectByVisibleText(State);
		test.log(LogStatus.PASS, "Successfully selected the state : "+State);
		ReservationPage.Enter_Postal_Code.sendKeys(Postalcode);
		test.log(LogStatus.PASS, "Successfully entered the postal code : "+Postalcode);
		ReservationPage.Enter_Phone_Number.sendKeys(Phonenumber);
		test.log(LogStatus.PASS, "Successfully entered the phone number : "+Phonenumber);
		//ReservationPage.Enter_Alt_Phn_number.sendKeys(alternativenumber);
		//ReservationPage.Enter_email.sendKeys(Email);
	}




	public void billingInformation(WebDriver driver,ExtentTest test, String PaymentMethod,
			String AccountNumber, String ExpiryDate, String BillingNotes) {
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		new Select(ReservationPage.Select_Payment_Method).selectByVisibleText(PaymentMethod);
		test.log(LogStatus.PASS, "Successfully selected the state : "+PaymentMethod);
		if(PaymentMethod.equalsIgnoreCase("MC")||PaymentMethod.equalsIgnoreCase("Amex")||PaymentMethod.equalsIgnoreCase("Discover")||PaymentMethod.equalsIgnoreCase("Visa"))
		{
			ReservationPage.Enter_Account_Number.sendKeys(AccountNumber);
			test.log(LogStatus.PASS, "Successfully entered the Account number : "+AccountNumber);
			ReservationPage.Enter_Exp_Card.sendKeys(ExpiryDate);
			test.log(LogStatus.PASS, "Successfully entered the expiry date : "+ExpiryDate);
			ReservationPage.Enter_Billing_Note.sendKeys(BillingNotes);
			test.log(LogStatus.PASS, "Successfully entered the billing notes : "+BillingNotes);

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
		Wait.wait5Second();
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
			Assert.assertEquals(getRoomclassName[3],"Unassigned" );
		}
	}



	
	
	
	

	public void roomAssignment(WebDriver driver, ExtentTest test,String Nights, String Adults,
			String Children, String CheckorUncheckAssign, String RoomClassName,
			String RoomClassName2) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_RoomPicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on Rooms Picker");
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
		Wait.wait5Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on arrival date");
		ReservationPage.Click_Today.click();
		test.log(LogStatus.PASS, "Successfully clicked on Today");
		ReservationPage.Enter_Nigts.clear();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		test.log(LogStatus.PASS, "Successfully entered the nights : "+Nights);
		ReservationPage.Enter_Adults.clear();
		ReservationPage.Enter_Adults.sendKeys(Adults);
		test.log(LogStatus.PASS, "Successfully entered the audlts : "+Adults);
		ReservationPage.Enter_Children.clear();
		ReservationPage.Enter_Children.sendKeys(Children);
		test.log(LogStatus.PASS, "Successfully entered the childrens : "+Children);
		//ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);

		if(!ReservationPage.Check_Split_Rooms.isSelected()){
			ReservationPage.Check_Split_Rooms.click();
			test.log(LogStatus.PASS, "Successfully clicked on split rooms");
		}

		if(ReservationPage.Check_Assign_Room.isSelected())
		{
			//			ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
			test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
		}
		else
		{
			if(CheckorUncheckAssign.equals("Yes"))
			{
				ReservationPage.Check_Assign_Room.click();
				test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			}
			else
			{
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			}
		}
		/*	try
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

		}*/
		Thread.sleep(4000);
		int count=1;
		while(Integer.parseInt(Nights)>=count){
			WebElement ele=	driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+count+"]/td[2]/select"));
			WebElement ele1=	driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+count+"]/td[3]/select"));
			Select sel = new Select(ele);
			if(count==1){
				System.out.println(RoomClassName);
				sel.selectByVisibleText(RoomClassName);
				test.log(LogStatus.PASS, "Successfully selected the room class : "+RoomClassName);
				sel=new Select(ele1);
				java.util.List<WebElement> options = sel.getOptions(); 
				int roomCount=0;
                for(WebElement item:options) 
                {  
                 System.out.println(item.getText());
                 if(roomCount==1){
                 sel.selectByIndex(1);
                 test.log(LogStatus.PASS, "Successfully selected the room number : "+item.getText());
                 
                 break;
                 }
                 roomCount++;
                 }  
				
				
			}else{
				sel.selectByVisibleText(RoomClassName2);
				test.log(LogStatus.PASS, "Successfully selected the room class : "+RoomClassName2);
				sel=new Select(ele1);
				
				
				
				
				
				java.util.List<WebElement> options = sel.getOptions(); 
				int roomCount=0;
                for(WebElement item:options) 
                {  
                 System.out.println(item.getText());
                 if(roomCount==1){
                 sel.selectByIndex(1);
                 test.log(LogStatus.PASS, "Successfully selected the room number : "+item.getText());
                 
                 break;
                 }
                 roomCount++;
                 }  
				
				
				
				
				
				
				
				 


				
				
			}
			count++;
		}


		ReservationPage.Click_Select.click();
		test.log(LogStatus.PASS, "Successfully clicked on select");
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
			test.log(LogStatus.PASS, "Successfully clicked on rule brocken pop up");
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
		//Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[]= getRoomclassName_status.split(" ");
		//Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if(CheckorUncheckAssign.equals("Yes"))
		{

		}
		else
		{
			Assert.assertEquals(getRoomclassName[3],"Unassigned" );
		}
	}


	
	
	public void roomAssignment(WebDriver driver, ExtentTest test,String Nights, String Adults,
			String Children, String CheckorUncheckAssign, String RoomClassName
			) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_RoomPicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on Rooms Picker");
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
		Wait.wait5Second();
		ReservationPage.Click_Arrive_Datepicker.click();
		test.log(LogStatus.PASS, "Successfully clicked on arrival date");
		ReservationPage.Click_Today.click();
		test.log(LogStatus.PASS, "Successfully clicked on Today");
		ReservationPage.Enter_Nigts.clear();
		ReservationPage.Enter_Nigts.sendKeys(Nights);
		test.log(LogStatus.PASS, "Successfully entered the nights : "+Nights);
		ReservationPage.Enter_Adults.clear();
		ReservationPage.Enter_Adults.sendKeys(Adults);
		test.log(LogStatus.PASS, "Successfully entered the audlts : "+Adults);
		ReservationPage.Enter_Children.clear();
		ReservationPage.Enter_Children.sendKeys(Children);
		test.log(LogStatus.PASS, "Successfully entered the childrens : "+Children);
		//ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);

		/*if(!ReservationPage.Check_Split_Rooms.isSelected()){
			ReservationPage.Check_Split_Rooms.click();
			test.log(LogStatus.PASS, "Successfully clicked on split rooms");
		}*/

		if(ReservationPage.Check_Assign_Room.isSelected())
		{
			//			ReservationPage.Check_Assign_Room.click();
			ReservationPage.Click_Search.click();
			test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
		}
		else
		{
			if(CheckorUncheckAssign.equals("Yes"))
			{
				ReservationPage.Check_Assign_Room.click();
				test.log(LogStatus.PASS, "Successfully clicked on assign rooms");
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			}
			else
			{
				ReservationPage.Click_Search.click();
				test.log(LogStatus.PASS, "Successfully clicked on search");
			}
		}
		/*	try
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

		}*/
		Wait.wait5Second();
		int count=1;
		while(Integer.parseInt(Nights)>=count){
			WebElement ele=	driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+count+"]/td[2]/select"));
			WebElement ele1=	driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover table-condensed']/tbody/tr["+count+"]/td[3]/select"));
			Select sel = new Select(ele);
			if(count==1){
				System.out.println(RoomClassName);
				sel.selectByVisibleText(RoomClassName);
				test.log(LogStatus.PASS, "Successfully selected the room class : "+RoomClassName);
				sel=new Select(ele1);
				java.util.List<WebElement> options = sel.getOptions(); 
				int roomCount=0;
                for(WebElement item:options) 
                {  
                 System.out.println(item.getText());
                 if(roomCount==1){
                 sel.selectByIndex(1);
                 test.log(LogStatus.PASS, "Successfully selected the room number : "+item.getText());
                 
                 break;
                 }
                 roomCount++;
                 }  
				
				
			}
			count++;
		}


		ReservationPage.Click_Select.click();
		test.log(LogStatus.PASS, "Successfully clicked on select");
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
			test.log(LogStatus.PASS, "Successfully clicked on rule brocken pop up");
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
		//Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[]= getRoomclassName_status.split(" ");
		//Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if(CheckorUncheckAssign.equals("Yes"))
		{

		}
		else
		{
			Assert.assertEquals(getRoomclassName[3],"Unassigned" );
		}
	}
	


	public void saveReservationQuote(WebDriver driver, ExtentTest test) throws InterruptedException {


		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		double waittime = 0.12;
		long startTime = System.currentTimeMillis();
		ReservationPage.Click_Save_ReservationDetails.click();
		test.log(LogStatus.PASS, "Successfully clicked on save reservation");
		Wait.wait3Second();
		try
		{
			if(ReservationPage.Verify_Depos_policy.isDisplayed())
			{
				ReservationPage.Click_Without_Deposit.click();
				test.log(LogStatus.PASS, "Successfully clicked with out deposit");
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
		Wait.wait5Second();
		
		 try{
	    	 
	    	 Select sel = new Select(driver.findElement(By.xpath(OR.Get_QuoteReservation_Status)));
	    	 
	    	 WebElement ele=sel.getFirstSelectedOption();
	    
	    	 String str=ele.getText();
	    	System.out.println(str);
	    	assertTrue(str.equalsIgnoreCase("Reserved")||str.equalsIgnoreCase("Confirmed")||str.equalsIgnoreCase("On Hold"));
	    	test.log(LogStatus.PASS, "Reservation status : "+str);
	     }catch(Exception e)
			{
	    	 e.printStackTrace();
				System.out.println("Reservation status is not Reserved/Confirmed/On Hold");
			}
		
	}
	
	
	
	
	public void saveReservation(WebDriver driver, ExtentTest test) throws InterruptedException {


		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		double waittime = 0.12;
		long startTime = System.currentTimeMillis();
		ReservationPage.Click_Save_ReservationDetails.click();
		test.log(LogStatus.PASS, "Successfully clicked on save reservation");
		//Wait.wait3Second();
		try
		{
			if(ReservationPage.Verify_Depos_policy.isDisplayed())
			{
				ReservationPage.Click_Without_Deposit.click();
				test.log(LogStatus.PASS, "Successfully clicked with out deposit");
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
		Wait.wait5Second();
		
		
	}
	
	
	
	
	public void clickBook(WebDriver driver) throws InterruptedException{

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Book_Reservation.click();
		//Wait.wait5Second();
	}
	


	public void manualEmail(WebDriver driver, ExtentTest test,String Email, String Attachment) throws InterruptedException {

		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.Click_Email_icon.click();
		test.log(LogStatus.PASS, "Click on Email icon");
		Wait.explicit_wait_xpath(OR.Verify_Send_Email_Popup);
		Wait.explicit_wait_absenceofelement(OR.Verify_loading_popup_mailContentPopUp);
		//Wait.wait5Second();
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
			test.log(LogStatus.PASS, "Enter  Email : "+Email);
		}
		new Select (ReservationPage.Select_Attachment).selectByVisibleText(Attachment);
		test.log(LogStatus.PASS, "Select Attachment : "+Attachment);
	//	Wait.wait5Second();
		ReservationPage.Click_Send_Email.click();
		test.log(LogStatus.PASS, "Click on send Email");
		//Wait.wait5Second();
	}

	
	
	public void vaidatePaymentDetails(WebDriver driver, ExtentTest test){
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		
		String roomChargers=ReservationPage.Room_Charges.getText();
		String incidentals=ReservationPage.Incidentals.getText();
		String taxAndServiceCharges=ReservationPage.TaxesAndServiceCharges.getText();
		String Total=ReservationPage.TotalCharges.getText();
		
		test.log(LogStatus.PASS, "Tax is : "+taxAndServiceCharges);
		
		roomChargers=roomChargers.replace("$", "").trim();
		incidentals=incidentals.replace("$", "").trim();
		taxAndServiceCharges=taxAndServiceCharges.replace("$", "").trim();
		Total=Total.replace("$", "").trim();
		
		
		
		
		
		
		if(Double.parseDouble(roomChargers)+Double.parseDouble(incidentals)+Double.parseDouble(taxAndServiceCharges)==Double.parseDouble(Total)){
			test.log(LogStatus.PASS, "Totals are equal");
		}else{
			test.log(LogStatus.FAIL, "Totals are not equal");
		}
	}
	
	
	
	public void taxDetails(WebDriver driver, ExtentTest test) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		//Wait.wait5Second();
		String roomChargers=ReservationPage.Room_Charges.getText();
		String incidentals=ReservationPage.Incidentals.getText();
		String taxAndServiceCharges=ReservationPage.TaxesAndServiceCharges.getText();
		String Total=ReservationPage.TotalCharges.getText();
		
		test.log(LogStatus.PASS, "Tax is : "+taxAndServiceCharges);
		
		roomChargers=roomChargers.replace("$", "").trim();
		incidentals=incidentals.replace("$", "").trim();
		taxAndServiceCharges=taxAndServiceCharges.replace("$", "").trim();
		Total=Total.replace("$", "").trim();
		
		
		
		
		if(Double.parseDouble(taxAndServiceCharges)==0){
			test.log(LogStatus.PASS, "Tax is Zero");
		}else{
			test.log(LogStatus.FAIL, "Tax are not Zero");
		}
		
		ReservationPage.FirstOpenedReservationClose.click();
		//Wait.wait5Second();
	}
	


	public void validateTaxExempt(WebDriver driver, ExtentTest test) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		Wait.wait5Second();
		// Java script object creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		if(!ReservationPage.Check_IsTaxExempt.isSelected()){
			ReservationPage.Check_IsTaxExempt.click();
			test.log(LogStatus.PASS, "Tax exempt check box selected");

			String str=ReservationPage.TaxExemptThisFieldIsdRequired.getText();

			test.log(LogStatus.PASS, str);

			ReservationPage.Enter_TaxExemptId.sendKeys("123");
			test.log(LogStatus.PASS, "Entered Tax exempt id : "+"123");
		}
	}

	
	public void click_Folio(WebDriver driver, ExtentTest test) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		Wait.wait5Second();
		ReservationPage.MoveFolio_Folio.click();
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


	public String  GetReservationnumber(WebDriver driver,ExtentTest test) throws IOException
	{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationConfirmation =ReservationPage.Get_Confirmation_Number.getText();
		System.out.println("ReservationConfirmation :" +ReservationConfirmation);
		test.log(LogStatus.PASS, "Reservation Number is : "+ReservationConfirmation);
		try
		{
			BufferedWriter writer= new BufferedWriter(new FileWriter(".\\ConfirmationNumber.txt"));
			writer.write(ReservationConfirmation);
			writer.close();
		}
		catch(Exception e)
		{

		}
		
		
		return ReservationConfirmation;

	}
	
	
	public void clickGuestInfo(WebDriver driver,ExtentTest test){
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);
		ReservationPage.GuestInfo.click();
		test.log(LogStatus.PASS, "Successfully clicked on Guest Info");
	}
	
	public void getNotesCreated(WebDriver driver,ExtentTest test){
		
		
		int count=driver.findElements(By.xpath(OR.Get_Notes)).size();
		String str;
		
		for(int i=1;i<=count;i++){
			
			str="//table[@class='table table-striped table-bordered table-hover resGrid1']/tbody/tr["+i+"]/td[3]/a";
			System.out.println(driver.findElement(By.xpath(str)).getText());
			test.log(LogStatus.PASS, "Successfully get the note : "+driver.findElement(By.xpath(str)).getText());
		}
		
	}

		

	
}
