package com.innroad.inncenter.interfaces;

import org.openqa.selenium.WebDriver;

public interface IRateDerived {
	
	void inventory_Rate(WebDriver driver) throws InterruptedException;
	
	void new_RateDerived(WebDriver driver, String ratename, String offsetamount, String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException;

	void delete_rate(WebDriver driver) throws InterruptedException;
	
}
