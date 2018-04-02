package com.innroad.inncenter.WebElements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.Properties.OR;

public class Elements_Tax {
	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	public Elements_Tax(WebDriver driver2)
	{
		this.driver=driver2;
		PageFactory.initElements(this.driver, this);		 
	}
	
	
	@FindBy(xpath=OR.TaxNewItem)
	public WebElement TaxNewItem;
	
	@FindBy(xpath=OR.TaxItemName)
	public WebElement TaxItemName;
	
	@FindBy(xpath=OR.TaxDispalyName)
	public WebElement TaxDispalyName;
	
	@FindBy(xpath=OR.TaxDescription)
	public WebElement TaxDescription;
	
	@FindBy(xpath=OR.TaxValue)
	public WebElement TaxValue;
	
	
	@FindBy(xpath=OR.ExcludeTaxExempt)
	public WebElement ExcludeTaxExempt;
	
	
	@FindBy(xpath=OR.TaxPercent)
	public WebElement TaxPercent;
	
	@FindBy(xpath=OR.taxCategory)
	public WebElement taxCategory;
	
	@FindBy(xpath=OR.TaxAssociate)
	public WebElement TaxAssociate;
	
	@FindBy(xpath=OR.TaxLedgerAccountPopup)
	public WebElement TaxLedgerAccountPopup;
	
	@FindBy(xpath=OR.TaxPickOne)
	public WebElement TaxPickOne;
	
	
	
	@FindBy(xpath=OR.TaxLaedgerAccountDone)
	public WebElement TaxLaedgerAccountDone;
	
	
	@FindBy(xpath=OR.TaxDone)
	public WebElement TaxDone;
	
	
	
	
	//table[@id='MainContent_dgTaxItemList']/tbody/tr/td[1]/a[contains(text(),'tax test')]

	//select[@id='lstTaxes']/option[contains(text(),'POS')]
	
}
