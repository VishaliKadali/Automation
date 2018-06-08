package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

public interface IReservationSearchPage {
	
	void basicSearch_WithGuestName(WebDriver driver, String GuestName)throws InterruptedException;
	
	void basicSearch_WithResNumber(WebDriver driver)throws InterruptedException;
	
    void Bulkcheckin(WebDriver driver, String GuestName)throws InterruptedException;
    void Bulkcheckout(WebDriver driver, String GuestName)throws InterruptedException;
    
    void bulkCancellation(WebDriver driver) throws InterruptedException;
    
}
