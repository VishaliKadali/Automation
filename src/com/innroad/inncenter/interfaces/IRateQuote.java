package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

public interface IRateQuote {
	
	void searchDetails(WebDriver driver, String RateQuoteNights, String RateQuoteAdults, String RateQuoteChildren, String RateQuoteRatePlanList, String RateQuotePromoCode);
	void clearRateQuoteDetails(WebDriver driver);
	void SearchRateQuoteDetails(WebDriver driver);
	void clickBookicon(WebDriver driver)throws InterruptedException;

}
