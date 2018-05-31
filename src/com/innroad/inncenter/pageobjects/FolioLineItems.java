package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.innroad.inncenter.interfaces.IFolioLineItemsVoid;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_FolioLineItemsVoid;



public class FolioLineItems implements IFolioLineItemsVoid{

public static Logger folioVoidLogger = Logger.getLogger("FolioLineItems");

public void IPropertySelector(WebDriver driver, String PropertyName) throws InterruptedException {
		
		if(driver.findElement(By.xpath("//b[@role='presentation']")).isDisplayed())
		{
		
		driver.findElement(By.id("s2id_autogen1")).click();
		//Wait.explicit_wait_xpath("select2-drop");
		driver.findElement(By.xpath("//li/div[.='"+PropertyName+"']")).click();
        Wait.wait15Second(); 
		}
		else
		{
			folioVoidLogger.info("Single Property");
		}
	}
	
public void clickNewReservationButton(WebDriver driver) throws InterruptedException {
	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	FolioLineItems.New_Reservation_Button.click();
	Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
	Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
}

public void marketingInfo(WebDriver driver, String MarketSegment,
		String Referral, String Travel_Agent, String ExtReservation) throws InterruptedException {
	
	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	new Select(FolioLineItems.Reservation_market_Segment).selectByVisibleText(MarketSegment);
	new Select(FolioLineItems.Reservation_Referral).selectByVisibleText(Referral);
	try
	{
	FolioLineItems.Enter_Travel_Agent.sendKeys(Travel_Agent);
	}
	catch(Exception e)
	{
		
	}
	FolioLineItems.Enter_Ext_Reservation.sendKeys(ExtReservation);
}


public void contactInformation(WebDriver driver, String saluation,
		String FirstName, String LastName, String Address, String Line1,
		String Line2, String Line3, String City, String Country,
		String State, String Postalcode, String Phonenumber,
		String alternativenumber, String Email, String Account,String IsTaxExempt,
		String TaxEmptext) {
	
	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	
	new Select(FolioLineItems.Select_Saluation).selectByVisibleText(saluation);
	FolioLineItems.Enter_First_Name.clear();
	FolioLineItems.Enter_Last_Name.clear();
	FolioLineItems.Enter_Address_Search.clear();
	FolioLineItems.Enter_Line1.clear();
	FolioLineItems.Enter_Line2.clear();
	FolioLineItems.Enter_Line3.clear();
	FolioLineItems.Enter_City.clear();
	FolioLineItems.Enter_Postal_Code.clear();;
	FolioLineItems.Enter_Phone_Number.clear();;
	FolioLineItems.Enter_Alt_Phn_number.clear();;
	FolioLineItems.Enter_email.clear();;
	FolioLineItems.Enter_First_Name.sendKeys(FirstName);
	FolioLineItems.Enter_Last_Name.sendKeys(LastName);
	FolioLineItems.Enter_Address_Search.sendKeys(Address);
	FolioLineItems.Enter_Line1.sendKeys(Line1);
	FolioLineItems.Enter_Line2.sendKeys(Line2);
	FolioLineItems.Enter_Line3.sendKeys(Line3);
	FolioLineItems.Enter_City.sendKeys(City);
	new Select(FolioLineItems.Select_Country).selectByVisibleText(Country);
	new Select(FolioLineItems.Select_State).selectByVisibleText(State);
	FolioLineItems.Enter_Postal_Code.sendKeys(Postalcode);
	FolioLineItems.Enter_Phone_Number.sendKeys(Phonenumber);
	FolioLineItems.Enter_Alt_Phn_number.sendKeys(alternativenumber);
	FolioLineItems.Enter_email.sendKeys(Email);
	try
	{
	FolioLineItems.Enter_Account.sendKeys(Account);
	}
	catch(Exception e)
	{
		
	}
	if(IsTaxExempt.equals("Yes"))
	{
	if(FolioLineItems.Check_IsTaxExempt.isSelected())
	{
	FolioLineItems.Enter_TaxExemptId.sendKeys(TaxEmptext);	
	}
	else
	{
		FolioLineItems.Check_IsTaxExempt.click();
		FolioLineItems.Enter_TaxExemptId.sendKeys(TaxEmptext);
	}
	}
}

public void billingInformation(WebDriver driver, String PaymentMethod,
		String AccountNumber, String ExpiryDate, String BillingNotes) {
	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	new Select(FolioLineItems.Select_Payment_Method).selectByVisibleText(PaymentMethod);
	if(PaymentMethod.equalsIgnoreCase("MC")||PaymentMethod.equalsIgnoreCase("Amex")||PaymentMethod.equalsIgnoreCase("Discover")||PaymentMethod.equalsIgnoreCase("Visa"))
	{
		FolioLineItems.Enter_Account_Number.sendKeys(AccountNumber);
		FolioLineItems.Enter_Exp_Card.sendKeys(ExpiryDate);
		FolioLineItems.Enter_Billing_Note.sendKeys(BillingNotes);
		
	}
}

public void roomAssignment(WebDriver driver,String PropertyName, String Nights, String Adults,
		String Children, String RatepromoCode,String CheckorUncheckAssign, String RoomClassName,
		String RoomNumber) throws InterruptedException {
	
	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	FolioLineItems.Click_RoomPicker.click();
	Wait.explicit_wait_xpath(OR.Room_Assignment_PopUp);
	Wait.wait3Second();
	/*try
	{
	new Select(FolioLineItems.Select_property_RoomAssign).selectByVisibleText(PropertyName);
	}
	catch(Exception e)
	{
		new Select(FolioLineItems.Select_property_RoomAssign2).selectByVisibleText(PropertyName);
	}*/
	Wait.wait15Second();
	FolioLineItems.Click_Arrive_Datepicker.click();
	FolioLineItems.Click_Today.click();
	FolioLineItems.Enter_Nigts.clear();
	FolioLineItems.Enter_Nigts.sendKeys(Nights);
	FolioLineItems.Enter_Adults.sendKeys(Adults);
	FolioLineItems.Enter_Children.sendKeys(Children);
	FolioLineItems.Enter_Rate_Promocode.sendKeys(RatepromoCode);
	
	if(FolioLineItems.Check_Assign_Room.isSelected())
	{
//		FolioLineItems.Check_Assign_Room.click();
		FolioLineItems.Click_Search.click();
	}
	else
	{
		if(CheckorUncheckAssign.equals("Yes"))
		{
			FolioLineItems.Check_Assign_Room.click();
			FolioLineItems.Click_Search.click();
		}
		else
		{
			FolioLineItems.Click_Search.click();
		}
	}
	try
	{
	
	new Select(FolioLineItems.Select_Room_Class).selectByVisibleText(RoomClassName);
	String selectedOption = new Select(FolioLineItems.Validating_UnAssgined_DDL).getFirstSelectedOption().getText();
	folioVoidLogger.info("selectedOption  " +selectedOption);
	if(selectedOption.equals("--Select--"))
	{
	//new Select(FolioLineItems.Select_Room_Number).selectByVisibleText(RoomNumber);
		new Select(FolioLineItems.Select_Room_Number).selectByIndex(1);
	}
	else
	{
		folioVoidLogger.info("Reservation is unassigned");
	}
	}
	catch(Exception e)
	{
		Wait.explicit_wait_xpath(OR.Validation_Text_NoRooms);
		folioVoidLogger.info("Room Class are not Available for these dates");
		
	}
	FolioLineItems.Click_Select.click();
	try
	{
		Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
	}
	catch(Exception e)
	{
		folioVoidLogger.info("Verification failed");
	}
	Wait.wait5Second();
	if(FolioLineItems.Verify_RulesBroken_Popup.isDisplayed())
	{
		FolioLineItems.Click_Continue_RuleBroken_Popup.click();
	}
	else
	{
		folioVoidLogger.info("Satisfied Rules");
	}
	
	if(FolioLineItems.Verify_Toaster_Container.isDisplayed())
	{
	String getTotasterTitle=FolioLineItems.Toaster_Title.getText();
	String getToastermessage=FolioLineItems.Toaster_Message.getText();
	folioVoidLogger.info(getTotasterTitle + " " +getToastermessage);
	Assert.assertEquals(getTotasterTitle, "Room assignment has changed.");
	Assert.assertEquals(getToastermessage, "Room assignment has changed.");
	}
	Wait.wait2Second();
	String getPropertyName = FolioLineItems.Get_Property_Name.getText();
	String getRoomclassName_status=FolioLineItems.Get_RoomClass_Status.getText();
	folioVoidLogger.info(getRoomclassName_status);
	Assert.assertEquals(getPropertyName,PropertyName );
	String getRoomclassName[]= getRoomclassName_status.split(" ");
	//Assert.assertEquals(getRoomclassName[0],RoomClassName );
	if(CheckorUncheckAssign.equals("Yes"))
	{
	
	}
	else
	{
		Assert.assertEquals(getRoomclassName[3],"Unassigned" );
	}
}

//Save the Reservation
public void saveReservation(WebDriver driver) throws InterruptedException {
	

	Elements_FolioLineItemsVoid FolioLineItems = new Elements_FolioLineItemsVoid(driver);
	double waittime = 0.12;
	long startTime = System.currentTimeMillis();
	FolioLineItems.Click_Save_ReservationDetails.click();
	Wait.wait3Second();
	try
	{
	if(FolioLineItems.Verify_Depos_policy.isDisplayed())
	{
		FolioLineItems.Click_Without_Deposit.click();
	}
	}
	catch (Exception ne)
	{
		
	}
	try
	{
	if(FolioLineItems.Verify_Toaster_Container.isDisplayed())
	{
	String getTotasterTitle_ReservationSucess=FolioLineItems.Toaster_Title.getText();
	String getToastermessage_ReservationSucess=FolioLineItems.Toaster_Message.getText();
	Assert.assertEquals(getTotasterTitle_ReservationSucess, "Reservation Saved");
	 long endTime   = System.currentTimeMillis();
	 double totalTime = (endTime - startTime); 
	// folioVoidLogger.info(totalTime + " in Millsecs");
  	 double TotalTimeinsecs = totalTime/1000;
  	 double ActualTime = TotalTimeinsecs - waittime - 3;
  //	folioVoidLogger.info(ActualTime + " in secs");
	if(getToastermessage_ReservationSucess.endsWith("has been saved successfully"));
	
	}
	}
	catch(Exception e)
	{
		
	}
	Wait.wait10Second();
}


//Add Line Items in Folio
/*public void addLineItem(WebDriver driver, String Amount) throws InterruptedException {
	Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
	FolioLineItems.click_Add_Button.click();
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.selectCategory);
	new Select(FolioLineItems.selectCategory).selectByIndex(9);
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.enterAmount);
	FolioLineItems.enterAmount.sendKeys(Amount);
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickCommitButton);
	FolioLineItems.clickCommitButton.click();
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
	FolioLineItems.clickSaveButton.click();
	Wait.wait10Second();
	
}*/


/*//Folio Line Items Post and Rollback 
public void adjustLineItem(WebDriver driver) throws InterruptedException{
	Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
	//boolean lineItemStatusPending=FolioLineItems.lineItem1.isDisplayed();
	//boolean checkbox=FolioLineItems.verifyCheckbox.isEnabled();
	//boolean lineItemStatusPostFutureDate=FolioLineItems.clickOkForPopup.isDisplayed();
	Wait.wait10Second();
	if(FolioLineItems.lineItemPendingStatus.isDisplayed()==true)
	{
		if(FolioLineItems.verifyCheckboxPendingStatus.isEnabled())
		{
		FolioLineItems.lineItemPendingStatus.click();
		Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
		FolioLineItems.clickSaveButton.click();
		Wait.wait10Second();
		folioVoidLogger.info(" Posted the Line Item successfully ");
		Wait.wait15Second();	
		}
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
				folioVoidLogger.info(" Posted Line Item Rolled back successfully ");
				Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickSaveButton);
				FolioLineItems.clickSaveButton.click();
				Wait.wait10Second();
			}
			else {
				Assert.fail("Failed to Disable the checkbox after posting the line Item");
				
			}
		}
		
	
	
	
	catch(Exception e){
		
		addOrPostLineItemLogger.info(e.getMessage());
		
	}
*/

 
//Add and Void Folio Line Items 
public void folioLineItemsVoid(WebDriver driver, String Category, String Amount, String Notes) throws InterruptedException{
	Elements_FolioLineItemsVoid FolioLineItems=new Elements_FolioLineItemsVoid(driver);
	FolioLineItems.click_Folio_tab.click();
	
	try
	{
		Wait.explicit_wait_xpath(OR.click_Add_Button);
	}
	catch(Exception e)
	{
		folioVoidLogger.info("Verification failed");
	}
	
	FolioLineItems.click_Add_Button.click();
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.selectCategory);
	new Select(FolioLineItems.selectCategory).selectByVisibleText(Category);
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.enterAmount);
	FolioLineItems.enterAmount.sendKeys(Amount);
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickCommitButton);
	FolioLineItems.clickCommitButton.click();
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.getBalanceFolioLineItems);
	String getBalance= FolioLineItems.getBalanceFolioLineItems.getText();
	folioVoidLogger.info(" Balance of the Folio Line Items " +getBalance);
	FolioLineItems.selectAllLineItems.click();
	Wait.wait5Second();
	try {
		if(FolioLineItems.clickVoidButton.isEnabled()){
			
			FolioLineItems.clickVoidButton.click();
			Wait.wait5Second();
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		folioVoidLogger.info(" Void button is disabled in Folio tab ");
		
	}
	FolioLineItems.enterNotes.sendKeys(Notes);
	Wait.explicit_wait_visibilityof_webelement(FolioLineItems.clickVoidButtonInNotes);
	FolioLineItems.clickVoidButtonInNotes.click();
	Wait.wait10Second();
	
	if(!FolioLineItems.DisplayVoidItemsCheckBox.isSelected())
	{
		FolioLineItems.DisplayVoidItemsCheckBox.click();
		folioVoidLogger.info(" Checked Display Void Items CheckBox ");
	}
	else{
		Wait.wait10Second();
	}
		
		Wait.wait5Second();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Wait.wait10Second();
        String getBalance1= FolioLineItems.getBalanceFolioLineItems.getText();
        folioVoidLogger.info(" Balance of the Folio Line Items after void " +getBalance1);
        Wait.explicit_wait_visibilityof_webelement(FolioLineItems.folioSaveButton);
        FolioLineItems.folioSaveButton.click();
        Wait.wait10Second();
}




@Override
public void adjustLineItem(WebDriver driver, String folioitemDescription, String folioLineAmount, String folioNotes)
		throws InterruptedException {
	// TODO Auto-generated method stub
	
}

	
}
