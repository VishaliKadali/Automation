package com.innroad.inncenter.pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.innroad.inncenter.interfaces.IAddOrPostLineItem;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_FolioLineItemsVoid;

public class AddOrPostLineItem implements IAddOrPostLineItem {
	
	public static Logger addOrPostLineItemLogger = Logger.getLogger("AddOrPostLineItem");
	
	public void guestNameReservation(WebDriver driver) throws InterruptedException {
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		FolioLineItems.reservationGuestName.click();
		Wait.wait10Second();
	}
	

	public void clickFoliotab(WebDriver driver) throws InterruptedException{
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		try {
			FolioLineItems.click_Folio_tab.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wait.wait10Second();
	}
	
	
	public void adjustLineItem(WebDriver driver) throws InterruptedException{
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		boolean lineItemStatusPending=FolioLineItems.lineItem1.isDisplayed();
		boolean lineItemStatusPosted=FolioLineItems.lineItem2.isDisplayed();
		boolean lineItemStatusPostFutureDate=FolioLineItems.clickOkForPopup.isDisplayed();
		Wait.wait10Second();
		if(lineItemStatusPending==true&&lineItemStatusPosted==true)
		{
			
			FolioLineItems.lineItem1.click();
			
			if(lineItemStatusPostFutureDate==true){
				FolioLineItems.clickOkForPopup.click();
				Wait.wait10Second();
				FolioLineItems.closeReservation.click();
				
			}
			addOrPostLineItemLogger.info(" Posted the Line Item successfully ");
			Wait.wait15Second();
				FolioLineItems.clickSaveButton.click();
				Wait.wait10Second();
				FolioLineItems.clickOnDescription.click();
				Wait.wait10Second();
				FolioLineItems.clickRollBackButtonInPopUp.click();
				Wait.wait10Second();
				FolioLineItems.clickContinueButton.click();
				Wait.wait10Second();
				FolioLineItems.clickSaveButton.click();
				Wait.wait10Second();
			
		}
		
		else if(lineItemStatusPosted==true)
		{
			FolioLineItems.clickOnDescription.click();
			Wait.wait10Second();
			FolioLineItems.clickRollBackButtonInPopUp.click();
			Wait.wait10Second();
			FolioLineItems.clickContinueButton.click();
			Wait.wait10Second();
			addOrPostLineItemLogger.info(" Posted Line Item Rolled back successfully ");
			Wait.wait10Second();
			FolioLineItems.clickSaveButton.click();
			Wait.wait10Second();
		}
		
		
		
	}


}
