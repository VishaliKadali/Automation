package com.innroad.inncenter.WebElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class WebElements_Create_Seasons {
	
	WebDriver driver;

	public WebElements_Create_Seasons(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id=OR.New_Seasons)
	public WebElement New_Seasons_link;
	
	@FindBy(xpath=OR.Select_Property_in_Seasons)
	public WebElement Selecting_Property_in_Season;
	
	@FindBy(xpath=OR.New_Season_Button)
	public WebElement New_Season_Buttom;
	
	@FindBy(id=OR.EG_Select_Property_in_Seasons)
	public WebElement EG_Select_Property_in_Seasons;

	@FindBy(id=OR.EG_New_Seasons_Button)
	public WebElement EG_New_Seasons_Button;

	@FindBy(xpath=OR.NG_Season_Name)
	public WebElement NG_Season_Name;
	
	@FindBy(xpath=OR.NG_Season_start_Date)
	public WebElement NG_Season_start_Date;
	
	@FindBy(xpath=OR.NG_Season_End_Date)
	public WebElement NG_Season_End_Date;
	
	@FindBy(xpath=OR.NG_Season_Save)
	public WebElement NG_Season_Save;
	
	
	@FindBy(id=OR.EG_Season_Name)
	public WebElement EG_Season_Name;
	
	@FindBy(xpath=OR.EG_start_Picker)
	public WebElement EG_start_Picker;
	
	@FindBy(xpath=OR.EG_Season_start_Date)
	public WebElement EG_Season_start_Date;
	
	@FindBy(xpath=OR.EG_End_picker)
	public WebElement EG_End_picker;
	
	@FindBy(id=OR.EG_Season_End_Date)
	public WebElement EG_Season_End_Date;
	
	@FindBy(id=OR.EG_Season_Save)
	public WebElement EG_Season_Save;
	
	

}
