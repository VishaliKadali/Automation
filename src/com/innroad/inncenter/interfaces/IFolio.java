package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public interface IFolio {
	
	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescription);
	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String resNumber2);

}
