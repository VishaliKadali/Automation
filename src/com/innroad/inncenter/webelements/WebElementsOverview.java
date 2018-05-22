package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.innroad.inncenter.properties.OR;


public class WebElementsOverview {

	public static Logger app_logs = Logger.getLogger("devpinoyLogger");

	WebDriver driver ;
	public WebElementsOverview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);


	}
	
	@FindBy(xpath=OR.Edit_Rate)
	public WebElement Edit_Rate; 
	

	@FindBy(xpath=OR.Rates_Override_Info_Popup)
	public WebElement Rates_Override_Info_Popup; 
	

	@FindBy(xpath=OR.First_Roomclass_P1_Rate)
	public WebElement First_Roomclass_P1_Rate; 
	

	@FindBy(xpath=OR.Save_Btn_In_Rates_Override_Info_Popup)
	public WebElement Save_Btn_In_Rates_Override_Info_Popup; 
	

	@FindBy(xpath=OR.Done_Btn_In_Rates_Override_Info_Popup)
	public WebElement Done_Btn_In_Rates_Override_Info_Popup; 
	

	@FindBy(xpath=OR.Cancel_Btn_In_Rates_Override_Info_Popup)
	public WebElement Cancel_Btn_In_Rates_Override_Info_Popup; 
	

	@FindBy(xpath=OR.Get_Rack_Rate)
	public WebElement Get_Rack_Rate; 


}

