package com.innroad.inncenter.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.innroad.inncenter.interfaces.IRateQuote;
import com.innroad.inncenter.properties.OR;
import com.innroad.inncenter.waits.Wait;
import com.innroad.inncenter.webelements.Elements_RateQuote;

public class RateQuote implements IRateQuote {

	public static Logger rateQuoteLogger=Logger.getLogger("RateQuote");
	
	public void searchDetails(WebDriver driver, String RateQuoteNights,
			String RateQuoteAdults, String RateQuoteChildren,
			String RateQuoteRatePlanList, String RateQuotePromoCode) {
		
		Elements_RateQuote RateQuotePage= new Elements_RateQuote(driver);
		
		RateQuotePage.Click_Arrive_DatePicker.click();
		RateQuotePage.Click_Today.click();
		RateQuotePage.Enter_RateQuoteNights.sendKeys(RateQuoteNights);
		RateQuotePage.Enter_RateQuoteAdults.sendKeys(RateQuoteAdults);
		RateQuotePage.Enter_RateQuoteChildren.sendKeys(RateQuoteChildren);
		new Select (RateQuotePage.Select_RateQuoteRatePlanList).selectByVisibleText(RateQuoteRatePlanList);
		RateQuotePage.Enter_RateQuotePromoCode.sendKeys(RateQuotePromoCode);
		
		rateQuoteLogger.info("Entered inputs for RateQuote Search fields");		
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

}
