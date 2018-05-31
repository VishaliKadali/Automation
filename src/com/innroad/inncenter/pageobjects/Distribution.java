package com.innroad.inncenter.pageobjects;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IDistribution;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Distribution;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Distribution {

	public static Logger distributionLogger = Logger.getLogger("Distribution");

	
	public void ClickDistributionLink(WebDriver driver, ExtentTest test, String Client1) throws InterruptedException {

		Elements_Distribution elements_Distribution = new Elements_Distribution(driver);
		elements_Distribution.DistributionLink.click();
		test.log(LogStatus.PASS, "Navigate to Distribution");
		distributionLogger.info("Navigate to Distribution");
		Wait.wait2Second();
		new Select(elements_Distribution.Select_Client).selectByVisibleText(Client1);
		Wait.wait2Second();
	}
	
	public void BlackOutRoom(WebDriver driver, ExtentTest test, boolean condition, String Client1
			, String Client2)
			throws InterruptedException {
		Elements_Distribution elements_Distribution = new Elements_Distribution(driver);
		elements_Distribution.DistributionLink.click();
		test.log(LogStatus.PASS, "Navigate to Distribution");
		distributionLogger.info("Navigate to Distribution");
		Wait.wait2Second();
		if (condition) {
			new Select(elements_Distribution.Select_Client).selectByVisibleText(Client1);
			Wait.wait2Second();
		}
		
		WebElement current_state = null;
		if (condition) {
			elements_Distribution.BlackoutsLink.click();
			elements_Distribution.BlackOutRoomCheckBox.get(6).click();
			elements_Distribution.BlackOutRoom_Save_Button.click();
			current_state = elements_Distribution.BlackOutRoomCheckBox.get(6);
		}
		else{
			elements_Distribution.BlackoutsLink1.click();
			Wait.wait2Second();
			elements_Distribution.BlackOutRoomCheckBox.get(9).click();
			elements_Distribution.BlackOutRoom_Save_Button1.get(5).click();
			Wait.wait2Second();
			current_state = elements_Distribution.BlackOutRoomCheckBox.get(9);
		}
		
		boolean isRoomChecked = false;
		if (current_state.isSelected()) {

			isRoomChecked = true;
		}
		assertEquals(isRoomChecked, condition, "Balck room checkbox does not checked");
	}

}
