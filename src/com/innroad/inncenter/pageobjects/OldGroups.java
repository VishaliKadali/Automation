package com.innroad.inncenter.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_AdvanceGroups;
import com.innroad.inncenter.webelements.Elements_OldGroups;

public class OldGroups {
	
	public String numberAsString;
	
	public void createGroupaccount(WebDriver driver,String MarketingSegment, String GroupReferral,String NumberofNights,String GroupAccountName, String GroupFirstName, String GroupLastName, String GroupPhn,
			String GroupAddress, String GroupCity, String Groupstate, String GroupPostale, String Groupscountry) throws InterruptedException
	{
		
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.GroupsNewAccount.click();
		Wait.wait10Second();
		Wait.explicit_wait_xpath(OR.Verify_New_Group_Account);
		new Select (oldGroup.MarketingSegment).selectByVisibleText(MarketingSegment);
		new Select (oldGroup.GroupReferral).selectByVisibleText(GroupReferral);
		oldGroup.oldGroup_startdate.click();
		oldGroup.oldGroup_Today.click();
		oldGroup.oldGroup_numberofNights.sendKeys(NumberofNights);
		long timestamp = System.currentTimeMillis();
		numberAsString = Long.toString(timestamp);
		System.out.println("timeStamp :" + timestamp);
		oldGroup.oldGroup_AccountNumber.clear();
		oldGroup.oldGroup_AccountNumber.sendKeys(numberAsString);
		oldGroup.AccountFirstName.sendKeys(GroupAccountName);
		oldGroup.GroupFirstName.sendKeys(GroupFirstName);
		oldGroup.GroupLastName.sendKeys(GroupLastName);
		oldGroup.GroupPhn.sendKeys(GroupPhn);
		oldGroup.GroupAddress.sendKeys(GroupAddress);
		oldGroup.GroupCity.sendKeys(GroupCity);
		new Select (oldGroup.Groupstate).selectByVisibleText(Groupstate);
		oldGroup.GroupPostale.sendKeys(GroupPostale);
		new Select (oldGroup.Groupscountry).selectByVisibleText(Groupscountry);
		Wait.wait5Second();
		oldGroup.Mailinginfo.click();
		
	}
	
	public void SaveAdvGroup(WebDriver driver)
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.GroupSave.click();
	}

	
	public void NavigateRoomBlock(WebDriver driver)
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.Navigate_Room_Block.click();
		Wait.explicit_wait_xpath(OR.old_Gropups_RoomBlockPage);
	}
	
	public void oldRoomBlock(WebDriver driver, String Adults)
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.oldGroup_Adults.clear();
		oldGroup.oldGroup_Adults.sendKeys(Adults);
		oldGroup.old_Groups_Click_Search.click();
	}
	public void BlockRoomForSelectedRoomclass(WebDriver driver, String EnterBlockedcount, String RoomClassName) throws InterruptedException
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		 List<WebElement> GetroomAvialbleCountsize = oldGroup.GetNumberofclasses;
		  System.out.println("GetroomAvialbleCount"+ GetroomAvialbleCountsize.size());
		  for(int i=0;i<GetroomAvialbleCountsize.size();i++)
			{
			  //int index = i+1;
			  int results = Integer.parseInt(GetroomAvialbleCountsize.get(i).getText());
			  
			  	//Wait.wait3Second();
			  double GetNightlyRate1, GetTotalRate1;	
			  
				if(results>=2)
				{
					//  Wait.wait3Second();
					try{
						String GetNightlyRate = driver.findElement(By.xpath("//*[@id='MainContentxucRateQuotexUwgRateQuote_rc_0_"+i+"_7']")).getText();				
						GetNightlyRate1  = Double.parseDouble(GetNightlyRate);
						  System.out.println("GetNightlyRate1  "+GetNightlyRate1);
						  String GetTotalRate = driver.findElement(By.xpath("//*[@id='MainContentxucRateQuotexUwgRateQuote_rc_0_"+i+"_8']")).getText();				
						  GetTotalRate1 = Double.parseDouble(GetTotalRate);
					}
					catch(Exception ex)
					{
						//checking if i value become equal to GetroomAvialbleCountsize then resetting the i value to 0 to restart the loop until we hit the cell    
						if(i+1 == GetroomAvialbleCountsize.size())
						{
							i = 0;
						}
						continue;
					}
					System.out.println("GetTotalRate1  "+GetTotalRate1);
					if(GetNightlyRate1 > 0 && GetTotalRate1 > 0 )
					{
				        System.out.println("results "+ results);
				        System.out.println("i "+ i);
				        WebElement d =   driver.findElement(By.xpath(".//*[@id='MainContentxucRateQuotexUwgRateQuote_rc_0_"+i+"_4']"));
				        Actions actions = new Actions(driver);
				        actions.moveToElement(d);
				        actions.click();
				        actions.sendKeys(EnterBlockedcount);
				        actions.build().perform();
				        Wait.wait5Second();
				        System.out.println("i out of box "+ i);
						break;
					}
				}
			}

	}
	
	public void SearchGroupAccount(WebDriver driver)
	{
		
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.oldGroups_Click_Groups.click();
		Wait.explicit_wait_xpath(OR.oldgroups_Verify_GroupSearchpage);
		oldGroup.oldGroup_AccountSearch_Accountnum.sendKeys(numberAsString);
		oldGroup.oldGroups_Account_ClickGo.click();
		String GetAccountNumber= oldGroup.oldGroups_Account_VerifyAccountNumber.getText();
		//Assert.assertEquals(GetAccountNumber, numberAsString);
	}
	
	public void SearchBookicon(WebDriver driver)
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.oldGroup_SearchBookicon.click();
		Wait.explicit_wait_xpath(OR.oldGroup_Verify_GroupPickPage);
	}
	
	public void pickfromRoominglist (WebDriver driver, String FirstName, String LastName) throws InterruptedException
	{
		Elements_OldGroups oldGroup= new Elements_OldGroups(driver);
		oldGroup.oldGroup_Click_Roominglistbutton.click();
		Wait.explicit_wait_xpath(OR.oldGroup_Verify_Roominglistpopup);
		oldGroup.oldGroups_Enter_FirstName_Roominglistpopup.sendKeys(FirstName);
		oldGroup.oldGroups_Enter_LastName_Roominglistpoup.sendKeys(LastName);
		new Select (oldGroup.oldGroups_Select_Roomclass_Roominglistpoup).selectByIndex(1);
		Wait.wait3Second();
		new Select (oldGroup.oldGroups_Select_RoomNo_Roominglistpopup).selectByIndex(1);
		Wait.wait3Second();
		oldGroup.oldGroups_Select_Pickupbutton_Roominglistpopup.click();
		Wait.explicit_wait_xpath(OR.oldGroup_Verify_Roominglistsummary);
		Wait.explicit_wait_xpath(OR.oldgroup_Verify_grid);
		oldGroup.oldGroup_Click_Close_Roominglistsummary.click();
		
	}
	
}
