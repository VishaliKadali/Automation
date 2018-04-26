package com.innroad.inncenter.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_AdvanceGroups;

public class AdvGroups {
	
	public static Logger advGroupsLogger=Logger.getLogger("AdvGroups");
	
	public void createGroupaccount(WebDriver driver,String MarketingSegment, String GroupReferral, String GroupAccountName, String GroupFirstName, String GroupLastName, String GroupPhn,
			String GroupAddress, String GroupCity, String Groupstate, String GroupPostale, String Groupscountry) throws InterruptedException
	{
		
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		
//		AdvGroup.GroupsNewAccount.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement btnNewAccount=AdvGroup.GroupsNewAccount;
		js.executeScript("arguments[0].click();", btnNewAccount);
		
		Wait.wait10Second();
		Wait.explicit_wait_xpath(OR.Verify_New_Group_Account);
		new Select (AdvGroup.MarketingSegment).selectByVisibleText(MarketingSegment);
		new Select (AdvGroup.GroupReferral).selectByVisibleText(GroupReferral);
		AdvGroup.AccountFirstName.sendKeys(GroupAccountName);
		AdvGroup.GroupFirstName.sendKeys(GroupFirstName);
		AdvGroup.GroupLastName.sendKeys(GroupLastName);
		AdvGroup.GroupPhn.sendKeys(GroupPhn);
		AdvGroup.GroupAddress.sendKeys(GroupAddress);
		AdvGroup.GroupCity.sendKeys(GroupCity);
		new Select (AdvGroup.Groupstate).selectByVisibleText(Groupstate);
		AdvGroup.GroupPostale.sendKeys(GroupPostale);
		new Select (AdvGroup.Groupscountry).selectByVisibleText(Groupscountry);
		Wait.wait5Second();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
//		AdvGroup.Mailinginfo.click();
		WebElement mailingInfoCB=AdvGroup.Mailinginfo;
		jse.executeScript("arguments[0].scrollIntoView(true);", mailingInfoCB);
		jse.executeScript("arguments[0].click();", mailingInfoCB);
		
	}
	
	public void SaveAdvGroup(WebDriver driver)
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		AdvGroup.GroupSave.click();
	}

	public void EnterBlockName(WebDriver driver, String BlockName)
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		
//		AdvGroup.Click_New_Block_button.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement btnNewBlock=AdvGroup.Click_New_Block_button;
		js.executeScript("arguments[0].click();", btnNewBlock);
		
		Wait.explicit_wait_xpath(OR.Verify_Block_Details_Popup);
		AdvGroup.Enter_Block_Name.sendKeys(BlockName);
		AdvGroup.Click_Ok.click();
		Wait.explicit_wait_xpath(OR.Verify_Rate_Quote);
		
	}
	
	public void SearchGroupCriteria(WebDriver driver, String NumberofNights) throws InterruptedException
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		AdvGroup.Select_Arrival_Date_Groups.click();
		AdvGroup.Click_Today_Arrival_Groups.click();
		AdvGroup.Enter_No_of_Nigts.sendKeys(NumberofNights);
		AdvGroup.Click_Search_Group.click();
		Wait.explicit_wait_xpath(OR.Verify_Room_Class_Grid_Groups);
		Wait.wait5Second();
	}
	
	//Update automatically Updated Rooms
	public void updatedAutomaticallyAssignedRooms(WebDriver driver, String UpdatedBlockedRoom) throws InterruptedException
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		List<WebElement> BlockedRooms = AdvGroup.GetBlockedRowsize;
		advGroupsLogger.info(BlockedRooms.size());
		
		 for(int i=0;i<BlockedRooms.size();i++)
			{
//			 advGroupsLogger.info(BlockedRooms.get(i).getAttribute("value"));
			 String BlockedRoomsCount=  BlockedRooms.get(i).getAttribute("value");
			 int BlockedRoomsvalues = Integer.parseInt(BlockedRoomsCount);
			 if(BlockedRoomsvalues>0)
			 {
				 int index = i+1;
				 driver.findElement(By.xpath("//tbody[@data-bind='foreach: serverData.objListRoomClass']//tr["+index+"]/td[3]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"),UpdatedBlockedRoom);
				 Wait.wait5Second();
				 break;
			 }
			}
	}
	
	//Select Room class for block
	
	public void BlockRoomForSelectedRoomclass(WebDriver driver, String EnterBlockedcount, String RoomClassName) throws InterruptedException
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		 List<WebElement> GetRoomclassNames = AdvGroup.GetRoomclasses;
		 advGroupsLogger.info("GetRoomclassNames"+ GetRoomclassNames.size());
		  for(int i=0;i<GetRoomclassNames.size();i++)
			{
				if(GetRoomclassNames.get(i).getText().equals(RoomClassName))
				{
			        int index = i+1;
			        driver.findElement(By.xpath("//tbody[@data-bind='foreach: serverData.objListRoomClass']//tr["+index+"]/td[3]/input")).sendKeys(Keys.chord(Keys.CONTROL, "a"),EnterBlockedcount);
					 Wait.wait5Second();
					
					break;
				}
			}

	}
	
	public void ClickCreateBlock(WebDriver driver)
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		AdvGroup.Click_Create_Block.click();
		if(AdvGroup.Verify_Block_Nights.isDisplayed())
		{
			AdvGroup.Click_Continue_Block_Night.click();
		}
		else
		{
			
		}
		Wait.explicit_wait_xpath(OR.Verify_Release_Date_Popup);
		AdvGroup.Click_Ok_On_Rel_Popup.click();
		Wait.explicit_wait_xpath(OR.Verifyroom_block_content);
		
	}
	
	public void ClickBookicon(WebDriver driver, String RoomClassName) throws InterruptedException
	{
		Wait.wait5Second();
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		Wait.wait10Second();
		 List<WebElement> RoomCount = AdvGroup.CountofRooms;
		 advGroupsLogger.info("RoomCount"+ RoomCount.size());
		  for(int i=0;i<RoomCount.size();i++)
			{
				if(RoomCount.get(i).getText().equals(RoomClassName))
				{
					JavascriptExecutor jse=(JavascriptExecutor)driver;
					jse.executeScript("window.scrollBy(0,150);");
			        int index = i+1;
			        driver.findElement(By.xpath("//div[@id='row"+i+"JQGrid']//div[@class='book']")).click();
					 Wait.wait5Second();
					
					break;
				}
			}
	}
	
	public void NavigateRoomBlock(WebDriver driver)
	{
		Elements_AdvanceGroups AdvGroup= new Elements_AdvanceGroups(driver);
		AdvGroup.Navigate_Room_Block.click();
		Wait.explicit_wait_xpath(OR.Verifyroom_block_content);
	}
}
