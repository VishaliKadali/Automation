package com.innroad.inncenter.Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innroad.inncenter.Interface.IFolio;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_MovieFolio;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Folio implements IFolio{

	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescription){
		
		
		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);
		
		Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
		
		// Search Reservation
		try{
			ReservationSearch resSearch	= new ReservationSearch();
			resSearch.basicSearch_WithResNumber(driver,resNumber1);
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber1);
			System.out.println("System opened reservation number "+resNumber1);
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}
		
		
		// waiting for the vivibility of guest info
		try{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
			
			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Thread.sleep(6000);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));
			
			moveFolio.MoveFolio_Folio.click();
			System.out.println("clicked on Folio Tab");
			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			test.log(LogStatus.FAIL, "Folio Tab not opened");
		}
		
		// click on Folio Tab
		try{
			
			moveFolio.MoveFolio_NewFolio.click();
			System.out.println("clicked on New Folio IMG");
			// Waiting for visibility of new Folio Details
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolioDeatils)));
			test.log(LogStatus.PASS, "Successfully New Folio Details pop up ");
			
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
		}
		
		
		// new Folio creation
		try{
			
			Assert.assertTrue("Fail to find new folio name",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Name));
			
			moveFolio.MoveFolio_NewFolio_Name.sendKeys(newFolioName);
			test.log(LogStatus.PASS, "Successfully Entered the New Folio Name : "+newFolioName);
			
			System.out.println("Enter thye new folio name");
			
			Assert.assertTrue("Fail to find new folio description",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Description));
			
			moveFolio.MoveFolio_NewFolio_Description.sendKeys(newFolioDescription);
			
			System.out.println("Enter thye new folio description");
			
			test.log(LogStatus.PASS, "Successfully Entered the New Folio Description : "+newFolioDescription);
			
			Assert.assertTrue("Fail to find new folio close",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Close));
			Assert.assertTrue("Fail to find new folio save",Utility.return_element_status_after_explicit_wait(OR.MoveFolio_NewFolio_Save));
			
			moveFolio.MoveFolio_NewFolio_Save.click();
			test.log(LogStatus.PASS, "Successfully clicked save Folio");
			System.out.println("clicked on save folio");
			Wait.wait3Second();
			// Waiting for visibility of adjoining rooms
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_NewFolio_SaveReservation)));
			//test.log(LogStatus.FAIL, "Successfully New Folio Details pop up ");			
			
			moveFolio.MoveFolio_NewFolio_SaveReservation.click();
			test.log(LogStatus.PASS, "Successfully clicked save Reservation");
			System.out.println("clicked on save reservation");
			
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "New Folio Details pop up not opened");
		}
		
		// select new folio
		try{
			//Thread.sleep(8000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div")));
			Wait.wait3Second();
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			System.out.println("selected the new folio from folio drop down");
			sel.selectByIndex(0);
			Wait.wait3Second();
			sel.selectByVisibleText(newFolioName);
			Wait.wait3Second();
			sel.selectByIndex(0);
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName);
		}
		
		// select the folio item to move
		try{
			Wait.wait3Second();
			moveFolio.MoveFolio_SelectFiloItem.click();
			test.log(LogStatus.PASS, "Successfully selected the folio Item");
			System.out.println("clicked on folio item to move");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to select the Fail item");
		}
		
		//Click on move
		try{
			Wait.wait3Second();
			moveFolio.MoveFolio_Move.click();
			test.log(LogStatus.PASS, "Successfully clieked on move");
			System.out.println("clicked on move");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on move");
		}
		
		
		// Folio items to move to target folio pop up
		try{
			//Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
			Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			System.out.println("selected the target folio from the folio move pop up");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+newFolioName);
		}
		
		//move folio items to target folio pop up
		try{
			moveFolio.MoveFolio_FolioItemToMove.click();
			test.log(LogStatus.PASS, "Successfully clieked on folio item");
			System.out.println("selected the folio item");
			moveFolio.MoveFolio_MoveSelectedItem.click();
			test.log(LogStatus.PASS, "Successfully moved folio item");
			System.out.println("clicked on move button");
			moveFolio.MoveFolio_Close.click();
			test.log(LogStatus.PASS, "Successfully clicked on close");
			System.out.println("click on close button");
			Wait.wait3Second();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));
			System.out.println("waiting for success message");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on folio item");
		}
		
		//validation folio items
		try{
			Select sel = new Select(moveFolio.MoveFolio_GuestFolio);
			sel.selectByVisibleText(newFolioName);
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+newFolioName);
			if(driver.findElements(By.xpath(OR.MoveFolio_SelectFiloItem)).size()>0){
				test.log(LogStatus.PASS, "Successfully moved the folio Item to : "+newFolioName);
				System.out.println("Completed");
			}
			
		}catch(Exception e){
			System.out.println(e);
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
			System.out.println("System opened reservation number "+resNumber1);
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}
		
		// Search and open Reservation2
		try{
			moveFolio.Reservations.click();
			Wait.wait5Second();
			ReservationSearch resSearch	= new ReservationSearch();
			resSearch.basicSearch_WithResNumber1(driver,resNumber2);
			System.out.println("System opened reservation number "+resNumber2);
			test.log(LogStatus.PASS, "System opened reservation number "+resNumber2);
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "System fail to open reservation number");
		}
		
		
		//opening the first reservation tab
		try{
			moveFolio.FirstOpenedReservation.click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
			
			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait5Second();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));
			
			moveFolio.MoveFolio_Folio.click();
			System.out.println("click on Folio");
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
			Wait.wait5Second();
			moveFolio.MoveFolio_SelectFiloItem.click();
			test.log(LogStatus.PASS, "Successfully selected the folio Item");
			System.out.println("select the folio item");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to select the Fail item");
		}
		
		// click on move
		try{
			Wait.wait5Second();
			moveFolio.MoveFolio_Move.click();
			test.log(LogStatus.PASS, "Successfully clieked on move");
			System.out.println("click on move");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on move");
		}
		
		// Select the guest folio of another reservation
		try{
			//Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_TargetFolio)));
			Select sel = new Select(moveFolio.MoveFolio_TargetFolio);
			sel.selectByVisibleText("Guest Folio");
			test.log(LogStatus.PASS, "Successfully opened the new Folio : "+"Guest Folio");
			System.out.println("select the guest folio of another reservation");
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Fail to open New Folio : "+"Guest Folio");
		}
		
		// move Folio item to another reservation folio
		try{
			moveFolio.MoveFolio_FolioItemToMove.click();
			test.log(LogStatus.PASS, "Successfully clieked on folio item");
			System.out.println("select the folio item to move");
			moveFolio.MoveFolio_MoveSelectedItem.click();
			test.log(LogStatus.PASS, "Successfully moved folio item");
			System.out.println("click on move");
			moveFolio.MoveFolio_Close.click();
			test.log(LogStatus.PASS, "Successfully clicked on close");
			System.out.println("click on close");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='toast-container']/div/div[2]")));
		}catch(Exception e){
			System.out.println(e);
			test.log(LogStatus.FAIL, "Unable to click on folio item");
		}
		
		// closing first reservation and validation second reservation folio
		try{
			moveFolio.FirstOpenedReservationClose.click();
			System.out.println("close reservation1");
			moveFolio.FirstOpenedReservation.click();
			System.out.println("open the reservation");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.GuestInfo)));
			
			wait.until(ExpectedConditions.elementToBeClickable(moveFolio.GuestInfo));
			Wait.wait5Second();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.GuestInfo)));
			
			moveFolio.MoveFolio_Folio.click();
			System.out.println("open the folio tab");
			// Waiting for visibility of guest folio
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.MoveFolio_GuestFolio)));
			test.log(LogStatus.PASS, "Successfully opened the Folio Tab");
			Wait.wait5Second();
			
			if(driver.findElements(By.xpath("//table[@class='table table-striped table-bordered table-hover trHeight25']/tbody/tr/td/input")).size()>1){
				
					test.log(LogStatus.PASS, "Successfully moved the folio Item");
					System.out.println("validated the folio items");
				}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
