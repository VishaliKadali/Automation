package com.innroad.inncenter.Interface;

import org.openqa.selenium.WebDriver;

public interface IReservationFolio {
	
	void paymentMethod(WebDriver driver, String PaymentType, String CardName, String CCNumber, String CCExpiry, String CCVCode, String Authorizationtype, String ChangeAmount, String ChangeAmountValue, String traceData) throws InterruptedException;
    void Paytype_CP_Account(WebDriver driver, String ChangeAmount, String ChangeAmountValue)throws InterruptedException;
}
