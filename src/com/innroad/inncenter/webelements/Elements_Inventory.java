package com.innroad.inncenter.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.innroad.inncenter.properties.OR;



public class Elements_Inventory {

	
	WebDriver driver ;


	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
		
		public Elements_Inventory(WebDriver driver2)
		
		{
			this.driver=driver2;
			PageFactory.initElements(this.driver, this);
	 
		}
		
		//Select Property
		
		@FindBy(xpath=OR.clickClientSelectorIcon)
		public WebElement clickClientSelectorIcon;
		
		@FindBy(xpath=OR.clickPenIcon)
		public WebElement clickPenIcon;
		
		@FindBy(xpath=OR.enterClientName)
		public WebElement enterClientName;
		
		//Rates

		@FindBy(xpath=OR.click_Inventory)
		public WebElement click_Inventory;
		
		@FindBy(xpath=OR.inventory_rate)
		public WebElement inventory_rate;
		
		@FindBy(xpath=OR.newRate)
		public WebElement newRate;
		
		@FindBy(xpath=OR.rateName)
		public WebElement rateName;
		
		@FindBy(xpath=OR.ratePlan)
		public WebElement ratePlan;
		
		@FindBy(xpath=OR.selectDerivedRate)
		public WebElement selectDerivedRate;
		
		@FindBy(xpath=OR.getRateType)
		public WebElement getRateType;
		
		@FindBy(xpath=OR.getRateType3)
		public WebElement getRateType3;
		
		@FindBy(xpath=OR.getRateType4)
		public WebElement getRateType4;
		
		@FindBy(xpath=OR.maxAdults)
		public WebElement maxAdults;
		
		@FindBy(xpath=OR.maxPersons)
		public WebElement maxPersons;
		
		@FindBy(xpath=OR.selectDerivedRatePlan)
		public WebElement selectDerivedRatePlan;
		
		@FindBy(xpath=OR.clickPackageAssociateRate)
		public WebElement clickPackageAssociateRate;
		
		@FindBy(xpath=OR.selectPackageRatePlan)
		public WebElement selectPackageRatePlan;
		
		@FindBy(xpath=OR.getPackageComponents)
		public WebElement getPackageComponents;
		
		@FindBy(xpath=OR.clickPackageAddButton)
		public WebElement clickPackageAddButton;
		
		@FindBy(xpath=OR.selectPackageCategory)
		public WebElement selectPackageCategory;
		
		@FindBy(xpath=OR.packageComponentDescription)
		public WebElement packageComponentDescription;
		
		@FindBy(xpath=OR.packageCalculationMethod)
		public WebElement packageCalculationMethod;
		
		@FindBy(xpath=OR.enterPackageAmount)
		public WebElement enterPackageAmount;
		
		@FindBy(xpath=OR.selectRateInPackage)
		public WebElement selectRateInPackage;
		
		@FindBy(xpath=OR.clickPackageSelectButton)
		public WebElement clickPackageSelectButton;
		
		@FindBy(xpath=OR.baseAmount)
		public WebElement baseAmount;
		
		@FindBy(xpath=OR.offsetAmount)
		public WebElement offsetAmount;
		
		@FindBy(xpath=OR.additionalAdult)
		public WebElement additionalAdult;
		
		@FindBy(xpath=OR.additionalChild)
		public WebElement additionalChild;
		
		@FindBy(xpath=OR.rate_displayName)
		public WebElement rate_displayName;
		
		@FindBy(xpath=OR.rate_policy)
		public WebElement rate_policy;
		
		@FindBy(xpath=OR.rate_description)
		public WebElement rate_description;
		
		@FindBy(xpath=OR.rate_Associate_Seasons)
		public WebElement rate_Associate_Seasons;
		
		@FindBy(xpath=OR.click_All_Seasons)
		public WebElement click_All_Seasons;
		
		@FindBy(xpath=OR.doneButton)
		public WebElement doneButton;
		
		@FindBy(xpath=OR.rate_Associate_RoomClasses)
		public WebElement rate_Associate_RoomClasses;
		
		@FindBy(xpath=OR.click_All_RoomClasses)
		public WebElement click_All_RoomClasses;
		
		@FindBy(xpath=OR.rate_Associate_Sources)
		public WebElement rate_Associate_Sources;
		
		@FindBy(xpath=OR.rate_select_Source)
		public WebElement rate_select_Source;
		
		@FindBy(xpath=OR.rate_Save_Button)
		public WebElement rate_Save_Button;
		
		@FindBy(xpath=OR.rate_done_button)
		public WebElement rate_done_button;
		
		@FindBy(xpath=OR.click_goButton)
		public WebElement click_goButton;
		
		@FindBy(xpath=OR.selectBaseRate)
		public WebElement selectBaseRate;
		
		@FindBy(xpath=OR.selectDRate)
		public WebElement selectDRate;
		
		@FindBy(xpath=OR.selectPRate)
		public WebElement selectPRate;
		
		@FindBy(xpath=OR.deleteRate)
		public WebElement deleteRate;

		
		//Distribution
		
		@FindBy(xpath=OR.clickDistributionMenu)
		public WebElement clickDistributionMenu;
		
		@FindBy(xpath=OR.propertySelectionAlert)
		public WebElement propertySelectionAlert;
		
		@FindBy(xpath=OR.selectProperty)
		public WebElement selectProperty; 
		
		@FindBy(xpath=OR.distribute)
		public WebElement distribute;
		
		@FindBy(xpath=OR.defaultStatus)
		public WebElement defaultStatus;
		
		@FindBy(xpath=OR.clickSaveButtonDistribution)
		public WebElement clickSaveButtonDistribution;

		//Create Rule
		
		@FindBy(xpath=OR.click_Rules)
		public WebElement click_Rules;
		
		@FindBy(xpath=OR.Click_newRule_Btn)
		public WebElement Click_newRule_Btn;
		
		@FindBy(xpath=OR.Enter_ruleName)
		public WebElement Enter_ruleName;
		
		@FindBy(xpath=OR.Select_ruleType)
		public WebElement Select_ruleType;
		
		@FindBy(xpath=OR.Enter_ruleDescription)
		public WebElement Enter_ruleDescription;
		
		@FindBy(xpath=OR.click_effectiveOnAsMonday)
		public WebElement click_effectiveOnAsMonday;
		
		@FindBy(xpath=OR.click_effectiveOnAsTuesday)
		public WebElement click_effectiveOnAsTuesday;
		
		@FindBy(xpath=OR.click_associateSeasons)
		public WebElement click_associateSeasons;
		
		@FindBy(xpath=OR.get_unassignedSeasons_list)
		public WebElement get_unassignedSeasons_list;
		
		@FindBy(xpath=OR.click_associateSeasons_assignAll)
		public WebElement click_associateSeasons_assignAll;
		
		@FindBy(xpath=OR.get_assignedSeasons_list)
		public WebElement get_assignedSeasons_list;
		
		@FindBy(xpath=OR.click_associateSeasons_doneButton)
		public WebElement click_associateSeasons_doneButton;
		
		@FindBy(xpath=OR.click_associateRoomclass)
		public WebElement click_associateRoomclass;
		
		@FindBy(xpath=OR.click_associateRoomclass_assignAll)
		public WebElement click_associateRoomclass_assignAll;
		
		@FindBy(xpath=OR.click_associateRoomclass_doneButton)
		public WebElement click_associateRoomclass_doneButton;
		
		@FindBy(xpath=OR.click_associateSources)
		public WebElement click_associateSources;
		
		@FindBy(xpath=OR.click_associateSources_assignAll)
		public WebElement click_associateSources_assignAll;
		
		@FindBy(xpath=OR.click_associateSources_doneButton)
		public WebElement click_associateSources_doneButton;
		
		@FindBy(xpath=OR.click_associateRatePlans)
		public WebElement click_associateRatePlans;
		
		@FindBy(xpath=OR.click_associateRatePlans_assignAll)
		public WebElement click_associateRatePlans_assignAll;
		
		@FindBy(xpath=OR.click_associateRatePlans_doneButton)
		public WebElement click_associateRatePlans_doneButton;
		
		@FindBy(xpath=OR.Click_saveButton)
		public WebElement Click_saveButton;
		
		@FindBy(xpath=OR.Message_newRuleCreated)
		public WebElement Message_newRuleCreated; 
		
		@FindBy(xpath=OR.Click_closeTab)
		public WebElement Click_closeTab;
		
		@FindBy(xpath=OR.Click_searchButton)
		public WebElement Click_searchButton;

		@FindBy(xpath=OR.selectRule)
		public WebElement selectRule;
		
		@FindBy(xpath=OR.rule_clickDeleteButton)
		public WebElement rule_clickDeleteButton;
		
		}
