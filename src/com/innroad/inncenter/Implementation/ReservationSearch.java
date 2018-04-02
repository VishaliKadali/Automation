package com.innroad.inncenter.Implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.innroad.inncenter.Interface.IReservationSearchPage;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_MovieFolio;
import com.innroad.inncenter.WebElements.Elements_Reservation;
import com.innroad.inncenter.WebElements.Elements_Reservation_SearchPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ReservationSearch implements IReservationSearchPage {
	
	public String ResNumber;

	
	public void basicSearch_WithGuestName(WebDriver driver, String GuestName) throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.BasicGuestName.sendKeys(GuestName);
		resservationSearch.Click_BasicSearch.click();
		Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
		Wait.wait10Second();
		String GetGuestName=resservationSearch.Get_Guest_Name.getAttribute("title");
		Assert.assertEquals(GuestName, GetGuestName);
		
	}

	
	public void basicSearch_WithResNumber(WebDriver driver ) throws InterruptedException {
		
		try
		{
		FileReader fr= new FileReader(".\\ConfirmationNumber.txt");
		BufferedReader br = new BufferedReader(fr);
		
		while((ResNumber=br.readLine())!=null)
		{
			System.out.println("ResNumber :"+ResNumber);
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			System.out.println("ResNumber after loop:" + ResNumber);
			resservationSearch.Basic_Res_Number.sendKeys(ResNumber);
			resservationSearch.Click_BasicSearch.click();
			Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
			Wait.wait10Second();
			String GetResNumber=resservationSearch.Get_Res_Number.getText();
			Assert.assertEquals(ResNumber, GetResNumber);
		}
		br.close();
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}
		
		
	}
	
	
	
	public void addIncidentals(WebDriver driver,ExtentTest test,String category,String amount) throws InterruptedException{
		Wait.wait5Second();
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.AddIncidental.click();
		test.log(LogStatus.PASS, "click Add");
		Select sel = new Select(resservationSearch.IncidentalCategory);
		sel.selectByVisibleText(category);
		test.log(LogStatus.PASS, "select the category : "+category);
		resservationSearch.IncidentalAmount.sendKeys(amount);
		test.log(LogStatus.PASS, "Enter the amount : "+amount);
		resservationSearch.Commit.click();
		test.log(LogStatus.PASS, "click commit");
		Wait.wait5Second();
		String str=driver.findElement(By.xpath("//td/span[contains(text(),'"+category+"')]/../following-sibling::td/following-sibling::td/following-sibling::td/span")).getText();
		str=str.replace("$", "");
		Double d=Double.parseDouble(str);
		if(d==0){
			test.log(LogStatus.PASS, "Tax value is zero");
		}else{
			test.log(LogStatus.FAIL, "Tax value is not zero");	
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
			System.out.println("ResNumber :"+resNumber);
			Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
			System.out.println("ResNumber after loop:" + resNumber);
			resservationSearch.Basic_Res_Number.sendKeys(resNumber);
			resservationSearch.Click_BasicSearch.click();
			Wait.explicit_wait_xpath(OR.Verify_Search_Loading_Gird);
			Wait.wait10Second();
			String GetResNumber=resservationSearch.Get_Res_Number.getText();
			Assert.assertEquals(resNumber, GetResNumber);
	//	}
		//br.close();
			
			
			// Explicit wait object creation
			WebDriverWait wait = new WebDriverWait(driver, 90);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.NewRervations)));
			System.out.println(resNumber);
			
			String resLocator="//span[contains(text(),'"+resNumber.trim()+"')]/../../td[4]/div/a";
			Wait.wait5Second();
			/*
			Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
			moveFolio.NewRervations.click();*/
			
			str=driver.findElement(By.xpath(resLocator)).getText();
	
			driver.findElement(By.xpath(resLocator)).click();
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
		
		return str;
	}

	
	
	public void uncheck_TaxExempt(WebDriver driver,ExtentTest test) throws InterruptedException{
		Elements_Reservation ReservationPage = new Elements_Reservation(driver);

		Wait.wait5Second();
		// Java script object creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		if(ReservationPage.Check_IsTaxExempt.isSelected()){
			ReservationPage.Check_IsTaxExempt.click();
			test.log(LogStatus.PASS, "Tax exempt check box un selected");
		}
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
			System.out.println(resNumber);
			
			String resLocator="//span[contains(text(),'"+resNumber.trim()+"')]/../../td[4]/div/a";
			//Thread.sleep(5000);
			
			/*Elements_MovieFolio moveFolio = new Elements_MovieFolio(driver);
			moveFolio.NewRervations.click();*/
			
			str=driver.findElement(By.xpath(resLocator)).getText();
			
			driver.findElement(By.xpath(resLocator)).click();
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
		
		
	}


	public void Bulkcheckin(WebDriver driver, String GuestName) throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.Check_Reservation.click();
		resservationSearch.Click_Bulk_Action.click();
		resservationSearch.Select_Checkin.click();
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkin_popup);
		String GetGuestName=resservationSearch.Verify_Guest_Name.getAttribute("title");
		System.out.println("GuestName  :" + GuestName);
		if(GetGuestName.equals(GuestName))
		{
			System.out.println("Verified Guest Name");
		}
		else
		{
			System.out.println("Fail to verify Guest Name");
		}
		Wait.wait5Second();
		resservationSearch.Click_Process_Button.click();
		
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checin_Completed);
		Wait.wait5Second();
		resservationSearch.click_on_Close_icon.click();
		Wait.wait5Second();
		if(resservationSearch.Get_Reservation_Status.getText().equals("In-House"))
		{
			System.out.println("In House Success");
		}
		else
		{
			System.out.println("Fail to checkin");
		}
		
	}



	public void Bulkcheckout(WebDriver driver, String GuestName)
			throws InterruptedException {
		Elements_Reservation_SearchPage resservationSearch = new Elements_Reservation_SearchPage(driver);
		resservationSearch.Check_Reservation.click();
		resservationSearch.Click_Bulk_Action.click();
		resservationSearch.Select_Checkout.click();
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkout_popup);
		String GetGuestName=resservationSearch.Verify_Guest_Name.getAttribute("title");
		System.out.println("GuestName  :" + GuestName);
		if(GetGuestName.equals(GuestName))
		{
			System.out.println("Verified Guest Name");
		}
		else
		{
			System.out.println("Fail to verify Guest Name");
		}
		Wait.wait5Second();
		resservationSearch.Click_Process_Button.click();
		
		Wait.explicit_wait_xpath(OR.Verify_Bulk_Checkout_Completed);
		Wait.wait5Second();
		resservationSearch.click_on_Close_icon.click();
		Wait.wait5Second();
		if(resservationSearch.Get_Reservation_Status.getText().equals("Departed"))
		{
			System.out.println("Departed Success");
		}
		else
		{
			System.out.println("Fail to checkin");
		}
		
		
	}

	
	
}
