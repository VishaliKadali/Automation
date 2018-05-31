package com.innroad.inncenter.pageobjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IAddOrPostLineItem;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_FolioLineItemsVoid;

public class AddOrPostLineItem implements IAddOrPostLineItem {
	
	public static Logger addOrPostLineItemLogger = Logger.getLogger("AddOrPostLineItem");
	
	public void clickFoliotab(WebDriver driver) throws InterruptedException{
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		try {
			FolioLineItems.click_Folio_tab.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wait.explicit_wait_visibilityof_webelement(FolioLineItems.click_Add_Button);

	}
	
	public void addLineItem(WebDriver driver, String Amount) throws InterruptedException {
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		FolioLineItems.click_Add_Button.click();
		Wait.wait10Second();
		new Select(FolioLineItems.selectCategory).selectByIndex(9);
		Wait.wait10Second();
		FolioLineItems.enterAmount.sendKeys(Amount);
		Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickCommitButton);
		FolioLineItems.clickCommitButton.click();
		Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
		FolioLineItems.clickSaveButton.click();
		Wait.wait10Second();
		
	}
	
	
	
	public void adjustLineItem(WebDriver driver,String folioitemDescription, String folioLineAmount, String folioNotes) throws InterruptedException{
		Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
		//boolean lineItemStatusPending=FolioLineItems.lineItem1.isDisplayed();
		//boolean checkbox=FolioLineItems.verifyCheckbox.isEnabled();
		//boolean lineItemStatusPostFutureDate=FolioLineItems.clickOkForPopup.isDisplayed();
		Wait.wait10Second();
		if(FolioLineItems.lineItemPendingStatus.isDisplayed()==true)
		{
			if(FolioLineItems.verifyCheckboxPendingStatus.isEnabled())
			{
			Wait.explicit_wait_visibilityof_webelement(FolioLineItems.getBalanceFolioLineItems);
			String getBalance= FolioLineItems.getBalanceFolioLineItems.getText();
			addOrPostLineItemLogger.info(" Balance of the Folio Line Items before adjusting " +getBalance);	
				
			FolioLineItems.pendingItemDescription.click();
			Wait.explicit_wait_visibilityof_webelement(FolioLineItems.selectCategoryItem);
			new Select(FolioLineItems.selectCategoryItem).selectByIndex(1);
			Wait.explicit_wait_visibilityof_webelement(FolioLineItems.itemDescription);
			FolioLineItems.itemDescription.sendKeys(folioitemDescription);
			FolioLineItems.foliolineItemAmount.sendKeys(folioLineAmount);
			FolioLineItems.foliolineItemNotes.sendKeys(folioNotes);
			FolioLineItems.foliolineItemAddButton.click();
			FolioLineItems.foliolineItemContinueButton.click();
			
			Wait.explicit_wait_visibilityof_webelement(FolioLineItems.lineItemPendingStatus);
			 String getBalance1= FolioLineItems.getBalanceFolioLineItems.getText();
			 addOrPostLineItemLogger.info(" Balance of the Folio Line Items after adjusting " +getBalance1);
			FolioLineItems.lineItemPendingStatus.click();
			Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
			FolioLineItems.clickSaveButton.click();
			Wait.wait10Second();
			addOrPostLineItemLogger.info(" Posted the Line Item successfully ");
			Wait.wait15Second();	
			}
				/*FolioLineItems.clickSaveButton.click();
				Wait.wait10Second();
				FolioLineItems.clickOnDescription.click();
				Wait.wait10Second();
				FolioLineItems.clickRollBackButtonInPopUp.click();
				Wait.wait10Second();
				FolioLineItems.clickContinueButton.click();
				Wait.wait10Second();
				FolioLineItems.clickSaveButton.click();
				Wait.wait10Second();*/
			
		}
		//boolean lineItemStatusPosted=FolioLineItems.lineItem2.isDisplayed();
		
	//	try{
			
			
			if(FolioLineItems.lineItemPostStatus.isDisplayed()==true)
			{
				if(FolioLineItems.verifyCheckboxPostStatus.isEnabled()!=true){
					FolioLineItems.clickOnDescription.click();
					Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickRollBackButtonInPopUp);
					FolioLineItems.clickRollBackButtonInPopUp.click();
					Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickContinueButton);
					FolioLineItems.clickContinueButton.click();
					Wait.wait10Second();
					addOrPostLineItemLogger.info(" Posted Line Item Rolled back successfully ");
					Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
					FolioLineItems.clickSaveButton.click();
					Wait.wait10Second();
				}
				else {
					Assert.fail("Failed to Disable the checkbox after posting the line Item");
					
				}
			}
			
		
		
		
		/*catch(Exception e){
			
			addOrPostLineItemLogger.info(e.getMessage());*/
			
		}

}
