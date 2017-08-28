package com.innroad.inncenter.Implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;





import org.testng.Assert;

import com.innroad.inncenter.Interface.IReservationSearchPage;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Reservation_SearchPage;


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
