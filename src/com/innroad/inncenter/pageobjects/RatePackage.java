package com.innroad.inncenter.pageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;


import com.innroad.inncenter.interfaces.IRatePackage;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Inventory;



public class RatePackage implements IRatePackage{
	
public static Logger packageRateLogger = Logger.getLogger("RatePackage");
	
public void inventory_Rate(WebDriver driver) throws InterruptedException{
		
		
		Elements_Inventory rate= new Elements_Inventory(driver);
		Wait.wait3Second();
		rate.click_Inventory.click();
		rate.inventory_rate.click();
		Wait.wait10Second();
		packageRateLogger.info(" System successfully Navigated to Inventory Rates ");
		//Wait.wait10Second();
	}



public void package_details(WebDriver driver, String packageName) throws InterruptedException{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Elements_Inventory packagerate= new Elements_Inventory(driver);
	Wait.explicit_wait_xpath(OR.newRate);
	packagerate.newRate.click();
	Wait.explicit_wait_xpath(OR.rateName);
	packagerate.rateName.sendKeys(packageName);
	String packageplan=new Select(packagerate.ratePlan).getFirstSelectedOption().getText();
	
	
	packageRateLogger.info( "Selected Rate Plan : " +packageplan);
	
	
	
	//packageRateLogger.info( "Selected Rate Plan : " +derivedplan);
	packagerate.selectPackageRatePlan.click();
	String rateType=packagerate.getRateType3.getText();
	packageRateLogger.info(" Selected Rate Type : "  +rateType);
}
	
public void package_components(WebDriver driver, String PackageCompDescription, String PackageAmount) throws InterruptedException{
	
	Elements_Inventory packagerate= new Elements_Inventory(driver);
		String packageComponents=packagerate.getPackageComponents.getText();
		packageRateLogger.info("packageComponents : "  +packageComponents);
		
		packagerate.clickPackageAddButton.click();
		
		
		Select dropdown=new Select(packagerate.selectPackageCategory);
		java.util.List<WebElement> options=dropdown.getOptions();
		int itemSize = options.size();
		packageRateLogger.info(" No of Package rates : " +itemSize);
		Wait.wait3Second();
	    /*for(int i = 0; i < itemSize ; i++)
	    {
	        String optionsValue = options.get(i).getText();
	        packageRateLogger.info("Category : " +optionsValue);*/ 
	       
	    //}
	    
		 new Select(packagerate.selectPackageCategory).selectByIndex(5);
		 Wait.wait3Second();
	   String getpackageComponentDescription= packagerate.packageComponentDescription.getText();
	   packageRateLogger.info("packageComponentDescription : " +getpackageComponentDescription);
	   Wait.wait3Second();
	    String getpackageCalculationMethod= new Select(packagerate.packageCalculationMethod).getFirstSelectedOption().getText();
	    packageRateLogger.info(" Package Calculation Method " +getpackageCalculationMethod);
	    Wait.wait3Second();
	    packagerate.enterPackageAmount.sendKeys(PackageAmount);
	    
	    Wait.wait10Second();
		
	}
	
public void package_descriptiveInformation(WebDriver driver, String rateDisplayName, String ratePolicy, String rateDescription) throws InterruptedException{
	Elements_Inventory packagerate= new Elements_Inventory(driver);
	///Wait.explicit_wait_xpath(OR.rate_displayName);
	packagerate.rate_displayName.sendKeys(rateDisplayName);
	Wait.explicit_wait_xpath(OR.rate_policy);
	packagerate.rate_policy.sendKeys(ratePolicy);
	Wait.explicit_wait_xpath(OR.rate_description);
	packagerate.rate_description.sendKeys(rateDescription);
	Wait.wait15Second();
	}

	
public void associateRate(WebDriver driver) throws InterruptedException	{
	
	
	Elements_Inventory packagerate= new Elements_Inventory(driver);
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
    js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    
    Wait.wait5Second();
    
    packageRateLogger.info(driver.getWindowHandles());
	
	packagerate.clickPackageAssociateRate.click();
	
	
	//Thread.sleep(5000);
	//new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='MainContent_dgRatesList_chkSelected_0']")));
    //packageRateLogger.info("Waiting for 15 secs");
	//Wait.explicit_wait_xpath(OR.selectRateInPackage);
	
	Wait.wait5Second();
	driver.switchTo().frame("dialog-body0");
	
	packagerate.selectRateInPackage.click();
	
	Wait.wait5Second();
	//jse.executeScript("window.scrollBy(0,1000)");
	//Wait.explicit_wait_xpath(OR.rate_Save_Button);
	packagerate.clickPackageSelectButton.click();
	Wait.wait5Second();
	driver.switchTo().defaultContent();
	packagerate.rate_Save_Button.click();
	Wait.wait5Second();
	packagerate.rate_done_button.click();
	Wait.wait10Second();
	packageRateLogger.info(" Clicked on Done Button ");
	Wait.wait10Second();
	
}
	
	
public void delete_rate(WebDriver driver) throws InterruptedException

{
	Elements_Inventory rate= new Elements_Inventory(driver);
	rate.click_goButton.click();
	Wait.wait5Second();
	rate.selectPRate.click();
	Wait.wait10Second();
	rate.deleteRate.click();
	Wait.wait10Second();
	packageRateLogger.info(" System sucessfully deleted the Rate ");
	Wait.wait10Second();
}

}
