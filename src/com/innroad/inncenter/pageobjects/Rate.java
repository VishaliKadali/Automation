package com.innroad.inncenter.pageobjects;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.innroad.inncenter.interfaces.IRate;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_GuestHistory;
import com.innroad.inncenter.webelements.Elements_Inventory;



public class Rate implements IRate{
	
	public static Logger rateLogger = Logger.getLogger("Rate");
	
	public void inventory_Rate(WebDriver driver) throws InterruptedException{
		
		
		Elements_Inventory rate= new Elements_Inventory(driver);
		Wait.wait3Second();
		rate.click_Inventory.click();
		rate.inventory_rate.click();
		Wait.wait10Second();
		rateLogger.info(" System successfully Navigated to Inventory Rates ");
		//Wait.wait10Second();
	}
	
	public void new_Rate(WebDriver driver, String ratename,String maxAdults, String maxPersons, String baseAmount, String additionalAdult, String additionalChild, String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Elements_Inventory rate= new Elements_Inventory(driver);
		Wait.explicit_wait_xpath(OR.newRate);
		rate.newRate.click();
		Wait.explicit_wait_xpath(OR.rateName);
		rate.rateName.sendKeys(ratename);
		String ratepan=new Select(rate.ratePlan).getFirstSelectedOption().getText();
		rateLogger.info( "Selected Rate Plan : " +ratepan);
		String rateType=rate.getRateType.getText();
		rateLogger.info(" Selected Rate Type : "  +rateType);
		rate.maxAdults.sendKeys(maxAdults);
		rate.maxPersons.sendKeys(maxPersons);
		rate.baseAmount.sendKeys(baseAmount);
		Wait.explicit_wait_xpath(OR.additionalAdult);
		rate.additionalAdult.sendKeys(additionalAdult);
		Wait.explicit_wait_xpath(OR.additionalChild);
		rate.additionalChild.sendKeys(additionalChild);
		Wait.explicit_wait_xpath(OR.rate_displayName);
		rate.rate_displayName.sendKeys(rateDisplayName);
		Wait.explicit_wait_xpath(OR.rate_policy);
		rate.rate_policy.sendKeys(ratePolicy);
		Wait.explicit_wait_xpath(OR.rate_description);
		rate.rate_description.sendKeys(rateDescription);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
//       String parentWindow=driver.getWindowHandle();
		rate.rate_Associate_Seasons.click();
		Wait.wait2Second();
		
	/*	Set<String> allWindowHandles = driver.getWindowHandles();
		rateLogger.info(allWindowHandles.size());
		
		for (String winHandle  : allWindowHandles) {
			if (!winHandle.equals(parentWindow)) {
				driver.switchTo().window(winHandle);
				
			}
			driver.switchTo().window(parentWindow);
		}*/
		
		driver.switchTo().frame("dialog-body0");
		driver.switchTo().frame("frmWaitHost");
		rateLogger.info(" Switched to Frame ");
	
		rate.click_All_Seasons.click();
		//Wait.wait5Second();
		//Wait.explicit_wait_xpath(OR.doneButton);
		rate.doneButton.click();
		Wait.wait5Second();
		driver.switchTo().defaultContent();
		
		
		jse.executeScript("window.scrollBy(0,1000)"); 
		Wait.explicit_wait_xpath(OR.rate_Associate_RoomClasses);
		rate.rate_Associate_RoomClasses.click();
		Thread.sleep(5000);
		driver.switchTo().frame("dialog-body0");
		driver.switchTo().frame("frmWaitHost");
		rateLogger.info(" Switched to Frame ");
		Wait.wait15Second();
		rate.click_All_RoomClasses.click();
		Wait.explicit_wait_xpath(OR.doneButton);
		rate.doneButton.click();
		Wait.wait5Second();
		driver.switchTo().defaultContent();
		Wait.wait15Second();
		/*JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/
		
		jse.executeScript("window.scrollBy(0,1500)"); 
		/*WebElement availableCell2=rate.rate_Associate_Sources;
		jse.executeScript("arguments[0].scrollIntoView(true);", availableCell2);
		jse.executeScript("arguments[0].click();", availableCell2);*/
        Wait.wait5Second();
		Wait.explicit_wait_xpath(OR.rate_Associate_Sources);
		rate.rate_Associate_Sources.click();
		Wait.wait5Second();
		driver.switchTo().frame("dialog-body0");
		driver.switchTo().frame("frmWaitHost");
		rateLogger.info(" Switched to Frame ");
		Wait.wait15Second();
		rate.rate_select_Source.click();
		Wait.explicit_wait_xpath(OR.doneButton);
		rate.doneButton.click();
		Wait.wait5Second();
		driver.switchTo().defaultContent();
		Wait.wait15Second();
		//jse.executeScript("window.scrollBy(0,1000)");
		Wait.explicit_wait_xpath(OR.rate_Save_Button);
		rate.rate_Save_Button.click();
		Wait.wait5Second();
		rate.rate_done_button.click();
		Wait.wait10Second();
		rateLogger.info(" Clicked on Done Button ");
		Wait.wait10Second();
	}

	
	public void delete_rate(WebDriver driver) throws InterruptedException
	
	{
		Elements_Inventory rate= new Elements_Inventory(driver);
		//Wait.wait5Second();
		//rate.click_Inventory.click();
		//rate.inventory_rate.click();
		//Wait.wait10Second();
		rate.click_goButton.click();
		Wait.wait5Second();
		rate.selectBaseRate.click();
		Wait.wait10Second();
		rate.deleteRate.click();
		Wait.wait10Second();
		rateLogger.info(" System sucessfully deleted the Rate ");
		Wait.wait10Second();
		
	}
	
	
}
