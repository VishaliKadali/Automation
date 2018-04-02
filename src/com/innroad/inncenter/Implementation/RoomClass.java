package com.innroad.inncenter.Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.innroad.inncenter.Interface.IRoomClass;
import com.innroad.inncenter.Intialize.testCore;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Utils.Utility;
import com.innroad.inncenter.WebElements.Elements_NewRoomClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;



public class RoomClass implements IRoomClass{
	
	

	
	public boolean roomClassInfo(WebDriver driver,String roomClassName,String roomClassAbbrivation,String bedsCount,String maxAdults,String maxPersopns,String roomQuantity,ExtentTest test) throws Exception{

		// Explicit wait object creation
		WebDriverWait wait = new WebDriverWait(driver, 90);
		
		
		// Creating object for Elements_NewRoomClass
		Elements_NewRoomClass roomClass = new Elements_NewRoomClass(driver);
		
		// Enter Room Class Name
		roomClass.NewRoomClassName.sendKeys(roomClassName);
		System.out.println("Entered the room class name : "+roomClassName);
		test.log(LogStatus.PASS, "Entered the room class name : "+roomClassName);
		
		// Enter the new class room abbreviation
		roomClass.NewRoomClassAbbrivation.sendKeys(roomClassAbbrivation);
		System.out.println("Entered the room class abbreviation : "+roomClassAbbrivation);
		test.log(LogStatus.PASS, "Entered the room class abbreviation : "+roomClassAbbrivation);
		
		// Enter the number of king bed count
		roomClass.NewRoomClassKingBeds.sendKeys(bedsCount);
		System.out.println("Entered the king beds count : "+bedsCount);
		test.log(LogStatus.PASS, "Entered the king beds count : "+bedsCount);
		
		// Java script object creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		// Waiting for visibility of adjoining rooms
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_RoomType_AdjoiningRooms)));
		
		// Clicking on adjoining rooms check box
		roomClass.New_RoomClassRoomTypeAdjoiningRooms.click();
		System.out.println("clicked on room type adjoining rooms check box");
		test.log(LogStatus.PASS, "clicked on room type adjoining rooms check box");
		
		// Click on Rooms
		roomClass.NewRoomClassRooms.click();
		System.out.println("Clicked on Rooms Tab");
		test.log(LogStatus.PASS, "Clicked on Rooms Tab");
		
		// Enter the Max Adults
		roomClass.NewRoomClassMaxAdults.sendKeys(maxAdults);
		System.out.println("Entered the max audlts : "+maxAdults);
		test.log(LogStatus.PASS, "Entered the max audlts : "+maxAdults);
		
		// Enter the Max Persons
		roomClass.NewRoomClassMaxPersons.sendKeys(maxPersopns);
		System.out.println("Entered the max persopns : "+maxPersopns);
		test.log(LogStatus.PASS, "Entered the max persopns : "+maxPersopns);
		
		// Enter the Rooms Quantity
		roomClass.NewRoomClassRoomQuantity.sendKeys(roomQuantity);
		System.out.println("Enterd the rooms quantity : "+roomQuantity);
		test.log(LogStatus.PASS, "Enterd the rooms quantity : "+roomQuantity);
		
		// Click create Rooms
		roomClass.NewRoomClassCreateRooms.click();
		System.out.println("clicked on create rooms");
		test.log(LogStatus.PASS, "clicked on create rooms");
		
		// Waiting for visibility of Room Number text box
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_RoomNumber)));
				
		// Clear the Room Number text box
		roomClass.NewRoomClassRoomNumber.clear();
		
		// Enter for  Room Numbers
		roomClass.NewRoomClassRoomNumber.sendKeys("501");
		System.out.println("Entered the room number 501");
		test.log(LogStatus.PASS, "Entered the room number 501");
		
		// Waiting for visibility of Assign Room Number button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_AssignRoomNumber)));
		
		// click on Assign room number
		roomClass.NewRoomClassAssignRoomNumbers.click();
		System.out.println("clicked on assign room numbers");
		test.log(LogStatus.PASS, "clicked on assign room numbers");
		
		// Waiting for visibility of Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_Save)));
		
		// click on  Save
		roomClass.NewRoomClassSave.click();
		System.out.println("clicked on Save");
		test.log(LogStatus.PASS, "clicked on Save");
		
		// Waiting for visibility of publish
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_Publish)));
		wait.until(ExpectedConditions.elementToBeClickable(roomClass.NewRoomClassPublish));
	    
		// Clicking on publish
		roomClass.NewRoomClassPublish.click();
		System.out.println("clicked on Publish");
		test.log(LogStatus.PASS, "clicked on Publish");
		
		// Waiting for visibility of OK
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_OK)));
		
		// Waiting for visibility of publish msg
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClass_Msg_Publish)));
		System.out.println(driver.findElement(By.xpath(OR.New_RoomClass_Msg_Publish)).getText());
		
		// Clicking on OK
		roomClass.NewRoomClassOk.click();
		System.out.println("Clicked on OK");
		test.log(LogStatus.PASS, "clicked on OK");
		
		// Waiting for visibility of New Room classes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.New_RoomClasses)));
		wait.until(ExpectedConditions.elementToBeClickable(roomClass.NewRoomClasses));
		
		// Getting the msg after publish
		String msg=driver.findElement(By.xpath(OR.New_RoomClass_Msg_Publish)).getText();
		
		// Asserting the msf after publish
		Assert.assertTrue(msg.contains("Successfully Created Room Class : "));
		test.log(LogStatus.PASS, "Room Classed Asserted");
		
		// Waiting for invisibility of publish msg
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(OR.New_RoomClass_Msg_Publish)));
		
		// Click on Room Classes
		roomClass.NewRoomClasses.click();
		System.out.println("Room Classes Clicked");
		test.log(LogStatus.PASS, "Room Classes Clicked");
		
		// Parsing the Room class name to get First character to upper case
		char ch=roomClassName.charAt(0);
		String str=""+ch;
		str=str.toUpperCase();
		
		// Waiting for visibility of Search Bar
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']/li/a[contains(text(),'"+str+"')]")));
		driver.findElement(By.xpath("//ul[@class='pagination']/li/a[contains(text(),'"+str+"')]")).click();
		
		// Validating the newly created room class
		if(driver.findElements(By.xpath("//a[contains(text(),'"+roomClassName+"')]")).size()>0){
			System.out.println("newly created class room validated successfully");
			test.log(LogStatus.PASS, "newly created class room validated successfully");
			return true;
		}else{
			System.out.println("new class room not successfully created");
			test.log(LogStatus.FAIL, "new class room not successfully created");
			return false;
		}
	}
	
	
}
