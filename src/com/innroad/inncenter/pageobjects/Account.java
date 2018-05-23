package com.innroad.inncenter.pageobjects;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.innroad.inncenter.interfaces.IAccount;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Account implements IAccount {
	
	public static Logger accountsLogger = Logger.getLogger("Account");
	
	public void NewAccountbutton(WebDriver driver, String Accounttype) {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		new Select (CreateAccount.Select_Account_Type).selectByVisibleText(Accounttype);
		CreateAccount.Click_New_Account.click();
		Wait.explicit_wait_xpath(OR.Verify_New_Account_tab);
		Wait.explicit_wait_xpath(OR.Verify_New_Account_Page_Load);
		
	}


	public void AccountDetails(WebDriver driver, String AccountType,
			String AccountName) {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		String selectedOption = new Select(CreateAccount.Verify_Account_Type).getFirstSelectedOption().getText();
        Assert.assertEquals(AccountType, selectedOption);
        
        CreateAccount.Enter_Account_Name.sendKeys(AccountName);
	}

	
	public void AccountAttributes(WebDriver driver, String MargetSegment,
			String Referral) {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		new Select (CreateAccount.Select_Market_Segment).selectByVisibleText(MargetSegment);
    	new Select (CreateAccount.Select_Referrals).selectByVisibleText(Referral);
		
	}

	public void Mailinginfo(WebDriver driver, String AccountFirstName,
			String AccountLastName, String Phonenumber,
			String alternativeNumber, String Address1, String Address2,
			String Address3, String Email, String city, String State,
			String Postalcode) {
	
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		CreateAccount.Account_Enter_First_Name.sendKeys(AccountFirstName);
    	CreateAccount.Account_Enter_Last_Name.sendKeys(AccountLastName);
    	CreateAccount.Account_Phone_number.sendKeys(Phonenumber);
    	CreateAccount.Account_Enter_AltPhoneNumber.sendKeys(alternativeNumber);
    	CreateAccount.Account_Enter_Line1.sendKeys(Address1);
    	CreateAccount.Account_Enter_Line2.sendKeys(Address2);
    	CreateAccount.Account_Enter_Line3.sendKeys(Address3);
    	CreateAccount.Account_Enter_Email.sendKeys(Email);
    	CreateAccount.Account_Enter_City.sendKeys(city);
    	new Select (CreateAccount.Select_Account_State).selectByVisibleText(State);
    	CreateAccount.Account_Enter_PostalCode.sendKeys(Postalcode);
		
	}

	
	public void Billinginfo(WebDriver driver) throws InterruptedException {
		
		Wait.wait5Second();
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Wait.wait5Second();
		WebElement checkBoxMailingInfo=CreateAccount.Account_Check_Mailing_info;
		jse.executeScript("arguments[0].scrollIntoView(true);", checkBoxMailingInfo);
		
		if(checkBoxMailingInfo.isSelected())
		{
			accountsLogger.info("Check box already checked");
		}
		else
		{
			
			checkBoxMailingInfo.click();
		}
		
	}

	
	public void Save(WebDriver driver) {
		
		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		CreateAccount.Account_save.click();
		Wait.explicit_wait_visibilityof_webelement(CreateAccount.Verify_Toaster_Container);
		if(CreateAccount.Verify_Toaster_Container.isDisplayed())
		{
		String getTotasterTitle_ReservationSucess=CreateAccount.Toaster_Title.getText();
		String getToastermessage_ReservationSucess=CreateAccount.Toaster_Message.getText();
		Assert.assertEquals(getTotasterTitle_ReservationSucess, "Account Saved");
		if(getToastermessage_ReservationSucess.equals("The account Test Account has been successfully created."));
		}
	
		
		
	}



	public void addLineitem(WebDriver driver, String propertyName ,String SelectCategory,
			String Amount) throws InterruptedException {
		
		Elements_Accounts CreateAccountlineitem=new Elements_Accounts(driver);
		
		CreateAccountlineitem.Account_Add.click();
		Wait.explicit_wait_xpath(OR.Verify_Account_line_item);
		new Select (CreateAccountlineitem.Select_Property_lineitem).selectByVisibleText(propertyName);
		new Select (CreateAccountlineitem.Select_Line_item_Category).selectByVisibleText(SelectCategory);
		try
		{
		String GetID=CreateAccountlineitem.Get_Gift_ID.getAttribute("value");
		accountsLogger.info("GetID :" + GetID);
		String GetSplitid[]= GetID.split("#");
		accountsLogger.info("GetSplitid[1] :" + GetSplitid[1]);
		try
		{
		BufferedWriter writer= new BufferedWriter(new FileWriter(".\\GiftCertificate.txt"));
		writer.write(GetSplitid[1].trim());
		writer.close();
		}
		catch(Exception e)
		{
			
		}
		}
		catch(Exception e)
		{
			
		}
		try
		{
		
			CreateAccountlineitem.Enter_Gift_Line_Item_Amount.clear();
			Wait.wait2Second();
			CreateAccountlineitem.Enter_Gift_Line_Item_Amount.sendKeys(Amount);
		}
		catch(Exception e)
		{
			CreateAccountlineitem.Enter_Line_item_Amount.clear();
			Wait.wait2Second();
			CreateAccountlineitem.Enter_Line_item_Amount.sendKeys(Amount);
			
			
		}
		


	}
	public void Commit(WebDriver driver) {
		Elements_Accounts CreateAccountlineitem=new Elements_Accounts(driver);
		CreateAccountlineitem.Click_Commit.click();
	}


	
	public void navigateFolio(WebDriver driver) {
		Elements_Accounts ClickFolio=new Elements_Accounts(driver);
		
		ClickFolio.Account_Folio.click();
		
	}



	public void Payment(WebDriver driver, String PaymentType, String CardName, String CCNumber,String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException {
		Elements_Accounts AccountPayment=new Elements_Accounts(driver);
		AccountPayment.Account_pay.click();
		new Select (AccountPayment.Select_Account_paymethod).selectByVisibleText(PaymentType);
		Wait.wait3Second();
		AccountPayment.Click_Account_Card_info.click();
		Wait.explicit_wait_xpath(OR.Verify_Account_Paymnet_info_popup);
		Wait.wait3Second();
		AccountPayment.Enter_Account_Card_Name.sendKeys(CardName);
		AccountPayment.Enter_CC_Account_Number.sendKeys(CCNumber);
		AccountPayment.Enter_ExpiryDate_Account.sendKeys(CCExpiry);
		AccountPayment.Enter_CCV_Account.sendKeys(CCVCode);
		AccountPayment.Click_Ok_Account.click();
		Wait.wait10Second();
	
			
		new Select (AccountPayment.Select_Authorization_Type_Account).selectByVisibleText(Authorizationtype);
		if(ChangeAmount.equalsIgnoreCase("Yes"))
		{
			/*ReservationFolio.Change_Amount.clear();
			Wait.wait3Second();
			ReservationFolio.Change_Amount.sendKeys(ChangeAmountValue);*/
			AccountPayment.Enter_Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),ChangeAmountValue);
		}
		else
		{
			accountsLogger.info("Processed complete amount");
		}
		Wait.wait10Second();
		if(Authorizationtype.equalsIgnoreCase("Capture"))
		{
		AccountPayment.Click_Process_Account.click();
		Wait.explicit_wait_visibilityof_webelement(AccountPayment.Apply_Advance_Deposite);
//		Wait.explicit_wait_xpath(OR.Apply_Advance_Deposite);
		AccountPayment.Click_Continue_Adv_Deposite.click();
		}
		Wait.wait3Second();
                Wait.wait3Second();
                Wait.wait3Second();
		Wait.explicit_wait_xpath(OR.Verify_MC_Grid);
		String GetPaymentMethod=AccountPayment.Account_Payment_Method.getText();
		accountsLogger.info(GetPaymentMethod + " "+GetPaymentMethod);
		if(GetPaymentMethod.equals(PaymentType))
		{
			accountsLogger.info("Paymnet Success");
		}
		else
		{
			accountsLogger.info("Paymnet Failed");
		}
		AccountPayment.Click_Account_Pay_Continue.click();
		Wait.wait3Second();
		Wait.explicit_wait_xpath(OR.Get_Line_item_Account);
		String GetMCCard=AccountPayment.Get_Line_item_Account.getText();
		accountsLogger.info(GetMCCard + " "+GetMCCard);
		if(GetMCCard.equals("Name: MC Account #: XXXX5454 Exp. Date: 08/19"))
		{
			accountsLogger.info("Paymnet Success");
		}
		else
		{
			accountsLogger.info("Paymnet Failed");
		}
		String GetBalance=AccountPayment.Verify_Ending_Balance.getText();
		accountsLogger.info(GetBalance + " "+GetBalance);
		String RemoveCurreny[]=GetBalance.split(" ");
		accountsLogger.info(RemoveCurreny[1]);
		if(ChangeAmount.equalsIgnoreCase("No"))
		{
		if(RemoveCurreny[1].equals("0.00"));
		}
		else
		{
			accountsLogger.info("Selected Changed Value");
		}
		
	}
	
	public void CreateNewReservation(WebDriver driver)
	{
		Elements_Accounts AccountPayment=new Elements_Accounts(driver);
		AccountPayment.Click_New_Reservation_Account.click();
		Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
		Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
	}
	
	public void CreateHouseAccount(WebDriver driver, String HouseAccountName)
	{
		Elements_Accounts AccountPayment=new Elements_Accounts(driver);
		AccountPayment.Enter_House_Account_Name.sendKeys(HouseAccountName);
		
	
	}
	
	public void GiftCertificate(WebDriver driver, String GiftCertificateName)
	{
		Elements_Accounts AccountPayment=new Elements_Accounts(driver);
		AccountPayment.Enter_House_Account_Name.sendKeys(GiftCertificateName);
		
	
	}
	
	public void AccAddNotes(WebDriver driver, String Subject, String NoteDetails, String NoteType, String Notestatus) throws InterruptedException
	{
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Elements_Accounts AddNote=new Elements_Accounts(driver);
		AddNote.Acc_Add_Button.click();
		Wait.explicit_wait_xpath(OR.Verify_Notes_Popup);
		AddNote.Acc_Note_Enter_sub.sendKeys(Subject);
		AddNote.Acc_Note_Enter_Details.sendKeys(NoteDetails);
		new Select (AddNote.Acc_Note_Select_Note_Type).selectByVisibleText(NoteType);
		
		 if(AddNote.Acc_Note_Action_Req.isSelected())
		    {
			 accountsLogger.info("Already selected");
		    }
		    else
		    {
		    	AddNote.Acc_Note_Action_Req.click();
		    	Wait.wait10Second();
		    }
		    new Select ( AddNote.Acc_Note_Select_Note_Status).selectByVisibleText(Notestatus);
		    
		    AddNote.Acc_Note_Save.click();
		    if(AddNote.Verify_Add_line_Notes.isDisplayed())
		    {
		    	accountsLogger.info("Created note Successfully");
		    }
		    else
		    {
		    	accountsLogger.info("Fail to create note");
		    }
		 
		 
	}

	
	public void get_AccountDetails(WebDriver driver,ExtentTest test,String AccountType,String AccountName,String AccountNumber) throws InterruptedException{

		Elements_Accounts Account=new Elements_Accounts(driver);
		Wait.explicit_wait_xpath(OR.Account_Type);

		Select sel = new Select(Account.Account_Type);
		sel.selectByVisibleText(AccountType);
		test.log(LogStatus.PASS, "Account type : "+AccountType);
		accountsLogger.info("Account type : "+AccountType);

		Account.Account_Name.sendKeys(AccountName);
		test.log(LogStatus.PASS, "Account Name : "+AccountName);
		accountsLogger.info("Account Name : "+AccountName);

		Account.Account_Number.sendKeys(AccountNumber);
		test.log(LogStatus.PASS, "Account Number : "+AccountNumber);
		accountsLogger.info("Account Number : "+AccountNumber);

		Account.Account_Search.click();
		test.log(LogStatus.PASS, "Click Account Search");
		accountsLogger.info("Click Account Search");

		/*int i=0;
		while(true){

			if(driver.findElements(By.xpath("//div[@id='toast-container']/div/div")).size()>0){

				break;
			}else if(i<0){
				test.log(LogStatus.PASS, "There are No Accounts available with "+AccountName +" and Account Number "+AccountNumber);
				accountsLogger.info("There are No Accounts available with "+AccountName +" and Account Number "+AccountNumber);
				break;
			}else{
				Wait.wait1Second();
				i++;
			}
		}
*/
		
		Wait.wait5Second();
		int count =driver.findElements(By.xpath(OR.Number_Of_Accounts)).size();

		if(count==0){
			test.log(LogStatus.PASS, "There are No Accounts available with "+AccountName +" and Account Number "+AccountNumber);
			accountsLogger.info("There are No Accounts available with "+AccountName +" and Account Number "+AccountNumber);
		}else{
			test.log(LogStatus.PASS, "Number of Accounts available with "+AccountName +" and Account Number "+AccountNumber +" in this page are "+count);
			accountsLogger.info("Number of Accounts available with "+AccountName +" and Account Number "+AccountNumber +" in this page are "+count);
		}
	}


	public void select_AccountFolio(WebDriver driver,ExtentTest test,String AccountName){

		Elements_Accounts Account=new Elements_Accounts(driver);

		String account="//table[@class='table table-striped table-bordered table-hover']/tbody/tr/td/a";
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(account))));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(account))));

		driver.findElement(By.xpath(account)).click();
		test.log(LogStatus.PASS, "Clicking on Account name : "+AccountName);
		accountsLogger.info("Clicking on Account name : "+AccountName);

		wait.until(ExpectedConditions.visibilityOf(Account.Account_Folio));
		wait.until(ExpectedConditions.elementToBeClickable(Account.Account_Folio));
		Account.Account_Folio.click();
		test.log(LogStatus.PASS, "Clicking on Account Folio");
		accountsLogger.info("Clicking on Account Folio");
	}



	public void cashPayment(WebDriver driver,ExtentTest test,String AccountType,String AccountName,String AmountToPay,String PaymentType) throws InterruptedException{

		Elements_Accounts Account=new Elements_Accounts(driver);


		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(Account.Folio_Balance));

		String balance = Account.Folio_Balance.getText();		
		balance=balance.replace("$", "");


		float bal = Float.parseFloat(balance);

		if(bal>0){

			test.log(LogStatus.PASS, "Borefore pay Balance "+bal);
			accountsLogger.info("Borefore pay Balance "+bal);


			Account.Account_pay.click();
			test.log(LogStatus.PASS, "Clicking on Pay");
			accountsLogger.info("Clicking on Pay");

			new Select (Account.Select_Account_paymethod).selectByVisibleText(PaymentType);
			test.log(LogStatus.PASS, "Select Payment type "+PaymentType);
			accountsLogger.info("Select Payment type "+PaymentType);

			Account.Enter_Change_Amount.sendKeys(Keys.chord(Keys.CONTROL, "a"),AmountToPay);
			test.log(LogStatus.PASS, "Enter Amount to pay "+AmountToPay);
			accountsLogger.info("Enter Amount to pay "+AmountToPay);

			Wait.wait3Second();
			if(AccountType.contains("Corporate")){

				driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]/../../../../following-sibling::div/div/div/div/div/div/ul/li/div/button[contains(text(),'Add')]")).click();

				int i=0;
				while(true){

					if(driver.findElements(By.xpath(OR.Click_Continue_Adv_Deposite)).size()>0){
						Account.Click_Continue_Adv_Deposite.click();
						break;
					}else if(i==1){

						break;
					}else{
						Thread.sleep(1000);
						i++;
						//System.out.println(i);
					}
				}
			}else{
				driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]/../../../../following-sibling::div[1]/div/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div[6]/div/button[contains(text(),'Add')]")).click();
			}

			test.log(LogStatus.PASS, "Clicking on Add");
			accountsLogger.info("Clicking on Add");

			Wait.wait3Second();

			Account.Folio_Cash_Continue_Btn.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			accountsLogger.info("Clicking on Continue");

			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			accountsLogger.info("Clicking on Save Account");


			String balance1 = Account.Folio_Balance.getText();		
			balance1=balance1.replace("$", "");


			float bal1 = Float.parseFloat(balance1);

			test.log(LogStatus.PASS, "After pay Folio balance "+bal1);
			accountsLogger.info("After pay Folio balance "+bal1);

			if(bal1+Float.parseFloat(AmountToPay)==bal){
				test.log(LogStatus.PASS, "Cash Payment "+AmountToPay+ " is successful");
				accountsLogger.info("Cash Payment "+AmountToPay+ " is successful");
			}else{
				test.log(LogStatus.FAIL, "Cash Payment "+AmountToPay+ " is Fail");
				accountsLogger.info("Cash Payment "+AmountToPay+ " is Fail");
			}




		}else{
			test.log(LogStatus.FAIL, "Account : "+AccountName + " balance is Zero");
			accountsLogger.info("Account : "+AccountName + " balance is Zero");
		}



	}

	public void Save(WebDriver driver,ExtentTest test) {

		Elements_Accounts CreateAccount=new Elements_Accounts(driver);
		CreateAccount.Account_save.click();
		test.log(LogStatus.PASS, "Click on Save");
		accountsLogger.info("Click on Save");

		if(CreateAccount.Verify_Toaster_Container.isDisplayed())
		{
			String getTotasterTitle_ReservationSucess=CreateAccount.Toaster_Title.getText();
			String getToastermessage_ReservationSucess=CreateAccount.Toaster_Message.getText();
			Assert.assertEquals(getTotasterTitle_ReservationSucess, "Account Saved");
			if(getToastermessage_ReservationSucess.equals("The account Test Account has been successfully created."));
			test.log(LogStatus.PASS, "The account Test Account has been successfully Saved.");
			accountsLogger.info("The account Test Account has been successfully Saved.");
		}



	}
	
}
