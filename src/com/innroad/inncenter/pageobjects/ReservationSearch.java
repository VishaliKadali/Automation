package com.innroad.inncenter.pageobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.innroad.inncenter.interfaces.IReservationSearchPage;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Reservation_SearchPage;

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
				resSearchLogger.info("ResNumber :" + ResNumber);
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
			System.out.println("File not found");
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

}
