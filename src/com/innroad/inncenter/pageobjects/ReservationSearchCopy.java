package com.innroad.inncenter.pageobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservationSearchCopy;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_CopyPage;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;


public class ReservationSearchCopy implements IReservationSearchCopy {

public static String selectedOption;

public static String copiedNextRoom;

public static Logger resunassignedCopyLogger = Logger.getLogger("ReservationSearchCopy");


public void roomAssignment(WebDriver driver,String PropertyName, String Nights, String Adults,
		String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName, String RoomNumber) throws InterruptedException {
	
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
	ReservationPage.Enter_Nigts.clear();
	ReservationPage.Enter_Nigts.sendKeys(Nights);
	ReservationPage.Enter_Adults.sendKeys(Adults);
	ReservationPage.Enter_Children.sendKeys(Children);
	ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);
	
	if(ReservationPage.Check_Assign_Room.isSelected())
	{
//		ReservationPage.Check_Assign_Room.click();
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
	selectedOption = new Select(ReservationPage.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
    resunassignedCopyLogger.info("selectedOption  " +selectedOption);
    Wait.wait5Second();
	if(selectedOption.equals("--Select--"))
	{
	//new Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
	// new Select(ReservationPage.Select_Room_Number).selectByIndex(5);
	 String selectedRoom= new Select(ReservationPage.Select_Room_Number).getFirstSelectedOption().getText();
	
	 resunassignedCopyLogger.info( " Selected Room number is " +selectedRoom);
	 
	 Thread.sleep(5000);
		//Select getRoomNumber=new Select(ReservationPage.Validating_UnAssgined_DDL);
		/*List<WebElement> getAllRoomNumbers=getRoomNumber.getOptions();
		for(WebElement getEachRoomNumber: getAllRoomNumbers)
			resunassignedCopyLogger.info(getEachRoomNumber.getText());
			resunassignedCopyLogger.info("Total no of rooms " +getAllRoomNumbers.size());*/
			
		
		//	nextRoom=getRoomNumber.getFirstSelectedOption().getText();
	 
	 
	 
		
				/*WebElement EachRoom=getRoomNumber.getFirstSelectedOption();
				resunassignedCopyLogger.info("The Selected Rooom Number is " +EachRoom.getText());
				*/
		 
		Wait.wait5Second();
	}
	else
	{
		  resunassignedCopyLogger.info("Reservation is unassigned");
	}
	}
	catch(Exception e)
	{
		Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
		resunassignedCopyLogger.info("Room Class are not Available for these dates");
		
	}
	ReservationPage.Click_Select.click();
	try
	{
		Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
	}
	catch(Exception e)
	{
		resunassignedCopyLogger.info("Verification failed");
	}
	Wait.wait5Second();
	if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
	{
		ReservationPage.Click_Continue_RuleBroken_Popup.click();
	}
	else
	{
		resunassignedCopyLogger.info("Satisfied Rules");
	}
	
	if(ReservationPage.Verify_Toaster_Container.isDisplayed())
	{
	String getTotasterTitle=ReservationPage.Toaster_Title.getText();
	String getToastermessage=ReservationPage.Toaster_Message.getText();
	resunassignedCopyLogger.info(getTotasterTitle + " " +getToastermessage);
	Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
	Assert.assertEquals(getToastermessage, "Room assignment has changed.");
	}
	Wait.wait2Second();
	String getPropertyName = ReservationPage.Get_Property_Name.getText();
	String getRoomclassName_status=ReservationPage.Get_RoomClass_Status.getText();
	resunassignedCopyLogger.info(getRoomclassName_status);
	Assert.assertEquals(getPropertyName,PropertyName );
	String getRoomclassName[]= getRoomclassName_status.split(" ");
	//Assert.assertEquals(getRoomclassName[0],RoomClassName );
	if(CheckorUncheckAssign.equals("Yes"))
	{
	
	}

	
	
}

public void copyReservation(WebDriver driver) throws InterruptedException {
	
	Elements_Reservation_CopyPage res_copy =new Elements_Reservation_CopyPage(driver);
	
	res_copy.click_Copy_Button.click();
	
	
	Thread.sleep(8000);
	
	res_copy.click_copiedRoomPicker.click();
	
	
	Thread.sleep(6000);
	/*Select getRoomNumber=new Select(res_copy.get_Room_Number);
	copiedNextRoom=getRoomNumber.getFirstSelectedOption().getText();*/
	
	copiedNextRoom=new Select(res_copy.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
	//String copiedNextRoom=res_copy.get_copiedRoom_Number.getText();
	

	//Assert.assertEquals( nextRoom, copiedNextRoom);
	resunassignedCopyLogger.info(" Copied Next room Number is " +copiedNextRoom);
	
	//Assert.assertEquals( nextRoom,copiedNextRoom);
	//Assert.assertEquals( nextRoom, nextRoomCopied);
	Assert.assertEquals( selectedOption, copiedNextRoom);
	
	res_copy.click_cancel_button.click();
	Thread.sleep(8000);
	
	
	resunassignedCopyLogger.info(" Reservation Copied ");
	Thread.sleep(8000);
	String copiedGuestName= res_copy.get_Copied_Guest_Name.getText();
	resunassignedCopyLogger.info(" Name of the Copied Guest Name is " +copiedGuestName);
	Thread.sleep(5000);

}
}
