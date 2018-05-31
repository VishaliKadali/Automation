package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.ITax;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Tax;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tax implements ITax{

	public static Logger taxLogger = Logger.getLogger("Tax");
	
	@Override
	public void createTax(WebDriver driver, ExtentTest test, String taxName, String displayName, String description,
			String value, String category,String taxLedgerAccount) throws InterruptedException {
		//Wait.wait3Second();
		Elements_Tax tax = new Elements_Tax(driver);
		
		Wait.WaitForElement(driver, OR.TaxItemName);
		tax.TaxItemName.clear();
		tax.TaxItemName.sendKeys(taxName);
		test.log(LogStatus.PASS, "New Tax Name : "+taxName);
		taxLogger.info("New Tax Name : "+taxName);
		
		tax.TaxDispalyName.clear();
		tax.TaxDispalyName.sendKeys(displayName);
		test.log(LogStatus.PASS, "New Tax Dispaly Name : "+displayName);
		taxLogger.info("New Tax Dispaly Name : "+displayName);
		
		tax.TaxDescription.clear();
		tax.TaxDescription.sendKeys(description);
		test.log(LogStatus.PASS, "New Tax description : "+description);
		taxLogger.info("New Tax description : "+description);
		
		tax.TaxValue.clear();
		tax.TaxValue.sendKeys(value);
		test.log(LogStatus.PASS, "New Tax Value : "+value);
		taxLogger.info("New Tax Value : "+value);
		
		tax.TaxPercent.click();
		test.log(LogStatus.PASS, "Tax percent is clicked");
		taxLogger.info("Tax percent is clicked");
		
		tax.ExcludeTaxExempt.click();
		test.log(LogStatus.PASS, "Exclude when tax exempt is clicked");
		taxLogger.info("Exclude when tax exempt is clicked");
		
		Select sel= new Select(tax.taxCategory);
		sel.selectByVisibleText(category);
		
		test.log(LogStatus.PASS, "Tax category selected to : "+category);
		taxLogger.info("Tax category selected to : "+category);
		
		tax.TaxAssociate.click();
		
		Wait.wait3Second();
		
		//System.out.println(driver.getWindowHandles().size());
		
		
		
		driver.switchTo().defaultContent();
	
		driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
		
		driver.switchTo().frame(driver.findElement(By.id("frmWaitHost")));
		//System.out.println(driver.findElement(By.xpath("//td[@id='tdTitle']/font[contains(text(),'Ledger Account Picker')]")).getText());
		
		if(driver.findElements(By.xpath(OR.TaxLedgerAccountPopup)).size()>0){
			
			driver.findElement(By.xpath("//select[@id='lstTaxes']/option[contains(text(),'"+taxLedgerAccount.trim()+"')]")).click();
			test.log(LogStatus.PASS, "Tax ledger account selected to : "+taxLedgerAccount);
			taxLogger.info("Tax ledger account selected to : "+taxLedgerAccount);
			
			tax.TaxPickOne.click();
		}
		
		tax.TaxLaedgerAccountDone.click();
		test.log(LogStatus.PASS, "Click Tax ledger account Done");
		taxLogger.info("Click Tax ledger account Done");
		
		Wait.wait2Second();
		driver.switchTo().defaultContent();
		
		Wait.WaitForElement(driver, OR.TaxDone);
		tax.TaxDone.click();
		test.log(LogStatus.PASS, "click Tax Done");
		//Wait.wait5Second();
		
		Wait.WaitForElement(driver, "//table[@id='MainContent_dgTaxItemList']/tbody/tr/td[1]/a[contains(text(),'"+taxName.trim()+"')]");
		if(driver.findElements(By.xpath("//table[@id='MainContent_dgTaxItemList']/tbody/tr/td[1]/a[contains(text(),'"+taxName.trim()+"')]")).size()>0){
			test.log(LogStatus.PASS, "Tax Successfully crated : "+taxName);	
			taxLogger.info("Tax Successfully crated : "+taxName);
			
			driver.findElement(By.xpath("//li[@id='head_reservations']/a/img")).click();
			//Wait.wait5Second();
			
		}else{
			test.log(LogStatus.FAIL, "Tax Successfully not crated : "+taxName);	
			taxLogger.info("Tax Successfully not crated : "+taxName);
		}
	}

}
