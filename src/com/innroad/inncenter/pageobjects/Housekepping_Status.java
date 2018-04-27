package com.innroad.inncenter.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IHousekepping_Status;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.WebElements_Housekeeping_Status;

public class Housekepping_Status implements IHousekepping_Status{

	//select room condition clean/dirty/inspected in table header
	public void Select_Room_Condition_In_Header(WebDriver driver,String roomcondition) throws InterruptedException {
		
		driver.findElement(By.xpath("//tr[@class='dgHeader']//label[text()='"+roomcondition+"']/../input")).click();
	    Wait.wait2Second();
	}


	//select list items per page
	public void Select_Items_Per_Page(WebDriver driver,String itemsperpage) throws InterruptedException {
		WebElements_Housekeeping_Status Housekeeping_Status=new WebElements_Housekeeping_Status(driver);
		new Select(Housekeeping_Status.Select_Items_Per_Page).selectByVisibleText(itemsperpage);
	
	}
   
   //save changes
	public void Save(WebDriver driver) throws InterruptedException {
		
		WebElements_Housekeeping_Status Housekeeping_Status=new WebElements_Housekeeping_Status(driver);
		Housekeeping_Status.Save_Housekeeping_Status.click();
		Wait.wait2Second();
	}

	
}
