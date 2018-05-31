package com.innroad.inncenter.pageobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservationSearchPage;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReservationSearch implements IReservationSearchPage {

	public String ResNumber;
	public static Logger resSearchLogger = Logger.getLogger("ReservationSearch");

	public void basicSearch_WithGuestName(WebDriver driver, String GuestName) throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.BasicGuestName.sendKeys(GuestName);
		resSearchLogger.info("Entered the reservation number for basic search");
		resservationSearch.Click_BasicSearch.click();
		resSearchLogger.info("Clicked on Search Button");
		Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
		Wait.wait10Second();
		String GetGuestName = resservationSearch.Get_Guest_Name.getAttribute("title");
		Assert.assertEquals(GuestName, GetGuestName);

	}

	public void basicSearch_WithResNumber(WebDriver driver) throws InterruptedException {

		try {
			FileReader fr = new FileReader(".\\ConfirmationNumber.txt");
			BufferedReader br = new BufferedReader(fr);

			while ((ResNumber = br.readLine()) != null) {
				//resSearchLogger.info("ResNumber :" + ResNumber);
				Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
				resSearchLogger.info("ResNumber after loop:" + ResNumber);
				resservationSearch.Basic_Res_Number.sendKeys(ResNumber);
				resservationSearch.Click_BasicSearch.click();
				Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
				Wait.wait10Second();
				String GetResNumber = resservationSearch.Get_Res_Number.getText();
				Assert.assertEquals(ResNumber, GetResNumber);
			}
			br.close();
		} catch (IOException e) {
			//System.out.println("File not found");
		}

	}

	
	public String basicSearch_WithResNumber(WebDriver driver,String resNumber ) throws InterruptedException {
		String str = null;
		try
		{
		/*FileReader fr= new FileReader(".\\ConfirmationNumber.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while((ResNumber=br.readLine())!=null)
		{*/
			//System.out.println("ResNumber :"+resNumber);
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			
			Wait.wait2Second();
			Wait.WaitForElement(driver, OR.Basic_Res_Number);
			resservationSearch.Basic_Res_Number.clear();
			//Wait.wait2Second();
			
			Wait.WaitForElement(driver, OR.Basic_Res_Number);
			resservationSearch.Basic_Res_Number.sendKeys(resNumber);
			resservationSearch.Click_BasicSearch.click();
			Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
			//Wait.wait10Second();
			
			Wait.WaitForElement(driver, OR.Get_Res_Number);
			String GetResNumber=resservationSearch.Get_Res_Number.getText();
			Wait.wait3Second();
			//Assert.assertEquals(resNumber, GetResNumber);
	//	}
		//br.close();
			
			
			// Explicit wait object creation
			WebDriverWait wait = new WebDriverWait(driver, 90);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.NewRervations)));
			//System.out.println(resNumber);
			
			String resLocator="//span[contains(text(),'"+resNumber.trim()+"')]/../../td[4]/div/a";
			//Wait.wait5Second();
			/*
			Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
			moveFolio.NewRervations.click();*/
			Wait.WaitForElement(driver, resLocator);
			str=driver.findElement(By.xpath(resLocator)).getText();
	
			driver.findElement(By.xpath(resLocator)).click();
		}
		catch(Exception e)
		{
			//System.out.println("File not found");
		}
		
		return str;
	}
	
	
	public void basicSearch_WithResNumber1(WebDriver driver,String resNumber ) throws InterruptedException {
		String str = null;
		try
		{
		/*FileReader fr= new FileReader(".\\ConfirmationNumber.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while((ResNumber=br.readLine())!=null)
		{
			System.out.println("ResNumber :"+resNumber);
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			System.out.println("ResNumber after loop:" + resNumber);
			resservationSearch.Basic_Res_Number.sendKeys(resNumber);
			resservationSearch.Click_BasicSearch.click();
			Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
			Wait.wait10Second();
			String GetResNumber=resservationSearch.Get_Res_Number.getText();
			Assert.assertEquals(resNumber, GetResNumber);
		}
		br.close();*/
			
			
			// Explicit wait object creation
			WebDriverWait wait = new WebDriverWait(driver, 90);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.NewRervations)));
			
			
			String resLocator="//span[contains(text(),'"+resNumber.trim()+"')]/../../td[4]/div/a";
			//Thread.sleep(5000);
			
			/*Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
			moveFolio.NewRervations.click();*/
			
			str=driver.findElement(By.xpath(resLocator)).getText();
			
			driver.findElement(By.xpath(resLocator)).click();
		}
		catch(Exception e)
		{
			//System.out.println("File not found");
		}
		
		
	}
	
	
	public void Bulkcheckin(WebDriver driver, String GuestName) throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.Check_Reservation.click();
		resSearchLogger.info("Reseravation is selected");
		resservationSearch.Click_Bulk_Action.click();
		resSearchLogger.info("Clicked on bulk action");
		resservationSearch.Select_Checkin.click();
		resSearchLogger.info("Clicked on bulk action - CHECKIN option");
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkin_popup);
		String GetGuestName = resservationSearch.Verify_Guest_Name.getAttribute("title");
		resSearchLogger.info("GuestName  :" + GuestName);
		if (GetGuestName.equals(GuestName)) {
			resSearchLogger.info("Verified Guest Name");
		} else {
			resSearchLogger.info("Failed to verify Guest Name");
		}
		Wait.wait5Second();
		resservationSearch.Click_Process_Button.click();
		resSearchLogger.info("Clicked on Process button");
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checin_Completed);
		Wait.wait5Second();
		resservationSearch.click_on_Close_icon.click();
		resSearchLogger.info("Clicked on Close button");
		Wait.wait5Second();
		if (resservationSearch.Get_Reservation_Status.getText().equals("In-House")) {
			resSearchLogger.info("In House Success");
		} else {
			resSearchLogger.info("Fail to checkin");
		}

	}

	public void Bulkcheckout(WebDriver driver, String GuestName) throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.Check_Reservation.click();
		resSearchLogger.info("Reseravation is selected");
		resservationSearch.Click_Bulk_Action.click();
		resSearchLogger.info("Clicked on bulk action");
		resservationSearch.Select_Checkout.click();
		resSearchLogger.info("Clicked on bulk action - CHECKOUT option");
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkout_popup);
		String GetGuestName = resservationSearch.Verify_Guest_Name.getAttribute("title");
		resSearchLogger.info("GuestName  :" + GuestName);
		if (GetGuestName.equals(GuestName)) {
			resSearchLogger.info("Verified Guest Name");
		} else {
			resSearchLogger.info("Fail to verify Guest Name");
		}
		Wait.wait5Second();
		resservationSearch.Click_Process_Button.click();
		resSearchLogger.info("Clicked on Process button");
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkout_Completed);
		Wait.wait5Second();
		resservationSearch.click_on_Close_icon.click();
		resSearchLogger.info("Clicked on Close button");
		Wait.wait5Second();
		if (resservationSearch.Get_Reservation_Status.getText().equals("Departed")) {
			resSearchLogger.info("Departed Success");
		} else {
			resSearchLogger.info("Failed to checkout");
		}

	}
	
	
	public void delete_Res_WithResNumber(WebDriver driver,String Res_Confirm_Number ) throws InterruptedException {
		
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.Check_Reservation.click();
		resservationSearch.Click_Bulk_Action.click();
		Utility.ScrollToElement(resservationSearch.Select_Delete);
		resservationSearch.Select_Delete.click();		
		Wait.explicit_wait_visibilityof_webelement(resservationSearch.Verify_Bulk_Delete_popup);
		String GetResNumber=resservationSearch.Verify_Res_Number.getText();
		resSearchLogger.info("GetResNumber  :" + GetResNumber);
		if(GetResNumber.equals(Res_Confirm_Number))
		{
			resSearchLogger.info("Verified GetResNumber in popup");
		}
		else
		{
			resSearchLogger.info("Fail to verify GetResNumber in popup");
		}
		Wait.explicit_wait_visibilityof_webelement(resservationSearch.Click_Process_Button);
		resservationSearch.Click_Process_Button.click();
		
		Wait.explicit_wait_visibilityof_webelement(resservationSearch.Verify_Bulk_Delete_Completed);
	    resservationSearch.click_on_Close_icon.click();
		Wait.wait3Second();
		
//		Clear basic search and search for the deleted reservation
		resservationSearch.Basic_Res_Number.clear();
		resservationSearch.Basic_Res_Number.sendKeys(Res_Confirm_Number);
		resservationSearch.Click_BasicSearch.click();		
		Wait.wait2Second();
		Assert.assertEquals(resservationSearch.Search_Results_Alert_Msg.getText(), "No records meet your criteria. Please change your criteria and search again.");
		
	}
	
	
	public void uncheck_TaxExempt(WebDriver driver,ExtentTest test) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		Wait.wait2Second();
		// Java script object creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		if(ReservationPage.Check_IsTaxExempt.isSelected()){
			
			Wait.WaitForElement(driver, OR.Check_IsTaxExempt);
			ReservationPage.Check_IsTaxExempt.click();
			test.log(LogStatus.PASS, "Tax exempt check box un selected");
			resSearchLogger.info("Tax exempt check box un selected");
		}
	}

	
	public void addIncidentals(WebDriver driver,ExtentTest test,String category,String amount) throws InterruptedException{
		//Wait.wait5Second();
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		
		Wait.WaitForElement(driver, OR.AddIncidental);
		resservationSearch.AddIncidental.click();
		test.log(LogStatus.PASS, "Click Add");
		resSearchLogger.info("Click Add");
		
		Select sel = new Select(resservationSearch.IncidentalCategory);
		sel.selectByVisibleText(category);
		test.log(LogStatus.PASS, "Select the category : "+category);
		resSearchLogger.info("elect the category : "+category);
		
		resservationSearch.IncidentalAmount.sendKeys(amount);
		test.log(LogStatus.PASS, "Enter the amount : "+amount);
		resSearchLogger.info("Enter the amount : "+amount);
		
		resservationSearch.Commit.click();
		test.log(LogStatus.PASS, "Click commit");
		resSearchLogger.info("Click commit");
		
		Wait.wait5Second();
		String str=driver.findElement(By.xpath("//td/span[contains(text(),'"+category+"')]/../following-sibling::td/following-sibling::td/following-sibling::td/span")).getText();
		str=str.replace("$", "");
		Double d=Double.parseDouble(str);
		if(d==0){
			test.log(LogStatus.PASS, "Tax value is zero");
			resSearchLogger.info("Tax value is zero : "+d);
		}else{
			test.log(LogStatus.FAIL, "Tax value is not zero");	
			resSearchLogger.info("Tax value is not zero : "+d);
		}
	}
/*	
	public void preDefinedQueriesTab(WebDriver driver) throws InterruptedException{
		
		Elements_Reservation_SearchPage res=new Elements_Reservation_SearchPage(driver);
		res.inHouseReservations.click();
		
		//new Select(res.selectAllArrivals).selectByIndex(1);
		Wait.wait10Second();
		
	}

	public void bulkCancelOfReservation(WebDriver driver) throws InterruptedException{
		Elements_Reservation_SearchPage res=new Elements_Reservation_SearchPage(driver);
		res.selectAllRecords.click();
		new Select(res.selectCancelFromBulkAction).selectByIndex(3);
		Wait.wait10Second();
		
	}
*/	

}
