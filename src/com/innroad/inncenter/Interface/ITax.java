package com.innroad.inncenter.Interface;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public interface ITax {
	
	void createTax(WebDriver driver, ExtentTest test, String taxName, String displayName, String description, String value, String category,String taxLedgerAccount) throws InterruptedException;

}
