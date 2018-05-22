package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.innroad.inncenter.interfaces.IPolicies;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.utils.Utility;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_Accounts;
import com.innroad.inncenter.webelements.WebElements_Policies;

public class Policies implements IPolicies{

	public static Logger policiesLogger = Logger.getLogger("Policies");
	
	//selects the given policy type and clicks new policy button
	public void NewPolicybutton(WebDriver driver, String PolicyType) {
		
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		new Select (CreatePolicy.Select_Policy_Type).selectByVisibleText(PolicyType);
		CreatePolicy.New_Policy_Btn.click();
		Wait.explicit_wait_xpath(OR.Enter_Policy_Name);
				
	}
	//enters given policy name
	public void Enter_Policy_Name(WebDriver driver,String PolicyName)
	{
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		CreatePolicy.Enter_Policy_Name.sendKeys(PolicyName);
	}
	//checks whether selected policy type is selected or not. 
	public void verify_Policy_Type(WebDriver driver, String PolicyType){
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		String selectedOption = new Select(CreatePolicy.Select_Policy_Type).getFirstSelectedOption().getText();
		Assert.assertEquals(PolicyType, selectedOption);
    }

	public void Enter_Deposit_policy_Attributes_RC_Percentage(WebDriver driver,String Number){
		
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		CreatePolicy.Enter_Deposit_Percentage_Charges.sendKeys(Number);
	}
	
	public void Enter_Deposit_Policy_Attributes(WebDriver driver,String Chargestype,String Number) throws InterruptedException{
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		switch(Chargestype.toUpperCase())
		{
		case "PRC": 
			  
			   CreatePolicy.Enter_Deposit_Percentage_Charges.sendKeys(Number);
			   break;
			
		case "TRC":
			   new Select (CreatePolicy.Select_Roomcharges_Type_for_Deposit).selectByVisibleText("Total Charges");
			   Wait.wait2Second();
			   CreatePolicy.Enter_Deposit_Percentage_Charges.sendKeys(Number);
		       break;
			
		case "FA": 
			  driver.findElement(By.xpath(OR.Select_Deposit_Fixedamount_Radiobtn)).click();
			  CreatePolicy.Enter_Deposit_Fixed_Amount.sendKeys(Number);
			  break;
			
		case "FNRC": 
			    
			  driver.findElement(By.xpath(OR.Select_Deposit_Firstnightrc_Radiobtn)).click();
			  CreatePolicy.Enter_Deposit_First_Nights_RC.sendKeys(Number);
			  break;
	    default:  System.err.println("Error! Invalid Input Supplied for deposit policy expected PRC/TRC/FA/FNRC");
			
		}
		
	}
	
	
	public void Enter_Checkin_Policy_Attributes(WebDriver driver,String paymenttype,String number) throws InterruptedException{
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		switch(paymenttype.toLowerCase())
		{
		case "capture": 
			   CreatePolicy.Select_Capture_Payment_for_Checkin.click();
			   CreatePolicy.Enter_Checkin_Percentage_On_balance.sendKeys(number);
			   
			   break;
			
		case "authorize":
			   CreatePolicy.Select_Authorize_Payment_for_Checkin.click();
			   CreatePolicy.Enter_Checkin_Percentage_On_balance.sendKeys(number);
		       break;
		default : System.err.println("Error! Invalid Input Supplied for checkin policy expecting capture/authorize ");
			
			
		}
		
	}
		
	
	
	public void Enter_policy_Attributes_TC_Percentage(WebDriver driver,String Number){
		
		
	}
	
	
	public void Enter_Policy_Desc(WebDriver driver,String PolicyText,String PolicyDesc){
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		CreatePolicy.Enter_Policy_Text.sendKeys(PolicyText);
		CreatePolicy.Enter_Policy_Description.sendKeys(PolicyDesc);
		
	}
	
	public void Associate_Sources(WebDriver driver) throws InterruptedException{
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		Utility.ScrollToElement(CreatePolicy.Associate_Sources_Btn);
		CreatePolicy.Associate_Sources_Btn.click();
		Wait.explicit_wait_xpath(OR.Associate_Assign_All_Btn);
		int Available_Options_Count = driver.findElements(By.xpath(OR.Available_Options_In_Popup)).size();
		policiesLogger.info(Available_Options_Count);
		Wait.wait1Second();
		CreatePolicy.Assoociate_Assign_All_Btn.click();
		Wait.wait1Second();
		int Added_Options_Count = driver.findElements(By.xpath(OR.Added_Options_In_Popup)).size();
		Assert.assertEquals(Added_Options_Count, Available_Options_Count,"All Available options are not added in Sources Picker popup after clicking Assign all");
		CreatePolicy.Done_In_Popup.click();
		Wait.wait3Second();
		
								
	 }
	
	public void Associate_Seasons(WebDriver driver) throws InterruptedException {
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		Utility.ScrollToElement(CreatePolicy.Associate_Seasons_Btn);
		CreatePolicy.Associate_Seasons_Btn.click();
		Wait.explicit_wait_xpath(OR.Associate_Assign_All_Btn);
		int Available_Options_Count = driver.findElements(By.xpath(OR.Available_Options_In_Popup)).size();
		Wait.wait1Second();
		CreatePolicy.Assoociate_Assign_All_Btn.click();
		Wait.wait1Second();
		int Added_Options_Count = driver.findElements(By.xpath(OR.Added_Options_In_Popup)).size();
		Assert.assertEquals(Added_Options_Count, Available_Options_Count,"All Available options are not added in Seasons Picker popup after clicking Assign all");
		CreatePolicy.Done_In_Popup.click();
		Wait.wait3Second();
						
	 }
	
	
	public void Associate_RoomClasses(WebDriver driver) throws InterruptedException	{
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		Utility.ScrollToElement(CreatePolicy.Associate_Room_Classes_Btn);
		CreatePolicy.Associate_Room_Classes_Btn.click();
		Wait.explicit_wait_xpath(OR.Associate_Assign_All_Btn);
		int Available_Options_Count = driver.findElements(By.xpath(OR.Available_Options_In_Popup)).size();
		Wait.wait1Second();
		CreatePolicy.Assoociate_Assign_All_Btn.click();
		Wait.wait1Second();
		int Added_Options_Count = driver.findElements(By.xpath(OR.Added_Options_In_Popup)).size();
		Assert.assertEquals(Added_Options_Count, Available_Options_Count,"All Available options are not added in Roomclasses Picker popup after clicking Assign all");
		CreatePolicy.Done_In_Popup.click();
		Wait.wait3Second();
						
	 }
	
	public void Associate_RatePlans(WebDriver driver) throws InterruptedException {
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		Utility.ScrollToElement(CreatePolicy.Associate_Rate_Plans_Btn);
		CreatePolicy.Associate_Rate_Plans_Btn.click();
		Wait.explicit_wait_xpath(OR.Associate_Assign_All_Btn);
		int Available_Options_Count = driver.findElements(By.xpath(OR.Available_Options_In_Popup)).size();
		Wait.wait1Second();
		CreatePolicy.Assoociate_Assign_All_Btn.click();
		Wait.wait3Second();
		int Added_Options_Count = driver.findElements(By.xpath(OR.Added_Options_In_Popup)).size();
		Assert.assertEquals(Added_Options_Count, Available_Options_Count,"All Available options are not added in Roomclasses Picker popup after clicking Assign all");
		CreatePolicy.Done_In_Popup.click();
		Wait.wait3Second();
						
	 }
	
	public void Save_Policy(WebDriver driver){
		WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
		CreatePolicy.Policy_Save.click();
		
		if(CreatePolicy.Verify_Toaster_Container.isDisplayed()){
		String getTotasterTitle_ReservationSucess=CreatePolicy.Toaster_Title.getText();
		Assert.assertEquals(getTotasterTitle_ReservationSucess, "Success");
						
		}
		 else
		{
			System.err.println("Toaster_Message is not displaying ");
		}
	 }
		
		public void Close_Policy_Tab(WebDriver driver) throws InterruptedException{
			WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
			Utility.ScrollToElement(CreatePolicy.Policy_Close_Btn);
			CreatePolicy.Policy_Close_Btn.click();
			Wait.explicit_wait_xpath(OR.New_Policy_Btn);
		}
		//Searches for the policy with the created policy name.
		public void Verify_Policy(WebDriver driver,String PolicyName) throws InterruptedException{
			WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
			CreatePolicy.Policy_Name_On_Policiespage.clear();
			CreatePolicy.Policy_Name_On_Policiespage.sendKeys(PolicyName);
			CreatePolicy.Search_On_On_Policiespage.click();
			Wait.wait1Second();
			Wait.explicit_wait_xpath(OR.First_Element_In_Search_Result);
			Assert.assertEquals(CreatePolicy.First_Element_In_Search_Result.getText(), PolicyName);
			
		}
		
		
		public void Delete_Policy(WebDriver driver,String PolicyName) throws InterruptedException{
			WebElements_Policies CreatePolicy=new WebElements_Policies(driver);
			CreatePolicy.Policy_Name_On_Policiespage.clear();
			CreatePolicy.Policy_Name_On_Policiespage.sendKeys(PolicyName);
			CreatePolicy.Search_On_On_Policiespage.click();
			Wait.wait2Second();
	
			if(CreatePolicy.First_Element_In_Search_Result.isDisplayed())
			{
			Wait.explicit_wait_xpath(OR.First_Element_In_Search_Result);
			Assert.assertEquals(CreatePolicy.First_Element_In_Search_Result.getText(), PolicyName);
			Wait.explicit_wait_visibilityof_webelement(CreatePolicy.Delete_Policy_Checkbox);
			
			driver.findElement(By.xpath("//a[text()='"+PolicyName+"']/../following-sibling::td//input[@type='checkbox']")).click();
//			CreatePolicy.Delete_Policy_Checkbox.click();
			CreatePolicy.Delete_Policy_Btn.click();
			}
			
			else
			{
				System.out.println("Given "+PolicyName+" Policy is not found");
			}

//			if(CreatePolicy.Verify_Toaster_Container.isDisplayed()){
//			String getTotasterTitle_ReservationSucess=CreatePolicy.Toaster_Title.getText();
//			Assert.assertEquals(getTotasterTitle_ReservationSucess, "Policies Deleted Successfully");
//							
//			}
//			 else
//			{
//				System.err.println("Toaster_Message is not displaying ");
//			}
			
			
		}
		
	
		
	}
	
	

