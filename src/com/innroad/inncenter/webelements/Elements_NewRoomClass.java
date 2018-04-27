package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_NewRoomClass{
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public Elements_NewRoomClass(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);		 
	}
	
	
	@FindBy(xpath=OR.New_RoomClass_Name)
	public WebElement NewRoomClassName;
	
	
	@FindBy(xpath=OR.New_RoomClass_Abbrivation)
	public WebElement NewRoomClassAbbrivation;
	
	@FindBy(xpath=OR.New_RoomClass_KingBeds)
	public WebElement NewRoomClassKingBeds;
	
	
	@FindBy(xpath=OR.New_RoomClass_RoomType_AdjoiningRooms)
	public WebElement New_RoomClassRoomTypeAdjoiningRooms;
	
	@FindBy(xpath=OR.New_RoomClass_Rooms)
	public WebElement NewRoomClassRooms;
	
	@FindBy(xpath=OR.New_RoomClass_Max_Adults)
	public WebElement NewRoomClassMaxAdults;
	

	@FindBy(xpath=OR.New_RoomCLass_Max_Persons)
	public WebElement NewRoomClassMaxPersons;
	
	@FindBy(xpath=OR.New_RoomClass_Room_Quantity)
	public WebElement NewRoomClassRoomQuantity;
	
	
	@FindBy(xpath=OR.New_RoomClass_Create_Rooms)
	public WebElement NewRoomClassCreateRooms;
	
	
	@FindBy(xpath=OR.New_RoomClass_RoomNumber)
	public WebElement NewRoomClassRoomNumber;
	
	
	
	@FindBy(xpath=OR.New_RoomClass_AssignRoomNumber)
	public WebElement NewRoomClassAssignRoomNumbers;
	
	@FindBy(xpath=OR.New_RoomClass_Save)
	public WebElement NewRoomClassSave;
	
	
	@FindBy(xpath=OR.New_RoomClass_Publish)
	public WebElement NewRoomClassPublish;
	
	@FindBy(xpath=OR.New_RoomClass_OK)
	public WebElement NewRoomClassOk;
	
	@FindBy(xpath=OR.New_RoomClasses)
	public WebElement NewRoomClasses;
	
	@FindBy(xpath=OR.New_RoomClass_Msg_Publish)
	public WebElement NewRoomClassesMsgAfterPublish;
	
	

}
