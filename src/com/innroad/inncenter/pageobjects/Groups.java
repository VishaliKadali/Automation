package com.innroad.inncenter.pageobjects;



import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Groups;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Groups{
	
	public static Logger groupLogger = Logger.getLogger("Group");

	
	public void click_NewAccount(WebDriver driver, ExtentTest test) {

		Elements_Groups group = new Elements_Groups(driver);

		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.New_Account_Btn));
		group.New_Account_Btn.click();
		test.log(LogStatus.PASS, "Click on New Account");
	}

	
	public void type_GroupName(WebDriver driver, ExtentTest test, String GroupName) throws InterruptedException {
		Elements_Groups group = new Elements_Groups(driver);
		Wait.wait3Second();
		click_NewAccount(driver, test);
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.Group_Name));
		group.Group_Name.sendKeys(GroupName);
		test.log(LogStatus.PASS, "Enter Group Name : "+GroupName);
		groupLogger.info("Enter Group Name : "+GroupName);
	}

	
	public void type_AccountAttributes(WebDriver driver, ExtentTest test, String MarketSegment, String Referral) {

		Elements_Groups group = new Elements_Groups(driver);

		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.Market_Segment));
		new Select (group.Market_Segment).selectByVisibleText(MarketSegment);
		test.log(LogStatus.PASS, "Select Market Segment : "+MarketSegment);
		groupLogger.info("Select Market Segment : "+MarketSegment);
		
		new Select (group.Referrls).selectByVisibleText(Referral);
		test.log(LogStatus.PASS, "Select Referral : "+Referral);
		groupLogger.info("Select Referral : "+Referral);
	}

	
	public void type_MailingAddrtess(WebDriver driver, ExtentTest test, String FirstName, String LastName, String Phone,
			String Address, String City, String State, String Country, String PostalCode) {

		Elements_Groups group = new Elements_Groups(driver);

		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.FirstName));
		group.FirstName.sendKeys(FirstName);
		test.log(LogStatus.PASS, "Enter First Name : "+FirstName);
		groupLogger.info("Enter First Name : "+FirstName);
		
		group.LastName.sendKeys(LastName);
		test.log(LogStatus.PASS, "Enter Last Name : "+LastName);
		groupLogger.info("Enter Last Name : "+LastName);
		
		group.Phone.sendKeys(Phone);
		test.log(LogStatus.PASS, "Enter Phone Number : "+Phone);
		groupLogger.info("Enter Phone Number : "+Phone);
		
		group.Address1.sendKeys(Address);
		test.log(LogStatus.PASS, "Enter Address : "+Address);
		groupLogger.info("Enter Address : "+Address);
		
		group.City.sendKeys(City);
		test.log(LogStatus.PASS, "Enter City : "+City);
		groupLogger.info("Enter City : "+City);
		
		new Select (group.Country).selectByVisibleText(Country);
		test.log(LogStatus.PASS, "Select Country : "+Country);
		groupLogger.info("Select Country : "+Country);
		
		new Select (group.State).selectByVisibleText(State);
		test.log(LogStatus.PASS, "Select State : "+State);
		groupLogger.info("Select State : "+State);
		
		group.PostalCode.sendKeys(PostalCode);
		test.log(LogStatus.PASS, "Enter Postal code : "+PostalCode);
		groupLogger.info("Enter Postal code : "+PostalCode);
	}

	
	public void Billinginfo(WebDriver driver,ExtentTest test) throws InterruptedException {

		Elements_Groups group = new Elements_Groups(driver);

		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.Check_Mailing_Info));
		if(group.Check_Mailing_Info.isSelected())
		{
			//System.out.println("Check box already checked");
		}
		else
		{

			group.Check_Mailing_Info.click();
			test.log(LogStatus.PASS, "Click same as mailing address");
			groupLogger.info("Click same as mailing address");
			
		}

	}

	
	public void Save(WebDriver driver,ExtentTest test) {

		Elements_Groups group = new Elements_Groups(driver);
		group.Group_Save.click();

		test.log(LogStatus.PASS, "Click on Save");


	}

	
	public void navigateFolio(WebDriver driver,ExtentTest test) {
		Elements_Groups group = new Elements_Groups(driver);

		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.visibilityOf(group.Group_Folio));
		group.Group_Folio.click();
		test.log(LogStatus.PASS, "Click on Group Folio");
		groupLogger.info("Click on Group Folio");
		
	}



	
	public void addLineItems(WebDriver driver,ExtentTest test) throws InterruptedException{


		Elements_Groups group = new Elements_Groups(driver);

		group.Group_Folio_Add_LineItem.click();
		test.log(LogStatus.PASS, "Click on Add Line item");
		groupLogger.info("Click on Add Line item");
		

		new Select (driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpFolioProperty_0']"))).selectByIndex(1);
		Wait.wait2Second();
		new Select (driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpLedgeraccountname_0']"))).selectByIndex(1);

		String Cat1 = new Select(driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpLedgeraccountname_0']"))).getFirstSelectedOption().getText();
		//System.out.println("Cat1 : "+Cat1);
		test.log(LogStatus.PASS, "Selected category : "+Cat1);
		groupLogger.info("Selected category : "+Cat1);


		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_dgLineItems_txtAmount_0']")).clear();
		Wait.wait2Second();
		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_dgLineItems_txtAmount_0']")).sendKeys("100");
		test.log(LogStatus.PASS, "Enter amount 100");
		groupLogger.info("Enter amount 100");
		Commit(driver, test);

		group.Group_Folio_Add_LineItem.click();


		new Select (driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpFolioProperty_1']"))).selectByIndex(1);
		Wait.wait2Second();
		new Select (driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpLedgeraccountname_1']"))).selectByIndex(2);

		String Cat2 = new Select(driver.findElement(By.xpath("//select[@id='MainContent_Folio1_dgLineItems_drpLedgeraccountname_1']"))).getFirstSelectedOption().getText();
		//System.out.println("Cat2 : "+Cat2);
		test.log(LogStatus.PASS, "Selected category : "+Cat2);
		groupLogger.info("Selected category : "+Cat2);

		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_dgLineItems_txtAmount_1']")).clear();
		Wait.wait2Second();
		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_dgLineItems_txtAmount_1']")).sendKeys("150");
		test.log(LogStatus.PASS, "Enter amount 150");
		groupLogger.info("Enter amount 150");
		
		Commit(driver, test);
		Save(driver, test);

	}

	public void Commit(WebDriver driver,ExtentTest test) {
		Elements_Groups group = new Elements_Groups(driver);
		group.Group_Folio_Commit_Lineitem.click();
		test.log(LogStatus.PASS, "Click on commit");
		groupLogger.info("Click on commit");
	}


	public void ageingPayment(WebDriver driver,ExtentTest test, String AccountType,String PaymentType, String CardName, String CCNumber,String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException{

		Elements_Groups group = new Elements_Groups(driver);

		navigateFolio(driver, test);
		Wait.wait2Second();


		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_btnPay']")).click();
		Wait.wait3Second();
		if(PaymentType.equalsIgnoreCase("MC")){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			String text = null;
			//AccountPayment.Account_pay.click();
			new Select (group.Group_Folio_PaymentMethod).selectByVisibleText(PaymentType);
			groupLogger.info("Payment Method : "+PaymentType);
			
			Wait.wait3Second();
			group.Group_Folio_CardInfo.click();
			//Wait.explicit_wait_xpath(OR.Group_Folio_NameOnCard);
			Wait.wait5Second();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body1")));
			group.Group_Folio_NameOnCard.sendKeys(CardName);
			test.log(LogStatus.PASS, "Enter name on card : "+CardName);
			groupLogger.info("Enter name on card : "+CardName);
			
			group.Group_Folio_CardNumber.sendKeys(CCNumber);
			test.log(LogStatus.PASS, "Enter credit card number : "+CCNumber);
			groupLogger.info("Enter credit card number : "+CCNumber);
			
			group.Group_Folio_ExpDate.sendKeys(CCExpiry);
			test.log(LogStatus.PASS, "Enter Card expiry date : "+CCExpiry);
			groupLogger.info("Enter Card expiry date : "+CCExpiry);
			
			group.Group_Folio_CVV.sendKeys(CCVCode);
			test.log(LogStatus.PASS, "Enter card CVV : "+CCVCode);
			groupLogger.info("Enter card CVV : "+CCVCode);
			
			group.Group_Folio_OK.click();
			test.log(LogStatus.PASS, "Clicking on Folio Ok");
			groupLogger.info("Clicking on Folio Ok");
			
			Wait.wait3Second();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			new Select (group.Group_Folio_AuthType).selectByVisibleText(Authorizationtype);
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{

				group.Group_Folio_Amount.clear();
				Wait.wait2Second();
				group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
				test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
				groupLogger.info("Enter Amount to pay "+ChangeAmountValue);
			}
			else
			{
				//System.out.println("Processed complete amount");
			}
			Wait.wait2Second();
			if(Authorizationtype.equalsIgnoreCase("Capture"))
			{

				text=driver.findElement(By.xpath("//a[@id='dgPaymentDetails_lbtnDisplaycaption_0']")).getText();
				driver.findElement(By.xpath("//input[@id='dgPaymentDetails_ChkItemSelect_0']")).click();
				group.Group_Folio_Process.click();
				groupLogger.info("Click Process");
			}
			Wait.wait3Second();
			Wait.explicit_wait_xpath("//table[@id='dgTransactionPayList']/tbody/tr[2]/td[4]");
			String GetPaymentMethod=new Select(group.Group_Folio_PaymentMethod).getFirstSelectedOption().getText();
			//System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			if(GetPaymentMethod.equals(PaymentType))
			{
				//System.out.println("Paymnet Success");
				groupLogger.info("Payment Success");
				
			}
			else
			{
				//System.out.println("Paymnet Failed");
				groupLogger.info("Payment Failed");
			}
			group.Group_Folio_Continue.click();
			groupLogger.info("Click Continue");
			Wait.wait3Second();

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Wait.wait3Second();
			try{
				if(driver.switchTo().alert() != null){
					alert.accept();
				}
			}catch(Exception e){
			//	System.out.println("No Alert");
			}
			Wait.wait2Second();

			String GetMCCard=driver.findElement(By.xpath("//a[contains(text(),'Name')]")).getText();
			//System.out.println(GetMCCard + " "+GetMCCard);
			if(GetMCCard.contains("Name: test Account #: XXXX5454 Exp."))
			{
			//	System.out.println("Paymnet Success");
				
				groupLogger.info("Payment Success");
			}

			driver.switchTo().defaultContent();
			Wait.wait2Second();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			
			navigateFolio(driver, test);
			String loc="//table[@id='MainContent_Folio1_dgLineItems']/tbody/tr/td/table/tbody/tr/td/a[contains(text(),'"+text.trim()+"')]/../../../../../following-sibling::td/img";

			String str=driver.findElement(By.xpath(loc)).getAttribute("title");
			test.log(LogStatus.PASS, "Payment : "+str);
			groupLogger.info("Payment : "+str);

		}else if(PaymentType.equalsIgnoreCase("Cash")){
			Wait.wait3Second();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));

			WebDriverWait wait = new WebDriverWait(driver,90);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))));
			new Select (driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))).selectByVisibleText(PaymentType);

			test.log(LogStatus.PASS, "Select Payment type "+PaymentType);
			groupLogger.info("Select Payment type "+PaymentType);

			Wait.wait2Second();
			group.Group_Folio_Amount.clear();
			Wait.wait2Second();
			group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
			test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
			groupLogger.info("Enter Amount to pay "+ChangeAmountValue);


			String text=driver.findElement(By.xpath("//a[@id='dgPaymentDetails_lbtnDisplaycaption_0']")).getText();
			driver.findElement(By.xpath("//input[@id='dgPaymentDetails_ChkItemSelect_0']")).click();
			//System.out.println(text);
			group.Group_Folio_Add.click();

			test.log(LogStatus.PASS, "Clicking on Add");
			groupLogger.info("Clicking on Add");

			Wait.wait3Second();

			group.Group_Folio_Continue.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			groupLogger.info("Clicking on Continue");
			Wait.wait3Second();
			driver.switchTo().defaultContent();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			navigateFolio(driver, test);
			String loc="//table[@id='MainContent_Folio1_dgLineItems']/tbody/tr/td/table/tbody/tr/td/a[contains(text(),'"+text.trim()+"')]/../../../../../following-sibling::td/img";
			String str=driver.findElement(By.xpath(loc)).getAttribute("title");
			//System.out.println(str);
			test.log(LogStatus.PASS, "Payment : "+str);
			groupLogger.info("Payment : "+str);
		}

	}



	public void ageingPaymentAutoApply(WebDriver driver,ExtentTest test, String AccountType,String PaymentType, String CardName, String CCNumber,String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException{

		Elements_Groups group = new Elements_Groups(driver);
		navigateFolio(driver, test);
		test.log(LogStatus.PASS, "Clicking on Folio");
		groupLogger.info("Clicking on Folio");
		
		String balance = group.Group_Folio_EndingBalance.getText();		
		balance=balance.replace("$", "");
		float bal = Float.parseFloat(balance);
		test.log(LogStatus.PASS, "Before Pay Folio balance : "+balance);
		groupLogger.info("Before Pay Folio balance : "+balance);

		navigateFolio(driver, test);
		Wait.wait2Second();

		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_btnPay']")).click();
		test.log(LogStatus.PASS, "Clicking on Pay");
		groupLogger.info("Clicking on Pay");
		
		Wait.wait3Second();
		if(PaymentType.equalsIgnoreCase("MC")){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			String text = null;
			
			new Select (group.Group_Folio_PaymentMethod).selectByVisibleText(PaymentType);
			test.log(LogStatus.PASS, "Select Payment type : "+PaymentType);
			groupLogger.info("Select Payment type : "+PaymentType);
			
			Wait.wait2Second();
			group.Group_Folio_CardInfo.click();
			test.log(LogStatus.PASS, "Clicking on Card Info");
			groupLogger.info("Clicking on Card Info");
			
			Wait.wait3Second();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body1")));
			group.Group_Folio_NameOnCard.sendKeys(CardName);
			test.log(LogStatus.PASS, "Enter name on card : "+CardName);
			groupLogger.info("Enter name on card : "+CardName);
			
			group.Group_Folio_CardNumber.sendKeys(CCNumber);
			test.log(LogStatus.PASS, "Enter credit card number : "+CCNumber);
			groupLogger.info("Enter credit card number : "+CCNumber);
			
			group.Group_Folio_ExpDate.sendKeys(CCExpiry);
			test.log(LogStatus.PASS, "Enter Card expiry date : "+CCExpiry);
			groupLogger.info("Enter Card expiry date : "+CCExpiry);
			
			group.Group_Folio_CVV.sendKeys(CCVCode);
			test.log(LogStatus.PASS, "Enter card CVV : "+CCVCode);
			groupLogger.info("Enter card CVV : "+CCVCode);
			
			group.Group_Folio_OK.click();
			test.log(LogStatus.PASS, "Clicking on Folio Ok");
			groupLogger.info("Clicking on Folio Ok");
			
			Wait.wait3Second();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			new Select (group.Group_Folio_AuthType).selectByVisibleText(Authorizationtype);
			test.log(LogStatus.PASS, "Select Authorization type : "+Authorizationtype);
			groupLogger.info("Select Authorization type : "+Authorizationtype);
			
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{

				group.Group_Folio_Amount.clear();
				Wait.wait2Second();
				group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
				test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
				groupLogger.info("Enter Amount to pay "+ChangeAmountValue);

			}
			else
			{
				//System.out.println("Processed complete amount");
				groupLogger.info("Processed complete amount");
			}
			Wait.wait2Second();
			if(Authorizationtype.equalsIgnoreCase("Capture"))
			{

				group.Group_Folio_AutoApply.click();
				test.log(LogStatus.PASS, "Clicking on Auto Apply");
				groupLogger.info("Clicking on Auto Apply");
				
				Wait.wait2Second();
				if(driver.findElement(By.xpath("//input[@id='dgPaymentDetails_ChkItemSelect_0']")).isSelected()){
					text=driver.findElement(By.xpath("//a[@id='dgPaymentDetails_lbtnDisplaycaption_0']")).getText();
					//System.out.println("Test : "+text);
				}
				Wait.wait2Second();
				group.Group_Folio_Process.click();
				test.log(LogStatus.PASS, "Clicking on Folio");
				groupLogger.info("Clicking on Folio");
			}
			Wait.wait3Second();
			Wait.explicit_wait_xpath("//table[@id='dgTransactionPayList']/tbody/tr[2]/td[4]");
			String GetPaymentMethod=new Select(group.Group_Folio_PaymentMethod).getFirstSelectedOption().getText();
			//System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			if(GetPaymentMethod.equals(PaymentType))
			{
				//System.out.println("Paymnet Success");
				groupLogger.info("Payment Success");
			}
			else
			{
				//System.out.println("Paymnet Failed");
				groupLogger.info("Payment Failed");
			}
			group.Group_Folio_Continue.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			groupLogger.info("Clicking on Continue");
			Wait.wait3Second();

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Wait.wait3Second();
			try{
				if(driver.switchTo().alert() != null){
					alert.accept();
				}
			}catch(Exception e){
				//System.out.println("No Alert");
			}
			Wait.wait2Second();

			String GetMCCard=driver.findElement(By.xpath("//a[contains(text(),'Name')]")).getText();
			//System.out.println(GetMCCard + " "+GetMCCard);
			if(GetMCCard.contains("Name: test Account #: XXXX5454 Exp."))
			{
				//System.out.println("Paymnet Success");
				test.log(LogStatus.PASS, "Payment Success");
				groupLogger.info("Payment Success");
			}

			driver.switchTo().defaultContent();
			Wait.wait2Second();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			
			navigateFolio(driver, test);
			String loc="//table[@id='MainContent_Folio1_dgLineItems']/tbody/tr/td/table/tbody/tr/td/a[contains(text(),'"+text.trim()+"')]/../../../../../following-sibling::td/img";

			String str=driver.findElement(By.xpath(loc)).getAttribute("title");
			//System.out.println(str);
			test.log(LogStatus.PASS, "Payment : "+str);
			groupLogger.info("Payment : "+str);

			String balance1 = group.Group_Folio_EndingBalance.getText();		
			balance1=balance1.replace("$", "");


			float bal1 = Float.parseFloat(balance1);

			test.log(LogStatus.PASS, "After pay Folio balance "+bal1);
			groupLogger.info("After pay Folio balance "+bal1);
			

			if(bal1+Float.parseFloat(ChangeAmountValue)==bal){
				test.log(LogStatus.PASS, "Cash Payment "+ChangeAmountValue+ " is successful");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is successful");
			}else{
				test.log(LogStatus.FAIL, "Cash Payment "+ChangeAmountValue+ " is Fail");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is Fail");
			}


		}else if(PaymentType.equalsIgnoreCase("Cash")){
			Wait.wait2Second();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));

			WebDriverWait wait = new WebDriverWait(driver,90);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))));
			new Select (driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))).selectByVisibleText(PaymentType);

			test.log(LogStatus.PASS, "Select Payment type "+PaymentType);
			groupLogger.info("Select Payment type "+PaymentType);

			Wait.wait2Second();
			group.Group_Folio_Amount.clear();
			Wait.wait2Second();
			group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
			test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
			groupLogger.info("Enter Amount to pay "+ChangeAmountValue);
			
			String text = null;
			group.Group_Folio_AutoApply.click();
			test.log(LogStatus.PASS, "Clicking on Auto Apply");
			groupLogger.info("Clicking on Auto Apply");
			
			Wait.wait2Second();
			if(driver.findElement(By.xpath("//input[@id='dgPaymentDetails_ChkItemSelect_0']")).isSelected()){
				text=driver.findElement(By.xpath("//a[@id='dgPaymentDetails_lbtnDisplaycaption_0']")).getText();
				//System.out.println("Test : "+text);
			}
			Wait.wait2Second();
			//System.out.println(text);
			group.Group_Folio_Add.click();
			test.log(LogStatus.PASS, "Clicking on Add");
			groupLogger.info("Clicking on Add");

			Wait.wait3Second();
			group.Group_Folio_Continue.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			groupLogger.info("Clicking on Continue");
			
			Wait.wait3Second();
			driver.switchTo().defaultContent();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			
			navigateFolio(driver, test);
			String loc="//table[@id='MainContent_Folio1_dgLineItems']/tbody/tr/td/table/tbody/tr/td/a[contains(text(),'"+text.trim()+"')]/../../../../../following-sibling::td/img";

			String str=driver.findElement(By.xpath(loc)).getAttribute("title");
			//System.out.println(str);
			test.log(LogStatus.PASS, "Payment : "+str);
			groupLogger.info("Payment : "+str);
			
			String balance1 = group.Group_Folio_EndingBalance.getText();		
			balance1=balance1.replace("$", "");
			float bal1 = Float.parseFloat(balance1);
			test.log(LogStatus.PASS, "After pay Folio balance "+bal1);
			groupLogger.info("After pay Folio balance "+bal1);
			

			if(bal1+Float.parseFloat(ChangeAmountValue)==bal){
				test.log(LogStatus.PASS, "Cash Payment "+ChangeAmountValue+ " is successful");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is successful");
			}else{
				test.log(LogStatus.FAIL, "Cash Payment "+ChangeAmountValue+ " is Fail");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is Fail");
			}
		}	
	}


	public void ageingPaymentAdvanceDeposit(WebDriver driver,ExtentTest test, String AccountType,String PaymentType, String CardName, String CCNumber,String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount,
			String ChangeAmountValue) throws InterruptedException{

		Elements_Groups group = new Elements_Groups(driver);

		navigateFolio(driver, test);
		test.log(LogStatus.PASS, "Clicking on Folio");
		groupLogger.info("Clicking on Folio");
		
		String balance = group.Group_Folio_EndingBalance.getText();		
		balance=balance.replace("$", "");
		float bal = Float.parseFloat(balance);
		test.log(LogStatus.PASS, "Before Pay Folio balance : "+balance);
		groupLogger.info("Before Pay Folio balance : "+balance);

		navigateFolio(driver, test);
		Wait.wait2Second();

		driver.findElement(By.xpath("//input[@id='MainContent_Folio1_btnPay']")).click();
		test.log(LogStatus.PASS, "Clicking on Pay");
		groupLogger.info("Clicking on Pay");
		
		Wait.wait3Second();
		if(PaymentType.equalsIgnoreCase("MC")){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			
			new Select (group.Group_Folio_PaymentMethod).selectByVisibleText(PaymentType);
			test.log(LogStatus.PASS, "Select Payment type : "+PaymentType);
			groupLogger.info("Select Payment type : "+PaymentType);
			
			Wait.wait2Second();
			group.Group_Folio_CardInfo.click();
			test.log(LogStatus.PASS, "Clicking on Card Info");
			groupLogger.info("Clicking on Card Info");
			
			Wait.wait2Second();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body1")));
			group.Group_Folio_NameOnCard.sendKeys(CardName);
			test.log(LogStatus.PASS, "Enter name on card : "+CardName);
			groupLogger.info("Enter name on card : "+CardName);
			
			group.Group_Folio_CardNumber.sendKeys(CCNumber);
			test.log(LogStatus.PASS, "Enter credit card number : "+CCNumber);
			groupLogger.info("Enter credit card number : "+CCNumber);
			
			group.Group_Folio_ExpDate.sendKeys(CCExpiry);
			test.log(LogStatus.PASS, "Enter Card expiry date : "+CCExpiry);
			groupLogger.info("Enter Card expiry date : "+CCExpiry);
			
			group.Group_Folio_CVV.sendKeys(CCVCode);
			test.log(LogStatus.PASS, "Enter card CVV : "+CCVCode);
			groupLogger.info("Enter card CVV : "+CCVCode);
			
			group.Group_Folio_OK.click();
			test.log(LogStatus.PASS, "Clicking on Folio Ok");
			groupLogger.info("Clicking on Folio Ok");
			
			Wait.wait3Second();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
			new Select (group.Group_Folio_AuthType).selectByVisibleText(Authorizationtype);
			test.log(LogStatus.PASS, "Select Authorization type : "+Authorizationtype);
			groupLogger.info("Select Authorization type : "+Authorizationtype);
			
			if(ChangeAmount.equalsIgnoreCase("Yes"))
			{
				group.Group_Folio_Amount.clear();
				Wait.wait2Second();
				group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
				test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
				groupLogger.info("Enter Amount to pay "+ChangeAmountValue);
			}
			else
			{
			//	System.out.println("Processed complete amount");
				groupLogger.info("Processed complete amount");
				
			}
			Wait.wait2Second();
			if(Authorizationtype.equalsIgnoreCase("Capture"))
			{
				Wait.wait2Second();
				group.Group_Folio_Process.click();
				test.log(LogStatus.PASS, "Clicking on Folio");
				groupLogger.info("Clicking on Folio");
			}
			Wait.wait3Second();

			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			Wait.wait3Second();
			Wait.explicit_wait_xpath("//table[@id='dgTransactionPayList']/tbody/tr[2]/td[4]");
			String GetPaymentMethod=new Select(group.Group_Folio_PaymentMethod).getFirstSelectedOption().getText();
			//System.out.println(GetPaymentMethod + " "+GetPaymentMethod);
			if(GetPaymentMethod.equals(PaymentType))
			{
				//System.out.println("Paymnet Success");
				
				groupLogger.info("Payment Success");
			}
			else
			{
				//System.out.println("Paymnet Failed");
			}
			group.Group_Folio_Continue.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			groupLogger.info("Clicking on Continue");
			
			Wait.wait3Second();

			Alert alert = driver.switchTo().alert();
			alert.accept();
			Wait.wait3Second();
			try{
				if(driver.switchTo().alert() != null){
					alert.accept();
				}
			}catch(Exception e){
				//System.out.println("No Alert");
			}
			Wait.wait2Second();
			try{
				String GetMCCard=driver.findElement(By.xpath("//a[contains(text(),'Name')]")).getText();
				//System.out.println(GetMCCard + " "+GetMCCard);
				if(GetMCCard.contains("Name: test Account #: XXXX5454 Exp."))
				{
					//System.out.println("Paymnet Success");
					test.log(LogStatus.PASS, "Payment Success");
					groupLogger.info("Payment Success");
				}
			}catch(Exception e){
				test.log(LogStatus.FAIL, "Card payment failure");
				groupLogger.info("Card payment failure");
				Assert.fail();
			}

			driver.switchTo().defaultContent();
			Wait.wait2Second();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			
			navigateFolio(driver, test);

			String str=driver.findElement(By.xpath("//span[@id='MainContent_Folio1_fSummary1_lblAdvanceDepositBalance']")).getText();
			str=str.replace("$", "");
			str=str.trim();
			float a = Float.parseFloat(str);
			test.log(LogStatus.PASS, "Advanced deposit balance "+str);
			groupLogger.info("Advanced deposit balance "+str);

			if(a==Float.parseFloat(ChangeAmountValue)){
				test.log(LogStatus.PASS, "Advanced Deposit Successfull for : "+str);
				groupLogger.info("Advanced Deposit Successfull for : "+str);
			}else{
				test.log(LogStatus.FAIL, "Advanced Deposit not sucessfull for : "+str);
				groupLogger.info("Advanced Deposit not sucessfull for : "+str);
			}

			String balance1 = group.Group_Folio_EndingBalance.getText();		
			balance1=balance1.replace("$", "");
			float bal1 = Float.parseFloat(balance1);
			test.log(LogStatus.PASS, "After pay Folio balance "+bal1);
			groupLogger.info("After pay Folio balance "+bal1);

			if(bal1+Float.parseFloat(ChangeAmountValue)==bal){
				test.log(LogStatus.PASS, "Cash Payment "+ChangeAmountValue+ " is successful");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is successful");
			}else{
				test.log(LogStatus.FAIL, "Cash Payment "+ChangeAmountValue+ " is Fail");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is Fail");
			}
		}else if(PaymentType.equalsIgnoreCase("Cash")){
			Wait.wait2Second();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));

			WebDriverWait wait = new WebDriverWait(driver,90);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))));
			new Select (driver.findElement(By.xpath("//span[@id='lblPaymentMethod']/../following-sibling::td/select"))).selectByVisibleText(PaymentType);

			test.log(LogStatus.PASS, "Select Payment type "+PaymentType);
			groupLogger.info("Select Payment type "+PaymentType);
			
			Wait.wait2Second();
			group.Group_Folio_Amount.clear();
			Wait.wait2Second();
			group.Group_Folio_Amount.sendKeys(ChangeAmountValue);
			test.log(LogStatus.PASS, "Enter Amount to pay "+ChangeAmountValue);
			groupLogger.info("Enter Amount to pay "+ChangeAmountValue);
			Wait.wait2Second();

			group.Group_Folio_Add.click();
			test.log(LogStatus.PASS, "Clicking on Add");
			groupLogger.info("Clicking on Add");

			Wait.wait3Second();
			driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			Wait.wait3Second();
			group.Group_Folio_Continue.click();
			test.log(LogStatus.PASS, "Clicking on Continue");
			groupLogger.info("Clicking on Continue");
			Wait.wait3Second();
			driver.switchTo().defaultContent();
			Save(driver,test);
			test.log(LogStatus.PASS, "Clicking on Save Account");
			groupLogger.info("Clicking on Save Account");
			navigateFolio(driver, test);

			String str=driver.findElement(By.xpath("//span[@id='MainContent_Folio1_fSummary1_lblAdvanceDepositBalance']")).getText();
			str=str.replace("$", "");
			str=str.trim();
			float a = Float.parseFloat(str);
			test.log(LogStatus.PASS, "Advanced deposit balance "+str);
			groupLogger.info("Advanced deposit balance "+str);

			if(a==Float.parseFloat(ChangeAmountValue)){
				test.log(LogStatus.PASS, "Advanced Deposit Successfull for : "+str);
				groupLogger.info("Advanced Deposit Successfull for : "+str);
			}else{
				test.log(LogStatus.FAIL, "Advanced Deposit not successful for : "+str);
				groupLogger.info("Advanced Deposit not successful for : "+str);
			}

			String balance1 = group.Group_Folio_EndingBalance.getText();		
			balance1=balance1.replace("$", "");
			float bal1 = Float.parseFloat(balance1);
			test.log(LogStatus.PASS, "After pay Folio balance "+bal1);
			groupLogger.info("After pay Folio balance "+bal1);

			if(bal1+Float.parseFloat(ChangeAmountValue)==bal){
				test.log(LogStatus.PASS, "Cash Payment "+ChangeAmountValue+ " is successful");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is successful");
			}else{
				test.log(LogStatus.FAIL, "Cash Payment "+ChangeAmountValue+ " is Fail");
				groupLogger.info("Cash Payment "+ChangeAmountValue+ " is Fail");
			}
		}	
	}
}
