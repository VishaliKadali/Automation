package com.innroad.inncenter.pageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IRule;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Inventory;



public class Rules implements IRule{
	
	public static Logger rulesLogger = Logger.getLogger("Rules");

	public void create_Rule(WebDriver driver,String RuleName, String RuleType, String RuleDescription) throws InterruptedException {
		// TODO Auto-generated method stub
		Elements_Inventory newRule=new Elements_Inventory(driver);
		
		newRule.click_Inventory.click();
		newRule.click_Rules.click();
		Thread.sleep(5000);
		newRule.Click_newRule_Btn.click();
		newRule.Enter_ruleName.sendKeys(RuleName);
		new Select(newRule.Select_ruleType).selectByVisibleText(RuleType);
		newRule.Enter_ruleDescription.sendKeys(RuleDescription);
		Thread.sleep(3000);
		newRule.click_effectiveOnAsMonday.click();
		Thread.sleep(3000);
		newRule.click_effectiveOnAsTuesday.click();
		Thread.sleep(3000);
		newRule.click_associateSeasons.click();
		Thread.sleep(3000);
		newRule.click_associateSeasons_assignAll.click();
		newRule.click_associateSeasons_doneButton.click();
		Thread.sleep(8000);
		
//Page scroll down
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
		newRule.click_associateRoomclass.click();
		Thread.sleep(4000);
		
		
		/*int count_unassigned=driver.findElements(By.xpath(OR.get_unassignedSeasons_list)).size();
		rulesLogger.info("Unassigned Seasons" +count_unassigned);*/
		
		newRule.click_associateRoomclass_assignAll.click();
		
		/*int count_assigned=driver.findElements(By.xpath(OR.get_assignedSeasons_list)).size();
		rulesLogger.info(count_assigned); */
		
		newRule.click_associateRoomclass_doneButton.click();
		Thread.sleep(8000);
		newRule.click_associateSources.click();
		Thread.sleep(5000);
		newRule.click_associateSources_assignAll.click();
		newRule.click_associateSources_doneButton.click();
		Thread.sleep(8000);
		
//Page scroll down		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
		newRule.click_associateRatePlans.click();
		Thread.sleep(5000);
		newRule.click_associateRatePlans_assignAll.click();
		newRule.click_associateRatePlans_doneButton.click();
		Thread.sleep(8000);
		
		//Save the Rule
		newRule.Click_saveButton.click();
		Thread.sleep(3000);
		
		//Rule created success message
		String ruleCreation_message= newRule.Message_newRuleCreated.getText();
		rulesLogger.info(" New Rule created Successfully " +ruleCreation_message);
		
		Wait.wait15Second();
		//Scroll up the page
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newRule.Click_closeTab);
		
		//Close the created rule 
		newRule.Click_closeTab.click();
		Wait.wait10Second();
		rulesLogger.info(" Closed the tab");
		
		//Search the Rule
		newRule.Click_searchButton.click();
		Wait.wait10Second();
}

	
	//Delete the Rule
	public void deleteRule(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Elements_Inventory deleteRule=new Elements_Inventory(driver);
		deleteRule.selectRule.click();
		deleteRule.rule_clickDeleteButton.click();
		Wait.wait10Second();
		
	}
	
	
	
	/*public void click_Inventory(WebDriver driver) throws InterruptedException{
		Elements_Rule_Create RuleCreation = new Elements_Rule_Create(driver);
		RuleCreation.click_Inventory.click();
	  // Wait.explicit_wait_xpath(OR.click_Inventory); 
	    Thread.sleep(2000);
	}*/
	
	
	/*public void click_Rules(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Elements_Rule_Create RuleCreation = new Elements_Rule_Create(driver);
		RuleCreation.click_Rules.click();
	    //Wait.explicit_wait_xpath(OR.click_Rules);  
	}*/

	/*public void saveNewRule(WebDriver driver){
		Elements_Rule_Create Click_saveButton=new Elements_Rule_Create(driver);
		Click_saveButton.Click_saveButton.click();
		//Wait.explicit_wait_xpath(OR.Click_saveButton);
		rulesLogger.info(" New Rule Created " );
		

	
	}*/
 
	
	
	/*public void Click_newRule_Btn(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_Rule_Create RuleCreation = new Elements_Rule_Create(driver);
		RuleCreation.Click_newRule_Btn.click();
	    Wait.explicit_wait_xpath(OR.Click_newRule_Btn);  
	}
	
	public void Enter_ruleName(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_Rule_Create RuleCreation = new Elements_Rule_Create(driver);
		RuleCreation.Enter_ruleName.click();
	    Wait.explicit_wait_xpath(OR.Enter_ruleName);  
	}
	
	public void Select_ruleType(WebDriver driver) {
		// TODO Auto-generated method stub
		Elements_Rule_Create RuleCreation = new Elements_Rule_Create(driver);
		RuleCreation.Select_ruleType.click();
	    Wait.explicit_wait_xpath(OR.Select_ruleType);  
	}
	
	
	
	
	public void saveNewRule(WebDriver driver)throws InterruptedException {
		

		Elements_Rule_Create clickSaveButton = new Elements_Rule_Create(driver);
		clickSaveButton.Click_saveButton.click();
		
		Wait.wait10Second();
	}*/


	/*public void saveNewRule(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}*/
	
}
