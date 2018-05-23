package com.innroad.inncenter.pageobjects;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IRateQuote;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_RateQuote;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RateQuote implements IRateQuote {

	public static Logger rateQuoteLogger=Logger.getLogger("RateQuote");
	
	public void searchDetails(WebDriver driver, String RateQuoteNights,
			String RateQuoteAdults, String RateQuoteChildren,
			String RateQuoteRatePlanList, String RateQuotePromoCode) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_Arrive_DatePicker.click();
		RateQuotePage.Click_Today.click();
		
		RateQuotePage.Enter_RateQuoteNights.clear();
		
		RateQuotePage.Enter_RateQuoteNights.sendKeys(RateQuoteNights);
		
		RateQuotePage.Enter_RateQuoteAdults.clear();
		RateQuotePage.Enter_RateQuoteAdults.sendKeys(RateQuoteAdults);
		
		RateQuotePage.Enter_RateQuoteChildren.clear();
		RateQuotePage.Enter_RateQuoteChildren.sendKeys(RateQuoteChildren);
		new Select (RateQuotePage.Select_RateQuoteRatePlanList).selectByVisibleText(RateQuoteRatePlanList);
		
		RateQuotePage.Enter_RateQuotePromoCode.clear();
		RateQuotePage.Enter_RateQuotePromoCode.sendKeys(RateQuotePromoCode);
		
		rateQuoteLogger.info("Entered inputs for RateQuote Search fields");		
	}

	public void searchDetails(WebDriver driver,ExtentTest test, String RateQuoteNights,
			String RateQuoteAdults, String RateQuoteChildren,
			String RateQuoteRatePlanList, String RateQuotePromoCode) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_Arrive_DatePicker.click();
		RateQuotePage.Click_Today.click();
		test.log(LogStatus.PASS, "Clicked on Today in datepicker");
		rateQuoteLogger.info("Clicked on Today in datepicker");
		
		RateQuotePage.Enter_RateQuoteNights.clear();
		RateQuotePage.Enter_RateQuoteNights.sendKeys(RateQuoteNights);
		test.log(LogStatus.PASS, "Number of Rate Quote nights : "+RateQuoteNights);
		rateQuoteLogger.info("Number of Rate Quote nights : "+RateQuoteNights);
		
		RateQuotePage.Enter_RateQuoteAdults.clear();
		RateQuotePage.Enter_RateQuoteAdults.sendKeys(RateQuoteAdults);
		test.log(LogStatus.PASS, "Number of Rate Quote adults : "+RateQuoteAdults);
		rateQuoteLogger.info("Number of Rate Quote adults : "+RateQuoteAdults);
		
		RateQuotePage.Enter_RateQuoteChildren.clear();
		RateQuotePage.Enter_RateQuoteChildren.sendKeys(RateQuoteChildren);
		new Select (RateQuotePage.Select_RateQuoteRatePlanList).selectByVisibleText(RateQuoteRatePlanList);
		test.log(LogStatus.PASS, "Number of Rate Quote children : "+RateQuoteChildren);
		rateQuoteLogger.info("Number of Rate Quote children : "+RateQuoteChildren);
		
		RateQuotePage.Enter_RateQuotePromoCode.sendKeys(RateQuotePromoCode);
		test.log(LogStatus.PASS, "Number of Rate Quote promocode : "+RateQuotePromoCode);	
		rateQuoteLogger.info("Number of Rate Quote promocode : "+RateQuotePromoCode);
		
		
		
	}


	public void clearRateQuoteDetails(WebDriver driver) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_clearRateQuote.clear();
		
		
	}

	
	public void SearchRateQuoteDetails(WebDriver driver) {
		
      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_searchRateQuote.click();
		Wait.explicit_wait_xpath(OR.Verify_Room_Grid);
		
		
	}

	public void SearchRateQuoteDetails(WebDriver driver,ExtentTest test) {
		
	      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
			
			RateQuotePage.Click_searchRateQuote.click();
			test.log(LogStatus.PASS, "Click Search");
			rateQuoteLogger.info("AClick Search");
			Wait.explicit_wait_xpath(OR.Verify_Room_Grid);
		}

	public void clickBookicon(WebDriver driver) throws InterruptedException {
		
		
	      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		 /* String Propertyid= RateQuotePage.Get_Property_Id.getAttribute("propertyid");
		  System.out.println(Propertyid);*/
	      RateQuotePage.Click_First_Book_Icon.click();
	      try
			{
				Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			}
			catch(Exception e)
			{
				rateQuoteLogger.info("Rules Satisfied");
			}
			Wait.wait5Second();
			if(RateQuotePage.Verify_RulesBroken_Popup.isDisplayed())
			{
				RateQuotePage.Click_Rate_Quote_Book.click();
				Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
				Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			}
			else
			{
				rateQuoteLogger.info("Satisfied Rules");
			}
			
		     try
		      {
		    	  Wait.explicit_wait_xpath(OR.Verify_OverBook_popup);
		      }
		      catch(Exception e)
				{
		    	  rateQuoteLogger.info("Rooms are available");
				}
		     Wait.wait5Second();
		     if(RateQuotePage.Verify_OverBook_popup.isDisplayed())
				{
					RateQuotePage.Click_Continue_OverBook_Popup.click();
					Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
					Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
				}
				else
				{
					rateQuoteLogger.info("Satisfied Rules");
				}
	}
	
	
	
	public void clickQuoteIcon(WebDriver driver,ExtentTest test) throws InterruptedException {
		
		
	      Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		 /* String Propertyid= RateQuotePage.Get_Property_Id.getAttribute("propertyid");
		  System.out.println(Propertyid);*/
	      RateQuotePage.Click_First_Quote_Icon.click();
	      test.log(LogStatus.PASS, "Click on Quote");
	      try
			{
				Wait.explicit_wait_xpath(OR.Verify_RulesBroken_Popup);
			}
			catch(Exception e)
			{
				//System.out.println("Rules Satisfied");
			}
			Wait.wait3Second();
			if(RateQuotePage.Verify_RulesBroken_Popup.isDisplayed())
			{
				RateQuotePage.Click_First_Quote_Icon.click();
				 test.log(LogStatus.PASS, "Click on Quote");
				Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
				Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
			}
			else
			{
				//System.out.println("Satisfied Rules");
			}
			
		     try
		      {
		    	  Wait.explicit_wait_xpath(OR.Verify_OverBook_popup);
		      }
		      catch(Exception e)
				{
					//System.out.println("Rooms are available");
				}
		     Wait.wait3Second();
		     if(RateQuotePage.Verify_OverBook_popup.isDisplayed())
				{
					RateQuotePage.Click_Continue_OverBook_Popup.click();
					test.log(LogStatus.PASS, "Click on Over Book");
					Wait.explicit_wait_xpath(OR.New_Reservation_Tab);
					Wait.explicit_wait_xpath(OR.New_Reservation_Page_Load);
				}
				else
				{
					//System.out.println("Satisfied Rules");
				}
		     try{
		    	 
		    	 Select sel = new Select(driver.findElement(By.xpath(OR.Get_QuoteReservation_Status)));
		    	 
		    	 WebElement ele=sel.getFirstSelectedOption();
		    
		    	 String str=ele.getText();
		    	//System.out.println(str);
		    	assertTrue(str.equalsIgnoreCase("Quote"));
		    	test.log(LogStatus.PASS, "Reservation status : "+str);
		     }catch(Exception e)
				{
		    	 e.printStackTrace();
					//System.out.println("Reservation status is not Quote");
				}
	}

}
