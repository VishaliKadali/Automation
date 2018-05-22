package com.innroad.inncenter.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservationCopy_Assigned;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_CopyPage;





public class ReservationCopy_Assigned implements IReservationCopy_Assigned{
	
public static String nextRoom;	

public static String copiedNextRoom;

public static Logger resCopyAssignedLogger = Logger.getLogger("ReservationCopy_Assigned");

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
        resCopyAssignedLogger.info("selectedOption  " +selectedOption);
        Wait.wait5Second();
		if(selectedOption.equals("--Select--"))
		{
		//new Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
		 new Select(ReservationPage.Select_Room_Number).selectByIndex(5);
		 String selectedRoom= new Select(ReservationPage.Select_Room_Number).getFirstSelectedOption().getText();
		
		 resCopyAssignedLogger.info( " Selected Room number is " +selectedRoom);
		 
		 Thread.sleep(5000);
			Select getRoomNumber=new Select(ReservationPage.Select_Room_Number);
			
			List<WebElement> getAllRoomNumbers=getRoomNumber.getOptions();
			
			for(WebElement getEachRoomNumber: getAllRoomNumbers)
//				resCopyAssignedLogger.info(getEachRoomNumber.getText());
				resCopyAssignedLogger.info("Total no of rooms " +getAllRoomNumbers.size());
				nextRoom=getAllRoomNumbers.get(1).getText();
				resCopyAssignedLogger.info(" Next  availble Room is " +nextRoom);
				WebElement EachRoom=getRoomNumber.getFirstSelectedOption();
				resCopyAssignedLogger.info("The Selected Rooom Number is " +EachRoom.getText());
				Wait.wait5Second();
		}
		else
		{
			  resCopyAssignedLogger.info("Reservation is unassigned");
		}
		}
		catch(Exception e)
		{
			Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
			resCopyAssignedLogger.info("Room Class are not Available for these dates");
			
		}
		ReservationPage.Click_Select.click();
		try
		{
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		}
		catch(Exception e)
		{
			resCopyAssignedLogger.info("Verification failed");
		}
		Wait.wait5Second();
		if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
		{
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
		}
		else
		{
			resCopyAssignedLogger.info("Satisfied Rules");
		}
		
		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle=ReservationPage.Toaster_Title.getText();
		String getToastermessage=ReservationPage.Toaster_Message.getText();
		resCopyAssignedLogger.info(getTotasterTitle + " " +getToastermessage);
		Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
		Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}
		Wait.wait2Second();
		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status=ReservationPage.Get_RoomClass_Status.getText();
		resCopyAssignedLogger.info(getRoomclassName_status);
		Assert.assertEquals(getPropertyName,PropertyName );
		String getRoomclassName[]= getRoomclassName_status.split(" ");
		//Assert.assertEquals(getRoomclassName[0],RoomClassName );
		if(CheckorUncheckAssign.equals("Yes"))
		{
		
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
      	 resCopyAssignedLogger.info(totalTime + " in Millsecs");
      	 double TotalTimeinsecs = totalTime/1000;
      	 double ActualTime = TotalTimeinsecs - waittime - 3;
      	 resCopyAssignedLogger.info(ActualTime + " in secs");
		if(getToastermessage_ReservationSucess.endsWith("has been saved successfully"));
		
		}
		}
		catch(Exception e)
		{
			
		}
		Wait.wait10Second();
		
	}


public void copyReservation(WebDriver driver) throws InterruptedException {
	
	Elements_Reservation_CopyPage res_copy =new Elements_Reservation_CopyPage(driver);
	
	res_copy.click_Copy_Button.click();
	
	
	Thread.sleep(8000);
	
	res_copy.click_copiedRoomPicker.click();
	
	
	Thread.sleep(5000);
	Select getRoomNumber=new Select(res_copy.get_Room_Number);
	copiedNextRoom=getRoomNumber.getFirstSelectedOption().getText();
	//String copiedNextRoom=res_copy.get_copiedRoom_Number.getText();
	

	//Assert.assertEquals( nextRoom, copiedNextRoom);
	resCopyAssignedLogger.info(" Copied Next room Number is " +copiedNextRoom);
	
	//Assert.assertEquals( nextRoom,copiedNextRoom);
	//Assert.assertEquals( nextRoom, nextRoomCopied);
	Assert.assertEquals( nextRoom, copiedNextRoom);
	
	res_copy.click_cancel_button.click();
	Thread.sleep(8000);
	
	
	resCopyAssignedLogger.info(" Reservation Copied ");
	Thread.sleep(8000);
	String copiedGuestName= res_copy.get_Copied_Guest_Name.getText();
	resCopyAssignedLogger.info(" Name of the Copied Guest Name is " +copiedGuestName);
	Thread.sleep(5000);

}
	
}

	


