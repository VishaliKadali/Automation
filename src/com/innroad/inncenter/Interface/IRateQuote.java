package com.innroad.inncenter.Interface;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public interface IRateQuote {
	
	void searchDetails(WebDriver driver,ExtentTest test, String RateQuoteNights, String RateQuoteAdults, String RateQuoteChildren, String RateQuoteRatePlanList, String RateQuotePromoCode);
	void clearRateQuoteDetails(WebDriver driver,ExtentTest test);
	void SearchRateQuoteDetails(WebDriver driver,ExtentTest test);
	void clickBookicon(WebDriver driver,ExtentTest test)throws InterruptedException;

}
