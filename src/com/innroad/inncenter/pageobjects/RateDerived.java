package com.innroad.inncenter.pageobjects;

import java.awt.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IRateDerived;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Inventory;



public class RateDerived implements IRateDerived {

	public static Logger derivedRateLogger = Logger.getLogger("RateDerived");
	
public void inventory_Rate(WebDriver driver) throws InterruptedException	{
		
		
		Elements_Inventory rate= new Elements_Inventory(driver);
		Wait.wait3Second();
		rate.click_Inventory.click();
		rate.inventory_rate.click();
		Wait.wait10Second();
		derivedRateLogger.info(" System successfully Navigated to Inventory Rates ");
		//Wait.wait10Second();
	}
	

public void new_RateDerived(WebDriver driver, String ratename, String offsetAmount, String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Elements_Inventory derivedrate= new Elements_Inventory(driver);
	Wait.explicit_wait_xpath(OR.newRate);
	derivedrate.newRate.click();
	Wait.explicit_wait_xpath(OR.rateName);
	derivedrate.rateName.sendKeys(ratename);
	String derivedplan=new Select(derivedrate.ratePlan).getFirstSelectedOption().getText();	
	derivedRateLogger.info( "Selected Rate Plan : " +derivedplan);
	
	new Select(derivedrate.ratePlan).selectByIndex(1);
	String derivedplan2=new Select(derivedrate.ratePlan).getFirstSelectedOption().getText();
	derivedRateLogger.info(" Selected Derived Rate Plan : " +derivedplan2);
	
	
	//derivedRateLogger.info( "Selected Rate Plan : " +derivedplan);
	derivedrate.selectDerivedRate.click();
	String rateType=derivedrate.getRateType4.getText();
	derivedRateLogger.info(" Selected Rate Type : "  +rateType);
	
	Select dropdown=new Select(derivedrate.selectDerivedRatePlan);
	java.util.List<WebElement> options=dropdown.getOptions();
	int itemSize = options.size()-1;
	derivedRateLogger.info(" No of Derived rates : " +itemSize);
	
    for(int i = 0; i < itemSize ; i++){
        String optionsValue = options.get(i).getText();
        derivedRateLogger.info("Derived rate Plans : " +optionsValue);
        
      new Select(derivedrate.selectDerivedRatePlan).selectByIndex(itemSize);
     
    }
 
	derivedrate.offsetAmount.sendKeys(offsetAmount);
	Wait.explicit_wait_xpath(OR.rate_displayName);
	derivedrate.rate_displayName.sendKeys(rateDisplayName);
	Wait.explicit_wait_xpath(OR.rate_policy);
	derivedrate.rate_policy.sendKeys(ratePolicy);
	Wait.explicit_wait_xpath(OR.rate_description);
	derivedrate.rate_description.sendKeys(rateDescription);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
    js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
//   String parentWindow=driver.getWindowHandle();
    derivedrate.rate_Associate_Seasons.click();
	Wait.wait2Second();
	
/*	Set<String> allWindowHandles = driver.getWindowHandles();
	derivedRateLogger.info(allWindowHandles.size());
	
	for (String winHandle  : allWindowHandles) {
		if (!winHandle.equals(parentWindow)) {
			driver.switchTo().window(winHandle);
			
		}
		driver.switchTo().window(parentWindow);
	}*/
	
	driver.switchTo().frame("dialog-body0");
	driver.switchTo().frame("frmWaitHost");
	derivedRateLogger.info(" Switched to Frame ");

	derivedrate.click_All_Seasons.click();
	//Wait.wait5Second();
	//Wait.explicit_wait_xpath(OR.doneButton);
	derivedrate.doneButton.click();
	Wait.wait5Second();
	driver.switchTo().defaultContent();
	//Wait.wait25Second();
/*
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
    js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	Thread.sleep(5000);*/
	
	
	/*WebElement availableCell=rate.rate_Associate_RoomClasses;
	jse.executeScript("arguments[0].scrollIntoView(true);", availableCell);
	jse.executeScript("arguments[0].click()", availableCell);
	*/
	
	jse.executeScript("window.scrollBy(0,1000)"); 
	Wait.explicit_wait_xpath(OR.rate_Associate_RoomClasses);
	derivedrate.rate_Associate_RoomClasses.click();
	Thread.sleep(5000);
	driver.switchTo().frame("dialog-body0");
	driver.switchTo().frame("frmWaitHost");
	derivedRateLogger.info(" Switched to Frame ");
	Wait.wait15Second();
	derivedrate.click_All_RoomClasses.click();
	Wait.explicit_wait_xpath(OR.doneButton);
	derivedrate.doneButton.click();
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
	derivedrate.rate_Associate_Sources.click();
	Wait.wait5Second();
	driver.switchTo().frame("dialog-body0");
	driver.switchTo().frame("frmWaitHost");
	derivedRateLogger.info(" Switched to Frame ");
	Wait.wait15Second();
	derivedrate.rate_select_Source.click();
	Wait.explicit_wait_xpath(OR.doneButton);
	derivedrate.doneButton.click();
	Wait.wait5Second();
	driver.switchTo().defaultContent();
	Wait.wait15Second();
	//jse.executeScript("window.scrollBy(0,1000)");
	Wait.explicit_wait_xpath(OR.rate_Save_Button);
	derivedrate.rate_Save_Button.click();
	Wait.wait5Second();
	derivedrate.rate_done_button.click();
	Wait.wait10Second();
	derivedRateLogger.info(" Clicked on Done Button ");
	Wait.wait10Second();
	
	}

public void delete_rate(WebDriver driver) throws InterruptedException


{
	Elements_Inventory rate= new Elements_Inventory(driver);
	rate.click_goButton.click();
	Wait.wait5Second();
	rate.selectDRate.click();
	Wait.wait10Second();
	rate.deleteRate.click();
	Wait.wait10Second();
	derivedRateLogger.info(" System sucessfully deleted the Rate ");
	Wait.wait10Second();
}
	
}
