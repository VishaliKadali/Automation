package com.innroad.inncenter.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.innroad.inncenter.interfaces.ISupportPanel_ClientSelection;
import com.innroad.inncenter.webelements.WebElements_Support_Panel_Client_Selection;

public class SupportPanle_ClientSelection implements com.innroad.inncenter.interfaces.ISupportPanel_ClientSelection{

	@Override
	public void Client_Selection(WebDriver driver, String ClientName) throws InterruptedException {
		
		
		WebElements_Support_Panel_Client_Selection ClientSelection = new WebElements_Support_Panel_Client_Selection(driver);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().frame("main");
		Thread.sleep(5000);
		ClientSelection.ClickArrow.click();
		Thread.sleep(9000);
		ClientSelection.clientTextBox.click();
		ClientSelection.clientTextBox.sendKeys(ClientName);
		ClientSelection.clientTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
	}

}
