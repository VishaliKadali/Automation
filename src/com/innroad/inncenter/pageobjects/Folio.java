package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innroad.inncenter.interfaces.IFolio;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_MovieFolio;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Folio implements IFolio{


	public static Logger folioLogger = Logger.getLogger("Folio");

	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescription){


		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		// Search Reservation
		try{
			ReservationSearch resSearch	= new ReservationSearch();
			resSearch.basicSearch_WithResNumber(driver,resNumber1);
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
			
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}


		// waiting for the visibility of guest info
		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait3Second();;

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));

			moveFolio.MoveFolio_Folio.click();
			
			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");

		}catch(Exception e){
			e.printStackTrace();
			
			test.log(LogStatus.FAIL, "Folio Tab not opened");
		}

		// click on Folio Tab
		try{

			moveFolio.MoveFolio_NewFolio.click();
		
			// Waiting for visibility of new Folio Details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
			test.log(LogStatus.PASS, "Successfully New Folio Details pop up ");

		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
		}


		// new Folio creation
		try{

			Assert.assertTrue("Fail to find new folio name",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Name));

			moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
			test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);

			//System.out.println("Enter thye new folio name");

			Assert.assertTrue("Fail to find new folio description",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Description));

			moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);

		//	System.out.println("Enter thye new folio description");

			test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);

			Assert.assertTrue("Fail to find new folio close",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Close));
			Assert.assertTrue("Fail to find new folio save",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Save));

			moveFolio.MoveFolio_NewFolio_Save.click();
			test.log(LogStatus.PASS, "Successfully clicked save Folio");
			
			Wait.wait3Second();
			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
					

			moveFolio.MoveFolio_NewFolio_SaveReservation.click();
			test.log(LogStatus.PASS, "Successfully clicked save Reservation");
			

		}catch(Exception e){
		
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
		}

		// select new folio
		try{
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
			Wait.wait2Second();
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			
			sel.selectByIndex(0);
			Wait.wait2Second();
			sel.selectByVisibleText(newFolioName);
			Wait.wait2Second();
			sel.selectByIndex(0);
		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName);
		}

		// select the folio item to move
		try{
			Wait.wait3Second();
			moveFolio.MoveFolio_SelectFiloItem.click();
			test.log(LogStatus.PASS, "Successfully selected the folio Item");
		
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Unable to select the Fail item");
		}

		//Click on move
		try{
			Wait.wait3Second();
			moveFolio.MoveFolio_Move.click();
			test.log(LogStatus.PASS, "Successfully clieked on move");
			
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Unable to click on move");
		}


		// Folio items to move to target folio pop up
		try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
			Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName);
		}

		//move folio items to target folio pop up
		try{
			moveFolio.MoveFolio_FolioItemToMove.click();
			test.log(LogStatus.PASS, "Successfully clieked on folio item");
			
			moveFolio.MoveFolio_MoveSelectedItem.click();
			test.log(LogStatus.PASS, "Successfully moved folio item");
			
			moveFolio.MoveFolio_Close.click();
			test.log(LogStatus.PASS, "Successfully clicked on close");
			
			Wait.wait2Second();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));
			
		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on folio item");
		}

		//validation folio items
		try{
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			if(driver.findElements(By.xpath(OR.MoveFolio_SelectFiloItem)).size()>0){
				test.log(LogStatus.PASS, "Successfully moved the folio Item to : "+newFolioName);
				//System.out.println("Completed");
			}

		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.PASS, "not moved the folio Item to : "+newFolioName);
		}


	}

	@Override
	public void MoveFolioInsideReservation(WebDriver driver, ExtentTest test, String resNumber1, String resNumber2) {
		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);

		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);

		String resName;

		// Search and open Reservation1
		try{
			ReservationSearch resSearch	= new ReservationSearch();
			resName=resSearch.basicSearch_WithResNumber(driver,resNumber1);
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
			
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}

		// Search and open Reservation2
		try{
			moveFolio.Reservations.click();
			Wait.wait5Second();
			ReservationSearch resSearch	= new ReservationSearch();
			resSearch.basicSearch_WithResNumber1(driver,resNumber2);
			
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber2);
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}


		//opening the first reservation tab
		try{
			moveFolio.FirstOpenedReservation.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait3Second();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));

			moveFolio.MoveFolio_Folio.click();
			
			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");

		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			test.log(LogStatus.FAIL, "Folio Tab not opened");
		}


		// Select the folio item to move
		try{
			Wait.wait2Second();
			moveFolio.MoveFolio_SelectFiloItem.click();
			test.log(LogStatus.PASS, "Successfully selected the folio Item");
			
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Unable to select the Fail item");
		}

		// click on move
		try{
			Wait.wait3Second();
			moveFolio.MoveFolio_Move.click();
			test.log(LogStatus.PASS, "Successfully clieked on move");
			
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on move");
		}

		// Select the guest folio of another reservation
		try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
			Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
			sel.selectByVisibleText("Guest Folio");
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+"Guest Folio");
		
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+"Guest Folio");
		}

		// move Folio item to another reservation folio
		try{
			moveFolio.MoveFolio_FolioItemToMove.click();
			test.log(LogStatus.PASS, "Successfully clieked on folio item");
			
			moveFolio.MoveFolio_MoveSelectedItem.click();
			test.log(LogStatus.PASS, "Successfully moved folio item");
			
			moveFolio.MoveFolio_Close.click();
			test.log(LogStatus.PASS, "Successfully clicked on close");
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));
		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "Unable to click on folio item");
		}

		// closing first reservation and validation second reservation folio
		try{
			moveFolio.FirstOpenedReservationClose.click();
			
			moveFolio.FirstOpenedReservation.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait3Second();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));

			moveFolio.MoveFolio_Folio.click();
			
			// Waiting for visibility of guest folio
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
			Wait.wait2Second();

			if(driver.findElements(By.xpath("//table[@class='table table-striped table-bordered table-hover trHeight25']/tbody/tr/td/input")).size()>1){

				test.log(LogStatus.PASS, "Successfully moved the folio Item");
				
			}


		}catch(Exception e){
			e.printStackTrace();
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
		try{
			resSearch.basicSearch_WithResNumber(driver,resNumber1);
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
			//System.out.println("System opened reservation number "+resNumber1);
			folioLogger.info("System opened reservation number "+resNumber1);

		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "System fail to open reservation number");
			folioLogger.info("System fail to open reservation number"+resNumber1);
		}


		// waiting for the vivibility of guest info
		try{

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));

			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait3Second();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));

			moveFolio.MoveFolio_Folio.click();
			//System.out.println("clicked on Folio Tab");

			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
			folioLogger.info("Clicked on Folio Tab");
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(e);
			test.log(LogStatus.FAIL, "Folio Tab not opened");
			folioLogger.info("Folio Tab not opened");
		}

		// click on Folio Tab
		try{

			moveFolio.MoveFolio_NewFolio.click();
			//System.out.println("clicked on New Folio IMG");
			// Waiting for visibility of new Folio Details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
			test.log(LogStatus.PASS, "Successfully New Folio Details pop up");
			folioLogger.info("Successfully New Folio Details pop up");
		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
			folioLogger.info("New Folio Details pop up not opened");
		}


		// new Folio creation
		try{

			Assert.assertTrue("Fail to find new folio name",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Name));

			moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
			test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);
			folioLogger.info("Successfully Entered the New Folio Name : "+newFolioName);
			
			//System.out.println("Enter thye new folio name");

			Assert.assertTrue("Fail to find new folio description",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Description));

			moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);

			//System.out.println("Enter thye new folio description");

			test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);
			folioLogger.info("Successfully Entered the New Folio Description : "+newFolioDescription);
			
			Assert.assertTrue("Fail to find new folio close",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Close));
			Assert.assertTrue("Fail to find new folio save",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Save));

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

		}catch(Exception e){
			
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
			folioLogger.info("New Folio Details pop up not opened");
		}

		// select new folio
		try{
			//Thread.sleep(8000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
			Wait.wait3Second();
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			folioLogger.info("Successfully opened the new Folio : "+newFolioName);
			Wait.wait3Second();
		}catch(Exception e){
			//System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName);
			folioLogger.info("Fail to open New Folio : "+newFolioName);
		}


		try{
			Wait.wait5Second();
			moveFolio.Edit_Folio_Btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
			moveFolio.MoveFolio_NewFolio_Name.clear();
			moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName+"test");
			test.log(LogStatus.PASS, "Successfully edited the New Folio Name : "+newFolioName+"test");
			folioLogger.info("Successfully edited the New Folio Name : "+newFolioName+"test");
			
			
			//System.out.println("edit the new folio name");

			Assert.assertTrue("Fail to find new folio description",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Description));
			moveFolio.MoveFolio_NewFolio_Description.clear();
			moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription+"test");

			//System.out.println("edit the new folio description");

			test.log(LogStatus.PASS, "Successfully edited the New Folio Description : "+newFolioDescription+"test");
			folioLogger.info("Successfully edited the New Folio Description : "+newFolioDescription+"test");
			Assert.assertTrue("Fail to find new folio save",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Save));
			
			
			
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
			//System.out.println("clicked on save reservation");


		}catch(Exception e){
			e.printStackTrace();
		}


		// select new folio
		try{
			//Thread.sleep(8000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
			Wait.wait3Second();
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName+"test");
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName+"test");
			folioLogger.info("Successfully opened the new Folio : "+newFolioName+"test");
			//System.out.println("selected the new folio from folio drop down");
			sel.selectByIndex(0);
			Wait.wait3Second();
			sel.selectByVisibleText(newFolioName+"test");
			Wait.wait3Second();
		}catch(Exception e){
		//	System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName+"test");
			folioLogger.info("Fail to open New Folio : "+newFolioName+"test");
		}


		try{
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.Delete_Folio_Btn)));
			moveFolio.Delete_Folio_Btn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
			//test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");			

			moveFolio.MoveFolio_NewFolio_SaveReservation.click();
			test.log(LogStatus.PASS, "Successfully clicked save Reservation");
			folioLogger.info("Successfully clicked save Reservation");
			//System.out.println("clicked on save reservation");
			Wait.wait10Second();
			if(!(driver.findElements(By.xpath("//select[@class='form-control folioFil']/option")).size()>1)){
				test.log(LogStatus.PASS, "Sucessfully deleted the folio : "+newFolioName+"test");
				folioLogger.info("Sucessfully deleted the folio : "+newFolioName+"test");
			}

		}catch(Exception e){
			e.printStackTrace();
		}






	}



}
