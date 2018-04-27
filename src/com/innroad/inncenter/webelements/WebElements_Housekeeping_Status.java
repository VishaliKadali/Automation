package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class WebElements_Housekeeping_Status {
	
	WebDriver driver ;
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public WebElements_Housekeeping_Status(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);
		
		 
	}
	
	
	@FindBy(xpath=OR.Select_Items_Per_Page)
	public WebElement Select_Items_Per_Page;
	
	@FindBy(xpath=OR.Select_Rmcondition_In_Theader)
	public WebElement Select_Rmcondition_In_Theader;
	
	@FindBy(xpath=OR.Save_Housekeeping_Status)
	public WebElement Save_Housekeeping_Status;

}
