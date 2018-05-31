package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_Users {

WebDriver driver ;
	
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public Elements_Users(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);

	}
	
	@FindBy(xpath=OR.New_User_Btn)
	public WebElement New_User_Btn;
	
	@FindBy(xpath=OR.Users_Search_Btn)
	public WebElement Users_Search_Btn;
	
	@FindBy(xpath=OR.First_Element_In_Users_SearchResults)
	public WebElement First_Element_In_Users_SearchResults;
	
	@FindBy(xpath=OR.Enter_User_LoginId)
	public WebElement Enter_User_LoginId;
	
	@FindBy(xpath=OR.Users_Reset_Btn)
	public WebElement Users_Reset_Btn;
	
	
}
