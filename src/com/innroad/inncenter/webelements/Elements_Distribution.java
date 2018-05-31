package com.innroad.inncenter.webelements;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;

public class Elements_Distribution {
	

	WebDriver driver ;
		
		public Elements_Distribution(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(this.driver, this);
			
		}

		@FindBy(id=OR.DistributionLink)
		public WebElement DistributionLink;
		
		@FindBy(id=OR.BlackoutsLink)
		public WebElement BlackoutsLink;
		
		@FindBy(css=OR.BlackOutRoomCheckBox)
		public List<WebElement> BlackOutRoomCheckBox;
		

		@FindBy(css=OR.BlackOutRoom_Save_Button1)
		public List<WebElement> BlackOutRoom_Save_Button1;
		
		@FindBy(id=OR.BlackOutRoom_Save_Button)
		public WebElement BlackOutRoom_Save_Button;
		
		@FindBy(id=OR.Select_Client)
		public WebElement Select_Client;
		
		@FindBy(xpath=OR.BlackoutsLink1)
		public WebElement BlackoutsLink1;
		
		
}
