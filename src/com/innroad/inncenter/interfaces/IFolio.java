package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public interface IFolio {
	
	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String newFolioName,String newFolioDescriptio) throws InterruptedException;
	public void MoveFolioInsideReservation(WebDriver driver,ExtentTest test,String resNumber1,String resNumber2,Double d,Double d2) throws Exception;

}
