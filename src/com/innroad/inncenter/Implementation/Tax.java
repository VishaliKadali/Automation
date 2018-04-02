package com.innroad.inncenter.Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.Interface.ITax;
import com.innroad.inncenter.Properties.OR;
import com.innroad.inncenter.Wait.Wait;
import com.innroad.inncenter.WebElements.Elements_Tax;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tax implements ITax{

	@Override
	public void createTax(WebDriver driver, ExtentTest test, String taxName, String displayName, String description,
			String value, String category,String taxLedgerAccount) throws InterruptedException {
		Wait.wait5Second();
		Elements_Tax tax = new Elements_Tax(driver);
		tax.TaxItemName.clear();
		tax.TaxItemName.sendKeys(taxName);
		test.log(LogStatus.PASS, "New Tax Name : "+taxName);
		tax.TaxDispalyName.clear();
		tax.TaxDispalyName.sendKeys(displayName);
		test.log(LogStatus.PASS, "New Tax Dispaly Name : "+displayName);
		tax.TaxDescription.clear();
		tax.TaxDescription.sendKeys(description);
		test.log(LogStatus.PASS, "New Tax description : "+description);
		tax.TaxValue.clear();
		tax.TaxValue.sendKeys(value);
		test.log(LogStatus.PASS, "New Tax Value : "+value);
		tax.TaxPercent.click();
		test.log(LogStatus.PASS, "Tax percent is clicked");
		tax.ExcludeTaxExempt.click();
		test.log(LogStatus.PASS, "Exclude when tax exempt is clicked");
		Select sel= new Select(tax.taxCategory);
		sel.selectByVisibleText(category);
		
		test.log(LogStatus.PASS, "Tax category selected to : "+category);
		tax.TaxAssociate.click();
		
		Wait.wait10Second();
		
		//System.out.println(driver.getWindowHandles().size());
		
		
		
		driver.switchTo().defaultContent();
	
		driver.switchTo().frame(driver.findElement(By.id("dialog-body0")));
		
		driver.switchTo().frame(driver.findElement(By.id("frmWaitHost")));
		System.out.println(driver.findElement(By.xpath("//td[@id='tdTitle']/font[contains(text(),'Ledger Account Picker')]")).getText());
		
		if(driver.findElements(By.xpath(OR.TaxLedgerAccountPopup)).size()>0){
			
			driver.findElement(By.xpath("//select[@id='lstTaxes']/option[contains(text(),'"+taxLedgerAccount.trim()+"')]")).click();
			test.log(LogStatus.PASS, "Tax ledger account selected to : "+taxLedgerAccount);
			tax.TaxPickOne.click();
		}
		
		tax.TaxLaedgerAccountDone.click();
		test.log(LogStatus.PASS, "click Tax ledger account Done");
		
		Wait.wait10Second();
		driver.switchTo().defaultContent();
		tax.TaxDone.click();
		test.log(LogStatus.PASS, "click Tax Done");
		Wait.wait10Second();
		if(driver.findElements(By.xpath("//table[@id='MainContent_dgTaxItemList']/tbody/tr/td[1]/a[contains(text(),'"+taxName.trim()+"')]")).size()>0){
			test.log(LogStatus.PASS, "Tax Successfully crated : "+taxName);	
			driver.findElement(By.xpath("//li[@id='head_reservations']/a/img")).click();
			Wait.wait5Second();
			
		}else{
			test.log(LogStatus.FAIL, "Tax Successfully not crated : "+taxName);		
		}
	}

}
