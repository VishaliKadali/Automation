package com.innroad.inncenter.WebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class Elements_MovieFolio {

	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public Elements_MovieFolio(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);		 
	}
	
	
	@FindBy(xpath=OR.MoveFolio_Folio)
	public WebElement MoveFolio_Folio;
	
	
	@FindBy(xpath=OR.MoveFolio_GuestFolio)
	public WebElement MoveFolio_GuestFolio;
	
	@FindBy(xpath=OR.MoveFolio_NewFolio)
	public WebElement MoveFolio_NewFolio;
	
	
	@FindBy(xpath=OR.MoveFolio_NewFolio_Name)
	public WebElement MoveFolio_NewFolio_Name;
	
	@FindBy(xpath=OR.MoveFolio_NewFolio_Description)
	public WebElement MoveFolio_NewFolio_Description;
	
	
	@FindBy(xpath=OR.MoveFolio_NewFolio_Close)
	public WebElement MoveFolio_NewFolio_Close;
	
	
	@FindBy(xpath=OR.MoveFolio_NewFolio_Save)
	public WebElement MoveFolio_NewFolio_Save;
	
	@FindBy(xpath=OR.MoveFolio_NewFolio_SaveReservation)
	public WebElement MoveFolio_NewFolio_SaveReservation;
	
	@FindBy(xpath=OR.MoveFolio_SelectFiloItem)
	public WebElement MoveFolio_SelectFiloItem;
	
	@FindBy(xpath=OR.MoveFolio_Move)
	public WebElement MoveFolio_Move;
	
	
	@FindBy(xpath=OR.MoveFolio_TargetFolio)
	public WebElement MoveFolio_TargetFolio;

	@FindBy(xpath=OR.MoveFolio_FolioItemToMove)
	public WebElement MoveFolio_FolioItemToMove;
	
	@FindBy(xpath=OR.MoveFolio_MoveSelectedItem)
	public WebElement MoveFolio_MoveSelectedItem;
	
	
	@FindBy(xpath=OR.MoveFolio_Close)
	public WebElement MoveFolio_Close;
	
	
	@FindBy(xpath=OR.NewRervations)
	public WebElement NewRervations;
	
	
	@FindBy(xpath=OR.GuestInfo)
	public WebElement GuestInfo;
	
	@FindBy(xpath=OR.Reservations)
	public WebElement Reservations;
	
	
	@FindBy(xpath=OR.FirstOpenedReservation)
	public WebElement FirstOpenedReservation;
	
	@FindBy(xpath=OR.FirstOpenedReservationClose)
	public WebElement FirstOpenedReservationClose;
	
	
}
