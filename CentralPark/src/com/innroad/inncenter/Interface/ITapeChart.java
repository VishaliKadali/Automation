package com.innroad.inncenter.Interface;

import org.openqa.selenium.WebDriver;

public interface ITapeChart {
	
	void TapeChartSearch(WebDriver driver,String TapeChartAdults, String TapeChartChildrens, String PromoCode)throws InterruptedException;
	void click_availableRoomClass(WebDriver driver)throws InterruptedException;

}
