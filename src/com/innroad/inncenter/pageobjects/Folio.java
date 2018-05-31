package com.innroad.inncenter.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innroad.inncenter.interfaces.IFolio;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_All_Payments;
import com.innroad.inncenter.webelements.Elements_FolioLineItemsVoid;
import com.innroad.inncenter.webelements.Elements_MovieFolio;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Folio implements IFolio {

	public static Logger folioLogger = Logger.getLogger("Folio");

	public void MoveFolioInsideReservation(WebDriver driver, ExtentTest test, String resNumber1, String newFolioName,
			String newFolioDescription) throws InterruptedException {

		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		// Search Reservation

		/*
		 * ReservationSearch resSearch = new ReservationSearch();
		 * resSearch.basicSearch_WithResNumber(driver,resNumber1);
		 * test.log(LogStatus.PASS,
		 * "System opened reservation number "+resNumber1);
		 * folioLogger.info("System opened reservation number "+resNumber1);
		 */

		// waiting for the visibility of guest info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));

		Wait.WaitForElement(driver, OR.GuestInfo);

		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio);

		// click on Folio Tab
		moveFolio.MoveFolio_NewFolio.click();

		// Waiting for visibility of new Folio Details
		
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolioDeatils);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		test.log(LogStatus.PASS, "Successfully New Folio Details pop up ");
		folioLogger.info("Successfully New Folio Details pop up ");

		// new Folio creation
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Name);
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : " + newFolioName);
		folioLogger.info("Successfully Entered the New Folio Name : " + newFolioName);

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Description);
		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : " + newFolioDescription);
		folioLogger.info("Successfully Entered the New Folio Description : " + newFolioDescription);

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Save);
		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");
		//Wait.wait10Second();
		// Waiting for visibility of adjoining rooms
		
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_SaveReservation);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		
		Wait.WaitForElement(driver, "//div[@id='toast-container']/div/div");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		Wait.wait1Second();
		Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : " + newFolioName);
		folioLogger.info("Successfully opened the new Folio : " + newFolioName);

		sel.selectByIndex(0);
		Wait.wait1Second();
		sel.selectByVisibleText(newFolioName);
		Wait.wait1Second();
		sel.selectByIndex(0);
		Wait.wait2Second();
		
		Wait.WaitForElement(driver, "//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']");
		String Balance=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance=Balance.replace("$", "");

		Double d = Double.parseDouble(Balance);
		folioLogger.info("Folio Balance : " + d);

		// select the folio item to move
		moveFolio.MoveFolio_SelectFiloItem.click();
		test.log(LogStatus.PASS, "Successfully selected the folio Item");
		folioLogger.info("Successfully selected the folio Item");

		
		Wait.WaitForElement(driver, OR.MoveFolio_Move);

		moveFolio.MoveFolio_Move.click();
		test.log(LogStatus.PASS, "Successfully clieked on move");
		folioLogger.info("Successfully clieked on move");

		// Folio items to move to target folio pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
		Wait.WaitForElement(driver, OR.MoveFolio_TargetFolio);
		sel = new Select(moveFolio.MoveFolio_TargetFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : " + newFolioName);
		folioLogger.info("Successfully opened the new Folio : " + newFolioName);

		//move folio items to target folio pop up
		
		Wait.WaitForElement(driver, OR.MoveFolio_FolioItemToMove);

		moveFolio.MoveFolio_FolioItemToMove.click();
		test.log(LogStatus.PASS, "Successfully clieked on folio item");
		folioLogger.info("Successfully clieked on folio item");

		Wait.WaitForElement(driver, OR.MoveFolio_MoveSelectedItem);
		moveFolio.MoveFolio_MoveSelectedItem.click();
		test.log(LogStatus.PASS, "Successfully moved folio item");
		folioLogger.info("Successfully moved folio item");

		Wait.WaitForElement(driver, OR.MoveFolio_Close);
		moveFolio.MoveFolio_Close.click();
		test.log(LogStatus.PASS, "Successfully clicked on close");
		folioLogger.info("Successfully clicked on close");

		//Wait.wait2Second();
		Wait.WaitForElement(driver, "//div[@id='toast-container']/div/div[2]");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));

		String Balance1 = driver
				.findElement(By
						.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']"))
				.getText();
		Balance1 = Balance1.replace("$", "");

		Double d1 = Double.parseDouble(Balance1);
		folioLogger.info("Folio Old Balance : " + d1);

		// validation folio items
		sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : " + newFolioName);
		folioLogger.info("Successfully opened the new Folio : " + newFolioName);
		if (driver.findElements(By.xpath(OR.MoveFolio_SelectFiloItem)).size() > 0) {
			test.log(LogStatus.PASS, "Successfully moved the folio Item to : " + newFolioName);
			folioLogger.info("Successfully moved the folio Item to : " + newFolioName);

			String Balance2 = driver
					.findElement(By
							.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']"))
					.getText();
			Balance2 = Balance2.replace("$", "");

			Double d2 = Double.parseDouble(Balance2);
			folioLogger.info("Folio New Balance : " + d2);
			if (d == d1 + d2) {
				test.log(LogStatus.PASS, "Successfully Validated Folio Balances");
				folioLogger.info("Successfully Validated Folio Balances");
			} else {
				test.log(LogStatus.FAIL, "Folio Balance Fail");
				folioLogger.info("Folio Balance Fail");
			}
		}
	}

	@Override
	public void MoveFolioInsideReservation(WebDriver driver, ExtentTest test, String resNumber1, String resNumber2,
			Double d, Double d2) throws Exception {
		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		String resName;

		// Search and open Reservation1
		ReservationSearch resSearch	= new ReservationSearch();
		resName=resSearch.basicSearch_WithResNumber(driver,resNumber1);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
		folioLogger.info("System opened reservation number "+resNumber1);

		Wait.WaitForElement(driver, OR.Reservations);
		// Search and open Reservation2
		moveFolio.Reservations.click();
		Wait.wait2Second();
		resSearch.basicSearch_WithResNumber(driver,resNumber2);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber2);
		folioLogger.info("System opened reservation number "+resNumber2);

		//opening the first reservation tab
		Wait.WaitForElement(driver, OR.FirstOpenedReservation);

		moveFolio.FirstOpenedReservation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		//Wait.wait3Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_Folio);
		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");

		// Select the folio item to move
		//Wait.wait2Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_SelectFiloItem);
		moveFolio.MoveFolio_SelectFiloItem.click();
		test.log(LogStatus.PASS, "Successfully selected the folio Item");
		folioLogger.info("Successfully selected the folio Item");

		// click on move
		//Wait.wait3Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_Move);
		moveFolio.MoveFolio_Move.click();
		test.log(LogStatus.PASS, "Successfully clieked on move");
		folioLogger.info("Successfully clieked on move");

		// Select the guest folio of another reservation
		Wait.WaitForElement(driver, OR.MoveFolio_TargetFolio);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
		Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
		sel.selectByVisibleText("Guest Folio");
		test.log(LogStatus.PASS, "Successfully opened the new Folio : " + "Guest Folio");
		folioLogger.info("Successfully opened the new Folio : " + "Guest Folio");

		// move Folio item to another reservation folio
		Wait.WaitForElement(driver, OR.MoveFolio_FolioItemToMove);
		moveFolio.MoveFolio_FolioItemToMove.click();
		test.log(LogStatus.PASS, "Successfully clieked on folio item");
		folioLogger.info("Successfully clieked on folio item");

		Wait.WaitForElement(driver, OR.MoveFolio_MoveSelectedItem);
		moveFolio.MoveFolio_MoveSelectedItem.click();
		test.log(LogStatus.PASS, "Successfully moved folio item");
		folioLogger.info("Successfully moved folio item");

		Wait.WaitForElement(driver, OR.MoveFolio_Close);
		moveFolio.MoveFolio_Close.click();
		test.log(LogStatus.PASS, "Successfully clicked on close");
		folioLogger.info("Successfully clicked on close");
		wait.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));

		// closing first reservation and validation second reservation folio
		Wait.WaitForElement(driver, OR.FirstOpenedReservationClose);
		moveFolio.FirstOpenedReservationClose.click();
		Wait.WaitForElement(driver, OR.FirstOpenedReservation);
		moveFolio.FirstOpenedReservation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		//Wait.wait3Second();
		Wait.WaitForElement(driver, OR.MoveFolio_Folio);
		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of guest folio
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");
		//Wait.wait2Second();
		Wait.WaitForElement(driver, "//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']");
		String Balance1=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance1=Balance1.replace("$", "");

		Double d1 = Double.parseDouble(Balance1);
		folioLogger.info("Folio First Balance : " + d1);

		if (driver
				.findElements(By
						.xpath("//table[@class='table table-striped table-bordered table-hover trHeight25']/tbody/tr/td/input"))
				.size() > 1) {

			if (d1 == d + d2) {
				test.log(LogStatus.PASS, "Successfully moved the folio Item");
				test.log(LogStatus.PASS, "Folio Balance is same : " + d1);
				folioLogger.info("Folio Balance is same : " + d1);
			} else {
				test.log(LogStatus.FAIL, "Successfully moved the folio Item");
				test.log(LogStatus.FAIL, "Folio Balance is same : " + d1);
				folioLogger.info("Folio Balance is not same : " + d1);
			}

		}

	}

	public void newFolio(WebDriver driver, ExtentTest test, String resNumber1, String newFolioName,
			String newFolioDescription) throws InterruptedException {

		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
		ReservationSearch resSearch = new ReservationSearch();

		moveFolio.FirstOpenedReservationClose.click();

		// Search Reservation
		resSearch.basicSearch_WithResNumber(driver, resNumber1);
		test.log(LogStatus.PASS, "System opened reservation number " + resNumber1);
		// System.out.println("System opened reservation number "+resNumber1);
		folioLogger.info("System opened reservation number " + resNumber1);

		// waiting for the vivibility of guest info
		
		Wait.WaitForElement(driver, OR.GuestInfo);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		//Wait.wait3Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_Folio);
		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		Wait.WaitForElement(driver, OR.MoveFolio_GuestFolio);
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Clicked on Folio Tab");

		// click on Folio Tab
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio);
		moveFolio.MoveFolio_NewFolio.click();

		// Waiting for visibility of new Folio Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolioDeatils);
		test.log(LogStatus.PASS, "Successfully New Folio Details pop up");
		folioLogger.info("Successfully New Folio Details pop up");

		// new Folio creation
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Name);
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);
		folioLogger.info("Successfully Entered the New Folio Name : "+newFolioName);
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Description);
		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);
		folioLogger.info("Successfully Entered the New Folio Description : "+newFolioDescription);


		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Save);
		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		// test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");

		//Wait.wait3Second();
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_SaveReservation);
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		//Wait.wait3Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_GuestFolio);
		Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
		folioLogger.info("Successfully opened the new Folio : "+newFolioName);
		//Wait.wait5Second();
		
		Wait.WaitForElement(driver, OR.Edit_Folio_Btn);
		moveFolio.Edit_Folio_Btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Name);
		moveFolio.MoveFolio_NewFolio_Name.clear();
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName + "test");
		test.log(LogStatus.PASS, "Successfully edited the New Folio Name : " + newFolioName + "test");
		folioLogger.info("Successfully edited the New Folio Name : " + newFolioName + "test");

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Description);
		moveFolio.MoveFolio_NewFolio_Description.clear();
		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription + "test");

		test.log(LogStatus.PASS, "Successfully edited the New Folio Description : " + newFolioDescription + "test");
		folioLogger.info("Successfully edited the New Folio Description : " + newFolioDescription + "test");

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_Save);
		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		// test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");

		Wait.WaitForElement(driver, OR.MoveFolio_NewFolio_SaveReservation);
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		//Wait.wait3Second();
		
		Wait.WaitForElement(driver, OR.MoveFolio_GuestFolio);
		sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName + "test");
		test.log(LogStatus.PASS, "Successfully opened the new Folio : " + newFolioName + "test");
		folioLogger.info("Successfully opened the new Folio : " + newFolioName + "test");

		sel.selectByIndex(0);
		Wait.wait1Second();
		sel.selectByVisibleText(newFolioName + "test");
		Wait.wait1Second();

		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.Delete_Folio_Btn)));
		
		Wait.WaitForElement(driver, OR.Delete_Folio_Btn);

		moveFolio.Delete_Folio_Btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		// test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		Wait.wait5Second();
		if(!(driver.findElements(By.xpath("//select[@class='form-control folioFil']/option")).size()>1)){
			test.log(LogStatus.PASS, "Sucessfully deleted the folio : "+newFolioName+"test");
			folioLogger.info("Sucessfully deleted the folio : "+newFolioName+"test");
		}
	}

	public void LineItem(WebDriver driver, String SelectCategory, String Amount) throws InterruptedException {

		Elements_FolioLineItemsVoid Ele_FolioItem = new Elements_FolioLineItemsVoid(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		java.util.List<WebElement> element = driver.findElements(By.xpath(OR.AddButton));
		jse.executeScript("arguments[0].scrollIntoView();", element.get(0));
		element.get(0).click();
		Wait.wait2Second();
		new Select(Ele_FolioItem.SelectCategory).selectByVisibleText(SelectCategory);
		int size = Ele_FolioItem.LineItemsAmountFields.size();
		Ele_FolioItem.LineItemsAmountFields.get(size - 1).sendKeys(Amount);
		Ele_FolioItem.CommitButton.get(0).click();
	}

	public void VerifyLineItem(WebDriver driver, String Date, String Property, String Category, String Amount) {

		Elements_FolioLineItemsVoid Elements_FolioLineItemsVoid = new Elements_FolioLineItemsVoid(driver);
		String Charges = Elements_FolioLineItemsVoid.RoomCharger_Tax.get(0).getText();
		String Incidentals =  Elements_FolioLineItemsVoid.RoomCharger_Tax.get(1).getText();
		String Tax =  Elements_FolioLineItemsVoid.RoomCharger_Tax.get(2).getText();
		
		// Split $ sign
		String[] str_charger = Charges.split(" ");	
		String[] str_incidentals = Incidentals.split(" ");
		String[] str_tax = Tax.split(" ");

		double do_charger = Double.valueOf(str_charger[1]);
		double do_incidentals = Double.valueOf(str_incidentals[1]);
		double do_tax = Double.valueOf(str_tax[1]);
		
		// Calculate total charger with tax
		double total_amount_after_tax = do_charger+do_incidentals+do_tax;
		String str_total = String.valueOf(total_amount_after_tax);
		
		String Total_Charges =  Elements_FolioLineItemsVoid.RoomCharger_Tax.get(3).getText();
		String Pyments =  Elements_FolioLineItemsVoid.RoomCharger_Tax.get(4).getText();
		String Balance = Elements_FolioLineItemsVoid.RoomCharger_Tax.get(5).getText();
		// payments
		String[] str_payments = Pyments.split(" ");
		double balance_after_paymenys = Double.valueOf(str_payments[1])+total_amount_after_tax;
		
		assertTrue(Total_Charges.contains(str_total),
				"Total Charges does not conatin amount");
		assertTrue(Balance.contains(String.valueOf(balance_after_paymenys)),
				"Balance does not conatin amount");
		
	}

	public void Cash_Payment(WebDriver driver, String Amount, String PaymentType) throws InterruptedException {

		Elements_All_Payments elements_All_Payments = new Elements_All_Payments(driver);
		Elements_FolioLineItemsVoid Elements_FolioLineItemsVoid = new Elements_FolioLineItemsVoid(driver);

		WebElement element = driver.findElement(By.xpath(OR.PayButton));
		elements_All_Payments.Folio.get(0).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
		Wait.explicit_wait_xpath(OR.PaymentPopUp);
		Wait.wait2Second();
		assertEquals(elements_All_Payments.PaymentPopUp.getText(), "Payment Details", "payment popup does not open");

		// select payment type as cash
		new Select(elements_All_Payments.PaymentType).selectByVisibleText(PaymentType);
		elements_All_Payments.Enter_Amount.clear();
		for (int i = 0; i < 10; i++) {
			elements_All_Payments.Enter_Amount.sendKeys(Keys.BACK_SPACE);
		}
		elements_All_Payments.Enter_Amount.sendKeys(Amount);

		// Add button
		elements_All_Payments.Add_Pay_Button.click();
		Wait.wait2Second();
		driver.findElement(By.xpath(OR.Continue_Pay_Button)).click();
		Wait.wait2Second();

		// Verify cash payment
		int LineItem_Size = Elements_FolioLineItemsVoid.LineItems.size();
		assertTrue(Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 10).getText().contains("cash"),
				"payament type does not add in line item");
		assertTrue(
				Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 7).getText().contains(String.valueOf(Amount)),
				"Amount does not add in line item");

	}

	public void CardPayment(WebDriver driver, String PaymentType, String Amount, String CardName, String CardNum,
			String ExpDate, String CVVCode, String Address, String City, String State, String PostalCode,
			String AuthCode) throws InterruptedException {

		Elements_All_Payments elements_All_Payments = new Elements_All_Payments(driver);
		WebElement element = driver.findElement(By.xpath(OR.PayButton));
		elements_All_Payments.Folio.get(0).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
		Wait.explicit_wait_xpath(OR.PaymentPopUp);
		Wait.wait2Second();
		assertEquals(elements_All_Payments.PaymentPopUp.getText(), "Payment Details", "payment popup does not open");

		// select payment type as cash
		new Select(elements_All_Payments.PaymentType).selectByVisibleText(PaymentType);
		elements_All_Payments.Enter_Amount.clear();
		for (int i = 0; i < 10; i++) {
			elements_All_Payments.Enter_Amount.sendKeys(Keys.BACK_SPACE);
		}
		elements_All_Payments.Payment_Info_Button.click();
		Wait.explicit_wait_xpath(OR.Payment_Info_Button);
		Wait.wait2Second();
		elements_All_Payments.Enter_Amount.sendKeys(Amount);
		elements_All_Payments.Enter_CardName.sendKeys(CardName);
		elements_All_Payments.Enter_CardNum.sendKeys(CardNum);
		elements_All_Payments.Enter_ExpDate.sendKeys(ExpDate);
		elements_All_Payments.Enter_Card_CVVCode.sendKeys(CVVCode);
		elements_All_Payments.Enter_Address.sendKeys(Address);
		elements_All_Payments.Enter_Card_City.sendKeys(City);
		elements_All_Payments.Enter_Card_State.sendKeys(State);
		elements_All_Payments.Enter_PostalCode.sendKeys(PostalCode);
		elements_All_Payments.Enter_ApprovalCode.sendKeys(AuthCode);
		elements_All_Payments.CardOK_Button.click();
		Wait.wait2Second();
		elements_All_Payments.Process_Button.click();
		Wait.wait3Second();
		driver.findElement(By.xpath(OR.Continue_Pay_Button)).click();
		Wait.wait2Second();
		
		// Verify payament
		Elements_FolioLineItemsVoid Elements_FolioLineItemsVoid = new Elements_FolioLineItemsVoid(driver);
		int LineItem_Size = Elements_FolioLineItemsVoid.LineItems.size();
		assertTrue(Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 10).getText().contains(PaymentType),
				"payament type does not add in line item");
		assertTrue(
				Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 7).getText().contains(String.valueOf(Amount)),
				"Amount does not add in line item");
		
	}
	
	public void Card_Swipe_Payment(WebDriver driver, String Amount, String PaymentType,
			String CardNumber) throws InterruptedException {

		Elements_All_Payments elements_All_Payments = new Elements_All_Payments(driver);
		Elements_FolioLineItemsVoid Elements_FolioLineItemsVoid = new Elements_FolioLineItemsVoid(driver);

		WebElement element = driver.findElement(By.xpath(OR.PayButton));
		elements_All_Payments.Folio.get(0).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
		Wait.explicit_wait_xpath(OR.PaymentPopUp);
		Wait.wait2Second();
		assertEquals(elements_All_Payments.PaymentPopUp.getText(), "Payment Details", "payment popup does not open");

		// select payment type as cash
		new Select(elements_All_Payments.PaymentType).selectByVisibleText(PaymentType);
		elements_All_Payments.Enter_Amount.clear();
		for (int i = 0; i < 10; i++) {
			elements_All_Payments.Enter_Amount.sendKeys(Keys.BACK_SPACE);
		}
		elements_All_Payments.Enter_Amount.sendKeys(Amount);
		// card swipe 
		elements_All_Payments.PaymentSwipe_Img.click();
		elements_All_Payments.SwipeCard_Field.sendKeys(CardNumber);
		Wait.wait2Second();
        // Process
		elements_All_Payments.Process_Button.click();
		Wait.wait3Second();
		driver.findElement(By.xpath(OR.Continue_Pay_Button)).click();
		
		
		Wait.wait2Second();

		// Verify cash payment
		int LineItem_Size = Elements_FolioLineItemsVoid.LineItems.size();
		assertTrue(Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 10).getText().contains(PaymentType),
				"Payament type does not add in line item");
		assertTrue(
				Elements_FolioLineItemsVoid.LineItems.get(LineItem_Size - 7).getText().contains(String.valueOf(Amount)),
				"Amount does not add in line item");

	}

}
