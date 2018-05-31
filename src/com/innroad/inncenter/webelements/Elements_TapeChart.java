package com.innroad.inncenter.webelements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.innroad.inncenter.properties.OR;

public class Elements_TapeChart {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_TapeChart(WebDriver driver2)
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
			
		}
		
		@FindBy(xpath=OR.Select_Arrival_Date)
		public WebElement Select_Arrival_Date;
		
		@FindBy(xpath=OR.Enter_Adults_Tapehchart)
		public WebElement Enter_Adults_Tapehchart;

		@FindBy(xpath=OR.Enter_Children_Tapechart)
		public WebElement Enter_Children_Tapechart;
		
		@FindBy(xpath=OR.Click_Tapechart_Rateplan)
		public WebElement Click_Tapechart_Rateplan;
		
		@FindBy(xpath=OR.Enter_promoCode_Tapechart)
		public WebElement Enter_promoCode_Tapechart;
		
		@FindBy(xpath=OR.Click_First_Available)
		public WebElement Click_First_Available;
		
		@FindBy(xpath=OR.Click_Today)
		public WebElement Click_Today;
		
		@FindBy(xpath=OR.Get_Tapechart_Rateplan)
		public WebElement Get_Tapechart_Rateplan;
		
		@FindBy(xpath=OR.Select_Rack_Rate)
		public WebElement Select_Rack_Rate;
		
		@FindBy(xpath=OR.Click_Search_TapeChart)
		public WebElement Click_Search_TapeChart;
		
		@FindBy(xpath=OR.Rules_Broken_popup)
		public WebElement Rules_Broken_popup;
		
		@FindBy(xpath=OR.Click_Book_icon_Tapechart)
		public WebElement Click_Book_icon_Tapechart;
		
		@FindBy(xpath=OR.Click_Unassigned_Tapechart)
		public WebElement Click_Unassigned_Tapechart;
		
		@FindBy(xpath=OR.FirstRoomClass_Rate_In_Tapechart)
		public WebElement FirstRoomClass_Rate_In_Tapechart;
		
		@FindBy(xpath=OR.Click_First_Available_In_First_Roomclass)
		public WebElement Click_First_Available_In_First_Roomclass;
		
		
		@FindBy(className=OR.ReservationsLink)
	    public WebElement ReservationsLink;
		
		@FindBy(xpath=OR.Tape_Chart)
	    public WebElement Tape_Chart;
		
		@FindBy(css=OR.BlackOutCell)
	    public List<WebElement> BlackOutCell;
		
		@FindBy(xpath=OR.NewQuote)
	    public  WebElement NewQuote;
		
		@FindBy(css=OR.DatePickerIcon)
	    public  List<WebElement> DatePickerIcon;
		
		@FindBy(xpath=OR.Quote_SearchButton)
	    public  WebElement Quote_SearchButton;
		
		@FindBy(xpath=OR.BlackOutAlert)
	    public  WebElement BlackOutAlert;
		
		@FindBy(xpath=OR.Blackout_OkButton)
	    public  WebElement Blackout_OkButton;
		
		@FindBy(css=OR.SelectDate)
	    public WebElement SelectDate;
		
		@FindBy(className=OR.BookButton)
	    public  List<WebElement> BookButton;
		

}
