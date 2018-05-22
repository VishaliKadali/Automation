package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservationNonRackRate;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;



public class ReservationNonRackRate implements IReservationNonRackRate{
	
	public static Logger resNonRackRateLogger = Logger.getLogger("ReservationNonRackRate");
	
	public void roomAssignment(WebDriver driver,String PropertyName1, String Nights, String Adults,
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
		//ReservationPage.Enter_Rate_Promocode.sendKeys(RatepromoCode);
		new Select(ReservationPage.selectRackRate).selectByIndex(13);
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
		
		new Select(ReservationPage.Select_Room_Class).selectByIndex(1);
		String selectedOption = new Select(ReservationPage.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
        resNonRackRateLogger.info("selectedOption  " +selectedOption);
		if(selectedOption.equals("--Select--"))
		{
		//new Select(ReservationPage.Select_Room_Number).selectByVisibleText(RoomNumber);
			new Select(ReservationPage.Select_Room_Number).selectByIndex(1);
			Wait.wait5Second();
		}
		else
		{
			  resNonRackRateLogger.info("Reservation is unassigned");
		}
		}
		catch(Exception e)
		{
			Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
			resNonRackRateLogger.info("Room Class are not Available for these dates");
			
		}
		ReservationPage.Click_Select.click();
		try
		{
			Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
		}
		catch(Exception e)
		{
			resNonRackRateLogger.info("Verification failed");
		}
		Wait.wait5Second();
		if(ReservationPage.Verify_RulesBroken_Popup.isDisplayed())
		{
			ReservationPage.Click_Continue_RuleBroken_Popup.click();
		}
		else
		{
			resNonRackRateLogger.info("Satisfied Rules");
		}
		
		if(ReservationPage.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle=ReservationPage.Toaster_Title.getText();
		String getToastermessage=ReservationPage.Toaster_Message.getText();
		resNonRackRateLogger.info(getTotasterTitle + " " +getToastermessage);
		Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
		Assert.assertEquals(getToastermessage, "Room assignment has changed.");
		}
		Wait.wait2Second();
		String getPropertyName = ReservationPage.Get_Property_Name.getText();
		String getRoomclassName_status=ReservationPage.Get_RoomClass_Status.getText();
		resNonRackRateLogger.info(getRoomclassName_status);
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

	

}
