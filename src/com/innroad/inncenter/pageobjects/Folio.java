package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.innroad.inncenter.interfaces.IFolio;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_MovieFolio;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Folio implements IFolio{


	public static Logger folioLogger = Logger.getLogger("Folio");

	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescription) throws InterruptedException{


		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		// Search Reservation

		/*ReservationSearch resSearch	= new ReservationSearch();
		resSearch.basicSearch_WithResNumber(driver,resNumber1);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
		folioLogger.info("System opened reservation number "+resNumber1);*/

		// waiting for the visibility of guest info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		Wait.wait3Second();;

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));

		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");


		// click on Folio Tab
		moveFolio.MoveFolio_NewFolio.click();

		// Waiting for visibility of new Folio Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		test.log(LogStatus.PASS, "Successfully New Folio Details pop up ");
		folioLogger.info("Successfully New Folio Details pop up ");

		// new Folio creation
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);
		folioLogger.info("Successfully Entered the New Folio Name : "+newFolioName);

		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);
		folioLogger.info("Successfully Entered the New Folio Description : "+newFolioDescription);

		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");
		Wait.wait10Second();
		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		Wait.wait1Second();
		Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
		folioLogger.info("Successfully opened the new Folio : "+newFolioName);

		sel.selectByIndex(0);
		Wait.wait1Second();
		sel.selectByVisibleText(newFolioName);
		Wait.wait1Second();
		sel.selectByIndex(0);
		Wait.wait2Second();
		String Balance=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance=Balance.replace("$", "");

		Double d = Double.parseDouble(Balance);
		folioLogger.info("Folio Balance : "+d);

		// select the folio item to move
		moveFolio.MoveFolio_SelectFiloItem.click();
		test.log(LogStatus.PASS, "Successfully selected the folio Item");
		folioLogger.info("Successfully selected the folio Item");

		//Click on move
		Wait.wait3Second();
		moveFolio.MoveFolio_Move.click();
		test.log(LogStatus.PASS, "Successfully clieked on move");
		folioLogger.info("Successfully clieked on move");

		// Folio items to move to target folio pop up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
		sel = new Select(moveFolio.MoveFolio_TargetFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
		folioLogger.info("Successfully opened the new Folio : "+newFolioName);

		//move folio items to target folio pop up
		moveFolio.MoveFolio_FolioItemToMove.click();
		test.log(LogStatus.PASS, "Successfully clieked on folio item");
		folioLogger.info("Successfully clieked on folio item");

		moveFolio.MoveFolio_MoveSelectedItem.click();
		test.log(LogStatus.PASS, "Successfully moved folio item");
		folioLogger.info("Successfully moved folio item");

		moveFolio.MoveFolio_Close.click();
		test.log(LogStatus.PASS, "Successfully clicked on close");
		folioLogger.info("Successfully clicked on close");

		Wait.wait2Second();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));

		String Balance1=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance1=Balance1.replace("$", "");

		Double d1 = Double.parseDouble(Balance1);
		folioLogger.info("Folio Old Balance : "+d1);

		//validation folio items
		sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
		folioLogger.info("Successfully opened the new Folio : "+newFolioName);
		if(driver.findElements(By.xpath(OR.MoveFolio_SelectFiloItem)).size()>0){
			test.log(LogStatus.PASS, "Successfully moved the folio Item to : "+newFolioName);
			folioLogger.info("Successfully moved the folio Item to : "+newFolioName);

			String Balance2=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
			Balance2=Balance2.replace("$", "");

			Double d2 = Double.parseDouble(Balance2);
			folioLogger.info("Folio New Balance : "+d2);
			if(d==d1+d2){
				test.log(LogStatus.PASS, "Successfully Validated Folio Balances");
				folioLogger.info("Successfully Validated Folio Balances");
			}else{
				test.log(LogStatus.FAIL, "Folio Balance Fail");
				folioLogger.info("Folio Balance Fail");
			}
		}
	}

	@Override
	public void MoveFolioInsideReservation(WebDriver driver, ExtentTest test, String resNumber1, String resNumber2,Double d,Double d2) throws Exception {
		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		String resName;

		// Search and open Reservation1
		ReservationSearch resSearch	= new ReservationSearch();
		resName=resSearch.basicSearch_WithResNumber(driver,resNumber1);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
		folioLogger.info("System opened reservation number "+resNumber1);

		// Search and open Reservation2
		moveFolio.Reservations.click();
		Wait.wait5Second();
		resSearch.basicSearch_WithResNumber(driver,resNumber2);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber2);
		folioLogger.info("System opened reservation number "+resNumber2);

		//opening the first reservation tab
		moveFolio.FirstOpenedReservation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		Wait.wait3Second();
		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");

		// Select the folio item to move
		Wait.wait2Second();
		moveFolio.MoveFolio_SelectFiloItem.click();
		test.log(LogStatus.PASS, "Successfully selected the folio Item");
		folioLogger.info("Successfully selected the folio Item");

		// click on move
		Wait.wait3Second();
		moveFolio.MoveFolio_Move.click();
		test.log(LogStatus.PASS, "Successfully clieked on move");
		folioLogger.info("Successfully clieked on move");

		// Select the guest folio of another reservation
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
		Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
		sel.selectByVisibleText("Guest Folio");
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+"Guest Folio");
		folioLogger.info("Successfully opened the new Folio : "+"Guest Folio");

		// move Folio item to another reservation folio
		moveFolio.MoveFolio_FolioItemToMove.click();
		test.log(LogStatus.PASS, "Successfully clieked on folio item");
		folioLogger.info("Successfully clieked on folio item");

		moveFolio.MoveFolio_MoveSelectedItem.click();
		test.log(LogStatus.PASS, "Successfully moved folio item");
		folioLogger.info("Successfully moved folio item");

		moveFolio.MoveFolio_Close.click();
		test.log(LogStatus.PASS, "Successfully clicked on close");
		folioLogger.info("Successfully clicked on close");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));

		// closing first reservation and validation second reservation folio
		moveFolio.FirstOpenedReservationClose.click();
		moveFolio.FirstOpenedReservation.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		Wait.wait3Second();
		moveFolio.MoveFolio_Folio.click();

		// Waiting for visibility of guest folio
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Successfully opened the Folio Tab");
		Wait.wait2Second();

		String Balance1=driver.findElement(By.xpath("//label[contains(text(),'Balance: ')]/following-sibling::span[@class='pamt']/span[@class='pamt']")).getText();
		Balance1=Balance1.replace("$", "");

		Double d1 = Double.parseDouble(Balance1);
		folioLogger.info("Folio First Balance : "+d1);

		if(driver.findElements(By.xpath("//table[@class='table table-striped table-bordered table-hover trHeight25']/tbody/tr/td/input")).size()>1){
			
			if(d1==d+d2){
				test.log(LogStatus.PASS, "Successfully moved the folio Item");
				test.log(LogStatus.PASS, "Folio Balance is same : "+d1);
				folioLogger.info("Folio Balance is same : "+d1);
			}else{
				test.log(LogStatus.FAIL, "Successfully moved the folio Item");
				test.log(LogStatus.FAIL, "Folio Balance is same : "+d1);
				folioLogger.info("Folio Balance is not same : "+d1);
			}

		}

	}


	public void newFolio(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescription) throws InterruptedException{

		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
		ReservationSearch resSearch	= new ReservationSearch();

		moveFolio.FirstOpenedReservationClose.click();
		Wait.wait3Second();
		
		// Search Reservation
		resSearch.basicSearch_WithResNumber(driver,resNumber1);
		test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
		//System.out.println("System opened reservation number "+resNumber1);
		folioLogger.info("System opened reservation number "+resNumber1);

		// waiting for the vivibility of guest info
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
		wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
		Wait.wait3Second();
		moveFolio.MoveFolio_Folio.click();
		

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
		test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
		folioLogger.info("Clicked on Folio Tab");

		// click on Folio Tab
		moveFolio.MoveFolio_NewFolio.click();
		
		// Waiting for visibility of new Folio Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		test.log(LogStatus.PASS, "Successfully New Folio Details pop up");
		folioLogger.info("Successfully New Folio Details pop up");

		// new Folio creation
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
		test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);
		folioLogger.info("Successfully Entered the New Folio Name : "+newFolioName);
		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);

		test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);
		folioLogger.info("Successfully Entered the New Folio Description : "+newFolioDescription);

		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");

		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		//test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");

		Wait.wait3Second();
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		Wait.wait3Second();
		Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName);
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
		folioLogger.info("Successfully opened the new Folio : "+newFolioName);
		Wait.wait5Second();
		moveFolio.Edit_Folio_Btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
		moveFolio.MoveFolio_NewFolio_Name.clear();
		moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName+"test");
		test.log(LogStatus.PASS, "Successfully edited the New Folio Name : "+newFolioName+"test");
		folioLogger.info("Successfully edited the New Folio Name : "+newFolioName+"test");

		moveFolio.MoveFolio_NewFolio_Description.clear();
		moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription+"test");

		test.log(LogStatus.PASS, "Successfully edited the New Folio Description : "+newFolioDescription+"test");
		folioLogger.info("Successfully edited the New Folio Description : "+newFolioDescription+"test");

		moveFolio.MoveFolio_NewFolio_Save.click();
		test.log(LogStatus.PASS, "Successfully clicked save Folio");
		folioLogger.info("Successfully clicked save Folio");
		//System.out.println("clicked on save folio");
		Wait.wait3Second();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		//test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");			

		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		// select new folio
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
		Wait.wait3Second();
		sel = new Select(moveFolio.MoveFolio_GuestFolio);
		sel.selectByVisibleText(newFolioName+"test");
		test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName+"test");
		folioLogger.info("Successfully opened the new Folio : "+newFolioName+"test");

		sel.selectByIndex(0);
		Wait.wait1Second();
		sel.selectByVisibleText(newFolioName+"test");
		Wait.wait1Second();

		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.Delete_Folio_Btn)));
		moveFolio.Delete_Folio_Btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
		//test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");			
		moveFolio.MoveFolio_NewFolio_SaveReservation.click();
		test.log(LogStatus.PASS, "Successfully clicked save Reservation");
		folioLogger.info("Successfully clicked save Reservation");

		Wait.wait10Second();
		if(!(driver.findElements(By.xpath("//select[@class='form-control folioFil']/option")).size()>1)){
			test.log(LogStatus.PASS, "Sucessfully deleted the folio : "+newFolioName+"test");
			folioLogger.info("Sucessfully deleted the folio : "+newFolioName+"test");
		}
	}

}
